# Java EE

Java Platform, Enterprise Edition (Java EE) is the standard in community-driven enterprise software. Java EE is developed using the Java Community Process, with contributions from industry experts, commercial and open source organizations, Java User Groups, and countless individuals.

Java EE platform is designed to help developers create large-scale, multi-tiered, scalable, reliable, and secure network applications i.e `enterprise applications`, so called because these applications are designed to solve the problems encountered by large enterprises. Enterprise applications are not only useful for large corporations, agencies, and governments, however. The benefits of an enterprise application are helpful, even essential, for individual developers and small organizations in an increasingly networked world.

The aim of the Java EE platform is to provide developers with a powerful set of APIs while shortening development time, reducing application complexity, and improving application performance.

The Java EE platform is developed through the Java Community Process (JCP), which is responsible for all Java technologies. Expert groups composed of interested parties have created Java Specification Requests (JSRs) to define the various Java EE technologies. The work of the Java Community under the JCP program helps to ensure Java technology’s standards of stability and cross-platform compatibility.

The Java EE platform uses a simplified programming model, XML deployment descriptors are optional. Instead, a developer can simply enter the information as an annotation directly into a Java source file, and the Java EE server will configure the component at deployment and runtime. These annotations are generally used to embed in a program data that would otherwise be furnished in a deployment descriptor. With annotations, you put the specification information in your code next to the program element affected.

In the Java EE platform, dependency injection can be applied to all resources a component needs, effectively hiding the creation and lookup of resources from application code. Dependency injection can be used in Enterprise JavaBeans (EJB) containers, web containers, and application clients. Dependency injection allows the Java EE container to automatically insert references to other required components or resources, using annotations.

J2EE: Servlet,JSP,RMI,EJB

## Java EE APIs

* `Enterprise JavaBeans Technology`:- An Enterprise JavaBeans (EJB) component, or enterprise bean, is a body of code that has fields and methods to implement modules of business logic. You can think of an enterprise bean as a building block that can be used alone or with other enterprise beans to execute business logic on the Java EE server.

Enterprise beans are either session beans or message-driven beans.

1. A session bean represents a transient conversation with a client. When the client finishes executing, the session bean and its data are gone.
2. A message-driven bean combines features of a session bean and a message listener, allowing a business component to receive messages asynchronously. Commonly, these are Java Message Service (JMS) messages.

The Java EE 8 platform requires Enterprise JavaBeans 3.2 and Interceptors 1.2. The Interceptors specification is part of the EJB specification.

* `Java Servlet Technology`:- Java Servlet technology lets you define HTTP-specific servlet classes. A servlet class extends the capabilities of servers that host applications accessed by way of a request-response programming model. Although servlets can respond to any type of request, they are commonly used to extend the applications hosted by web servers.

In the Java EE 8 platform, new Java Servlet technology features include the following:

1. Server Push
2. HTTP Trailer

The Java EE 8 platform requires Servlet 4.0

* `JavaServer Faces Technology`:- JavaServer Faces technology is a user interface framework for building web applications. The main components of JavaServer Faces technology are as follows:

1. A GUI component framework.
2. A flexible model for rendering components in different kinds of HTML or different markup languages and technologies. A Renderer object generates the markup to render the component and converts the data stored in a model object to types that can be represented in a view.
3. A standard RenderKit for generating HTML 4.01 markup.

The following features support the GUI components:

1. Input validation
2. Event handling
3. Data conversion between model objects and components
4. Managed model object creation
5. Page navigation configuration
6. Expression Language (EL)

All this functionality is available using standard Java APIs and XML-based configuration files.

In the Java EE 8 platform, new features of JavaServer Faces technology include the following:

* Direct support for WebSockets via the new <f:websocket> tag
* Class-level bean validation via the new <f:validateWholeBean> tag
* A CDI-compatible @ManagedProperty annotation
* Enhanced component search expression framework

The Java EE 8 platform requires JavaServer Faces 2.3 and Expression Language 3.0.

* `JavaServer Pages Technology`:- JavaServer Pages (JSP) technology lets you put snippets of servlet code directly into a text-based document. A JSP page is a text-based document that contains two types of text:

