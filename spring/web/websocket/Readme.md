# WebSockets

The WebSocket protocol, RFC 6455, provides a standardized way to establish a full-duplex, two-way communication channel between client and server over a single TCP connection. It is a different TCP protocol from HTTP but is designed to work over HTTP, using ports 80 and 443 and allowing re-use of existing firewall rules.

1. A WebSocket interaction begins with an HTTP request that uses the HTTP Upgrade header to upgrade or, in this case, to switch to the WebSocket protocol. The following example shows such an interaction:

```
GET /spring-websocket-portfolio/portfolio HTTP/1.1
Host: localhost:8080
Upgrade: websocket 
Connection: Upgrade 
Sec-WebSocket-Key: Uc9l9TMkWGbHFD2qnFHltg==
Sec-WebSocket-Protocol: v10.stomp, v11.stomp
Sec-WebSocket-Version: 13
Origin: http://localhost:8080

  The Upgrade header.
 Using the Upgrade connection.
```

Instead of the usual 200 status code, a server with WebSocket support returns output similar to the following:

```
HTTP/1.1 101 Switching Protocols 
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: 1qVdfYHU9hPOl4JYYNXF623Gzn0=
Sec-WebSocket-Protocol: v10.stomp

 Protocol switch
```

2. After a successful handshake, the TCP socket underlying the HTTP upgrade request remains open for both the client and the server to continue to send and receive messages.

Note that, if a WebSocket server is running behind a web server (e.g. nginx), you likely need to configure it to pass WebSocket upgrade requests on to the WebSocket server. Likewise, if the application runs in a cloud environment, check the instructions of the cloud provider related to WebSocket support.

## HTTP Versus WebSocket

Even though WebSocket is designed to be HTTP-compatible and starts with an HTTP request, it is important to understand that the two protocols lead to very different architectures and application programming models.

In HTTP and REST, an application is modeled as many URLs. To interact with the application, clients access those URLs, request-response style. Servers route requests to the appropriate handler based on the HTTP URL, method, and headers.

By contrast, in WebSockets, there is usually only one URL for the initial connect. Subsequently, all application messages flow on that same TCP connection. This points to an entirely different asynchronous, event-driven, messaging architecture.

WebSocket is also a low-level transport protocol, which, unlike HTTP, does not prescribe any semantics to the content of messages. That means that there is no way to route or process a message unless the client and the server agree on message semantics.

WebSocket clients and servers can negotiate the use of a higher-level, messaging protocol (for example, STOMP), through the Sec-WebSocket-Protocol header on the HTTP handshake request. In the absence of that, they need to come up with their own conventions.

### When to Use WebSockets

WebSockets can make a web page be dynamic and interactive. However, in many cases, a combination of AJAX and HTTP streaming or long polling can provide a simple and effective solution.

For example, news, mail, and social feeds need to update dynamically, but it may be perfectly okay to do so every few minutes. Collaboration, games, and financial apps, on the other hand, need to be much closer to real-time.

Latency alone is not a deciding factor. If the volume of messages is relatively low (for example, monitoring network failures) HTTP streaming or polling can provide an effective solution. It is the combination of low latency, high frequency, and high volume that make the best case for the use of WebSocket.

Keep in mind also that over the Internet, restrictive proxies that are outside of your control may preclude WebSocket interactions, either because they are not configured to pass on the Upgrade header or because they close long-lived connections that appear idle. This means that the use of WebSocket for internal applications within the firewall is a more straightforward decision than it is for public facing applications.

## WebSocket API

The Spring Framework provides a WebSocket API that you can use to write client- and server-side applications that handle WebSocket messages.

### WebSocketHandler

Creating a WebSocket server is as simple as implementing WebSocketHandler or, more likely, extending either TextWebSocketHandler or BinaryWebSocketHandler. The following example uses TextWebSocketHandler:

```java
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

public class MyHandler extends TextWebSocketHandler {

 @Override
 public void handleTextMessage(WebSocketSession session, TextMessage message) {
  // ...
 }

}

```

There is dedicated WebSocket Java configuration and XML namespace support for mapping the preceding WebSocket handler to a specific URL, as the following example shows:
```java
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

 @Override
 public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
  registry.addHandler(myHandler(), "/myHandler");
 }

 @Bean
 public WebSocketHandler myHandler() {
  return new MyHandler();
 }

}
```

The following example shows the XML configuration equivalent of the preceding example:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xmlns:websocket="http://www.springframework.org/schema/websocket"
 xsi:schemaLocation="
  http://www.springframework.org/schema/beans
  https://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/websocket
  https://www.springframework.org/schema/websocket/spring-websocket.xsd">

 <websocket:handlers>
  <websocket:mapping path="/myHandler" handler="myHandler"/>
 </websocket:handlers>

 <bean id="myHandler" class="org.springframework.samples.MyHandler"/>

