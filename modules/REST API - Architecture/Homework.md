# REST API Architecture Module Practical Task 

##### 1.	Download Java SE Development Kit 8 according to your OS and processor’s architecture.
##### 2.	Install Java Development Kit according to JDK installation instructions (see also PATH and CLASSPATH).
##### 3.	Download Apache Maven 3.6.0 according to your OS and processor’s architecture.
##### 4.	Install Apache Maven according to installation instructions.
##### 5.	Create maven project with 4 modules:
	*	event-service-api
	*	event-service-dto
	*	event-service-impl
	*	event-service-rest
##### 6.	event-service-dto module should contain Event class with following fields:
	*	id;
	*	title;
	*	place;
	*	speaker;
	*	eventType;
	*	dateTime.
##### 7.	event-service-api module should contain EventService interface with following methods:
	*	createEvent(…);
	*	updateEvent(…);
	*	getEvent(…);
	*	deleteEvent();
	*	getAllEvents();
	*	getAllEventsByTitle(…).
##### 8.	event-service-impl module should contain EventServiceImpl which implements EventService interface and responds with list of Events.
      Note: feel free to use any database (filesystem, any db, in memory storage)
##### 9.	event-service-rest module should contain EventServiceController which provides REST API interface according to 2nd or 3rd level of REST API maturity and responds with list of Events.
##### 10.	Document methods in EventServiceController using Swagger 2 annotations.
##### 11.	Implement Application class with @SpringBootApplication annotation and main method.
##### 12.	Create runnable Spring Boot JAR with dependencies using spring-boot-maven-plugin.
##### 13.	Run event-service jar using SpringBoot and Analyse REST API with Swagger UI.
##### 14.	Provide sample requests to EventService, demonstrate it’s work using Swagger UI.

##### Note:
      Implement REST APIs according to all Richardson Maturity Level as additional task.

## References

[Oracle Java SE Development Kit 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Oracle Java Install Instructions](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)

[Java PATH and CLASSPATH](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html)

[Apache Maven](https://maven.apache.org/download.cgi)

[Apache Maven Install Instructions](https://maven.apache.org/install.html)

[Apache Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)

[Apache Maven Jar Plugin](https://maven.apache.org/plugins/maven-jar-plugin/)

[Spring Boot](https://spring.io/projects/spring-boot)

[Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)

[Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)

[Swagger](https://swagger.io/docs/)

[Dependency Injection](https://springframework.guru/dependency-injection-example-using-spring/)