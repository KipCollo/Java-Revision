# Persistence

The `Java Persistence API` provides an object/relational mapping facility to Java developers for managing relational data in Java applications. Java Persistence consists of three areas:

1. The Java Persistence API
2. The query language
3. Object/relational mapping metadata

`Entities`:- An entity is a lightweight persistence domain object. Typically an entity represents a table in a relational database, and each entity instance corresponds to a row in that table. The primary programming artifact of an entity is the entity class, although entities can use helper classes.

The persistent state of an entity is represented either through persistent fields or persistent properties. These fields or properties use object/relational mapping annotations to map the entities and entity relationships to the relational data in the underlying data store.

- An entity class must follow these requirements:
  1. The class must be annotated with the javax.persistence.Entity annotation.
  2. The class must have a public or protected, no-argument constructor. The class may have other constructors.
  3. The class must not be declared final. No methods or persistent instance variables must be declared final.
  4. If an entity instance be passed by value as a detached object, such as through a session bean’s remote business interface, the class must implement the Serializable interface.
  5. Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.
  6. Persistent instance variables must be declared private, protected, or package-private, and can only be accessed directly by the entity class’s methods. Clients must access the entity’s state through accessor or business methods.

- `Persistent Fields and Properties in Entity Classes`:- The persistent state of an entity can be accessed either through the entity’s instance variables or through JavaBeans-style properties. The fields or properties must be of the following Java language types:
  1. Java primitive types
  2. java.lang.String
  3. Wrappers of Java primitive types
  4. java.math.BigInteger
  5. java.math.BigDecimal
  6. java.util.Date
  7. java.util.Calendar
  8. java.sql.Date
  9. java.sql.Time
  10. java.sql.TimeStamp
  11. User-defined serializable types
  12. byte[]
  13. Byte[]
  14. char[]
  15. Character[]
  16. Enumerated types
  17. Other entities and/or collections of entities
  18. Embeddable classes

Entities may either use persistent fields or persistent properties. If the mapping annotations are applied to the entity’s instance variables, the entity uses persistent fields. If the mapping annotations are applied to the entity’s getter methods for JavaBeans-style properties, the entity uses persistent properties. You cannot apply mapping annotations to both fields and properties in a single entity.

- `Persistent Fields`:- If the entity class uses persistent fields, the Persistence runtime accesses entity class instance variables directly. All fields not annotated javax.persistence.Transient or not marked as Java transient will be persisted to the data store. The object/relational mapping annotations must be applied to the instance variables.
Persistent Properties

If the entity uses persistent properties, the entity must follow the method conventions of JavaBeans components. JavaBeans-style properties use getter and setter methods that are typically named after the entity class’s instance variable names. For every persistent property property of type Type of the entity, there is a getter method getProperty and setter method setProperty. If the property is a boolean, you may use isProperty instead of getProperty. For example, if a Customer entity uses persistent properties, and has a private instance variable called firstName, the class defines a getFirstName and setFirstName method for retrieving and setting the state of the firstName instance variable.

The method signature for single-valued persistent properties are as follows:

Type getProperty()
void setProperty(Type type)

Collection-valued persistent fields and properties must use the supported Java collection interfaces regardless of whether the entity uses persistent fields or properties. The following collection interfaces may be used:

    java.util.Collection

    java.util.Set

    java.util.List

    java.util.Map

If the entity class uses persistent fields, the type in the above method signatures must be one of these collection types. Generic variants of these collection types may also be used. For example, if the Customer entity has a persistent property that contains a set of phone numbers, it would have the following methods:

Set<PhoneNumber> getPhoneNumbers() {}
void setPhoneNumbers(Set<PhoneNumber>) {}

The object/relational mapping annotations for must be applied to the getter methods. Mapping annotations cannot be applied to fields or properties annotated @Transient or marked transient.
Primary Keys in Entities

Each entity has a unique object identifier. A customer entity, for example, might be identified by a customer number. The unique identifier, or primary key, enables clients to locate a particular entity instance. Every entity must have a primary key. An entity may have either a simple or a composite primary key.

Simple primary keys use the javax.persistence.Id annotation to denote the primary key property or field.

Composite primary keys must correspond to either a single persistent property or field, or to a set of single persistent properties or fields. Composite primary keys must be defined in a primary key class. Composite primary keys are denoted using the javax.persistence.EmbeddedId and javax.persistence.IdClass annotations.

The primary key, or the property or field of a composite primary key, must be one of the following Java language types:

    Java primitive types

    Java primitive wrapper types

    java.lang.String

    java.util.Date (the temporal type should be DATE)

    java.sql.Date

Floating point types should never be used in primary keys. If you use a generated primary key, only integral types will be portable.
Primary Key Classes

A primary key class must meet these requirements:

    The access control modifier of the class must be public.

    The properties of the primary key class must be public or protected if property-based access is used.

    The class must have a public default constructor.

    The class must implement the hashCode() and equals(Object other) methods.

    The class must be serializable.

    A composite primary key must be represented and mapped to multiple fields or properties of the entity class, or must be represented and mapped as an embeddable class.

    If the class is mapped to multiple fields or properties of the entity class, the names and types of the primary key fields or properties in the primary key class must match those of the entity class.

The following primary key class is a composite key, the orderId and itemId fields together uniquely identify an entity.

public final class LineItemKey implements Serializable {
    public Integer orderId;
    public int itemId;

    public LineItemKey() {}

