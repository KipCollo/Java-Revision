# Web Applications

A web application is a dynamic extension of a web or application server.There are two types of web applications:

1. `Presentation-oriented`: A presentation-oriented web application generates interactive web pages containing various types of markup language (HTML, XHTML, XML, and so on) and dynamic content in response to requests. Development of presentation-oriented web applications Internationalizing and Localizing Web Applications, "JavaServer Faces Technology," "Java Servlet Technology."how to develop presentation-oriented web applications.
2. `Service-oriented`: A service-oriented web application implements the endpoint of a web service. Presentation-oriented applications are often clients of service-oriented web applications. Development of service-oriented web applications , "Building Web Services with JAX-WS," "Building RESTful Web Services with JAX-RS," "Web Services."how to develop service-oriented web applications.

* In early days,Java used to make**applets**.These are Java apps that can be downloaded from web site and run within web browser.However,Microsoft Internet Explorer stopped supporting new versions of Java.As result applets lost their appeal and dev switched to servlets and JSPs.These tech allowed devs to write java web apps that run on server.

In the Java 2 platform, web components provide the dynamic extension capabilities for a web  server. Web components are either Java servlets, JSP pages, or web service endpoints. The client sends an HTTP request to the web server. A web server that implements Java Servlet and JavaServer Pages technology converts the request into an HTTPServletRequest object. This object is delivered to a web component, which can interact with JavaBeans components or a database to generate dynamic content. The web component can then generate an HTTPServletResponse or it can pass the request to another web component. Eventually a web component generates a HTTPServletResponse object. The web server converts this object to an HTTP response and returns it to the client.

               1                            2
      |---------------->HttpServletRequest--------->|
Client|                                             | Web Componets------4----->Database
      |<---------------HttpServletResponse<---------|       |
                6                                5          |3
                                                        JavaBeans Component


Servlets are Java programming language classes that dynamically process requests and construct responses. JSP pages are text-based documents that execute as servlets but allow a more natural approach to creating static content. Although servlets and JSP pages can be used interchangeably, each has its own strengths. Servlets are best suited for service-oriented applications (web service endpoints are implemented as servlets) and the control functions of a presentation-oriented application, such as dispatching requests and handling nontextual data. JSP pages are more appropriate for generating text-based markup such as HTML, Scalable Vector Graphics (SVG), Wireless Markup Language (WML), and XML.

Since the introduction of Java Servlet and JSP technology, additional Java technologies and frameworks for building interactive web applications have been developed.This oincludes: JavaServer Faces,JavaServer Pages Standard Tag Library.ava Servlet technology is the foundation of all the web application technologies

Web components are supported by the services of a runtime platform called a web container. A web container provides services such as request dispatching, security, concurrency, and life-cycle management. It also gives web components access to APIs such as naming, transactions, and email.Certain aspects of web application behavior can be configured when the application is installed, or deployed, to the web container. The configuration information is maintained in a text file in XML format called a web application deployment descriptor (DD).

## Components of Java Web App

Client(Browser)<------>[Web Server<---->Servlet/JSP Engine(JDK)<----->Database Server]

To run java app,server must run servlet/JSP engine or servlet/JSP container.It allows web server to run servlets and JSPs.

Java EE specification describes how servlet/JSP engine should interact with web server.Since all Servlet/JSP engines must implement this specification,all servlet/JSPs code works similarly.In theory, this makes servlet/JSPs code portable btwn servlet/JSP engine and web servers.In practise,there are diffs btwn each servlet/JSPs engine and web server.as result you need to make some modifications to your code when switching servlet/JSPs engine or web servers.

In the Java EE platform, web components provide the dynamic extension capabilities for a web server. Web components can be Java servlets, web pages implemented with JavaServer Faces technology, web service endpoints, or JSP pages.

The client sends an HTTP request to the web server. A web server that implements Java Servlet and JavaServer Pages technology converts the request into an HTTPServletRequest object. This object is delivered to a web component, which can interact with JavaBeans components or a database to generate dynamic content. The web component can then generate an HTTPServletResponse or can pass the request to another web component. A web component eventually generates a HTTPServletResponse object. The web server converts this object to an HTTP response and returns it to the client.

