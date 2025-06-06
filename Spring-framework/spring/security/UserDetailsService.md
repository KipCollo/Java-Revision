# UserDetailsService

Core interface which loads user-specific data.It is used throughout the framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.
The interface requires only one read-only method, which simplifies support for new data-access strategies.

**UserDetails loadUserByUsername(String username) throws UsernameNotFoundException**:- Locates the user based on the username. In the actual implementation, the search may possibly be case sensitive, or case insensitive depending on how the implementation instance is configured. In this case, the UserDetails object that comes back may have a username that is of a different case than what was actually requested..

## InMemoryUserDetailsManager

Non-persistent implementation of UserDetailsManager which is backed by an in-memory map.Mainly intended for testing and demonstration purposes, where a full blown persistent system isn't required.

## JdbcDaoImpl

UserDetailsService implementation which retrieves the user details (username, password, enabled flag, and authorities) from a database using JDBC queries.

Default Schema - A default database schema is assumed, with two tables "users" and "authorities".

The Users table - This table contains the login name, password and enabled status of the user.
Column:- username, password,enabled

The Authorities Table
Column:- username,authority

If you are using an existing schema you will have to set the queries usersByUsernameQuery and authoritiesByUsernameQuery to match your database setup.

In order to minimise backward compatibility issues, this implementation doesn't recognise the expiration of user accounts or the expiration of user credentials. However, it does recognise and honour the user enabled/disabled column. This should map to a boolean type in the result set (the SQL type will depend on the database you are using). All the other columns map to Strings.

Group Support:- Support for group-based authorities can be enabled by setting the enableGroups property to true (you may also then wish to set enableAuthorities to false to disable loading of authorities directly). With this approach, authorities are allocated to groups and a user's authorities are determined based on the groups they are a member of. The net result is the same (a UserDetails containing a set of GrantedAuthoritys is loaded), but the different persistence strategy may be more suitable for the administration of some applications.

When groups are being used, the tables "groups", "group_members" and "group_authorities" are used. See DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY for the default query which is used to load the group authorities. Again you can customize this by setting the groupAuthoritiesByUsernameQuery property, but the format of the rows returned should match the default.

## JdbcUserDetailsManager

Jdbc user management service, based on the same table structure as its parent class, JdbcDaoImpl.

Provides CRUD operations for both users and groups. Note that if the enableAuthorities property is set to false, calls to createUser, updateUser and deleteUser will not store the authorities from the UserDetails or delete authorities for the user. Since this class cannot differentiate between authorities which were loaded for an individual or for a group of which the individual is a member, it's important that you take this into account when using this implementation for managing your users.

## LdapUserDetailsManager

An Ldap implementation of UserDetailsManager.

It is designed around a standard setup where users and groups/roles are stored under separate contexts, defined by the "userDnBase" and "groupSearchBase" properties respectively.

In this case, LDAP is being used purely to retrieve information and this class can be used in place of any other UserDetailsService for authentication. Authentication isn't performed directly against the directory, unlike with the LDAP authentication provider setup.

## LdapUserDetailsService

LDAP implementation of UserDetailsService based around an LdapUserSearch and an LdapAuthoritiesPopulator. The final UserDetails object returned from loadUserByUsername is created by the configured UserDetailsContextMapper.

## CachingUserDetailsService

Implementation of UserDetailsService that utilizes caching through a UserCache

If a null UserDetails instance is returned from UserCache.getUserFromCache(String) to the UserCache got from getUserCache(), the user load is deferred to the UserDetailsService provided during construction. Otherwise, the instance retrieved from the cache is returned.

It is initialized with a NullUserCache by default, so it's strongly recommended setting your own UserCache using setUserCache(UserCache), otherwise, the delegate will be called every time.

Utilize this class by defining a Bean that encapsulates an actual implementation of UserDetailsService and providing a UserCache implementation.
For example:

```java
 @Bean
 public CachingUserDetailsService cachingUserDetailsService(UserCache userCache) {
     UserDetailsService delegate = ...;
     CachingUserDetailsService service = new CachingUserDetailsService(delegate);
     service.setUserCache(userCache);
     return service;
 }
```
