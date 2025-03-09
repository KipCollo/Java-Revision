# Messages Annotations

Annotations and support classes for handling messages.Found in package **org.springframework.messaging.handler.annotation**

1. @DestinationVariable - Annotation that indicates a method parameter should be bound to a template variable in a destination template string.
2. @Header - Annotation which indicates that a method parameter should be bound to a message header.
3. @Headers - Annotation which indicates that a method parameter should be bound to the headers of a message.
4. @MessageExceptionHandler - Annotation for handling exceptions thrown from message-handling methods within a specific handler class.
5. @MessageMapping - Annotation for mapping a Message onto a message-handling method by matching the declared patterns to a destination extracted from the message.
6. @MessageMappingReflectiveProcessor - ReflectiveProcessor implementation for types annotated with @MessageMapping, @SubscribeMapping and @MessageExceptionHandler.
7. @Payload - Annotation that binds a method parameter to the payload of a message.
8. @SendTo - Annotation that indicates a method's return value should be converted to a Message if necessary and sent to the specified destination.
9. @ValueConstants - Common annotation value constants.
