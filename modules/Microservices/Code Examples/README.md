Rules:
Direct calls to service are prohibited. You can call services via API-Gateway only

Examples:
 http://localhost:8765/one/property/intproperty
 http://localhost:8765/one/property/name
 http://localhost:8765/one/callService/1
 http://localhost:8765/one/callService2/2
 http://localhost:8765/two/getSomething1/1
 http://localhost:8765/two/getSomething2/1

Run a service from command Line:
 mvn spring-boot:run

Eureka: http://localhost:8761/
Zuul: http://localhost:8765/info
One: http://localhost:8765/one/info
Two: http://localhost:8765/two/info