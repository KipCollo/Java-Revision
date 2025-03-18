# Reactive

Reactive systems have certain characteristics that make them ideal for low-latency, high-throughput workloads. Project Reactor and the Spring portfolio work together to enable developers to build enterprise-grade reactive systems that are responsive, resilient, elastic, and message-driven.

- `reactive processing`:- Reactive processing is a paradigm that enables developers build non-blocking, asynchronous applications that can handle back-pressure (flow control).
Reactive systems better utilize modern processors. Also, the inclusion of back-pressure in reactive programming ensures better resilience between decoupled components.

- `Project Reactor`:- Project Reactor is a fully non-blocking foundation with back-pressure support included. It’s the foundation of the reactive stack in the Spring ecosystem and is featured in projects such as Spring WebFlux, Spring Data, and Spring Cloud Gateway.

One of the main reasons developers move from blocking to non-blocking code is efficiency. Reactive code does more work with fewer resources. Project Reactor and Spring WebFlux let developers take advantage of multi-core, next-generation processors—handling potentially massive numbers of concurrent connections. With reactive processing, you can satisfy more concurrent users with fewer microservice instances.
