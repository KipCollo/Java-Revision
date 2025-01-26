# Context 

This package builds on the beans package to add support for message sources and for the Observer design pattern, and the ability for application objects to obtain resources using a consistent API.

There is no necessity for Spring applications to depend on ApplicationContext or even BeanFactory functionality explicitly. One of the strengths of the Spring architecture is that application objects can often be configured without any dependency on Spring-specific APIs.

Two of the most fundamental and important packages in Spring are the org.springframework.beans and org.springframework.context packages. Code in these packages provides the basis for Spring's Inversion of Control (alternately called Dependency Injection) features. The BeanFactory provides an advanced configuration mechanism capable of managing beans (objects) of any nature, using potentially any kind of storage facility. The ApplicationContext builds on top of the BeanFactory (it's a subclass) and adds other functionality such as easier integration with Springs AOP features, message resource handling (for use in internationalization), event propagation, declarative mechanisms to create the ApplicationContext and optional parent contexts, and application-layer specific contexts such as the WebApplicationContext, among other enhancements.

BeanFactory provides the configuration framework and basic functionality, while the ApplicationContext adds enhanced capabilities to it, some of them perhaps more J2EE and enterprise-centric. In general, an ApplicationContext is a complete superset of a BeanFactory, and any description of BeanFactory capabilities and behavior should be considered to apply to ApplicationContexts as well.

Users are sometimes unsure whether a BeanFactory or an ApplicationContext are best suited for use in a particular situation. Normally when building most applications in a J2EE-environment, the best option is to use the ApplicationContext, since it offers all the features of the BeanFactory and adds on to it in terms of features, while also allowing a more declarative approach to use of some functionality, which is generally desirable.

The main usage scenario when you might prefer to use the BeanFactory is when memory usage is the greatest concern (such as in an applet where every last kilobyte counts), and you don't need all the features of the ApplicationContext.

Includes:

1. Application context
2. UI support
3. Validation
4. JNDI, EJB support & Remoting Mail

## ApplicationContext

While the beans package provides basic functionality for managing and manipulating beans, often in a programmatic way, the context package adds ApplicationContext, which enhances BeanFactory functionality in a more framework-oriented style.

The basis for the context package is the ApplicationContext interface, located in the org.springframework.context package.Deriving from the BeanFactory interface, it provides all the functionality of BeanFactory. To allow working in a more framework-oriented fashion, using layering and hierarchical contexts, the context package also provides the following:

- MessageSource, providing access to messages in, i18n-style
- Access to resources, such as URLs and files
- Event propagation to beans implementing the ApplicationListener interface
- Loading of multiple (hierarchical) contexts, allowing each to be focused on one particular layer, for example the web layer of an application 

### Application contexts and Resource paths

1. Constructing application context - An application context constuctor (for a specific application context type) generally takes a string or array of strings as the location path(s) of the resource(s) such as XML files that make up the definition of the context.

ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/appContext.xml");

## ApplicationContext Annotations

Annotation support for the Application Context, including JSR-250 "common" annotations, component-scanning, and Java-based metadata for creating Spring-managed objects.Found in package **org.springframework.context.annotation**.

It includes:

1. @ComponentScan - Configures component scanning directives for use with @Configuration classes.Either basePackageClasses() or basePackages() (or its alias value()) may be specified to define specific packages to scan. If specific packages are not defined, scanning will occur recursively beginning with the package of the class that declares this annotation.
2. @Import- Indicates one or more component classes to import — typically @Configuration classes.
3. @ImportResource - Indicates one or more resources containing bean definitions to import.
4. @Lazy - Indicates whether a bean is to be lazily initialized.
5. @Bean - Indicates that a method produces a bean to be managed by the Spring container.
6. @Configuration - Indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime
7. @Primary- Indicates that a bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency.
8. @Scope - When used as a type-level annotation in conjunction with @Component, @Scope indicates the name of a scope to use for instances of the annotated type.
9. @PropertySource - Annotation providing a convenient and declarative mechanism for adding a PropertySource to Spring's Environment.Used to load properties file.
10. @Profile -Indicates that a component is eligible for registration when one or more specified profiles are active.

