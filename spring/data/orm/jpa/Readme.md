# Spring Data Jpa

Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA-based (Java Persistence API) repositories. It makes it easier to build Spring-powered applications that use data access technologies.

Implementing a data access layer for an application can be quite cumbersome. Too much boilerplate code has to be written to execute the simplest queries. Add things like pagination, auditing, and other often-needed options, and you end up lost.

Spring Data JPA aims to significantly improve the implementation of data access layers by reducing the effort to the amount that’s actually needed. As a developer you write your repository interfaces using any number of techniques, and Spring will wire it up for you automatically. You can even use custom finders or query by example and Spring will write the query for you!

It uses Hibernate as default JPA provider.

The central interface in the Spring Data repository abstraction is Repository. It takes the domain class to manage as well as the identifier type of the domain class as type arguments. This interface acts primarily as a marker interface to capture the types to work with and to help you to discover interfaces that extend this one.

Spring Data JPA is not JPA provider.It simply hides the Java Persistence API(abd the JPA provider) behind its repository abstraction

Application Properties:- Spring Data JPA is an abstracton layer on top of JPA to reduce the amount of boilerplate code required to implement data eccess object(DAO)
