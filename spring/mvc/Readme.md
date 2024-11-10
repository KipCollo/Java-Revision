# Spring MVC

Its a module in sring framework.Spring MVC is used to develop web apps and and distributed applications.

* Web applications-Using servlets and JSPs we can develop web apps but dev has to write lots of boiler-plate codes.Boiler-plate code is code common for all apps.
i.e

1. converting HTTP request params into java bean.Suppose in a project there is 100 servlets rhen we'll need to prepare 100 java Beans.
2. There's mixing of business logic and presentation logics.In servlet class you write both business and presentation logics.

Spring MVC will help remove boilerplate code with help of FrontController(DispatcherServlet).It separates business logic from presentation logics.Its one of Gang of Four design Pattern.It includes 3 design patterns: trategy,Observer and Composite.

* Standalone apps
Creating a container for standalone application:

```java

ApplicationContext context= new ClassPathXmlApplicationContext();
```

The REST capabilities are provided by the Spring MVC module (same module that provides model-view-controller capabilities). It is not a JAX-RS implementation and can be seen as a Spring alternative to the JAX-RS standard.
