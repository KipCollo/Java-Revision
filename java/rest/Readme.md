# RESTful WebServices

## Distributed Technologies

An object in one JVM trying to access with another object in another JVM is called **Java Distribute Technologies**.

OBJ 1(JVM3)---------(N/W)-----------------------------> OBJ 2(JVM2)
  |
  |--------------------(N/W)--------> OBJ3(JVM1)

Ther are many Java Distributed Tech:

1. EJB
2. RMI
3. Socket Programming
4. Corba

* The drawback for using RMI and EJB is that it only supports JVM(Java) and is limited to only Java programming language.

Java Distributed Technologies--------->java clients only can access
.NET Distributed Technologies--------->.net clients only can access

>To overcome the limitation, WEBSERVICES was introduced.

        |------Java request object-------xml----------xml-----------java object request---------|
consumer                                                                                          provider
        |------Java response object------xml-----------xml---------java object response---------|

1. For every request--consumer end req object is converted to xml,provider end converts from xml to Java object
2. For every response--consumer end response object is converted to xml,consumer end converts from xml to Java object

## WebSevices

A web service is a set of open protocols and standards that allow data to be exchanged between different applications or systems. Web services can be used by software programs written in a variety of programming languages and running on a variety of platforms to exchange data via computer networks such as the Internet in a similar way to inter-process communication on a single computer.

Any software, application, or cloud technology that uses standardized web protocols (HTTP or HTTPS) to connect, interoperate, and exchange data messages – commonly XML (Extensible Markup Language) – across the internet is considered a web service.
Web services have the advantage of allowing programs developed in different languages to connect with one another by exchanging data over a web service between clients and servers. A client invokes a web service by submitting an XML request, which the service responds with an XML response.

### Components of Web Service

* SOAP (Simple Object Access Protocol)(JAXWS)

SOAP stands for “Simple Object Access Protocol.” It is a transport-independent messaging protocol. SOAP is built on sending XML data in the form of SOAP Messages. A document known as an XML document is attached to each message. Only the structure of the XML document, not the content, follows a pattern. The best thing about Web services and SOAP is that everything is sent through HTTP, the standard web protocol.

A root element known as the element is required in every SOAP document. In an XML document, the root element is the first element. The “envelope” is separated into two halves. The header comes first, followed by the body. The routing data, or information that directs the XML document to which client it should be sent to, is contained in the header. The real message will be in the body.

* UDDI (Universal Description, Discovery, and Integration)

UDDI is a standard for specifying, publishing and discovering a service provider’s online services. It provides a specification that aids in the hosting of data via web services. UDDI provides a repository where WSDL files can be hosted so that a client application can discover a WSDL file to learn about the various actions that a web service offers. As a result, the client application will have full access to the UDDI, which serves as a database for all WSDL files.
The UDDI registry will hold the required information for the online service, just like a telephone directory has the name, address, and phone number of a certain individual. So that a client application may figure out where it is.

* WSDL (Web Services Description Language)

If a web service can’t be found, it can’t be used. The client invoking the web service should be aware of the location of the web service. Second, the client application must understand what the web service does in order to invoke the correct web service. The WSDL, or Web services description language, is used to accomplish this. The WSDL file is another XML-based file that explains what the web service does to the client application. The client application will be able to understand where the web service is located and how to use it by using the WSDL document.

* REST API

REpresentational State Transfer (REST) is an architectural style that defines a set of constraints to be used for creating web services. REST API is a way of accessing web services in a simple and flexible way without having any processing.
REST technology is generally preferred to the more robust Simple Object Access Protocol (SOAP) technology because REST uses less bandwidth, simple and flexible making it more suitable for internet usage. It’s used to fetch or give some information from a web service. All communication done via REST API uses only HTTP request.

In HTTP there are five methods that are commonly used in a REST-based Architecture i.e., POST, GET, PUT, PATCH, and DELETE. These correspond to create, read, update, and delete (or CRUD) operations respectively. There are other methods which are less frequently used like OPTIONS and HEAD.

* What is a resource -Understand resource as the concept of a user. Don't think about the table in your database, think about an abstraction of a user with their set of attributes.
* What is a representation in my example?-A JSON document can be used to represent the state of a particular resource. A resource can have many representations, such as JSON and/or XML documents, and the client can use content negotiation to request different representations of the same resource.
* What is a state transfer or when does this happens in my example?-The state of a given resource can be retrieved and manipulated using representations.

A GET request, for example, allows you to retrieve a representation of the state of a resource, sent in the response payload. A PUT request, for example, allows you to replace the state of a resource with the state defined by the representation enclosed in the request payload.

Consider a user resource with attributes such as id and name stored somehow in your server:

```
ID: 1
Name: John Doe
```

These details make the state of the resource.

A URL such as /users/1 can be used to locate the resource in your server.

Requests such as GET, PUT and DELETE can be performed against this URL to retrieve/manipulate the state of the resource using representations, such as JSON and/or XML documents (other representations can be supported according to your needs):

```json
{
  "id": 1,
  "name": "John Doe"
}
```

```xml
<user>
  <id>1</id>
  <name>John Doe</name>
</user>
```

* Web services should have a higher level of security than the Secure Socket Layer (SSL) (SSL). Entrust Secure Transaction Platform is the only way to attain this level of security. This level of security is required for web services in order to assure dependable transactions and secure confidential information.

soap--->wsdl------xml
rest---->swagger--json/yaml

Old web features included; HTTP,Methods & URL.REST API extended the features and added Resource,URI,Representation,Uniform Interface & HATEOAS

