# JavaMail

The JavaMail API is programming interface that makes it easy for java developers to write code that automatically sends an email.It depends on another API known as JavaBeans Activation Framework(JAF) API.

## How Mails work

Mail client software such as Outlook or Eudora allows you to send and retrieve messages.This software communiactes with the mail server software that actually sends and retrieves your email.Mail server software is provided by your Internet Service Provider(ISP) or through your company.

The SMTP protocol is commonly used to send email messages.When you send an email message,the message is first sent from mail client software on your computer to your email server using SMTP protocol.Then, your mail server uses SMTP to send the mail to the recipient's mail server.Finally, the recipient's mail client uses the POP protocol or IMAP protocol to retrieve the mail from recipient's mail server.

There is also MIME protocol,It isn't used to transfer email messages.Instead, it defines how the content of an email message and its attachments are formatted.

- Protocols for sending and retrieving email messages:-
    1. `SMTP(Simple Mail Transfer Protocol)` used to send a message from one mail server to another.
    2. `POP(Post office Protocol)` used to retrieve messages from a mail server.This protocol transfers all messages from mail server to mail client.Currently, POP is version 3 and is known as POP3
    3. `IMAP(Internet Message Access Protocol)` is used by web-based services such as Yahoo,Gmail and Hotmail.It allows a web browser to read messages stored on mail server.

- `MIME(Multipurpose Internet Message Extension)` type specifies the type of content that can be sent as a message or attachment.

## JavaMail API

The JavaMail API provides a set of abstract classes defining objects that comprise a mail system. The API defines classes like Message, Store and Transport. The API can be extended and can be subclassed to provide new protocols and to add functionality when necessary.

In addition, the API provides concrete subclasses of the abstract classes. These subclasses,including MimeMessage and MimeBodyPart, implement widely used Internet mail protocols and conform to specifications RFC822 and RFC2045. They are ready to be used in application development.

The JavaMailTM API provides classes that model a mail system.

1. The `javax.mail` package defines classes that are common to all mail systems.General email-handling classes(protocol handling,authentication,sending/receiving).It's key classes are:-
   1. Session - Manages configuration for connecting to mail server.
   2. Message - Represents the email message.
   3. Transport - Handles sending emails.
   4. Store - Used for retrieving emails.

2. The `javax.mail.internet` package defines classes that are specific to mail systems based on internet standards such as MIME, SMTP, POP3, and IMAP.Provide advanced internet email features.(MIME,HTML,attachments) to send an email across the Internet.
   1. MimeMessage - A subclass of Message that supports rich content like HTML and attachments.
   2. InternetAddress - Helps manage email addresses.
   3. MimeBodyPart and MimeMultipart - Enable you to build emails parts(texts + attachments).

- The JavaMail API is designed to serve several audiences:
   1. Client, server, or middleware developers interested in building mail and messaging applications using the Java programming language.
   2. Application developers who need to “mail-enable” their applications.
   3. Service Providers who need to implement specific access and transfer protocols. For example; a telecommunications company can use the JavaMail API to implement a PAGER Transport protocol that sends mail messages to alphanumeric pagers.

`java.util` - Contains the Properties class that's used to set the properties for the email session.

## Goals and Design Principles

The JavaMail API is designed to make adding electronic mail capability to simple applications easy, while also supporting the creation of sophisticated user interfaces. It includes appropriate convenience classes which encapsulate common mail functions and protocols. It fits with other packages for the Java platform in order to facilitate its use with other Java APIs, and it uses familiar programming models.
The JavaMail API is therefore designed to satisfy the following development and runtime requirements:

- Simple, straightforward class design is easy for a developer to learn and implement.
- Use of familiar concepts and programming models support code development that interfaces well with other Java APIs.
    1. Uses familiar exception-handling and JDK 1.1 event-handling programming models.
    2. Uses features from the JavaBeans Activation Framework (JAF) to handle access to data based on data-type and to facilitate the addition of data types and commands on
those data types. The JavaMail API provides convenience functions to simplify these coding tasks.
- Lightweight classes and interfaces make it easy to add basic mail-handling tasks to any application.
- Supports the development of robust mail-enabled applications, that can handle a variety of complex mail message formats, data types, and access and transport protocols.

The JavaMail API draws heavily from IMAP, MAPI, CMC, c-client and other messaging system APIs: many of the concepts present in these other systems are also present in the
JavaMail API. It is simpler to use because it uses features of the Java programming language not available to these other APIs, and because it uses the Java programming language’s object
model to shelter applications from implementation complexity.

The JavaMail API design is driven by the needs of the applications it supports—but it is also important to consider the needs of API implementors. It is critically important to enable the
implementation of messaging systems written using the Java programming language that interoperate with existing messaging systems—especially Internet mail. It is also important to
anticipate the development of new messaging systems. The JavaMail API conforms to current standards while not being so constrained by current standards that it stifles future innovation.

## Architectural Overview

JavaMail provides elements that are used to construct an interface to a messaging system, including system components and interfaces. While this specification does not define any specific implementation, JavaMail does include several classes that implement RFC822 and MIME Internet messaging standards. These classes are delivered as part of the JavaMail class package.

The JavaMail architectural components are layered as:

1. The Abstract Layer declares classes, interfaces and abstract methods intended to support mail handling functions that all mail systems support. API elements comprising the Abstract Layer are intended to be subclassed and extended as necessary in order to support standard data types, and to interface with message access and message transport protocols as necessary.It defines what should be done, not how to do it.Developers can extend or implement these to work with any email system.
2. The internet implementation layer implements part of the abstract layer using internet standards - RFC822 and MIME.RFC 822 = rules for email format (headers like To, From, Subject),MIME = rules for attachments, images, HTML in email.
3. JavaMail uses the JavaBeans Activation Framework (JAF) in order to encapsulate message data, and to handle commands intended to interact with that data. Interaction with message data should take place via JAF-aware JavaBeans, which are not provided by the JavaMail API.JAF lets Java understand what to do with content like: .txt → Show text, .jpg → Show image, .pdf → Open or attachJAF uses JavaBeans that are specially built to understand and display this content.

JavaMail clients use the JavaMail API and Service Providers implement the JavaMail API.The layered design architecture allows clients to use the same JavaMail API calls to send,receive and store a variety of messages using different data-types from different message stores and using different message transport protocols.These are plug-ins or drivers that do the actual work of sending and receiving email.For example: SMTP provider → sends email, IMAP or POP3 provider → reads email from a server. You can switch between providers and still use the same Jakarta Mail API.

Message----->Transport-------->Network Infrastructure------->Store---------->Folders-------->Message

- `The JavaMail Framework`:-The JavaMail API is intended to perform the following functions, which comprise the standard mail handling process for a typical client application:

1. Create a mail message consisting of a collection of header attributes and a block of data of some known data type as specified in the Content-Type header field. JavaMail uses the Part interface and the Message class to define a mail message. It uses the JAF defined DataHandler object to contain data placed in the message.
2. Create a Session object, which authenticates the user, and controls access to the message store and transport.
3. Send the message to its recipient list.
4. Retrieve a message from a message store.
5. Execute a high-level command on a retrieved message. High-level commands like view and print are intended to be implemented via JAF-Aware JavaBeans.

Note – The JavaMail framework does not define mechanisms that support message delivery,security, disconnected operation, directory services or filter functionality.

- **Major JavaMail API Components**:- Major components comprising the JavaMail architecture.

1. `The Message Class`:- The Message class is an abstract class that defines a set of attributes and a content for a mail message. Attributes of the Message class specify addressing information and define the structure of the content, including the content type. The content is represented as a DataHandler object that wraps around the actual data.
The Message class implements the `Part interface`. The Part interface defines attributes that are required to define and format data content carried by a Message object, and to interface successfully to a mail system. The Message class adds From, To, Subject,Reply-To, and other attributes necessary for message routing via a message transport system. When contained in a folder, a Message object has a set of flags associated with it.JavaMail provides Message subclasses that support specific messaging implementations.
 The content of a message is a collection of bytes, or a reference to a collection of bytes,encapsulated within a Message object. JavaMail has no knowledge of the data type or format of the message content. A Message object interacts with its content through an intermediate layer—the JavaBeans Activation Framework (JAF). This separation allows a Message object to handle any arbitrary content and to transmit it using any appropriate transmission protocol by using calls to the same API methods. The message recipient usually knows the content data type and format and knows how to handle that content.The JavaMail API also supports multipart Message objects, where each Bodypart defines its own set of attributes and content.
The JavaMail API also supports multipart Message objects, where each Bodypart defines its own set of attributes and content

2. `Message Storage and Retrieval`:- Messages are stored in Folder objects. A Folder object can contain subfolders as well as messages, thus providing a tree-like folder hierarchy. The Folder class declares methods that fetch, append, copy and delete messages. A Folder object can also send events to components registered as event listeners.
 The Store class defines a database that holds a folder hierarchy together with its messages.The Store class also specifies the access protocol that accesses folders and retrieves messages stored in folders. The Store class also provides methods to establish a connection to the database, to fetch folders and to close a connection. Service providers implementing Message Access protocols (IMAP4, POP3, etc.) start off by subclassing the Store class. A user typically starts a session with the mail system by connecting to a particular Store implementation.

3. `Message Composition and Transport`:- A client creates a new message by instantiating an appropriate Message subclass. It sets attributes like the recipient addresses and the subject, and inserts the content into the Message object. Finally, it sends the Message by invoking the Transport.send method.
The Transport class models the transport agent that routes a message to its destination addresses. This class provides methods that send a message to a list of recipients. Invoking the Transport.send method with a Message object identifies the appropriate transport based on its destination addresses.

4. `The Session Class`:- The Session class defines global and per-user mail-related properties that define the interface between a mail-enabled client and the network. JavaMail system components use the Session object to set and get specific properties. The Session class also provides a default authenticated session object that desktop applications can share. The Session class is a final concrete class. It cannot be subclassed.
The Session class also acts as a factory for Store and Transport objects that implement specific access and transport protocols. By calling the appropriate factory method on a Session object, the client can obtain Store and Transport objects that support specific protocols.

- **The JavaMail Event Model**:- The JavaMail event model conforms to the JDK 1.1 event-model specification, as described in the JavaBeans Specification. The JavaMail API follows the design patterns defined in the JavaBeans Specification for naming events, event methods and event listener registration.
All events are subclassed from the MailEvent class. Clients listen for specific events by registering themselves as listeners for those events. Events notify listeners of state changes as a session progresses. During a session, a JavaMail component generates a specific event-type to notify objects registered as listeners for that event-type. The JavaMail Store, Folder,and Transport classes are event sources. This specification describes each specific event in the section that describes the class that generates that event.

## Basic Workflow

1. Set Up Mail Server Properties:- Configure settings such as SMTP server address,port and whether to use authentication
2. Create a session:- This is your connection context to the mail server.It includes your credentials and configuration properties.
3. Build The Email Message:- Construct your email.You can set the sender,recipient,subject and content(plain text or HTML)
4. Send the email:- Use Transport class to send message through configured SMTP server.

```java
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SimpleEmailSender {
    public static void main(String[] args) {
        // Step 1: Configure the mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Your SMTP server
        props.put("mail.smtp.port", "587"); // Port for TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Enable TLS

        // Step 2: Create a Session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("your_email@gmail.com", "your_app_password");
            }
        });
        try {
            // Step 3: Create the email message using MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("your_email@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
            message.setSubject("Hello from JavaMail API");
            message.setText("This is a simple email sent using JavaMail API.");

            // Step 4: Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

```

## Classes and Interfaces

- **The Message Class**:- The Message class defines a set of attributes and a content for a mail message. Message attributes specify message addressing information and define the structure of the content,including the content type. The content is represented by a DataHandler object that wraps around the actual data. The Message class is an abstract class that implements the `Part interface`.
Subclasses of the Message classes can implement several standard message formats. For example, the JavaMail API provides the `MimeMessage class`, that extends the Message
class to implement the RFC822 and MIME standards. Implementations can typically construct themselves from byte streams and generate byte streams for transmission.

It represents email message.It provides methods to set and retrieve email attributes like sender,recipient,subject and content.Since it is an abstract class, you cannot initiate it directly,instead you use MimeMessage to create email.
A Message subclass instantiates an object that holds message content, together with attributes that specify addresses for the sender and recipients, structural information about the message, and the content type of the message body. Messages placed into a folder also have a set of flags that describe the state of the message within the folder.

The Message object has no direct knowledge of the nature or semantics of its content. This separation of structure from content allows the message object to contain any arbitrary content.
Message objects are either retrieved from a `Folder object` or constructed by instantiating a new Message object of the appropriate subclass. Messages stored within a Folder object are sequentially numbered, starting at one. An assigned message number can change when the folder is expunged, since the expunge operation removes deleted messages from the folder and also renumbers the remaining messages.
A Message object can contain multiple parts, where each part contains its own set of attributes and content. The content of a multipart message is a `Multipart object` that
contains BodyPart objects representing each individual part. The `Part interface` defines the structural and semantic similarity between the Message class and the `BodyPart class`.

This class models an email message. This is an abstract class. Subclasses provide actual implementations.

Direct Known Subclasses:- MimeMessage

Message implements the Part interface. Message contains a set of attributes and a "content". Messages within a folder also have a set of flags that describe its state within the folder.

Message defines some new attributes in addition to those defined in the Part interface. These attributes specify meta-data for the message - i.e., addressing and descriptive information about the message.

Message objects are obtained either from a Folder or by constructing a new Message object of the appropriate subclass. Messages that have been received are normally retrieved from a folder named "INBOX".

A Message object obtained from a folder is just a lightweight reference to the actual message. The Message is 'lazily' filled up (on demand) when each item is requested from the message. Note that certain folder implementations may return Message objects that are pre-filled with certain user-specified items. To send a message, an appropriate subclass of Message (e.g., MimeMessage) is instantiated, the attributes and content are filled in, and the message is sent using the Transport.send method.

The Message class defines a set of attributes and a content for a mail message. Message attributes specify message addressing information and define the structure of the content,including the content type. The content is represented by a DataHandler object that wraps around the actual data. The Message class is an abstract class that implements the Part interface.

Subclasses of the Message classes can implement several standard message formats. For example, the JavaMail API provides the MimeMessage class, that extends the Message class to implement the RFC822 and MIME standards. Implementations can typically construct themselves from byte streams and generate byte streams for transmission.

A Message subclass instantiates an object that holds message content, together with attributes that specify addresses for the sender and recipients, structural information about the message, and the content type of the message body. Messages placed into a folder also have a set of flags that describe the state of the message within the folder.

The Message object has no direct knowledge of the nature or semantics of its content. This separation of structure from content allows the message object to contain any arbitrary content.Message objects are either retrieved from a Folder object or constructed by instantiating a new Message object of the appropriate subclass. Messages stored within a Folder object are sequentially numbered, starting at one. An assigned message number can change when the folder is expunged, since the expunge operation removes deleted messages from the folder and also renumbers the remaining messages.

A Message object can contain multiple parts, where each part contains its own set of attributes and content. The content of a multipart message is a Multipart object that contains BodyPart objects representing each individual part. The Part interface defines the structural and semantic similarity between the Message class and the BodyPart class.

Key methods includes:-

abstract void 	addFrom(Address[] addresses) - Add these addresses to the existing "From" attribute
void 	addRecipient(Message.RecipientType type, Address address) - Add this recipient address to the existing ones of the given type.
abstract void 	addRecipients(Message.RecipientType type, Address[] addresses) - Add these recipient addresses to the existing ones of the given type.
Address[] 	getAllRecipients() - Get all the recipient addresses for the message.
abstract Flags 	getFlags() - Returns a Flags object containing the flags for this message.
Folder 	getFolder() - Get the folder from which this message was obtained.
abstract Address[] 	getFrom() - Returns the "From" attribute.
int 	getMessageNumber() - Get the Message number for this Message.
abstract Date 	getReceivedDate() - Get the date this message was received.
abstract Address[] 	getRecipients(Message.RecipientType type) - Get all the recipient addresses of the given type.
Address[] 	getReplyTo() - Get the addresses to which replies should be directed.
abstract Date 	getSentDate() - Get the date this message was sent.
Session 	getSession() - Return the Session used when this message was created.
abstract String 	getSubject() - Get the subject of this message.
boolean 	isExpunged() - Checks whether this message is expunged.
boolean 	isSet(Flags.Flag flag) - Check whether the flag specified in the flag argument is set in this message.
boolean 	match(SearchTerm term) - Apply the specified Search criterion to this message.
abstract Message 	reply(boolean replyToAll) - Get a new Message suitable for a reply to this message.
abstract void 	saveChanges() - Save any changes made to this message into the message-store when the containing folder is closed, if the message is contained in a folder.
protected void 	setExpunged(boolean expunged) - Sets the expunged flag for this Message.
void 	setFlag(Flags.Flag flag, boolean set)- Set the specified flag on this message to the specified value.
abstract void 	setFlags(Flags flag, boolean set)- Set the specified flags on this message to the specified value.
abstract void 	setFrom()- Set the "From" attribute in this Message.Sets sender of the email.
abstract void 	setFrom(Address address)- Set the "From" attribute in this Message.
protected void 	setMessageNumber(int msgnum) - Set the Message number for this Message.
void 	setRecipient(Message.RecipientType type, Address address) - Set the recipient address.
abstract void 	setRecipients(Message.RecipientType type, Address[] addresses) - Set the recipient addresses.(To,CC,BCC)
void 	setReplyTo(Address[] addresses) - Set the addresses to which replies should be directed.
abstract void 	setSentDate(Date date) - Set the sent date of this message.
abstract void 	setSubject(String subject) - Set the subject of this message.Sets subject of email.

