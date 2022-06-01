This document contains homework tasks for `NoSQL`.

**Note**: all task should be implemented with newest versions of Mongo (`>= 4.0`) and Cassandra (`>= 3.11.3`).



Task 1 - Backend Database Migration
===================================

**Cost**: 1 point.

Move one of your pet application/mentoring projects with DAO and simple CRUD to MongoDB.

Install MongoDB and use corresponding Java driver.

* Define data model for Mongo (the direct table-collection mapping is not the best idea).
* Write data migration job (via SQL and MongoDriver operations).
* Use aggregation mechanism to get grouped results from the database.
* (Optional, +5 bonus points) Run this job in one transaction for SQL database and in one multi-document transaction for Mongo.
* (Optional, +5 bonus points) Use appropriate indices to improve query performance.
* (Optional, +10 bonus points) Make a replica-set with 1 primary and 2 secondary nodes, execute your tests/client code over the Mongo cluster.



Task 2 - Task Manager with Mongo DB
===================================

**Cost**: 2 points.

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



Task 3 - the Cassandra Ring
===========================

**Cost**: 2 points.

1. Install Cassandra and use corresponding Java driver.
2. Build Cassandra cluster with 4 nodes.
3. Balance the cluster and distribute keys.
4. Provides screenshots of running cluster and filled tables.
5. Write performance test app which stores logs (logs can be tracked events with different structure) from your working app into Cassandra Cluster.
6. Measure different useful statistics for log writing (throughput - avg, 95th percentile and so on).
7. Provide simple admin operations (to edit logs) via Cassandra Java driver.
8. Use CQL to make queries for generating reports.
9. List of desired reports and collected metrics should be provided by your mentor.



Task 4 (Optional)- Social Network with Mongo
==================================

**Cost**: 1 point.

Write simple app with a few classes reflected typical Social Network (Users, Messages, Movies, Audio tracks, Friendships etc.).
Keep more than `10^9` instances for each class into Mongo database using Mongo DB driver.

Provide simple reporting based on Mongo Aggregation Framework:
1. Average number of messages by day of week.
2. Max number of new friendships from month to month.
3. Min number of watched movies by users with more than `100` friends.

Play with different data models, do not fear to experiment with denormalization.

Optionally (+5 bonus points) use appropriate indices to improve query performance.

Optionally (+10 bonus points) make a replica-set with 1 primary and 2 secondary nodes, execute your tests/client code over the Mongo cluster.



Task 5 (Optional) - Social Network with Cassandra
======================================

**Cost**: 1 point.

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