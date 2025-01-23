# Spring data jpa

Spring Data JPA in a traditional Spring application, without the auto-configuration features of Spring Boot. In this case, the setup requires some manual configuration, but you still get the power of Spring Data JPA for repository management.

Spring Configuration (applicationContext.xml)

For traditional Spring (non-Boot) projects, you will need to configure your data source, JPA entity manager factory, and transaction manager in your Spring XML configuration file (applicationContext.xml).

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
                           http://www.springframework.org/schema/jpa
                           http://www.springframework.org/schema/jpa/spring-jpa-2.0.xsd">

    <!-- DataSource configuration -->
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/my_database" />
        <property name="username" value="root" />
        <property name="password" value="password" />
    </bean>

    <!-- EntityManagerFactory configuration -->
    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="packagesToScan" value="com.example.domain" />
        <property name="jpaVendorAdapter">
            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter">
                <property name="showSql" value="true" />
                <property name="generateDdl" value="true" />
            </bean>
        </property>
    </bean>

    <!-- Transaction Manager configuration -->
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory" />
    </bean>

    <!-- Enable JPA repositories -->
    <context:component-scan base-package="com.example.repository" />
</beans>

    dataSource: Configures the database connection.
    entityManagerFactory: Configures the JPA EntityManager to manage entities.
    transactionManager: Manages JPA transactions.
    