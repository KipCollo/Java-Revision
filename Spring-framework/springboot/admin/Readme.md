# Spring Boot ADMIN

Spring Boot Admin is a monitoring tool that aims to visualize information provided by Spring Boot Actuators in a nice and accessible way. It consists of two major parts:

1. A server that provides a user interface to display and interact with Spring Boot Actuators.
2. A client that is used to register at the server and allow to access actuator endpoints.

## ADMIN SERVER

Spring Boot Admin Server is capable of running as servlet or webflux application, you need to decide on this and add the according Spring Boot Starter.
Pull in the Spring Boot Admin Server configuration via adding @EnableAdminServer to your configuration:

```java
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }
}
```

## ADMIN CLIENT

Each application that wants to register has to include the Spring Boot Admin Client. In order to secure the endpoints, also add the spring-boot-starter-security.
Enable the SBA Client by configuring the URL of the Spring Boot Admin Server:

```java
spring.boot.admin.client.url=http://localhost:8080  (1)
management.endpoints.web.exposure.include=*  (2)
management.info.env.enabled=true (3)
```

The Spring Boot Admin Client registers the application at the admin server. This is done by periodically doing a HTTP post request to the SBA Server providing information about the application.
There are plenty of properties to influence the way how the SBA Client registers your application. In case that doesn’t fit your needs, you can provide your own ApplicationFactory implementation.

1. spring.boot.admin.client.enabled(true) - Enables the Spring Boot Admin Client.
2. spring.boot.admin.client.url - Comma separated ordered list of URLs of the Spring Boot Admin server to register at. This triggers the AutoConfiguration. Mandatory.
3. 

Instance Metadata:-

user.name,user.password - Credentials being used to access the endpoints.
