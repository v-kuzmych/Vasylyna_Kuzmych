# Homework for Java Lecture #4: Spring : Spring Web (Part 1)

1. Migrate functionality related to core business logic of Servlet-based application to newly created Spring MVC project adapting the old one to the correct package structure, naming conventions, etc.:
    * get rid of all JSP views (now your service will be consuming and populating only JSON text format)
    * make your service RESTful (don't implement HATEOAS logic for now. It will be accomplished in the scope of next lecture)
    * the best approach is to start from the scratch and create an empty Spring Boot project using the 'Spring Initializr'.
    * avoid code copypaste from the old project, unless it relates to the business logic.
2. Create DTO classes and use them at the controller level.
3. Add logging to all layers of the application.