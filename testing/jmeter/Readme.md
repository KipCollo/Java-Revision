# JMETER

JMeter is a software that can perform load test, performance-oriented business functional test, regression test, etc., on different protocols or technologies.

- `Performance Test` − This test sets the best possible performance expectation under a given configuration of infrastructure. It also highlights early in the testing process if any changes need to be made before the application goes into production.
- `Load Test` − This test is basically used for testing the system under the top load it was designed to operate under.
- `Stress Test` − This test is an attempt to break the system by overwhelming its resources.

Stefano Mazzocchi of the Apache Software Foundation was the original developer of JMeter. He wrote it primarily to test the performance of Apache JServ now called as ApacheTomcatproject. Apachelater redesigned JMeter to enhance the GUI and to add functional testing capabilities.

JMeter is a Java desktop application with a graphical interface that uses the Swing graphical API. It can therefore run on any environment / workstation that accepts a Java virtual machine, for example − Windows, Linux, Mac, etc.

- The protocols supported by JMeter are −
   1. Web − HTTP, HTTPS sites 'web 1.0' web 2.0 ajax, flexandflex − ws − amf
   2. Web Services − SOAP / XML-RPC
   3. Database via JDBC drivers
   4. Directory − LDAP
   5. Messaging Oriented service via JMS
   6. Service − POP3, IMAP, SMTP
   7. FTP Service

JMeter features include:-

1. It is free i.e open source
2. Simple and intuitive GUI.
3. Can conduct load and performance test for many different server types i.e Web(HTTP,HTTPS,SOAP),Database(JDBC,LDAP),JMS,Mail(POP3).
4. It is platform independent tool.
5. Has full Swing and lightweight component support.
6. Stores its test plans in XML format.You can generate test plan using text editor.
7. It is full multi-threading framework allowing concurrent sampling by many threads and simultaneous sampling of different functions by separate thread groups
8. Extensible
9. Can be used to perform automated and functional testing of the applications.

How Jmeter works:-

JMeter simulates a group of users sending requests to a target server,and returns statistics that show the performance/functionality of the target server/application via tables,graphs

## JMETER - ENVIRONMENT

JMeter is a framework for Java, so the very first requirement is to have JDK installed in your machine.

- Verify Java Installation.
- Download JMeter
- Run JMeter

## JMETER - BUILD TEST PLAN

`Test Plan`:- It is a container for running tests.It defines what to test and how to go about it.A complete test plan consists of one or more elements such as thread groups,logic controllers,a sample-generating controllers,listeners,timers,assertions and configuration elements.A test plan must have at least one thread group.

- Writing a Test Plan:-
   1. Start the JMeter Window - Open the JMeter window by clicking /home/manisha/apache-jmeter-2.9/bin/jmeter.sh.The JMeter window will appear.This is a plain and blank JMeter window without any additional elaments added to it. It contains two nodes −
      - Test Plan node − is where the real test plan is kept.
      - Workbench node − It simply provides a place to temporarily store test elements while not in use, for copy/paste purposes. When you save your test plan, Workbench items are not saved with it.
   2. Add/Remove Elements - Elements can be added to a test plan by right-clicking on the Test Plan node and choosing a new element from the "add" list.Alternatively, you can load an element from a file and add it by choosing the "merge" or "open" option.To remove an element, make sure the element is selected, right-click on the element, and choose the "remove" option.