    public LineItemKey(Integer orderId, int itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public boolean equals(Object otherOb) {
        if (this == otherOb) {
            return true;
        }
        if (!(otherOb instanceof LineItemKey)) {
            return false;
        }
        LineItemKey other = (LineItemKey) otherOb;
        return (
                    (orderId==null?other.orderId==null:orderId.equals
                    (other.orderId)
                    )
                    &&
                    (itemId == other.itemId)
                );
    }

    public int hashCode() {
        return (
                    (orderId==null?0:orderId.hashCode())
                    ^
                    ((int) itemId)
                );
    }

    public String toString() {
        return "" + orderId + "-" + itemId;
    }
}

Multiplicity in Entity Relationships

There are four types of multiplicities: one-to-one, one-to-many, many-to-one, and many-to-many.

One-to-one: Each entity instance is related to a single instance of another entity. For example, to model a physical warehouse in which each storage bin contains a single widget, StorageBin and Widget would have a one-to-one relationship. One-to-one relationships use the javax.persistence.OneToOne annotation on the corresponding persistent property or field.

One-to-many: An entity instance can be related to multiple instances of the other entities. A sales order, for example, can have multiple line items. In the order application, Order would have a one-to-many relationship with LineItem. One-to-many relationships use the javax.persistence.OneToMany annotation on the corresponding persistent property or field.

Many-to-one: Multiple instances of an entity can be related to a single instance of the other entity. This multiplicity is the opposite of a one-to-many relationship. In the example just mentioned, from the perspective of LineItem the relationship to Order is many-to-one. Many-to-one relationships use the javax.persistence.ManyToOne annotation on the corresponding persistent property or field.

Many-to-many: The entity instances can be related to multiple instances of each other. For example, in college each course has many students, and every student may take several courses. Therefore, in an enrollment application, Course and Student would have a many-to-many relationship. Many-to-many relationships use the javax.persistence.ManyToMany annotation on the corresponding persistent property or field.
Direction in Entity Relationships

The direction of a relationship can be either bidirectional or unidirectional. A bidirectional relationship has both an owning side and an inverse side. A unidirectional relationship has only an owning side. The owning side of a relationship determines how the Persistence runtime makes updates to the relationship in the database.
Bidirectional Relationships

In a bidirectional relationship, each entity has a relationship field or property that refers to the other entity. Through the relationship field or property, an entity class’s code can access its related object. If an entity has a related field, then the entity is said to “know” about its related object. For example, if Order knows what LineItem instances it has and if LineItem knows what Order it belongs to, then they have a bidirectional relationship.

Bidirectional relationships must follow these rules:

    The inverse side of a bidirectional relationship must refer to its owning side by using the mappedBy element of the @OneToOne, @OneToMany, or @ManyToMany annotation. The mappedBy element designates the property or field in the entity that is the owner of the relationship.

    The many side of many-to-one bidirectional relationships must not define the mappedBy element. The many side is always the owning side of the relationship.

    For one-to-one bidirectional relationships, the owning side corresponds to the side that contains the corresponding foreign key.

    For many-to-many bidirectional relationships either side may be the owning side.

Unidirectional Relationships

In a unidirectional relationship, only one entity has a relationship field or property that refers to the other. For example, LineItem would have a relationship field that identifies Product, but Product would not have a relationship field or property for LineItem. In other words, LineItem knows about Product, but Product doesn’t know which LineItem instances refer to it.
Queries and Relationship Direction

Java Persistence query language queries often navigate across relationships. The direction of a relationship determines whether a query can navigate from one entity to another. For example, a query can navigate from LineItem to Product but cannot navigate in the opposite direction. For Order and LineItem, a query could navigate in both directions, because these two entities have a bidirectional relationship.
Cascade Deletes and Relationships

Entities that use relationships often have dependencies on the existence of the other entity in the relationship. For example, a line item is part of an order, and if the order is deleted, then the line item should also be deleted. This is called a cascade delete relationship.

Cascade delete relationships are specified using the cascade=REMOVE element specification for @OneToOne and @OneToMany relationships. For example:

@OneToMany(cascade=REMOVE, mappedBy="customer")
public Set<Order> getOrders() { return orders; }

Entity Inheritance

Entities support class inheritance, polymorphic associations, and polymorphic queries. They can extend non-entity classes, and non-entity classes can extend entity classes. Entity classes can be both abstract and concrete.

The roster example application demonstrates entity inheritance, and is described in Entity Inheritance in the roster Application.
Abstract Entities

An abstract class may be declared an entity by decorating the class with @Entity. Abstract entities differ from concrete entities only in that they cannot be instantiated.

Abstract entities can be queried just like concrete queries. If an abstract entity is the target of a query, the query operates on all the concrete subclasses of the abstract entity.

@Entity
public abstract class Employee {
    @Id
    protected Integer employeeId;
    ...
}
@Entity
public class FullTimeEmployee extends Employee {
    protected Integer salary;
    ...
}
@Entity
public class PartTimeEmployee extends Employee {
    protected Float hourlyWage;
}

Mapped Superclasses

Entities may inherit from superclasses that contain persistent state and mapping information, but are not entities. That is, the superclass is not decorated with the @Entity annotation, and is not mapped as an entity by the Java Persistence provider. These superclasses are most often used when you have state and mapping information common to multiple entity classes.

Mapped superclasses are specified by decorating the class with the javax.persistence.MappedSuperclass annotation.

@MappedSuperclass
public class Employee {
    @Id
    protected Integer employeeId;
    ...
}
@Entity
public class FullTimeEmployee extends Employee {
    protected Integer salary;
    ...
}
@Entity
public class PartTimeEmployee extends Employee {
    protected Float hourlyWage;
    ...
}

Mapped superclasses are not queryable, and can’t be used in EntityManager or Query operations. You must use entity subclasses of the mapped superclass in EntityManager or Query operations. Mapped superclasses can’t be targets of entity relationships. Mapped superclasses can be abstract or concrete.

Mapped superclasses do not have any corresponding tables in the underlying datastore. Entities that inherit from the mapped superclass define the table mappings. For instance, in the code sample above the underlying tables would be FULLTIMEEMPLOYEE and PARTTIMEEMPLOYEE, but there is no EMPLOYEE table.
Non-Entity Superclasses

Entities may have non-entity superclasses, and these superclasses can be either abstract or concrete. The state of non-entity superclasses is non-persistent, and any state inherited from the non-entity superclass by an entity class is non-persistent. Non-entity superclasses may not be used in EntityManager or Query operations. Any mapping or relationship annotations in non-entity superclasses are ignored.
Entity Inheritance Mapping Strategies

You can configure how the Java Persistence provider maps inherited entities to the underlying datastore by decorating the root class of the hierarchy with the javax.persistence.Inheritance annotation. There are three mapping strategies that are used to map the entity data to the underlying database:

    A single table per class hierarchy

    A table per concrete entity class

    A “join” strategy, where fields or properties that are specific to a subclass are mapped to a different table than the fields or properties that are common to the parent class

The strategy is configured by setting the strategy element of @Inheritance to one of the options defined in the javax.persistence.InheritanceType enumerated type:

public enum InheritanceType {
    SINGLE_TABLE,
    JOINED,
    TABLE_PER_CLASS
};

The default strategy is InheritanceType.SINGLE_TABLE, and is used if the @Inheritance annotation is not specified on the root class of the entity hierarchy.
The Single Table per Class Hierarchy Strategy

With this strategy, which corresponds to the default InheritanceType.SINGLE_TABLE, all classes in the hierarchy are mapped to a single table in the database. This table has a discriminator column, a column that contains a value that identifies the subclass to which the instance represented by the row belongs.

The discriminator column can be specified by using the javax.persistence.DiscriminatorColumn annotation on the root of the entity class hierarchy.

Table 24-1 @DiscriminatorColumn Elements

Type
	

Name
	

Description

String
	

name
	

The name of the column in the table to be used as the discriminator column. The default is DTYPE. This element is optional.

DiscriminatorType
	

discriminatorType
	

The type of the column to be used as a discriminator column. The default is DiscriminatorType.STRING. This element is optional.

String
	

columnDefinition
	

The SQL fragment to use when creating the discriminator column. The default is generated by the Persistence provider, and is implementation-specific. This element is optional.

String
	

length
	

The column length for String-based discriminator types. This element is ignored for non-String discriminator types. The default is 31. This element is optional.

The javax.persistence.DiscriminatorType enumerated type is used to set the type of the discriminator column in the database by setting the discriminatorType element of @DiscriminatorColumn to one of the defined types. DiscriminatorType is defined as:

public enum DiscriminatorType {
    STRING,
    CHAR,
    INTEGER
};

If @DiscriminatorColumn is not specified on the root of the entity hierarchy and a discriminator column is required, the Persistence provider assumes a default column name of DTYPE, and column type of DiscriminatorType.STRING.

The javax.persistence.DiscriminatorValue annotation may be used to set the value entered into the discriminator column for each entity in a class hierarchy. You may only decorate concrete entity classes with @DiscriminatorValue.

If @DiscriminatorValue is not specified on an entity in a class hierarchy that uses a discriminator column, the Persistence provider will provide a default, implementation-specific value. If the discriminatorType element of @DiscriminatorColumn is DiscriminatorType.STRING, the default value is the name of the entity.

This strategy provides good support for polymorphic relationships between entities and queries that cover the entire entity class hierarchy. However, it requires the columns that contain the state of subclasses to be nullable.
The Table per Concrete Class Strategy

In this strategy, which corresponds to InheritanceType.TABLE_PER_CLASS, each concrete class is mapped to a separate table in the database. All fields or properties in the class, including inherited fields or properties, are mapped to columns in the class’s table in the database.

This strategy provides poor support for polymorphic relationships, and usually requires either SQL UNION queries or separate SQL queries for each subclass for queries that cover the entire entity class hierarchy.

Support for this strategy is optional, and may not be supported by all Java Persistence API providers. The default Java Persistence API provider in the Application Server does not support this strategy.
The Joined Subclass Strategy

In this strategy, which corresponds to InheritanceType.JOINED, the root of the class hierarchy is represented by a single table, and each subclass has a separate table that only contains those fields specific to that subclass. That is, the subclass table does not contain columns for inherited fields or properties. The subclass table also has a column or columns that represent its primary key, which is a foreign key to the primary key of the superclass table.

This strategy provides good support for polymorphic relationships, but requires one or more join operations to be performed when instantiating entity subclasses. This may result in poor performance for extensive class hierarchies. Similarly, queries that cover the entire class hierarchy require join operations between the subclass tables, resulting in decreased performance.

Some Java Persistence API providers, including the default provider in the Application Server, require a discriminator column in the table that corresponds to the root entity when using the joined subclass strategy. If you are not using automatic table creation in your application, make sure the database table is set up correctly for the discriminator column defaults, or use the @DiscriminatorColumn annotation to match your database schema. For information on discriminator columns, see The Single Table per Class Hierarchy Strategy.


Managing Entities

Entities are managed by the entity manager. The entity manager is represented by javax.persistence.EntityManager instances. Each EntityManager instance is associated with a persistence context. A persistence context defines the scope under which particular entity instances are created, persisted, and removed.
The Persistence Context

A persistence context is a set of managed entity instances that exist in a particular data store. The EntityManager interface defines the methods that are used to interact with the persistence context.
The EntityManager Interface

The EntityManager API creates and removes persistent entity instances, finds entities by the entity’s primary key, and allows queries to be run on entities.
Container-Managed Entity Managers

With a container-managed entity manager, an EntityManager instance’s persistence context is automatically propagated by the container to all application components that use the EntityManager instance within a single Java Transaction Architecture (JTA) transaction.

JTA transactions usually involve calls across application components. To complete a JTA transaction, these components usually need access to a single persistence context. This occurs when an EntityManager is injected into the application components by means of the javax.persistence.PersistenceContext annotation. The persistence context is automatically propagated with the current JTA transaction, and EntityManager references that are mapped to the same persistence unit provide access to the persistence context within that transaction. By automatically propagating the persistence context, application components don’t need to pass references to EntityManager instances to each other in order to make changes within a single transaction. The Java EE container manages the life cycle of container-managed entity managers.

To obtain an EntityManager instance, inject the entity manager into the application component:

@PersistenceContext
EntityManager em;

Application-Managed Entity Managers

With application-managed entity managers, on the other hand, the persistence context is not propagated to application components, and the life cycle of EntityManager instances is managed by the application.

Application-managed entity managers are used when applications need to access a persistence context that is not propagated with the JTA transaction across EntityManager instances in a particular persistence unit. In this case, each EntityManager creates a new, isolated persistence context. The EntityManager, and its associated persistence context, is created and destroyed explicitly by the application.

Applications create EntityManager instances in this case by using the createEntityManager method of javax.persistence.EntityManagerFactory.

To obtain an EntityManager instance, you first must obtain an EntityManagerFactory instance by injecting it into the application component by means of the javax.persistence.PersistenceUnit annotation:

@PersistenceUnit
EntityManagerFactory emf;

Then, obtain an EntityManager from the EntityManagerFactory instance:

EntityManager em = emf.createEntityManager();

Finding Entities Using the EntityManager

The EntityManager.find method is used to look up entities in the data store by the entity’s primary key.

@PersistenceContext
EntityManager em;
public void enterOrder(int custID, Order newOrder) {
    Customer cust = em.find(Customer.class, custID);
    cust.getOrders().add(newOrder);
    newOrder.setCustomer(cust);
}

Managing an Entity Instance’s Life Cycle

You manage entity instances by invoking operations on the entity by means of an EntityManager instance. Entity instances are in one of four states: new, managed, detached, or removed.

New entity instances have no persistent identity and are not yet associated with a persistence context.

Managed entity instances have a persistent identity and are associated with a persistence context.

Detached entity instances have a persistent identify and are not currently associated with a persistence context.

Removed entity instances have a persistent identity, are associated with a persistent context, and are scheduled for removal from the data store.
Persisting Entity Instances

New entity instances become managed and persistent either by invoking the persist method, or by a cascading persist operation invoked from related entities that have the cascade=PERSIST or cascade=ALL elements set in the relationship annotation. This means the entity’s data is stored to the database when the transaction associated with the persist operation is completed. If the entity is already managed, the persist operation is ignored, although the persist operation will cascade to related entities that have the cascade element set to PERSIST or ALL in the relationship annotation. If persist is called on a removed entity instance, it becomes managed. If the entity is detached, persist will throw an IllegalArgumentException, or the transaction commit will fail.

@PersistenceContext
EntityManager em;
...
public LineItem createLineItem(Order order, Product product,
        int quantity) {
    LineItem li = new LineItem(order, product, quantity);
    order.getLineItems().add(li);
    em.persist(li);
    return li;
}

The persist operation is propagated to all entities related to the calling entity that have the cascade element set to ALL or PERSIST in the relationship annotation.

@OneToMany(cascade=ALL, mappedBy="order")
public Collection<LineItem> getLineItems() {
    return lineItems;
}

Removing Entity Instances

Managed entity instances are removed by invoking the remove method, or by a cascading remove operation invoked from related entities that have the cascade=REMOVE or cascade=ALL elements set in the relationship annotation. If the remove method is invoked on a new entity, the remove operation is ignored, although remove will cascade to related entities that have the cascade element set to REMOVE or ALL in the relationship annotation. If remove is invoked on a detached entity it will throw an IllegalArgumentException, or the transaction commit will fail. If remove is invoked on an already removed entity, it will be ignored. The entity’s data will be removed from the data store when the transaction is completed, or as a result of the flush operation.

public void removeOrder(Integer orderId) {
    try {
        Order order = em.find(Order.class, orderId);
        em.remove(order);
    }...

In this example, all LineItem entities associated with the order are also removed, as Order.getLineItems has cascade=ALL set in the relationship annotation.
Synchronizing Entity Data to the Database

The state of persistent entities is synchronized to the database when the transaction with which the entity is associated commits. If a managed entity is in a bidirectional relationship with another managed entity, the data will be persisted based on the owning side of the relationship.

To force synchronization of the managed entity to the data store, invoke the flush method of the entity. If the entity is related to another entity, and the relationship annotation has the cascade element set to PERSIST or ALL, the related entity’s data will be synchronized with the data store when flush is called.

If the entity is removed, calling flush will remove the entity data from the data store.
Creating Queries

The EntityManager.createQuery and EntityManager.createNamedQuery methods are used to query the datastore using Java Persistence query language queries. See Chapter 27, The Java Persistence Query Language for more information on the query language.

The createQuery method is used to create dynamic queries, queries that are defined directly within an application’s business logic.

public List findWithName(String name) {
return em.createQuery(
    "SELECT c FROM Customer c WHERE c.name LIKE :custName")
    .setParameter("custName", name)
    .setMaxResults(10)
    .getResultList();
}

The createNamedQuery method is used to create static queries, queries that are defined in metadata using the javax.persistence.NamedQuery annotation. The name element of @NamedQuery specifies the name of the query that will be used with the createNamedQuery method. The query element of @NamedQuery is the query.

@NamedQuery(
    name="findAllCustomersWithName",
    query="SELECT c FROM Customer c WHERE c.name LIKE :custName"
)

Here’s an example of createNamedQuery, which uses the @NamedQuery defined above.

@PersistenceContext
public EntityManager em;
...
customers = em.createNamedQuery("findAllCustomersWithName")
    .setParameter("custName", "Smith")
    .getResultList();

Named Parameters in Queries

Named parameters are parameters in a query that are prefixed with a colon (:). Named parameters in a query are bound to an argument by the javax.persistence.Query.setParameter(String name, Object value) method. In the following example, the name argument to the findWithName business method is bound to the :custName named parameter in the query by calling Query.setParameter.

public List findWithName(String name) {
    return em.createQuery(
        "SELECT c FROM Customer c WHERE c.name LIKE :custName")
        .setParameter("custName", name)
        .getResultList();
}

Named parameters are case-sensitive, and may be used by both dynamic and static queries.
Positional Parameters in Queries

You may alternately use positional parameters in queries, instead of named parameters. Positional parameters are prefixed with a question mark (?) followed the numeric position of the parameter in the query. The Query.setParameter(integer position, Object value) method is used to set the parameter values.

In the following example, the findWithName business method is rewritten to use input parameters:

public List findWithName(String name) {
    return em.createQuery(
        “SELECT c FROM Customer c WHERE c.name LIKE ?1”)
        .setParameter(1, name)
        .getResultList();
}

Input parameters are numbered starting from 1. Input parameters are case-sensitive, and may be used by both dynamic and static queries.
Persistence Units

A persistence unit defines a set of all entity classes that are managed by EntityManager instances in an application. This set of entity classes represents the data contained within a single data store.

Persistence units are defined by the persistence.xml configuration file. The JAR file or directory whose META-INF directory contains persistence.xml is called the root of the persistence unit. The scope of the persistence unit is determined by the persistence unit’s root.

Each persistence unit must be identified with a name that is unique to the persistence unit’s scope.

Persistent units can be packaged as part of a WAR or EJB JAR file, or can be packaged as a JAR file that can then be included in an WAR or EAR file.

If you package the persistent unit as a set of classes in an EJB JAR file, persistence.xml should be put in the EJB JAR’s META-INF directory.

If you package the persistence unit as a set of classes in a WAR file, persistence.xml should be located in the WAR file’s WEB-INF/classes/META-INF directory.

If you package the persistence unit in a JAR file that will be included in a WAR or EAR file, the JAR file should be located:

    In the WEB-INF/lib directory of a WAR.

    In the top-level of an EAR file.

    In the EAR file’s library directory.

The persistence.xml File

persistence.xml defines one or more persistence units. The following is an example persistence.xml file.

<persistence>
    <persistence-unit name="OrderManagement">
        <description>This unit manages orders and customers.
            It does not rely on any vendor-specific features and can
            therefore be deployed to any persistence provider.
        </description>
        <jta-data-source>jdbc/MyOrderDB</jta-data-source>
        <jar-file>MyOrderApp.jar</jar-file>
        <class>com.widgets.Order</class>
        <class>com.widgets.Customer</class>
    </persistence-unit>
</persistence>

This file defines a persistence unit named OrderManagement, which uses a JTA-aware data source jdbc/MyOrderDB. The jar-file and class elements specify managed persistence classes: entity classes, embeddable classes, and mapped superclasses. The jar-file element specifies JAR files that are visible to the packaged persistence unit that contain managed persistence classes, while the class element explicitly names managed persistence classes.

The jta-data-source (for JTA-aware data sources) and non-jta-data-source (non-JTA-aware data sources) elements specify the global JNDI name of the data source to be use by the container.

## Java Persistence API

Persistence simply means that we would like our application’s data to outlive the applications process. In Java terms, we would like the state of (some of) our objects to live beyond the scope of the JVM so that the same state is available later.

## ORM

Object/Relational Mapping refers to the technique of mapping data from an object model representation to a relational data model representation (and vice versa).

## JPA (Java Persistence API)

JPA is a specification for ORM (Object-Relational Mapping), which maps Java objects to database tables and abstracts SQL operations.

Key Features:

- Declarative mapping using annotations (@Entity, @Table, etc.).
- Entity relationships (@OneToOne, @OneToMany, etc.).
- JPQL (Java Persistence Query Language): Object-oriented query language.

Key Classes/Interfaces:

- EntityManager: Manages entities and transactions.
- Persistence: Bootstrap class for initializing JPA.
- Entities: Plain Old Java Objects (POJOs) annotated for persistence.

Limitation:- JPA is a specification, not an implementation. It needs a provider like Hibernate.

## Hibernate (JPA Provider)

Hibernate is a framework that implements the JPA specification and adds additional features for ORM and database interactions.

Key Features:

- Implements all JPA features.
- Provides advanced features like caching, lazy loading, and batch processing.
- Supports native SQL queries alongside JPQL.

Key Components:

- SessionFactory: Factory for managing database sessions.
- Session: Equivalent to EntityManager in JPA.
- Criteria API: For programmatically building queries.

Use Case: Hibernate is one of the most popular JPA providers due to its rich feature set and extensive documentation.

**JPA as a Specification** - JPA (Java Persistence API) is indeed a specification, which means it defines a set of rules and guidelines for object-relational mapping (ORM) and how Java objects are persisted in relational databases. JPA itself does not provide an implementation; it just defines the standards for ORM. Think of it as a contract that an ORM provider (like Hibernate, EclipseLink, or OpenJPA) follows to enable persistence functionality in Java.

JPA provides a set of annotations like @Entity, @Id, @GeneratedValue, @ManyToOne, @OneToMany, etc.
JPA also defines how data is persisted, retrieved, and queried, but it leaves the implementation details to the provider.

**Hibernate as an Implementation of JPA** - Hibernate is a popular JPA implementation. It adheres to the JPA specification, but it also includes additional features beyond JPA. Hibernate implements the rules defined by JPA, but it also adds its own set of advanced ORM capabilities, such as custom caching, automatic dirty checking, and more.

Hibernate can be used as the JPA provider. In fact, when you use JPA annotations in your code (like @Entity, @Id, etc.), Hibernate is the underlying implementation that handles the actual mapping between your Java objects and the database.

## JPA Configuration (Persistence Unit)

Create a persistence.xml file inside src/main/resources/META-INF/ to configure the persistence unit.

```xml
<persistence xmlns="https://jakarta.ee/xml/ns/persistence" version="3.0">
    <persistence-unit name="my-persistence-unit">
        <class>User</class>
        <properties>
            <!-- Database connection properties -->
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/my_database"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="password"/>
            <property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>

            <!-- Hibernate as JPA provider -->
            <property name="jakarta.persistence.provider" value="org.hibernate.jpa.HibernatePersistenceProvider"/>

            <!-- Hibernate properties -->
            <property name="hibernate.hbm2ddl.auto" value="update"/> <!-- Auto-create tables -->
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
            <property name="hibernate.show_sql" value="true"/> <!-- Show SQL in logs -->
        </properties>
    </persistence-unit>
</persistence>
```

JPA Implementation

This code demonstrates fetching data from the users table using JPA.

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class JPAExample {
    public static void main(String[] args) {
        // Create EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        try {
            // Fetch all users from the database
            List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();

            // Print user details
            users.forEach(user -> 
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail())
            );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the EntityManager and EntityManagerFactory
            em.close();
            emf.close();
        }
    }
}
```

How It Works

Entity Class:The User class is annotated with @Entity to map it to the users table in the database.The @Id and @GeneratedValue annotations specify the primary key and its auto-generation strategy.
Persistence Configuration:The persistence.xml file defines the persistence unit, database connection details, and JPA provider (Hibernate in this case).
EntityManager:The EntityManager is used to interact with the database.The createQuery method runs a JPQL query (SELECT u FROM User u) to fetch all users.
Resource Management:The EntityManager and EntityManagerFactory are properly closed to release resources.

Advantages of Using JPA

Abstraction:JPA abstracts SQL queries and low-level JDBC code, making database interactions simpler.
ORM Capabilities:JPA maps Java objects directly to database tables, reducing boilerplate code.
Portability:The same code can work with different databases by simply changing the configuration in persistence.xml.
Transaction Management:Transactions are easier to manage compared to JDBC.

This implementation is clean, scalable, and leverages JPA for efficient database operations.

JPA abstracts SQL queries by allowing developers to interact with the database using Java objects and methods rather than writing raw SQL queries. It uses an Object-Relational Mapping (ORM) approach, where Java classes are mapped to database tables, and their fields correspond to table columns. Here's how JPA achieves query abstraction:

- Using Entity Classes Instead of Tables:- With JPA, you work with Java classes (entities) that represent database tables.Instead of manually constructing SQL statements, you manipulate these entities, and JPA translates the operations into SQL.

Example:

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

How it is abstracted:- This User class is mapped to the users table in the database.You don’t need to write SQL INSERT INTO, SELECT, or UPDATE statements explicitly.

- Query Abstraction with JPQL:- JPA provides Java Persistence Query Language (JPQL), which is a high-level query language similar to SQL but operates on entity objects rather than table names.

Example:

```java
List<User> users = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class)
                     .setParameter("name", "Alice")
                     .getResultList();
