# Enterprise Beans

Enterprise beans are Java EE components that implement `Enterprise JavaBeans (EJB)` technology. 
Enterprise beans run in the `EJB container`, a runtime environment within the Application Server(EJB Container - GlassFish server). Although transparent to the application developer, the EJB container provides system-level services such as transactions and security to its enterprise beans. These services enable you to quickly build and deploy enterprise beans, which form the core of transactional Java EE applications.

`Enterprise Bean` - Written in the Java programming language, an enterprise bean is a server-side component that encapsulates the business logic of an application. The business logic is the code that fulfills the purpose of the application. 

Benefits of Enterprise Beans:-

1. Enterprise beans simplify the development of large, distributed applications because the EJB container provides system-level services to enterprise beans, the bean developer can concentrate on solving business problems. The EJB container, rather than the bean developer, is responsible for system-level services such as transaction management and security authorization.
2. The beans rather than the clients contain the application’s business logic, the client developer can focus on the presentation of the client. The client developer does not have to code the routines that implement business rules or access databases. As a result, the clients are thinner, a benefit that is particularly important for clients that run on small devices.
3. Enterprise beans are portable components, the application assembler can build new applications from existing beans. These applications can run on any compliant Java EE server provided that they use the standard APIs.
When to Use Enterprise Beans

You should consider using enterprise beans if your application has any of the following requirements:

1. The application must be scalable. To accommodate a growing number of users, you may need to distribute an application’s components across multiple machines. Not only can the enterprise beans of an application run on different machines, but also their location will remain transparent to the clients.
2. Transactions must ensure data integrity. Enterprise beans support transactions, the mechanisms that manage the concurrent access of shared objects.
3. The application will have a variety of clients. With only a few lines of code, remote clients can easily locate enterprise beans. These clients can be thin, various, and numerous.

Types of Enterprise Beans

1. Session - Performs a task for a client; optionally may implement a web service
2. Message-Driven - Acts as a listener for a particular messaging type, such as the Java Message Service API

Note - Entity beans have been replaced by Java Persistence API entities.

## Session Bean

A `session bean` encapsulates business logic that can be invoked programmatically by a client over local, remote, or web service client views. To access an application that is deployed on the server, the client invokes the session bean's methods. The session bean performs work for its client, shielding it from complexity by executing business tasks inside the server.

It represents a single client inside the Application Server. To access an application that is deployed on the server, the client invokes the session bean’s methods. The session bean performs work for its client, shielding the client from complexity by executing business tasks inside the server.

A session bean is similar to an interactive session. A session bean is not shared; it can have only one client, in the same way that an interactive session can have only one user. Like an interactive session, a session bean is not persistent. (That is, its data is not saved to a database.) When the client terminates, its session bean appears to terminate and is no longer associated with the client.

A session bean is not persistent. (That is, its data is not saved to a database.)

State Management Modes:- There are three types of session beans: stateful, Singleton and stateless.

1. Stateful Session Beans - The state of an object consists of the values of its instance variables. In a stateful session bean, the instance variables represent the state of a unique client-bean session. Because the client interacts (“talks”) with its bean, this state is often called the conversational state.

The state is retained for the duration of the client-bean session. If the client removes the bean or terminates, the session ends and the state disappears. This transient nature of the state is not a problem, however, because when the conversation between the client and the bean ends there is no need to retain the state.
Stateless Session Beans

2. Singleton: Single shared instance. Used for shared configuration or caching.

3. A stateless session bean does not maintain a conversational state with the client. When a client invokes the methods of a stateless bean, the bean’s instance variables may contain a state specific to that client, but only for the duration of the invocation. When the method is finished, the client-specific state should not be retained. Clients may, however, change the state of instance variables in pooled stateless beans, and this state is held over to the next invocation of the pooled stateless bean. Except during method invocation, all instances of a stateless bean are equivalent, allowing the EJB container to assign an instance to any client. That is, the state of a stateless session bean should apply accross all clients.

Because stateless session beans can support multiple clients, they can offer better scalability for applications that require large numbers of clients. Typically, an application requires fewer stateless session beans than stateful session beans to support the same number of clients.

A stateless session bean can implement a web service, but other types of enterprise beans cannot.

When to Use Session Beans

In general, you should use a session bean if the following circumstances hold:

1. At any given time, only one client has access to the bean instance.
2. The state of the bean is not persistent, existing only for a short period (perhaps a few hours).
3. The bean implements a web service.

Stateful session beans are appropriate if any of the following conditions are true:

1. The bean’s state represents the interaction between the bean and a specific client.
2. The bean needs to hold information about the client across method invocations.
3. The bean mediates between the client and the other components of the application, presenting a simplified view to the client.
4. Behind the scenes, the bean manages the work flow of several enterprise beans.

To improve performance, you might choose a stateless session bean if it has any of these traits:

1. The bean’s state has no data for a specific client.
2. In a single method invocation, the bean performs a generic task for all clients. For example, you might use a stateless session bean to send an email that confirms an online order.

## Message-Driven Bean

A `message-driven bean` is an enterprise bean that allows Java EE applications to process messages asynchronously. It normally acts as a JMS message listener, which is similar to an event listener except that it receives JMS messages instead of events. The messages can be sent by any Java EE component (an application client, another enterprise bean, or a web component) or by a JMS application or system that does not use Java EE technology.Message-driven beans can process JMS messages or other kinds of messages.
