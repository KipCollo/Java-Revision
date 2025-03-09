# Spring, Spring Boot, Spring cloud Annotations

## Core Annotations

1. @SpringBootApplication:- Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan:- Entry point for Spring Boot applications.
2. @Configuration- Marks a class as a source of bean definitions for the application context.
3. @Bean - Indicates a method produces a bean managed by the Spring container.
4. @Component - Marks a class as a Spring-managed component (generic stereotype for any Spring-managed bean).
5. @Service - Specialization of @Component for service-layer classes.
6. @Repository - Specialization of @Component for persistence-layer classes. Automatically translates exceptions into Spring’s data access exceptions.
7. @Controller - Indicates that a class handles web requests (used in MVC).
8. @RestController - Combines @Controller and @ResponseBody. Used to handle REST APIs.

## Dependency Injection Annotations

1. @Autowired - Automatically injects a bean by type into the field, constructor, or method.
2. @Qualifier - Specifies the bean to inject when multiple candidates are available, used with @Autowired.
3. @Primary - Marks a bean as the primary candidate when multiple beans of the same type are available for injection.
4. @Value - Injects values from property files or environment variables into fields, methods, or constructors.
5. @Scope - Specifies the scope of a bean (singleton, prototype, request, session, etc.).

## Web and HTTP Annotations

1. @RequestMapping - Maps HTTP requests to handler methods or classes, supporting all HTTP methods.
2. @GetMapping - Shortcut for HTTP GET requests.
3. @PostMapping - Shortcut for HTTP POST requests.
4. @PutMapping - Shortcut for HTTP PUT requests.
5. @DeleteMapping - Shortcut for HTTP DELETE requests.
6. @PatchMapping - Shortcut for HTTP PATCH requests.
7. @RequestBody - Binds the HTTP request body to a method parameter, allowing automatic deserialization.
8. @RequestParam - Extracts query parameters from the request URL and binds them to method parameters.
9. @RequestHeader - Binds a request header to a method parameter in the controller.
10. @PathVariable - Extracts values from the URL path and binds them to method parameters.
11. @ResponseBody - Indicates that the return value of a method should be written directly to the HTTP response body.
12. @ModelAttribute - Binds request parameters to a model object, allowing for easier population of form objects.
13. @SessionAttributes - Specifies model attributes that should be stored in the session.
14. @InitBinder - Allows customizing the binding of web request parameters to method arguments, typically used for custom property editors.
15. @CrossOrigin - Configures Cross-Origin Resource Sharing (CORS) for a resource or endpoint, enabling cross-origin requests.
16. @CookieValue - Binds a cookie value to a method parameter in the controller.

## Security Annotations

1. @EnableWebSecurity - Enables Spring Security's web security features for the application.
2. @EnableGlobalMethodSecurity - Enables method-level security annotations like @PreAuthorize and @Secured.
3. @Secured - Marks a method or class to restrict access based on roles or authorities.
4. @PreAuthorize - Provides access control based on expressions, allowing method-level security using SpEL (Spring Expression Language).
5. @PostAuthorize - Allows access control after a method is executed, useful for restricting access based on the method's return value.
6. @RolesAllowed - Restricts access to a method or class based on specified roles.
7. @PreFilter -Filters input parameters before a method is executed. Useful for restricting data based on security attributes.
8. @PostFilter - Filters output parameters after a method is executed. Useful for restricting data based on security attributes.
9. @Authenticated - Indicates that a user must be authenticated to access the annotated method or class.
10. @EnableOAuth2Sso - Enables Single Sign-On (SSO) using OAuth2 for a Spring Boot application, typically with services like Google or Facebook.
11. @EnableResourceServer - Marks the application as a resource server for OAuth2, used for securing REST APIs.
12. @EnableAuthorizationServer - Configures the application as an OAuth2 authorization server, managing tokens and authorization flows.
13. @AuthenticationPrincipal - Binds the currently authenticated principal (usually the user details) to a method parameter.
14. @EnableGlobalAuthentication - Enables global authentication settings, allowing custom authentication logic across the entire application.

## Data Access Annotations

- JPA Annotations

