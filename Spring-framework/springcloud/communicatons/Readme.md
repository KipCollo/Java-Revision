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

## Spring for Apache Kafka

The Spring for Apache Kafka (spring-kafka) project applies core Spring concepts to the development of Kafka-based messaging solutions. It provides a "template" as a high-level abstraction for sending messages. It also provides support for Message-driven POJOs with @KafkaListener annotations and a "listener container". These libraries promote the use of dependency injection and declarative. In all of these cases, you will see similarities to the JMS support in the Spring Framework and RabbitMQ support in Spring AMQP.

The Spring for Apache Kafka project applies core Spring concepts to the development of Kafka-based messaging solutions. We provide a “template” as a high-level abstraction for sending messages. We also provide support for Message-driven POJOs.

Prerequisites: You must install and run Apache Kafka. Then you must put the Spring for Apache Kafka (spring-kafka) JAR and all of its dependencies on your classpath. The easiest way to do that is to declare a dependency in your build tool.

If you are not using Spring Boot, declare the spring-kafka jar as a dependency in your project.

```xml
<dependency>
  <groupId>org.springframework.kafka</groupId>
  <artifactId>spring-kafka</artifactId>
  <version>3.3.4</version>
</dependency>
```

When using Spring Boot, (and you haven’t used start.spring.io to create your project), omit the version and Boot will automatically bring in the correct version that is compatible with your Boot version.

- `Configuring Topics`:-If you define a KafkaAdmin bean in your application context, it can automatically add topics to the broker. To do so, you can add a NewTopic @Bean for each topic to the application context.TopicBuilder class to make creation of such beans more convenient.

```java
@Bean
public KafkaAdmin admin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    return new KafkaAdmin(configs);
}

@Bean
public NewTopic topic1() {
    return TopicBuilder.name("thing1")
            .partitions(10)
            .replicas(3)
            .compact()
            .build();
}

@Bean
public NewTopic topic2() {
    return TopicBuilder.name("thing2")
            .partitions(10)
            .replicas(3)
            .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
            .build();
}

@Bean
public NewTopic topic3() {
    return TopicBuilder.name("thing3")
            .assignReplicas(0, List.of(0, 1))
            .assignReplicas(1, List.of(1, 2))
            .assignReplicas(2, List.of(2, 0))
            .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
            .build();
}
```

Starting with version 2.6, you can omit partitions() and/or replicas() and the broker defaults will be applied to those properties. The broker version must be at least 2.4.0 to support this feature

```java
@Bean
public NewTopic topic4() {
    return TopicBuilder.name("defaultBoth")
            .build();
}

@Bean
public NewTopic topic5() {
    return TopicBuilder.name("defaultPart")
            .replicas(1)
            .build();
}

@Bean
public NewTopic topic6() {
    return TopicBuilder.name("defaultRepl")
            .partitions(3)
            .build();
}
```

Starting with version 2.7, you can declare multiple NewTopics in a single KafkaAdmin.NewTopics bean definition:

```java
@Bean
public KafkaAdmin.NewTopics topics456() {
    return new NewTopics(
            TopicBuilder.name("defaultBoth")
                .build(),
            TopicBuilder.name("defaultPart")
                .replicas(1)
                .build(),
            TopicBuilder.name("defaultRepl")
                .partitions(3)
                .build());
}
```

When using Spring Boot, a KafkaAdmin bean is automatically registered so you only need the NewTopic (and/or NewTopics) @Beans.

- `Sending Messages`:- Using KafkaTemplate - The KafkaTemplate wraps a producer and provides convenience methods to send data to Kafka topics. The following listing shows the relevant methods from KafkaTemplate

```java
CompletableFuture<SendResult<K, V>> sendDefault(V data);

CompletableFuture<SendResult<K, V>> sendDefault(K key, V data);

CompletableFuture<SendResult<K, V>> sendDefault(Integer partition, K key, V data);

CompletableFuture<SendResult<K, V>> sendDefault(Integer partition, Long timestamp, K key, V data);

CompletableFuture<SendResult<K, V>> send(String topic, V data);

CompletableFuture<SendResult<K, V>> send(String topic, K key, V data);

CompletableFuture<SendResult<K, V>> send(String topic, Integer partition, K key, V data);

CompletableFuture<SendResult<K, V>> send(String topic, Integer partition, Long timestamp, K key, V data);

CompletableFuture<SendResult<K, V>> send(ProducerRecord<K, V> record);

CompletableFuture<SendResult<K, V>> send(Message<?> message);

Map<MetricName, ? extends Metric> metrics();

List<PartitionInfo> partitionsFor(String topic);

<T> T execute(ProducerCallback<K, V, T> callback);

<T> T executeInTransaction(OperationsCallback<K, V, T> callback);

// Flush the producer.
void flush();

interface ProducerCallback<K, V, T> {

    T doInKafka(Producer<K, V> producer);

}

interface OperationsCallback<K, V, T> {

    T doInOperations(KafkaOperations<K, V> operations);

}
```

The sendDefault API requires that a default topic has been provided to the template.

The API takes in a timestamp as a parameter and stores this timestamp in the record. How the user-provided timestamp is stored depends on the timestamp type configured on the Kafka topic. If the topic is configured to use CREATE_TIME, the user-specified timestamp is recorded (or generated if not specified). If the topic is configured to use LOG_APPEND_TIME, the user-specified timestamp ignored and the broker adds in the local broker time.

The metrics and partitionsFor methods delegate to the same methods on the underlying Producer. The execute method provides direct access to the underlying Producer.

To use the template, you can configure a producer factory and provide it in the template’s constructor. The following example shows how to do so:

```java
@Bean
public ProducerFactory<Integer, String> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
}

@Bean
public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return props;
}

@Bean
public KafkaTemplate<Integer, String> kafkaTemplate() {
    return new KafkaTemplate<Integer, String>(producerFactory());
}
```

- `@KafkaListener Annotation`:- The @KafkaListener annotation is used to designate a bean method as a listener for a listener container. The bean is wrapped in a MessagingMessageListenerAdapter configured with various features, such as converters to convert the data, if necessary, to match the method parameters.

You can configure most attributes on the annotation with SpEL by using #{…​} or property placeholders (${…​}).
Record Listeners - The @KafkaListener annotation provides a mechanism for simple POJO listeners.

```java
public class Listener {

    @KafkaListener(id = "foo", topics = "myTopic", clientIdPrefix = "myClientId")
    public void listen(String data) {
        ...
    }
}
```

This mechanism requires an @EnableKafka annotation on one of your @Configuration classes and a listener container factory, which is used to configure the underlying ConcurrentMessageListenerContainer. By default, a bean with name kafkaListenerContainerFactory is expected.
The following example shows how to use ConcurrentMessageListenerContainer:

```java
@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
                        kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        ...
        return props;
    }
}
```