</beans>
```

The preceding example is for use in Spring MVC applications and should be included in the configuration of a DispatcherServlet. However, Spring’s WebSocket support does not depend on Spring MVC. It is relatively simple to integrate a WebSocketHandler into other HTTP-serving environments with the help of WebSocketHttpRequestHandler.

When using the WebSocketHandler API directly vs indirectly, e.g. through the STOMP messaging, the application must synchronize the sending of messages since the underlying standard WebSocket session (JSR-356) does not allow concurrent sending. One option is to wrap the WebSocketSession with ConcurrentWebSocketSessionDecorator.

WebSocket Handshake

See equivalent in the Reactive stack

The easiest way to customize the initial HTTP WebSocket handshake request is through a HandshakeInterceptor, which exposes methods for “before” and “after” the handshake. You can use such an interceptor to preclude the handshake or to make any attributes available to the WebSocketSession. The following example uses a built-in interceptor to pass HTTP session attributes to the WebSocket session:

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

 @Override
 public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
  registry.addHandler(new MyHandler(), "/myHandler")
   .addInterceptors(new HttpSessionHandshakeInterceptor());
 }

}

The following example shows the XML configuration equivalent of the preceding example:

<beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xmlns:websocket="http://www.springframework.org/schema/websocket"
 xsi:schemaLocation="
  http://www.springframework.org/schema/beans
  https://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/websocket
  https://www.springframework.org/schema/websocket/spring-websocket.xsd">

 <websocket:handlers>
  <websocket:mapping path="/myHandler" handler="myHandler"/>
  <websocket:handshake-interceptors>
   <bean class="org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor"/>
  </websocket:handshake-interceptors>
 </websocket:handlers>

 <bean id="myHandler" class="org.springframework.samples.MyHandler"/>

</beans>

## STOMP

The WebSocket protocol defines two types of messages (text and binary), but their content is undefined. The protocol defines a mechanism for client and server to negotiate a sub-protocol (that is, a higher-level messaging protocol) to use on top of WebSocket to define what kind of messages each can send, what the format is, the content of each message, and so on. The use of a sub-protocol is optional but, either way, the client and the server need to agree on some protocol that defines message content.

STOMP (Simple Text Oriented Messaging Protocol) was originally created for scripting languages (such as Ruby, Python, and Perl) to connect to enterprise message brokers. It is designed to address a minimal subset of commonly used messaging patterns. STOMP can be used over any reliable two-way streaming network protocol, such as TCP and WebSocket. Although STOMP is a text-oriented protocol, message payloads can be either text or binary.

STOMP is a frame-based protocol whose frames are modeled on HTTP. The following listing shows the structure of a STOMP frame:

COMMAND
header1:value1
header2:value2

Body^@

Clients can use the SEND or SUBSCRIBE commands to send or subscribe for messages, along with a destination header that describes what the message is about and who should receive it. This enables a simple publish-subscribe mechanism that you can use to send messages through the broker to other connected clients or to send messages to the server to request that some work be performed.

When you use Spring’s STOMP support, the Spring WebSocket application acts as the STOMP broker to clients. Messages are routed to @Controller message-handling methods or to a simple in-memory broker that keeps track of subscriptions and broadcasts messages to subscribed users. You can also configure Spring to work with a dedicated STOMP broker (such as RabbitMQ, ActiveMQ, and others) for the actual broadcasting of messages. In that case, Spring maintains TCP connections to the broker, relays messages to it, and passes messages from it down to connected WebSocket clients. Thus, Spring web applications can rely on unified HTTP-based security, common validation, and a familiar programming model for message handling.

The following example shows a client subscribing to receive stock quotes, which the server may emit periodically (for example, via a scheduled task that sends messages through a SimpMessagingTemplate to the broker):

SUBSCRIBE
id:sub-1
destination:/topic/price.stock.*

^@

The following example shows a client that sends a trade request, which the server can handle through an @MessageMapping method:

SEND
destination:/queue/trade
content-type:application/json
content-length:44

{"action":"BUY","ticker":"MMM","shares",44}^@

After the execution, the server can broadcast a trade confirmation message and details down to the client.

The meaning of a destination is intentionally left opaque in the STOMP spec. It can be any string, and it is entirely up to STOMP servers to define the semantics and the syntax of the destinations that they support. It is very common, however, for destinations to be path-like strings where /topic/.. implies publish-subscribe (one-to-many) and /queue/ implies point-to-point (one-to-one) message exchanges.

STOMP servers can use the MESSAGE command to broadcast messages to all subscribers. The following example shows a server sending a stock quote to a subscribed client:

MESSAGE
message-id:nxahklf6-1
subscription:sub-1
destination:/topic/price.stock.MMM

{"ticker":"MMM","price":129.45}^@

A server cannot send unsolicited messages. All messages from a server must be in response to a specific client subscription, and the subscription header of the server message must match the id header of the client subscription.

The preceding overview is intended to provide the most basic understanding of the STOMP protocol. We recommended reviewing the protocol specification in full.

## Benefits

Using STOMP as a sub-protocol lets the Spring Framework and Spring Security provide a richer programming model versus using raw WebSockets. The same point can be made about HTTP versus raw TCP and how it lets Spring MVC and other web frameworks provide rich functionality. The following is a list of benefits:

    No need to invent a custom messaging protocol and message format.

    STOMP clients, including a Java client in the Spring Framework, are available.

    You can (optionally) use message brokers (such as RabbitMQ, ActiveMQ, and others) to manage subscriptions and broadcast messages.

    Application logic can be organized in any number of @Controller instances and messages can be routed to them based on the STOMP destination header versus handling raw WebSocket messages with a single WebSocketHandler for a given connection.

    You can use Spring Security to secure messages based on STOMP destinations and message types.

## Annotations

1. @EnableWebSocketMessageBroker - This annotation enables WebSocket message handling, backed by a message broker.Typically placed on a configuration class.

```java
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // Configuration methods
}
```

2. @MessageMapping - Maps a WebSocket message to a specific method in a controller. Similar to @RequestMapping for HTTP requests.Used On methods within a controller class that handles incoming messages.

```java
@MessageMapping("/send")
@SendTo("/topic/messages")
public String sendMessage(String message) {
    return message;
}
```

3. @SendTo - Specifies the destination to which the return value from a @MessageMapping method should be sent. This is where the response will be broadcasted.Used in conjunction with @MessageMapping.

```java
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        return message;
    }