1. @Entity - Marks a class as a JPA entity, mapped to a database table.
2. @Table - Specifies the database table to which an entity is mapped.
3. @Id - Marks a field as the primary key in an entity.
4. @GeneratedValue - Specifies the strategy for generating primary key values.
5. @Column - Maps a field to a specific database column.
6. @OneToOne - Defines a one-to-one relationship between entities.
7. @OneToMany - Defines a one-to-many relationship between entities.
8. @ManyToOne -  Defines a many-to-one relationship between entities.
9. @ManyToMany - Defines a many-to-many relationship between entities.
10. @JoinColumn - Specifies the column to join in a relationship.
11. @JoinTable - Specifies the join table for a many-to-many relationship.
12. @Transactional - Manages transactions in JPA operations.
13. @Query - Defines custom JPQL or SQL queries for repository methods.
14. @NamedQuery - Declares a static, named query at the entity level.
15. @EntityListeners - Specifies listener classes for entity lifecycle events.
16. @Embeddable - Marks a class that can be embedded in another entity.
17. @Embedded - Marks a field as embedded (referring to an @Embeddable type).

- Spring JDBC Annotations

1. @Repository - Indicates that a class is a Spring-managed repository for data access.
2. @Autowired - Injects the required dependencies into Spring beans, including JDBC repositories.

- Spring Data Access Annotations

1. @EnableJpaRepositories - Enables Spring Data JPA repositories.
2. @EnableTransactionManagement - Enables transaction management in Spring applications.

- Spring Data Annotations

1. @QueryParam - Binds query parameters to method arguments.
2. @Param - Binds method parameters in a named query to method arguments.
3. @Transactional(readOnly=true)- Specifies that the transaction is read-only for performance optimization
4. @EnableBatchProcessing - Enables Spring Batch configuration for batch processing jobs.

- Spring MongoDB Annotations

1. @Document - Marks a class as a MongoDB document.
2. @Field - Maps a field in a MongoDB document to a specific field in the class.
3. @Id - Marks the primary key field in MongoDB.

- Spring Redis Annotations

1. @RedisHash - Marks a field to be indexed in Redis.
2. @Id - Marks the primary key for Redis data.
3. @Indexed - Marks a class as a Redis hash.

- Spring Couchbase Annotations

1. @Document - Marks a class as a Couchbase document.
2. @Id - Marks the primary key for Couchbase documents.

- Spring SQL Annotations

1. @NamedNativeQuery - Declares a native SQL query at the entity level.
2. @Query - Defines a custom SQL query for the repository method.

- Spring Transaction Annotations

1. @EnableTransactionManagement - Enables Spring’s declarative transaction management.
2. @Transactional(propagation=Propagation.REQUIRES_NEW) - Begins a new transaction, suspending the current one.
3. @Transactional(isolation=Isolation.SERIALIZABLE) - Sets the isolation level for the transaction.

## Cache Management Annotations

1. @EnableCaching - Enables caching support in a Spring Boot application.
2. @Cacheable - Marks a method to cache its result based on the method parameters.
3. @CachePut - Updates the cache with the result of the method, regardless of whether the method was cached.
4. @CacheEvict - Evicts or removes entries from the cache.
5. @Caching - Combines multiple cache-related annotations on a single method.
6. @CacheConfig - Provides default cache settings at the class level.
7. @Cacheable(value="cacheName",key="#id") - Caches the result of a method with a specified key and cache name.
8. @CacheEvict(allEntries=true) - Evicts all entries from a cache when the method is invoked.
9. @CacheEvict(beforeInvocation=true) - Evicts cache entries before the method invocation.
10. @Cacheable(condition="#param > 5") - Caches the method result only if a condition is met.
11. @CacheEvict(condition="#param ==0") - Evicts cache entries if a condition is met.

## Scheduling Annotations

1. @EnableScheduling - Enables support for scheduled tasks in Spring Boot, typically used to enable cron-based tasks.
2. @Scheduled - Marks a method to be run at fixed intervals or according to a cron expression (e.g.,periodic tasks).
3. @Scheduled(fixedRate) - Schedules a task to run at a fixed rate, measured from the start of the previous task.
4. @Scheduled(fixedDelay) - Schedules a task to run after a fixed delay, measured from the end of the previous task.
5. @Scheduled(cron) - Schedules a task based on a cron expression, allowing complex task schedules

## Scope Annotations

