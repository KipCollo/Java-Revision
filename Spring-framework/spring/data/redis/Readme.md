# Redis

Redis is an advanced key-value store. It is similar to memcached but the dataset is not volatile, and values can be strings, exactly like in memcached, but also
lists, sets, and ordered sets. All this data types can be manipulated with atomic operations to push/pop elements, add/remove elements, perform server side
union, intersection, difference between sets, and so forth. Redis supports different kind of sorting abilities.

Spring Data Redis provides easy configuration and access to Redis from Spring applications. It offers both low-level and high-level abstractions for interacting with the store, freeing the user from infrastructural concerns.

Spring Data support for Redis contains a wide range of features:
• RedisTemplate and ReactiveRedisTemplate helper class that increases productivity when performing common Redis operations. Includes integrated serializa-
tion between objects and values.
• Exception translation into Spring’s portable Data Access Exception hierarchy.
• Automatic implementation of Repository interfaces, including support for custom query methods.
• Feature-rich Object Mapping integrated with Spring’s Conversion Service.
• Annotation-based mapping metadata that is extensible to support other metadata formats.
• Transactions and Pipelining.
• Redis Cache integration through Spring’s Cache abstraction.
• Redis Pub/Sub Messaging and Redis Stream Listeners.
• Redis Collection Implementations for Java such as RedisList or RedisSet.

## Why Spring Data Redis

The Spring Framework is the leading full-stack Java/JEE application framework. It provides a lightweight container and a non-invasive programming model enabled by the
use of dependency injection, AOP, and portable service abstractions.
NoSQL storage systems provide an alternative to classical RDBMS for horizontal scalability and speed. In terms of implementation, key-value stores represent one of the
largest (and oldest) members in the NoSQL space.
The Spring Data Redis (SDR) framework makes it easy to write Spring applications that use the Redis key-value store by eliminating the redundant tasks and boilerplate
code required for interacting with the store through Spring’s excellent infrastructure support.

Redis Support High-level View: The Redis support provides several components.For most tasks, the high-level abstractions and support services are the best choice.Note that, at any point, you can move between layers.For example, you can get a low-level connection (or even the native library) to communicate directly with Redis.

## Drivers

1. RedisConnection and RedisConnectionFactory
2. Configuring the Lettuce Connector
3. Configuring the Jedis Connector

One of the first tasks when using Redis and Spring is to connect to the store through the IoC container. To do that, a Java connector (or binding) is required. No matter the library you choose, you need to use only one set of Spring Data Redis APIs (which behaves consistently across all connectors). The
org.springframework.data.redis.connection package and its RedisConnection and RedisConnectionFactory interfaces for working with and retrieving active connections to Redis

- RedisConnection and RedisConnectionFactory: RedisConnection provides the core building block for Redis communication, as it handles the communication with the Redis backend. It also automatically translates underlying connecting library exceptions to Spring’s consistent DAO exception hierarchy so that you can switch connectors without any code changes, as the operation semantics remain the same.

Active RedisConnection objects are created through RedisConnectionFactory . In addition, the factory acts as PersistenceExceptionTranslator objects,meaning that, once declared, they let you do transparent exception translation. For example, you can do exception translation through the use of the @Repository annotation and AOP.

If you need to share (stateful) Redis resources, like connections, across multiple Threads, for performance reasons or otherwise, then you should acquire the native connection and use the Redis client library (driver) API directly. Alternatively, you can use the RedisTemplate , which acquires and manages connections for operations (and Redis commands) in a Thread-safe manner. See documentation on RedisTemplate for more details.

Depending on the underlying configuration, the factory can return a new connection or an existing connection (when a pool or shared native connection is used).

The easiest way to work with a RedisConnectionFactory is to configure the appropriate connector through the IoC container and inject it into the using class.
Unfortunately, currently, not all connectors support all Redis features. When invoking a method on the Connection API that is unsupported by the underlying library, an
UnsupportedOperationException is thrown.

- Configuring the Lettuce Connector: Lettuce is a Netty-based open-source connector supported by Spring Data Redis through the org.springframework.data.redis.connection.lettuce package.

