# Servlet

A servlet is a small Java program that runs within a Web server. Servlets receive and respond to requests from Web clients, usually across HTTP, the HyperText Transfer Protocol.

A servlet is a Java class that runs in a Java-enabled server. An HTTP servlet is a special type of servlet that handles an HTTP request and provides an HTTP response, usually in the form of an HTML page. The most common use of WebLogic HTTP servlets is to create interactive applications using standard Web browsers for the client-side
presentation while WebLogic Server handles the business logic as a server-side process. WebLogic HTTP servlets can access databases, Enterprise JavaBeans,messaging APIs, HTTP sessions, and other facilities of WebLogic Server

## Jakarta Servlet

Jakarta Servlet is a corner stone web framework that can act as a presentation-oriented as well as a service-oriented web application. Jakarta Servlet intends to reduce the boilerplate code needed to convert the HTTP request into a Java object and to offer a Java object as an HTTP response, and to manage all the lifecycle around them.

To implement this interface, you can write a generic servlet that extends javax.servlet.GenericServlet or an HTTP servlet that extends javax.servlet.http.HttpServlet.

This interface defines methods to initialize a servlet, to service requests, and to remove a servlet from the server. These are known as life-cycle methods and are called in the following sequence:

1. The servlet is constructed, then initialized with the init method.
2. Any calls from clients to the service method are handled.
3. The servlet is taken out of service, then destroyed with the destroy method, then garbage collected and finalized.

A servlet is a java class that xtends HttpServlet class and runs on server within a servlet container.

A servlet is a Java programming language class that directly or indirectly implements the jakarta.servlet.Servlet interface. The jakarta.servlet and jakarta.servlet.http packages provide interfaces and classes for writing servlets. All servlets must implement the jakarta.servlet.Servlet interface, which defines lifecycle methods such as init, service, and destroy

```java
public class StudentServleet extends HttpServlet{

}
```

In a typical Jakarta Servlet based web application, the class must extend jakarta.servlet.http.HttpServlet and override one of the doXxx methods where Xxx represents the HTTP method of interest.

## Creating a servlet

Use the @WebServlet annotation to define a servlet component in a web application. This annotation is specified on a class and contains metadata about the servlet being declared. The annotated servlet must specify at least one URL pattern. This is done by using the urlPatterns or value attribute on the annotation. All other attributes are optional, with default settings. Use the value attribute when the only attribute on the annotation is the URL pattern; otherwise, use the urlPatterns attribute when other attributes are also used.

Classes annotated with @WebServlet must extend the jakarta.servlet.http.HttpServlet class.

```java
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/")
public class ExampleServlet extends HttpServlet {
    ...
}
```

The web container initializes a servlet after loading and instantiating the servlet class and before delivering requests from clients. To customize this process to allow the servlet to read persistent configuration data, initialize resources, and perform any other one-time activities, you can either override the init method of the Servlet interface or specify the initParams attribute of the @WebServlet annotation. The initParams attribute contains a @WebInitParam annotation. If it cannot complete its initialization process, a servlet throws an UnavailableException.

## Creating Service Method

The service provided by a servlet is implemented in the service method of a GenericServlet, in the doMethod methods (where Method can take the value Get, Delete, Options, Post, Put, or Trace) of an HttpServlet object, or in any other protocol-specific methods defined by a class that implements the Servlet interface. The term service method is used for any method in a servlet class that provides a service to a client.

The general pattern for a service method is to extract information from the request, access external resources, and then populate the response, based on that information. For HTTP servlets, the correct procedure for populating the response is to do the following:

1. Retrieve an output stream from the response.
2. Fill in the response headers.
3. Write any body content to the output stream.

Response headers must always be set before the response has been committed. The web container will ignore any attempt to set or add headers after the response has been committed.
Getting Information from Requests

A request contains data passed between a client and the servlet. All requests implement the ServletRequest interface. This interface defines methods for accessing the following information:

    Parameters, which are typically used to convey information between clients and servlets

    Object-valued attributes, which are typically used to pass information between the web container and a servlet or between collaborating servlets

    Information about the protocol used to communicate the request and about the client and server involved in the request

    Information relevant to localization

