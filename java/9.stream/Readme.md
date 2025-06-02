# Stream and Optionals

`Stream API` is used to process collections of objects. A `stream` in Java is a sequence of objects that supports various methods that can be pipelined to produce the desired result.It was introduced in Java 8.It supports functional-style operations on collections and other data sources, making code concise, readable, and efficient.

Stream is an interface, containing stream() method.Stream method returns an object of type stream.Any operation can be performed inside stream method.Any changes done inside stream can be reflected on actal list.Once we work with stream we can't reuse.

Streams allows us to process a collection of data in a declarative way.A stream in Java is a sequence of data. A stream pipeline consists of the operations that run
on a stream to produce a result.

A stream is a sequence of elements that supports aggregate operations like map, filter, reduce, etc.Streams don’t store data. Instead, they operate on data from a source (e.g., collections, arrays, I/O channels).They allow declarative programming, focusing on what to do rather than how to do it.

Use of Stream in Java:

- Stream API is a way to express and process collections of objects.
- Enable us to perform operations like filtering, mapping, reducing, and sorting.

Streams don’t change the original data structure, they only provide the result as per the pipelined methods.Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined. Terminal operations mark the end of the stream and return the result.

Characteristics:-

1. Pipeline Concept:- A stream pipeline has three stages:
      - Source: Generates the stream (e.g., a list or an array).
      - Intermediate Operations: Transform the stream (e.g., filter, map).
      - Terminal Operations: Produce a result or side effects (e.g., collect, forEach).
2. Lazy Evaluation:- Intermediate operations are not executed until a terminal operation is invoked.
3. Single-Use:- Streams cannot be reused once operated on. A new stream must be created for additional operations.

Mapping
Filtering
Slicing
Sorting
Reducing
Colectors

TODO Imperative --How, Declarative --What(e.g SQL)

```java
//imperative programming - Tells computer what to do
int count = 0;
for(var movie: movies)
   if (movies.getLikes()>10)
    count ++

//declarative(Functional) Programming
var count2 = movies.stream()
      .filter(movie -> movie.getLikes() > 10)
      .count();
```

## Creating Streams

Streams can be created from:-

1. From collections
2. From arrays
3. From an arbitrary number of objects
4. Infinite/finite streams

Creating Stream Sources - In Java, the streams we have been talking about are represented by the `Stream<T> interface`, defined in the java.util.stream package.

```java
Collection<Integer> x;//Collections
x.stream()

var list= new ArrayList<>();//List
list.stream()

int[] numbers = {1,2,3};//Arrays
Arrays.stream(numbers);

Stream.of(1,2,3,4);

Stream.generate(()- > Math.random());//infinite stream
Stream.iterate(1,n -> n +1);
```

Creating Finite Streams - There are a few ways to create them.

```java
Stream<String> empty = Stream.empty();// count = 0
Stream<Integer> singleElement = Stream.of(1);// count = 1
Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3
```

Creating a Parallel Stream - It is just as easy to create a parallel stream from a list.

```java
var list = List.of("a", "b", "c");
Stream<String> fromListParallel = list.parallelStream();
```

Creating Infinite Streams

```java
Stream<Double> randoms = Stream.generate(Math::random);
Stream<Integer> oddNumbers = Stream.iterate(1, n -­> n + 2);
```

The iterate() method takes a seed or starting value as the first parameter. This is the first element that will be part of the stream. The other parameter is a lambda expression that is passed the previous value and generates the next value. As with the random numbers example, it will keep on producing odd numbers as long as you need them.

1. Stream.empty() - Finite - Creates Stream with zero elements.
2. Stream.of(varargs) - Finite - Creates Stream with elements listed.
3. coll.stream() - Finite - Creates Stream from Collection.
4. coll.parallelStream() - Finite - Creates Stream from Collection where the stream can run in parallel.
5. Stream.generate(supplier) - Infinite - Creates Stream by calling Supplier for each element upon request.
6. Stream.iterate(seed,unaryOperator) - Infinite - Creates Stream by using seed for first element and then calling UnaryOperator for each subsequent element upon request.
7. Stream.iterate(seed,predicate,unaryOperator) - Finite or infinite - Creates Stream by using seed for first element and then calling UnaryOperator for each subsequent element upon request. Stops if Predicate returns false

There are three parts to a stream pipeline:-

- Source: Where the stream comes from.
- Intermediate operations: Transforms the stream into another one. There can be as few or as many intermediate operations as you’d like. Since streams use lazy evaluation, the intermediate operations do not run until the terminal operation runs.
- Terminal operation: Produces a result. Since streams can be used only once, the stream is no longer valid after a terminal operation completes.

## Operations On Streams

There are two types of Operations in Streams:

1. Intermediate Operations -Are operations in which multiple methods are chained in a row.
2. Terminate Operations

- `Intermediate`

- map() - The map method is used to return a stream consisting of the results of applying the given function to the elements of this stream.

Syntax:

```Java
<R> Stream<R> map(Function<? super T, ? extends R> mapper)

list.stream()
      .map(String::toUpperCase)
```

- filter() - The filter method is used to select elements as per the Predicate passed as an argument.*Stream<T> filter(Predicate<? super T> predicate)*

```Java
Predicate<Movie> isPopular = m -> m.getLikes() > 10;
movies.stream()
      .filter(isPopular)

movies.stream()
      .filter(m -> m.getLikes() > 10)

list.stream()
    .filter(s -> s.startsWith("A"))
    .forEach(System.out::println);
```

- sorted() - The sorted method is used to sort the stream.

Syntax:

```java
Stream<T> sorted()
Stream<T> sorted(Comparator<? super T> comparator)

list.stream()
    .sorted()
    .forEach(System.out::println);
```