`Class MimeMessage`:- This class represents a MIME style email message. It implements the Message abstract class and the MimePart interface.

- The Multipurpose Internet Mail Extensions(MIME) standard allows email to include different type of contents in a  structured way.This includes:-
  1. Plain text(simple text content)
  2. HTML Content(formatted emails with colors,images and links).
  3. Attachments(PDFs,images,documents).
  4. Multiple Recipients(To,CC,BCC)

If we just send a raw text string using SMTP,it won't support (HTML formatting,Attachments,Multiple parts-text + HTML together)

All Implemented Interfaces:- MimePart, Part

Clients wanting to create new MIME style messages will instantiate an empty MimeMessage object and then fill it with appropriate attributes and content. Service providers that implement MIME compliant backend stores may want to subclass MimeMessage and override certain methods to provide specific implementations. The simplest case is probably a provider that generates a MIME style input stream and leaves the parsing of the stream to this class.
MimeMessage uses the InternetHeaders class to parse and store the top level RFC 822 headers of a message.

The mail.mime.address.strict session property controls the parsing of address headers. By default, strict parsing of address headers is done. If this property is set to "false", strict parsing is not done and many illegal addresses that sometimes occur in real messages are allowed. See the InternetAddress class for details.

A note on RFC 822 and MIME headers :- RFC 822 header fields must contain only US-ASCII characters. MIME allows non ASCII characters to be present in certain portions of certain headers, by encoding those characters. RFC 2047 specifies the rules for doing this. The MimeUtility class provided in this package can be used to to achieve this. Callers of the setHeader, addHeader, and addHeaderLine methods are responsible for enforcing the MIME requirements for the specified headers. In addition, these header fields must be folded (wrapped) before being sent if they exceed the line length limitation for the transport (1000 bytes for SMTP). Received headers may have been folded. The application is responsible for folding and unfolding headers as appropriate.

Nested Class Summary

1. static class MimeMessage.RecipientType - This inner class extends the javax.mail.Message.RecipientType class to add additional RecipientTypes.

Field Summary

1. protected Object 	cachedContent - If our content is a Multipart or Message object, we save it the first time it's created by parsing a stream so that changes to the contained objects will not be lost.
2. protected byte[] 	content  - Byte array that holds the bytes of this Message's content.
3. protected InputStream 	contentStream - If the data for this message was supplied by an InputStream that implements the SharedInputStream interface, contentStream is another such stream representing the content of this message.
4. protected DataHandler 	dh - The DataHandler object representing this Message's content.
5. protected Flags flags - The Flags for this message.
6. protected InternetHeaders 	headers  - The InternetHeaders object that stores the header of this message.
7. protected boolean 	modified  - A flag indicating whether the message has been modified.
8. protected boolean 	saved  - Does the saveChanges method need to be called on this message? This flag is set to false by the public constructor and set to true by the saveChanges method.

Fields inherited from class javax.mail.Message - expunged, folder, msgnum, session
Fields inherited from interface javax.mail.Part - ATTACHMENT, INLINE
Constructor Summary

1. protected 	MimeMessage(Folder folder, InputStream is, int msgnum) - Constructs a MimeMessage by reading and parsing the data from the specified MIME InputStream.
2. protected 	MimeMessage(Folder folder, int msgnum) - Constructs an empty MimeMessage object with the given Folder and message number.
3. protected 	MimeMessage(Folder folder, InternetHeaders headers, byte[] content, int msgnum) - Constructs a MimeMessage from the given InternetHeaders object and content.
4. MimeMessage(MimeMessage source) - Constructs a new MimeMessage with content initialized from the source MimeMessage.
5. MimeMessage(Session session)

Default constructor.
MimeMessage(Session session, InputStream is) - Constructs a MimeMessage by reading and parsing the data from the specified MIME InputStream.

