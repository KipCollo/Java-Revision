# Data Access/Integration

The Data Access/Integration layer consists of the JDBC, ORM, OXM, JMS and Transaction modules.

The JDBC module provides a JDBC-abstraction layer that removes the need to do tedious JDBC coding and parsing of database-vendor specific error codes.

The ORM module provides integration layers for popular object-relational mapping APIs, including JPA, JDO, and Hibernate. Using the ORM package you can use all of these O/R-mapping frameworks in combination with all of the other features Spring offers, such as the simple declarative transaction management feature mentioned previously.

The OXM module provides an abstraction layer that supports Object/XML mapping implementations for JAXB, Castor, XMLBeans, JiBX and XStream.

The Java Messaging Service (JMS) module contains features for producing and consuming messages.

The Transaction module supports programmatic and declarative transaction management for classes that implement special interfaces and for all your POJOs (plain old Java objects).

## Spring Data

Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store.

It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an umbrella project which contains many subprojects that are specific to a given database. The projects are developed by working together with many of the companies and developers that are behind these exciting technologies.
Features

- Powerful repository and custom object-mapping abstractions
- Dynamic query derivation from repository method names
- Implementation domain base classes providing basic properties
- Support for transparent auditing (created, last changed)
- Possibility to integrate custom repository code
- Easy Spring integration via JavaConfig and custom XML namespaces
- Advanced integration with Spring MVC controllers
- Experimental support for cross-store persistence

Main modules

1. Spring Data Commons - Core Spring concepts underpinning every Spring Data module.
2. Spring Data JDBC - Spring Data repository support for JDBC.
3. Spring Data R2DBC - Spring Data repository support for R2DBC.
4. Spring Data JPA - Spring Data repository support for JPA.
5. Spring Data KeyValue - Map based repositories and SPIs to easily build a Spring Data module for key-value stores.
6. Spring Data LDAP - Spring Data repository support for Spring LDAP.
7. Spring Data MongoDB - Spring based, object-document support and repositories for MongoDB.
8. Spring Data Redis - Easy configuration and access to Redis from Spring applications.
9. Spring Data REST - Exports Spring Data repositories as hypermedia-driven RESTful resources.
10. Spring Data for Apache Cassandra - Easy configuration and access to Apache Cassandra or large scale, highly available, data oriented Spring applications.
11. Spring Data for Apache Geode - Easy configuration and access to Apache Geode for highly consistent, low latency, data oriented Spring applications.

Community modules

1. Spring Data Aerospike - Spring Data module for Aerospike.
2. Spring Data ArangoDB - Spring Data module for ArangoDB.
3. Spring Data Couchbase - Spring Data module for Couchbase.
4. Spring Data Azure Cosmos DB - Spring Data module for Microsoft Azure Cosmos DB.
5. Spring Data Cloud Datastore - Spring Data module for Google Datastore.
6. Spring Data Cloud Spanner - Spring Data module for Google Spanner.
7. Spring Data DynamoDB - Spring Data module for DynamoDB.
8. Spring Data Elasticsearch - Spring Data module for Elasticsearch.
9. Spring Data Hazelcast - Provides Spring Data repository support for Hazelcast.
10. Spring Data Jest - Spring Data module for Elasticsearch based on the Jest REST client.
11. Spring Data Neo4j - Spring-based, object-graph support and repositories for Neo4j.
12. Oracle NoSQL Database SDK for Spring Data - Spring Data module for Oracle NoSQL Database and Oracle NoSQL Cloud Service.
13. Spring Data Vault - Vault repositories built on top of Spring Data KeyValue.
14. Spring Data YugabyteDB - Spring Data module for YugabyteDB distributed SQL database.

Spring Data is a high-level abstraction layer over JPA (or other persistence technologies) that simplifies database access in Spring applications.

Key Features:
Repositories: Predefined CRUD operations with minimal boilerplate. Example: JpaRepository, CrudRepository.
Query Methods: Derive queries from method names (findByName, findByAgeGreaterThan).
Integration with other persistence APIs like MongoDB, Cassandra, etc.

Key Components:
JpaRepository: Extends JPA with additional features like pagination and sorting.
Custom Queries: Supports JPQL, native SQL, and @Query annotations.

Use Case: Spring Data eliminates boilerplate code in Spring applications, making it easier to implement complex persistence logic.

spring-context: The core Spring framework that provides dependency injection and context management.
spring-data-jpa: This is the Spring Data project that integrates JPA with Spring, enabling easier data access via repositories.
hibernate-core: Hibernate is the JPA implementation used by Spring Data JPA to manage the ORM (mapping between Java objects and database tables).
mysql-connector-java: The JDBC driver needed to connect Spring to a MySQL database.
spring-orm: Provides integration for ORM frameworks like Hibernate with Spring's transaction management.
dbcp2: Provides a connection pool for efficient handling of database connections.

These dependencies work together to provide an end-to-end solution for managing database operations in a Spring application, from connecting to the database to handling transactions and simplifying data access using JPA.

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

## What is a Repository in Spring Data JPA?

A repository in Spring Data JPA is an abstraction for the data access layer. It provides an easy way to interact with the database using methods for standard CRUD operations (Create, Read, Update, Delete) and additional custom queries. Repositories in Spring Data JPA are part of the Repository abstraction in the Spring Data project, which simplifies database access.

Repositories eliminate the need for boilerplate code like writing SQL queries or implementing DAO (Data Access Object) interfaces, letting developers focus on business logic.

### Hierarchy of Repositories in Spring Data

Spring Data repositories are organized into a hierarchy:

Repository<T, ID>:- The base interface for Spring Data repositories.It's a marker interface (empty interface) and is not meant to be used directly.

