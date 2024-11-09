# Filters

A filter is a Java class that is invoked in response to a request for a resource in a Web application. Resources include Java Servlets, JavaServer pages (JSP), and static resources such as HTML pages or images. A filter intercepts the request and can examine and modify the response and request objects or execute other tasks.

## How Filters Work

You define filters in the context of a Web application. A filter intercepts a request for a specific named resource or a group of resources (based on a URL pattern) and executes the code in the filter. For each resource or group of resources, you can specify a single filter or multiple filters that are invoked in a specific order, called a chain.

When a filter intercepts a request, it has access to the javax.servlet.ServletRequest and javax.servlet.ServletResponse objects that provide access to the HTTP request and response, and a javax.servlet.FilterChain object. The FilterChain object contains a list of filters that can be invoked sequentially. When a filter has completed its work, the filter can either call the next filter in the chain, block the request, throw an exception, or invoke the originally requested resource.

After the original resource is invoked, control is passed back to the filter at the bottom of the list in the chain. This filter can then examine and modify the response headers and data, block the request, throw an exception, or invoke the next filter up from the bottom of the chain. This process continues in reverse order up through the chain of filters.

* Note: The filter can modify the headers only if the response has not already been committed

## Uses for Filters

Filters can be useful for the following functions:

1. Implementing a logging function
2. Implementing user-written security functionality
3. Debugging
4. Encryption
5. Data compression
6. Modifying the response sent to the client. (However, post processing the response can degrade the performance of your application.)

## Writing a Filter Class

To write a filter class, implement the javax.servlet.Filter interface; You must implement the following methods of this interface:

* init(FilterConfig filterConfig)-Called by the web container to indicate to a filter that it is being placed into service.
* destroy() -Called by the web container to indicate to a filter that it is being taken out of service.
* doFilter(ServletRequest request, ServletResponse response, FilterChain chain) -The doFilter method of the Filter is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain.

You use the doFilter() method to examine and modify the request and response objects, perform other tasks such as logging, invoke the next filter in the chain, or
block further processing.Several other methods are available on the FilterConfig object for accessing the name of the filter, the ServletContext and the filter's initialization attributes.

To access the next item in the chain (either another filter or the original resource, if that is the next item in the chain), call the FilterChain.doFilter() method.

## Configuring Filters

You configure filters as part of a Web application, using the application's web.xml deployment descriptor. In the deployment descriptor, you specify the filter and then
map the filter to a URL pattern or to a specific servlet in the Web application. You can specify any number of filters.

To configure a filter:

Add a filter declaration to web.xml. The filter element declares a filter, defines a name for the filter, and specifies the Java class that executes the filter. The filter element must directly follow the context-param element and directly precede the listener and servlet elements. For example:

```xml
<context-param>Param</context-param>
<filter>
<icon>
<small-icon>MySmallIcon.gif</small-icon>
<large-icon>MyLargeIcon.gif</large-icon>
</icon>
<filter-name>myFilter</filter-name>
<display-name>My Filter</display-name>
<description>This is my filter</description>
<filter-class>examples.myFilterClass</filter-class>
</filter>
<listener>Listener</listener>
<servlet>Servlet</servlet>
```

The icon, description, and display-name elements are optional.

### Configuring a Chain of Filters

WebLogic Server creates a chain of filters by creating a list of all the filter mappings that match an incoming HTTP request. The ordering of the list is determined by the following sequence:

1. Filters where the filter-mapping element contains a url-pattern that matches the request are added to the chain in the order they appear in the web.xml deployment descriptor.
2. Filters where the filter-mapping element contains a servlet-name that matches the request are added to the chain after the filters that match a URL pattern.
3. The last item in the chain is always the originally requested resource.In your filter class, use the FilterChain.doFilter() method to invoke the next item in the chain
