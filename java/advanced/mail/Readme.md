# JavaMail

The JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications. The JavaMail API is available as an optional package for use with the Java SE platform and is also included in the Java EE platform.

In the years since its first release, the JavaTM programming language has matured to become a platform. The Java platform has added functionality, including distributed computing with RMI and CORBA, and a component architecture (JavaBeansTM). Java applications have also matured, and many need an addition to the Java platform: a mail and messaging framework.The JavaMailTM API described in this specification satisfies that need.

The JavaMail API provides a set of abstract classes defining objects that comprise a mail system. The API defines classes like Message, Store and Transport. The API can be extended and can be subclassed to provide new protocols and to add functionality when necessary.

In addition, the API provides concrete subclasses of the abstract classes. These subclasses,including MimeMessage and MimeBodyPart, implement widely used Internet mail protocols and conform to specifications RFC822 and RFC2045. They are ready to be used in application development.

## Architectural Overview

JavaMail provides elements that are used to construct an interface to a messaging system, including system components and interfaces. While this specification does not define any specific implementation, JavaMail does include several classes that implement RFC822 and MIME Internet messaging standards. These classes are delivered as part of the JavaMail class package.

The JavaMail architectural components are layered as shown below:

1. The Abstract Layer declares classes, interfaces and abstract methods intended to support mail handling functions that all mail systems support. API elements comprising the Abstract Layer are intended to be subclassed and extended as necessary in order to support standard data types, and to interface with message access and message transport protocols as necessary.
2. The internet implementation layer implements part of the abstract layer using internet standards - RFC822 and MIME.
3. JavaMail uses the JavaBeans Activation Framework (JAF) in order to encapsulate message data, and to handle commands intended to interact with that data. Interaction with message data should take place via JAF-aware JavaBeans, which are not provided by the JavaMail API.

JavaMail clients use the JavaMail API and Service Providers implement the JavaMail API.The layered design architecture allows clients to use the same JavaMail API calls to send,receive and store a variety of messages using different data-types from different message stores and using different message transport protocols.

## The JavaMail Framework

The JavaMail API is intended to perform the following functions, which comprise the standard mail handling process for a typical client application:

1. Create a mail message consisting of a collection of header attributes and a block of data of some known data type as specified in the Content-Type header field. JavaMail uses the Part interface and the Message class to define a mail message. It uses the JAF defined DataHandler object to contain data placed in the message.
2. Create a Session object, which authenticates the user, and controls access to the message store and transport.
3. Send the message to its recipient list.
4. Retrieve a message from a message store.Execute a high-level command on a retrieved message. High-level commands like view and print are intended to be implemented via JAF-Aware JavaBeans.

Note – The JavaMail framework does not define mechanisms that support message delivery,security, disconnected operation, directory services or filter functionality.

## Major JavaMail API Components

- The Message Class

The Message class is an abstract class that defines a set of attributes and a content for a mail message. Attributes of the Message class specify addressing information and define the structure of the content, including the content type. The content is represented as aDataHandler object that wraps around the actual data.

The Message class implements the Part interface. The Part interface defines attributes that are required to define and format data content carried by a Message object, and to interface successfully to a mail system. The Message class adds From, To, Subject,Reply-To, and other attributes necessary for message routing via a message transport system. When contained in a folder, a Message object has a set of flags associated with it.JavaMail provides Message subclasses that support specific messaging implementations.

The content of a message is a collection of bytes, or a reference to a collection of bytes,encapsulated within a Message object. JavaMail has no knowledge of the data type or format of the message content. A Message object interacts with its content through an intermediate layer—the JavaBeans Activation Framework (JAF). This separation allows a Message object to handle any arbitrary content and to transmit it using any appropriate transmission protocol by using calls to the same API methods. The message recipient usually knows the content data type and format and knows how to handle that content.The JavaMail API also supports multipart Message objects, where each Bodypart defines its own set of attributes and content.

- Message Storage and Retrieval

Messages are stored in Folder objects. A Folder object can contain subfolders as well as messages, thus providing a tree-like folder hierarchy. The Folder class declares methods that fetch, append, copy and delete messages. A Folder object can also send events to components registered as event listeners.

The Store class defines a database that holds a folder hierarchy together with its messages.
The Store class also specifies the access protocol that accesses folders and retrieves
messages stored in folders. The Store class also provides methods to establish a connection
to the database, to fetch folders and to close a connection. Service providers implementing
Message Access protocols (IMAP4, POP3, etc.) start off by subclassing the Store class. A
user typically starts a session with the mail system by connecting to a particular Store
implementation.

- Message Composition and Transport

A client creates a new message by instantiating an appropriate Message subclass. It sets
attributes like the recipient addresses and the subject, and inserts the content into the
Message object. Finally, it sends the Message by invoking the Transport.send
method.
The Transport class models the transport agent that routes a message to its destination
addresses. This class provides methods that send a message to a list of recipients. Invoking the
Transport.send method with a Message object identifies the appropriate transport based
on its destination addresses.

- The Session Class
The Session class defines global and per-user mail-related properties that define the
interface between a mail-enabled client and the network. JavaMail system components use the
Session object to set and get specific properties. The Session class also provides a default
authenticated session object that desktop applications can share. The Session class is a final
concrete class. It cannot be subclassed.
The Session class also acts as a factory for Store and Transport objects that implement
specific access and transport protocols. By calling the appropriate factory method on a
Session object, the client can obtain Store and Transport objects that support specific
protocols.