Method Summary

        All MethodsInstance MethodsConcrete Methods Modifier and Type 	Method and Description
        void 	addFrom(Address[] addresses)
        Add the specified addresses to the existing "From" field.
        void 	addHeader(String name, String value)
        Add this value to the existing values for this header_name.
        void 	addHeaderLine(String line)
        Add a raw RFC 822 header-line.
        void 	addRecipients(Message.RecipientType type, Address[] addresses)
        Add the given addresses to the specified recipient type.
        void 	addRecipients(Message.RecipientType type, String addresses)
        Add the given addresses to the specified recipient type.
        protected InternetHeaders 	createInternetHeaders(InputStream is)
        Create and return an InternetHeaders object that loads the headers from the given InputStream.
        protected MimeMessage 	createMimeMessage(Session session)
        Create and return a MimeMessage object.
        Enumeration 	getAllHeaderLines()
        Get all header lines as an Enumeration of Strings.
        Enumeration 	getAllHeaders()
        Return all the headers from this Message as an enumeration of Header objects.
        Address[] 	getAllRecipients()
        Get all the recipient addresses for the message.
        Object 	getContent()
        Return the content as a Java object.
        String 	getContentID()
        Returns the value of the "Content-ID" header field.
        String[] 	getContentLanguage()
        Get the languages specified in the "Content-Language" header field of this message.
        String 	getContentMD5()
        Return the value of the "Content-MD5" header field.
        protected InputStream 	getContentStream()
        Produce the raw bytes of the content.
        String 	getContentType()
        Returns the value of the RFC 822 "Content-Type" header field.
        DataHandler 	getDataHandler()
        Return a DataHandler for this Message's content.
        String 	getDescription()
        Returns the "Content-Description" header field of this Message.
        String 	getDisposition()
        Returns the value of the "Content-Disposition" header field.
        String 	getEncoding()
        Returns the content transfer encoding from the "Content-Transfer-Encoding" header field.
        String 	getFileName()
        Get the filename associated with this Message.
        Flags 	getFlags()
        Return a Flags object containing the flags for this message.
        Address[] 	getFrom()
        Returns the value of the RFC 822 "From" header fields.
        String[] 	getHeader(String name)
        Get all the headers for this header_name.
        String 	getHeader(String name, String delimiter)
        Get all the headers for this header name, returned as a single String, with headers separated by the delimiter.
        InputStream 	getInputStream()
        Return a decoded input stream for this Message's "content".
        int 	getLineCount()
        Return the number of lines for the content of this message.
        Enumeration 	getMatchingHeaderLines(String[] names)
        Get matching header lines as an Enumeration of Strings.
        Enumeration 	getMatchingHeaders(String[] names)
        Return matching headers from this Message as an Enumeration of Header objects.
        String 	getMessageID()
        Returns the value of the "Message-ID" header field.
        Enumeration 	getNonMatchingHeaderLines(String[] names)
        Get non-matching header lines as an Enumeration of Strings.
        Enumeration 	getNonMatchingHeaders(String[] names)
        Return non-matching headers from this Message as an Enumeration of Header objects.
        InputStream 	getRawInputStream()
        Return an InputStream to the raw data with any Content-Transfer-Encoding intact.
        Date 	getReceivedDate()
        Returns the Date on this message was received.
        Address[] 	getRecipients(Message.RecipientType type)
        Returns the recepients specified by the type.
        Address[] 	getReplyTo()
        Return the value of the RFC 822 "Reply-To" header field.
        Address 	getSender()
        Returns the value of the RFC 822 "Sender" header field.
        Date 	getSentDate()
        Returns the value of the RFC 822 "Date" field.
        int 	getSize()
        Return the size of the content of this message in bytes.
        String 	getSubject()
        Returns the value of the "Subject" header field.
        boolean 	isMimeType(String mimeType)
        Is this Part of the specified MIME type? This method compares only the primaryType and subType.
        boolean 	isSet(Flags.Flag flag)
        Check whether the flag specified in the flag argument is set in this message.
        protected void 	parse(InputStream is)
        Parse the InputStream setting the headers and content fields appropriately.
        void 	removeHeader(String name)
        Remove all headers with this name.
        Message 	reply(boolean replyToAll)
        Get a new Message suitable for a reply to this message.
        Message 	reply(boolean replyToAll, boolean setAnswered)
        Get a new Message suitable for a reply to this message.
        void 	saveChanges()
        Updates the appropriate header fields of this message to be consistent with the message's contents.
        void 	setContent(Multipart mp)
        This method sets the Message's content to a Multipart object.
        void 	setContent(Object o, String type)
        A convenience method for setting this Message's content.
        void 	setContentID(String cid)
        Set the "Content-ID" header field of this Message.
        void 	setContentLanguage(String[] languages)
        Set the "Content-Language" header of this MimePart.
        void 	setContentMD5(String md5)
        Set the "Content-MD5" header field of this Message.
        void 	setDataHandler(DataHandler dh)
        This method provides the mechanism to set this part's content.
        void 	setDescription(String description)
        Set the "Content-Description" header field for this Message.
        void 	setDescription(String description, String charset)
        Set the "Content-Description" header field for this Message.
        void 	setDisposition(String disposition)
        Set the "Content-Disposition" header field of this Message.
        void 	setFileName(String filename)
        Set the filename associated with this part, if possible.
        void 	setFlags(Flags flag, boolean set)
        Set the flags for this message.
        void 	setFrom()
        Set the RFC 822 "From" header field using the value of the InternetAddress.getLocalAddress method.
        void 	setFrom(Address address)
        Set the RFC 822 "From" header field.
        void 	setFrom(String address)
        Set the RFC 822 "From" header field.
        void 	setHeader(String name, String value)
        Set the value for this header_name.
        void 	setRecipients(Message.RecipientType type, Address[] addresses)
        Set the specified recipient type to the given addresses.
        void 	setRecipients(Message.RecipientType type, String addresses)
        Set the specified recipient type to the given addresses.
        void 	setReplyTo(Address[] addresses)
        Set the RFC 822 "Reply-To" header field.
        void 	setSender(Address address)
        Set the RFC 822 "Sender" header field.
        void 	setSentDate(Date d)
        Set the RFC 822 "Date" header field.
        void 	setSubject(String subject)
        Set the "Subject" header field.
        void 	setSubject(String subject, String charset)
        Set the "Subject" header field.
        void 	setText(String text)
        Convenience method that sets the given String as this part's content, with a MIME type of "text/plain".
        void 	setText(String text, String charset)
        Convenience method that sets the given String as this part's content, with a MIME type of "text/plain" and the specified charset.
        void 	setText(String text, String charset, String subtype)
        Convenience method that sets the given String as this part's content, with a primary MIME type of "text" and the specified MIME subtype.
        protected void 	updateHeaders()
        Called by the saveChanges method to actually update the MIME headers.
        protected void 	updateMessageID()
        Update the Message-ID header.
        void 	writeTo(OutputStream os)
        Output the message as an RFC 822 format stream.
        void 	writeTo(OutputStream os, String[] ignoreList)
        Output the message as an RFC 822 format stream, without specified headers.
            Methods inherited from class javax.mail.Message
            addRecipient, getFolder, getMessageNumber, getSession, isExpunged, match, setExpunged, setFlag, setMessageNumber, setRecipient
            Methods inherited from class java.lang.Object
            clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait

        Field Detail
            dh

            protected DataHandler dh

            The DataHandler object representing this Message's content.
            content

            protected byte[] content

            Byte array that holds the bytes of this Message's content.
            contentStream

            protected InputStream contentStream

            If the data for this message was supplied by an InputStream that implements the SharedInputStream interface, contentStream is another such stream representing the content of this message. In this case, content will be null.

            Since:
                JavaMail 1.2

            headers

            protected InternetHeaders headers

            The InternetHeaders object that stores the header of this message.
            flags

            protected Flags flags

            The Flags for this message.
            modified

            protected boolean modified

            A flag indicating whether the message has been modified. If the message has not been modified, any data in the content array is assumed to be valid and is used directly in the writeTo method. This flag is set to true when an empty message is created or when the saveChanges method is called.

            Since:
                JavaMail 1.2

            saved

            protected boolean saved

            Does the saveChanges method need to be called on this message? This flag is set to false by the public constructor and set to true by the saveChanges method. The writeTo method checks this flag and calls the saveChanges method as necessary. This avoids the common mistake of forgetting to call the saveChanges method on a newly constructed message.

            Since:
                JavaMail 1.2

            cachedContent

            protected Object cachedContent

            If our content is a Multipart or Message object, we save it the first time it's created by parsing a stream so that changes to the contained objects will not be lost.

            If this field is not null, it's return by the getContent() method. The getContent() method sets this field if it would return a Multipart or MimeMessage object. This field is is cleared by the setDataHandler(javax.activation.DataHandler) method.

            Since:
                JavaMail 1.5

        Constructor Detail
            MimeMessage

            public MimeMessage(Session session)

            Default constructor. An empty message object is created. The headers field is set to an empty InternetHeaders object. The flags field is set to an empty Flags object. The modified flag is set to true.
            MimeMessage

            public MimeMessage(Session session,
                               InputStream is)
                        throws MessagingException

            Constructs a MimeMessage by reading and parsing the data from the specified MIME InputStream. The InputStream will be left positioned at the end of the data for the message. Note that the input stream parse is done within this constructor itself.

            The input stream contains an entire MIME formatted message with headers and data.

            Parameters:
                session - Session object for this message
                is - the message input stream
            Throws:
                MessagingException

            MimeMessage

            public MimeMessage(MimeMessage source)
                        throws MessagingException

            Constructs a new MimeMessage with content initialized from the source MimeMessage. The new message is independent of the original.

            Note: The current implementation is rather inefficient, copying the data more times than strictly necessary.

            Parameters:
                source - the message to copy content from
            Throws:
                MessagingException
            Since:
                JavaMail 1.2

            MimeMessage

            protected MimeMessage(Folder folder,
                                  int msgnum)

            Constructs an empty MimeMessage object with the given Folder and message number.

            This method is for providers subclassing MimeMessage.
            MimeMessage

            protected MimeMessage(Folder folder,
                                  InputStream is,
                                  int msgnum)
                           throws MessagingException

            Constructs a MimeMessage by reading and parsing the data from the specified MIME InputStream. The InputStream will be left positioned at the end of the data for the message. Note that the input stream parse is done within this constructor itself.

            This method is for providers subclassing MimeMessage.

            Parameters:
                folder - The containing folder.
                is - the message input stream
                msgnum - Message number of this message within its folder
            Throws:
                MessagingException

            MimeMessage

            protected MimeMessage(Folder folder,
                                  InternetHeaders headers,
                                  byte[] content,
                                  int msgnum)
                           throws MessagingException

            Constructs a MimeMessage from the given InternetHeaders object and content. This method is for providers subclassing MimeMessage.

            Parameters:
                folder - The containing folder.
                headers - The headers
                content - The message content
                msgnum - Message number of this message within its folder
            Throws:
                MessagingException

        Method Detail
            parse

            protected void parse(InputStream is)
                          throws MessagingException

            Parse the InputStream setting the headers and content fields appropriately. Also resets the modified flag.

            This method is intended for use by subclasses that need to control when the InputStream is parsed.

            Parameters:
                is - The message input stream
            Throws:
                MessagingException

            getFrom

            public Address[] getFrom()
                              throws MessagingException

            Returns the value of the RFC 822 "From" header fields. If this header field is absent, the "Sender" header field is used. If the "Sender" header field is also absent, null is returned.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getFrom in class Message
            Returns:
                Address object
            Throws:
                MessagingException
            See Also:
                headers

            setFrom

            public void setFrom(Address address)
                         throws MessagingException

            Set the RFC 822 "From" header field. Any existing values are replaced with the given address. If address is null, this header is removed.

            Specified by:
                setFrom in class Message
            Parameters:
                address - the sender of this message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            setFrom

            public void setFrom(String address)
                         throws MessagingException

            Set the RFC 822 "From" header field. Any existing values are replaced with the given addresses. If address is null, this header is removed.

            Parameters:
                address - the sender(s) of this message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            Since:
                JvaMail 1.5

            setFrom

            public void setFrom()
                         throws MessagingException

            Set the RFC 822 "From" header field using the value of the InternetAddress.getLocalAddress method.

            Specified by:
                setFrom in class Message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            addFrom

            public void addFrom(Address[] addresses)
                         throws MessagingException

            Add the specified addresses to the existing "From" field. If the "From" field does not already exist, it is created.

            Specified by:
                addFrom in class Message
            Parameters:
                addresses - the senders of this message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getSender

            public Address getSender()
                              throws MessagingException

            Returns the value of the RFC 822 "Sender" header field. If the "Sender" header field is absent, null is returned.

            This implementation uses the getHeader method to obtain the requisite header field.

            Returns:
                Address object
            Throws:
                MessagingException
            Since:
                JavaMail 1.3
            See Also:
                headers

            setSender

            public void setSender(Address address)
                           throws MessagingException

            Set the RFC 822 "Sender" header field. Any existing values are replaced with the given address. If address is null, this header is removed.

            Parameters:
                address - the sender of this message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            Since:
                JavaMail 1.3

            getRecipients

            public Address[] getRecipients(Message.RecipientType type)
                                    throws MessagingException

            Returns the recepients specified by the type. The mapping between the type and the corresponding RFC 822 header is as follows:

                            Message.RecipientType.TO                "To"
                            Message.RecipientType.CC                "Cc"
                            Message.RecipientType.BCC               "Bcc"
                            MimeMessage.RecipientType.NEWSGROUPS    "Newsgroups"
             


            Returns null if the header specified by the type is not found or if its value is empty.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getRecipients in class Message
            Parameters:
                type - Type of recepient
            Returns:
                array of Address objects
            Throws:
                MessagingException - if header could not be retrieved
                AddressException - if the header is misformatted
            See Also:
                headers, Message.RecipientType.TO, Message.RecipientType.CC, Message.RecipientType.BCC, MimeMessage.RecipientType.NEWSGROUPS

            getAllRecipients

            public Address[] getAllRecipients()
                                       throws MessagingException

            Get all the recipient addresses for the message. Extracts the TO, CC, BCC, and NEWSGROUPS recipients.

            Overrides:
                getAllRecipients in class Message
            Returns:
                array of Address objects
            Throws:
                MessagingException
            See Also:
                Message.RecipientType.TO, Message.RecipientType.CC, Message.RecipientType.BCC, MimeMessage.RecipientType.NEWSGROUPS

            setRecipients

            public void setRecipients(Message.RecipientType type,
                                      Address[] addresses)
                               throws MessagingException

            Set the specified recipient type to the given addresses. If the address parameter is null, the corresponding recipient field is removed.

            Specified by:
                setRecipients in class Message
            Parameters:
                type - Recipient type
                addresses - Addresses
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            See Also:
                getRecipients(javax.mail.Message.RecipientType)

            setRecipients

            public void setRecipients(Message.RecipientType type,
                                      String addresses)
                               throws MessagingException

            Set the specified recipient type to the given addresses. If the address parameter is null, the corresponding recipient field is removed.

            Parameters:
                type - Recipient type
                addresses - Addresses
            Throws:
                AddressException - if the attempt to parse the addresses String fails
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            Since:
                JavaMail 1.2
            See Also:
                getRecipients(javax.mail.Message.RecipientType)

            addRecipients

            public void addRecipients(Message.RecipientType type,
                                      Address[] addresses)
                               throws MessagingException

            Add the given addresses to the specified recipient type.

            Specified by:
                addRecipients in class Message
            Parameters:
                type - Recipient type
                addresses - Addresses
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            addRecipients

            public void addRecipients(Message.RecipientType type,
                                      String addresses)
                               throws MessagingException

            Add the given addresses to the specified recipient type.

            Parameters:
                type - Recipient type
                addresses - Addresses
            Throws:
                AddressException - if the attempt to parse the addresses String fails
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            Since:
                JavaMail 1.2

            getReplyTo

            public Address[] getReplyTo()
                                 throws MessagingException

            Return the value of the RFC 822 "Reply-To" header field. If this header is unavailable or its value is absent, then the getFrom method is called and its value is returned. This implementation uses the getHeader method to obtain the requisite header field.

            Overrides:
                getReplyTo in class Message
            Returns:
                addresses to which replies should be directed
            Throws:
                MessagingException
            See Also:
                headers

            setReplyTo

            public void setReplyTo(Address[] addresses)
                            throws MessagingException

            Set the RFC 822 "Reply-To" header field. If the address parameter is null, this header is removed.

            Overrides:
                setReplyTo in class Message
            Parameters:
                addresses - addresses to which replies should be directed
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
                MethodNotSupportedException - if the underlying implementation does not support setting this attribute

            getSubject

            public String getSubject()
                              throws MessagingException

            Returns the value of the "Subject" header field. Returns null if the subject field is unavailable or its value is absent.

            If the subject is encoded as per RFC 2047, it is decoded and converted into Unicode. If the decoding or conversion fails, the raw data is returned as is.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getSubject in class Message
            Returns:
                Subject
            Throws:
                MessagingException
            See Also:
                headers

            setSubject

            public void setSubject(String subject)
                            throws MessagingException

            Set the "Subject" header field. If the subject contains non US-ASCII characters, it will be encoded using the platform's default charset. If the subject contains only US-ASCII characters, no encoding is done and it is used as-is. If the subject is null, the existing "Subject" field is removed.

            The application must ensure that the subject does not contain any line breaks.

            Note that if the charset encoding process fails, a MessagingException is thrown, and an UnsupportedEncodingException is included in the chain of nested exceptions within the MessagingException.

            Specified by:
                setSubject in class Message
            Parameters:
                subject - The subject
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException. - An UnsupportedEncodingException may be included in the exception chain if the charset conversion fails.
                MessagingException

            setSubject

            public void setSubject(String subject,
                                   String charset)
                            throws MessagingException

            Set the "Subject" header field. If the subject contains non US-ASCII characters, it will be encoded using the specified charset. If the subject contains only US-ASCII characters, no encoding is done and it is used as-is. If the subject is null, the existing "Subject" header field is removed.

            The application must ensure that the subject does not contain any line breaks.

            Note that if the charset encoding process fails, a MessagingException is thrown, and an UnsupportedEncodingException is included in the chain of nested exceptions within the MessagingException.

            Parameters:
                subject - The subject
                charset - The charset
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException. - An UnsupportedEncodingException may be included in the exception chain if the charset conversion fails.
                MessagingException

            getSentDate

            public Date getSentDate()
                             throws MessagingException

            Returns the value of the RFC 822 "Date" field. This is the date on which this message was sent. Returns null if this field is unavailable or its value is absent.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getSentDate in class Message
            Returns:
                The sent Date
            Throws:
                MessagingException

            setSentDate

            public void setSentDate(Date d)
                             throws MessagingException

            Set the RFC 822 "Date" header field. This is the date on which the creator of the message indicates that the message is complete and ready for delivery. If the date parameter is null, the existing "Date" field is removed.

            Specified by:
                setSentDate in class Message
            Parameters:
                d - the sent date of this message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getReceivedDate

            public Date getReceivedDate()
                                 throws MessagingException

            Returns the Date on this message was received. Returns null if this date cannot be obtained.

            Note that RFC 822 does not define a field for the received date. Hence only implementations that can provide this date need return a valid value.

            This implementation returns null.

            Specified by:
                getReceivedDate in class Message
            Returns:
                the date this message was received
            Throws:
                MessagingException

            getSize

            public int getSize()
                        throws MessagingException

            Return the size of the content of this message in bytes. Return -1 if the size cannot be determined.

            Note that this number may not be an exact measure of the content size and may or may not account for any transfer encoding of the content.

            This implementation returns the size of the content array (if not null), or, if contentStream is not null, and the available method returns a positive number, it returns that number as the size. Otherwise, it returns -1.

            Specified by:
                getSize in interface Part
            Returns:
                size of content in bytes
            Throws:
                MessagingException

            getLineCount

            public int getLineCount()
                             throws MessagingException

            Return the number of lines for the content of this message. Return -1 if this number cannot be determined.

            Note that this number may not be an exact measure of the content length and may or may not account for any transfer encoding of the content.

            This implementation returns -1.

            Specified by:
                getLineCount in interface Part
            Returns:
                number of lines in the content.
            Throws:
                MessagingException

            getContentType

            public String getContentType()
                                  throws MessagingException

            Returns the value of the RFC 822 "Content-Type" header field. This represents the content-type of the content of this message. This value must not be null. If this field is unavailable, "text/plain" should be returned.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getContentType in interface Part
            Returns:
                The ContentType of this part
            Throws:
                MessagingException
            See Also:
                DataHandler

            isMimeType

            public boolean isMimeType(String mimeType)
                               throws MessagingException

            Is this Part of the specified MIME type? This method compares only the primaryType and subType. The parameters of the content types are ignored.

            For example, this method will return true when comparing a Part of content type "text/plain" with "text/plain; charset=foobar".

            If the subType of mimeType is the special character '*', then the subtype is ignored during the comparison.

            Specified by:
                isMimeType in interface Part
            Throws:
                MessagingException

            getDisposition

            public String getDisposition()
                                  throws MessagingException

            Returns the value of the "Content-Disposition" header field. This represents the disposition of this part. The disposition describes how the part should be presented to the user.

            If the Content-Disposition field is unavailable, null is returned.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getDisposition in interface Part
            Returns:
                disposition of this part, or null if unknown
            Throws:
                MessagingException
            See Also:
                Part.ATTACHMENT, Part.INLINE, Part.getFileName()

            setDisposition

            public void setDisposition(String disposition)
                                throws MessagingException

            Set the "Content-Disposition" header field of this Message. If disposition is null, any existing "Content-Disposition" header field is removed.

            Specified by:
                setDisposition in interface Part
            Parameters:
                disposition - disposition of this part
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            See Also:
                Part.ATTACHMENT, Part.INLINE, Part.setFileName(java.lang.String)

            getEncoding

            public String getEncoding()
                               throws MessagingException

            Returns the content transfer encoding from the "Content-Transfer-Encoding" header field. Returns null if the header is unavailable or its value is absent.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getEncoding in interface MimePart
            Returns:
                content-transfer-encoding
            Throws:
                MessagingException

            getContentID

            public String getContentID()
                                throws MessagingException

            Returns the value of the "Content-ID" header field. Returns null if the field is unavailable or its value is absent.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getContentID in interface MimePart
            Returns:
                content-ID
            Throws:
                MessagingException

            setContentID

            public void setContentID(String cid)
                              throws MessagingException

            Set the "Content-ID" header field of this Message. If the cid parameter is null, any existing "Content-ID" is removed.

            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getContentMD5

            public String getContentMD5()
                                 throws MessagingException

            Return the value of the "Content-MD5" header field. Returns null if this field is unavailable or its value is absent.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getContentMD5 in interface MimePart
            Returns:
                content-MD5
            Throws:
                MessagingException

            setContentMD5

            public void setContentMD5(String md5)
                               throws MessagingException

            Set the "Content-MD5" header field of this Message.

            Specified by:
                setContentMD5 in interface MimePart
            Parameters:
                md5 - the MD5 value
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getDescription

            public String getDescription()
                                  throws MessagingException

            Returns the "Content-Description" header field of this Message. This typically associates some descriptive information with this part. Returns null if this field is unavailable or its value is absent.

            If the Content-Description field is encoded as per RFC 2047, it is decoded and converted into Unicode. If the decoding or conversion fails, the raw data is returned as-is

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getDescription in interface Part
            Returns:
                content-description
            Throws:
                MessagingException

            setDescription

            public void setDescription(String description)
                                throws MessagingException

            Set the "Content-Description" header field for this Message. If the description parameter is null, then any existing "Content-Description" fields are removed.

            If the description contains non US-ASCII characters, it will be encoded using the platform's default charset. If the description contains only US-ASCII characters, no encoding is done and it is used as-is.

            Note that if the charset encoding process fails, a MessagingException is thrown, and an UnsupportedEncodingException is included in the chain of nested exceptions within the MessagingException.

            Specified by:
                setDescription in interface Part
            Parameters:
                description - content-description
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException. - An UnsupportedEncodingException may be included in the exception chain if the charset conversion fails.
                MessagingException

            setDescription

            public void setDescription(String description,
                                       String charset)
                                throws MessagingException

            Set the "Content-Description" header field for this Message. If the description parameter is null, then any existing "Content-Description" fields are removed.

            If the description contains non US-ASCII characters, it will be encoded using the specified charset. If the description contains only US-ASCII characters, no encoding is done and it is used as-is.

            Note that if the charset encoding process fails, a MessagingException is thrown, and an UnsupportedEncodingException is included in the chain of nested exceptions within the MessagingException.

            Parameters:
                description - Description
                charset - Charset for encoding
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException. - An UnsupportedEncodingException may be included in the exception chain if the charset conversion fails.
                MessagingException

            getContentLanguage

            public String[] getContentLanguage()
                                        throws MessagingException

            Get the languages specified in the "Content-Language" header field of this message. The Content-Language header is defined by RFC 1766. Returns null if this field is unavailable or its value is absent.

            This implementation uses the getHeader method to obtain the requisite header field.

            Specified by:
                getContentLanguage in interface MimePart
            Returns:
                value of content-language header.
            Throws:
                MessagingException

            setContentLanguage

            public void setContentLanguage(String[] languages)
                                    throws MessagingException

            Set the "Content-Language" header of this MimePart. The Content-Language header is defined by RFC 1766.

            Specified by:
                setContentLanguage in interface MimePart
            Parameters:
                languages - array of language tags
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getMessageID

            public String getMessageID()
                                throws MessagingException

            Returns the value of the "Message-ID" header field. Returns null if this field is unavailable or its value is absent.

            The default implementation provided here uses the getHeader method to return the value of the "Message-ID" field.

            Returns:
                Message-ID
            Throws:
                MessagingException - if the retrieval of this field causes any exception.
            Since:
                JavaMail 1.1
            See Also:
                MessageIDTerm

            getFileName

            public String getFileName()
                               throws MessagingException

            Get the filename associated with this Message.

            Returns the value of the "filename" parameter from the "Content-Disposition" header field of this message. If it's not available, returns the value of the "name" parameter from the "Content-Type" header field of this BodyPart. Returns null if both are absent.

            If the mail.mime.encodefilename System property is set to true, the MimeUtility.decodeText method will be used to decode the filename. While such encoding is not supported by the MIME spec, many mailers use this technique to support non-ASCII characters in filenames. The default value of this property is false.

            Specified by:
                getFileName in interface Part
            Returns:
                filename
            Throws:
                MessagingException

            setFileName

            public void setFileName(String filename)
                             throws MessagingException

            Set the filename associated with this part, if possible.

            Sets the "filename" parameter of the "Content-Disposition" header field of this message.

            If the mail.mime.encodefilename System property is set to true, the MimeUtility.encodeText method will be used to encode the filename. While such encoding is not supported by the MIME spec, many mailers use this technique to support non-ASCII characters in filenames. The default value of this property is false.

            Specified by:
                setFileName in interface Part
            Parameters:
                filename - Filename to associate with this part
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getInputStream

            public InputStream getInputStream()
                                       throws IOException,
                                              MessagingException

            Return a decoded input stream for this Message's "content".

            This implementation obtains the input stream from the DataHandler, that is, it invokes getDataHandler().getInputStream().

            Specified by:
                getInputStream in interface Part
            Returns:
                an InputStream
            Throws:
                MessagingException
                IOException - this is typically thrown by the DataHandler. Refer to the documentation for javax.activation.DataHandler for more details.
            See Also:
                getContentStream(), DataHandler.getInputStream()

            getContentStream

            protected InputStream getContentStream()
                                            throws MessagingException

            Produce the raw bytes of the content. This method is used during parsing, to create a DataHandler object for the content. Subclasses that can provide a separate input stream for just the message content might want to override this method.

            This implementation returns a SharedInputStream, if contentStream is not null. Otherwise, it returns a ByteArrayInputStream constructed out of the content byte array.

            Throws:
                MessagingException
            See Also:
                content

            getRawInputStream

            public InputStream getRawInputStream()
                                          throws MessagingException

            Return an InputStream to the raw data with any Content-Transfer-Encoding intact. This method is useful if the "Content-Transfer-Encoding" header is incorrect or corrupt, which would prevent the getInputStream method or getContent method from returning the correct data. In such a case the application may use this method and attempt to decode the raw data itself.

            This implementation simply calls the getContentStream method.

            Throws:
                MessagingException
            Since:
                JavaMail 1.2
            See Also:
                getInputStream(), getContentStream()

            getDataHandler

            public DataHandler getDataHandler()
                                       throws MessagingException

            Return a DataHandler for this Message's content.

            The implementation provided here works as follows. Note the use of the getContentStream method to generate the byte stream for the content. Also note that any transfer-decoding is done automatically within this method.

                  getDataHandler() {
                      if (dh == null) {
                          dh = new DataHandler(new MimePartDataSource(this));
                      }
                      return dh;
                  }
                  


                  class MimePartDataSource implements DataSource {
                      public getInputStream() {
                          return MimeUtility.decode(
                                     getContentStream(), getEncoding());
                      }
                        
                                .... 
                  }
                 

            Specified by:
                getDataHandler in interface Part
            Returns:
                DataHandler for the content
            Throws:
                MessagingException

            getContent

            public Object getContent()
                              throws IOException,
                                     MessagingException

            Return the content as a Java object. The type of this object is dependent on the content itself. For example, the native format of a "text/plain" content is usually a String object. The native format for a "multipart" message is always a Multipart subclass. For content types that are unknown to the DataHandler system, an input stream is returned as the content.

            This implementation obtains the content from the DataHandler, that is, it invokes getDataHandler().getContent(). If the content is a Multipart or Message object and was created by parsing a stream, the object is cached and returned in subsequent calls so that modifications to the content will not be lost.

            Specified by:
                getContent in interface Part
            Returns:
                Object
            Throws:
                MessagingException
                IOException - this is typically thrown by the DataHandler. Refer to the documentation for javax.activation.DataHandler for more details.
            See Also:
                Part, DataHandler.getContent()

            setDataHandler

            public void setDataHandler(DataHandler dh)
                                throws MessagingException

            This method provides the mechanism to set this part's content. The given DataHandler object should wrap the actual content.

            Specified by:
                setDataHandler in interface Part
            Parameters:
                dh - The DataHandler for the content.
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            setContent

            public void setContent(Object o,
                                   String type)
                            throws MessagingException

            A convenience method for setting this Message's content.

            The content is wrapped in a DataHandler object. Note that a DataContentHandler class for the specified type should be available to the JavaMail implementation for this to work right. i.e., to do setContent(foobar, "application/x-foobar"), a DataContentHandler for "application/x-foobar" should be installed. Refer to the Java Activation Framework for more information.

            Specified by:
                setContent in interface Part
            Parameters:
                o - the content object
                type - Mime type of the object
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            setText

            public void setText(String text)
                         throws MessagingException

            Convenience method that sets the given String as this part's content, with a MIME type of "text/plain". If the string contains non US-ASCII characters. it will be encoded using the platform's default charset. The charset is also used to set the "charset" parameter.

            Note that there may be a performance penalty if text is large, since this method may have to scan all the characters to determine what charset to use.

            If the charset is already known, use the setText method that takes the charset parameter.

            Specified by:
                setText in interface MimePart
            Specified by:
                setText in interface Part
            Parameters:
                text - the text content to set
            Throws:
                MessagingException - if an error occurs
            See Also:
                setText(String text, String charset)

            setText

            public void setText(String text,
                                String charset)
                         throws MessagingException

            Convenience method that sets the given String as this part's content, with a MIME type of "text/plain" and the specified charset. The given Unicode string will be charset-encoded using the specified charset. The charset is also used to set the "charset" parameter.

            Specified by:
                setText in interface MimePart
            Parameters:
                text - the text content to set
                charset - the charset to use for the text
            Throws:
                MessagingException - if an error occurs

            setText

            public void setText(String text,
                                String charset,
                                String subtype)
                         throws MessagingException

            Convenience method that sets the given String as this part's content, with a primary MIME type of "text" and the specified MIME subtype. The given Unicode string will be charset-encoded using the specified charset. The charset is also used to set the "charset" parameter.

            Specified by:
                setText in interface MimePart
            Parameters:
                text - the text content to set
                charset - the charset to use for the text
                subtype - the MIME subtype to use (e.g., "html")
            Throws:
                MessagingException - if an error occurs
            Since:
                JavaMail 1.4

            setContent

            public void setContent(Multipart mp)
                            throws MessagingException

            This method sets the Message's content to a Multipart object.

            Specified by:
                setContent in interface Part
            Parameters:
                mp - The multipart object that is the Message's content
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            reply

            public Message reply(boolean replyToAll)
                          throws MessagingException

            Get a new Message suitable for a reply to this message. The new Message will have its attributes and headers set up appropriately. Note that this new message object will be empty, i.e., it will not have a "content". These will have to be suitably filled in by the client.

            If replyToAll is set, the new Message will be addressed to all recipients of this message. Otherwise, the reply will be addressed to only the sender of this message (using the value of the getReplyTo method).

            The "Subject" field is filled in with the original subject prefixed with "Re:" (unless it already starts with "Re:"). The "In-Reply-To" header is set in the new message if this message has a "Message-Id" header. The ANSWERED flag is set in this message. The current implementation also sets the "References" header in the new message to include the contents of the "References" header (or, if missing, the "In-Reply-To" header) in this message, plus the contents of the "Message-Id" header of this message, as described in RFC 2822.

            Specified by:
                reply in class Message
            Parameters:
                replyToAll - reply should be sent to all recipients of this message
            Returns:
                the reply Message
            Throws:
                MessagingException

            reply

            public Message reply(boolean replyToAll,
                                 boolean setAnswered)
                          throws MessagingException

            Get a new Message suitable for a reply to this message. The new Message will have its attributes and headers set up appropriately. Note that this new message object will be empty, i.e., it will not have a "content". These will have to be suitably filled in by the client.

            If replyToAll is set, the new Message will be addressed to all recipients of this message. Otherwise, the reply will be addressed to only the sender of this message (using the value of the getReplyTo method).

            If setAnswered is set, the ANSWERED flag is set in this message.

            The "Subject" field is filled in with the original subject prefixed with "Re:" (unless it already starts with "Re:"). The "In-Reply-To" header is set in the new message if this message has a "Message-Id" header. The current implementation also sets the "References" header in the new message to include the contents of the "References" header (or, if missing, the "In-Reply-To" header) in this message, plus the contents of the "Message-Id" header of this message, as described in RFC 2822.

            Parameters:
                replyToAll - reply should be sent to all recipients of this message
                setAnswered - set the ANSWERED flag in this message?
            Returns:
                the reply Message
            Throws:
                MessagingException
            Since:
                JavaMail 1.5

            writeTo

            public void writeTo(OutputStream os)
                         throws IOException,
                                MessagingException

            Output the message as an RFC 822 format stream.

            Note that, depending on how the messag was constructed, it may use a variety of line termination conventions. Generally the output should be sent through an appropriate FilterOutputStream that converts the line terminators to the desired form, either CRLF for MIME compatibility and for use in Internet protocols, or the local platform's line terminator for storage in a local text file.

            This implementation calls the writeTo(OutputStream, String[]) method with a null ignore list.

            Specified by:
                writeTo in interface Part
            Throws:
                IOException - if an error occurs writing to the stream or if an error is generated by the javax.activation layer.
                MessagingException
            See Also:
                DataHandler.writeTo(java.io.OutputStream)

            writeTo

            public void writeTo(OutputStream os,
                                String[] ignoreList)
                         throws IOException,
                                MessagingException

            Output the message as an RFC 822 format stream, without specified headers. If the saved flag is not set, the saveChanges method is called. If the modified flag is not set and the content array is not null, the content array is written directly, after writing the appropriate message headers.

            Throws:
                MessagingException
                IOException - if an error occurs writing to the stream or if an error is generated by the javax.activation layer.
            See Also:
                DataHandler.writeTo(java.io.OutputStream)

            getHeader

            public String[] getHeader(String name)
                               throws MessagingException

            Get all the headers for this header_name. Note that certain headers may be encoded as per RFC 2047 if they contain non US-ASCII characters and these should be decoded.

            This implementation obtains the headers from the headers InternetHeaders object.

            Specified by:
                getHeader in interface Part
            Parameters:
                name - name of header
            Returns:
                array of headers
            Throws:
                MessagingException
            See Also:
                MimeUtility

            getHeader

            public String getHeader(String name,
                                    String delimiter)
                             throws MessagingException

            Get all the headers for this header name, returned as a single String, with headers separated by the delimiter. If the delimiter is null, only the first header is returned.

            Specified by:
                getHeader in interface MimePart
            Parameters:
                name - the name of this header
                delimiter - separator between values
            Returns:
                the value fields for all headers with this name
            Throws:
                MessagingException

            setHeader

            public void setHeader(String name,
                                  String value)
                           throws MessagingException

            Set the value for this header_name. Replaces all existing header values with this new value. Note that RFC 822 headers must contain only US-ASCII characters, so a header that contains non US-ASCII characters must have been encoded by the caller as per the rules of RFC 2047.

            Specified by:
                setHeader in interface Part
            Parameters:
                name - header name
                value - header value
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            See Also:
                MimeUtility

            addHeader

            public void addHeader(String name,
                                  String value)
                           throws MessagingException

            Add this value to the existing values for this header_name. Note that RFC 822 headers must contain only US-ASCII characters, so a header that contains non US-ASCII characters must have been encoded as per the rules of RFC 2047.

            Specified by:
                addHeader in interface Part
            Parameters:
                name - header name
                value - header value
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            See Also:
                MimeUtility

            removeHeader

            public void removeHeader(String name)
                              throws MessagingException

            Remove all headers with this name.

            Specified by:
                removeHeader in interface Part
            Parameters:
                name - the name of this header
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getAllHeaders

            public Enumeration getAllHeaders()
                                      throws MessagingException

            Return all the headers from this Message as an enumeration of Header objects.

            Note that certain headers may be encoded as per RFC 2047 if they contain non US-ASCII characters and these should be decoded.

            This implementation obtains the headers from the headers InternetHeaders object.

            Specified by:
                getAllHeaders in interface Part
            Returns:
                array of header objects
            Throws:
                MessagingException
            See Also:
                MimeUtility

            getMatchingHeaders

            public Enumeration getMatchingHeaders(String[] names)
                                           throws MessagingException

            Return matching headers from this Message as an Enumeration of Header objects. This implementation obtains the headers from the headers InternetHeaders object.

            Specified by:
                getMatchingHeaders in interface Part
            Returns:
                enumeration of Header objects
            Throws:
                MessagingException

            getNonMatchingHeaders

            public Enumeration getNonMatchingHeaders(String[] names)
                                              throws MessagingException

            Return non-matching headers from this Message as an Enumeration of Header objects. This implementation obtains the header from the headers InternetHeaders object.

            Specified by:
                getNonMatchingHeaders in interface Part
            Returns:
                enumeration of Header objects
            Throws:
                MessagingException

            addHeaderLine

            public void addHeaderLine(String line)
                               throws MessagingException

            Add a raw RFC 822 header-line.

            Specified by:
                addHeaderLine in interface MimePart
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            getAllHeaderLines

            public Enumeration getAllHeaderLines()
                                          throws MessagingException

            Get all header lines as an Enumeration of Strings. A Header line is a raw RFC 822 header-line, containing both the "name" and "value" field.

            Specified by:
                getAllHeaderLines in interface MimePart
            Throws:
                MessagingException

            getMatchingHeaderLines

            public Enumeration getMatchingHeaderLines(String[] names)
                                               throws MessagingException

            Get matching header lines as an Enumeration of Strings. A Header line is a raw RFC 822 header-line, containing both the "name" and "value" field.

            Specified by:
                getMatchingHeaderLines in interface MimePart
            Throws:
                MessagingException

            getNonMatchingHeaderLines

            public Enumeration getNonMatchingHeaderLines(String[] names)
                                                  throws MessagingException

            Get non-matching header lines as an Enumeration of Strings. A Header line is a raw RFC 822 header-line, containing both the "name" and "value" field.

            Specified by:
                getNonMatchingHeaderLines in interface MimePart
            Throws:
                MessagingException

            getFlags

            public Flags getFlags()
                           throws MessagingException

            Return a Flags object containing the flags for this message.

            Note that a clone of the internal Flags object is returned, so modifying the returned Flags object will not affect the flags of this message.

            Specified by:
                getFlags in class Message
            Returns:
                Flags object containing the flags for this message
            Throws:
                MessagingException
            See Also:
                Flags

            isSet

            public boolean isSet(Flags.Flag flag)
                          throws MessagingException

            Check whether the flag specified in the flag argument is set in this message.

            This implementation checks this message's internal flags object.

            Overrides:
                isSet in class Message
            Parameters:
                flag - the flag
            Returns:
                value of the specified flag for this message
            Throws:
                MessagingException
            See Also:
                Flags.Flag, Flags.Flag.ANSWERED, Flags.Flag.DELETED, Flags.Flag.DRAFT, Flags.Flag.FLAGGED, Flags.Flag.RECENT, Flags.Flag.SEEN

            setFlags

            public void setFlags(Flags flag,
                                 boolean set)
                          throws MessagingException

            Set the flags for this message.

            This implementation modifies the flags field.

            Specified by:
                setFlags in class Message
            Parameters:
                flag - Flags object containing the flags to be set
                set - the value to be set
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException
            See Also:
                MessageChangedEvent

            saveChanges

            public void saveChanges()
                             throws MessagingException

            Updates the appropriate header fields of this message to be consistent with the message's contents. If this message is contained in a Folder, any changes made to this message are committed to the containing folder.

            If any part of a message's headers or contents are changed, saveChanges must be called to ensure that those changes are permanent. Otherwise, any such modifications may or may not be saved, depending on the folder implementation.

            Messages obtained from folders opened READ_ONLY should not be modified and saveChanges should not be called on such messages.

            This method sets the modified flag to true, the save flag to true, and then calls the updateHeaders method.

            Specified by:
                saveChanges in class Message
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            updateMessageID

            protected void updateMessageID()
                                    throws MessagingException

            Update the Message-ID header. This method is called by the updateHeaders and allows a subclass to override only the algorithm for choosing a Message-ID.

            Throws:
                MessagingException
            Since:
                JavaMail 1.4

            updateHeaders

            protected void updateHeaders()
                                  throws MessagingException

            Called by the saveChanges method to actually update the MIME headers. The implementation here sets the Content-Transfer-Encoding header (if needed and not already set), the MIME-Version header and the Message-ID header. Also, if the content of this message is a MimeMultipart, its updateHeaders method is called.

            If the cachedContent field is not null (that is, it references a Multipart or Message object), then that object is used to set a new DataHandler, any stream data used to create this object is discarded, and the cachedContent field is cleared.

            Throws:
                IllegalWriteException - if the underlying implementation does not support modification
                IllegalStateException - if this message is obtained from a READ_ONLY folder.
                MessagingException

            createInternetHeaders

            protected InternetHeaders createInternetHeaders(InputStream is)
                                                     throws MessagingException

            Create and return an InternetHeaders object that loads the headers from the given InputStream. Subclasses can override this method to return a subclass of InternetHeaders, if necessary. This implementation simply constructs and returns an InternetHeaders object.

            Parameters:
                is - the InputStream to read the headers from
            Throws:
                MessagingException
            Since:
                JavaMail 1.2

            createMimeMessage

            protected MimeMessage createMimeMessage(Session session)
                                             throws MessagingException

            Create and return a MimeMessage object. The reply method uses this method to create the MimeMessage object that it will return. Subclasses can override this method to return a subclass of MimeMessage. This implementation simply constructs and returns a MimeMessage object using the supplied Session.

            Parameters:
                session - the Session to use for the new message
            Returns:
                the new MimeMessage object
            Throws:
                MessagingException

