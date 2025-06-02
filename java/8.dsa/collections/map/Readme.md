# Map Interface

A map stores key-value pairs. Both key and values are objects. Using a key you can find its value. Keys must be unique, but the values may contain duplicates.

The 'Map' interface maps unique keys to values. A key is an object that can be used to retrieve its corresponding value. The 'AbstractMap' class implements most of the 'Map' interface and serves as a superclass for all concrete map implementations.

Map.of() and Map.copyOf() - Just like List and Set, there is a factory method to create a Map. You pass any number of pairs of keys and values.

```java
Map.of("key1", "value1", "key2", "value2");
```

Map also provides a method that lets you supply key/value pairs.

```java
Map.ofEntries(
Map.entry("key1", "value1"),
Map.entry("key2", "value2"));
```

Now we can’t forget to pass a value. If we leave out a parameter, the entry() method won’t compile. Conveniently, Map.copyOf(map) works just like the List and Set inter-
face copyOf() methods.

A HashMap stores the keys in a hash table. This means that it uses the hashCode() method of the keys to retrieve their values more efficiently.
The main benefit is that adding elements and retrieving the element by key both have constant time. The trade-­off is that you lose the order in which you inserted the elements.Most of the time, you aren’t concerned with this in a map anyway. If you were, you could use LinkedHashMap.

A TreeMap stores the keys in a sorted tree structure. The main benefit is that the keys are always in sorted order. Like a TreeSet, the trade-­off is that adding and checking whether a key is present takes longer as the tree grows larger.

## Working with Map Methods

Given that Map doesn’t extend Collection, more methods are specified on the Map interface.Since there are both keys and values, we need generic type parameters for both. The class uses K for key and V for value

1. public void clear() - Removes all keys and values from map.
2. public boolean containsKey(Object key) - Returns whether key is in map.
3. public boolean containsValue(Object value) - Returns whether value is in map.
4. public Set<Map.Entry<K,V>> entrySet() - Returns Set of key/value pairs.
5. public void forEach( BiConsumer<K key, V value>) - Loops through each key/value pair.
6. public V get(Object key) - Returns value mapped by key or null if none is mapped.
7. public V getOrDefault(Object key,V defaultValue) - Returns value mapped by key or default value if none is mapped.
8. public boolean isEmpty() - Returns whether map is empty.
9. public Set<K> keySet() - Returns set of all keys.
10. ublic V merge(K key, V value,Function(<V, V, V> func)) - Sets value if key not set. Runs function if key is set, to determine new value.Removes if value is null.
11. public V put(K key, V value) - Adds or replaces key/value pair. Returns previous value or null.
12. public V putIfAbsent(K key, V value) - Adds value if key not present and returns null. Otherwise, returns existing value.
13. public V remove(Object key)Removes and returns value mapped to key. Returns null if none.
14. public V replace(K key, V value)Replaces value for given key if key is set.Returns original value or null if none.
15. public void replaceAll(BiFunction<K, V, V> func)Replaces each value with results of function.
16. public int size()Returns number of entries (key/value pairs) in map.
17. public Collection<V> values()Returns Collection of all values.
