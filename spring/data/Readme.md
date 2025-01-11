# Data Access/Integration

The Data Access/Integration layer consists of the JDBC, ORM, OXM, JMS and Transaction modules.

The JDBC module provides a JDBC-abstraction layer that removes the need to do tedious JDBC coding and parsing of database-vendor specific error codes.

The ORM module provides integration layers for popular object-relational mapping APIs, including JPA, JDO, and Hibernate. Using the ORM package you can use all of these O/R-mapping frameworks in combination with all of the other features Spring offers, such as the simple declarative transaction management feature mentioned previously.

The OXM module provides an abstraction layer that supports Object/XML mapping implementations for JAXB, Castor, XMLBeans, JiBX and XStream.

The Java Messaging Service (JMS) module contains features for producing and consuming messages.

The Transaction module supports programmatic and declarative transaction management for classes that implement special interfaces and for all your POJOs (plain old Java objects).

## Spring Data Annotations

Spring Data provides an abstraction over data storage technologies.Therefore, business logic code can be much more independent of underlying persistence implementation.It also simplifies handling of implementation-dependant details of data storage.

- @Transactional - When we want to configure transactional behaviour of a method

```java
@Transactional
void pay(){
    ---
}
```

If we apply to class level,it works on all methods inside the class.However, we can override its effects by applying it on a specific method.It has many configuration options.

- @NoRepositoryBean -
- @Param - We can pass named parameters to our queries using @Param

```java
@Query("FROM Person p WHERE p.name=:name")
Person findByName(@Param("name") String name);
```

We refer to parameter with the :name syntax

- @Id - It marks a field in a model class as the Primary Key

```java
class Person{
    @Id
    Long id;
}
```

It's implementation-independent,it makes a model class easy to use with multiple data store engines.

- @Transient - Used to mark a field in model class as transient.Hence the data storage engine won't read or write this field's value:

```java
class Person{
    @Transient
    int age;
}
```

Transient is implementation-independent which makes it convenient to use with multiple data stre implementations

- @CreatedBy,LastModifiedBy,@CreatedDate,@LastModifiedDate - We can audit our model classes with these annotatins.Spring automatically populaes the annotated fields with principal who created the object,last modifiedit and date of creation and lst modification.

```java
class Person{
    @CreatedBy
    User creator;
    @LastModifiedBy
    User modifier;
    @CreatedDate
    Date createdAt;
    @LastModifiedDate
    Date modifiedAt;
}
```

## Spring Data JPA Annotations

- @Query -We can provide JPQL implementation for repository method:

```java
@Query("SELECT COUNT(*) FROM Person p")
long getPersonCount();
```

We can use named parameters

```java
@Query("SELECT FROM Person p WHERE p.name =:name")
Person findByName(@Param("name") String name);
```

We can use nativeSQL queries,if we set nativeQuery argument to true.

```java
@Query(value="SELECT AVG(p.age) FROM Person p",nativeQuery=true)
int getAverageAge();
```

- @Procedure - We can easily call repository call stored procedures from repositories.

```java
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name ="count_by_name",
        procedureName ="person.count_by_name",
        parameters =(
            @StoredProcedureParameter(
                mode =ParameterMode.IN,
                name ="name",
                type =String.class),
            @StoredProcedureParameter(
                mode =ParameterMode.OUT,
                name ="count",
                type =Long.class),
        )
    )
})
class Person{}
```

```java
@Procedure(name= "count_by_name")
long getCountByName(@Param("name") String name);
```

- @Lock - We can configure the lock mode when we execute a repository query method:

```java
@Lock(LockModeType.NONE)
@Query("SELECT COUNT(*)) FROM Person p")
long getPersonCount();
```

The available lock modes include: (READ,WRITE,OPTIMISTIC,OPTIMISTIC_FORCE_INCREMENT,PESSIMISTIC_READ,PESSIMISTIC_WRITE,PESSIMISTIC_FORCE_INCREMENT,NONE)

- @Modifying - We can modify data with a repository method with the annotation

```java
@Modifying
@Query("UPDATE Person p SET p.name =:name WHERE p.id= :id")
void changeName(@Param("id") long id, @Param("name") String name);
```

@EnabeJpaRepositories - To use JPA repositories,we have to indicate it to Spring.We can do this with @EnableJpaRepositories.NB: We have to use with @Configuration

```java
@Configuration
@enableJpaRepositories
class PersistenceJPAConfig{}
```

Spring will look for repositories in the sub packages of the configurations class.We can alter this behaviour with basePckages argument.

```java
@Configuration
@enableJpaRepositories(basePackages="com.kipcolo.models")
class PersistenceJPAConfig{}
```

## Spring Data Mongo Annotations

Spring Data makes working with MongoDB much easier.

- @Document - This annotation marks a class domain object that we want to persist. to database.

```java
@Document
class User{}
```

It allows us to choose name of collection we want to use

```java
@Document(collection="user")
class User{}
```

- @Field - We can configure the name of a field we want to use when MongoDB persists the document

```java
@Document(collection="user")
class User{

    @Field
    String emailAddress;
}
```

- @Query - We can provide a finder query on a MongoDB repository method:

```java
@Query("{'name': ?0}")
List<User> findUserByName(String name);
```

- @EnableMongoRepositories - To use Mo ngoDB repositories,we have to indicate it to spring.We can do this with @EnableMongoRepositories

```java
@Configuration
@EnableMongoRepositories
class MongoConfig{}
```

Spring will look for repositories in the sub packages of the configurations class.We can alter this behaviour with basePckages argument.

```java
@Configuration
@EnableMongoRepositories(basePackages ="com.kipcollo.repository")
class MongoConfig{}
```