`The Part Interface`:- The Part interface is the common base interface for Messages and BodyParts.Part consists of a set of attributes and a "Content".
It represents an email component(such as text or attachment).Both email messages and email attachments are considered "parts" in email system.Since emails have multiple sections,the `Part` interface provides methods to manage these sections.

The Part interface defines a set of standard headers common to most mail systems, specifies the data-type assigned to data comprising a content block, and defines set and get methods for each of these members. It is the basic data component in the JavaMail API and provides a common interface for both the Message and BodyPart classes.

Note – A Message object can not be contained directly in a Multipart object, but must be embedded in a BodyPart first

1. Attributes: The JavaMail API defines a set of standard Part attributes that are considered to be common to most existing Mail systems. These attributes have their own settor and gettor methods. Mail systems may support other Part attributes as well, these are represented as name-value pairs where both the name and value are Strings.
2. Content: The data type of the "content" is returned by the getContentType() method. The MIME typing system is used to name data types.
The "content" of a Part is available in various formats:

- As a DataHandler - using the getDataHandler() method. The "content" of a Part is also available through a javax.activation.DataHandler object. The DataHandler object allows clients to discover the operations available on the content, and to instantiate the appropriate component to perform those operations.
- As an input stream - using the getInputStream() method. Any mail-specific encodings are decoded before this stream is returned.
- As a Java object - using the getContent() method. This method returns the "content" as a Java object. The returned object is of course dependent on the content itself. In particular, a "multipart" Part's content is always a Multipart or subclass thereof. That is, getContent() on a "multipart" type Part will always return a Multipart (or subclass) object.

