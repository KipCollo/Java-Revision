# Spring Cloud Circuit Breaker

Spring Cloud Circuit breaker provides an abstraction across different circuit breaker implementations. It provides a consistent API to use in your applications allowing you the developer to choose the circuit breaker implementation that best fits your needs for your app.

Supported Implementations

1. Resilience4J
2. Spring Retry

`Starters` - There are two starters for the Resilience4J implementations, one for reactive applications and one for non-reactive applications.

   - org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j - non-reactive applications
   - org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j - reactive applications

You can disable the Resilience4J auto-configuration by setting spring.cloud.circuitbreaker.resilience4j.enabled to false