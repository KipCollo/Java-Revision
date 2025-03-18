# API Gateway

API Gateway built on top of the Spring Ecosystem, including: Spring 5, Spring Boot 2 and Project Reactor.Spring Cloud Gateway aims to provide a simple,yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.

To include Spring Cloud Gateway in your project, use the starter with a group ID of org.springframework.cloud and an artifact ID of spring-cloud-starter-gateway .

* If you include the starter, but you do not want the gateway to be enabled, set spring.cloud.gateway.enabled=false

Spring Cloud Gateway is built on Spring Boot 2.x, Spring WebFlux, and Project Reactor. As a consequence, many of the familiar synchronous libraries (Spring Data and Spring Security, for example) and patterns you know may not apply when you use Spring Cloud Gateway.

Spring Cloud Gateway requires the Netty runtime provided by Spring Boot and Spring Webflux. It does not work in a traditional Servlet Container or when built as a WAR

There are two distinct flavors of Spring Cloud Gateway: Server and Proxy Exchange. Each flavor offers WebFlux and MVC compatibility.

1. The Server variant is a full-featured API gateway that can be standalone or embedded in a Spring Boot application.
2. The Proxy Exchange variant is exclusively for use in annotation based WebFlux or MVC applications and allows the use of a special ProxyExchange object as a parameter to a web handler method.

## Features

Spring Cloud Gateway features:

* Built on Spring Framework 5, Project Reactor and Spring Boot 2.0
* Able to match routes on any request attribute.
* Predicates and filters are specific to routes.
* Hystrix Circuit Breaker integration.
* Spring Cloud DiscoveryClient integration
* Easy to write Predicates and Filters
* Request Rate Limiting
* Path Rewriting

1. Route: The basic building block of the gateway. It is defined by an ID, a destination URI, a collection of predicates, and a collection of filters. A route is matched if the aggregate predicate is true.
2. Predicate: This is a Java 8 Function Predicate. The input type is a Spring Framework ServerWebExchange . This lets you match on anything from the HTTP request, such as headers or parameters.
3. Filter: These are instances of Spring Framework GatewayFilter that have been constructed with a specific factory. Here, you can modify requests and responses before or after sending the downstream request.

## How It Works

Clients make requests to Spring Cloud Gateway. If the Gateway Handler Mapping determines that a request matches a route, it is sent to the Gateway Web Handler. This handler runs the request through a filter chain that is specific to the request. The filters can run logic both before and after the proxy request is sent. All “pre” filter logic is executed. Then the proxy request is made. After the proxy request is made, the “post” filter logic is run.URIs defined in routes without a port get default port values of 80 and 443 for the HTTP and HTTPS URIs, respectively.

* URIs defined in routes without a port get default port values of 80 and 443 for the HTTP and HTTPS URIs, respectively.Any path defined on a route URI will be ignored.

## Routing Handler

Being focused on routing requests, the Spring Cloud Gateway forwards requests to a Gateway Handler Mapping, which determines what should be done with requests matching a specific route.
The Gateway Handler resolves route configurations by using RouteLocator:

