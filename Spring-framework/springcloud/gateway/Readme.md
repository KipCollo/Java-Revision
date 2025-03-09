# API Gateway

API Gateway built on top of the Spring Ecosystem, including: Spring 5, Spring Boot 2 and Project Reactor.Spring Cloud Gateway aims to provide a simple,yet e�ective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.

To include Spring Cloud Gateway in your project, use the starter with a group ID of org.springframework.cloud and an artifact ID of spring-cloud-starter-gateway .

* If you include the starter, but you do not want the gateway to be enabled, set spring.cloud.gateway.enabled=false

Spring Cloud Gateway is built on Spring Boot 2.x, Spring WebFlux, and Project Reactor. As a consequence, many of the familiar synchronous libraries (Spring Data and Spring Security, for example) and patterns you know may not apply when you use Spring Cloud Gateway.

Spring Cloud Gateway requires the Netty runtime provided by Spring Boot and Spring Webflux. It does not work in a traditional Servlet Container or when built as a WAR

## Features

1. Route: The basic building block of the gateway. It is de�ned by an ID, a destination URI, a collection of predicates, and a collection of �lters. A route is matched if the aggregate predicate is true.
2. Predicate: This is a Java 8 Function Predicate. The input type is a Spring Framework ServerWebExchange . This lets you match on anything from the HTTP request, such as headers or parameters.
3. Filter: These are instances of Spring Framework GatewayFilter that have been constructed with a speci�c factory. Here, you can modify requests and responses before or after sending the downstream request.

## How It Works

Clients make requests to Spring Cloud Gateway. If the Gateway Handler Mapping determines that a request matches a route, it is sent to the Gateway Web Handler. This handler runs the request through a filter chain that is specific to the request. The filters can run logic both before and after the proxy request is sent. All “pre” filter logic is executed. Then the proxy request is made. After the proxy request is made, the “post” filter logic is run.URIs defined in routes without a port get default port values of 80 and 443 for the HTTP and HTTPS URIs, respectively.

* URIs defined in routes without a port get default port values of 80 and 443 for the HTTP and HTTPS URIs, respectively.

## Configuring Route Predicate Factories and Gateway Filter Factories

There are two ways to configure predicates and filters:

1. shortcuts
2. fully expanded arguments.

The name and argument names will be listed as code in the first sentence or two of the each section. The arguments are typically listed in the order that would be needed for the shortcut con�guration.

### Shortcut Configuration

Shortcut con�guration is recognized by the �lter name, followed by an equals sign ( = ), followed by argument values separated by commas ( , ).

```java
spring.cloud.gateway.routes:
- id: after_route
uri: https://example.org
predicates:
- Cookie=mycookie,mycookievalue
```

The previous sample de�nes the Cookie Route Predicate Factory with two arguments, the cookie name, mycookie and the value to match mycookievalue.

### Fully Expanded Arguments

Fully expanded arguments appear more like standard yaml con�guration with name/value pairs. Typically, there will be a name key and an args key. The args key is a map of key value pairs to con�gure the predicate or �lter.

```java
spring:
cloud:
gateway:
routes:
- id: after_route
uri: https://example.org
predicates:
- name: Cookie
args:
name: mycookie
```

This is the full con�guration of the shortcut con�guration of the Cookie predicate shown above.
