This document contains homework tasks for `BigData`.

**Note**: all tasks should run on Ubuntu or another Linux OS. If you are a big Windows fan you can try on Windows, but it's pain.



Task 1 - Single-node Hadoop
===========================

**Cost**: 1 point.

1. Download latest Hadoop release and set it up manually.
2. Run Hadoop in Single Node regime.
3. Run [Pi example](https://github.com/apache/hadoop/blob/trunk/hadoop-mapreduce-project/hadoop-mapreduce-examples/src/main/java/org/apache/hadoop/examples/pi/DistBbp.java).
4. Make screenshot/screencast and share it with mentor.



Task 2 - Multi-node Hadoop
==========================

**Cost**: 1 point.

1. Configure cluster with 4 machines with the same Hadoop version.
2. Run Hadoop on 4 machines in Multi-Node regime.
3. Rerun Pi example from the previous task.
4. Make screenshots/screencast of execution process and share it with mentor.



Task 3 (Optional) - Hadoop WordCount with Optimizations
============================================

**Cost**: 2 points.

1. Find your favorite Shakespeare poem and put it into HDFS.
2. Write MapReduce WordCount **\*** program, make JAR and run it via Hadoop (Single Node or cluster, your choice).
3. MR program should:
* filter stop-words (define this list manually);
* change all words to lower case;
* makes pre-reduce optimization;
* have 2 Reducers (one for short words with less than 5 symbols and other one for other words);
* have MR Unit tests for Mapper and Reducer.

**\*** - WordCount is a simple application that counts the number of occurrences of each word in a given input set.

P.S. Look [at this](https://github.com/zaleslaw/Spark-Tutorial/tree/master/Hadoop) if you don't know how to start.



Task 4 (Optional) - Spark WordCount
========================

**Cost**: 2 points.

Write Spark program in Java or Scala for WordCount problem from the previous task.

Provide three solutions via RDD, DataFrames and SparkSQL.

Each solution should:

* read data from the disk;
* cache the data in the Spark memory;
* filter stop-words;
* change all words to lower case;
* print out a calculated result;
* save the calculated result in the file.

**Note**: 10 points for each solution.



Task 5 - Spark and SMS
======================

**Cost**: 1 points.

Find top 5 spam words are not contained in ham messages (use [smsData.txt](smsData.txt)).
Implement your solution via one of approaches (RDD/DataFrames/SparkSQL). Java or Scala as you wish.

+10 bonus points if it will be executed via Apache Zeppelin.



Task 6 - Kafka
==============

**Cost**: 2 points.

1. Install Kafka.
2. Create topic `EPAM Secret Messages`.
3. Distribute it over 3 partitions.
4. Add a Producer that generates and sends 1 message every `100 ms` to the topic.
5. Add a Consumer that reads messages every `500 ms`, aggregates them (as you wish) and writes the result into the database via JDBC connection.
6. Run a few consumers. What has happened in Kafka cluster? Discuss with mentor.
