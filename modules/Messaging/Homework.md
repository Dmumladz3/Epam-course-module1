# Messaging Module Practical Task 

## Prerequisits: "Event REST" application

1. Create maven project with 4 modules:
    * event-service-api
    * event-service-dto
    * event-service-impl
    * event-service-rest
1. `event-service-dto` module should contain `Event` class with following fields:
    * eventId      : Long
    * title        : String
    * place        : String
    * speaker      : String
    * eventType    : enum (WORKSHOP, TECH_TALK)
    * dateTime     : LocalDateTime
1. `event-service-api` module should contain `EventService` interface with following methods:
    * Event createEvent(Event event);
    * Event updateEvent(Long id, Event event);
    * Event getEvent(Long id);
    * Event deleteEvent(Long id);
    * List<Event> getAllEvents();
1. `event-service-impl` module should contain `EventServiceImpl` which implements `EventService` interface.
   Feel free to use any event storage (filesystem, any db, in memory db, nosql) up to your preference and choice.
1. `event-service-rest` module should contain `EventServiceController` which provides REST API interface according to 2nd or 3rd level of REST API maturity.
1. [Optional] Document methods in `EventServiceController` using Swagger 2 annotations.
1. Implement `Application` class with `@SpringBootApplication` annotation and `main` method.

## Practical Task

Extend "Event REST" application to send messages to three different messaging systems:
1. Kafka
1. RabbitMQ
1. ActiveMQ

1. Add one more interface to `event-service-api`:
    ```Java
    public interface EventMessaging {
        void createEvent(Event event);
        void updateEvent(Event event);
        void deleteEvent(Long id);
    }
   ```
1. Inject optionally (`@Autowired(required = false)`) `EventMessaging` in `EventServiceImpl` and call in
   corresponding methods in `createEvent`, `updateEvent` and `deleteEvent`.
1. While application run with one of messaging systems (Kafka, RabbitMQ of ActiveMQ) we suggest use spring framework profiles.
   Below tasks are based on profiles approach.
    * `kafka`
    * `rabbit`
    * `activemq`
1. EventServiceImpl should use that messaging system specified by active spring framework profile
1. Create one more module `event-messaging`
1. Add dependency in `event-messaging` to `event-service-api`
1. For each messaging system create and use six topics/queues.
    * Three for notification of create, update, delete events from `EventServiceImpl`:
        1. `create-event-notification`
        1. `update-event-notification`
        1. `delete-event-notification`
         ```plantuml
         package "from EventService" {
           component "Swagger UI" as swagger
           component "EventServiceController" as controller
           component "EventService\n    createEvent\n    updateEvent\n    deleteEvent" as service
           component "Messaging System\n    create-event-notification\n    update-event-notification\n    delete-event-notification" as system
           component "Console consumer\n    Kafka CLI\n    Rabbit MQ UI\n    Active MQ UI" as console
         }
         swagger -right-> controller : REST call
         controller -right-> service
         service -right-> system : "produce and\nsend message"
         system -right-> console : "consume\nmessage"
         ```
    * Three for listening from messaging systems and calling corresponding methods in EventService:
        1. `create-event-request`
        1. `update-event-request`
        1. `delete-event-request`
         ```plantuml
         package "to EventService" {
           component "Console producer\n    Kafka CLI\n    Rabbit MQ UI\n    Active MQ UI" as console
           component "Messaging System\n    create-event-request\n    update-event-request\n    delete-event-request" as system
           component "EventConsumer\n    (@Listener)" as consumer
           component "EventService" as service
           component "EventServiceController" as controller
           component "Swagger UI" as swagger
         }
         console -right-> system : "produce\nmessage"
         system -right-> consumer : "@Listener consumes\nmessage"
         consumer -right-> service
         service <.right. controller
         controller <.right. swagger : "REST call\nto check the change"
         ```
1. [Optional] Cover with unit tests all messaging code using unit testing libraries for Kafka, RabbitMQ and JMS.