Part provides the writeTo() method that streams out its bytestream in mail-safe form suitable for transmission. This bytestream is typically an aggregation of the Part attributes and its content's bytestream.

Message and BodyPart implement the Part interface. Note that in MIME parlance, Part models an Entity (RFC 2045, Section 2.4).

1. Message(implements Part):- Represents the entire email.
2. BodyPart(implements Part):- Represents parts of an email(text,attachments,images).
3. MimeMessage(extends Message):- Represents a full email message.
4. MimeBodyPart(extends BodyPart):- Represents a part of a MIME email(text,images or attachment).

Note – A Message object can not be contained directly in a Multipart object, but must be embedded in a BodyPart first.

        Field Summary
        Fields Modifier and Type 	Field and Description
        static String 	ATTACHMENT
        This part should be presented as an attachment.
        static String 	INLINE
        This part should be presented inline.
        Method Summary
        All MethodsInstance MethodsAbstract Methods Modifier and Type 	Method and Description
        void 	addHeader(String header_name, String header_value)
        Add this value to the existing values for this header_name.
        Enumeration 	getAllHeaders()
        Return all the headers from this part as an Enumeration of Header objects.
        Object 	getContent()
        Return the content as a Java object.
        String 	getContentType()
        Returns the Content-Type of the content of this part.
        DataHandler 	getDataHandler()
        Return a DataHandler for the content within this part.
        String 	getDescription()
        Return a description String for this part.
        String 	getDisposition()
        Return the disposition of this part.
        String 	getFileName()
        Get the filename associated with this part, if possible.
        String[] 	getHeader(String header_name)
        Get all the headers for this header name.
        InputStream 	getInputStream()
        Return an input stream for this part's "content".
        int 	getLineCount()
        Return the number of lines in the content of this part.
        Enumeration 	getMatchingHeaders(String[] header_names)
        Return matching headers from this part as an Enumeration of Header objects.
        Enumeration 	getNonMatchingHeaders(String[] header_names)
        Return non-matching headers from this envelope as an Enumeration of Header objects.
        int 	getSize()
        Return the size of the content of this part in bytes.
        boolean 	isMimeType(String mimeType)
        Is this Part of the specified MIME type? This method compares only the primaryType and subType.
        void 	removeHeader(String header_name)
        Remove all headers with this name.
        void 	setContent(Multipart mp)
        This method sets the given Multipart object as this message's content.
        void 	setContent(Object obj, String type)
        A convenience method for setting this part's content.
        void 	setDataHandler(DataHandler dh)
        This method provides the mechanism to set this part's content.
        void 	setDescription(String description)
        Set a description String for this part.
        void 	setDisposition(String disposition)
        Set the disposition of this part.
        void 	setFileName(String filename)
        Set the filename associated with this part, if possible.
        void 	setHeader(String header_name, String header_value)
        Set the value for this header_name.
        void 	setText(String text)
        A convenience method that sets the given String as this part's content with a MIME type of "text/plain".
        void 	writeTo(OutputStream os)
        Output a bytestream for this Part.

        Field Detail
            ATTACHMENT

            static final String ATTACHMENT

            This part should be presented as an attachment.

            See Also:
                getDisposition(), setDisposition(java.lang.String), Constant Field Values

            INLINE

            static final String INLINE

            This part should be presented inline.

            See Also:
                getDisposition(), setDisposition(java.lang.String), Constant Field Values

        Method Detail
            getSize

            int getSize()
                 throws MessagingException

            Return the size of the content of this part in bytes. Return -1 if the size cannot be determined.

            Note that the size may not be an exact measure of the content size and may or may not account for any transfer encoding of the content. The size is appropriate for display in a user interface to give the user a rough idea of the size of this part.

            Returns:
                size of content in bytes
            Throws:
                MessagingException

            getLineCount

            int getLineCount()
                      throws MessagingException

            Return the number of lines in the content of this part. Return -1 if the number cannot be determined. Note that this number may not be an exact measure of the content length and may or may not account for any transfer encoding of the content.

            Returns:
                number of lines in the content.
            Throws:
                MessagingException

            getContentType

            String getContentType()
                           throws MessagingException

            Returns the Content-Type of the content of this part. Returns null if the Content-Type could not be determined.

            The MIME typing system is used to name Content-types.

            Returns:
                The ContentType of this part
            Throws:
                MessagingException
            See Also:
                DataHandler

            isMimeType

            boolean isMimeType(String mimeType)
                        throws MessagingException

            Is this Part of the specified MIME type? This method compares only the primaryType and subType. The parameters of the content types are ignored.

            For example, this method will return true when comparing a Part of content type "text/plain" with "text/plain; charset=foobar".

            If the subType of mimeType is the special character '*', then the subtype is ignored during the comparison.

            Throws:
                MessagingException

            getDisposition

            String getDisposition()
                           throws MessagingException

            Return the disposition of this part. The disposition describes how the part should be presented to the user. (See RFC 2183.) The return value should be considered without regard to case. For example:

                 String disp = part.getDisposition();
                 if (disp == null || disp.equalsIgnoreCase(Part.ATTACHMENT))
                        // treat as attachment if not first part
                 

            Returns:
                disposition of this part, or null if unknown
            Throws:
                MessagingException
            See Also:
                ATTACHMENT, INLINE, getFileName()

            setDisposition

            void setDisposition(String disposition)
                         throws MessagingException

            Set the disposition of this part.

            Parameters:
                disposition - disposition of this part
            Throws:
                MessagingException
                IllegalWriteException - if the underlying implementation does not support modification of this header
                IllegalStateException - if this Part is obtained from a READ_ONLY folder
            See Also:
                ATTACHMENT, INLINE, setFileName(java.lang.String)

            getDescription

            String getDescription()
                           throws MessagingException

            Return a description String for this part. This typically associates some descriptive information with this part. Returns null if none is available.

            Returns:
                description of this part
            Throws:
                MessagingException

            setDescription

            void setDescription(String description)
                         throws MessagingException

            Set a description String for this part. This typically associates some descriptive information with this part.

            Parameters:
                description - description of this part
            Throws:
                MessagingException
                IllegalWriteException - if the underlying implementation does not support modification of this header
                IllegalStateException - if this Part is obtained from a READ_ONLY folder

            getFileName

            String getFileName()
                        throws MessagingException

            Get the filename associated with this part, if possible. Useful if this part represents an "attachment" that was loaded from a file. The filename will usually be a simple name, not including directory components.

            Returns:
                Filename to associate with this part
            Throws:
                MessagingException

            setFileName

            void setFileName(String filename)
                      throws MessagingException

            Set the filename associated with this part, if possible. Useful if this part represents an "attachment" that was loaded from a file. The filename will usually be a simple name, not including directory components.

            Parameters:
                filename - Filename to associate with this part
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of this header
                IllegalStateException - if this Part is obtained from a READ_ONLY folder
                MessagingException

            getInputStream

            InputStream getInputStream()
                                throws IOException,
                                       MessagingException

            Return an input stream for this part's "content". Any mail-specific transfer encodings will be decoded before the input stream is provided.

            This is typically a convenience method that just invokes the DataHandler's getInputStream() method.

            Returns:
                an InputStream
            Throws:
                IOException - this is typically thrown by the DataHandler. Refer to the documentation for javax.activation.DataHandler for more details.
                MessagingException
            See Also:
                getDataHandler(), DataHandler.getInputStream()

            getDataHandler

            DataHandler getDataHandler()
                                throws MessagingException

            Return a DataHandler for the content within this part. The DataHandler allows clients to operate on as well as retrieve the content.

            Returns:
                DataHandler for the content
            Throws:
                MessagingException

            getContent

            Object getContent()
                       throws IOException,
                              MessagingException

            Return the content as a Java object. The type of the returned object is of course dependent on the content itself. For example, the object returned for "text/plain" content is usually a String object. The object returned for a "multipart" content is always a Multipart subclass. For content-types that are unknown to the DataHandler system, an input stream is returned as the content

            This is a convenience method that just invokes the DataHandler's getContent() method

            Returns:
                Object
            Throws:
                MessagingException
                IOException - this is typically thrown by the DataHandler. Refer to the documentation for javax.activation.DataHandler for more details.
            See Also:
                DataHandler.getContent()

            setDataHandler

            void setDataHandler(DataHandler dh)
                         throws MessagingException

            This method provides the mechanism to set this part's content. The DataHandler wraps around the actual content.

            Parameters:
                dh - The DataHandler for the content.
            Throws:
                MessagingException
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder

            setContent

            void setContent(Object obj,
                            String type)
                     throws MessagingException

            A convenience method for setting this part's content. The part internally wraps the content in a DataHandler.

            Note that a DataContentHandler class for the specified type should be available to the JavaMail implementation for this to work right. i.e., to do setContent(foobar, "application/x-foobar"), a DataContentHandler for "application/x-foobar" should be installed. Refer to the Java Activation Framework for more information.

            Parameters:
                obj - A java object.
                type - MIME type of this object.
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder
                MessagingException

            setText

            void setText(String text)
                  throws MessagingException

            A convenience method that sets the given String as this part's content with a MIME type of "text/plain".

            Parameters:
                text - The text that is the Message's content.
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder
                MessagingException

            setContent

            void setContent(Multipart mp)
                     throws MessagingException

            This method sets the given Multipart object as this message's content.

            Parameters:
                mp - The multipart object that is the Message's content
            Throws:
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder
                MessagingException

            writeTo

            void writeTo(OutputStream os)
                  throws IOException,
                         MessagingException

            Output a bytestream for this Part. This bytestream is typically an aggregration of the Part attributes and an appropriately encoded bytestream from its 'content'.

            Classes that implement the Part interface decide on the appropriate encoding algorithm to be used.

            The bytestream is typically used for sending.

            Throws:
                IOException - if an error occurs writing to the stream or if an error is generated by the javax.activation layer.
                MessagingException - if an error occurs fetching the data to be written
            See Also:
                DataHandler.writeTo(java.io.OutputStream)

            getHeader

            String[] getHeader(String header_name)
                        throws MessagingException

            Get all the headers for this header name. Returns null if no headers for this header name are available.

            Parameters:
                header_name - the name of this header
            Returns:
                the value fields for all headers with this name
            Throws:
                MessagingException

            setHeader

            void setHeader(String header_name,
                           String header_value)
                    throws MessagingException

            Set the value for this header_name. Replaces all existing header values with this new value.

            Parameters:
                header_name - the name of this header
                header_value - the value for this header
            Throws:
                MessagingException
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder

            addHeader

            void addHeader(String header_name,
                           String header_value)
                    throws MessagingException

            Add this value to the existing values for this header_name.

            Parameters:
                header_name - the name of this header
                header_value - the value for this header
            Throws:
                MessagingException
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder

            removeHeader

            void removeHeader(String header_name)
                       throws MessagingException

            Remove all headers with this name.

            Parameters:
                header_name - the name of this header
            Throws:
                MessagingException
                IllegalWriteException - if the underlying implementation does not support modification of existing values
                IllegalStateException - if this Part is obtained from a READ_ONLY folder

            getAllHeaders

            Enumeration getAllHeaders()
                               throws MessagingException

            Return all the headers from this part as an Enumeration of Header objects.

            Returns:
                enumeration of Header objects
            Throws:
                MessagingException

            getMatchingHeaders

            Enumeration getMatchingHeaders(String[] header_names)
                                    throws MessagingException

            Return matching headers from this part as an Enumeration of Header objects.

            Returns:
                enumeration of Header objects
            Throws:
                MessagingException

            getNonMatchingHeaders

            Enumeration getNonMatchingHeaders(String[] header_names)
                                       throws MessagingException

            Return non-matching headers from this envelope as an Enumeration of Header objects.

            Returns:
                enumeration of Header objects
            Throws:
                MessagingException

- `Message Attributes`:- The Message class adds its own set of standard attributes to those it inherits from the Part interface. These attributes include the sender and recipient addresses, the subject, flags, and sent and received dates. The Message class also supports non-standard attributes in the form of headers.Not all messaging systems will support arbitrary headers, and the availability and meaning of particular header names is specific to the messaging system implementation.

- `The ContentType Attribute`:- The contentType attribute specifies the data type of the content, following the MIME typing specification (RFC 2045). A MIME type is composed of a primary type that declares the general type of the content, and a subtype that specifies a specific format for the content.
A MIME type also includes an optional set of type-specific parameters

JavaMail API components can access content via these mechanisms:
As an input streamThe Part interface declares the getInputStream method that
returns an input stream to the content. Note that Part implementations
must decode any mail-specific transfer encoding before providing the
input stream.
As a DataHandler objectThe Part interface declares the getDataHandler method that
returns a javax.activation.DataHandler object that wraps
around the content. The DataHandler object allows clients to
discover the operations available to perform on the content, and to
instantiate the appropriate component to perform those operations. See
“The JavaBeans Activation Framework” on page 41 for details
describing the data typing framework
As an object in the Java
programming languageThe Part interface declares the getContent method that returns the
content as an object in the Java programming language. The type of the
returned object is dependent on the content’s data type. If the content is
of type multipart, the getContent method returns a Multipart
object, or a Multipart subclass object. The getContent method
returns an input stream for unknown content-types. Note that the
getContent method uses the DataHandler internally to obtain the
native form

The setDataHandler(DataHandler) method specifies content for a new Part
object, as a step toward the construction of a new message. The Part also provides some
convenience methods to set up most common content types.
Part provides the writeTo method that writes its byte stream in mail-safe form suitable for
transmission. This byte stream is typically an aggregation of the Part attributes and the byte
stream for its content.

- `The Address Class`:- The Address class represents email addresses. The Address class is an abstract class. Subclasses provide implementation-specific semantics.

- `The BodyPart Class`:- The BodyPart class is an abstract class that implements the Part interface in order to define the attribute and content body definitions that Part declares. It does not declare attributes that set From, To, Subject, ReplyTo, or other address header fields, as a Message object does.
A BodyPart object is intended to be inserted into a Multipart container, later accessed via a multipart message.

- `The Multipart Class`:- The Multipart class implements multipart messages. A multipart message is a Message object where the content-type specifier has been set to multipart. The Multipart class is a container class that contains objects of type Bodypart. A Bodypart object is an instantiation of the Part interface—it contains either a new Multipart container object, or a DataHandler object.

Note that Multipart objects can be nested to any reasonable depth within a multipart message, in order to build an appropriate structure for data carried in DataHandler objects.Therefore, it is important to check the ContentType header for each BodyPart element stored within a Multipart container. The figure below illustrates a typical nested Multipart message.
Typically, the client calls the getContentType method to get the content type of a
message. If getContentType returns a MIME-type whose primary type is multipart, then
the client calls getContent to get the Multipart container object.
The Multipart object supports several methods that get, create, and remove individual
BodyPart objects.
public int getCount() throws MessagingException;
public Body getBodyPart(int index)
throws MessagingException;
public void addBodyPart(BodyPart part)
throws MessagingException;
public void removeBodyPart(BodyPart body)
throws MessagingException;
public void removeBodyPart(int index)
throws MessagingException;
The Multipart class implements the javax.beans.DataSource interface. It can act
as the DataSource object for javax.beans.DataHandler and
javax.beans.DataContentHandler objects. This allows message-aware content
handlers to handle multipart data sources more efficiently, since the data has already been
parsed into individual parts.
This diagram illustrates the structure of a multipart message, and shows calls from the
associated Message and Multipart objects, for a typical call sequence returning a
BodyPart containing text/plain content.

- `The Flags Class`:- The Flags class represents the set of flags on a Message. Flags are composed of predefined system flags, and user defined flags.A System flag is represented by the Flags.Flag inner class. A User defined flag is represented as a String. User flags are case-independent.

A set of standard system flags are predefined. Most folder implementations are expected to support these flags. Some implementations may also support arbitrary user-defined flags. The getPermanentFlags method on a Folder returns a Flags object that holds all the flags that are supported by that folder implementation.

