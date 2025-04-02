# Microservices Communications

There are two forms of communications in Microservices:

1. Synchronous communications- Includes REST Template and Feign
2. Asynchronous communications- Using message brokers e.g ActiveMQ,Kafka and RabbitMQ

## Spring Cloud OpenFeign

Feign is a declarative web service client. It makes writing web service clients easier. To use Feign create an interface and annotate it. It has pluggable annotation support including Feign annotations and JAX-RS annotations. Feign also supports pluggable encoders and decoders. Spring Cloud adds support for Spring MVC annotations and for using the same HttpMessageConverters used by default in Spring Web. Spring Cloud integrates Eureka, as well as Spring Cloud LoadBalancer to provide a load-balanced http client when using Feign.

To include Feign in your project use the starter with group org.springframework.cloud and artifact id spring-cloud-starter-openfeign.

Declarative REST Client: Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations

```java
@SpringBootApplication
@EnableFeignClients
public class WebApplication {

 public static void main(String[] args) {
  SpringApplication.run(WebApplication.class, args);
 }
}
```

```java
@FeignClient(
    name = "customer",
    url="${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/{customerId}")
    Optional<CustomerResponse> findCustomerById(@PathVariable String customerId);

}
```

In the @FeignClient annotation the String value is an arbitrary client name, which is used to create a Spring Cloud LoadBalancer client. You can also specify a URL using the url attribute (absolute value or just a hostname). The name of the bean in the application context is the fully qualified name of the interface. To specify your own alias value you can use the qualifiers value of the @FeignClient annotation.

The load-balancer client above will want to discover the physical addresses for the "stores" service. If your application is a Eureka client then it will resolve the service in the Eureka service registry. If you don’t want to use Eureka, you can configure a list of servers in your external configuration using SimpleDiscoveryClient.

Spring Cloud OpenFeign supports all the features available for the blocking mode of Spring Cloud LoadBalancer.

To use @EnableFeignClients annotation on @Configuration-annotated-classes, make sure to specify where the clients are located, for example: @EnableFeignClients(basePackages = "com.example.clients") or list them explicitly: @EnableFeignClients(clients = InventoryServiceFeignClient.class).

Placeholders are supported in the name and url attributes.

```java
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface StoreClient {
 //..
}
```

Spring Cloud OpenFeign provides the following beans by default for feign (BeanType beanName: ClassName):

- Decoder feignDecoder: ResponseEntityDecoder (which wraps a SpringDecoder)
- Encoder feignEncoder: SpringEncoder
- Logger feignLogger: Slf4jLogger
- MicrometerObservationCapability micrometerObservationCapability: If feign-micrometer is on the classpath and ObservationRegistry is available
- MicrometerCapability micrometerCapability: If feign-micrometer is on the classpath, MeterRegistry is available and ObservationRegistry is not available
- CachingCapability cachingCapability: If @EnableCaching annotation is used. Can be disabled via spring.cloud.openfeign.cache.enabled.
- Contract feignContract: SpringMvcContract
- Feign.Builder feignBuilder: FeignCircuitBreaker.Builder
- Client feignClient: If Spring Cloud LoadBalancer is on the classpath, FeignBlockingLoadBalancerClient is used. If none of them is on the classpath, the default feign client is used.