1. Static data, which can be expressed in any text-based format, such as HTML or XML
2. JSP elements, which determine how the page constructs dynamic content

The Java EE 8 platform requires JavaServer Pages 2.3 for compatibility with earlier releases but recommends the use of Facelets as the display technology in new applications.

* `JavaServer Pages Standard Tag Library`:- The JavaServer Pages Standard Tag Library (JSTL) encapsulates core functionality common to many JSP applications. Instead of mixing tags from numerous vendors in your JSP applications, you use a single, standard set of tags. This standardization allows you to deploy your applications on any JSP container that supports JSTL and makes it more likely that the implementation of the tags is optimized.

JSTL has iterator and conditional tags for handling flow control, tags for manipulating XML documents, internationalization tags, tags for accessing databases using SQL, and tags for commonly used functions.

The Java EE 8 platform requires JSTL 1.2.

* `Java Persistence API`:- The Java Persistence API (JPA) is a Java standards–based solution for persistence. Persistence uses an object/relational mapping approach to bridge the gap between an object-oriented model and a relational database. The Java Persistence API can also be used in Java SE applications outside of the Java EE environment. Java Persistence consists of the following areas:

1. The Java Persistence API
2. The query language
3. Object/relational mapping metadata

The Java EE 8 platform requires Java Persistence API 2.2.

* `Java Transaction API`:- The Java Transaction API (JTA) provides a standard interface for demarcating transactions. The Java EE architecture provides a default auto commit to handle transaction commits and rollbacks. An auto commit means that any other applications that are viewing data will see the updated data after each database read or write operation. However, if your application performs two separate database access operations that depend on each other, you will want to use the JTA API to demarcate where the entire transaction, including both operations, begins, rolls back, and commits.

The Java EE 8 platform requires Java Transaction API 1.2.

* `Java API for RESTful Web Services`:- The Java API for RESTful Web Services (JAX-RS) defines APIs for the development of web services built according to the Representational State Transfer (REST) architectural style. A JAX-RS application is a web application that consists of classes packaged as a servlet in a WAR file along with required libraries.

In the Java EE 8 platform, new RESTful web services features include the following:

1. Reactive Client API
2. When the results of an invocation on a target resource are received, enhancements to the completion stage APIs in Java SE allow the sequence of those results to be specified, prioritized, combined, or concatenated, and how exceptions can be handled.
3. Enhancements in support for server-sent events
4. Clients may subscribe to server-issued event notifications using a long-running connection. Support for a new media type, text/event-stream, has been added.
5. Support for JSON-B objects, and improved integration with CDI, Servlet, and Bean Validation technologies

The Java EE 8 platform requires JAX-RS 2.1.

* `Managed Beans`:- Managed Beans, lightweight container-managed objects (POJOs) with minimal requirements, support a small set of basic services, such as resource injection, lifecycle callbacks, and interceptors. Managed Beans represent a generalization of the managed beans specified by JavaServer Faces technology and can be used anywhere in a Java EE application, not just in web modules.

The Managed Beans specification is part of the Java EE 8 platform specification (JSR 366). The Java EE 8 platform requires Managed Beans 1.0.

* `Contexts and Dependency Injection for Java EE`:- Contexts and Dependency Injection for Java EE (CDI) defines a set of contextual services, provided by Java EE containers, that make it easy for developers to use enterprise beans along with JavaServer Faces technology in web applications. Designed for use with stateful objects, CDI also has many broader uses, allowing developers a great deal of flexibility to integrate different kinds of components in a loosely coupled but typesafe way.

In the Java EE 8 platform, new CDI features include the following:

1. An API for bootstrapping a CDI container in Java SE 8
2. Support for observer ordering, which determines the order in which the observer methods for a particular event are invoked, and support for firing events asynchronously
3. Configurators interfaces, which are used for dynamically defining and modifying CDI objects
4. Built-in annotation literals, a convenience feature for creating instances of annotations, and more

The Java EE 8 platform requires CDI 2.0.

* `Dependency Injection for Java`:- Dependency Injection for Java defines a standard set of annotations (and one interface) for use on injectable classes.
In the Java EE platform, CDI provides support for Dependency Injection. Specifically, you can use injection points only in a CDI-enabled application.