Servlets are Java programming language classes that dynamically process requests and construct responses. Java technologies, such as JavaServer Faces and Facelets, are used for building interactive web applications. (Frameworks can also be used for this purpose.) Although servlets and JavaServer Faces and Facelets pages can be used to accomplish similar things, each has its own strengths. Servlets are best suited for service-oriented applications (web service endpoints can be implemented as servlets) and the control functions of a presentation-oriented application, such as dispatching requests and handling nontextual data. JavaServer Faces and Facelets pages are more appropriate for generating text-based markup, such as XHTML, and are generally used for presentation-oriented applications.

Certain aspects of web application behavior can be configured when the application is installed, or deployed, to the web container. The configuration information can be specified using Java EE annotations or can be maintained in a text file in XML format called a web application deployment descriptor (DD). A web application DD must conform to the schema described in the Java Servlet specification.

## Web Application Lifecycle

A web application consists of web components; static resource files, such as images and cascading style sheets (CSS); and helper classes and libraries. The web container provides many supporting services that enhance the capabilities of web components and make them easier to develop. However, because a web application must take these services into account, the process for creating and running a web application is different from that of traditional stand-alone Java classes.

The process for creating, deploying, and executing a web application can be summarized as follows:

1. Develop the web component code.
2. Develop the web application deployment descriptor, if necessary.
3. Compile the web application components and helper classes referenced by the components.
4. Optionally, package the application into a deployable unit.
5. Deploy the application into a web container.
6. Access a URL that references the web application.

## Web Services

Building Web Services with JAX-WS

JAX-WS stands for Java API for XML Web Services. JAX-WS is a technology for building web services and clients that communicate using XML. JAX-WS allows developers to write message-oriented as well as RPC-oriented web services.

In JAX-WS, a web service operation invocation is represented by an XML-based protocol such as SOAP. The SOAP specification defines the envelope structure, encoding rules, and conventions for representing web service invocations and responses. These calls and responses are transmitted as SOAP messages (XML files) over HTTP.

Although SOAP messages are complex, the JAX-WS API hides this complexity from the application developer. On the server side, the developer specifies the web service operations by defining methods in an interface written in the Java programming language. The developer also codes one or more classes that implement those methods. Client programs are also easy to code. A client creates a proxy (a local object representing the service) and then simply invokes methods on the proxy. With JAX-WS, the developer does not generate or parse SOAP messages. It is the JAX-WS runtime system that converts the API calls and responses to and from SOAP messages.

With JAX-WS, clients and web services have a big advantage: the platform independence of the Java programming language. In addition, JAX-WS is not restrictive: a JAX-WS client can access a web service that is not running on the Java platform, and vice versa. This flexibility is possible because JAX-WS uses technologies defined by the World Wide Web Consortium (W3C): HTTP, SOAP, and the Web Service Description Language (WSDL). WSDL specifies an XML format for describing a service as a set of endpoints operating on messages.

### Setting the Port

Several files in the JAX-WS examples depend on the port that you specified when you installed the Application Server. The tutorial examples assume that the server runs on the default port, 8080. If you have changed the port, you must update the port number in the following file before building and running the JAX-WS examples:

tut-install/javaeetutorial5/examples/jaxws/simpleclient/src/java/simpleclient/HelloClient.java

## Web Application

A web application (sometimes shortened to web app) is a collection of servlets, Java-Server Pages (JSPs), HTML documents,images, templates, and other web resources that are set up in such a way as to be portably deployed across any servlet-enabled web server.By having everyone agree on exactly where files in a web application are to be placed and agreeing on a standard configuration file format, a web app can be transferred from one server to another easily without requiring any extra server
administration.

All the files under server_root/webapps/ROOT belong to a single web application (the root one). To simplify deployment, these files can be bundled into a single archive file and deployed to another server merely by placing the archive file into a specific directory. These archive files have the extension .war, which stands for web application archive. WAR files are actually JAR files (created using the jar utility) saved with an alternate extension. Using the JAR format allows WAR files to be stored in compressed form and have their contents digitally signed. The .war file extension was chosen over .jar to let people and tools know to treat them differently.

* The File Structure Inside a Web Application

```java
index.html
feedback.jsp
images/banner.gif
images/jumping.gif
WEB-INF/web.xml
WEB-INF/lib/bhawk4j.jar
WEB-INF/classes/MyServlet.class
WEB-INF/classes/com/mycorp/frontend/CorpServlet.class
WEB-INF/classes/com/mycorp/frontend/SupportClass.class
```

* /(root)-The top directory containing subdirectories typically containing HTML and JSP files for the app.