```

How it is abstracted:- The SELECT u FROM User u query operates on the User entity, not the users table.JPA automatically translates this JPQL query into the equivalent SQL:

```sql
SELECT * FROM users WHERE name = 'Alice';
```

- CRUD Operations Without SQL:- JPA provides methods for common database operations like Create, Read, Update, and Delete (CRUD). You don’t need to write SQL for these tasks.

Example: Persisting an Object (Insert)

```java
User user = new User();
user.setName("Charlie");
user.setEmail("charlie@example.com");

em.getTransaction().begin();
em.persist(user);
em.getTransaction().commit();
```

How it is abstracted:- The persist method inserts the object into the database.JPA generates the following SQL:

```sql
INSERT INTO users (name, email) VALUES ('Charlie', 'charlie@example.com');
```

Example: Updating an Object

```java
User user = em.find(User.class, 1L);
user.setEmail("newemail@example.com");

em.getTransaction().begin();
em.merge(user);
em.getTransaction().commit();
```

How it is abstracted:- The merge method updates the object in the database.
JPA generates:

```sql
UPDATE users SET email = 'newemail@example.com' WHERE id = 1;
```

- Relationships Abstracted:- JPA handles relationships (e.g., one-to-many, many-to-many) without requiring SQL joins.

Example:

```java
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // Maps to the 'user_id' column in the orders table
}
```

How it is abstracted:- The @ManyToOne annotation maps a Java reference to a foreign key column in SQL.Fetching all orders with their users:

```java
List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
```

JPA generates:

```sql
SELECT o.id, o.user_id FROM orders o;
```

- Automatic SQL Generation:- JPA automatically generates SQL based on annotations like @Entity, @Table, @Id, etc. For example:

Entity Class:

```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