1. @Singleton - Ensures that the annotated bean is a single instance within the Spring container(default scope).
2. @Scope("prototype") - Creates a new instance of the bean every time it is requested from the container.
3. @Scope("request") - The bean is created per HTTP request and is discarded after the request is completed.
4. @Scope("session") - The bean is created per HTTP session and is discarded after the session ends.
5. @Scope("application") - The bean is created once per servlet context (application-wide scope).
6. @Scope("websocket") - The bean is created for each WebSocket session.
7. @Configurable - Marks a class as needing configuration via dependency injection. (Used for IoC container integration)
8. @Scope("refresh") - The bean is re-initialized upon each refresh of the configuration (commonly used with Spring Cloud).
9. @WebSocketScope - Creates a new instance for each WebSocket session, managing the lifecycle based on WebSocket connections.
10. @RequestScope - The bean will be created once per HTTP request. It is similar to @Scope("request"),but it’s more explicit and easier to use in Spring Boot.
11. @SessionScope - The bean will be created once per HTTP session. It is similar to @Scope("session"), but provides a more explicit way to define session-scoped beans.
12. @ApplicationScope - The bean will be created once per ServletContext, effectively making it application-wide. It is equivalent to @Scope("application") but more convenient to use in Spring Boot.
13. @EnableAspectJAutoProxy(proxyTargetClass=false) - Enables Spring AOP for proxy beans. When proxyTargetClass=false, it uses interface-based proxying.
14. @EnableAspectJAutoProxy(proxyTargetClass=true) - Enables Spring AOP for proxy beans. When proxyTargetClass=true, it uses class-based proxying.

## Spring Batch Annotations

1. @EnableBatchProcessing - Enables Spring Batch functionality in the application.
2. @JobScope - Marks a bean as scoped to the lifetime of a Spring Batch job execution.
3. @StepScope - Marks a bean as scoped to the lifetime of a Spring Batch step execution.
4. @Job - Defines a Spring Batch job, typically used on methods to declare a job.
5. @Step - Defines a step in a Spring Batch job.
6. @BeforeStep - Indicates that a method should be executed before a Spring Batch step.
7. @AfterStep - Indicates that a method should be executed after a Spring Batch step.
8. @BeforeJob - Indicates that a method should be executed before a Spring Batch job.
9. @AfterJob - Indicates that a method should be executed after a Spring Batch job.
10. @Partitioner - Marks a class as a partitioner that divides a batch job into smaller chunks.
11. @Tasklet - Defines a tasklet, which is the core unit of work in a Spring Batch step.
12. @ItemReader - Marks a bean as an item reader in a Spring Batch step.
13. @ItemProcessor - Marks a bean as an item processor in a Spring Batch step.
14. @ItemWriter - Marks a bean as an item writer in a Spring Batch step.

## Testing Annotations

1. @SpringBootTest - Used for integration testing with Spring Boot, sets up the application context and runs tests within it.
2. @WebMvcTest - Used for testing Spring MVC controllers, focusing on web layer testing by mocking the service layer.
3. @DataJpaTest - Used for testing JPA repositories, loads only the JPA context (database-related beans) for unit tests.
4. @MockBean - Mocks a bean in the application context to test components in isolation(usually used with @SpringBootTest).
5. @Mock - Creates a mock of the specified class or interface (commonly used with Mockito).
6. @InjectMocks - Injects mocks into the annotated field, usually used for testing service or component classes.
7. @Test - Marks a method as a test method in JUnit 5 (used to define a unit test).
8. @BeforeEach - Marks a method to be executed before each test method in JUnit 5 (similar to @Before in JUnit 4).
9. @AfterEach - Marks a method to be executed after each test method in JUnit 5 (similar to @After in JUnit 4).
10. @BeforeAll - Marks a method to be executed before all test methods in JUnit 5 (similar to @BeforeClass in JUnit 4).
11. @AfterAll - Marks a method to be executed after all test methods in JUnit 5 (similar to @AfterClass in JUnit 4).
12. @TestConfiguration - Defines additional configuration for unit tests, useful when creating custom beans for test environments.
13. @SpringBootTest(webEnvironment =WebEnvironment.RANDOM_PORT) - Configures Spring Boot to run tests with an embedded server on a random port.
14. @DirtiesContext - Marks a test class or method to indicate that the application context should be considered dirty after the test.
15. @ExtendWith - Used in JUnit 5 to extend the functionality of test classes, often used with custom extensions.
16. @Value - Injects values into test fields, useful for testing properties or configurations (e.g., environment variables).
17. @TestPropertySource - Specifies the locations of property files to use for the test configuration, overriding the application.properties.
18. @Autowired - Automatically injects dependencies into the test class, ensuring Spring-managed beans are available for testing.
19. @Profile - Activates specific profiles for the test class, ensuring only beans from the active profile are loaded during the test.

## Pagination Annotations

1. @PageableDefaultSpecifies default values for pagination parameters (such as page size and sorting) when a Pageable object is not provided in the method.
2. @Sort - Used with Pageable to define sorting information, allowing pagination results to be ordered based on the provided sort criteria.
3. @Query - Used in Spring Data repositories to define custom queries, often used in conjunction with Pageable to return paginated results.
4. @Pagination - Not a standard Spring Boot annotation, but typically refers to the concept of paginating results in custom implementations using Pageable.
5. Pageable Interface - Not an annotation itself, but it is an interface used in Spring Data repositories and controllers to handle pagination functionality by automatically receiving and passing page parameters.

