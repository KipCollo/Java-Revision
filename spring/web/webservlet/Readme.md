# Webservlet and Spring MVC

The Web-Servlet module contains Spring’s model-view-controller (MVC) implementation for web applications. Spring’s MVC framework provides a clean separation between domain model code and web forms, and integrates with all the other features of the Spring Framework.

Spring Web MVC is the original web framework built on the Servlet API and has been included in the Spring Framework from the very beginning.Servlets and JSP can develop web apps but has alot of boilerplate code and mixing of business logic and presentation logic.

* Boilerplate code is code common for all classes.Also you should convert HTTP Request params into Java Bean

i.e

```java
 public void service(Request req,Response res){

	String name = req.getParameter("name")
	String password = req.getParameter("password")

	Customer cust= new Customer();//convert req params to Bean
	cust.setFirstname(req.getFirstName())
 }
```

Spring MVC helps in removal of boilerplate code with help of FrontController(DispatcherServlet) and separate business logic from presentation logic.

- Spring MVC is one of Gang of Four design pattern and internally uses 3 design patterns(Strategy,Observer & Composite patterns)

			 1								2
  CLIENT-------------->DispatcherServlet----------------->HandlerMapping
	|						|  	|   |          3
	|						|	|   |----------><---------------Controller
	|						|	|
	|   Http Response	  	|	|------------><--------------ViewRessolver
	 -------<-------------VIEW

## MVC Architecture

Has 5 components
1. FrontController(DispatcherServlet)
2. HandlerMapping
3. Controller
4. ViewReolver
5. View

1. DispatcherServlet

Spring MVC, as many other web frameworks, is designed around the front controller pattern where a central Servlet, the DispatcherServlet, provides a shared algorithm for request processing, while actual work is performed by configurable delegate components. This model is flexible and supports diverse workflows.

Takes care common processing logic that should be applied to all request coming into applications.It will bind URL patterns i.e *.htm,*.web,*.mvc,*.do,*.action..etc

The DispatcherServlet, as any Servlet, needs to be declared and mapped according to the Servlet specification by using Java configuration or in web.xml. In turn, the DispatcherServlet uses Spring configuration to discover the delegate components it needs for request mapping, view resolution, exception handling, and more.

The following example of the Java configuration registers and initializes the DispatcherServlet, which is auto-detected by the Servlet container
```java
public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {

		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
	}
}
```

The following example of web.xml configuration registers and initializes the DispatcherServlet:
```xml
<web-app>

	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/app-context.xml</param-value>
	</context-param>

	<servlet>
		<servlet-name>app</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value></param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>app</servlet-name>
		<url-pattern>/app/*.htm,*.mvc,*.do</url-pattern>
	</servlet-mapping>

</web-app>
```

Spring Boot follows a different initialization sequence. Rather than hooking into the lifecycle of the Servlet container, Spring Boot uses Spring configuration to bootstrap itself and the embedded Servlet container. Filter and Servlet declarations are detected in Spring configuration and registered with the Servlet container.

2. Handler Mapping

Helps in identifying the controller to be used for a request.Based on URI,Handler Mapping will return controller name then DispatcherServlet will execute the controller.

3. Controller

Responsible for processing logics to handle the request.Always gives logical name as response to DispatcherServlet.The DispatcherServlet will send logical name to ViewResolver

4. ViewResolver

Converts logical name into physical names.i.e fail---fail.jsp,orders---order.jsp

5. View

Views is rendering/displaying the data.i.e what format to display data.Different views are available ie pdf,webpage,excel.We can change one view to another in view layer.
i.e   Jsp----------->Thymeleaf

## Context Hierarchy

DispatcherServlet expects a WebApplicationContext (an extension of a plain ApplicationContext) for its own configuration. WebApplicationContext has a link to the ServletContext and the Servlet with which it is associated. It is also bound to the ServletContext such that applications can use static methods on RequestContextUtils to look up the WebApplicationContext if they need access to it.

For many applications, having a single WebApplicationContext is simple and suffices. It is also possible to have a context hierarchy where one root WebApplicationContext is shared across multiple DispatcherServlet (or other Servlet) instances, each with its own child WebApplicationContext configuration. See Additional Capabilities of the ApplicationContext for more on the context hierarchy feature.

The root WebApplicationContext typically contains infrastructure beans, such as data repositories and business services that need to be shared across multiple Servlet instances. Those beans are effectively inherited and can be overridden (that is, re-declared) in the Servlet-specific child WebApplicationContext, which typically contains beans local to the given Servlet.

The following example configures a WebApplicationContext hierarchy:
```java
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { App1Config.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/app1/*" };
	}
}
```

If an application context hierarchy is not required, applications can return all configuration through getRootConfigClasses() and null from getServletConfigClasses().

The following example shows the web.xml equivalent:
```xml
<web-app>

	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/root-context.xml</param-value>
	</context-param>

	<servlet>
		<servlet-name>app1</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/app1-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>app1</servlet-name>
		<url-pattern>/app1/*</url-pattern>
	</servlet-mapping>

</web-app>
```
	
If an application context hierarchy is not required, applications may configure a “root” context only and leave the contextConfigLocation Servlet parameter empty. 

## Special Bean Types

The DispatcherServlet delegates to special beans to process requests and render the appropriate responses. By “special beans” we mean Spring-managed Object instances that implement framework contracts. Those usually come with built-in contracts, but you can customize their properties and extend or replace them.

1. HandlerMapping - Map a request to a handler along with a list of interceptors for pre- and post-processing. The mapping is based on some criteria, the details of which vary by HandlerMapping implementation.

The two main HandlerMapping implementations are RequestMappingHandlerMapping (which supports @RequestMapping annotated methods) and SimpleUrlHandlerMapping (which maintains explicit registrations of URI path patterns to handlers).

2. HandlerAdapter - Help the DispatcherServlet to invoke a handler mapped to a request, regardless of how the handler is actually invoked. For example, invoking an annotated controller requires resolving annotations. The main purpose of a HandlerAdapter is to shield the DispatcherServlet from such details.
3. HandlerExceptionResolver- Strategy to resolve exceptions, possibly mapping them to handlers, to HTML error views, or other targets. See Exceptions.
4. ViewResolver - Resolve logical String-based view names returned from a handler to an actual View with which to render to the response. See View Resolution and View Technologies.
5. LocaleResolver, LocaleContextResolver - Resolve the Locale a client is using and possibly their time zone, in order to be able to offer internationalized views. See Locale.
6. ThemeResolver - Resolve themes your web application can use — for example, to offer personalized layouts. See Themes.
7. MultipartResolver - Abstraction for parsing a multi-part request (for example, browser form file upload) with the help of some multipart parsing library. See Multipart Resolver.
8. FlashMapManager - Store and retrieve the “input” and the “output” FlashMap that can be used to pass attributes from one request to another, usually across a redirect. See Flash Attributes.

## Web MVC Config

See equivalent in the Reactive stack

Applications can declare the infrastructure beans listed in Special Bean Types that are required to process requests. The DispatcherServlet checks the WebApplicationContext for each special bean. If there are no matching bean types, it falls back on the default types listed in DispatcherServlet.properties.

In most cases, the MVC Config is the best starting point. It declares the required beans in either Java or XML and provides a higher-level configuration callback API to customize it.

 Spring Boot relies on the MVC Java configuration to configure Spring MVC and provides many extra convenient options. 