- flatMap()

Syntax:

The flatMap operation in Java Streams is used to flatten a stream of collections into a single stream of elements.

```Java
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```

- distinct ()
Removes duplicate elements. It returns a stream consisting of the distinct elements (according to Object.equals(Object)).

Syntax:

```Java
Stream<T> distinct()
```

- peek() - Performs an action on each element without modifying the stream. It returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

Syntax:

```Java
Stream<T> peek(Consumer<? super T> action)
```

The program prints the intermediate results stored in the intermediateResults set. Finally, it prints the result list, which contains the fully processed strings after all stream operations.

This example showcases how Java Streams can be used to process and manipulate collections of data in a functional and declarative manner, applying transformations and filters in a sequence of operations.

- `Terminal Operations`:- Terminal Operations are the type of Operations that return the result. These Operations are not processed further just return a final result value.

- collect() - The collect method is used to return the result of the intermediate operations performed on the stream.Gathers the stream elements into a collection.

Syntax:

```Java
<R, A> R collect(Collector<? super T, A, R> collector)

List<String> result = list.stream()
                          .filter(s -> s.length() > 3)
                          .collect(Collectors.toList());

```

- forEach() - The forEach method is used to iterate through every element of the stream.

Syntax:

```Java
void forEach(Consumer<? super T> action)

list.stream().forEach(System.out::println);
```

- reduce() - The reduce method is used to reduce the elements of a stream to a single value. The reduce method takes a BinaryOperator as a parameter.

Syntax:

```Java
T reduce(T identity, BinaryOperator<T> accumulator)
Optional<T> reduce(BinaryOperator<T> accumulator)

int sum = numbers.stream()
                 .reduce(0, Integer::sum);
```

- count()- Returns the count of elements in the stream.

Syntax:

```Java
long count()
```

- findFirst() - Returns the first element of the stream, if present.

Syntax:

```Java
Optional<T> findFirst()
```

- allMatch() - Checks if all elements of the stream match a given predicate.

Syntax:

```Java
boolean allMatch(Predicate<? super T> predicate)
```

- anyMatch() - Checks if any element of the stream matches a given predicate.

Syntax:

```Java
boolean anyMatch(Predicate<? super T> predicate)
```

Note: Intermediate Operations are running based on the concept of Lazy Evaluation, which ensures that every method returns a fixed value(Terminal operation) before moving to the next method.

## Parallel Streams

Java streams can be parallelized for performance improvement. This divides the work across multiple threads:

```java
list.parallelStream()
    .filter(s -> s.startsWith("A"))
    .forEach(System.out::println);
```

## OPTIONALS

An Optional is created using a factory. You can either request an empty Optional or pass a value for the Optional to wrap. Think of an Optional as a box that might have something in it or might instead be empty.

```java
Optional.empty()//empty
Optional.of(90)//value passed
```

Optional is primarily intended for use as a method return type where there is a clear need to represent "no result," and where using null is likely to cause errors. A variable whose type is Optional should never itself be null; it should always point to an Optional instance.

A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true. If no value is present, the object is considered empty and isPresent() returns false.

Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (returns a default value if no value is present) and ifPresent() (performs an action if a value is present).

This is a value-based class; programmers should treat instances that are equal as interchangeable and should not use instances for synchronization, or unpredictable behavior may occur. For example, in a future release, synchronization may fail.

### Creating Optional

### Methods

1. static <T> Optional<T> empty() -Returns an empty Optional instance.
2. boolean equals(Object obj) - Indicates whether some other object is "equal to" this Optional.
3. Optional<T> filter(Predicate<? super T> predicate) - If a value is present, and the value matches the given predicate, returns an Optional describing the value, otherwise returns an empty Optional.
4. <U> Optional<U> flatMap(Function<? super T,? extends Optional<? extends U>> mapper) - If a value is present, returns the result of applying the given Optional-bearing mapping function to the value, otherwise returns an empty Optional.
5. T get() - If a value is present, returns the value, otherwise throws NoSuchElementException.
6. int hashCode() - Returns the hash code of the value, if present, otherwise 0 (zero) if no value is present.
7. void ifPresent(Consumer<? super T> action) - If a value is present, performs the given action with the value, otherwise does nothing.
8. void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) - If a value is present, performs the given action with the value, otherwise performs the given empty-based action.
9. boolean isEmpty() - If a value is not present, returns true, otherwise false.
10. boolean isPresent() - If a value is present, returns true, otherwise false.
11. <U> Optional<U> map(Function<? super T,? extends U> mapper) - If a value is present, returns an Optional describing (as if by ofNullable(T)) the result of applying the given mapping function to the value, otherwise returns an empty Optional.
12. static <T> Optional<T> of(T value) - Returns an Optional describing the given non-null value.
13. static <T> Optional<T> ofNullable(T value) - Returns an Optional describing the given value, if non-null, otherwise returns an empty Optional.
14. Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) - If a value is present, returns an Optional describing the value, otherwise returns an Optional produced by the supplying function.
15. T orElse(T other) - If a value is present, returns the value, otherwise returns other.
16. T orElseGet(Supplier<? extends T> supplier) - If a value is present, returns the value, otherwise returns the result produced by the supplying function.
17. T orElseThrow() - If a value is present, returns the value, otherwise throws NoSuchElementException.
18. <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) - If a value is present, returns the value, otherwise throws an exception produced by the exception supplying function.
19. Stream<T> stream() - If a value is present, returns a sequential Stream containing only that value, otherwise returns an empty Stream.
20. String toString() - Returns a non-empty string representation of this Optional suitable for debugging.
