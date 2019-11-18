Spring WEB homework

1. Transform existing project into web application, configure dispatcher servlet. (1 point)

2. Implement annotation-based controllers that will delegate to BookingFacade methods. For methods, that accept Entity, just send the list of parameters from the client and assemble the entity in controller, no need in automatic conversion of request payload to java object. (2 points)

3. For methods, that should return single entity or entity list result (e.g. getUsersByName), implement simple thymeleaf templates for displaying results. No sophisticated markup required, just the fact that you know how to implement the chain ModelAndView->resolver->ThymeleafTemplate->Html page in the browser. (2 points)

4. For the following facade method:

List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);

implement alternative controller, which will be mapped on header value "accept=application/pdf" and return PDF version of booked tickets list. (2 points)

5. Implement custom HandlerExceptionResolver, which in case of controller exception just send simple text response to the client with brief description of the error. (1 point)

6. Unit tests, logging, javadocs. (1 point)

7. Implement tests for Booking service controllers using MockMVC framework. (1 point)

Extra task:

Modify the method implemented in HW2 "Implement batch creation of ticket bookings from XML file". Make facade method accept some input stream, MVC controller for this method should handle multipart file upload and pass the file byte stream to the facade method.