* The WEB-INF Directory-This directory must contain web.xml file.This directory is not accessible from web.The files there are not served directly to the client; instead, they contain Java classes and configuration information for the web app. The directory behaves like a JAR file's META-INF directory: it contains meta information about the archive contents.

1. The WEB-INF/classes directory contains the class files for this web app's servlets and support classes.
2. WEB-INF/lib contains classes stored in JAR files. For convenience, server class loaders automatically look to WEB-INF/classes and WEB-INF/lib when loading classes—no extra install steps are necessary.
The servlets in this web app can be invoked using URIs like /demo/servlet/MyServlet
and /demo/servlet/com.mycorp.frontend.CorpServlet. Notice how every request for this web app begins with /demo, even
requests for servlets.With the Tomcat server, server_root/webapps/ROOT is the default context mapped to the root path "/ ". This means that servlets
placed under server_root/webapps/ROOT/WEB-INF/classes can be accessed, as we saw earlier, using thepath /servlet/HelloWorld. With Tomcat, this default context mapping can be changed and new mappings can be added by editing
the server_root/conf/server.xml serverwide configuration file. Other servers configure mappings in different ways; see your
server's documentation for details.
The web.xml file in the WEB-INF directory is known as a deployment descriptor . This file contains configuration information.
about the web app in which it resides. It's an XML file with a standardized DTD. The DTD contains more than 50 tags, allowing full
control over the web app's behavior. The deployment descriptor file controls servlet registration, URL mappings, welcome files,
and MIME types, as well as advanced features like page-level security constraints and how a servlet should behave in a distributed
environment.

* META-INF -Contains context.xml.The file is used to configure web app context.

XML and DTDs

XML stands for Extensible Markup Language.[] It's a universal syntax for structuring data, created as an activity of
the World Wide Web Consortium (W3C) beginning in 1996. Since its standardization early in 1998 it has taken the
Web by storm.
XML is similar to HTML in that both take content and "mark it up" using tags that begin and end with angle brackets,
such as <title> and </title>. XML serves a different purpose than HTML, however. The tags in an XML
document don't define how the text should be displayed but rather explain the meaning of the text. It's an "extensible"
markup language because new tags can be created with their own meaning, as appropriate for the document being
written. XML works especially well as a flat file format because it's a standard, well-defined, platform-independent
technique for describing hierarchical data, and there are numerous tools to support the reading, writing, and
manipulation of XML files.
The rules for writing XML are more strict than for HTML. First, XML tags are case sensitive. <servlet> and
<SERVLET> are not the same. Second, all tags that begin must end. If there's a begin tag <servlet> there must be
an end tag </servlet>—although for convenience the empty tag syntax <servlet/> may be substituted as a
synonym for an immediate begin and end tag pairing <servlet></servlet>. Third, nested elements must not
overlap. So it's legal to have <outside><inside>data</inside></outside> while it's illegal to have
<outside><inside>data</outside></inside>. Fourth and finally, all attribute values must be surrounded by
quotes, either single or double. This means <servlet id="0"/> is fine while <servlet id=0/> is not. Documents
that follow these rules are called well-formed and will be successfully parsed by automated tools.
Beyond these rules, there are ways to explicitly declare a structure for the tags within an XML file. A specification of
this sort is called a Document Type Definition, or DTD. A DTD explicitly states what tags are allowed in a compliant
XML file, what type of data those tags are to contain, as well as where in the hierarchy the tags can (or must) be
placed. Each XML file can be declared to follow a certain DTD. Files that perfectly conform to their declared DTD
are called valid.
XML is used with servlets as the storage format for configuration files. XML also can be used by servlets to help with
content creation

The structure of the web.xml file is not in itself important at this point; what's important is the fact that having a deployment
descriptor file allows configuration information to be specified in a server-independent manner, greatly simplifying the deployment
process. Because of deployment descriptors, not only are simple servlets portable, but you can now transfer whole self-contained
subsections of your site between servers.
Over time it's likely that a commercial market for WAR files will develop. WAR files will become pluggable web components,
capable of being downloaded and installed and put to work right away—no matter what your operating system or web server.
Deployment descriptors also provide web-hosting companies with a convenient way to support multiple customers on the same
server. Customers can be given control over their individual domains. They can individually manage servlet registration.

The Deployment Descriptor

```xml
<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE web-app
PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.2//EN"
"http://java.sun.com/j2ee/dtds/web-app_2_2.dtd">
<web-app>
<servlet>
<servlet-name>
hi
</servlet-name>
<servlet-class>
HelloWorld
</servlet-class>
</servlet>
<url-pattern>
/hello.html
</url-pattern>
</web-app>
```