You can also retrieve an input stream from the request and manually parse the data. To read character data, use the BufferedReader object returned by the request’s getReader method. To read binary data, use the ServletInputStream returned by getInputStream.

HTTP servlets are passed an HTTP request object, HttpServletRequest, which contains the request URL, HTTP headers, query string, and so on. An HTTP request URL contains the following parts:

http://[host]:[port][request-path]?[query-string]

The request path is further composed of the following elements:

    Context path: A concatenation of a forward slash (/) with the context root of the servlet’s web application.

    Servlet path: The path section that corresponds to the component alias that activated this request. This path starts with a forward slash (/).

    Path info: The part of the request path that is not part of the context path or the servlet path.

You can use the getContextPath, getServletPath, and getPathInfo methods of the HttpServletRequest interface to access this information. Except for URL encoding differences between the request URI and the path parts, the request URI is always comprised of the context path plus the servlet path plus the path info.

Query strings are composed of a set of parameters and values. Individual parameters are retrieved from a request by using the getParameter method. There are two ways to generate query strings.

    A query string can explicitly appear in a web page.

    A query string is appended to a URL when a form with a GET HTTP method is submitted.

Constructing Responses

A response contains data passed between a server and the client. All responses implement the ServletResponse interface. This interface defines methods that allow you to

    Retrieve an output stream to use to send data to the client. To send character data, use the PrintWriter returned by the response’s getWriter method. To send binary data in a Multipurpose Internet Mail Extensions (MIME) body response, use the ServletOutputStream returned by getOutputStream. To mix binary and text data, as in a multipart response, use a ServletOutputStream and manage the character sections manually.

    Indicate the content type (for example, text/html) being returned by the response with the setContentType(String) method. This method must be called before the response is committed. A registry of content type names is kept by the Internet Assigned Numbers Authority (IANA) at http://www.iana.org/assignments/media-types/.

    Indicate whether to buffer output with the setBufferSize(int) method. By default, any content written to the output stream is immediately sent to the client. Buffering allows content to be written before anything is sent back to the client, thus providing the servlet with more time to set appropriate status codes and headers or forward to another web resource. The method must be called before any content is written or before the response is committed.

    Set localization information, such as locale and character encoding. See Chapter 17, Internationalizing and Localizing Web Applications for details.

HTTP response objects, javax.servlet.http.HttpServletResponse, have fields representing HTTP headers, such as the following:

    Status codes, which are used to indicate the reason a request is not satisfied or that a request has been redirected.

    Cookies, which are used to store application-specific information at the client. Sometimes, cookies are used to maintain an identifier for tracking a user’s session (see Session Tracking).

* HttpServlet -Provides an abstract class to be subclassed to create an HTTP servlet suitable for a Web site. A subclass of HttpServlet must override at least one method, usually one of these:

 1. doGet, if the servlet supports HTTP GET requests
 2. doPost, for HTTP POST requests
 3. doPut, for HTTP PUT requests
 4. doDelete, for HTTP DELETE requests
 5. init and destroy, to manage resources that are held for the life of the servlet
 6. getServletInfo, which the servlet uses to provide information about itself

There's almost no reason to override the service method. service handles standard HTTP requests by dispatching them to the handler methods for each HTTP request type (the doXXX methods listed above).
Servlets typically run on multithreaded servers, so be aware that a servlet must handle concurrent requests and be careful to synchronize access to shared resources. Shared resources include in-memory data such as instance or class variables and external objects such as files, database connections, and network connections.

```java
public class StudentServleet extends HttpServlet{

    @Override
    public void doPost(HttpRequesst request, HttpResponse response)throws ServletException,IOException
    {
        ...
    }
}
```

## Configuring Servlets

* XML based -You define servlets as a part of a Web application in several entries in the J2EE standard Web Application deployment descriptor, web.xml. The web.xml file is located in the WEB-INF directory of your Web application.

1. The first entry, under the root servlet element in web.xml, defines a name for the servlet and specifies the compiled class that executes the servlet. (Or, instead of specifying a servlet class, you can specify a JSP.) The servlet element also contains definitions for initialization attributes and security roles for the servlet.
2. The second entry in web.xml, under the servlet-mapping element, defines the URL pattern that calls this servlet.