## Asynchronous Processing Annotations

1. @Async - Marks a method to be executed asynchronously, allowing the method to run in a separate thread.
2. @EnableAsync - Enables support for asynchronous method execution in a Spring application. It needs to be added at the configuration class level.
3. @AsyncResult - Represents the result of an asynchronous method call and can be used to return a value from an asynchronous method.

## Messaging Annotations

1. @EnableRabbit -  Enables Spring AMQP (RabbitMQ) messaging and configures listeners for RabbitMQ message queues.
2. @RabbitListener - Marks a method as a listener for RabbitMQ messages, processing messages from a specific queue.
3. @JmsListener - Marks a method to listen for messages from a JMS (Java Message Service) destination (e.g., ActiveMQ).
4. @EnableJms - Enables JMS messaging in the Spring Boot application, allowing configuration for JMS message consumers.
5. @SendTo - Specifies where to send the return value of a @RabbitListener or @JmsListener method(target queue or topic).
6. @MessagingGateway - Defines a messaging gateway interface, allowing methods to send messages through a message channel.
7. @ServiceActivator- Defines a messaging gateway interface, allowing methods to send messages through a message channel.
8. @MessageEndpoint - Marks a class as a message endpoint, enabling it to handle messages in Spring Integration.
9. @Router - Defines a method for routing messages to appropriate handlers or channels in Spring Integration.
10. @Transformer - Marks a method as a message transformer that processes and modifies the message payload.
11. @EnableRabbit - Enables Spring AMQP (RabbitMQ) messaging and configures listeners for RabbitMQ message queues.
12. @RabbitListener - Marks a method as a listener for RabbitMQ messages, processing messages from a specific queue.
13. @JmsListener - Marks a method to listen for messages from a JMS (Java Message Service) destination (e.g., ActiveMQ).
14. @EnableJms - Enables JMS messaging in the Spring Boot application, allowing configuration for JMS message consumers.

## Logging Annotations

1. @Slf4j - Generates a logger field using SLF4J (Simple Logging Facade for Java) in the annotated class. It is a Lombok annotation.
2. @Log - Generates a logger field using Java’s built-in java.util.logging.Logger in the annotated class. It is a Lombok annotation.
3. @Log4j - Generates a logger field using Log4j in the annotated class. It is a Lombok annotation.
4. @Log4j2 - Generates a logger field using Log4j2 in the annotated class. It is a Lombok annotation.
5. @CommonsLog - Generates a logger field using Apache Commons Logging in the annotated class. It is a Lombok annotation.
6. @XSlf4j - Generates a logger field using XSLF4J (another version of SLF4J) in the annotated class. It is a Lombok annotation.

## Metrics and Monitoring Annotations

1. @Endpoint - Defines a custom endpoint for monitoring and metrics, exposing specific data about the application.
2. @ReadOperation - Marks a method within an @Endpoint as handling read operations, typically used to expose application metrics.
3. @WriteOperation - Marks a method within an @Endpoint as handling write operations, typically used for modifying application state or metrics.
4. @DeleteOperation - Marks a method within an @Endpoint to handle delete operations for metrics or data exposed via custom endpoints.
5. @Metric - A custom annotation used for tracking specific metrics in Spring Boot Actuator, typically used with custom beans or metrics classes.
6. @Timed - Automatically times method executions and tracks the duration as a metric, often used with @Endpoint or service methods.
7. @Counted - Tracks the number of times a method is called, often used for measuring the frequency of specific operations
8. @Gauge - Provides a method to track a dynamic value that can be reported as a gauge metric (e.g., current load).
9. @EnableMetrics - Enables Spring Boot Actuator metrics, making them available for monitoring and export to external systems
10. @HealthIndicator - Customizes application health check endpoints, allowing you to define application-specific health checks.
11. @Timed (method level) - Tracks execution time of a method and exposes the result as a metric, useful for performance monitoring.

## Aspect-Oriented Programming (AOP) Annotations