The Java EE 8 platform requires Dependency Injection for Java 1.0.

* `Bean Validation`:- The Bean Validation specification defines a metadata model and API for validating data in JavaBeans components. Instead of distributing validation of data over several layers, such as the browser and the server side, you can define the validation constraints in one place and share them across the different layers.

In the Java EE 8 platform, new Bean Validation features include the following:

1. Support for new features in Java SE 8, such as the Date-Time API
2. Addition of new built-in Bean Validation constraints

The Java EE 8 platform requires Bean Validation 2.0.

* `Java Message Service API`:- The Java Message Service (JMS) API is a messaging standard that allows Java EE application components to create, send, receive, and read messages. It enables distributed communication that is loosely coupled, reliable, and asynchronous.

The Java EE 8 platform requires JMS 2.0.

* `Java EE Connector Architecture`:- The Java EE Connector Architecture is used by tools vendors and system integrators to create resource adapters that support access to enterprise information systems that can be plugged in to any Java EE product. A resource adapter is a software component that allows Java EE application components to access and interact with the underlying resource manager of the EIS. Because a resource adapter is specific to its resource manager, a different resource adapter typically exists for each type of database or enterprise information system.

The Java EE Connector Architecture also provides a performance-oriented, secure, scalable, and message-based transactional integration of Java EE platform–based web services with existing EISs that can be either synchronous or asynchronous. Existing applications and EISs integrated through the Java EE Connector Architecture into the Java EE platform can be exposed as XML-based web services by using JAX-WS and Java EE component models. Thus JAX-WS and the Java EE Connector Architecture are complementary technologies for enterprise application integration (EAI) and end-to-end business integration.

The Java EE 8 platform requires Java EE Connector Architecture 1.7.

* `JavaMail API`:- Java EE applications use the JavaMail API to send email notifications. The JavaMail API has two parts:

1. An application-level interface used by the application components to send mail
2. A service provider interface

The Java EE platform includes the JavaMail API with a service provider that allows application components to send Internet mail.

The Java EE 8 platform requires JavaMail 1.6.

* `Java Authorization Contract for Containers`:- The Java Authorization Contract for Containers (JACC) specification defines a contract between a Java EE application server and an authorization policy provider. All Java EE containers support this contract.

The JACC specification defines java.security.Permission classes that satisfy the Java EE authorization model. The specification defines the binding of container-access decisions to operations on instances of these permission classes. It defines the semantics of policy providers that use the new permission classes to address the authorization requirements of the Java EE platform, including the definition and use of roles.

The Java EE 8 platform requires JACC 1.5.

* `Java Authentication Service Provider Interface for Containers`:- The Java Authentication Service Provider Interface for Containers (JASPIC) specification defines a service provider interface (SPI) by which authentication providers that implement message authentication mechanisms may be integrated in client or server message-processing containers or runtimes. Authentication providers integrated through this interface operate on network messages provided to them by their calling containers. The authentication providers transform outgoing messages so that the source of each message can be authenticated by the receiving container, and the recipient of the message can be authenticated by the message sender. Authentication providers authenticate each incoming message and return to their calling containers the identity established as a result of the message authentication.

The Java EE 8 platform requires JASPIC 1.1.

* `Java EE Security API`:- The Java EE Security API specification defines portable, plug-in interfaces for HTTP authentication and identity stores, and an injectable SecurityContext interface that provides an API for programmatic security.

Implementations of the HttpAuthenticationMechanism interface can be used to authenticate callers of web applications. An application can supply its own HttpAuthenticationMechanism, or use one of the default implementations provided by the container.

Implementations of the IdentityStore interface can be used to validate user credentials and retrieve group information. An application can provide its own IdentityStore, or use the built in LDAP or Database store.

The HttpAuthenticationMechanism and IdentityStore APIs provide an advantage over container-provided implementations in that they allow an application to control the authentication process, and the identity stores used for authentication, in a standard, portable way.

The SecurityContext API is intended for use by application code to query and interact with the current security context. The specification also provides for default group-to-role mapping, and defines a principal type called CallerPrincipal that can represent the identity of an application caller.

The Java EE 8 platform requires Java EE Security API 1.0.

