# Stream

Stream API is used to process collections of objects. A stream in Java is a sequence of objects that supports various methods that can be pipelined to produce the desired result. 

Use of Stream in Java:
- Stream API is a way to express and process collections of objects.
- Enable us to perform operations like filtering, mapping, reducing, and sorting.

Streams don’t change the original data structure, they only provide the result as per the pipelined methods.Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.

## Operations On Streams

There are two types of Operations in Streams:
1. Intermediate Operations -Are operations in which multiple methods are chained in a row.
2. Terminate Operations

### There are a few Intermediate Operations mentioned below:
1. map()

The map method is used to return a stream consisting of the results of applying the given function to the elements of this stream.

Syntax:
```Java
<R> Stream<R> map(Function<? super T, ? extends R> mapper)
```
2. filter()

The filter method is used to select elements as per the Predicate passed as an argument.

Syntax:
```Java
Stream<T> filter(Predicate<? super T> predicate)
```
3. sorted()

The sorted method is used to sort the stream.

Syntax:
```java
Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)
```
4.flatMap()

Syntax:

The flatMap operation in Java Streams is used to flatten a stream of collections into a single stream of elements.
```Java
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```
5. distinct ()
Removes duplicate elements. It returns a stream consisting of the distinct elements (according to Object.equals(Object)).

Syntax:
```Java
Stream<T> distinct()
```
6. peek()

Performs an action on each element without modifying the stream. It returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

Syntax:
```Java
Stream<T> peek(Consumer<? super T> action)
```

The program prints the intermediate results stored in the intermediateResults set. Finally, it prints the result list, which contains the fully processed strings after all stream operations.

This example showcases how Java Streams can be used to process and manipulate collections of data in a functional and declarative manner, applying transformations and filters in a sequence of operations.
Terminal Operations

Terminal Operations are the type of Operations that return the result. These Operations are not processed further just return a final result value.
Important Terminal Operations

### There are a few Terminal Operations mentioned below:
1. collect()

The collect method is used to return the result of the intermediate operations performed on the stream.

Syntax:

<R, A> R collect(Collector<? super T, A, R> collector)

2. forEach()

The forEach method is used to iterate through every element of the stream.

Syntax:

void forEach(Consumer<? super T> action)

3. reduce()

Syntax:

The reduce method is used to reduce the elements of a stream to a single value. The reduce method takes a BinaryOperator as a parameter.

T reduce(T identity, BinaryOperator<T> accumulator)
Optional<T> reduce(BinaryOperator<T> accumulator)

4. count()
Returns the count of elements in the stream.

Syntax:

long count()

5. findFirst()

Returns the first element of the stream, if present.

Syntax:

Optional<T> findFirst()

6. allMatch()
Checks if all elements of the stream match a given predicate.

Syntax:

boolean allMatch(Predicate<? super T> predicate)

7. anyMatch()

Checks if any element of the stream matches a given predicate.

Syntax:

boolean anyMatch(Predicate<? super T> predicate)

Here ans variable is assigned 0 as the initial value and i is added to it.

    Note: Intermediate Operations are running based on the concept of Lazy Evaluation, which ensures that every method returns a fixed value(Terminal operation) before moving to the next method.


## Difference between Stream.of() and Arrays.stream() method in Java
Arrays.stream() The stream(T[] array) method of Arrays class in Java, is used to get a Sequential Stream from the array passed as the parameter with its elements. It returns a sequential Stream with the elements of the array, passed as parameter, as its source. Example: Java Code // Java program to demonstrate Arrays.stream() method import java.uti
5 min read
## Character Stream Vs Byte Stream in Java
A stream is a sequence of data. I/O Stream refers to a stream that is unlikely a method to sequentially access a file. I/O Stream means an input source or output destination representing different types of sources e.g. disk files. The java.io package provides classes that allow you to convert between Unicode character streams and byte streams of no
4 min read
## foreach() loop vs Stream foreach() vs Parallel Stream foreach()
foreach() loopLambda operator is not used: foreach loop in Java doesn't use any lambda operations and thus operations can be applied on any value outside of the list that we are using for iteration in the foreach loop. The foreach loop is concerned over iterating the collection or array by storing each element of the list on a local variable and do
4 min read
## Java Stream | Collectors toCollection() in Java
Collectors toCollection(Supplier<C> collectionFactory) method in Java is used to create a Collection using Collector. It returns a Collector that accumulates the input elements into a new Collection, in the order in which they are passed. 
public static <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supp
2 min read
## Stream skip() method in Java with examples
Prerequisite : Streams in java The skip(long N) is a method of java.util.stream.Stream object. This method takes one long (N) as an argument and returns a stream after removing first N elements. skip() can be quite expensive on ordered parallel pipelines, if the value of N is large, because skip(N) is constrained to skip the first N elements in the
3 min read
## Stream.concat() in Java
Stream.concat() method creates a concatenated stream in which the elements are all the elements of the first stream followed by all the elements of the second stream. The resulting stream is ordered if both of the input streams are ordered, and parallel if either of the input streams is parallel. Syntax : static <T> Stream<T> concat(Str
4 min read
## Stream.distinct() in Java
distinct() returns a stream consisting of distinct elements in a stream. distinct() is the method of Stream interface. This method uses hashCode() and equals() methods to get distinct elements. In case of ordered streams, the selection of distinct elements is stable. But, in case of unordered streams, the selection of distinct elements is not neces
2 min read
## Stream sorted() in Java
Stream sorted() returns a stream consisting of the elements of this stream, sorted according to natural order. For ordered streams, the sort method is stable but for unordered streams, no stability is guaranteed. It is a stateful intermediate operation i.e, it may incorporate state from previously seen elements when processing new elements. Syntax
2 min read
## Stream.max() method in Java with Examples
Stream.max() returns the maximum element of the stream based on the provided Comparator. A Comparator is a comparison function, which imposes a total ordering on some collection of objects. max() is a terminal operation which combines stream elements and returns a summary result. So, max() is a special case of reduction. The method returns Optional
3 min read
## Stream sorted (Comparator comparator) method in Java
Stream sorted(Comparator comparator) returns a stream consisting of the elements of this stream, sorted according to the provided Comparator. For ordered streams, the sort method is stable but for unordered streams, no stability is guaranteed. It is a stateful intermediate operation i.e, it may incorporate state from previously seen elements when p
3 min read