A Flags object is serializable so that (for example) the use of Flags objects in search terms can be serialized along with the search terms.

Warning: Serialized objects of this class may not be compatible with future JavaMail API releases. The current serialization support is appropriate for short term storage.

Flags objects carry flag settings that describe the state of a Message object within its containing folder. The Message.getFlags method returns a Flags object that holds all the flags currently set for that message.
The setFlags(Flags f, boolean set) method sets the specified flags for that message. The add(Flags.Flag f) method on a Flags object sets the specified flag; the contains(Flags.Flag f) method returns whether the specified flag is set.

public static final class Flags.Flag - This inner class represents an individual system flag. A set of standard system flag objects are predefined here.

Field Detail:

1. ANSWERED - This message has been answered. This flag is set by clients to indicate that this message has been answered to.
2. DRAFT - Indicates that this message is a draft.This message is a draft. This flag is set by clients to indicate that the message is a draft message.
3. FLAGGED - No defined semantics. Clients can use this flag to mark a message in some user-defined manner.This message is flagged. No semantic is defined for this flag. Clients alter this flag.
4. RECENT - This message is newly arrived in this folder. This flag is set when the message is first delivered into the folder and cleared when the containing folder is closed.Clients cannot set this flag. This message is recent. Folder implementations set this flag to indicate that this message is new to this folder, that is, it has arrived since the last time this folder was opened.Clients cannot alter this flag.
5. SEEN - Marks a message that has been opened. A client sets this flag implicitly when the message contents are retrieved.This message is seen. This flag is implicitly set by the implementation when the this Message's content is returned to the client in some form. The getInputStream and getContent methods on Message cause this flag to be set.Clients can alter this flag.
6. DELETED - Allows undoable message deletion. Setting this flag for a message marks it deleted but does not physically remove the message from its folder. The client calls the expunge method on a folder to remove all deleted messages in that folder.This message is marked deleted. Clients set this flag to mark a message as deleted. The expunge operation on a folder removes all messages in that folder that are marked for deletion.
7. USER - A special flag that indicates that this folder supports user defined flags.The implementation sets this flag. Clients cannot alter this flag but can use it to determine if a folder supports user defined flags by using folder.getPermanentFlags().contains(Flags.Flag.USER).

Note that a folder is not guaranteed to support either standard system flags or arbitrary user flags. The getPermanentFlags method in a folder returns a Flags object that contains all the system flags supported by that Folder implementation. The presence of the special USER flag indicates that the client can set arbitrary user-definable flags on any message belonging to this folder.

The below code sample illustrates how to set, examine, and get the flags for a message.

```java
Message m = folder.getMessage(1);
m.setFlag(Flags.Flag.DELETED, true); // set the DELETED flag

// Check if DELETED flag is set on this message
if (m.isSet(Flags.Flag.DELETED))
    System.out.println("DELETED message");

// Examine ALL system flags for this message
Flags flags = m.getFlags();
Flags.Flag[] sf = flags.getSystemFlags();
    for (int i = 0; i < sf.length; i++) {
        if (sf[i] == Flags.Flag.DELETED)
            System.out.println("DELETED message");
        else if (sf[i] == Flags.Flag.SEEN)
            System.out.println("SEEN message");
          ......
          ......
}
```  

    See Also:
        Folder.getPermanentFlags(), Serialized Form

        Nested Class Summary
        Nested Classes Modifier and Type 	Class and Description
        static class  	Flags.Flag
        This inner class represents an individual system flag.
        Constructor Summary
        Constructors Constructor and Description
        Flags()
        Construct an empty Flags object.
        Flags(Flags.Flag flag)
        Construct a Flags object initialized with the given system flag.
        Flags(Flags flags)
        Construct a Flags object initialized with the given flags.
        Flags(String flag)
        Construct a Flags object initialized with the given user flag.
        Method Summary
        All MethodsInstance MethodsConcrete Methods Modifier and Type 	Method and Description
        void 	add(Flags.Flag flag)
        Add the specified system flag to this Flags object.
        void 	add(Flags f)
        Add all the flags in the given Flags object to this Flags object.
        void 	add(String flag)
        Add the specified user flag to this Flags object.
        Object 	clone()
        Returns a clone of this Flags object.
        boolean 	contains(Flags.Flag flag)
        Check whether the specified system flag is present in this Flags object.
        boolean 	contains(Flags f)
        Check whether all the flags in the specified Flags object are present in this Flags object.
        boolean 	contains(String flag)
        Check whether the specified user flag is present in this Flags object.
        boolean 	equals(Object obj)
        Check whether the two Flags objects are equal.
        Flags.Flag[] 	getSystemFlags()
        Return all the system flags in this Flags object.
        String[] 	getUserFlags()
        Return all the user flags in this Flags object.
        int 	hashCode()
        Compute a hash code for this Flags object.
        void 	remove(Flags.Flag flag)
        Remove the specified system flag from this Flags object.
        void 	remove(Flags f)
        Remove all flags in the given Flags object from this Flags object.
        void 	remove(String flag)
        Remove the specified user flag from this Flags object.
            Methods inherited from class java.lang.Object
            finalize, getClass, notify, notifyAll, toString, wait, wait, wait

        Constructor Detail
            Flags

            public Flags()

            Construct an empty Flags object.
            Flags

            public Flags(Flags flags)

            Construct a Flags object initialized with the given flags.

            Parameters:
                flags - the flags for initialization

            Flags

            public Flags(Flags.Flag flag)

            Construct a Flags object initialized with the given system flag.

            Parameters:
                flag - the flag for initialization

            Flags

            public Flags(String flag)

            Construct a Flags object initialized with the given user flag.

            Parameters:
                flag - the flag for initialization

        Method Detail
            add

            public void add(Flags.Flag flag)

            Add the specified system flag to this Flags object.

            Parameters:
                flag - the flag to add

            add

            public void add(String flag)

            Add the specified user flag to this Flags object.

            Parameters:
                flag - the flag to add

            add

            public void add(Flags f)

            Add all the flags in the given Flags object to this Flags object.

            Parameters:
                f - Flags object

            remove

            public void remove(Flags.Flag flag)

            Remove the specified system flag from this Flags object.

            Parameters:
                flag - the flag to be removed

            remove

            public void remove(String flag)

            Remove the specified user flag from this Flags object.

            Parameters:
                flag - the flag to be removed

            remove

            public void remove(Flags f)

            Remove all flags in the given Flags object from this Flags object.

            Parameters:
                f - the flag to be removed

            contains

            public boolean contains(Flags.Flag flag)

            Check whether the specified system flag is present in this Flags object.

            Returns:
                true of the given flag is present, otherwise false.

            contains

            public boolean contains(String flag)

            Check whether the specified user flag is present in this Flags object.

            Returns:
                true of the given flag is present, otherwise false.

            contains

            public boolean contains(Flags f)

            Check whether all the flags in the specified Flags object are present in this Flags object.

            Returns:
                true if all flags in the given Flags object are present, otherwise false.

            equals

            public boolean equals(Object obj)

            Check whether the two Flags objects are equal.

            Overrides:
                equals in class Object
            Returns:
                true if they're equal

            hashCode

            public int hashCode()

            Compute a hash code for this Flags object.

            Overrides:
                hashCode in class Object
            Returns:
                the hash code

            getSystemFlags

            public Flags.Flag[] getSystemFlags()

            Return all the system flags in this Flags object. Returns an array of size zero if no flags are set.

            Returns:
                array of Flags.Flag objects representing system flags

            getUserFlags

            public String[] getUserFlags()

            Return all the user flags in this Flags object. Returns an array of size zero if no flags are set.

            Returns:
                array of Strings, each String represents a flag.

            clone

            public Object clone()

            Returns a clone of this Flags object.

            Overrides:
                clone in class Object

- Message Creation And Transmission:- The Message class is abstract, so an appropriate subclass must be instantiated to create a new Message object. A client creates a message by instantiating an appropriate Message subclass.
For example, the MimeMessage subclass handles Internet email messages. Typically, the client application creates an email message by instantiating a MimeMessage object, and
passing required attribute values to that object. In an email message, the client defines Subject, From, and To attributes. The client then passes message content into the
MimeMessage object by using a suitably configured DataHandler object.
After the Message object is constructed, the client calls the Transport.send method to route it to its specified recipients.

### Managing Security

The Session class allows messaging system implementations to use the Authenticator
object that was registered when the session was created. The Authenticator object is
created by the application and allows interaction with the user to obtain a user name and
password. The user name and password is returned in a PasswordAuthentication
object. The messaging system implementation can ask the session to associate a user name and
password with a particular message store using the setPasswordAuthentication
method. This information is retrieved using the getPasswordAuthentication method.
This avoids the need to ask the user for a password when reconnecting to a Store that has
disconnected, or when a second application sharing the same session needs to create its own
connection to the same Store.
Messaging system implementations can register PasswordAuthentication objects with
the Session object for use later in the session or for use by other users of the same session.
Because PasswordAuthentication objects contain passwords, access to this information must be carefully controlled. Applications that create Session objects must restrict access to
those objects appropriately. In addition, the Session class shares some responsibility for
controlling access to the default Session object.
The first call to getDefaultInstance creates a new Session object and associates the
Authenticator object with the Session object. Later calls to getDefaultInstance
compare the Authenticator object passed in, to the Authenticator object saved in the
default session. If both objects have been loaded by the same class loader, then
getDefaultInstance will allow access to the default session. Typically, this is the case
when both the creator of the default session and the code requesting access to the default
session are in the same "security domain." Also, if both objects are null, access is allowed.
This last case is discouraged because setting objects to null allows access to the default
session from any security domain.
In the future, JDK security Permissions could control access to the default session. Note that
the Authenticator and PasswordAuthentication classes and their use in JavaMail
is similar to the classes with the same names provided in the java.net package in the JDK.
As new authentication mechanisms are added to the system, new methods can be added to the
Authenticator class to request the needed information. The default implementations of
these new methods will fail, but new clients that understand these new authentication
mechanisms can provide implementations of these methods. New classes other than
PasswordAuthentication could be needed to contain the new authentication
information, and new methods could be needed in the Session class to store such
information. JavaMail design evolution will be patterned after the corresponding JDK classes.

Store and Folder URLs
To simplify message folder naming and to minimize the need to manage Store and
Transport objects, folders can be named using URLNames. URLNames are similar to
URLs except they only include the parsing of the URL string. The Session class provides
methods to retrieve a Folder object given a URLName:
Folder f = session.getFolder(URLName);
or
Store s = session.getStore(URLName);

Here’s an example of META-INF/javamail.default.providers file contents:
protocol=imap; type=store; class=com.sun.mail.imap.IMAPStore; vendor=Sun;protocol=smtp; type=transport; class=com.sun.mail.smtp.SMTPTransport;

The Session class provides access to the protocol providers that implement the Store, Transport, and related classes. The protocol providers are configured using the following files:

    1. javamail.providers and javamail.default.providers
    2. javamail.address.map and javamail.default.address.map

 Each javamail.X resource file is searched for using three methods in the following order:

    java.home/lib/javamail.X
    META-INF/javamail.X
    META-INF/javamail.default.X

The first method allows the user to include their own version of the resource file by placing it in the lib directory where the java.home property points. The second method allows an application that uses the JavaMail APIs to include their own resource files in their application's or jar file's META-INF directory. The javamail.default.X default files are part of the JavaMail mail.jar file.

File location depends upon how the ClassLoader method getResource is implemented. Usually, the getResource method searches through CLASSPATH until it finds the requested file and then stops. JDK 1.1 has a limitation that the number of files of each name that will be found in the CLASSPATH is limited to one. However, this only affects method two, above; method one is loaded from a specific location (if allowed by the SecurityManager) and method three uses a different name to ensure that the default resource file is always loaded successfully. J2SE 1.2 and later are not limited to one file of a given name.

The ordering of entries in the resource files matters. If multiple entries exist, the first entries take precedence over the later entries. For example, the first IMAP provider found will be set as the default IMAP implementation until explicitly changed by the application. The user- or system-supplied resource files augment, they do not override, the default files included with the JavaMail APIs. This means that all entries in all files loaded will be available.

javamail.providers and javamail.default.providers

These resource files specify the stores and transports that are available on the system, allowing an application to "discover" what store and transport implementations are available. The protocol implementations are listed one per line. The file format defines four attributes that describe a protocol implementation. Each attribute is an "="-separated name-value pair with the name in lowercase. Each name-value pair is semi-colon (";") separated. The following names are defined.

Attribute Names in Providers Files Name	Description
protocol 	Name assigned to protocol. For example, smtp for Transport.
type 	Valid entries are store and transport.
class 	Class name that implements this protocol.
vendor 	Optional string identifying the vendor.
version 	Optional string identifying the version.

Here's an example of META-INF/javamail.default.providers file contents:

 protocol=imap; type=store; class=com.sun.mail.imap.IMAPStore; vendor=Sun Microsystems, Inc.;
 protocol=smtp; type=transport; class=com.sun.mail.smtp.SMTPTransport; vendor=Sun Microsystems, Inc.;
 

javamail.address.map and javamail.default.address.map

These resource files map transport address types to the transport protocol. The getType method of javax.mail.Address returns the address type. The javamail.address.map file maps the transport type to the protocol. The file format is a series of name-value pairs. Each key name should correspond to an address type that is currently installed on the system; there should also be an entry for each javax.mail.Address implementation that is present if it is to be used. For example, the javax.mail.internet.InternetAddress method getType returns "rfc822". Each referenced protocol should be installed on the system. For the case of news, below, the client should install a Transport provider supporting the nntp protocol.

Here are the typical contents of a javamail.address.map file:

 rfc822=smtp
 news=nntp

## Message Storage And Retrieval

This section describes JavaMail message storage facilities supported by the Store and Folder classes.Messages are contained in Folders. New messages are usually delivered to folders by a transport protocol or a delivery agent. Clients retrieve messages from folders using an access protocol.

- `The Store Class`: The Store class defines a database that holds a Folder hierarchy and the messages within.The Store also defines the access protocol used to access folders and retrieve messages from folders. Store is an abstract class. Subclasses implement specific message databases and access protocols.

