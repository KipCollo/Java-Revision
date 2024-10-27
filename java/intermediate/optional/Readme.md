# Optional class

Optional is primarily intended for use as a method return type where there is a clear need to represent "no result," and where using null is likely to cause errors. A variable whose type is Optional should never itself be null; it should always point to an Optional instance.

A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true. If no value is present, the object is considered empty and isPresent() returns false.

Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (returns a default value if no value is present) and ifPresent() (performs an action if a value is present).

This is a value-based class; programmers should treat instances that are equal as interchangeable and should not use instances for synchronization, or unpredictable behavior may occur. For example, in a future release, synchronization may fail.

## Methods

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
