# Web Applications

A web application is a dynamic extension of a web or application server.There are two types of web applications:

* Presentation-oriented: A presentation-oriented web application generates interactive web pages containing various types of markup language (HTML, XHTML, XML, and so on) and dynamic content in response to requests. Development of presentation-oriented web applications Internationalizing and Localizing Web Applications, "JavaServer Faces Technology," "Java Servlet Technology."how to develop presentation-oriented web applications.

* Service-oriented: A service-oriented web application implements the endpoint of a web service. Presentation-oriented applications are often clients of service-oriented web applications. Development of service-oriented web applications , "Building Web Services with JAX-WS," "Building RESTful Web Services with JAX-RS," "Web Services."how to develop service-oriented web applications.

* In early days,Java used to make**applets**.These are Java apps that can be downloaded from web site and run within web browser.However,Microsoft Internet Explorer stopped supporting new versions of Java.As result applets lost their appeal and dev switched to servlets and JSPs.These tech allowed devs to write java web apps that run on server.

## Components of Java Web App

Client(Browser)<------>[Web Server<---->Servlet/JSP Engine(JDK)<----->Database Server]

To run java app,server must run servlet/JSP engine or servlet/JSP container.It allows web server to run servlets and JSPs.

Java EE specification describes how servlet/JSP engine should interact with web server.Since all Servlet/JSP engines must implement this specification,all servlet/JSPs code works similarly.In theory, this makes servlet/JSPs code portable btwn servlet/JSP engine and web servers.In practise,there are diffs btwn each servlet/JSPs engine and web server.as result you need to make some modifications to your code when switching servlet/JSPs engine or web servers.

In the Java EE platform, web components provide the dynamic extension capabilities for a web server. Web components can be Java servlets, web pages implemented with JavaServer Faces technology, web service endpoints, or JSP pages.

The client sends an HTTP request to the web server. A web server that implements Java Servlet and JavaServer Pages technology converts the request into an HTTPServletRequest object. This object is delivered to a web component, which can interact with JavaBeans components or a database to generate dynamic content. The web component can then generate an HTTPServletResponse or can pass the request to another web component. A web component eventually generates a HTTPServletResponse object. The web server converts this object to an HTTP response and returns it to the client.

Servlets are Java programming language classes that dynamically process requests and construct responses. Java technologies, such as JavaServer Faces and Facelets, are used for building interactive web applications. (Frameworks can also be used for this purpose.) Although servlets and JavaServer Faces and Facelets pages can be used to accomplish similar things, each has its own strengths. Servlets are best suited for service-oriented applications (web service endpoints can be implemented as servlets) and the control functions of a presentation-oriented application, such as dispatching requests and handling nontextual data. JavaServer Faces and Facelets pages are more appropriate for generating text-based markup, such as XHTML, and are generally used for presentation-oriented applications.

Web components are supported by the services of a runtime platform called a web container. A web container provides such services as request dispatching, security, concurrency, and lifecycle management. A web container also gives web components access to such APIs as naming, transactions, and email.

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

In the Java 2 platform, web components provide the dynamic extension capabilities for a web server. Web components are either Java servlets, JSP pages, or web service endpoints. The client sends an HTTP request to the web server. A web server that implements Java Servlet and JavaServer Pages technology converts the request into an HTTPServletRequest object. This object is delivered to a web component, which can interact with JavaBeans components or a database to generate dynamic content. The web component can then generate an HTTPServletResponse or it can pass the request to another web component. Eventually a web component generates a HTTPServletResponse object. The web server converts this object to an HTTP response and returns it to the client.

               1                            2
      |---------------->HttpServletRequest--------->|
Client|                                             | Web Componets------4----->Database
      |<---------------HttpServletResponse<---------|       |
                6                                5          |3
                                                        JavaBeans Component

Servlets are Java programming language classes that dynamically process requests and construct responses. JSP pages are text-based documents that execute as servlets but allow a more natural approach to creating static content. Although servlets and JSP pages can be used interchangeably, each has its own strengths. Servlets are best suited for service-oriented applications (web service endpoints are implemented as servlets) and the control functions of a presentation-oriented application, such as dispatching requests and handling nontextual data. JSP pages are more appropriate for generating text-based markup such as HTML, Scalable Vector Graphics (SVG), Wireless Markup Language (WML), and XML.

Java Servlet technology is the foundation of all the web application technologies.Each technology adds a level of abstraction that makes web application prototyping and development faster and the web applications themselves more maintainable, scalable, and robust.

Web components are supported by the services of a runtime platform called a web container. A web container provides services such as request dispatching, security, concurrency, and life-cycle management. It also gives web components access to APIs such as naming, transactions, and email.

Certain aspects of web application behavior can be configured when the application is installed, or deployed, to the web container. The configuration information is maintained in a text file in XML format called a web application deployment descriptor (DD). A DD must conform to the schema described in the Java Servlet Specification.

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
