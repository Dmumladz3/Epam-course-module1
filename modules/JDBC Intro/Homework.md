This document contains homework tasks for `JDBC Advanced Techniques (+ Spring JDBC)`.


Task 1 - JDBC-based Social Network
========================================

**Cost**: 40 points.

1. Create simple database with tables
    * `Users (id, name, surname, birthdate)`
    * `Friendships (userid1, userid2, timestamp)`
    * `Posts (id, userId, text, timestamp)`
    * `Likes (postid, userid, timestamp)`
2. Populate tables with data which are make sense (`> 1 000 users`, `> 70 000 friendships`, `> 300 000 likes in 2025`) **\***
3. Program should print out all names (only distinct) of users who has more than `100 friends` and `100 likes` in `March 2025`. Implement all actions (table creation, insert data and reading) with JDBC.

**\*** You could prepare dictionaries (maps) in memory (with usernames for example) or data in files to generate data for the populating process.


Task 2 - Database Copy Console Tool
===================================

**Cost**: 30 points.

Create a Database Copy Console Tool that copies the database (URL/Name are command line parameters) step-by-step (table by table).

Required functionality:

1. Copying of tables in lexicographic order.
2. Rows in direct or reverse order (command line parameter).
3. It works for `10 GB` database in minimal time (should tune performance using Java and database performance features).
4. The solution is delivered with a test database (populated with a huge volume of data).

**\*** `10 GB` sample database could be generated via Highload Writing Tool.


Penalties
=========

* `-5` points for the missed subtask;
* `-5` points if table populating algorithm is trivial and ugly (using simple counters without the fantasy flight);
* `-3` points if mentee doesn't use `try-with-resources` if it's possible;
* `-2` points if connection parameters are not stored in property file;
* `-5` points for each task if mentee ignores Java Code Conventions.
