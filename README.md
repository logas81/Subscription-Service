
# Subscription-Service

Usage
-----
Three microservices have been developed to achieve the goals of the coding challenge. Each one must be started independently (there are no dependencies among them).
To run the project in local, you must do the following in three different terminal windows:

**Start up Subscription service**
```java
$ cd subscription-service
$ mvn spring-boot:run
```
Endpoint should be available at http://localhost:8080

**Start up Email service**
```java
$ cd email-service
$ mvn spring-boot:run
```
Endpoint should be available at http://localhost:8081

**Start up Event service**
```java
$ cd event-service
$ mvn spring-boot:run
```
Endpoint should be available at http://localhost:8082

## Service Interfaces
The following files contain service interfaces defined in Yaml by means of Swagger 2.0 editor (http://editor.swagger.io/#/)
* subscription-service.yaml
* email-service.yaml
* event-service.yaml

## Framework / libraries
This project has been developed using Spring Boot. Its capabilities fit properly for the requirements specified in the coding challenge since it makes easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* org.springframework.boot
    * spring-boot-starter-parent
    Parent pom provides applications built with Maven with dependency and plugin management. 
    * spring-boot-starter-data-rest
    It provides a flexible and configurable mechanism for writing simple services that can be exposed over HTTP.
    * spring-boot-starter-security
   It is a starter for using Spring Security
    * spring-boot-maven-plugin
    It provides Spring Boot with support in Maven. It has been used to package every service in an independent self running jar file.
* org.springframework.security.oauth
OAuth 2.0 is the industry-standard protocol for authorization. It has been used to secure subscription service. Email and event service don't need to be secured since they are in a secure network zone (not exposed to Internet).
    * spring-security-oauth2
* com.h2database
H2 is a relational database management system that can be embedded in Java applications. H2 has been used as an in-memory database for subscription service to store subscriptors data.
    * h2 
    
## Tools used during development
* Swagger
Used to define and document service interfaces.
* Eclipse
Used as development environment (IDE)
* Postman
Used to test services once launched by means of Maven. 
* Dillinger.io (http://dillinger.io/)
Online markdown editor used to create README.md file

## TODO
* Add jUnit tests to subscription-service (email and event service don´t need tests as they are mocked to always return "OK").
* Improve subscription-service by adding spring-cloud capabilities.
* Add support to run the services in Docker.