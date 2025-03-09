# Cache Annoations

Annotations and supporting classes for declarative cache management. Hooked into Spring's cache interception infrastructure via CacheOperationSource.

AbstractCachingConfiguration
Abstract base @Configuration class providing common structure for enabling Spring's annotation-driven cache management capability.
AbstractCachingConfiguration.CachingConfigurerSupplier
 
AnnotationCacheOperationSource
Implementation of the CacheOperationSource interface for working with caching metadata in annotation format.
AnnotationCacheOperationSource.CacheOperationProvider
Callback interface providing CacheOperation instance(s) based on a given CacheAnnotationParser.
Cacheable
Annotation indicating that the result of invoking a method (or all methods in a class) can be cached.
CacheAnnotationParser
Strategy interface for parsing known caching annotation types.
CacheConfig
@CacheConfig provides a mechanism for sharing common cache-related settings at the class level.
CacheEvict
Annotation indicating that a method (or all methods on a class) triggers a cache evict operation.
CachePut
Annotation indicating that a method (or all methods on a class) triggers a cache put operation.
Caching
Group annotation for multiple cache annotations (of different or the same type).
CachingConfigurationSelector
Selects which implementation of AbstractCachingConfiguration should be used based on the value of EnableCaching.mode() on the importing @Configuration class.
CachingConfigurer
Interface to be implemented by @Configuration classes annotated with @EnableCaching that wish or need to specify explicitly how caches are resolved and how keys are generated for annotation-driven cache management.
CachingConfigurerSupport
Deprecated.
as of 6.0 in favor of implementing CachingConfigurer directly
EnableCaching
Enables Spring's annotation-driven cache management capability, similar to the support found in Spring's <cache:*> XML namespace.
ProxyCachingConfiguration
@Configuration class that registers the Spring infrastructure beans necessary to enable proxy-based annotation-driven cache management.
SpringCacheAnnotationParser
Strategy implementation for parsing Spring's Caching, Cacheable, CacheEvict, and CachePut annotations.