Generated SQL for Table Creation:

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);
```

- Criteria API for Dynamic Queries:- For dynamic queries, JPA provides a Criteria API, allowing you to build queries programmatically in Java.

Example:

```java
CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<User> query = cb.createQuery(User.class);
Root<User> root = query.from(User.class);
query.select(root).where(cb.equal(root.get("name"), "Alice"));

List<User> users = em.createQuery(query).getResultList();
```

How it is abstracted:- This builds a SQL query dynamically without directly writing SQL:

```sql
SELECT * FROM users WHERE name = 'Alice';
```

Summary of Abstractions
Task- JDBC (Manual SQL)- JPA (Abstracted)
Entity Mapping- Write SQL for table operations.- Annotate Java classes, and let JPA map them.
Querying- Write SELECT statements manually.- Use JPQL or Criteria API for object-oriented queries.
Inserting Data- Use INSERT INTO queries.- Call persist() on an entity.
Updating Data- Write UPDATE statements.- Call merge() on an entity.
Relationships- Manually manage foreign keys.- Use annotations like @OneToMany, @ManyToOne.
Transactions- Explicitly manage commit/rollback in SQL.- Use EntityTransaction with abstracted methods.

JPA reduces the need for boilerplate SQL, minimizes error-prone code, and provides a cleaner, object-oriented approach to database interactions.

## Java Persistence API vs. Jakarta Persistence Layer

Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) are both popular frameworks for managing relational data in Java applications. While JPA has been around for a longer time, JPL was introduced as part of the Jakarta EE specifications after Java EE was transferred to the Eclipse Foundation.

## Java Persistence API (JPA)

Java Persistence API (JPA) is a Java specification for managing relational data in Java applications. It is part of the Java EE and Jakarta EE specifications and provides an Object-Relational Mapping (ORM) framework to map Java objects to relational database tables. JPA allows developers to interact with relational databases in an object-oriented way, abstracting the underlying SQL.

## Jakarta Persistence Layer (JPL)

Jakarta Persistence Layer (JPL) is the successor to JPA and is part of the Jakarta EE specifications. It is built upon JPA and provides similar functionality for managing relational data in Java applications. The primary difference is the change of package names, from javax.persistence to jakarta.persistence.

Both Java Persistence API (JPA) and Jakarta Persistence Layer (JPL) provide robust frameworks for managing relational data in Java applications. They both offer similar functionality, and the primary difference is the change of package names.

Jakarta Persistence is the API for the management for persistence and object/relational mapping.

## Annotation Types

1. @Access:- Used to specify an access type to be applied to an entity class, mapped superclass, or embeddable class, or to a specific attribute of such a class.
2. @AssociationOverride:- Used to override a mapping for an entity relationship.
3. @AssociationOverrides:- Used to override mappings of multiple relationship properties or fields.
4. @AttributeOverride:- Used to override the mapping of a Basic (whether explicit or default) property or field or Id property or field.
5. @AttributeOverrides:- Used to override mappings of multiple properties or fields.
6. @Basic:- The simplest type of mapping to a database column.
7. @Cacheable:- Specifies whether an entity should be cached if caching is enabled when the value of the persistence.xml caching element is ENABLE_SELECTIVE or DISABLE_SELECTIVE.
8. @CollectionTable:- Specifies the table that is used for the mapping of collections of basic or embeddable types.
9. @Column:- Specifies the mapped column for a persistent property or field.
10. @ColumnResult;- Used in conjunction with the SqlResultSetMapping annotation or ConstructorResult annotation to map a column of the SELECT list of a SQL query.
11. @ConstructorResult:- Used in conjunction with the SqlResultSetMapping annotation to map the SELECT clause of a SQL query to a constructor.
12. @Convert:- Specifies the conversion of a Basic field or property.
13. @Converter:- Specifies that the annotated class is a converter and defines its scope.
14. @Entity:- Specifies that the class is an entity.
15. @Id:- Specifies the primary key of an entity.
16. @Table:- Specifies the primary table for the annotated entity.
17. @UniqueConstraint- Specifies that a unique constraint is to be included in the generated DDL for a primary or secondary table.
18. @GeneratedValue:- Provides for the specification of generation strategies for the values of primary keys.
19. @SequenceGenerators- Used to group SequenceGenerator annotations.

Converts- Used to group Convert annotations.
DiscriminatorColumn- Specifies the discriminator column for the SINGLE_TABLE and JOINED Inheritance mapping strategies.
DiscriminatorValue:- Specifies the value of the discriminator column for entities of the given type.
ElementCollection:- Specifies a collection of instances of a basic type or embeddable class.
Embeddable:- Specifies a class whose instances are stored as an intrinsic part of an owning entity and share the identity of the entity.
Embedded:- Specifies a persistent field or property of an entity whose value is an instance of an embeddable class.
EmbeddedId:- Applied to a persistent field or property of an entity class or mapped superclass to denote a composite primary key that is an embeddable class.
@EntityListeners:- Specifies the callback listener classes to be used for an entity or mapped superclass.
EntityResult:- Used in conjunction with the SqlResultSetMapping annotation to map the SELECT clause of a SQL query to an entity result.
Enumerated:- Specifies that a persistent property or field should be persisted as a enumerated type.
ExcludeDefaultListeners:- Specifies that the invocation of default listeners is to be excluded for the entity class (or mapped superclass) and its subclasses.
ExcludeSuperclassListeners:- Specifies that the invocation of superclass listeners is to be excluded for the entity class (or mapped superclass) and its subclasses.
FieldResult:- Used in conjunction with the EntityResult annotation to map columns specified in the SELECT list of a SQL query to the properties or fields of an entity class.
ForeignKey:- Used to specify the handling of foreign key constraints when schema generation is in effect.
@IdClass:- Specifies a composite primary key class that is mapped to multiple fields or properties of the entity.
@Index:- Used in schema generation to specify creation of an index.
@Inheritance:- Specifies the inheritance strategy to be used for an entity class hierarchy.
@JoinColumn:- Specifies a column for joining an entity association or element collection.
@JoinColumns:- Specifies the mapping for composite foreign keys.
@JoinTable:- Specifies the mapping of associations.
@Lob :- Specifies that a persistent property or field should be persisted as a large object to a database-supported large object type.
@ManyToMany:- Specifies a many-valued association with many-to-many multiplicity.
@ManyToOne:- Specifies a single-valued association to another entity class that has many-to-one multiplicity.
MapKey:- Specifies the map key for associations of type java.util.Map when the map key is itself the primary key or a persistent field or property of the entity that is the value of the map.
MapKeyClass:- Specifies the type of the map key for associations of type java.util.Map.
MapKeyColumn:- Specifies the mapping for the key column of a map whose map key is a basic type.
MapKeyEnumerated:- Specifies the enum type for a map key whose basic type is an enumerated type.
MapKeyJoinColumn:- Specifies a mapping to an entity that is a map key.
MapKeyJoinColumns:- Supports composite map keys that reference entities.
MapKeyTemporal:- This annotation must be specified for persistent map keys of type Date and Calendar.
MappedSuperclass:- Designates a class whose mapping information is applied to the entities that inherit from it.
MapsId:- Designates a ManyToOne or OneToOne relationship attribute that provides the mapping for an EmbeddedId primary key, an attribute within an EmbeddedId primary key, or a simple primary key of the parent entity.
NamedAttributeNode:- A NamedAttributeNode is a member element of a NamedEntityGraph.
NamedEntityGraph:- Used to specify the path and boundaries for a find operation or query.
NamedEntityGraphs:- Used to group NamedEntityGraph annotations.
NamedNativeQueries:- Specifies multiple native SQL named queries.
NamedNativeQuery:- Specifies a named native SQL query.
NamedQueries:- Specifies multiple named Jakarta Persistence query language queries.
NamedQuery:- Specifies a static, named query in the Jakarta Persistence query language.
NamedStoredProcedureQueries:- Specifies multiple named stored procedure queries.
NamedStoredProcedureQuery:- Specifies and names a stored procedure, its parameters, and its result type.
NamedSubgraph:- A NamedSubgraph is a member element of a NamedEntityGraph.
@OneToMany:- Specifies a many-valued association with one-to-many multiplicity.
@OneToOne:- Specifies a single-valued association to another entity that has one-to-one multiplicity.
@OrderBy:- Specifies the ordering of the elements of a collection valued association or element collection at the point when the association or collection is retrieved.
@OrderColumn:- Specifies a column that is used to maintain the persistent order of a list.
PersistenceContext:- Expresses a dependency on a container-managed EntityManager and its associated persistence context.
PersistenceContexts:- Declares one or more PersistenceContext annotations.
PersistenceProperty:- Describes a single container or persistence provider property.
PersistenceUnit:- Expresses a dependency on an EntityManagerFactory and its associated persistence unit.
PersistenceUnits:- Declares one or more PersistenceUnit annotations.
PostLoad:- Specifies a callback method for the corresponding lifecycle event.
PostPersist:- Specifies a callback method for the corresponding lifecycle event.
PostRemove:- Specifies a callback method for the corresponding lifecycle event.
PostUpdate:- Specifies a callback method for the corresponding lifecycle event.
PrePersist:- Specifies a callback method for the corresponding lifecycle event.
PreRemove:- Specifies a callback method for the corresponding lifecycle event.
PreUpdate:- Specifies a callback method for the corresponding lifecycle event.
PrimaryKeyJoinColumn:- Specifies a primary key column that is used as a foreign key to join to another table.
PrimaryKeyJoinColumns:- Groups PrimaryKeyJoinColumn annotations.
QueryHint:- Used to supply a query property or hint to the NamedQuery or NamedNativeQuery annotation.
SecondaryTable:- Specifies a secondary table for the annotated entity class.
SecondaryTables:- Specifies multiple secondary tables for an entity.
SequenceGenerator:- Defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation.
SqlResultSetMapping:- Specifies the mapping of the result of a native SQL query or stored procedure.
SqlResultSetMappings:- Is used to define one or more SqlResultSetMapping annotations.
StoredProcedureParameter:- Specifies a parameter of a named stored procedure query.
TableGenerator:- Defines a primary key generator that may be referenced by name when a generator element is specified for the GeneratedValue annotation.
TableGenerators:- Used to group TableGenerator annotations.
Temporal:- This annotation must be specified for persistent fields or properties of type java.util.Date and java.util.Calendar.
Transient:- Specifies that the property or field is not persistent.
Version:- Specifies the version field or property of an entity class that serves as its optimistic lock value.

Generation strategy of key

1. GenerationType.AUTO -  Default generation type and lets the persistence provider choose the generation strategy.If you use Hibernate as persistence provider,it selects a generation strategy based on database-specific dialect.Most popular database uses GenerationType.SEQUENCE
2. GenerationType.IDENTITY - It relies on auto-incremented database column and lets database generate new value with each insert operation.Not good for JDBC batch operations.
3. GenerationType.SEQUENCE - Is used to generate primary key values and uses a database sequence to generate unique values.It requires additional select statements to get next value from a database sequence,but this has no performance impact on most applications.
  The @SequenceGenerator lets you define the name of generator and schema of db sequence and allocation size.
4. GenerationType.TABLE - Rarely used nowadays

```java
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="product_generator")
@SequenceGenerator(name ="product_generator",sequenceName="product_sequence_name",allocationSize=1)
```

Example:-

```java
@Entity
@Table(name= "products", schema = "ecommerce", uniqueConstraints={@UniqueConstraint=(name="cln_unique",columnNames="email"),@UniqueConstraint=(name="cln_unique",columnNames="pass")})
public class Product{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String email
   @Column(name="pass", nullable = false)
   private String password
}
```

## Why Use JPA Annotations and Not Hibernate Annotations?

In modern applications, it's a best practice to use JPA annotations rather than Hibernate-specific annotations because:

Portability: JPA annotations are part of the Java EE specification and are therefore standardized. By using JPA, your code can run with any JPA-compliant provider (e.g., Hibernate, EclipseLink, or OpenJPA). If you use Hibernate-specific annotations, your code becomes tightly coupled to Hibernate, making it harder to switch to another ORM provider if needed.

Abstraction: JPA provides a level of abstraction over the underlying ORM implementation. When you use JPA annotations, your code is less dependent on the specific ORM framework you're using (in this case, Hibernate). The goal is to write portable, standard code that follows JPA rules, while Hibernate simply implements these rules behind the scenes.

Spring's Choice: In a Spring application, especially with Spring Data JPA, you typically don't need to worry about the underlying ORM provider (like Hibernate) because Spring abstracts that away. You only need to use the JPA annotations, and Spring Data will use the configured JPA provider (which can be Hibernate by default) to handle the actual database interactions.
