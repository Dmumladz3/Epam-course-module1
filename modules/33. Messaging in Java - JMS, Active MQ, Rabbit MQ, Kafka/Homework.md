# ActiveMQ

## Prerequisites:

Download and install classic ActiveMQ.


## Practical Task:

I. Implement publish/subscribe interaction between two applications. Check durable vs non-durable subscription.

![image info](./attachments/dur_non_dur.png)

II. Implement request-reply interaction between two applications using a temporary queue in ActiveMQ.

![image info](./attachments/request-reply.png)

III. Implement subscriber scaling, i.e. create n subscribers to a topic with the same ClientID (see Virtual Topics in ActiveMQ)

![image info](./attachments/virtual-topic.png)

## References

1. [ActiveMQ Documentation](https://activemq.apache.org/components/classic/documentation)
2. [Spring: Messaging with JMS](https://www.linkedin.com/learning/spring-messaging-with-jms)



# RabbitMQ

## Prerequisites:

Download and install RabbitMQ.

## Practical Task:
I. Implement a Spring Boot application for sending notifications to customers about the receipt of goods based on the following architecture:

![image info](./attachments/Reliable.png)

### Tips
Dead letter channel/Invalid message channel
![image](./attachments/DLQ_IMQ.png)

## References

1. [RabbitMQ Documentation](https://www.rabbitmq.com/documentation.html)
2. [Spring. Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
3. [Learning RabbitMQ](https://www.linkedin.com/learning/learning-rabbitmq)



# Apache Kafka

## Prerequisites:

Configure a Kafka cluster using Docker with the following parameters:
* Number of brokers - 3
* Number of partitions - 3
* Replication factor - 2
* observe the Kafka broker logs to see how leaders/replicas for every partition are assigned

### Tips
* if you're working on a machine with 16 Gb of RAM or less, you might need to fall back to just 2 brokers
* an example of a Docker Compose for a 2-node cluster based on the official Confluent Kafka image, can be found
  [here](https://www.baeldung.com/ops/kafka-docker-setup#kafka-cluster-setup)

## Practical Task:

I. Implement a pair of `"at least once"` producer and  `"at most once"` consumer.

II. Implement another pair of producer and consumer with exactly-once delivery (use the Transactional API)

III. Implement a taxi application using Spring Boot. The application should consist of three components:
1. REST service fo sending taxi coordinates and car ID.
2. Kafka broker.
3. Three consumers to calculate the distance traveled by a car.

![image](./attachments/kafka-vehicle-monitor.jpg)

### Important
* Messages from every vehicle must be processed `sequentially`!

### Tips
* the first two subtasks may be done as integration tests (for example, using the
  [Embedded Kafka from Spring Boot](https://blog.knoldus.com/testing-spring-embedded-kafka-consumer-and-producer/))

## References

1. [Kafka Introduction](https://kafka.apache.org/intro)
2. [Kafka Quickstart Guide](https://kafka.apache.org/quickstart)
3. [Spring Kafka Introduction](https://docs.spring.io/spring-kafka/reference/html/#introduction)
4. [Learn Apache Kafka for Beginners](https://www.linkedin.com/learning/learn-apache-kafka-for-beginners)