* `Java API for WebSocket`:- WebSocket is an application protocol that provides full-duplex communications between two peers over TCP. The Java API for WebSocket enables Java EE applications to create endpoints using annotations that specify the configuration parameters of the endpoint and designate its lifecycle callback methods.

The Java EE 8 platform requires Java API for WebSocket 1.1.

* `Java API for JSON Processing`:- JavaScript Object Notation (JSON) is a text-based data exchange format derived from JavaScript that is used in web services and other connected applications. The Java API for JSON Processing (JSON-P) enables Java EE applications to parse, transform, and query JSON data using the object model or the streaming model.

In the Java EE 8 platform, new features of JSON-P include support for the following:

1. JSON Pointer-Defines a string syntax for referencing a specific value within a JSON document. JSON Pointer includes APIs for extracting values from a target document and transforming them to create a new JSON document.
2. JSON Patch-Defines a format for expressing a sequence of operations to be applied to a JSON document.
3. JSON Merge Patch-Defines a format and processing rules for applying operations to a JSON document that are based upon specific content of the target document.
4. The addition of editing and transformation functions to basic JSON document processing.
5. Helper classes and methods, called JSON Collectors, which leverage features of the Stream API that was introduced in Java SE 8.

The Java EE 8 platform requires JSON-P 1.1.

* `Java API for JSON Binding`:- The Java API for JSON Binding (JSON-B) provides a binding layer for converting Java objects to and from JSON messages. JSON-B also supports the ability to customize the default mapping process used in this binding layer through the use of Java annotations for a given field, JavaBean property, type or package, or by providing an implementation of a property naming strategy.

JSON-B is new to the Java EE 8 platform. The Java EE 8 platform requires JSON-B 1.0.

* `Concurrency Utilities for Java EE`:- Concurrency Utilities for Java EE is a standard API for providing asynchronous capabilities to Java EE application components through the following types of objects: managed executor service, managed scheduled executor service, managed thread factory, and context service.

The Java EE 8 platform requires Concurrency Utilities for Java EE 1.0.

* `Batch Applications for the Java Platform`:- Batch jobs are tasks that can be executed without user interaction. The Batch Applications for the Java Platform specification is a batch framework that provides support for creating and running batch jobs in Java applications. The batch framework consists of a batch runtime, a job specification language based on XML, a Java API to interact with the batch runtime, and a Java API to implement batch artifacts.

* `JAX-WS`(SOAP Web Services)

## Java EE 8 APIs in the Java Platform, Standard Edition 8

Several APIs that are required by the Java EE 8 platform are included in the Java Platform, Standard Edition 8 (Java SE 8) and are thus available to Java EE applications.

* `Java Database Connectivity API`:- The Java Database Connectivity (JDBC) API lets you invoke SQL commands from Java programming language methods. You use the JDBC API in an enterprise bean when you have a session bean access the database. You can also use the JDBC API from a servlet or a JSP page to access the database directly without going through an enterprise bean.

The JDBC API has two parts:

1. An application-level interface used by the application components to access a database
2. A service provider interface to attach a JDBC driver to the Java EE platform

The Java EE 8 platform requires JDBC 4.1.

* `Java Naming and Directory Interface API`:- The Java Naming and Directory Interface (JNDI) API provides naming and directory functionality, enabling applications to access multiple naming and directory services, such as LDAP, DNS, and NIS. The JNDI API provides applications with methods for performing standard directory operations, such as associating attributes with objects and searching for objects using their attributes. Using JNDI, a Java EE application can store and retrieve any type of named Java object, allowing Java EE applications to coexist with many legacy applications and systems.

Java EE naming services provide application clients, enterprise beans, and web components with access to a JNDI naming environment. A naming environment allows a component to be customized without the need to access or change the component’s source code. A container implements the component’s environment and provides it to the component as a JNDI naming context.

The naming environment provides four logical namespaces: java:comp, java:module, java:app, and java:global for objects available to components, modules, or applications or shared by all deployed applications. A Java EE component can access named system-provided and user-defined objects. The names of some system-provided objects, such as a default JDBC DataSource object, a default JMS connection factory, and a JTA UserTransaction object, are stored in the java:comp namespace. The Java EE platform allows a component to name user-defined objects, such as enterprise beans, environment entries, JDBC DataSource objects, and messaging destinations.

