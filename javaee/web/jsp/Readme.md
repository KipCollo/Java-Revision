# JSP

JavaServer Pages are built on top of servlets.
JavaServer Pages (JSPs) are a Sun Microsystems specification for combining Java with HTML to provide dynamic content for Web pages. When you create dynamic content,
JSPs are more convenient to write than HTTP servlets because they allow you to embed Java code directly into your HTML pages, in contrast with HTTP servlets, in
which you embed HTML inside Java code.JSPs are Web pages coded with an extended HTML that makes it possible to embed
Java code in a Web page. JSPs can call custom Java classes, called taglibs, using HTML-like tags. The WebLogic appc compiler weblogic.appc generates JSPs and
validates descriptors. You can also precompile JSPs into the WEB-INF/classes/ directory or as a JAR file under WEB-INF/lib/ and package the servlet class in the
Web archive to avoid compiling in the server. Servlets and JSPs may require additional helper classes to be deployed with the Web application.
JSPs enable you to separate the dynamic content of a Web page from its presentation. It caters to two different types of developers: HTML developers, who are responsible for the graphical design of the page, and Java developers, who handle the development of software to create the dynamic content
