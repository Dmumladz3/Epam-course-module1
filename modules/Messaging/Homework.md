# Messaging Module Practical Task 

## Quiz
1. How to implement asynchronous `push` communication in REST?
1. What are differences between _Topic_ and _Queue_ in JMS?
1. What is analog of such _Queue_ in Kafka?

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
    * Three for listening from messaging systems and calling corresponding methods in EventService:
        1. `create-event-request`
        1. `update-event-request`
        1. `delete-event-request`
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