```java
public interface Repository<T, ID> {}
```

CrudRepository<T, ID>:- Extends Repository.Provides basic CRUD operations (e.g., save(), findById(), delete()).

```java
public interface CrudRepository<T, ID> extends Repository<T, ID> {
    <S extends T> S save(S entity);
    Optional<T> findById(ID id);
    Iterable<T> findAll();
    void delete(T entity);
}
```

PagingAndSortingRepository<T, ID>:- Extends CrudRepository.Adds methods for pagination and sorting.

```java
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {
    Iterable<T> findAll(Sort sort);
    Page<T> findAll(Pageable pageable);
}
```

JpaRepository<T, ID>:- Extends PagingAndSortingRepository.Adds JPA-specific methods like flush() and saveAndFlush().All it's methods are transactional.

```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
    void flush();
    <S extends T> S saveAndFlush(S entity);
    void deleteAllInBatch();
}
```

## When to Use Which Interface?

1. CrudRepository: Use when you only need basic CRUD operations.
2. PagingAndSortingRepository: Use when you need pagination and sorting.
3. JpaRepository: Use when you need JPA-specific features like batch operations and saveAndFlush().

In most cases, developers use JpaRepository because it includes all the features of the other two.

Features of Repositories

- Built-in CRUD Methods:-Repositories come with built-in methods for standard CRUD operations:

1. save(T entity) - Saves or updates an entity.
2. findById(ID id)- Retrieves an entity by its primary key.
3. findAll() - Retrieves all entities.
4. deleteById(ID id)- Deletes an entity by its primary key.
5. delete(T entity) - Deletes a specific entity.
6. count() - Returns the count of entities.
7. existsById(ID id) - Checks if an entity exists by its primary key.

- Derived Query Methods:- Spring Data JPA can automatically generate query methods based on the naming conventions of methods in the repository interface.

For example:

```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmailContaining(String emailSubstring);
    List<User> findByAgeGreaterThan(int age);
}
```

findByName(String name): Finds users with a specific name.
findByEmailContaining(String emailSubstring): Finds users whose email contains a specific substring.
findByAgeGreaterThan(int age): Finds users older than a certain age.

Spring Data JPA parses the method names and translates them into appropriate JPQL or SQL queries.

- Custom Queries Using @Query:- If derived query methods are not sufficient, you can use the @Query annotation to write custom JPQL or native SQL queries.

```java
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findUsersByName(@Param("name") String name);

    @Query(value = "SELECT * FROM user WHERE email LIKE %:email%", nativeQuery = true)
    List<User> findUsersByEmail(@Param("email") String email);
}
```

JPQL Query: Defined with JPQL (Java Persistence Query Language).
Native Query: Defined with native SQL (nativeQuery = true).

- Pagination and Sorting:- Spring Data JPA provides support for pagination and sorting through the PagingAndSortingRepository and JpaRepository interfaces.

```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    List<User> findAll(Sort sort);
}
```

Pagination: Use Pageable to define page size, page number, and sorting.
Sorting: Use Sort to define sorting criteria.

Example:

```java
Page<User> usersPage = userRepository.findAll(PageRequest.of(0, 10, Sort.by("name")));
```

- Custom Repository Implementations:- You can define custom methods and provide your own implementations by extending your repository interface.

Example:

Define a custom repository interface:

```java
public interface CustomUserRepository {
    List<User> findUsersCustomLogic();
}
```

Implement the interface:

```java
@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findUsersCustomLogic() {
        String jpql = "SELECT u FROM User u WHERE u.customField = 'customValue'";
        return entityManager.createQuery(jpql, User.class).getResultList();
    }
}
```

Combine it with your repository:

```java
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {
    }
```

Now, UserRepository has both standard JPA methods and custom methods.

Advantages of Spring Data Repositories

1. Less Boilerplate Code: Automatically provides implementations for CRUD operations.
2. Custom Queries: Support for derived queries and custom @Query methods.
3. Integration: Works seamlessly with Spring’s transaction management and dependency injection.
4. Extensibility: Supports custom repository implementations for advanced use cases.
5. Pagination and Sorting: Built-in support for paginated and sorted results.

Conclusion

Spring Data repositories simplify database interactions by providing pre-implemented methods for CRUD operations, powerful query derivation capabilities, and extensibility through custom implementations. They are a key feature of Spring Data JPA, enabling developers to focus on business logic rather than writing boilerplate DAO code.

## save

The save() method allows us to save an entity to DB.Saving an entity acn be performed with CrudRepository.save(..) method.It persists or merges the given entity by using underlying JPA EntityManager.If the entity has not been persisted,Spring Data JPA saves the entity with a call to the entityManager.persist(..) method.Otherwise,it calls the entityManager.merge(..) method.

The saveAll() method allows us to save multiple entities to table.Belongs to CrudRepository.It returns a list of Iteraable objects.

## Retrieve Data

The findById() method allows us to get or retrieve an entity based on a given id(Primary Key) from the Database,It belongs to CrudRepository interface.It returns Optional of type Entity

The findAll() method allows us to get or retrieve all the entities from database table.Belongs to CrudRepository.It returns list of Iterable objects.

## Delete

The deleteById() method allows us to delete an entity by id from the database table.Belongs to CrudRepository.It returns void.

The delete() method allows us to delete an entity from the database table.Belongs to CrudRepository.Returns void.

The deleteAll() allows us to delete all the entities from database table.Belongs to CrudRepository.It returns void.

## count

The count() method allows us to count the number of records that exists in database table.Belongs to CrudRepository.It returns long(numbers of records)

## Exist

The existsById() method allows us to check if the entity exixts with a given id in database table.Belongs to CrudRepository.It returns a Boolean(true or false)
