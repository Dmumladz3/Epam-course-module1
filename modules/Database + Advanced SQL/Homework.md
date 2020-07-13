1) Using diagram drawing tools, for instance: http://draw.io, https://start.jhipster.tech/jdl-studio, etc., draw a JDL diagram, based on database tables structure, described below:  

users: 

    id; 

    username; 

    first_name (can be null); 

    last_name (can be null); 

    age (can be null); 

    email; 

    create_date (date and time); 

    update_date (date and time). 

events: 

    id; 

    title; 

    date (date and time); 

    create_date (date and time); 

    update_date (date and time). 

tickets: 

    id; 

    event_id; 

    user_id; 

    category (ULTRA, PREMIUM, STANDART); 

    place (sitting place, for instance: 8); 

    cinema_name; 

    cinema_address; 

    cinema_phone (can be more than one item in one record); 

    cinema_facilities (can be more than one item in one record); 

    purchase_date (date and time); 

    create_date(date and time); 

    update_date (date and time). 

(0.5 point) 


2) Implement the database design, according to step 1, with suitable data types, primary keys, foreign keys, constraints and unique indexes, using PostgreSQL. (0.5 points).  


3) Design a new DML function, which is responsible for creation n of dummy records in all tables from step 1, using the plpgsql language. 

For instance: 

populate_tables(number_of_records integer) { 

for i in number_of_records { 

insert into user (…) values (…); 

insert into event (…) values (…); 

insert into ticket (…) values (…); 

} 

} 

Please note that the purchase date field value cannot be less than event date field value. 

(0.5 point) 


4) To be grounded with indexes, investigate different kinds of PostgreSQL indexes and provide a doc as investigation result, which is answering these questions: 

    What kind of index PostgreSQL creates when we use default CREATE INDEX command? 

    What is the use case of each type of index? 

    Provide examples for indexes creating. 

    Pros and cons of using indexes. 

(0.2 points) 


5) Based on the investigation result from step 4, decide what kind/s of index/es will be suitable for tables from step 1 and provide it (be aware that table “users” will be used for searching by username or by email; table “tickets” will be used for searching by event_id and user_id).  

(0.2 points) 


6) Define how to get indexes size in PostgreSQL and check the size of provided indexes, document the result and remove indexes. 

(0.1 points) 


7) Using prepared function in step 3, populate tables with 100_000 of records, measure population time and document it. 

(0.1 points) 


8) To be grounded with EXPLAIN ANALYZE Query Plan, provide queries for the next cases: 

Table “users”: 

    find user by username (exact match). 

    find user by part of email (partial match). 

Table “tickets”: 

    Find record by event_id and user_id. 

    Find record by category in (…). 

 Analyze and document the queries plan. 

(0.5 points) 


9) Add indexes again, check indexes size, document it, prepare queries plan from step 8, compare it with previous result and document it. 

(0.1 points) 


10) Provide normalization for the table “tickets”. 

(0.5 points) 


11) Investigate PostgreSQL view and document kinds of views and its difference. 

(0.1 points) 


12) Provide 2 views with appropriate type for these requirements: 

1.As a data analyst, I want to be able to get the next aggregated information: 

month, category, age, tickets count 

Special notes: Please note that the tablespace is the crucial point. 

2. As a data analyst, I want to be able to get the next statistics, aggregated by categories: 

    Average days difference between ticket purchase date end event date. 

    The most frequent users age. 

    Percentage of each category across all tickets. 

Additional requirements: 

    For category ‘ULTRA’ select only that tickets, which event does not contain special characters. 

    For category ‘PREMIUM’ select tickets, which name contains numbers. 

    For category ‘STANDART’ check that the user age is not 20, 30, 35, 40, 50. 

Special notes: Please note that the query execution cost is the crucial point. 

(1 point) 


13) Add validation on DB level that checks email for appropriate format (abcd@abcd.abcd). 

(0.3 points) 


14) Provide script, which creates a new table “users_tmp” with the structure, equal to “users” table and populate that table with the next clause: age < 50. 

(0.1 points) 


15) Investigate pros and cons triggers and document it. 

(0.1 points) 


16) Add triggers that fill columns “update_date” and “create_date” to current date and time for all tables from step 1. 

(0.2 points)


Other rules: 

    Please, check in your changes into git repository task by task. It will be better to check your result based on such kind of history. 

    Database table/constraint creation – separate file. 

    Data generation and index creation scripts – separate files. 


Result of your task is: 

    DB design in suitable format. 

    Investigation result documents. 

    SQL files that will show your mentor and tutor how you did your homework. 
	

Extra mile 1.  

Implement immutable data trigger.  

Use the table, created in point 13. Add several rows with test data and do not give access to update any information inside it.  

Hint: you can create trigger that will reject any update operation for target table but save new row with updated (merged with original) data into separate table. (1.5 points) 



Extra mile 2. 

Show in tests (java application) transaction isolation phenomena. Describe what kind of phenomena is it and how can you achieve it. (1.5 points) 