Add the following to the pom.xml files dependencies element:

```xml
<dependencies>
<!-- other dependency elements omitted -->
<dependency>
<groupId>io.lettuce</groupId>
<artifactId>lettuce-core</artifactId>
<version>6.3.2.RELEASE</version>
</dependency>
</dependencies>
```

The following example shows how to create a new Lettuce connection factory:

```java
@Configuration
class AppConfig {
@Bean
public LettuceConnectionFactory redisConnectionFactory() {
return new LettuceConnectionFactory(new RedisStandaloneConfiguration("server", 6379));
}
}
```

There are also a few Lettuce-specific connection parameters that can be tweaked. By default, all LettuceConnection instances created by the
LettuceConnectionFactory share the same thread-safe native connection for all non-blocking and non-transactional operations. To use a dedicated connection each
time, set shareNativeConnection to false . LettuceConnectionFactory can also be configured to use a LettucePool for pooling blocking and transactional
connections or all connections if shareNativeConnection is set to false .

The following example shows a more sophisticated configuration, including SSL and timeouts, that uses LettuceClientConfigurationBuilder :

```java
@Bean
public LettuceConnectionFactory lettuceConnectionFactory() {
LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
.useSsl().and()
.commandTimeout(Duration.ofSeconds(2))
.shutdownTimeout(Duration.ZERO)
.build();
return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379), clientConfig);
}
```

Lettuce integrates with Netty’s native transports, letting you use Unix domain sockets to communicate with Redis. Make sure to include the appropriate native transport dependencies that match your runtime environment.

The following example shows how to create a Lettuce Connection factory for a Unix domain socket at /var/run/redis.sock :

```java
@Configuration
class AppConfig {
JAVA
@Bean
public LettuceConnectionFactory redisConnectionFactory() {
return new LettuceConnectionFactory(new RedisSocketConfiguration("/var/run/redis.sock"));
}
}
```

- Configuring the Jedis Connector: Jedis is a community-driven connector supported by the Spring Data Redis module through the org.springframework.data.redis.connection.jedis package.
Add the following to the pom.xml files dependencies element:

```xml
<dependencies>
<!-- other dependency elements omitted -->
<dependency>
<groupId>redis.clients</groupId>
<artifactId>jedis</artifactId>
<version>5.0.2</version>
</dependency>
</dependencies>
```

In its simplest form, the Jedis configuration looks as follow:

```java
@Configuration
class AppConfig {
@Bean
public JedisConnectionFactory redisConnectionFactory() {
return new JedisConnectionFactory();
}
}
```

For production use, however, you might want to tweak settings such as the host or password, as shown in the following example:

```java
@Configuration
class RedisConfiguration {
@Bean
public JedisConnectionFactory redisConnectionFactory() {
RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("server", 6379);
return new JedisConnectionFactory(config);
}
}
```

## Connection Modes

1. Redis Standalone
2. Write to Master, Read from Replica
3. Redis Sentinel
4. Redis Cluster

Redis can be operated in various setups. Each mode of operation requires specific configuration that is explained in the following sections.

- Redis Standalone: The easiest way to get started is by using Redis Standalone with a single Redis server,Configure LettuceConnectionFactory or JedisConnectionFactory , as shown in the following example:

```java
@Configuration
class RedisStandaloneConfiguration {

/**
* Lettuce
*/
@Bean
public RedisConnectionFactory lettuceConnectionFactory() {
return new LettuceConnectionFactory(new RedisStandaloneConfiguration("server", 6379));
}

/**
* Jedis
*/
@Bean
public RedisConnectionFactory jedisConnectionFactory() {
return new JedisConnectionFactory(new RedisStandaloneConfiguration("server", 6379));
}
}
```

- Write to Master, Read from Replica: The Redis Master/Replica setup — without automatic failover (for automatic failover see: Sentinel) — not only allows data to be safely stored at more nodes. It also allows,by using Lettuce, reading data from replicas while pushing writes to the master. You can set the read/write strategy to be used by using LettuceClientConfiguration ,as shown in the following example:

```java
@Configuration
class WriteToMasterReadFromReplicaConfiguration {

@Bean
public LettuceConnectionFactory redisConnectionFactory() {
LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
   .readFrom(REPLICA_PREFERRED)
    .build();

RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration("server", 6379);
return new LettuceConnectionFactory(serverConfig, clientConfig);
}
}
```

Note: For environments reporting non-public addresses through the INFO command (for example, when using AWS), use RedisStaticMasterReplicaConfiguration instead of
RedisStandaloneConfiguration . Please note that RedisStaticMasterReplicaConfiguration does not support Pub/Sub because of missing Pub/Sub message propagation
across individual servers

Redis Sentinel- For dealing with high-availability Redis, Spring Data Redis has support for Redis Sentinel, using RedisSentinelConfiguration , as shown in the following example:

```java
/**
* Lettuce
*/
@Bean
public RedisConnectionFactory lettuceConnectionFactory() {
RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
.master("mymaster")
.sentinel("127.0.0.1", 26379)
.sentinel("127.0.0.1", 26380);
return new LettuceConnectionFactory(sentinelConfig);
}

/**
* Jedis
*/
@Bean
public RedisConnectionFactory jedisConnectionFactory() {
RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
.master("mymaster")
.sentinel("127.0.0.1", 26379)
.sentinel("127.0.0.1", 26380);
return new JedisConnectionFactory(sentinelConfig);
}
```

RedisSentinelConfiguration can also be defined through RedisSentinelConfiguration.of(PropertySource) , which lets you pick up the following properties:

Configuration Properties:

• spring.redis.sentinel.master : name of the master node.
• spring.redis.sentinel.nodes : Comma delimited list of host:port pairs.
• spring.redis.sentinel.username : The username to apply when authenticating with Redis Sentinel (requires Redis 6)
• spring.redis.sentinel.password : The password to apply when authenticating with Redis Sentinel
• spring.redis.sentinel.dataNode.username : The username to apply when authenticating with Redis Data Node
• spring.redis.sentinel.dataNode.password : The password to apply when authenticating with Redis Data Node
• spring.redis.sentinel.dataNode.database : The database index to apply when authenticating with Redis Data Node

Sometimes, direct interaction with one of the Sentinels is required. Using RedisConnectionFactory.getSentinelConnection() or RedisConnection.getSentinelCommands() gives you access to the first active Sentinel configured.

- Redis Cluster: Cluster support is based on the same building blocks as non-clustered communication. RedisClusterConnection , an extension to RedisConnection , handles the communication with the Redis Cluster and translates errors into the Spring DAO exception hierarchy. RedisClusterConnection instances are created with the
RedisConnectionFactory , which has to be set up with the associated RedisClusterConfiguration , as shown in the following example:

Example 1. Sample RedisConnectionFactory Configuration for Redis Cluster

```java
@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class ClusterConfigurationProperties {
/*
* spring.redis.cluster.nodes[0] = 127.0.0.1:7379
* spring.redis.cluster.nodes[1] = 127.0.0.1:7380
* ...
*/
List<String> nodes;
/**
* Get initial collection of known cluster nodes in format {@code host:port}.
*
* @return
*/
public List<String> getNodes() {
return nodes;
}
public void setNodes(List<String> nodes) {
this.nodes = nodes;
}
}
@Configuration
public class AppConfig {
/**
* Type safe representation of application.properties
*/
@Autowired ClusterConfigurationProperties clusterProperties;
public @Bean RedisConnectionFactory connectionFactory() {
return new LettuceConnectionFactory(
new RedisClusterConfiguration(clusterProperties.getNodes()));
}
}
```

Note: RedisClusterConfiguration can also be defined through RedisClusterConfiguration.of(PropertySource) , which lets you pick up the following properties:
Configuration Properties
• spring.redis.cluster.nodes : Comma-delimited list of host:port pairs.
• spring.redis.cluster.max-redirects : Number of allowed cluster redirections.

The initial configuration points driver libraries to an initial set of cluster nodes. Changes resulting from live cluster reconfiguration are kept only in the native driver and are not written back to the configuration