A Java EE component can also locate its environment naming context by using JNDI interfaces. A component can create a javax.naming.InitialContext object and look up the environment naming context in InitialContext under the name java:comp/env. A component’s naming environment is stored directly in the environment naming context or in any of its direct or indirect subcontexts.

* `JavaBeans Activation Framework`:- The JavaBeans Activation Framework (JAF) is used by the JavaMail API. JAF provides standard services to determine the type of an arbitrary piece of data, encapsulate access to it, discover the operations available on it, and create the appropriate JavaBeans component to perform those operations.

* `Java API for XML Processing`:- The Java API for XML Processing (JAXP), part of the Java SE platform, supports the processing of XML documents using Document Object Model (DOM), Simple API for XML (SAX), and Extensible Stylesheet Language Transformations (XSLT). JAXP enables applications to parse and transform XML documents independently of a particular XML-processing implementation.

JAXP also provides namespace support, which lets you work with schemas that might otherwise have naming conflicts. Designed to be flexible, JAXP lets you use any XML-compliant parser or XSL processor from within your application and supports the Worldwide Web Consortium (W3C) schema. You can find information on the W3C schema at <http://www.w3.org/XML/Schema.>

* `Java Architecture for XML Binding`:- The Java Architecture for XML Binding (JAXB) provides a convenient way to bind an XML schema to a representation in Java language programs. JAXB can be used independently or in combination with JAX-WS, in which case it provides a standard data binding for web service messages. All Java EE application client containers, web containers, and EJB containers support the JAXB API.

The Java EE 8 platform requires JAXB 2.2.

* `Java API for XML Web Services`:- The Java API for XML Web Services (JAX-WS) specification provides support for web services that use the JAXB API for binding XML data to Java objects. The JAX-WS specification defines client APIs for accessing web services as well as techniques for implementing web service endpoints. The Implementing Enterprise Web Services specification describes the deployment of JAX-WS-based services and clients. The EJB and Java Servlet specifications also describe aspects of such deployment. JAX-WS-based applications can be deployed using any of these deployment models.

The JAX-WS specification describes the support for message handlers that can process message requests and responses. In general, these message handlers execute in the same container and with the same privileges and execution context as the JAX-WS client or endpoint component with which they are associated. These message handlers have access to the same JNDI namespace as their associated component. Custom serializers and deserializers, if supported, are treated in the same way as message handlers.

The Java EE 8 platform requires JAX-WS 2.2.

* `SOAP with Attachments API for Java`:- The SOAP with Attachments API for Java (SAAJ) is a low-level API on which JAX-WS depends. SAAJ enables the production and consumption of messages that conform to the SOAP 1.1 and 1.2 specifications and the SOAP with Attachments note. Most developers do not use the SAAJ API, instead using the higher-level JAX-WS API.

Java Authentication and Authorization Service

The Java Authentication and Authorization Service (JAAS) provides a way for a Java EE application to authenticate and authorize a specific user or group of users to run it.

JAAS is a Java programming language version of the standard Pluggable Authentication Module (PAM) framework, which extends the Java platform security architecture to support user-based authorization.

* `Common Annotations for the Java Platform`:- Annotations enable a declarative style of programming in the Java platform.

The Java EE 8 platform requires Common Annotations for the Java Platform 1.2.

## Tiered Applications

In a multi-tiered application, the functionality of the application is separated into isolated functional areas, called tiers. Typically, multi-tiered applications have a client tier, a middle tier, and a data tier (often called the enterprise information systems tier). The client tier consists of a client program that makes requests to the middle tier. The middle tier is divided into a web tier and a business tier, which handle client requests and process application data, storing it in a permanent data store in the data tier.

Java EE application development concentrates on the middle tier to make enterprise application management easier, more robust, and more secure.

* The Client Tier -Consists of application clients that access a Java EE server and that are usually located on a different machine from the server. The clients make requests to the server. The server processes the requests and returns a response back to the client. Many different types of applications can be Java EE clients, and they are not always, or even often, Java applications. Clients can be a web browser, a standalone application, or other servers, and they run on a different machine from the Java EE server.

