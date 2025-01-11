# Spring cloud

Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns.

## Features

1. Distributed/versioned con�guration
2. Service registration and discovery
3. Routing
4. Service-to-service calls
5. Load balancing
6. Circuit Breakers
7. Distributed messaging
8. Short lived microservices (tasks)
9. Consumer-driven and producer-driven contract testing

## Spring cloud and Microservice

Prerequisitives:

1. Java API/Libaries(Rest API's,Spring Boot)
2. Cloud(AWS,Azure)
3. Third party tools(apache,Netflix)

Microservices are distributed,loosely coupled software that carries out small no. of well defined tasks.It is a methodology or architecturial style of buiding software apps.It has provided guidelines,design patterns for building large scale systems.

## Properties

1. Loosely coupled
2. Independently deployable
3. Highly scalable
4. Resilient

To split monolithic to microservice:

* SRP - Single Responsibility Principle
* Bounded context - Spitting basing on business functionality.

Every micro-service should have its database and have backward compatibilty(i.e should maintain versioning).It also should have its own source code control(each micro-service should have its git repo)

1. Developing microservices:Can be developed with: Spring Rest,Spring Boot using Rest Principles
2. Delivering microsevices:

* Netflix: It has adopted microservice architecture and implemented several tools that helps integrate,manage and deploy microservice.
 It includes:

    1. Eureka Server - service discovery
    2. Feign Client -Declarative client api for inter-service communication
    3. Hystrix-circuit breaker for resilience
    4. Ribbon - client side loadbalacer
    5. Zuul -api gateway

* Apache: It includes:

    1. consul
    2. zookeeper
    3. zipkin
    4. camel Rest DSL

* Microservices application uses Rest APIs and Third party tools.Using third party tools is quite complex and has lots of boilerplate code.Spring cloud integrated with the third tools to build spring-based microservice.

Later, Spring framework slowly started developing their own third-party tools rather than depending on Netflix,it includes:

 1. Eureka Server Intergration
 2. Spring cloud config server and config client
 3. Spring cloud breaker(replacing Hystrix)
 4. Spring API gateway(Replacing ZUUL)
 5. Spring load balancer(Replacing Ribbon)
 6. feign client API

 Spring Boot is used to develop microservices and uses features like auto-configuration,embedded servers while spring cloud is used to integrate tools like cloud config server,eureka server,..etc.

 It is recommended that you use release train BOM spring-cloud-dependencies This is a BOM-only version and it just contains dependency management and no plugin declarations or direct references to Spring or Spring Boot. You can Spring Boot parent POM, or use the BOM from Spring Boot( spring-boot-dependencies ) to manage Spring Boot versions.

 You can't put more than one parent tag in pom.xml

 ```xml
  <dependencyManagement>
  <dependencies>
   <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>${spring-cloud.version}</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
  </dependencies>
 </dependencyManagement>
```

```groovy
plugins {
id 'java'
id 'org.springframework.boot' version '3.3.0'
id 'io.spring.dependency-management' version '1.1.4'
}
repositories {
mavenCentral()
}
ext {
set('springCloudVersion', "2023.0.2")
}
dependencyManagement {
imports {
mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
}
}
```

* Spring cloud is supported with spring boot.

## Spring Boot Microservices Design Patterns

* API Gateway pattern: API Gateway simplifies client's interaction with system by providing a single endpoint for various services.Spring Boot seamlessly intergrates with Spring Cloud Gateway,making it easy to implement the pattern
* Circuit Breaker Pattern: It prevents a network or service failure from cascading to other services.If a service fais to respond,the circuit breaker trips and the call is redirected or fails gracefully.Used with Spring Boot bcoz:
  1. Resilience4j Integration: Spring boot's comatibility with Resilience4j provides robust circuit breaker functionality ensuring system reslience.
  2. Better System Stability: It enhances system stablity and prevents failures from affecting other areas
* Service Registry and Discovery Pattern: This pattern allows services to find and communicate with each other without hard-coding hostnames and ports.Used with spring Boot coz:
    1. Eureka Integration: Spring Boot works well with Eureka Server for service registration and discovery,facilitating dynamic service scaling and load balancing.
    2. Dynamic Service Discovery: It supports dynamic discovery of service instances,which is vital for elastic scaling and fault tolerance.
* The Config Server Pattern: It is a centralized configuration server where all microservices can fetch their configurations.
* Event-Driven Architecture(EDA) Pattern: The pattern involves producing and consuming events synchronously,facilitating decoupled microservices.Used with Spring Boot coz:
    1. Asynchronous Communication: Enables loosely coupled microservices to interact through asynchronous messaging
    2. Integration with Messaging Systems: Spring Boot provides excellent suport for integrating with messaging systems e.g Kafka & RabbitMQ
* Saga Pattern: A Saga is a sequence of local transactions where each transaction updates data within a single service.If one transaction fails,saga ensures that overall business transaction is rolled back through compensatory transactions.It can be implemented using event-driven communication where each service listens for events from other services to execute local transactions.
* Command Query Responsibility Segragation(CQRS): It is a design pattern that separates read(query) and write(command) operations into different models.This can involve using distinct methods,objects, or even separate databases for handling data retrieval and data modification operations.Used with Spring Boot bcoz:
    1. Performance Optimization: By separating reads and writes,CQRS allows independent scaling and optimization of each operation,enhancing performance.
    2. Simplified Complex Models: It simplifies design in complex systems by separating the update logic from the query logic,leading to clearer and more maintainable code.
    3. Spring Ecosystem Integration: Spring Boot,with tools like Spring Data, supports CQRS by enabling different handling for read and write operations,which can be integrated with event-driven systems  commonly used in microservice.
* BulkHead Pattern; Is a design pattern inspired by partition of ships into watertight compartments(bulkheads).In software,it nvloves partitioning an application into isolated cmpartments to prevent failures in one part from cscading to others.Each "bulkhead
or compartment is independent,ensuring that issues in one area don't impact entire application.Used with Spring Boot bcoz:
    1. Improved Resilience: By isolating different parts of application(like services,data sources or even code within a service),the BulkHead pattern helps contain failures,ensuring that a problem in one area doesn't bring down entire system.
    2. Resource Allocation: It allows for fine-grained control over resources such as threads and memory
    3. Concurrency and Load Management: In micoservices environment, bulkheads can be used to manage the load on diff services or components.If one service is heavily loaded,it won't impact performance of others.
    4. Integration with sring Framework: Spring Boot's integration with frameworks like Hystrix and Resilience4j supports the BulkHead pattern.These frameworks provide tools implementing bulkheads in the form of thread pools or semaphores,which can be configured to isolate parts of an application.