```java
@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
                // adding 2 rotes to first microservice as we need to log request body if method is POST
        return builder.routes()
                .route("first-microservice",r -> r.path("/first")
                        .and().method("POST")
                        .and().readBody(Student.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                        .uri("http://localhost:8081"))
                .route("first-microservice",r -> r.path("/first")
                        .and().method("GET").filters(f-> f.filters(authFilter))
                        .uri("http://localhost:8081"))
                .route("second-microservice",r -> r.path("/second")
                        .and().method("POST")
                        .and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
                        .uri("http://localhost:8082"))
                .route("second-microservice",r -> r.path("/second")
                        .and().method("GET").filters(f-> f.filters(authFilter))
                        .uri("http://localhost:8082"))
                .route("auth-server",r -> r.path("/login")
                        .uri("http://localhost:8088"))
                .build();
    }

```java
@SpringBootApplication
public class DemogatewayApplication {
 @Bean
 public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
  return builder.routes()
   .route("path_route", r -> r.path("/get")
    .uri("http://httpbin.org"))
   .route("host_route", r -> r.host("*.myhost.org")
    .uri("http://httpbin.org"))
   .route("rewrite_route", r -> r.host("*.rewrite.org")
    .filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
    .uri("http://httpbin.org"))
   .route("hystrix_route", r -> r.host("*.hystrix.org")
    .filters(f -> f.hystrix(c -> c.setName("slowcmd")))
    .uri("http://httpbin.org"))
   .route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
    .filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
    .uri("http://httpbin.org"))
   .route("limit_route", r -> r
    .host("*.limited.org").and().path("/anything/**")
    .filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
    .uri("http://httpbin.org"))
   .build();
 }
}
```

Notice how we made use of the main building blocks of this API:

1. Route — the primary API of the gateway. It is defined by a given identification (ID), a destination (URI) and set of predicates and filters.
2. Predicate — a Java 8 Predicate — which is used for matching HTTP requests using headers, methods or parameters
3. Filter — a standard Spring WebFilter

## Dynamic routing

Spring Cloud Gateway provides means for routing requests to different services.

The routing configuration can be created by using pure Java (RouteLocator) or by using properties configuration:

```yaml
spring:
  application:
    name: gateway-service  
  cloud:
    gateway:
      routes:
      - id: collo
        uri: collo.com
      - id: myOtherRouting
        uri: localhost:9999
```

Spring Cloud Gateway matches routes using the Spring WebFlux HandlerMapping infrastructure.It also includes many built-in Route Predicate Factories. All these predicates match different attributes of the HTTP request. Multiple Route Predicate Factories can be combined via the logical “and”.
Route matching can be applied both programmatically and via configuration properties file using a different type of Route Predicate Factories.

* `Monitoring`:- Spring Cloud Gateway makes use of the Actuator API, a well-known Spring Boot library that provides several out-of-the-box services for monitoring the application.Once the Actuator API is installed and configured, the gateway monitoring features can be visualized by accessing /gateway/ endpoint.

## Configuring Route Predicate Factories and Gateway Filter Factories

There are two ways to configure predicates and filters:

1. shortcuts
2. fully expanded arguments.

The name and argument names will be listed as code in the first sentence or two of the each section. The arguments are typically listed in the order that would be needed for the shortcut configuration.

* `Shortcut Configuration`:- Shortcut configuration is recognized by the filter name, followed by an equals sign ( = ), followed by argument values separated by commas ( , ).

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: after_route
        uri: https://example.org
        predicates:
        - Cookie=mycookie,mycookievalue
```

The previous sample defines the Cookie Route Predicate Factory with two arguments, the cookie name, mycookie and the value to match mycookievalue.

* `Fully Expanded Arguments`:- Fully expanded arguments appear more like standard yaml configuration with name/value pairs. Typically, there will be a name key and an args key. The args key is a map of key value pairs to configure the predicate or filter.

```yml
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
            regexp: mycookievalue
```

This is the full configuration of the shortcut configuration of the Cookie predicate shown above.

```java
spring.cloud.gateway.routes[0].id=customer-service
spring.cloud.gateway.routes[0].uri= lb:http:8082//CUSTOMER-SERVICE
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/customers/**
```

## GatewayFilter Factories

Route filters allow the modification of the incoming HTTP request or outgoing HTTP response in some manner. Route filters are scoped to a particular route. Spring Cloud Gateway includes many built-in GatewayFilter Factories.

* `AddRequestHeader GatewayFilter Factory`:-The AddRequestHeader GatewayFilter factory takes a name and value parameter. The following example configures an AddRequestHeader GatewayFilter:

```yaml
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_header_route
        uri: https://example.org
        filters:
        - AddRequestHeader=X-Request-red, blue
```

This listing adds X-Request-red:blue header to the downstream request’s headers for all matching requests.

AddRequestHeader is aware of the URI variables used to match a path or host. URI variables may be used in the value and are expanded at runtime. The following example configures an AddRequestHeader GatewayFilter that uses a variable:

```yml
spring:
  cloud:
    gateway:
      routes:
      - id: add_request_header_route
        uri: https://example.org
        predicates:
        - Path=/red/{segment}
        filters:
        - AddRequestHeader=X-Request-Red, Blue-{segment}
```