* The Web Tier-Consists of components that handle the interaction between clients and the business tier. Its primary tasks are the following:

1. Dynamically generate content in various formats for the client
2. Collect input from users of the client interface and return appropriate results from the components in the business tier
3. Control the flow of screens or pages on the client
4. Maintain the state of data for a user’s session
5. Perform some basic logic and hold some data temporarily in managed beans

* Web-Tier Java EE Technologies
  1. JavaServer Faces technology- A user interface component framework for web applications that allows you to include UI components (such as fields and buttons) on a XHTML page, called a Facelets page; convert and validate UI component data; save UI component data to server-side data stores; and maintain component state
  2. Expression Language-A set of standard tags used in Facelets pages to refer to Java EE components
  3. Servlets-Java programming language classes that dynamically process requests and construct responses, usually for HTML pages
  4. Contexts and Dependency Injection for Java EE-A set of contextual services that make it easy for developers to use enterprise beans along with JavaServer Faces technology in web applications

* The Business Tier-Consists of components that provide the business logic for an application. Business logic is code that provides functionality to a particular business domain, like the financial industry, or an e-commerce site. In a properly designed enterprise application, the core functionality exists in the business tier components.
The following Java EE technologies are among those that are used in the business tier in Java EE applications:
  1. Enterprise JavaBeans (enterprise bean) components
  2. JAX-RS RESTful web services

* Java Persistence API entities:- The Enterprise Information Systems Tier(EIS) -Consists of database servers, enterprise resource planning systems, and other legacy data sources, like mainframes. These resources typically are located on a separate machine from the Java EE server, and are accessed by components on the business tier.
The following Java EE technologies are used to access the EIS tier in Java EE applications:
  1. The Java Database Connectivity API (JDBC)
  2. The Java Persistence API
  3. The Java EE Connector Architecture
  4. The Java Transaction API (JTA)

## Java EE Servers and Containers

A Java EE server is a server application that implements the Java EE platform APIs and provides standard Java EE services. Java EE servers are sometimes called application servers, because they allow you to serve application data to clients, much as web servers serve web pages to web browsers.

Java EE servers host several application component types that correspond to the tiers in a multitiered application. The Java EE server provides services to these components in the form of a container.

Java EE containers are the interface between the component and the lower-level functionality provided by the platform to support that component. The functionality of the container is defined by the platform and is different for each component type. Nonetheless, the server allows the different component types to work together to provide functionality in an enterprise application.

The Web Container-The web container is the interface between web components and the web server. A web component can be a servlet or a JavaServer Faces Facelets page. The container manages the component’s life cycle, dispatches requests to application components, and provides interfaces to context data, such as information about the current request.

The EJB Container-The EJB container is the interface between enterprise beans, which provide the business logic in a Java EE application, and the Java EE server. The EJB container runs on the Java EE server and manages the execution of an application’s enterprise beans.

The Application Client Container-The application client container is the interface between Java EE application clients (special Java SE applications that use Java EE server components) and the Java EE server. The application client container runs on the client machine and is the gateway between the client application and the Java EE server components that the client uses.

## Directory Structure

To facilitate iterative development and keep application source files separate from compiled files, the tutorial examples use the Maven application directory structure.

Each application module has the following structure:

    pom.xml: Maven build file

    src/main/java: Java source files for the module

    src/main/resources: configuration files for the module, with the exception of web applications

    src/main/webapp: web pages, style sheets, tag files, and images (web applications only)

    src/main/webapp/WEB-INF: configuration files for web applications (web applications only)

## Java EE Containers

Normally, thin-client multitiered applications are hard to write because they involve many lines of intricate code to handle transaction and state management, multithreading, resource pooling, and other complex low-level details. The component-based and platform-independent Java EE architecture makes applications easy to write because business logic is organized into reusable components. In addition, the Java EE server provides underlying services in the form of a container for every component type. Because you do not have to develop these services yourself, you are free to concentrate on solving the business problem at hand.

Container Services

Containers are the interface between a component and the low-level, platform-specific functionality that supports the component. Before it can be executed, a web, enterprise bean, or application client component must be assembled into a Java EE module and deployed into its container.

