# Spring Cloud Netflix

Spring Cloud Netflix provides Netflix OSS integrations for Spring Boot apps through autoconfiguration and binding to the Spring Environment and other Spring programming model idioms.
Spring Cloud Netflix features:

1. Service Discovery: Eureka instances can be registered and clients can discover the instances using Spring-managed beans
2. Service Discovery: an embedded Eureka server can be created with declarative Java configuration

## Service Discovery: Eureka Clients

Service Discovery is one of the key tenets of a microservice-based architecture. Trying to hand-configure each client or some form of convention can be difficult to do and can be brittle. Eureka is the Netflix Service Discovery Server and Client. The server can be configured and deployed to be highly available, with each server replicating state about the registered services to the others.

To include the Eureka Client in your project, use the starter with a group ID of org.springframework.cloud and an artifact ID of spring-cloud-starter-netflix-eureka-client.

`Registering with Eureka`:- When a client registers with Eureka, it provides meta-data about itself — such as host, port, health indicator URL, home page, and other details. Eureka receives heartbeat messages from each instance belonging to a service. If the heartbeat fails over a configurable timetable, the instance is normally removed from the registry.

By having spring-cloud-starter-netflix-eureka-client on the classpath, your application automatically registers with the Eureka Server. Configuration is required to locate the Eureka server, as shown in the following example:

```java
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}/${server.port}/eureka/
```

NOTE:- The defaultZone property is case sensitive and requires camel case because the serviceUrl property is a Map<String, String>. Therefore, the defaultZone property does not follow the normal Spring Boot snake-case convention of default-zone. 

The default application name (that is, the service ID), virtual host, and non-secure port (taken from the Environment) are ${spring.application.name}, ${spring.application.name} and ${server.port}, respectively.

Having spring-cloud-starter-netflix-eureka-client on the classpath makes the app into both a Eureka “instance” (that is, it registers itself) and a “client” (it can query the registry to locate other services). The instance behaviour is driven by eureka.instance.* configuration keys, but the defaults are fine if you ensure that your application has a value for spring.application.name (this is the default for the Eureka service ID or VIP).

To disable the Eureka Discovery Client, you can set eureka.client.enabled to false. Eureka Discovery Client will also be disabled when spring.cloud.discovery.enabled is set to false

`Authenticating with the Eureka Server`:- HTTP basic authentication is automatically added to your eureka client if one of the eureka.client.serviceUrl.defaultZone URLs has credentials embedded in it (curl style, as follows: user:password@localhost:8761/eureka). For more complex needs, you can create a @Bean of type DiscoveryClientOptionalArgs and inject ClientFilter instances into it, all of which is applied to the calls from the client to the server.

When Eureka server requires client side certificate for authentication, the client side certificate and trust store can be configured via properties, as shown in following example:

```yaml
eureka:
  client:
    tls:
      enabled: true
      key-store: <path-of-key-store>
      key-store-type: PKCS12
      key-store-password: <key-store-password>
      key-password: <key-password>
      trust-store: <path-of-trust-store>
      trust-store-type: PKCS12
      trust-store-password: <trust-store-password>
```

The eureka.client.tls.enabled needs to be true to enable Eureka client side TLS. When eureka.client.tls.trust-store is omitted, a JVM default trust store is used. The default value for eureka.client.tls.key-store-type and eureka.client.tls.trust-store-type is PKCS12. When password properties are omitted, empty password is assumed.

`Eureka’s Health Checks`:- By default, Eureka uses the client heartbeat to determine if a client is up. Unless specified otherwise, the Discovery Client does not propagate the current health check status of the application, per the Spring Boot Actuator. Consequently, after successful registration, Eureka always announces that the application is in 'UP' state. This behavior can be altered by enabling Eureka health checks, which results in propagating application status to Eureka. As a consequence, every other application does not send traffic to applications in states other then 'UP'. The following example shows how to enable health checks for the client:

```java
eureka.client.healthcheck.enabled=tru
```

eureka.client.healthcheck.enabled=true should only be set in application.yml. Setting the value in bootstrap.yml causes undesirable side effects, such as registering in Eureka with an UNKNOWN status.

## Service Discovery: Eureka Server

To include Eureka Server in your project, use the starter with a group ID of org.springframework.cloud and an artifact ID of spring-cloud-starter-netflix-eureka-server.

NOTE:- If your project already uses Thymeleaf as its template engine, the Freemarker templates of the Eureka server may not be loaded correctly. In this case it is necessary to configure the template loader manually:

```yml
spring:
  freemarker:
    template-loader-path: classpath:/templates/
    prefer-file-system-access: false
```

How to Run a Eureka Server

The following example shows a minimal Eureka server:

```java
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
		SpringApplication.run(CustomerServiceTestApplication.class, args);
	}
}
```

The server has a home page with a UI and HTTP API endpoints for the normal Eureka functionality under /eureka/*.

`Standalone Mode` - The combination of the two caches (client and server) and the heartbeats make a standalone Eureka server fairly resilient to failure, as long as there is some sort of monitor or elastic runtime (such as Cloud Foundry) keeping it alive. In standalone mode, you might prefer to switch off the client side behavior so that it does not keep trying and failing to reach its peers. The following example shows how to switch off the client-side behavior:

```yml
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
```
