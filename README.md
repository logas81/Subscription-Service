
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
or
```java
$ cd subscription-service
$ mvn package
$ java -jar target\subscription-service-0.0.1-SNAPSHOT.jar
```
Endpoint should be available at http://localhost:8080/createSubscription

**Start up Email service**
```java
$ cd email-service
$ mvn spring-boot:run
```
or
```java
$ cd email-service
$ mvn package
$ java -jar target\email-service-0.0.1-SNAPSHOT.jar
```
Endpoint should be available at http://localhost:8081/sendConfirmationMail

**Start up Event service**
```java
$ cd event-service
$ mvn spring-boot:run
```
or
```java
$ cd event-service
$ mvn package
$ java -jar target\event-service-0.0.1-SNAPSHOT.jar
```
Endpoint should be available at http://localhost:8082/sendEvent

**Dealing with Oauth2 Security**

We need an auth token in order to invoke subscription service, so to get it:

1)  We have to add an authorization header with client credentials to request headers.

	Username: my-trusted-client
	Password:  secret

2)  We have to invoke /oauth/token context with grant_type = password and adding resource owner credentials in the request params.

	Username: admin1
	Password: abc1234
	
http://localhost:8080/oauth/token?grant_type=password&username=admin1&password=abc1234

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
* Improve service scalability by adding spring-cloud capabilities.
* Add support to run the services in Docker.