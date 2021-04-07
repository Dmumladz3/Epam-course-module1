### Prerequisites
1. Install Couchbase: https://docs.couchbase.com/server/current/install/install-intro.html
2. Java version 8+
3. Maven
4. Java IDE

### Task 1 - Connect Spring Boot with Couchbase and create first document
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
   
### Task 2 - Create index for searching by field
1. Navigate to Couchbase Web Console, to Query tab and execute query to
   create an index for email field.
2. Add method to User repository and service with ability to retrieve user by email
3. Add the following API endpoint:
   * ```GET /api/v1/user/email/{email}``` - to get user by email
4. Verify that user available by email via API method call (do not forget about index)

### Task 3 - Embedded objects
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

### Task 4 - Search by embedded object fields
1. Create method in UserService with ability to search users by sport's name
2. Add method for UserRepository with custom query to retrieve users by sport's name
3. Do not forget to create index in couchbase
4. Implement API endpoint to retrieve users by sport's name:
   * ```GET  /api/v1/user/sport/{sportName}```
5. Verify that some users returned after method call    


### Task 5* - Perform full-text search
1. Create search index via Couchbase Web Console
2. Perform search request via Couchbase Web Console and make sure that you are able to see some 
   results
3. Create Repository for searching user by query
4. Implement service layer to return users by search query
5. Create SearchApi with API method:
   * ```GET /api/v1/search/user?q=``` - to search users by query
6. Verify that some users returned after method call     