The assembly process involves specifying container settings for each component in the Java EE application and for the Java EE application itself. Container settings customize the underlying support provided by the Java EE server, including such services as security, transaction management, Java Naming and Directory Interface (JNDI) API lookups, and remote connectivity. Here are some of the highlights.

    The Java EE security model lets you configure a web component or enterprise bean so that system resources are accessed only by authorized users.

    The Java EE transaction model lets you specify relationships among methods that make up a single transaction so that all methods in one transaction are treated as a single unit.

    JNDI lookup services provide a unified interface to multiple naming and directory services in the enterprise so that application components can access these services.

    The Java EE remote connectivity model manages low-level communications between clients and enterprise beans. After an enterprise bean is created, a client invokes methods on it as if it were in the same virtual machine.

Because the Java EE architecture provides configurable services, components within the same application can behave differently based on where they are deployed. For example, an enterprise bean can have security settings that allow it a certain level of access to database data in one production environment and another level of database access in another production environment.

The container also manages nonconfigurable services, such as enterprise bean and servlet lifecycles, database connection resource pooling, data persistence, and access to the Java EE platform APIs (see Java EE 8 APIs).

Container Types - The deployment process installs Java EE application components in the Java EE containers

The server and containers are as follows:

1. Java EE server: The runtime portion of a Java EE product. A Java EE server provides EJB and web containers.
2. EJB container: Manages the execution of enterprise beans for Java EE applications. Enterprise beans and their container run on the Java EE server.
3. Web container: Manages the execution of web pages, servlets, and some EJB components for Java EE applications. Web components and their container run on the Java EE server.
4. Application client container: Manages the execution of application client components. Application clients and their container run on the client.
5. Applet container: Manages the execution of applets. Consists of a web browser and a Java Plug-in running on the client together.

## Java EE Application Model

The Java EE application model begins with the Java programming language and the Java virtual machine. The proven portability, security, and developer productivity they provide forms the basis of the application model. Java EE is designed to support applications that implement enterprise services for customers, employees, suppliers, partners, and others who make demands on or contributions to the enterprise. Such applications are inherently complex, potentially accessing data from a variety of sources and distributing applications to a variety of clients.

To better control and manage these applications, the business functions to support these various users are conducted in the middle tier. The middle tier represents an environment that is closely controlled by an enterprise’s information technology department. The middle tier is typically run on dedicated server hardware and has access to the full services of the enterprise.

The Java EE application model defines an architecture for implementing services as multitier applications that deliver the scalability, accessibility, and manageability needed by enterprise-level applications. This model partitions the work needed to implement a multitier service into two parts: the business and presentation logic to be implemented by the developer, and the standard system services provided by the Java EE platform. The developer can rely on the platform to provide solutions for the hard systems-level problems of developing a multitier service.

### Distributed Multitiered Applications

The Java EE platform uses a distributed multitiered application model for enterprise applications. Application logic is divided into components according to function, and the various application components that make up a Java EE application are installed on different machines depending on the tier in the multitiered Java EE environment to which the application component belongs.

1. Client-tier components run on the client machine.
2. Web-tier components run on the Java EE server.
3. Business-tier components run on the Java EE server.
4. Enterprise information system (EIS)-tier software runs on the EIS server.

Although a Java EE application can consist of the three or four tiers,Java EE multitiered applications are generally considered to be three-tiered applications because they are distributed over three locations: client machines, the Java EE server machine, and the database or legacy machines at the back end. Three-tiered applications that run in this way extend the standard two-tiered client and server model by placing a multithreaded application server between the client application and back-end storage.

### Security

While other enterprise application models require platform-specific security measures in each application, the Java EE security environment enables security constraints to be defined at deployment time. The Java EE platform makes applications portable to a wide variety of security implementations by shielding application developers from the complexity of implementing security features.

The Java EE platform provides standard declarative access control rules that are defined by the developer and interpreted when the application is deployed on the server. Java EE also provides standard login mechanisms so application developers do not have to implement these mechanisms in their applications. The same application works in a variety of different security environments without changing the source code.

### Java EE Components

Java EE applications are made up of components. A Java EE component is a self-contained functional software unit that is assembled into a Java EE application with its related classes and files and that communicates with other components.

