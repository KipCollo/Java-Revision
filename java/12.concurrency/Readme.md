# Concurrency

All operating systems support what is known as multithreaded processing. The idea behind multithreaded processing is to allow an application or group of applications to
execute multiple tasks at the same time. This allows tasks waiting for other resources to give way to other processing requests.

Concurrency APIs provides numerous ways to manage threads.

## Threads

A `thread` is the smallest unit of execution that can be scheduled by the operating system.
A `process` is a group of associated threads that execute in the same shared environment. It follows,then, that a single-­threaded process is one that contains exactly one thread, whereas a multi-threaded process supports more than one thread.

By shared environment, we mean that the threads in the same process share the same memory space and can communicate directly with one another.

A `task` is a single unit of work performed by a thread. A thread can complete multiple independent tasks
but only one task at a time.

- Thread Concurrency:- The property of executing multiple threads and processes at the same time is referred to as concurrency.Operating systems use a thread scheduler to determine which threads should be currently executing. For example, a thread scheduler may employ a round-­robin schedule in which each available thread receives an equal number of CPU cycles with which to execute, with threads visited in a circular order.

When a thread’s allotted time is complete but the thread has not finished processing, a context switch occurs. A context switch is the process of storing a thread’s current state and later restoring the state of the thread to continue execution. Be aware that a cost is often associated with a context switch due to lost time and having to reload a thread’s state. Intelligent thread schedulers do their best to minimize the number of context switches while keeping an application running smoothly.
Finally, a thread can interrupt or supersede another thread if it has a higher thread priority than the other thread. A thread priority is a numeric value associated with a thread that is taken into consideration by the thread scheduler when determining which threads should currently be executing. In Java, thread priorities are specified as integer values.

- Creating a Thread:- One of the most common ways to define a task for a thread is by using the Runnable instance. Runnable is a functional interface that takes no arguments and returns no data.

```java
@FunctionalInterface public interface Runnable {
void run();
}
```

With this, it’s easy to create and start a thread. In fact, you can do so in one line of code using the Thread class:

```java
new Thread(() -­> System.out.print("Hello")).start();
   System.out.print("World");
```

The first line creates a new Thread object and then starts it with the start() method.Does this code print HelloWorld or WorldHello? The answer is that we don’t know.
Depending on the thread priority/scheduler, either is possible. Remember that order of thread execution is not often guaranteed. The exam commonly presents questions in which multiple tasks are started at the same time, and you must determine the result.