1. Resource- A resource can be any object the API can offer info about.i.e interface,images,file,method & database
2. URI-A Uniform Resource Identifier (URI), formerly Universal Resource Identifier, is a unique sequence of characters that identifies an abstract or physical resource,
such as resources on a webpage, mail address, phone number,books, real-world objects such as people and places, concepts.
3. Representation- client and server exchange representations of a resource, which reflect its current state or its desired state. REST is a way for two machines to transfer the state of a resource via representations.Format request and response data is rep.i.e json,xml,text,html
4. Uniform Interface-
5. HATEOAS-

* When apps follow the above principles;it becomes resful services

When designing REST over HTTP, URLs are used to locate the resources, HTTP methods are used to express the operations over the resources and representations such as JSON and/or XML documents are used to represent the state of the resource. HTTP headers can be used to exchange some metadata about the request and response while HTTP status code are used to inform the client regarding the status of the operation.

* URL-Uniform Resource locator e.g <https://www.collo.com>
* URI -Uniform Resource Identifier e.g <https://www.collo.com/resource1>, <https://www.collo.com/resource1/rest>.It can be one-to-one or many-to-one resource locator.It cant be many-to-one.

## Web service in Java

* REST API(JAXRS and Spring REST)
* SOAP (Simple Object Access Protocol)(JAXWS)
* JAXB - converts object to xml and xml to objects.
* JACKSON- converts object to json and json to objects.

## JSR 311: JAX-RS: The JavaTM API for RESTful Web Services

This JSR will develop an API for providing support for RESTful(Representational State Transfer) Web Services in the Java Platform.

1. Services
2. API's
3. Endpoint url
4. Service userguides

JAX-RS is a specification (which basically tells what to implement/follow) and Jersey is an implementation (which means how those specifications should be implemented).We can have multiple implementations for a Specification. We have libs for JAX-RS because we can use JAX-RS API's in your code so that in future if you change your implementation (in this case Jersey to something else) you code will still work fine.

JAXRS implementations include:

1. Jersey (shipped with GlassFish and Payara)
2. Apache axis2
3. Apache cxf(shipped with TomEE and WebSphere)
4. RESTeasy(shipped with JBoss EAP and WildFly)

### JAX-RS Annotations

1. @Path-It identifies the URI path. It can be specified on class or method.
2. @GET,@PUT,@DELETE,@POST,@HEAD-specifies method responds to GET,PUT,DELETE,POST,HEAD request.
3. @Produces-defines media type for the response such as XML, PLAIN, JSON etc. It defines the media type that the methods of a resource class or MessageBodyWriter can produce.
4. @PathParam-Used to read value from URI path.
5. @Singleton
6. @CookieParam-represents the parameter of the cookie.
7. @BeanParam
8. @FormParam-represents the parameter of the form.
9. @QueryParam-represents the parameter of the query string of an URL.
10. @Headerparam
11. @matrixParam
12. @Consumes-used to specify the MIME media types of representations a resource can consume that were sent by the client.

```java
@Path("/greetings")
public class JaxRsController {

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response greeting(@PathParam("name") String name) {

        String greeting = "Hello " + name;
        return Response.ok(greeting).build();
    }
}
```

Deployment descriptor config

```xml
<web-app>
//jaxrs implementation vendor e.g jersey
//servlet configs

<url-mapping>/order</url-mapping>
</web-app>
```

* Plain Java Rest(JAXRS) is no longer used.Spring Rest is commonly used instead.

## Importance of HTTP in REST

Used to transfer data from client to server.Its stateless protocol.
          HTTP Request
Client--<------------------------>---Server
          HTTP Response

1. HTTP Request Format- Has 3 parts(Request Line,Headers,Body).Request Line includes mathod name and URI.Header include metadata of the request i.e client,user-agent.Body is optional ie Its not in GET methods,required in POST.
2. HTTP Response- Has (Status Line,headers,Body).Status code shows request status.Metadata of response i.e content-length,content-type.Body is mandatory.

example:

GET | /orders | user-agent="mozilla" | No body
POST | /orders/123 | user-agent="mozilla" | ```<order><orderid>1234</orderid><name>Mobile</name></order>```

200 | OK | content-length |```<orderresp><status>Delivered</status></orderrep>```

Reading from HTTP Request - Request Line {Methods(GET for @GET,.etc.) and URI(Extract info from uri @PathParam,@QueryParam,etc)},Headers includes(@HeaderParam-can read only one header at a time,@Context HttpHeaders header-Can read one or more header),Body(Content Handler-Reading from body i.e Predefined- Java.io.File,byte[],jaxb classes,jackson classes.Custom-MessageBodyReader,MessageBodyReader)

HTTP Response- Status Line{Status code-1XX and Message OK},Headers,Body(Content Handler-Custom-MessageBodyReader and MessageBodyWriter.Predefined-jaxb classes,jackson classes,String,java.io.OutputStream).To get only Response body use JAXB or Jackson classes,to get full response use javax.ws.rs.core.Response.Classes

* Use Cases:

1. ONLY GET Services-Reading data from URI using @QueryParam,@PathParam.
2. GET service and Headers-Use @XXXParams and @HeaderParams
3. POST Service-Reading data from body using predefined content handlers or custom handlers
4. POST Service and Headers-Use content handlers and @HeaderParams or @Context HttpHeaders headers

In GET,data is in URI while in POST data is in the body.

## Steps to develop REST api at Provider endPoint

1. Create maven web project
2. add jaxrs vendor dependency in pom.xml
3. Write resources that rep @Path annotation
4. Write subresources rep @Path,@Get,@Produce annotation
5. Write business logic in sub resources
6. Write web.xml-configure servlet