1. @Aspect - Marks a class as an aspect, where cross-cutting concerns like logging or transaction handling are defined.
2. @Before - Indicates that the annotated method should be executed before the target method is invoked.
3. @After - Indicates that the annotated method should be executed after the target method execution (regardless of success).
4. @AfterReturning - Indicates that the annotated method should be executed after the target method returns successfully.
5. @AfterThrowing - Indicates that the annotated method should be executed if the target method throws an exception.
6. @Around - Allows custom behavior to be executed before and after a method invocation, including the ability to modify the method's result or prevent it.
7. @DeclareParents -Adds new functionality (i.e., method) to an existing class without modifying its code.
8. @EnableAspectJAutoProxy - Enables support for AOP proxy creation and management, allowing the aspects to be woven into the codebase.

## Validation Annotations

1. @NotNull - Ensures that a field cannot be null.
2. @NotEmpty - Ensures that a string, collection, or array is not empty.
3. @NotBlank- Ensures that a string is not null or empty and contains at least one non-whitespace character.
4. @Size - Specifies the allowed size range for strings, collections, or arrays.
5. @Min - Ensures that a numeric value is greater than or equal to a specified minimum.
6. @Max - Ensures that a numeric value is less than or equal to a specified maximum.
7. @Email - Validates that a string is a well-formed email address.
8. @Pattern - Ensures that a string matches a specified regular expression.
9. @Past - Ensures that a date or time is in the past.
10. @Future - Ensures that a date or time is in the future.
11. @AssertTrue -Ensures that a boolean value is true.
12. @AssertFalse - Ensures that a boolean value is false.
13. @Valid - Triggers validation for a field or method parameter. Triggers validation on a nested object (bean).

## Exception Handling Annotations

1. @ExceptionHandler - Handles specific exceptions thrown by controller methods and allows custom handling.
2. @ControllerAdvice - Global exception handler for all controllers, providing centralized exception handling.
3. @RestControllerAdvice - Similar to @ControllerAdvice, but returns the response as JSON or XML for REST APIs.
4. @ResponseStatus - Specifies the HTTP status code to be returned with a response, typically used with exceptions.
5. @ResponseBody - Converts the return value of a controller method into the HTTP response body,typically used for error responses.
6. @Valid / @ValidatedUsed to trigger validation on method parameters or request bodies and automatically handle validation errors.
7. @ExceptionHandler(Method-Level) - Handles exceptions specifically for a method within a controller, making it more localized.
8. @GlobalExceptionHandler - A custom annotation, often used as a naming convention, for handling exceptions globally within a Spring application.

## Fault Tolerance Annotations (Resilience4j)

1. @Retryable - Marks a method to be retried a specified number of times when a failure occurs.
2. @Recover - Defines a method to be called when retry attempts for a @Retryable method are exhausted.
3. @CircuitBreaker - Provides a fault tolerance mechanism that allows a method to fail fast when a threshold of failures is reached.
4. @Fallback - Specifies a fallback method that gets executed when a service call fails or the circuit is open.
5. @Timeout - Specifies a timeout for a method to define when to fail if the method execution takes too long.
6. @RateLimiter - Limits the rate of method invocations to prevent system overload.
7. @Bulkhead - Restricts the number of concurrent calls to a method to avoid overwhelming resources

## Spring Cloud Annotations

1. @EnableDiscoveryClient - Enables service discovery functionality for microservices using Spring Cloud (e.g.,Eureka).
2. @EnableCircuitBreaker - Enables Hystrix circuit breaker functionality to handle failures and fallback logic.
3. @EnableConfigServer - Marks a Spring Boot application as a Spring Cloud Config Server to serve configuration files.
4. @EnableZuulProxy - Enables the Zuul API Gateway to route requests to microservices and apply filters.
5. @EnableEurekaClient - Enables a Spring Boot application to register as a client with Eureka for service discovery.
6. @SpringCloudApplication - A convenience annotation combining several annotations to bootstrap Spring Cloud applications.
7. @HystrixCommand - Marks a method as a Hystrix command, enabling circuit breaker and fallback logic.
8. @EnableFeignClients - Enables Feign client functionality for making REST calls between Spring Cloud microservices.
9. @RibbonClient - Customizes Ribbon load balancing configuration for a specific service client.
10. @StreamListener - Marks a method as a listener for processing messages from Spring Cloud Stream.
11. @EnableHystrixDashboard - Enables the Hystrix Dashboard for monitoring circuit breakers and microservice health.
12. @EnableBatchProcessing - Enables Spring Batch processing in a Spring Cloud application.
13. @EnableDiscoveryClient - Enables service discovery functionality for microservices using Spring Cloud (e.g.,Eureka).
14. @EnableCircuitBreaker - Enables Hystrix circuit breaker functionality to handle failures and fallback logic.
15. @EnableConfigServer - Marks a Spring Boot application as a Spring Cloud Config Server to serve configuration files.