Various URL mapping rules can be specified in the deployment descriptor. There are four types of mappings, searched in the
following order:

Explicit mappings, like /hello.html or /images/chart.gif, containing no wildcards. This mapping style is useful when replacing
an existing page.
Path prefix mappings, such as /lite/*, /dbfile/*, or /catalog/item/*. These mappings begin with a /, end with a /*, and handle
all requests beginning with that prefix (not counting the context path). This mapping style allows a servlet to control an entire
virtual hierarchy. For example, the servlet handling /dbfile/*may serve files from a database, while the servlet handling /lite/*
may serve files from the filesystem automatically gzipped.
Extension mappings, such as *.wm or*.jsp. These mappings begin with a * and handle all requests ending with that suffix.
This mapping style lets a servlet operate on all files of a given extension. For example, a servlet can be assigned to handle
files ending in *.jsp to support JavaServer Pages. (In fact, this is an implicit mapping mandated by the servlet specification.)
The default mapping, /. This mapping specifies the default servlet for the web app, to be used if no other matches occur. It's
identical to the reduced path prefix mapping (/*) except this mapping matches after extension mappings. This gives control
over how basic files are served—a powerful ability, but one that should not be used lightly.

* When there's a collision between mappings, exact matches take precedence over path prefix matches, and path prefix matches take
precedence over extension matches. The default mapping is invoked only if no other matches occur. Longer string matches within a
category take precedence over shorter matches within a category.

### Standalone Servlet Containers

A standalone servlet container is a server that includes built-in support for servlets. Such a container has the advantage that everything works right out of the box. One disadvantage, however, is that you have to wait for a new release of the web server to get the latest servlet support. Another disadvantage is that server vendors generally support only the vendor-provided JVM. Web servers that provide standalone support include those in the following list.

1. Apache's Tomcat Server, the official reference implementation for how a servlet container should support servlets. Written entirely in Java, and freely available under an open source license. All the source code is available and anyone can help with its development. This server can operate standalone or as an add-on providing Apache or other servers with servlet support. It can even be used as an embedded container. Along with Tomcat, Apache develops the standard implementation of the javax.servlet and javax.servlet.http package
2. iPlanet (Netscape) Web Server Enterprise Edition (Version 4.0 and later), perhaps the most popular web server to provide
built-in servlet support. Some benchmarks show this server to have the fastest servlet implementation. Beware that, while
Versions 3.51 and 3.6 of this server had built-in servlet support, those servers supported only the early Servlet API 1.0 and
suffered from a number of bugs so significant the servlet support was practically unusable. To use servlets with Netscape 3.x
servers, use an add-on servlet container.
3. Zeus Web Server, a web server some consider the fastest available. Its feature list is quite long and includes servlet support.
4. Caucho's Resin, an open source container that prides itself on performance. It can run in standalone mode or as an add-on to
many servers
5. Gefion Software's LiteWebServer, a small (just over 100K) servlet container intended for uses, such as bundling with demos, where small size matters.
6. World Wide Web Consortium's Jigsaw Server, open source and written entirely in Java
7. Sun's Java Web Server, the server that started it all. This server was the first server to implement servlets and acted as the
effective reference implementation for Servlet API 2.0. It's written entirely in Java (except for two native code libraries that
enhance its functionality but are not needed). Sun has discontinued development on the server, concentrating now on
iPlanet/Netscape products as part of the Sun-Netscape Alliance.

Application servers are a growing area of development. An application server offers server-side support for developing enterprise-
based applications. Most Java-based application support servlets and the rest of the Java 2, Enterprise Edition, (J2EE)
specification. These servers include:

1. BEA System's WebLogic Application Server, one of the first and most famous Java-based application servers.
2. Orion Application Server, a high-end but relatively low-priced server, written entirely in Java.
3. Enhydra Application Server, an open source server from Lutris.
4. Oracle's Application Server, a server designed for integration with an Oracle database.
5. Silverstream Application Server, a fully compliant J2EE server that also started with a servlet focus.
6. Allaire's JRun Server (formerly from Live Software), a simple servlet container that grew to an advanced container providing
many J2EE technologies including EJB, JTA, and JMS.

### Add-on Servlet Containers

An add-on servlet container functions as a plug-in to an existing server—it adds servlet support to a server that was not originally designed with servlets in mind or to a server with a poor or outdated servlet implementation. Add-on servlet containers have been written for many servers including Apache, iPlanet's FastTrack Server and Enterprise Server, Microsoft's Internet Information Server and Personal Web Server, O'Reilly's WebSite, Lotus Domino's Go Webserver, StarNine's WebSTAR, and Apple's
AppleShare IP. Add-on servlet containers include the following:

1. New Atlanta's ServletExec, a plug-in designed to support servlets on all the popular web servers on all the popular operating
systems. Includes a free debugger.
2. The Java-Apache project's JServ module, a freely available open source servlet container that adds servlet support to the
extremely popular Apache server. Development has completed on JServ, and the Tomcat Server (acting as a plug-in) is the replacement for JServ.
3. Apache's Tomcat Server, as discussed previously, Tomcat may be plugged into other servers including Apache,
iPlanet/Netscape, and IIS.

### Embeddable Servlet Containers

An embeddable container is generally a lightweight servlet deployment platform that can be embedded in another application. That application becomes the true server. Embeddable servlet containers include the following:

1. Apache's Tomcat Server, while generally used standalone or as an add-on, this server also can be embedded into another application when necessary. Because this server is open source, development on most other embeddable containers has stopped.
2. Anders Kristensen's Nexus Web Server, a freely available servlet runner that implements most of the Servlet API and can be easily embedded in Java applications.


## HTTP Basics

Requests, Responses, and Headers
HTTP is a simple, stateless protocol. A client, such as a web browser, makes a request, the web server responds, and the
transaction is done. When the client sends a request, the first thing it specifies is an HTTP command, called a method, that tells the
server the type of action it wants performed. This first line of the request also specifies the address of a document (a URL) and the
version of the HTTP protocol it is using. For example:
GET /intro.html HTTP/1.0
This request uses the GET method to ask for the document named intro.html, using HTTP Version 1.0. After sending the request,
the client can send optional header information to tell the server extra information about the request, such as what software the client
is running and what content types it understands. This information doesn't directly pertain to what was requested, but it could be
used by the server in generating its response. Here are some sample request headers:
User-Agent: Mozilla/4.0 (compatible; MSIE 4.0; Windows 95)
Accept: image/gif, image/jpeg, text/*, */*
The User-Agent header provides information about the client software, while the Accept header specifies the media (MIME)
types that the client prefers to accept. (We'll talk more about request headers in the context of servlets in Chapter 4.) After the
headers, the client sends a blank line, to indicate the end of the header section. The client can also send additional data, if
appropriate for the method being used, as it is with the POST method that we'll discuss shortly. If the request doesn't send any
data, it ends with an empty line.
After the client sends the request, the server processes it and sends a response. The first line of the response is a status line specifing
the version of the HTTP protocol the server is using, a status code, and a description of the status code. For example:
HTTP/1.0 200 OK
This status line includes a status code of 200, which indicates that the request was successful, hence the description OK. Another
common status code is 404, with the description Not Found—as you can guess, this means that the requested document was not
found. Chapter 5 discusses common status codes and how you can use them in servlets, while Appendix D, provides a complete
list of HTTP status codes.
After the status line, the server sends response headers that tell the client things like what software the server is running and the
content type of the server's response. For example:
Date: Saturday, 23-May-00 03:25:12 GMT
Server: Tomcat Web Server/3.2
MIME-version: 1.0
Content-type: text/html
Content-length: 1029
Last-modified: Thursday, 7-May-00 12:15:35 GMT
The Server header provides information about the server software, while the Content-type header specifies the MIME type of
the data included with the response. (We'll also talk more about response headers in Chapter 5.) The server sends a blank line after
the headers, to conclude the header section.
If the request was successful, the requested data is then sent as part of the response. Otherwise, the response may contain human-This document is created with trial version of CHM2PDF Pilot 2.15.72.
readable data that explains why the server couldn't fulfill the request.
2.1.2 GET and POST
When a client connects to a server and makes an HTTP request, the request can be of several different types, called methods. The
most frequently used methods are GET and POST. Put simply, the GET method is designed for getting information (a document, a
chart, or the results from a database query), while the POST method is designed for posting information (a credit card number,
some new chart data, or information that is to be stored in a database). To use a bulletin board analogy, GET is for reading and
POST is for tacking up new material. GET is the method used when you type a URL directly into your browser or click on a
hyperlink; either GET or POST can be used when submitting an HTML form.
The GET method, although it's designed for reading information, can include as part of the request some of its own information that
better describes what to get—such as an x, y scale for a dynamically created chart. This information is passed as a sequence of
characters appended to the request URL in what's called a query string . Placing the extra information in the URL in this way
allows the page to be bookmarked or emailed like any other. Because GET requests theoretically shouldn't need to send large
amounts of information, some servers limit the length of URLs and query strings to about 240 characters.
The POST method uses a different technique to send information to the server because in some cases it may need to send
megabytes of information. A POST request passes all its data, of unlimited length, directly over the socket connection as part of its
HTTP request body. The exchange is invisible to the client. The URL doesn't change at all. Consequently, POST requests cannot
be bookmarked or emailed or, in some cases, even reloaded. That's by design—information sent to the server, such as your credit
card number, should be sent only once. POST also provides a bit of extra security when sending sensitive information because the
server's access log that records all URL accesses won't record the submitted POST data.
In practice, the use of GET and POST has strayed from the original intent. It's common for long parameterized requests for
information to use POST instead of GET to work around problems with overly long URLs. It's also common for simple forms that
upload information to use GET because, well—why not, it works! Generally, this isn't much of a problem. Just remember that GET
requests, because they can be bookmarked so easily, should not be allowed to cause a change on the server for which the client
could be held responsible. In other words, GET requests should not be used to place an order, update a database, or take an
explicit client action in any way.
2.1.3 Other Methods
In addition to GET and POST, there are several other lesser-used HTTP methods. There's the HEAD method, which is sent by a
client when it wants to see only the headers of the response, to determine the document's size, modification time, or general
availability. There's also PUT, to place documents directly on the server, and DELETE, to do just the opposite. These last two
aren't widely supported due to complicated policy issues. The TRACE method is used as a debugging aid—it returns to the client
the exact contents of its request. Finally, the OPTIONS method can be used to ask the server which methods it supports or what
options are available for a particular resource on the server.

The deployment descriptor (the web.xml file) includes the following configurations:
1. A display-name element that specifies the name that tools use to identify the application.
2. A set of filter elements that identify servlet filters contained in the application.
3. A set of filter-mapping elements that identify which servlets will have their requests or responses filtered by the filters identified by the filter elements. A filter-mapping element can define more than one servlet mapping and more than one URL pattern for a particular filter.
4. A set of servlet elements that identify all the servlet instances of the application.
5. A set of servlet-mapping elements that map the servlets to URL patterns. More than oneURL pattern can be defined for a particular servlet.
6. A set of error-page mappings that map exception types to an HTML page, so that the HTML page opens when an exception of that type is thrown by the application.

## Java Web Application Architecture

It uses three layers:-

1. The presentation layer/user interface layer - Consists of HTML pages and JSPs.Typically, a web designer will work on the HTML stored in these pages to create look and feel of the user interface.
2. The business rues layer - Uses servlets to control the flow of the application.These servlets can call other Java classes to store or retrieve data from database,and may forward results to a JSP or another servlet.A JavaBean is used to temporarily store and process data.
3. The Data access - It works with data that's stored on the server's disk.Consist of classes that read and write data that's stored on sever's disk data,database,text files,binary files,XML files.

`Model 1 Architecture` -With this architecture,a JSP is responsible for handling both request and response of application.The JSP interacts with Java classes and objects that represents the data of the business objects in application and provides method to do business processing.To save the data of business classes,the application maps the data to a database or files.

The JSPs uses regular Java classes to store data of the application and do business processing of the application.

Model 1 works for application with limited processing requirements,but not recommended for most applications.The JSPs become cluttered with scriplets and code becomes difficult to maintain.

`Model 2 architecture (Model-View-Controller (MVC) pattern)`:- A pattern is standard approach used by programmers to solve common programming problems.One of the pattern is Model-View-Controller. Has three layers:- model,view and controller.

Models defines the business layer of the application.Usually implemented by *JavaBeans*. Classes in these layer the data for business objects and provides methods that do business processing.

View defines presentation layer of the application.MVC apps uses HTML documents or JSPs to present view to the browser.

The Controller manages flow of the application,and this work is done by the servlets.

A servlet reads any parameters available from request which comes from view.Then,if necessary,the servlet updates the model and saves it in data store.Finally, based on logic that's coded in servlet,the servlet forwards the model to one of several posible JSPs for presentation.
Most applications need to map the data in the model to a data store but JavaBeans don't provide methods for storingg their own data.Instead, data classes like UserIo class provides those methods.That separates business logic from I/O operations.