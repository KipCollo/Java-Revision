# Microservices Communications

There are two forms of communications in Microservices:

1. Synchronous communications- Includes REST Template and Feign
2. Asynchronous communcations- Using message brokers e.g ActiveMQ,Kafka and RabbitMQ

## Spring Cloud OpenFeign

Feign is a declarative web service client. It makes writing web service clients easier. To use Feign create an interface and annotate it. It has pluggable annotation support including Feign annotations and JAX-RS annotations. Feign also supports pluggable encoders and decoders. Spring Cloud adds support for Spring MVC annotations and for using the same HttpMessageConverters used by default in Spring Web. Spring Cloud integrates Eureka, as well as Spring Cloud LoadBalancer to provide a load-balanced http client when using Feign.
