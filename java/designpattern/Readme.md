# Design Patterns

Design Patterns are class and method-level solutions to common problems in object-oriented design.

## Interface Patterns

**ADAPTER** Provide the interface that client expects,using service of a class with different interfaces.

**FACADE** Provide an interface that makes a subsystem easy to use.

**COMPOSITE** Allow clients to treat individual objects and compositions of objects uniformly.

**BRIDGE** Decouple a class that relies on abstract operations from implementations of those abstract operations so that class and implementation can vary independently.

## Responsibiliy Patterns

**SINGLETON** Ensure that a class has only one instance, and provide a global point of access to it.

**OBSERVER** Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatially.

**MEDIATOR** Define an object that encapsulates the way that a set of objects interact.This keeps the objects from referring to each other explicitly and leaves you vary their interaction independently.

**PROXY** Provide placeholder for another object to control access to it.

**CHAIN OF RESPONSIBILIY** Avoid coupling the sender of a request to its receiver, by giving more than one object a chance to hande the request.

**FLYWEIGHT** Use sharing to support large numbes of fine-grained objects efficiently.

## Construction/Creational Pattern

**BUILDER**  Move the construction logic for an object logic for an object outside the class to instantiate, typically to allow pieceal construction or to simplify the object.

**FACTORY METHOD** Define the interface for creating an object while retaining control of which class to instantiate.

**ABSTRACT FACTORY** Provide for creation of a family of related or dependent objects.

**PROTOTYPE** Provides new objects by copying an example.

**MEMENTO** Provide for storage and restoration of an object's state.

## Operation Pattern

**TEMPLATE METHOD** Implement an algorithm in a method, deferring the definition of some steps of the algorithm so that other classes can supply them

**STATE** Distribute state-specific logic across classes that rep an object's state.

**STRATEGY** Encapsulate alternative strategies in separate classes that each implement a common operation.

**COMMAND** Encapsulate a request as an object, so that you can parameterize clients with diff requests; queue,time ot log requests and allow a client to prepare a special context in which to inoke requests.

**INTERPRETER** Let developers compose executable objects according to a set of composition rules that you define.

## Extension Patterns

**DECORATOR** Let developer compose an object's behaviour dynamically.

**ITERATOR** Provide a way to access the elements of a collection sequentially.

**VISITOR** Let developers define new operation for a hierarchy without changing the hierarchy classes.