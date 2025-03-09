# MICROMETER

Vendor-neutral application observability facade.Micrometer provides a facade for the most popular observability systems,allowing you to instrument your JVM-based application code without vendor lock-in.It supports several monitoring systems:-Netflix Atlas,AWS CloudWatch,Datadog,InfluxData,SignalFX,Graphite,Wavefront,Prometheus.

Features:

1. Integrated into Frameworks:- Popular frameworks integrate with Micrometer include Helidon,Micronaut,Quarkus and Spring.
2. Instrumentation provided:- You do not need to write your own instrumentation for many components.
3. Environment:- Micrometer can directly publish to most backends for storing your observability data.
4. Dimensional Metrics:- Vendor-neutral abstractions for timers, gauges, counters, distribution summaries, and long task timers are provided with a dimensional data model. You can publish to a backend that supports dimensional metrics for efficient access to named metrics where you can drill down across its dimensions.
5. Distributed Tracing:- Micrometer Tracing is a facade over the Brave and OpenTelemetry tracers that gives insight into complex distributed systems at the level of an individual user request. Identify the root cause of issues faster with distributed tracing. Micrometer Tracing is the successor to the Spring Cloud Sleuth project.
6. Unified Observability:- You can instrument with the Micrometer Observation API, a single abstraction that can produce metrics, tracing, logs and more. You can instrument once, get multiple benefits, and keep metadata consistent across your observability data.

- `Installing`:- Micrometer contains a core library with the instrumentation SPI and an in-memory implementation that does not export data anywhere, a series of modules with implementations for various monitoring systems, and a test module.

If you use a framework, it might have dependency management that defines Micrometer versions or imports the Micrometer BOM. You can defer to the framework’s dependency management instead of declaring the Micrometer BOM directly in that case.