```

4. @SubscribeMapping - Used to handle subscription requests from clients. It allows you to process logic when a client subscribes to a particular destination.On methods within a controller that handle subscription messages.

```java
    @SubscribeMapping("/user/queue/reply")
    public String handleSubscription() {
        return "Welcome!";
    }
```

5. @MessageExceptionHandler

    Usage: Handles exceptions that occur during message handling. You can define a method that will respond to specific exceptions.

    Where to Use: On methods within a controller to catch and handle exceptions.

```java
    @MessageExceptionHandler
    public String handleException(Throwable exception) {
        return "Error: " + exception.getMessage();
    }
```

6. @SendToUser - Used to send a message back to a specific user. This is typically used in conjunction with user sessions.Used Within a message-handling method.

```java
@MessageMapping("/private")
@SendToUser("/queue/reply")
public String sendPrivateMessage(String message) {
    return message;
}
```

### WebSocketMessageBrokerConfigurer

WebSocketMessageBrokerConfigurer is an interface provided by Spring that allows you to configure WebSocket messaging. By implementing this interface, you can customize various aspects of the WebSocket message broker, including the message broker configuration, endpoint registration, and STOMP protocol settings

Here are the main methods you typically override when implementing WebSocketMessageBrokerConfigurer:

1. configureMessageBroker(MessageBrokerRegistry config) -Configures the message broker used for routing messages. You can specify options such as enabling a simple in-memory broker, setting prefixes for destinations, and enabling a full-featured message broker like RabbitMQ.

```java
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/queue"); // Configure simple broker
        config.setApplicationDestinationPrefixes("/app"); // Prefix for client messages
    }
```

2. registerStompEndpoints(StompEndpointRegistry registry)

    PurpRegisters STOMP endpoints that clients can connect to. You can also configure SockJS fallback options here.
    Example:

```java

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS(); // Endpoint with SockJS fallback
    }
```

3. configureClientInboundChannel(ChannelRegistration registration)

    Purpose: Customize the inbound channel for messages sent by clients. You can add interceptors here to handle or modify messages.
    Example:

```java
@Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new MyChannelInterceptor()); // Custom interceptor
    }
```

4. configureClientOutboundChannel(ChannelRegistration registration)

    Purpose: Customize the outbound channel for messages sent to clients. Similar to the inbound channel configuration.
    Example:

```java

@Override
public void configureClientOutboundChannel(ChannelRegistration registration) {
    registration.interceptors(new MyOutboundChannelInterceptor()); // Custom interceptor
}
```
