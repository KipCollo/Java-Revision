# Spring Data Jpa

Spring Data JPA is an abstracton layer on top of JPA to reduce the amount of boilerplate code required to implement data eccess object(DAO)

```java
spring.jpa.hibernate.ddl-auto=//create-drop,create,none,update,validate
spring.jpa.database=//database platform postgresql,mysql
spring.jpa.show-sql=//true or false
```

create-drop- Create and then destroythe schema at end of application
create- Create the schema and destroy previous data.
none- Disable DDL handling
update- Update the schema if necessary
validate- Validate the schema, make no changes to the database