Clients gain access to a Message Store by obtaining a Store object that implements the database access protocol. Most message stores require the user to be authenticated before they allow access. The connect method performs that authentication.

        Method Summary
        All MethodsStatic MethodsInstance MethodsConcrete Methods Modifier and Type 	Method and Description
        void 	addProvider(Provider provider)
        Add a provider to the session.
        boolean 	getDebug()
        Get the debug setting for this Session.
        PrintStream 	getDebugOut()
        Returns the stream to be used for debugging output.
        static Session 	getDefaultInstance(Properties props)
        Get the default Session object.
        static Session 	getDefaultInstance(Properties props, Authenticator authenticator)
        Get the default Session object.
        Folder 	getFolder(URLName url)
        Get a closed Folder object for the given URLName.
        static Session 	getInstance(Properties props)
        Get a new Session object.
        static Session 	getInstance(Properties props, Authenticator authenticator)
        Get a new Session object.
        PasswordAuthentication 	getPasswordAuthentication(URLName url)
        Return any saved PasswordAuthentication for this (store or transport) URLName.
        Properties 	getProperties()
        Returns the Properties object associated with this Session
        String 	getProperty(String name)
        Returns the value of the specified property.
        Provider 	getProvider(String protocol)
        Returns the default Provider for the protocol specified.
        Provider[] 	getProviders()
        This method returns an array of all the implementations installed via the javamail.[default.]providers files that can be loaded using the ClassLoader available to this application.
        Store 	getStore()
        Get a Store object that implements this user's desired Store protocol.
        Store 	getStore(Provider provider)
        Get an instance of the store specified by Provider.
        Store 	getStore(String protocol)
        Get a Store object that implements the specified protocol.
        Store 	getStore(URLName url)
        Get a Store object for the given URLName.
        Transport 	getTransport()
        Get a Transport object that implements this user's desired Transport protcol.
        Transport 	getTransport(Address address)
        Get a Transport object that can transport a Message of the specified address type.
        Transport 	getTransport(Provider provider)
        Get an instance of the transport specified in the Provider.
        Transport 	getTransport(String protocol)
        Get a Transport object that implements the specified protocol.
        Transport 	getTransport(URLName url)
        Get a Transport object for the given URLName.
        PasswordAuthentication 	requestPasswordAuthentication(InetAddress addr, int port, String protocol, String prompt, String defaultUserName)
        Call back to the application to get the needed user name and password.
        void 	setDebug(boolean debug)
        Set the debug setting for this Session.
        void 	setDebugOut(PrintStream out)
        Set the stream to be used for debugging output for this session.
        void 	setPasswordAuthentication(URLName url, PasswordAuthentication pw)
        Save a PasswordAuthentication for this (store or transport) URLName.
        void 	setProtocolForAddress(String addresstype, String protocol)
        Set the default transport protocol to use for addresses of the specified type.
        void 	setProvider(Provider provider)
        Set the passed Provider to be the default implementation for the protocol in Provider.protocol overriding any previous values.
            Methods inherited from class java.lang.Object
            clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait

        Method Detail
            getInstance

            public static Session getInstance(Properties props,
                                              Authenticator authenticator)

            Get a new Session object.

            Parameters:
                props - Properties object that hold relevant properties.
                It is expected that the client supplies values for the properties listed in Appendix A of the JavaMail spec (particularly mail.store.protocol, mail.transport.protocol, mail.host, mail.user, and mail.from) as the defaults are unlikely to work in all cases.
                authenticator - Authenticator object used to call back to the application when a user name and password is needed.
            Returns:
                a new Session object
            See Also:
                Authenticator

            getInstance

            public static Session getInstance(Properties props)

            Get a new Session object.

            Parameters:
                props - Properties object that hold relevant properties.
                It is expected that the client supplies values for the properties listed in Appendix A of the JavaMail spec (particularly mail.store.protocol, mail.transport.protocol, mail.host, mail.user, and mail.from) as the defaults are unlikely to work in all cases.
            Returns:
                a new Session object
            Since:
                JavaMail 1.2

            getDefaultInstance

            public static Session getDefaultInstance(Properties props,
                                                     Authenticator authenticator)

            Get the default Session object. If a default has not yet been setup, a new Session object is created and installed as the default.

            Since the default session is potentially available to all code executing in the same Java virtual machine, and the session can contain security sensitive information such as user names and passwords, access to the default session is restricted. The Authenticator object, which must be created by the caller, is used indirectly to check access permission. The Authenticator object passed in when the session is created is compared with the Authenticator object passed in to subsequent requests to get the default session. If both objects are the same, or are from the same ClassLoader, the request is allowed. Otherwise, it is denied.

            Note that if the Authenticator object used to create the session is null, anyone can get the default session by passing in null.

            Note also that the Properties object is used only the first time this method is called, when a new Session object is created. Subsequent calls return the Session object that was created by the first call, and ignore the passed Properties object. Use the getInstance method to get a new Session object every time the method is called.

            In JDK 1.2, additional security Permission objects may be used to control access to the default session.

            Parameters:
                props - Properties object. Used only if a new Session object is created.
                It is expected that the client supplies values for the properties listed in Appendix A of the JavaMail spec (particularly mail.store.protocol, mail.transport.protocol, mail.host, mail.user, and mail.from) as the defaults are unlikely to work in all cases.
                authenticator - Authenticator object. Used only if a new Session object is created. Otherwise, it must match the Authenticator used to create the Session.
            Returns:
                the default Session object

            getDefaultInstance

            public static Session getDefaultInstance(Properties props)

            Get the default Session object. If a default has not yet been setup, a new Session object is created and installed as the default.

            Note that a default session created with no Authenticator is available to all code executing in the same Java virtual machine, and the session can contain security sensitive information such as user names and passwords.

            Parameters:
                props - Properties object. Used only if a new Session object is created.
                It is expected that the client supplies values for the properties listed in Appendix A of the JavaMail spec (particularly mail.store.protocol, mail.transport.protocol, mail.host, mail.user, and mail.from) as the defaults are unlikely to work in all cases.
            Returns:
                the default Session object
            Since:
                JavaMail 1.2

            setDebug

            public void setDebug(boolean debug)

            Set the debug setting for this Session.

            Since the debug setting can be turned on only after the Session has been created, to turn on debugging in the Session constructor, set the property mail.debug in the Properties object passed in to the constructor to true. The value of the mail.debug property is used to initialize the per-Session debugging flag. Subsequent calls to the setDebug method manipulate the per-Session debugging flag and have no affect on the mail.debug property.

            Parameters:
                debug - Debug setting

            getDebug

            public boolean getDebug()

            Get the debug setting for this Session.

            Returns:
                current debug setting

            setDebugOut

            public void setDebugOut(PrintStream out)

            Set the stream to be used for debugging output for this session. If out is null, System.out will be used. Note that debugging output that occurs before any session is created, as a result of setting the mail.debug system property, will always be sent to System.out.

            Parameters:
                out - the PrintStream to use for debugging output
            Since:
                JavaMail 1.3

            getDebugOut

            public PrintStream getDebugOut()

            Returns the stream to be used for debugging output. If no stream has been set, System.out is returned.

            Returns:
                the PrintStream to use for debugging output
            Since:
                JavaMail 1.3

            getProviders

            public Provider[] getProviders()

            This method returns an array of all the implementations installed via the javamail.[default.]providers files that can be loaded using the ClassLoader available to this application.

            Returns:
                Array of configured providers

            getProvider

            public Provider getProvider(String protocol)
                                 throws NoSuchProviderException

            Returns the default Provider for the protocol specified. Checks mail.<protocol>.class property first and if it exists, returns the Provider associated with this implementation. If it doesn't exist, returns the Provider that appeared first in the configuration files. If an implementation for the protocol isn't found, throws NoSuchProviderException

            Parameters:
                protocol - Configured protocol (i.e. smtp, imap, etc)
            Returns:
                Currently configured Provider for the specified protocol
            Throws:
                NoSuchProviderException - If a provider for the given protocol is not found.

            setProvider

            public void setProvider(Provider provider)
                             throws NoSuchProviderException

            Set the passed Provider to be the default implementation for the protocol in Provider.protocol overriding any previous values.

            Parameters:
                provider - Currently configured Provider which will be set as the default for the protocol
            Throws:
                NoSuchProviderException - If the provider passed in is invalid.

            getStore

            public Store getStore()
                           throws NoSuchProviderException

            Get a Store object that implements this user's desired Store protocol. The mail.store.protocol property specifies the desired protocol. If an appropriate Store object is not obtained, NoSuchProviderException is thrown

            Returns:
                a Store object
            Throws:
                NoSuchProviderException - If a provider for the given protocol is not found.

            getStore

            public Store getStore(String protocol)
                           throws NoSuchProviderException

            Get a Store object that implements the specified protocol. If an appropriate Store object cannot be obtained, NoSuchProviderException is thrown.

            Parameters:
                protocol - 
            Returns:
                a Store object
            Throws:
                NoSuchProviderException - If a provider for the given protocol is not found.

            getStore

            public Store getStore(URLName url)
                           throws NoSuchProviderException

            Get a Store object for the given URLName. If the requested Store object cannot be obtained, NoSuchProviderException is thrown. The "scheme" part of the URL string (Refer RFC 1738) is used to locate the Store protocol.

            Parameters:
                url - URLName that represents the desired Store
            Returns:
                a closed Store object
            Throws:
                NoSuchProviderException - If a provider for the given URLName is not found.
            See Also:
                getFolder(URLName), URLName

            getStore

            public Store getStore(Provider provider)
                           throws NoSuchProviderException

            Get an instance of the store specified by Provider. Instantiates the store and returns it.

            Parameters:
                provider - Store Provider that will be instantiated
            Returns:
                Instantiated Store
            Throws:
                NoSuchProviderException - If a provider for the given Provider is not found.

            getFolder

            public Folder getFolder(URLName url)
                             throws MessagingException

            Get a closed Folder object for the given URLName. If the requested Folder object cannot be obtained, null is returned.

            The "scheme" part of the URL string (Refer RFC 1738) is used to locate the Store protocol. The rest of the URL string (that is, the "schemepart", as per RFC 1738) is used by that Store in a protocol dependent manner to locate and instantiate the appropriate Folder object.

            Note that RFC 1738 also specifies the syntax for the "schemepart" for IP-based protocols (IMAP4, POP3, etc.). Providers of IP-based mail Stores should implement that syntax for referring to Folders.

            Parameters:
                url - URLName that represents the desired folder
            Returns:
                Folder
            Throws:
                NoSuchProviderException - If a provider for the given URLName is not found.
                MessagingException - if the Folder could not be located or created.
            See Also:
                getStore(URLName), URLName

            getTransport

            public Transport getTransport()
                                   throws NoSuchProviderException

            Get a Transport object that implements this user's desired Transport protcol. The mail.transport.protocol property specifies the desired protocol. If an appropriate Transport object cannot be obtained, MessagingException is thrown.

            Returns:
                a Transport object
            Throws:
                NoSuchProviderException - If the provider is not found.

            getTransport

            public Transport getTransport(String protocol)
                                   throws NoSuchProviderException

            Get a Transport object that implements the specified protocol. If an appropriate Transport object cannot be obtained, null is returned.

            Returns:
                a Transport object
            Throws:
                NoSuchProviderException - If provider for the given protocol is not found.

            getTransport

            public Transport getTransport(URLName url)
                                   throws NoSuchProviderException

            Get a Transport object for the given URLName. If the requested Transport object cannot be obtained, NoSuchProviderException is thrown. The "scheme" part of the URL string (Refer RFC 1738) is used to locate the Transport protocol.

            Parameters:
                url - URLName that represents the desired Transport
            Returns:
                a closed Transport object
            Throws:
                NoSuchProviderException - If a provider for the given URLName is not found.
            See Also:
                URLName

            getTransport

            public Transport getTransport(Provider provider)
                                   throws NoSuchProviderException

            Get an instance of the transport specified in the Provider. Instantiates the transport and returns it.

            Parameters:
                provider - Transport Provider that will be instantiated
            Returns:
                Instantiated Transport
            Throws:
                NoSuchProviderException - If provider for the given provider is not found.

            getTransport

            public Transport getTransport(Address address)
                                   throws NoSuchProviderException

            Get a Transport object that can transport a Message of the specified address type.

            Parameters:
                address - 
            Returns:
                A Transport object
            Throws:
                NoSuchProviderException - If provider for the Address type is not found
            See Also:
                Address

            setPasswordAuthentication

            public void setPasswordAuthentication(URLName url,
                                                  PasswordAuthentication pw)

            Save a PasswordAuthentication for this (store or transport) URLName. If pw is null the entry corresponding to the URLName is removed.

            This is normally used only by the store or transport implementations to allow authentication information to be shared among multiple uses of a session.
            getPasswordAuthentication

            public PasswordAuthentication getPasswordAuthentication(URLName url)

            Return any saved PasswordAuthentication for this (store or transport) URLName. Normally used only by store or transport implementations.

            Returns:
                the PasswordAuthentication corresponding to the URLName

            requestPasswordAuthentication

            public PasswordAuthentication requestPasswordAuthentication(InetAddress addr,
                                                                        int port,
                                                                        String protocol,
                                                                        String prompt,
                                                                        String defaultUserName)

            Call back to the application to get the needed user name and password. The application should put up a dialog something like:

             Connecting to <protocol> mail service on host <addr>, port <port>.
             <prompt>

             User Name: <defaultUserName>
             Password:
             

            Parameters:
                addr - InetAddress of the host. may be null.
                protocol - protocol scheme (e.g. imap, pop3, etc.)
                prompt - any additional String to show as part of the prompt; may be null.
                defaultUserName - the default username. may be null.
            Returns:
                the authentication which was collected by the authenticator; may be null.

            getProperties

            public Properties getProperties()

            Returns the Properties object associated with this Session

            Returns:
                Properties object

            getProperty

            public String getProperty(String name)

            Returns the value of the specified property. Returns null if this property does not exist.

            Returns:
                String that is the property value

            addProvider

            public void addProvider(Provider provider)

            Add a provider to the session.

            Parameters:
                provider - the provider to add
            Since:
                JavaMail 1.4

            setProtocolForAddress

            public void setProtocolForAddress(String addresstype,
                                              String protocol)

            Set the default transport protocol to use for addresses of the specified type. Normally the default is set by the javamail.default.address.map or javamail.address.map files or resources.

            Parameters:
                addresstype - type of address
                protocol - name of protocol
            Since:
                JavaMail 1.4
            See Also:
                getTransport(Address)

## Internet Mail

The JavaMail specification does not define any implementation. However, the API does include a set of classes that implement Internet Mail standards. Although not part of the
specification, these classes can be considered part of the JavaMail package. They show how to adapt an existing messaging architecture to the JavaMail framework.
These classes implement the Internet Mail Standards defined by the RFCs listed below:

1. RFC822 (Standard for the Format of Internet Text Messages)
2. RFC2045, RFC2046, RFC2047 (MIME)

RFC822 describes the structure of messages exchanged across the Internet. Messages are viewed as having a header and contents. The header is composed of a set of standard and
optional header fields. The header is separated from the content by a blank line. The RFC specifies the syntax for all header fields and the semantics of the standard header fields. It does not however, impose any structure on the message contents.

The MIME RFCs 2045, 2046 and 2047 define message content structure by defining structured body parts, a typing mechanism for identifying different media types, and a set of
encoding schemes to encode data into mail-safe characters.

The Internet Mail package allows clients to create, use and send messages conforming to the standards listed above. It gives service providers a set of base classes and utilities they can use to implement Stores and Transports that use the Internet mail protocols. See “MimeMessage
Object Hierarchy” on page 89 for a Mime class and interface hierarchy diagram.
The JavaMail MimePart interface models an entity as defined in RFC2045, Section 2.4. MimePart extends the JavaMail Part interface to add MIME-specific methods and semantics.
The MimeMessage and MimeBodyPart classes implement the MimePart interface. The following figure shows the class hierarchy of these classes.

- `The MimeMessage Class`:- The MimeMessage class extends Message and implements MimePart. This class implements an email message that conforms to the RFC822 and MIME standards.

The MimeMessage class provides a default constructor that creates an empty MimeMessage object. The client can fill in the message later by invoking the parse method on an RFC822 input stream. Note that the parse method is protected, so that only this class and its subclasses can use this method. Service providers implementing ’light-
weight’ Message objects that are filled in on demand can generate the appropriate byte stream and invoke the parse method when a component is requested from a message.
Service providers that can provide a separate byte stream for the message body (distinct from the message header) can override the getContentStream method

The client can also use the default constructor to create new MimeMessage objects for sending. The client sets appropriate attributes and headers, inserts content into the message object, and finally calls the send method for that MimeMessage object.

```java
MimeMessage m = new MimeMessage(session);
// Set FROM:
m.setFrom(new InternetAddress("jmk@Sun.COM"));
// Set TO:
InternetAddress a[] = new InternetAddress[1];
a[0] = new InternetAddress("javamail@Sun.COM");
m.setRecipients(Message.RecipientType.TO, a);
// Set content
m.setContent(data, "text/plain");
// Send message
Transport.send(m);
```

The MimeMessage class also provides a constructor that uses an input stream to instantiate itself. The constructor internally invokes the parse method to fill in the message. The InputStream object is left positioned at the end of the message body.

```java
InputStream in = getMailSource(); // a stream of mail messages
MimeMessage m = null;
for (; ;) {
try {
m = new MimeMessage(session,in);
} catch (MessagingException ex) {
// reached end of message stream
break;
}
}
```

MimeMessage implements the writeTo method by writing an RFC822-formatted byte stream of its headers and body. This is accomplished in two steps: First, the MimeMessage
object writes out its headers; then it delegates the rest to the DataHandler object representing the content

- `The MimeBodyPart Class`:- The MimeBodyPart class extends BodyPart and implements the MimePart interface.This class represents a Part inside a Multipart. MimeBodyPart implements a Body Part as defined by RFC2045.
The getBodyPart(int index) returns the MimeBodyPart object at the given index.MimeMultipart also allows the client to fetch MimeBodyPart objects based on their
Content-IDs.The addBodyPart method adds a new MimeBodyPart object to a MimeMultipart as a step towards constructing a new multipart MimeMessage.


The JavaMail API supports the following standard properties, which may be set in the Session object, or in the Properties object used to create the Session object. The properties are always set as strings; the Type column describes how the string is interpreted. For example, use

        props.put("mail.debug", "true");

to set the mail.debug property, which is of type boolean.

