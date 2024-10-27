# aot Hints

Annotation support for runtime hints.Found in package **org.springframework.aot.hint.annotation**

Includes:

Reflective
Indicate that the annotated element requires reflection.
ReflectiveProcessor
Process an AnnotatedElement and register the necessary reflection hints for it.
ReflectiveRuntimeHintsRegistrar
Process @Reflective annotated elements.
RegisterReflectionForBinding
Indicates that the classes specified in the annotation attributes require some reflection hints for binding or reflection-based serialization purposes.
RegisterReflectionForBindingProcessor
A ReflectiveProcessor implementation that registers reflection hints for data binding purpose (class, constructors, fields, properties, record components, including types transitively used on properties and record components).
SimpleReflectiveProcessor
A simple ReflectiveProcessor implementation that registers only a reflection hint for the annotated type.