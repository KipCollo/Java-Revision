# Set

A set is an unordered collection of elements allowing no duplicates, i.e. all the elements in a set are unique.

The main thing that all Set implementations have in common is that they do not allow duplicates.

A `HashSet` stores its elements in a hash table, which means the keys are a hash and the values are an Object. This means that the HashSet uses the hashCode() method of the objects to retrieve them more efficiently. Remember that a valid hashCode() doesn’t mean every object will get a unique value, but the method is often written so that hash values are spread out over a large range to reduce collisions.
The main benefit is that adding elements and checking whether an element is in the set both have constant time. The trade-­off is that you lose the order in which you inserted the elements. Most of the time, you aren’t concerned with this in a Set anyway, making HashSet the most common set.

A `TreeSet` stores its elements in a sorted tree structure. The main benefit is that the set is always in sorted order. The trade-­off is that adding and checking whether an element exists takes longer than with a HashSet, especially as the tree grows larger.

Like a List, you can create an immutable Set in one line or make a copy of an existing one.

```java
Set<Character> letters = Set.of('z', 'o', 'o');
Set<Character> copy = Set.copyOf(letters);
```
