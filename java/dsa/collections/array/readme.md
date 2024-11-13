# Arrays

Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.An array is a collection of a fixed number of elements, wherein the elements are of same data types.

## Properties

1. Stores data of specified type.
2. Elements are located in contigous memory.
3. Each elements has unique index.
4. Size of array is defned.

## Types of Arrays

1. One Dimensional: An array with a bunch of values having been declared with single index.i.e a[i]->i btwn 0 and N.
2. Multi Dimensional- Two dimensional, Three dimensional..N dimensional: 2D array with bunch of values declared with double index.i.e a[i(Row)][j(Column)]->i and j btwn 0 and N.

## Creating Array

We can:

- Declare: Create reference to Array.
- Instantiate: Creates an array
- Initialization: Assigns value to cells in array.

### Declaring(O(1))

Syntax:

dataType arrayName[];

To declare an array, define the variable type with square brackets:

```Java
String[] cars;
```

### Instatiate.(O(1))

In Java array is an object, **arrayName** is a reference variable.To store data we must initiate the array object.

arrayName = new datatype[intExp];

The **intExp** rep number of components in array.

```Java
cars = new String[10];
```

You can combine the statement:

dataType[] arrayName = new datatype[intExp];

```Java
String[] cars = new String[10];
```

### Initialize

- When array is initialised, Java automatically initialises it's components to their default values.e.g numeric are initialised to 0.

## Insertion

- To add components to array you use:

```Java
cars[0]="Volvo";
cars[1]="Toyota";// all sum to (O(N))
```

- Shorter way to declare and initialize an Array. To insert values to it, you can place the values in a comma-separated list, inside curly braces:

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};//(O(1))
```

- To create an array of integers, you could write:

```java
int[] myNum = {10, 20, 30, 40};
```

## Accessing Array Components

The general format to access an array is:

arrayName[indexExp]


```Java
myNum[1];
```

The [] operator is called **array subscripting operator**
