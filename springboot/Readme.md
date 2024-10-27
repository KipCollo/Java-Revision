# Spring boot

Spring Boot makes it easy to create stand-alone, production-grade Spring-based Applications that you can run. We take an
opinionated view of the Spring platform and third-party libraries, so that you can get started with minimum fuss. Most Spring
Boot applications need very little Spring configuration.

Our primary goals are:
- Provide a radically faster and widely accessible getting-started experience for all Spring development.
- Be opinionated out of the box but get out of the way quickly as requirements start to diverge from the defaults.
- Provide a range of non-functional features that are common to large classes of projects (such as embedded servers,
security, metrics, health checks, and externalized configuration).
- Absolutely no code generation and no requirement for XML configuration.

Spring boot came to make Spring dev easier:

To make Spring web app:
1. Create a maven project
2. Add dependencies to pom.xml(spring core,MVC,jackson,validator)
3. Configure required beans in configuration using xml or java-config(DispatcherServlet,Viewresolver,Controller)
4. Write web.xml
5. Write conntroller class
6. configure annotations e,g(@requestBody)

Spring Drawbacks:
* Step 1-4 is boilerplate code(i.e common code for all project)
* Dependency management was too hard 
* Manual configurations(complex,time consuming)
* Many configurations-More configurations less code.
* Doesn't support non-functional requirements by default(i.e Healthy checks,metrics,logs,monitoring)