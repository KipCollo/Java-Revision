# Spring Cloud Function

Spring Cloud Function is a project with the following high-level goals:

1. Promote the implementation of business logic via functions.
2. Decouple the development lifecycle of business logic from any specific runtime target so that the same code can run as a web endpoint, a stream processor, or a task.
3. Support a uniform programming model across serverless providers, as well as the ability to run standalone (locally or in a PaaS).
4. Enable Spring Boot features (auto-configuration, dependency injection, metrics) on serverless providers.

It abstracts away all of the transport details and infrastructure, allowing the developer to keep all the familiar tools and processes, and focus firmly on business logic.

## Features

Spring Cloud Function features:

- Choice of programming styles - reactive, imperative or hybrid.
- POJO functions (i.e., if something fits the @FunctionalInterface semantics we’ll treat it as function)
- Transparent type conversion of inputs and outputs.
- Function composition which includes composing imperative functions with reactive.
- REST support to expose functions as HTTP endpoints etc.
- Streaming data (via Apache Kafka, Solace, RabbitMQ and more) to/from functions via Spring Cloud Stream framework.
- Deploying functions packaged as JAR files with an isolated classloader, to support multi-version deployments in a single JVM.
- Packaging functions for deployments, specific to the target platform (e.g., Project Riff, AWS Lambda and more)
- Adapters for AWS Lambda, Microsoft Azure, Apache OpenWhisk and possibly other "serverless" service providers.
- Support for reactive function with multiple inputs and outputs allowing merging, joining and other complex streaming operation to be handled by functions.

```java
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Function<String, String> uppercase() {
    return value -> value.toUpperCase();
  }
}
```
