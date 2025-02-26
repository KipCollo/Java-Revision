# JSP

JavaServer Pages are built on top of servlets.

JavaServer Pages (JSPs) are a Sun Microsystems specification for combining Java with HTML to provide dynamic content for Web pages. When you create dynamic content,
JSPs are more convenient to write than HTTP servlets because they allow you to embed Java code directly into your HTML pages, in contrast with HTTP servlets, in
which you embed HTML inside Java code.JSPs are Web pages coded with an extended HTML that makes it possible to embed Java code in a Web page. JSPs can call custom Java classes, called taglibs, using HTML-like tags.

The WebLogic appc compiler weblogic.appc generates JSPs and validates descriptors. You can also precompile JSPs into the WEB-INF/classes/ directory or as a JAR file under WEB-INF/lib/ and package the servlet class in the Web archive to avoid compiling in the server. Servlets and JSPs may require additional helper classes to be deployed with the Web application.

JSPs enable you to separate the dynamic content of a Web page from its presentation. It caters to two different types of developers: HTML developers, who are responsible for the graphical design of the page, and Java developers, who handle the development of software to create the dynamic content

## JSP Tags

* Scriplet

    • A JSP contains HTML tags and embedded Java code.
    • To code a scriptlet that contains one or more Java statements, you use the <% and %> tags.
    • To code an expression that can be converted to a string, you use the <%= and %> tags.
    • To get the values of the parameters that are passed to the JSP, you can use the getParameter method of implicit request object named request.

* Comments

```jsp

<%
string firstName= request.getParameter("fname");
%>

<%!
int age=0;
%>

<%--jsp comments--%>
```

## Configuring Java Server Pages (JSPs)

In order to deploy Java Server Pages (JSP) files, you must place them in the root (or in a subdirectory below the root) of a Web application. You define JSP configuration parameters in subelements of the jsp-descriptor element in the WebLogic-specific deployment descriptor, weblogic.xml. These parameters define the following functionality:

1. Options for the JSP compiler
2. Debugging
3. How often WebLogic Server checks for updated JSPs that need to be recompiled
4. Character encoding

