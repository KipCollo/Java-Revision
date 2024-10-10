# HashMap Class

The 'HashMap' class extends the 'AbstractSet' class and implements the 'Map' interface. A hash map does not guarantee the order of its elements, i.e. the order in which elements are added to a hash map is not necessarily the order in which they are accessed by an iterator.
		
		/*
		 * Adding elements to HashMap
		 * 
		 * V put(K k, V v) : Declared in the 'Map' interface. Puts an entry in the
		 * invoking map, overwriting any previous value associated with the key. 'k' is
		 * the key and 'v' is the value. Returns null if the key did not already exist.
		 * Otherwise, the previous value linked to the key is returned.
		 * 
		 * void putAll(Map m) : Declared in the 'Map' interface. Puts all the entries
		 * from m into the map.
		 * 
		 * V putIfAbsent(K k, V v) : Declared in the 'Map' interface. Inserts the
		 * key-value pair into the invoking map if this entry is not already present or
		 * if the existing value for key k is null. Returns the old value or null value
		 * if key k was not already present in the map.
		 */

		/*
		 * Removing elements from HashMap
		 * 
		 * V remove(K k) : Declared in the 'Map' interface. Removes the entry whose key
		 * equals k.
		 * 
		 * boolean remove(K k, V v) : Declared in the 'Map' interface. Removes that
		 * entry from the invoking map if key equals k and value equals v and returns
		 * true. Otherwise false is returned.
		 */

         		/*
		 * Get values from HashMap
		 * 
		 * V get(K k) : Declared in the 'Map' interface. Returns the value associated
		 * with key k. Returns null if the key is not found.
		 */

         		/*
		 * Check if HashMap contains a key / value
		 * 
		 * boolean containsKey(K k) : Declared in the 'Map' interface. Returns true if
		 * key k is present in the invoking map. Otherwise, returns false.
		 * 
		 * boolean containsValue(V v) : Declared in the 'Map' interface. Returns true if
		 * value v is present in the invoking map. Otherwise, returns false.
		 */

         		/*
		 * Replace key / value in HashMap
		 * 
		 * boolean replace(K k, V oldV, V newV) : Declared in the 'Map' interface. If
		 * key-value pair specified by k and oldV is present in the invoking map, the
		 * value is replaced by newV and true is returned. Otherwise false is returned.
		 * 
		 * V replace(K k, V v) : Declared in the 'Map' interface. If key k is present in
		 * the invoking map, its corresponding value is set to v and previous value is
		 * returned. Otherwise null is returned.
		 */