Name 	Type 	Description
mail.debug 	boolean 	The initial debug mode. Default is false.
mail.from 	String 	The return email address of the current user, used by the InternetAddress method getLocalAddress.
mail.mime.address.strict 	boolean 	The MimeMessage class uses the InternetAddress method parseHeader to parse headers in messages. This property controls the strict flag passed to the parseHeader method. The default is true.
mail.host 	String 	The default host name of the mail server for both Stores and Transports. Used if the mail.protocol.host property isn't set.
mail.store.protocol 	String 	Specifies the default message access protocol. The Session method getStore() returns a Store object that implements this protocol. By default the first Store provider in the configuration files is returned.
mail.transport.protocol 	String 	Specifies the default message transport protocol. The Session method getTransport() returns a Transport object that implements this protocol. By default the first Transport provider in the configuration files is returned.
mail.user 	String 	The default user name to use when connecting to the mail server. Used if the mail.protocol.user property isn't set.
mail.protocol.class 	String 	Specifies the fully qualified class name of the provider for the specified protocol. Used in cases where more than one provider for a given protocol exists; this property can be used to specify which provider to use by default. The provider must still be listed in a configuration file.
mail.protocol.host 	String 	The host name of the mail server for the specified protocol. Overrides the mail.host property.
mail.protocol.port 	int 	The port number of the mail server for the specified protocol. If not specified the protocol's default port number is used.
mail.protocol.user 	String 	The user name to use when connecting to mail servers using the specified protocol. Overrides the mail.user property.

The following properties are supported by Sun's implementation of JavaMail, but are not currently a required part of the specification. The names, types, defaults, and semantics of these properties may change in future releases.

Name 	Type 	Description
mail.debug.auth 	boolean 	Include protocol authentication commands (including usernames and passwords) in the debug output. Default is false.
mail.transport.protocol.address-type 	String 	Specifies the default message transport protocol for the specified address type. The Session method getTransport(Address) returns a Transport object that implements this protocol when the address is of the specified type (e.g., "rfc822" for standard internet addresses). By default the first Transport configured for that address type is used. This property can be used to override the behavior of the send method of the Transport class so that (for example) the "smtps" protocol is used instead of the "smtp" protocol by setting the property mail.transport.protocol.rfc822 to "smtps".

The JavaMail API also supports several System properties; see the javax.mail.internet package documentation for details.

The JavaMail reference implementation from Sun includes protocol providers in subpackages of com.sun.mail. Note that the APIs to these protocol providers are not part of the standard JavaMail API. Portable programs will not use these APIs.

Nonportable programs may use the APIs of the Sun protocol providers by (for example) casting a returned Folder object to a com.sun.mail.imap.IMAPFolder object. Similarly for Store and Message objects returned from the standard JavaMail APIs.

The Sun protocol providers also support properties that are specific to those providers. The package documentation for the IMAP, POP3, and SMTP packages provide details.

In addition to printing debugging output as controlled by the Session configuration, the current implementation of classes in this package log the same information using Logger as described in the following table:

Logger Name 	Logging Level 	Purpose
javax.mail 	CONFIG 	Configuration of the Session
javax.mail 	FINE 	General debugging output

The JavaMail API provides a platform-independent and protocol-independent framework to build mail and messaging applications. The JavaMail API is available as an optional package for use with the Java SE platform and is also included in the Java EE platform.

In the years since its first release, the JavaTM programming language has matured to become a platform. The Java platform has added functionality, including distributed computing with RMI and CORBA, and a component architecture (JavaBeansTM). Java applications have also matured, and many need an addition to the Java platform: a mail and messaging framework.The JavaMailTM API described in this specification satisfies that need.

The JavaMail API provides a set of abstract classes defining objects that comprise a mail system. The API defines classes like Message, Store and Transport. The API can be extended and can be subclassed to provide new protocols and to add functionality when necessary.

In addition, the API provides concrete subclasses of the abstract classes. These subclasses,including MimeMessage and MimeBodyPart, implement widely used Internet mail protocols and conform to specifications RFC822 and RFC2045. They are ready to be used in application development.

## Mail Session

Before you create a maail session,you need to create a `Properties` object that contains any properties that session needs to send or receive mail.A Properties object stores a list of properties where each property has a name,which is often referred to as a key, and a value.To specify properties for a mail session,you can use the put method of Properties class to define any of standard properties available in JavaMail API.

To create a mail session,you can call the `getDefaultInstance` method of Session class to get a Session object that has all default settings for a mail session.
After creating session object,you can use setDebug method of Session object to turn on debugging for the session.As a result,the Session object will print debugging information to the console.

`Environment Properties`:- Common environment properties that are used by the JavaMail APIs icludes:-

1. mail.store.protocol - Specifies the default Message Access Protocol.The Session.getStore() method returns a Store object that implements this protocol.The client can override this property and explicitly specify the protocol with the Session.getStore(String protocol) method.Default Value is The first appropriate protocol in the config files.
2. mail.transport.protocol - Specifies the default Transport Protocol. The Session.getTransport() method returns a Transport object that implements this protocol. The client can override this property and explicitly specify the protocol by using Session.getTransport(String protocol) method.
3. mail.host - Specifies the default Mail server. The Store and Transport object’s connect methods use this property, if the protocol-specific host property is absent, to locate the target host.- The local machine.
4. mail.user - Specifies the username to provide when connecting to a Mail server. The Store and Transport object’s connect methods use this property, if the protocol-specific username property is absent, to obtain the username.
5. mail.protocol.host - Specifies the protocol-specific default Mail server. This overrides the mail.host property.
6. mail.protocol.user - Specifies the protocol-specific default username for connecting to the Mail server.This overrides the mail.user property.
7. mail.from - Specifies the return address of the current user.Used by the InternetAddress.getLocalAddress method to specify the current user’s email address.
8. mail.debug - Specifies the initial debug mode. Setting this property to true will turn on debug mode, while setting it to false turns debug mode off.
9. mail.smtp.quitwait - Prevents an SSLException that sometimes occur when you use GMAIL SMTP server.
10. mail.smtp.auth - Indicates that the user must be authenticated before session can connect to SMTP server.

```java
//Local SMTP server
Properties props = new Properties();
props.put("mail.trancport.protocol", "smtps");
props.put("mail.smtp.host", "localhost"); // Your SMTP server
props.put("mail.smtp.port", 25); // Port for TLS
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true"); // Enable TLS

Session session = Session.getDefaultInstance(props);
session.setDebug(true);

// Mail session for remote SMTP server
Properties props = new Properties();
props.put("mail.trancport.protocol", "smtps");
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", 465);
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.quitwait", "false");

Session session = Session.getDefaultInstance(props);
session.setDebug(true);
```

A mail Session object manages the configuration options and user authentication information used to interact with messaging systems.

The Session class(public final class Session) represents a mail session and is not subclassed. It collects together properties and defaults used by the mail API's. A single default session can be shared by multiple applications on the desktop. Unshared sessions can also be created.

The JavaMail API supports simultaneous multiple sessions. Each session can access multiple message stores and transports. Any desktop application that needs to access the current primary message store can share the default session. Typically the mail-enabled application establishes the default session, which initializes the authentication information necessary to access the user’s Inbox folder. Other desktop applications then use the default session when sending or accessing mail on behalf of the user. When sharing the session object, all applications share authentication information, properties, and the rest of the state of the object.

For example,

To create a Session using a static factory method:

```java
Session session = Session.getInstance(props, authenticator);
```

To create the default shared session, or to access the default shared session:

```java
Session defaultSession =Session.getDefaultInstance(props, authenticator);
```

The Properties object that initializes the Session contains default values and other
configuration information. It is expected that clients using the APIs set the values for the listed
properties, especially mail.host, mail.user, and mail.from, since the defaults are
unlikely to work in all cases. See “Environment Properties” on page 61 for a list of properties
used by the JavaMail APIs and their defaults.

Some messaging system implementations can use additional properties. Typically the
properties object contains user-defined customizations in addition to system-wide defaults.
Mail-enabled application logic determines the appropriate set of properties. Lacking a specific
requirement, the application can use the system properties object retrieved from the
System.getProperties method.
The Authenticator object controls security aspects for the Session object. The
messaging system uses it as a callback mechanism to interact with the user when a password
is required to login to a messaging system. It indirectly controls access to the default session,
as described below.
Clients using JavaMail can register PasswordAuthentication objects with the
Session object for use later in the session or for use by other users of the same session.
Because PasswordAuthentication objects contain passwords, access to this informationmust be carefully controlled. Applications that create Session objects must restrict access to
those objects appropriately. In addition, the Session class shares some responsibility for
controlling access to the default session object.
The first call to the getDefaultInstance method creates a new Session object and
associates it with the Authenticator object. Subsequent calls to the
getDefaultInstance method compare the Authenticator object passed in with the
Authenticator object saved in the default session. Access to the default session is allowed
if both objects have been loaded by the same class loader. Typically, this is the case when both
the default session creator and the program requesting default session access are in the same
"security domain." Also, if both objects are null, access is allowed. Using null to gain
access is discouraged, because this allows access to the default session from any security
domain.
A mail-enabled client uses the Session object to retrieve a Store or Transport object in
order to read or send mail. Typically, the client retrieves the default Store or Transport
object based on properties loaded for that session:
Store store = session.getStore();
The client can override the session defaults and access a Store or Transport object that
implements a particular protocol.
Store store = session.getStore("imap");
See “The Provider Registry” on page 26 for details.
Implementations of Store and Transport objects will be told the session to which they
have been assigned. They can then make the Session object available to other objects
contained within this Store or Transport objects using application-dependent logic.

he Provider Registry
The Provider Registry allows providers to register their protocol implementations to be used
by JavaMail APIs. It provides a mechanism for discovering available protocol, for registering
new protocols, and for specifying default implementations.
Resource Files
The providers for JavaMail APIs are configured using the following files:
?
?
javamail.providers and javamail.default.providers
javamail.address.map and javamail.default.address.map
Each javamail.X resource file is searched in the following order:

1. java.home/lib/javamail.X
2. META-INF/javamail.X
3. META-INF/javamail.default.X

The first method allows the user to include their own version of the resource file by placing it
in the lib directory where the java.home property points. The second method allows an
application that uses the JavaMail APIs to include their own resource files in their
application’s or jar file’s META-INF directory. The javamail.default.X default files are
part of the JavaMail mail.jar file.
File location depends upon how the ClassLoader.getResource method is implemented.
Usually, the getResource method searches through CLASSPATH until it finds the requested
file and then stops. JDK 1.2 and newer allows all resources of a given name to be loaded from
all elements of the CLASSPATH. However, this only affects method two, above; method one
is loaded from a specific location (if allowed by the SecurityManager) and method three
uses a different name to ensure that the default resource file is always loaded successfully.
The ordering of entries in the resource files matters. If multiple entries exist, the first entries
take precedence over the latter entries as the initial defaults. For example, the first IMAP
provider found will be set as the default IMAP implementation until explicitly changed by the
application.
The user- or system-supplied resource files augment, they do not override, the default files
included with the JavaMail APIs. This means that all entries in all files loaded will be
available.
javamail.providers and
javamail.default.providers
These resource files specify the stores and transports that are available on the system, allowing
an application to "discover" what store and transport implementations are available. The
protocol implementations are listed one per line. The file format defines four attributes that
describe a protocol implementation. Each attribute is an "="-separated name-value pair with
the name in lowercase. Each name-value pair is semi-colon (";") separated.

protocolName - assigned to protocol. For example, ’smtp’ for Transport.
typeValid - entries are “store” and “transport”.
classClass - name that implements this protocol.
vendorOptional - string identifying the vendor.
versionOptional - string identifying the version.

javamail.address.map and
javamail.default.address.map
These resource files map transport address types to the transport protocol. The
javax.mail.Address.getType() method returns the address type. The
javamail.address.map file maps the transport type to the protocol. The file format is a
series of name-value pairs. Each key name should correspond to an address type that is
currently installed on the system; there should also be an entry for each
javax.mail.Address implementation that is present if it is to be used. For example,
javax.mail.internet.InternetAddress.getType() returns rfc822. Each
referenced protocol should be installed on the system. For the case of news, below, the client
should install a Transport provider supporting the nntp protocol.
Here are the typical contents of a javamail.address.map file.
rfc822=smt

Provider
Provider is a class that describes a protocol implementation. The values come from the
javamail.providers and javamail.default.providers resource files.

Protocol Selection and Defaults
The constructor for the Session object initializes the appropriate variables from the resource
files. The order of the protocols in the resource files determines the initial defaults for protocol
implementations. The methods, getProviders(), {getProvider()and
setProvider() allow the client to discover the available (installed) protocol
implementations, and to set the protocols to be used by default.
At runtime, an application may set the default implementation for a particular protocol. It can
set the mail.protocol.class property when it creates the Session object. This property
specifies the class to use for a particular protocol. The getProvider() method consults this
property first.
The code can also call setProviders() passing in a Provider that was returned by the
discovery methods. A Provider object in not normally explicitly created; it is usually retrieved
using the getProviders() method.
In either case, the provider specified is one of the ones configured in the resource files. An
application may also instantiate a Provider object to configure a new implementation.

Example Scenarios
Scenario 1: The client application invokes the default protocols:

```java
class Application1 {
init() {
// application properties include the JavaMail required properties: mail.store.protocol,mail.transport.protocol, mail.host, mail.user
Properties props = loadApplicationProps();
Session session = Session.getInstance(props, null);
/* get the store implementation of the protocol defined in mail.store.protocol; the implementation returned will be defined by the order of entries in
javamail.providers & javamail.default.providers */
try {
Store store = session.getStore();
store.connect();
} catch (MessagingException mex) {}
...
}
}
```

Scenario 2: The client application presents available implementations to the user and then sets
the user’s choice as the default implementation:

```java
class Application2 {
init() {
// application properties include the JavaMail properties: mail.store.protocol,mail.transport.protocol, mail.host, mail.user
Properties props = loadApplicationProps();
Session session = Session.getInstance(props, null);
// find out which implementations are available
Provider[] providers = session.getProviders();
// ask the user which implementations to use
// user’s response may include a number of choices,
// i.e. imap & nntp store providers & smtp transport
Provider[] userChosenProviders =
askUserWhichProvidersToUse(providers);
// set the defaults based on users response
for (int i = 0; i < userChosenProviders.length; i++)
session.setProvider(userChosenProviders[i]);
// get the store implementation of the protocol
// defined in mail.store.protocol; the implementation
// returned will be the one configured previously
try {
Store store = session.getStore();
store.connect();
} catch (MessagingException mex) {}
...
}
}
```

Scenario 3: Application wants to specify an implementation for a given protocol:

```java
class Application3 {
init() {
// application properties include the JavaMail
// required properties: mail.store.protocol,
// mail.transport.protocol, mail.host, mail.user
Properties props = loadApplicationProps();
// hard-code an implementation to use
// "com.acme.SMTPTRANSPORT"
props.put("mail.smtp.class", "com.acme.SMTPTRANSPORT");
Session session = Session.getInstance(props, null);
// get the smtp transport implementation; the
// implementation returned will be com.acme.SMTPTRANSPORT
// if it was correctly configured in the resource files.
// If com.acme.SMTPTRANSPORT can’t be loaded, a
// MessagingException is thrown.
try {
Transport transport = session.getTransport("smtp");
} catch (MessagingException mex) {
quit();
}
}
...
}
```

## Message

Once you create the Session object,you can create an object that defines an email message.
To do that, you pass a Session object to the constructor of the MimeMessage class to create a MimeMessage class to create a MimeMessage object.Then, you can set the subject,body and address for the message.To set the subject use setSubject method,to set message body as plain text,you use setText method.

When you use the setText method to set the body of the message,the MIME type for the message is automatically set to text/plain.For many text messages,that is inadequate.However,since most modern mail clients can display text that's formatted with HTML tags,it's also common to use the setContent method to change the MIME type for a message to text/html.then,the body of the message can include HTML tags that format the text,display images, and provide links to web resources.

```java
Message message = new MimeMessage(session);
message.setSubject("OrderConfirmation");
message.setText("Thanks for your order");
message.setContent("<h1>Thanks for your order</h1>", "text/html");
```

## Sending a Message

Onceyou've created and addressed a MimeMessage object, you can send the message.For an SMTP server that doesn't require authentication, you can call the static send method of the Transport class with MimeMessage object as argument.
However,if the SMTP server requires authentication,you use the staic getTransport method of Transport class to return a Transport object.Then you can use the connect method to specify a username and password that can be used to connect to the server.

Once you've connected to SMTP server,you can use the sendMessage method to send the message.When you use this method you can specify the MimeMessage object as first argument,and you can specify the second argument by calling the getAllRecipients method of MimeMessage object.Finally, you can use the close method to close the connection.

If the message can't be sent,the send or sendMessage method will throw an exception of the SendFailedException type.This exception contains a list of invalid addresses to which message could not be sent, valid addresses to which the message wasn't sent and valid addresses to which the message was sent.If necessary,you can use this exception to perform some processing such as writing these addresses to a log file.

```java
Transport.send(message);

// Authentication Required
Transport transport = session.getTransport();
transport.connect("example@gmail.com","password");
transport.sendMessage(message, message.getAllRecipients());
transport.close();
```
