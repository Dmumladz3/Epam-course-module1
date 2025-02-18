# Avro demo Spring boot application

This spring boot application demonstrates usages of schema registry. It consists of web
controller, kafka sender and receiver.

The project contains avro schema files:

* [user_v1.avsc](src/main/avro/user_v1.avsc) - original avro schema file.
* [user_v2.avsc_](src/main/avro/user_v2.avsc_) - modified avro schema file (with a property added).
  Both the schemas refer the same ``com.epam.jmp.protocols.avro.example.User`` class so one of them
  needs to be renamed to be ignored by avro generator.

Please follow this sequence of steps:

1. Generate avro schema (see details below).
2. A message can be sent using the ``/kafka/v1/users`` endpoint (see below). The message is
   sent to kafka and the schema is registered at the same time in schema registry. Then, the
   message is received by the Receiver.
3. The app should be stopped and the User class should be re-generated from `user_v2.avsc` file
   (please rename `user_v1.avsc` so it is not visible to generator and does not conflict).
4. Start the app and use the same call. See that avro schema evolves to new version (with User
   class having new property). The property appears in Receiver. Receiver writes a message into
   the application logs every time the message is received.

## How to

### How to generate Java files from schemas

This command line can be used to generate class files. They are put into `build/generated-main-avro-java/` folder.

```shell
./gradlew generateAvroJava
```

Note that schema changes may not be immediately accounted by the code generator, to update existing generated code you
may need to clean the project first with

```shell
./gradlew clean
```

### How to run the program

There are 2 options:

* Using existing remote Kafka service.
* Using local Kafka running in docker containers.

# Running using existing remote Kafka service.

The following environment variables are required to be set up before app run (Windows sample):

```
set KAFKA_HOST=...
set KAFKA_USER=...
set KAFKA_PASSWORD=...
set KAFKA_REGISTRY_HOST=...
set KAFKA_REGISTRY_USER=...
set KAFKA_REGISTRY_PASSWORD=...
```

Default server port is 9000. It can be changed in `application.yml` or with

```
set SERVER_PORT=...
```

This can be run by standard gradle command line:

```
gradlew bootRun
```

And this in case of debug is needed:

```
gradlew bootRun --debug-jvm
```

### How to use a local test instance of Kafka

Prerequisites: Docker, Docker Compose.
See also
[How to run a Kafka broker locally with Docker](https://developer.confluent.io/confluent-tutorials/kafka-on-docker/).

To launch a local Kafka instance execute the following commands

```shell
docker-compose up --detach
```

Depending on the setup the command can be either `docker-compose` or `docker compose`.

To launch the Java application that connects to this Kafka instance execute (Bash syntax):

```shell
export KAFKA_HOST=127.0.0.1:9092  # Kafka broker address.
export KAFKA_REGISTRY_HOST=http://localhost:8085
export SPRING_PROFILES_ACTIVE=none  # Disables authentication.
export SERVER_PORT=9000  # Optional, default is 9000
./gradlew bootRun
```

This can be run by standard gradle command line:

```
./gradlew bootRun
```

In this configuration the schema registry API is published at localhost:8085 (see also the registry
[API reference](https://docs.confluent.io/platform/current/schema-registry/develop/api.html)).
For example, the schema can be inspected with

```shell
curl http://127.0.0.1:8085/schemas/ids/1/schema
```

To inspect or manage topics in this configuration of Kafka one can use `kafka-topics.sh` script. For example

```shell
docker exec broker /opt/kafka/bin/kafka-topics.sh --bootstrap-server=localhost:9092 --topic my-test-topic --describe
```


### How to send requests to the server API

The request can be sent to POST http://localhost:9000/kafka/v1/users endpoint.
For example, with `curl` command (Bash syntax):

```bash
curl -X POST http://localhost:9000/kafka/v1/users --header 'content-type: application/json; charset=UTF-8'  --data '{
	"name" : "John",
	"id" : 1,
	"favoriteColor" : "blue",
	"regretColor" : "red"
}'
```
