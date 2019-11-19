Spring Data Access homework

Based on the codebase created during Hometask 1:

1. Add new entity to the application - UserAccount, it should store the amount of prepaid money user has in the system, which should be used during booking procedure. Add methods for refilling the account to the BookingFacade class. Add DAO and service objects for new entity. Add ticketPrice field to Event entity. (2 points)

2. Create database schema for storing application entities. Provide SQL script with schema creation DDL for DBMS of your choice. (2 points)

3. Update DAO objects so they would store and retrieve application entities from database using Spring JdbcTemplate. Configure JdbcTemplate and DataSource in Spring application context. Implement entity RowMapper objects. (1 point)

4. Update ticket booking methods to check and withdraw money from user account according to the ticketPrice for particular event. Make these methods transactional using Spring declarative transactions management. (1 point)

5. Implement batch creation of ticket bookings from XML file. Source file example:

<tickets>

<ticket user="..." event="..." category="..." place="..."/>

<ticket user="..." event="..." category="..." place="..."/>

<ticket user="..." event="..." category="..." place="..."/>

</tickets>

Add a method to facade that will load this file from some predefined place (or from a location specified in parameter), unmarshal ticket objects using Spring OXM capabilities and update the database. The whole batch should be performed in a single transaction, using programmatic transaction management. (2 points)

6. Cover code with unit tests. Code should contain proper logging (1 point)

7. Add integration tests for newly implemented scenarios. (1 point)

Extra task (optional, should be done when previous items are complete) (1 point)

Implement implicit user and event lookup for getting booked tickets:

- Create a singleton spring bean that will hold default User and Event objects.

- Create methods in BookingFacade to set default user and default event to the singleton bean.

- Implement custom SqlParameterSource that will during corresponding getBookedTickets method call first check if there's default object set, and if so, use it instead of the one passed as the parameter.

Example:

User user1 = new User(1234);

facade.setDefaultUser(user1);

List<Ticket> tickets = facade.getBookedTickets(new User(5678), 10, 1)

assertEquals(1234, tickets.get(0).getUserId())