```xml
<servlet>
  <servlet-name>name</servlet-name>
  <servlet-class>com.kipcollo.ExampleServlet</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>name</servlet-name>
  <url-pattern>/home</url-pattern>
</servlet-mapping>
```

* Annotation based configurations-Servlet Annotations are introduced in Servlet API 2.5 (JEE 5.0, JSE 5.0). These annotations are used to avoid writing the web.xml file.
@WebServlet annotation is used to declare a Servlet. This annotation is processed by the container at deployment time and the corresponding servlet made available at the specified URL patterns.

```java
@WebServlet
public class Servlet extends Httpservlet{
    .....
}
```

## Annotation Types

1. HandlesTypes -This annotation is used to declare the class types that a ServletContainerInitializer can handle.
2. HttpConstraint -This annotation is used within the ServletSecurity annotation to represent the security constraints to be applied to all HTTP protocol methods for which a corresponding HttpMethodConstraint element does NOT occur within the ServletSecurity annotation.
3. HttpMethodConstraint -This annotation is used within the ServletSecurity annotation to represent security constraints on specific HTTP protocol messages.
4. MultipartConfig -Annotation that may be specified on a Servlet class, indicating that instances of the Servlet expect requests that conform to the multipart/form-data MIME type.
5. ServletSecurity -This annotation is used on a Servlet implementation class to specify security constraints to be enforced by a Servlet container on HTTP protocol messages.
6. WebFilter -Annotation used to declare a servlet filter.
7. WebInitParam -This annotation is used on a Servlet or Filter implementation class to specify an initialization parameter.
8. WebListener -This annotation is used to declare a WebListener.
9. @WebServlet -Annotation used to declare a servlet.

## Request Object

* ServletRequest- Defines an object to provide client request information to a servlet. The servlet container creates a ServletRequest object and passes it as an argument to the servlet's service method.A ServletRequest object provides data including parameter name and values, attributes, and an input stream. Interfaces that extend ServletRequest can provide additional protocol-specific data (for example, HTTP data is provided by HttpServletRequest.)

1. String getParameter(String name) -Returns the value of a request parameter as a String, or null if the parameter does not exist.
2. void setAttribute(String name, Object o)- Stores an attribute in this request
3. Object getAttribute(String name)- Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.

* HttpServletRequest-Extends the ServletRequest interface to provide request information for HTTP servlets.The servlet container creates an HttpServletRequest object and passes it as an argument to the servlet's service methods (doGet, doPost, etc)

1. Cookie[] getCookies()- Returns an array containing all of the Cookie objects the client sent with this request.
2. HttpSession getSession()-Returns the current session associated with this request, or if the request does not have a session, creates one.
3. HttpSession getSession(boolean create)-Returns the current HttpSession associated with this request or, if there is no current session and create is true, returns a new session.

## Response Onjects

* ServletResponse-Defines an object to assist a servlet in sending a response to the client. The servlet container creates a ServletResponse object and passes it as an argument to the servlet's service method.

1. PrintWriter getWriter()-Returns a PrintWriter object that can send character text to the client
2. void setContentType(String type)-Sets the content type of the response being sent to the client, if the response has not been committed yet.

* HttpServletResponse-Extends the ServletResponse interface to provide HTTP-specific functionality in sending a response. For example, it has methods to access HTTP headers and cookies.The servlet container creates an HttpServletResponse object and passes it as an argument to the servlet's service methods (doGet, doPost, etc)

1. void addCookie(Cookie cookie)-Adds the specified cookie to the response.
2. int getStatus()-Gets the current status code of this response.
3. void sendRedirect(String location)- Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer.

### Forwading and Redirecting Requests

* Forwading Request and Response-
* Redirect Response-To redirect response you use redirect method of response object.Typically used when you transfer control to URL outside your application.

```java
//How to forward the request to an HTML page
String url = "/display_email_entry.html";
RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(url);
dispatcher.forward(request, response);

//How to forward the request to a JSP
String url = "/display_email_entry.jsp";
RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(url);
dispatcher.forward(request, response);

// How to forward the request to a servlet
String url = "/cart/displayInvoice";
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
dispatcher.forward(request, response);
```