### Kafka
Follow instruction in [Kafka Quickstart Guide](https://kafka.apache.org/quickstart) to install and execute Kafka

1. Create six above topics in Kafka using the same guide:
    * `kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic create-event-notification`
1. Check that topics were created successfully:
    * `kafka-topics --list --bootstrap-server localhost:9092`
1. Add necessary for Kafka dependencies to `event-messaging/pom.xml`:
    ```xml
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.kafka</groupId>
        <artifactId>spring-kafka-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```
1. Implement `kafka.EventConsumer` and call corresponding methods of `EventService`:
    ```Java
    @Component
    @Profile("kafka")
    public class EventConsumer {
        @KafkaListener
        public void createEvent(List<Event> events)
        @KafkaListener
        public void updateEvent(List<Event> events)
        @KafkaListener
        public void deleteEvent(List<Identifier> eventIds)
    }
    ```
1. Implement `kafka.EventProducer` that is called from `EventServiceImpl` that should send messages to Kafka:
    ```Java
    @Component
    @Profile("kafka")
    public class EventProducer implements EventMessaging
    ```
1. Check that create, update, delete REST operations send messages to Kafka.
1. Create, update, delete events in `Event Service` by sending messages to Kafka.

### Rabbit MQ
Follow instruction in [Downloading and Installing RabbitMQ](https://www.rabbitmq.com/download.html).

Use Rabbit MQ Web Console: http://localhost:15672/

1. Add necessary for Rabbit MQ dependencies to `event-messaging/pom.xml`:
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.amqp</groupId>
        <artifactId>spring-rabbit-test</artifactId>
        <scope>test</scope>
    </dependency>
    ```
1. Implement `rabbit.EventConsumer` and call corresponding methods of `EventService`:
    ```Java
    @Component
    @Profile("rabbit")
    public class EventConsumer {
        @RabbitListener
        public void createEvent(Event event)
        @RabbitListener
        public void updateEvent(Event event)
        @RabbitListener
        public void deleteEvent(Identifier eventId)
    }
    ```
1. Implement `rabbit.EventProducer` that is called from `EventServiceImpl` that should send messages to RabbitMQ:
    ```Java
    @Component
    @Profile("rabbit")
    public class EventProducer implements EventMessaging
    ```
1. Check that create, update, delete REST operations send messages to RabbitMQ.
1. Create, update, delete events in `Event Service` by sending messages to RabbitMQ.

### Active MQ
Follow instruction in https://activemq.apache.org/download.html to download and install ActiveMQ.

Use ActiveMQ Web Console: http://localhost:8161/admin/

1. Add necessary for Active MQ dependencies to `event-messaging/pom.xml`:
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-activemq</artifactId>
    </dependency>
    ```
1. Implement `activemq.EventConsumer` and call corresponding methods of `EventService`:
    ```Java
    @Component
    @Profile("activemq")
    public class EventConsumer {
        @JmsListener
        public void createEvent(Event event)
        @JmsListener
        public void updateEvent(Event event)
        @JmsListener
        public void deleteEvent(Identifier eventId)
    }
    ```
1. Implement `activemq.EventProducer` that is called from `EventServiceImpl` that should send messages to ActiveMQ:
    ```Java
    @Component
    @Profile("activemq")
    public class EventProducer implements EventMessaging
    ```
1. Check that create, update, delete REST operations send messages to ActiveMQ.
1. Create, update, delete events in `Event Service` by sending messages to ActiveMQ.

## References

1. [Kafka Introduction](https://kafka.apache.org/intro)
1. [Kafka Quickstart Guide](https://kafka.apache.org/quickstart)
1. [Spring Kafka Introduction](https://docs.spring.io/spring-kafka/reference/html/#introduction)
1. [Spring Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
1. [ActiveMQ Getting Started](https://activemq.apache.org/getting-started)
1. [ActiveMQ: how to unit test JMS code](https://activemq.apache.org/how-to-unit-test-jms-code)

