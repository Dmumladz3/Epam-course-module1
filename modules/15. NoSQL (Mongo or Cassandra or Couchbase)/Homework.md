This document contains homework tasks for `NoSQL`.

**Note**: all task should be implemented with newest versions of Mongo (`>= 4.0`) and Cassandra (`>= 3.11.3`).



Task 1 - Backend Database Migration
===================================

**Cost**: 2 points.

Move one of your pet application/mentoring projects with DAO and simple CRUD to MongoDB.
In case that you have not such projects in your program you can use project that attached (ticket-booking_data.rar)

Install MongoDB and use corresponding Java driver.

* Define data model for Mongo (the direct table-collection mapping is not the best idea).
* Write data migration job (via SQL and MongoDriver operations).
* Use aggregation mechanism to get grouped results from the database.
* (Optional, +5 bonus points) Run this job in one transaction for SQL database and in one multi-document transaction for Mongo.
* (Optional, +5 bonus points) Use appropriate indices to improve query performance.
* (Optional, +10 bonus points) Make a replica-set with 1 primary and 2 secondary nodes, execute your tests/client code over the Mongo cluster.

Task 2 - Choose the database and perform tasks
===================================

Mongo DB
===================================

Install MongoDB and use corresponding Java driver.

Create simple task manager console app. Your tasks should have next fields:
* date of creation;
* deadline;
* name;
* description;
* list of subtasks with simple structure (name/description);
* category.

Provide next operation:

1. Display on console all tasks.
2. Display overdue tasks.
3. Display all tasks with the specific category (query parameter).
4. Display all subtasks related to tasks with the specific category (query parameter).
5. Perform insert/update/delete of the task.
6. Perform insert/update/delete all subtasks of the given task (query parameter).
7. Support full-text search by word in task description.
8. Support full-text search by sub-task name.

For highest mark, you can try implement DAO with any ORM solution for Mongo (+10 bonus points).

Social Network with Mongo (Optional)
==================================

Write simple app with a few classes reflected typical Social Network (Users, Messages, Movies, Audio tracks, Friendships etc.).
Keep more than `10^9` instances for each class into Mongo database using Mongo DB driver.

Provide simple reporting based on Mongo Aggregation Framework:
1. Average number of messages by day of week.
2. Max number of new friendships from month to month.
3. Min number of watched movies by users with more than `100` friends.

Play with different data models, do not fear to experiment with denormalization.

Optionally (+5 bonus points) use appropriate indices to improve query performance.

Optionally (+10 bonus points) make a replica-set with 1 primary and 2 secondary nodes, execute your tests/client code over the Mongo cluster.


The Cassandra Ring
===========================

1. Install Cassandra and use corresponding Java driver.
2. Build Cassandra cluster with 4 nodes.
3. Balance the cluster and distribute keys.
4. Provides screenshots of running cluster and filled tables.
5. Write performance test app which stores logs (logs can be tracked events with different structure) from your working app into Cassandra Cluster.
6. Measure different useful statistics for log writing (throughput - avg, 95th percentile and so on).
7. Provide simple admin operations (to edit logs) via Cassandra Java driver.
8. Use CQL to make queries for generating reports.
9. List of desired reports and collected metrics should be provided by your mentor.

Social Network with Cassandra (Optional)
======================================

Take the model and data from the previous task and implement backend with Cassandra (build separate tables for each kind of report).
Could we use Spring solution to reduce copy-paste and light-switching of NoSQL database from Mongo to Cassandra?

Discuss with mentor, what solution is better for this data-case?

Optional sub-tasks:
* (+5 bonus points) use appropriate indices to improve query performance;
* (+5 bonus points) build Cassandra cluster with 4 nodes;
* (+5 bonus points) balance the cluster and distribute keys;
* (+5 bonus points) tune commitlog/memtable properties to reach better performance of your insert or select operations;
* (+5 bonus points) measure performance of query execution and prepare simple performance report.

Read [this](http://cassandra.apache.org/doc/latest/configuration/cassandra_config_file.html) to configure Cassandara.

Couchbase
======================================
### Prerequisites
1. Install Couchbase: https://docs.couchbase.com/server/current/install/install-intro.html
2. Java version 8+
3. Maven
4. Java IDE

### Task 1 - Connect Spring Boot with Couchbase and create first document (1 point)
1. Create spring-boot maven project with at least following dependencies:
```
spring-boot-starter-data-couchbase
spring-boot-starter-web
```
2. Create Java Representation of User with fields:
```json
{
   "id": "9e9a5147-8ebb-4344-a55a-b845aa6e2697",
   "email": "john_doe@epam.com",
   "fullName": "John Doe",
   "birthDate": "1990-10-10",
   "gender": "MALE"
}
```
3. Create repository for User with ability to
    * create new user
    * find user by Id
4. Implement service layer
5. Implement API layer with following REST endpoints:
    * ```GET /api/v1/user/{id}``` - to get user by id
    * ```POST /api/v1/user``` - to create user
6. Create new user via API method call
7. Verify that created user accessible via API method call

### Task 2 - Create index for searching by field (1 point)
1. Navigate to Couchbase Web Console, to Query tab and execute query to
   create an index for email field.
2. Add method to User repository and service with ability to retrieve user by email
3. Add the following API endpoint:
    * ```GET /api/v1/user/email/{email}``` - to get user by email
4. Verify that user available by email via API method call (do not forget about index)

### Task 3 - Embedded objects (1 point)
1. Create Java Representation of Sport with fields:
```json
{
   "id": "9e9a5147-8ebb-4344-a55a-b845aa6e2697",
   "sportName": "Tennis",
   "sportProficiency": "ADVANCED"
}
```
2. Add Sports to User model
3. Create method in UserService with ability to add sport to user
4. Implement API endpoint to update user with new sport
    * ```PUT /api/v1/user/{id}/sport```
5. Verify that couchbase document updated after API method call

### Task 4 - Search by embedded object fields (1 point)
1. Create method in UserService with ability to search users by sport's name
2. Add method for UserRepository with custom query to retrieve users by sport's name
3. Do not forget to create index in couchbase
4. Implement API endpoint to retrieve users by sport's name:
    * ```GET  /api/v1/user/sport/{sportName}```
5. Verify that some users returned after method call


### Task 5* - Perform full-text search (1 point)
1. Create search index via Couchbase Web Console
2. Perform search request via Couchbase Web Console and make sure that you are able to see some
   results
3. Create Repository for searching user by query
4. Implement service layer to return users by search query
5. Create SearchApi with API method:
    * ```GET /api/v1/search/user?q=``` - to search users by query
6. Verify that some users returned after method call     