```java
// How to redirect a response relative to the current directory
response.sendRedirect("join_email_list.html");

// How to redirect a response relative to the servlet engine
response.sendRedirect("/musicStore/email/join_email_list.jsp");

// How to redirect a response to a different web server
response.sendRedirect("http://www.murach.com/email/");
```

### sessions and cookies

## The Servlet API

Servlets use classes and interfaces from two packages: javax.servlet
and javax.servlet.http. The javax.servlet package contains classes and interfaces to support generic, protocol-
independent servlets. These classes are extended by the classes in the javax.servlet.http package to add HTTP-specific
functionality. The top-level package name is javax instead of the familiar java, to indicate that the Servlet API is an Optional
Package (formerly called a Standard Extension).
Every servlet must implement the javax.servlet.Servlet interface. Most servlets implement this interface by extending one of
two special classes: javax.servlet.GenericServlet or javax.servlet.http.HttpServlet. A protocol-independent
servlet should subclass GenericServlet, while an HTTP servlet should subclass HttpServlet, which is itself a subclass of
GenericServlet with added HTTP-specific functionality.

Unlike a regular Java program, and just like an applet, a servlet does not have a main( ) method. Instead, certain methods of a
servlet are invoked by the server in the process of handling requests. Each time the server dispatches a request to a servlet, it
invokes the servlet's service( ) method.

A generic servlet should override its service( ) method to handle requests as appropriate for the servlet. The service( )
method accepts two parameters: a request object and a response object. The request object tells the servlet about the request,
while the response object is used to return a response.

In contrast, an HTTP servlet usually does not override the service( ) method. Instead, it overrides doGet( ) to handle GET
requests and doPost( ) to handle POST requests. An HTTP servlet can override either or both of these methods, depending on
the type of requests it needs to handle. The service( ) method of HttpServlet handles the setup and dispatching to all the
doXXX( ) methods, which is why it usually should not be overridden

An HTTP servlet can override the doPut( ) and doDelete( ) methods to handle PUT and DELETE requests, respectively.
However, HTTP servlets generally don't touch doTrace( ) or doOptions( ). For these, the default implementations are almost
always sufficient.
The remainder in the javax.servlet and javax.servlet.http packages are largely support classes. For example, the
ServletRequest and ServletResponse classes in javax.servlet provide access to generic server requests and responses,while HttpServletRequest and HttpServletResponse in javax.servlet.http provide access to HTTP requests and
responses. The javax.servlet.http package also contains an HttpSession interface that provides built-in session tracking
functionality and a Cookie class that allows you to quickly set up and process HTTP cookies.

## Page Generation

The most basic type of HTTP servlet generates a full HTML page. Such a servlet has access to the same information usually sent to
a CGI script, plus a bit more. A servlet that generates an HTML page can be used for all the tasks for which CGI is used currently,
such as for processing HTML forms, producing reports from a database, taking orders, checking identities, and so forth.

```java

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HelloWorld extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res)
throws ServletException, IOException {
res.setContentType("text/html");
PrintWriter out = res.getWriter();
out.println("<HTML>");
out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
out.println("<BODY>");
out.println("<BIG>Hello World</BIG>");
out.println("</BODY></HTML>");
}
}
```

This servlet extends the HttpServlet class and overrides the doGet( ) method inherited from it. Each time the web server
receives a GET request for this servlet, the server invokes this doGet( ) method, passing it an HttpServletRequest object and
an HttpServletResponse object.
The HttpServletRequest represents the client's request. This object gives a servlet access to information about the client, the
parameters for this request, the HTTP headers passed along with the request

The HttpServletResponse represents the servlet's response. A servlet can use this object to return data to the client. This data
can be of any content type, though the type should be specified as part of the response. A servlet can also use this object to set
HTTP response headers.

## Loading Servlets, Context Listeners, and Filters

Servlets, Context Listeners, and Filters are loaded and destroyed in the following
order:
Order of loading:

1. Context Listeners
2. Filters
3. Servlets
Order of destruction:

1. Servlets
2. Filters
3. Context Listeners

Servlets and filters are loaded in the same order they are defined in the web.xml file
and unloaded in reverse order. Context listeners are loaded in the following order:

1. All context listeners in the web.xml file in the order as specified in the file
2. Packaged JAR files containing tag library descriptors
3. Tag library descriptors in the WEB-INF directory