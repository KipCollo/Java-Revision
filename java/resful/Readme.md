# RESTful WebServices

## Distributed Technologies 

An object in one JVM trying to access with another object in another JVM is called **Java Distribute Technologies**.

```                

OBJ 1(JVM3)---------(N/W)-----------------------------> OBJ 2(JVM2)
  |
  |--------------------(N/W)--------> OBJ3(JVM1)

```

Ther are many Java Distributed Tech:
1. EJB
2. RMI
3. Socket Programming
4. Corba

* The drawback for using RMI and EJB is that it only supports JVM(Java) and is limited to only Java programming language.

Java Distributed Technologies--------->java clients only cna access
.NET Distributed Technologies--------->.net clients only cna access

>To overcome the limitation, WEBSERVICES was introduced.

## WebSevices

A web service is a set of open protocols and standards that allow data to be exchanged between different applications or systems. Web services can be used by software programs written in a variety of programming languages and running on a variety of platforms to exchange data via computer networks such as the Internet in a similar way to inter-process communication on a single computer.

Any software, application, or cloud technology that uses standardized web protocols (HTTP or HTTPS) to connect, interoperate, and exchange data messages – commonly XML (Extensible Markup Language) – across the internet is considered a web service.
Web services have the advantage of allowing programs developed in different languages to connect with one another by exchanging data over a web service between clients and servers. A client invokes a web service by submitting an XML request, which the service responds with an XML response.

### Components of Web Service

1. SOAP (Simple Object Access Protocol)

SOAP stands for “Simple Object Access Protocol.” It is a transport-independent messaging protocol. SOAP is built on sending XML data in the form of SOAP Messages. A document known as an XML document is attached to each message. Only the structure of the XML document, not the content, follows a pattern. The best thing about Web services and SOAP is that everything is sent through HTTP, the standard web protocol.

A root element known as the element is required in every SOAP document. In an XML document, the root element is the first element. The “envelope” is separated into two halves. The header comes first, followed by the body. The routing data, or information that directs the XML document to which client it should be sent to, is contained in the header. The real message will be in the body.

2. UDDI (Universal Description, Discovery, and Integration)

UDDI is a standard for specifying, publishing and discovering a service provider’s online services. It provides a specification that aids in the hosting of data via web services. UDDI provides a repository where WSDL files can be hosted so that a client application can discover a WSDL file to learn about the various actions that a web service offers. As a result, the client application will have full access to the UDDI, which serves as a database for all WSDL files.
The UDDI registry will hold the required information for the online service, just like a telephone directory has the name, address, and phone number of a certain individual. So that a client application may figure out where it is.

3. WSDL (Web Services Description Language)

If a web service can’t be found, it can’t be used. The client invoking the web service should be aware of the location of the web service. Second, the client application must understand what the web service does in order to invoke the correct web service. The WSDL, or Web services description language, is used to accomplish this. The WSDL file is another XML-based file that explains what the web service does to the client application. The client application will be able to understand where the web service is located and how to use it by using the WSDL document.


4. REST API

REpresentational State Transfer (REST) is an architectural style that defines a set of constraints to be used for creating web services. REST API is a way of accessing web services in a simple and flexible way without having any processing. 
REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST uses less bandwidth, simple and flexible making it more suitable for internet usage. It’s used to fetch or give some information from a web service. All communication done via REST API uses only HTTP request. 

In HTTP there are five methods that are commonly used in a REST-based Architecture i.e., POST, GET, PUT, PATCH, and DELETE. These correspond to create, read, update, and delete (or CRUD) operations respectively. There are other methods which are less frequently used like OPTIONS and HEAD.


* Web services should have a higher level of security than the Secure Socket Layer (SSL) (SSL). Entrust Secure Transaction Platform is the only way to attain this level of security. This level of security is required for web services in order to assure dependable transactions and secure confidential information.

## JSR 311: JAX-RS: The JavaTM API for RESTful Web Services

This JSR will develop an API for providing support for RESTful(Representational State Transfer) Web Services in the Java Platform. 