AdviceMode
Enumeration used to determine whether JDK proxy-based or AspectJ weaving-based advice should be applied.
AdviceModeImportSelector<A extends Annotation>
Convenient base class for ImportSelector implementations that select imports based on an AdviceMode value from an annotation (such as the @Enable* annotations).
AnnotatedBeanDefinitionReader
Convenient adapter for programmatic registration of bean classes.
AnnotationBeanNameGenerator
BeanNameGenerator implementation for bean classes annotated with the @Component annotation or with another annotation that is itself annotated with @Component as a meta-annotation.
AnnotationConfigApplicationContext
Standalone application context, accepting component classes as input — in particular @Configuration-annotated classes, but also plain @Component types and JSR-330 compliant classes using jakarta.inject annotations.
AnnotationConfigBeanDefinitionParser
Parser for the <context:annotation-config/> element.
AnnotationConfigRegistry
Common interface for annotation config application contexts, defining AnnotationConfigRegistry.register(java.lang.Class<?>...) and AnnotationConfigRegistry.scan(java.lang.String...) methods.
AnnotationConfigUtils
Utility class that allows for convenient registration of common BeanPostProcessor and BeanFactoryPostProcessor definitions for annotation-based configuration.
AnnotationScopeMetadataResolver
A ScopeMetadataResolver implementation that by default checks for the presence of Spring's @Scope annotation on the bean class.
AutoProxyRegistrar
Registers an auto proxy creator against the current BeanDefinitionRegistry as appropriate based on an @Enable* annotation having mode and proxyTargetClass attributes set to the correct values.
ClassPathBeanDefinitionScanner
A bean definition scanner that detects bean candidates on the classpath, registering corresponding bean definitions with a given registry (BeanFactory or ApplicationContext).
ClassPathScanningCandidateComponentProvider
A component provider that scans for candidate components starting from a specified base package.
CommonAnnotationBeanPostProcessor
BeanPostProcessor implementation that supports common Java annotations out of the box, in particular the common annotations in the jakarta.annotation package.
CommonAnnotationBeanPostProcessor.LookupElement
Class representing generic injection information about an annotated field or setter method, supporting @Resource and related annotations.
ComponentScan.Filter
Declares the type filter to be used as an include filter or exclude filter.
ComponentScanBeanDefinitionParser
Parser for the <context:component-scan/> element.
ComponentScans
Container annotation that aggregates several ComponentScan annotations.
Condition
A single condition that must be matched in order for a component to be registered.
Conditional
Indicates that a component is only eligible for registration when all specified conditions match.
ConditionContext
Context information for use by Condition implementations.
ConfigurationClassPostProcessor
BeanFactoryPostProcessor used for bootstrapping processing of @Configuration classes.
ConfigurationClassUtils
Utilities for identifying and configuring Configuration classes.
ConfigurationCondition
A Condition that offers more fine-grained control when used with @Configuration.
ConfigurationCondition.ConfigurationPhase
The various configuration phases where the condition could be evaluated.
ContextAnnotationAutowireCandidateResolver
Complete implementation of the AutowireCandidateResolver strategy interface, providing support for qualifier annotations as well as for lazy resolution driven by the Lazy annotation in the context.annotation package.
DeferredImportSelector
A variation of ImportSelector that runs after all @Configuration beans have been processed.
DeferredImportSelector.Group
Interface used to group results from different import selectors.
DeferredImportSelector.Group.Entry
An entry that holds the AnnotationMetadata of the importing Configuration class and the class name to import.
DependsOn
Beans on which the current bean depends.
Description
Adds a textual description to bean definitions derived from Component or Bean.
EnableAspectJAutoProxy
Enables support for handling components marked with AspectJ's @Aspect annotation, similar to functionality found in Spring's <aop:aspectj-autoproxy> XML element.
EnableLoadTimeWeaving
Activates a Spring LoadTimeWeaver for this application context, available as a bean with the name "loadTimeWeaver", similar to the <context:load-time-weaver> element in Spring XML.
EnableLoadTimeWeaving.AspectJWeaving
AspectJ weaving enablement options.
EnableMBeanExport
Enables default exporting of all standard MBeans from the Spring context, as well as all @ManagedResource annotated beans.
FilterType
Enumeration of the type filters that may be used in conjunction with @ComponentScan.
FullyQualifiedAnnotationBeanNameGenerator
An extension of AnnotationBeanNameGenerator that uses the fully qualified class name as the default bean name if an explicit bean name is not supplied via a supported type-level annotation such as @Component (see AnnotationBeanNameGenerator for details on supported annotations).
ImportAware
Interface to be implemented by any @Configuration class that wishes to be injected with the AnnotationMetadata of the @Configuration class that imported it.
ImportAwareAotBeanPostProcessor
A BeanPostProcessor that honours ImportAware callback using a mapping computed at build time.
ImportBeanDefinitionRegistrar
Interface to be implemented by types that register additional bean definitions when processing @Configuration classes.
ImportRuntimeHints
Indicates that one or more RuntimeHintsRegistrar implementations should be processed.
ImportSelector
Interface to be implemented by types that determine which @Configuration class(es) should be imported based on a given selection criteria, usually one or more annotation attributes.
Jsr330ScopeMetadataResolver
Simple ScopeMetadataResolver implementation that follows JSR-330 scoping rules: defaulting to prototype scope unless Singleton is present.
LoadTimeWeavingConfiguration
@Configuration class that registers a LoadTimeWeaver bean.
LoadTimeWeavingConfigurer
Interface to be implemented by @Configuration classes annotated with @EnableLoadTimeWeaving that wish to customize the LoadTimeWeaver instance to be used.
MBeanExportConfiguration
@Configuration class that registers a AnnotationMBeanExporter bean.
PropertySources
Container annotation that aggregates several PropertySource annotations.
ResourceElementResolver
Resolver for the injection of named beans on a field or method element, following the rules of the Resource annotation but without any JNDI support.
Role
Indicates the 'role' hint for a given bean.
ScannedGenericBeanDefinition
Extension of the GenericBeanDefinition class, based on an ASM ClassReader, with support for annotation metadata exposed through the AnnotatedBeanDefinition interface.
ScopedProxyMode
Enumerates the various scoped-proxy options.
ScopeMetadata
Describes scope characteristics for a Spring-managed bean including the scope name and the scoped-proxy behavior.
ScopeMetadataResolver
Strategy interface for resolving the scope of bean definitions.
TypeFilterUtils
Collection of utilities for working with @ComponentScan type filters.

* @Lazy can be annotated with class level or method level.

1. @Component,@Configuration - Class level.
2. @Bean- Method level

Default scope of bean is singleton,Generally they are pre-initialised to discover errors in configuration.To initialize bean lazilly, we use @Lazy annotation in java config or lazy-init attribute in XML config app.If we want early initialisation,we use @Lazy(value="false")

Lazy initialisation could be;

1. Bean will not be initialized until reference/called by another bean
2. Explicitly called from ApplicationContext

* @Lazy can also be used with @Autowire(introduced in Spring  3.0)
