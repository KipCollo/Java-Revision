# Arrays

Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.An array is a collection of a fixed number of components, wherein the components are of same data types.

Syntax:
```
dataType arrayName[];
```

## Declaring

To declare an array, define the variable type with square brackets:
```Java
String[] cars;
```

In Java array is an object, **arrayName** is a reference variable.To store data we must initiate the array object.

```
arrayName = new datatype[intExp];
```
The **intExp** rep number of components in array.

```Java
cars = new String[10];
```

You can combine the statement:
```
dataType[] arrayName = new datatype[intExp];
```
```Java
String[] cars = new String[10];
```
- When array is initialised, Java automatically initialises it's components to their default values.e.g numeric are initialised to 0.
- To add components to array you use:

```Java
cars[0]="Volvo";
cars[1]="Toyota";
```

- We have now declared a variable that holds an array of strings. To insert values to it, you can place the values in a comma-separated list, inside curly braces:

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
```

- To create an array of integers, you could write:
```java
int[] myNum = {10, 20, 30, 40};
```
## Accessing Array Components

The general format to access an array is:
```
arrayName[indexExp]
```

```Java
myNum[1];
```

The [] operator is called **array subscripting operator**