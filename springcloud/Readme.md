# Spring cloud

Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns

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

* Spring cloud is supported with spring boot.
