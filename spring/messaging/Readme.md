# Messages Annotations

Annotations and support classes for handling messages.Found in package **org.springframework.messaging.handler.annotation**

includes:

DestinationVariable
Annotation that indicates a method parameter should be bound to a template variable in a destination template string.
Header
Annotation which indicates that a method parameter should be bound to a message header.
Headers
Annotation which indicates that a method parameter should be bound to the headers of a message.
MessageExceptionHandler
Annotation for handling exceptions thrown from message-handling methods within a specific handler class.
MessageMapping
Annotation for mapping a Message onto a message-handling method by matching the declared patterns to a destination extracted from the message.
MessageMappingReflectiveProcessor
ReflectiveProcessor implementation for types annotated with @MessageMapping, @SubscribeMapping and @MessageExceptionHandler.
Payload
Annotation that binds a method parameter to the payload of a message.
SendTo
Annotation that indicates a method's return value should be converted to a Message if necessary and sent to the specified destination.
ValueConstants
Common annotation value constants.