The Java EE specification defines the following Java EE components:

    Application clients and applets are components that run on the client.

    Java Servlet, JavaServer Faces, and JavaServer Pages (JSP) technology components are web components that run on the server.

    Enterprise JavaBeans (EJB) components (enterprise beans) are business components that run on the server.

Java EE components are written in the Java programming language and are compiled in the same way as any program in the language. The difference between Java EE components and “standard” Java classes is that Java EE components are assembled into a Java EE application, are verified to be well formed and in compliance with the Java EE specification, and are deployed to production, where they are run and managed by the Java EE server.

### Java EE Clients

A Java EE client can be a web client or an application client.
Web Clients

A web client consists of two parts: (1) dynamic web pages containing various types of markup language (HTML, XML, and so on), which are generated by web components running in the web tier, and (2) a web browser, which renders the pages received from the server.

A web client is sometimes called a thin client. Thin clients usually do not query databases, execute complex business rules, or connect to legacy applications. When you use a thin client, such heavyweight operations are off-loaded to enterprise beans executing on the Java EE server, where they can leverage the security, speed, services, and reliability of Java EE server-side technologies.
Applets

A web page received from the web tier can include an embedded applet. An applet is a small client application written in the Java programming language that executes in the Java virtual machine installed in the web browser. However, client systems will likely need the Java Plug-in and possibly a security policy file for the applet to successfully execute in the web browser.

Web components are the preferred API for creating a web client program because no plug-ins or security policy files are needed on the client systems. Also, web components enable cleaner and more modular application design because they provide a way to separate applications programming from web page design. Personnel involved in web page design thus do not need to understand Java programming language syntax to do their jobs.
Application Clients

An application client runs on a client machine and provides a way for users to handle tasks that require a richer user interface than can be provided by a markup language. It typically has a graphical user interface (GUI) created from the Swing or the Abstract Window Toolkit (AWT) API, but a command-line interface is certainly possible.

Application clients directly access enterprise beans running in the business tier. However, if application requirements warrant it, an application client can open an HTTP connection to establish communication with a servlet running in the web tier. Application clients written in languages other than Java can interact with Java EE 5 servers, enabling the Java EE 5 platform to interoperate with legacy systems, clients, and non-Java languages.
The JavaBeans Component Architecture

The server and client tiers might also include components based on the JavaBeans component architecture (JavaBeans components) to manage the data flow between an application client or applet and components running on the Java EE server, or between server components and a database. JavaBeans components are not considered Java EE components by the Java EE specification.

JavaBeans components have properties and have get and set methods for accessing the properties. JavaBeans components used in this way are typically simple in design and implementation but should conform to the naming and design conventions outlined in the JavaBeans component architecture.
Java EE Server Communications

Figure 1-2 shows the various elements that can make up the client tier. The client communicates with the business tier running on the Java EE server either directly or, as in the case of a client running in a browser, by going through JSP pages or servlets running in the web tier.

## Web Components

Java EE web components are either servlets or pages created using JSP technology (JSP pages) and/or JavaServer Faces technology. Servlets are Java programming language classes that dynamically process requests and construct responses. JSP pages are text-based documents that execute as servlets but allow a more natural approach to creating static content. JavaServer Faces technology builds on servlets and JSP technology and provides a user interface component framework for web applications.

Static HTML pages and applets are bundled with web components during application assembly but are not considered web components by the Java EE specification. Server-side utility classes can also be bundled with web components and, like HTML pages, are not considered web components.

### Business Components

Business code, which is logic that solves or meets the needs of a particular business domain such as banking, retail, or finance, is handled by enterprise beans running in the business tier. Figure 1-4 shows how an enterprise bean receives data from client programs, processes it (if necessary), and sends it to the enterprise information system tier for storage. An enterprise bean also retrieves data from storage, processes it (if necessary), and sends it back to the client program.

## Enterprise Information System Tier

The enterprise information system tier handles EIS software and includes enterprise infrastructure systems such as enterprise resource planning (ERP), mainframe transaction processing, database systems, and other legacy information systems. For example, Java EE application components might need access to enterprise information systems for database connectivity.
Previous
