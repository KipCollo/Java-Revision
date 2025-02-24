# Core APIs

## Strings

A string is basically a sequence of characters.They are reference type and are immutable.

```Java

String message = new String("Hello");
String message1 = "Hello" + "World";// concatenation
```

Placing one String before the other String and combining them is called `string concatenation.`
There aren’t a lot of rules to know for this, but you have to know them well:

1. If both operands are numeric, + means numeric addition.
2. If either operand is a String, + means concatenation.
3. The expression is evaluated left to right.

```java
System.out.println(1 + 2);// 3
System.out.println("a" + "b");// ab
System.out.println("a" + "b" + 3);// ab3
System.out.println(1 + 2 + "c");// 3c
System.out.println("c" + 1 + 2);// c12
System.out.println("c" + null);// cnull
```

Since a String is a sequence of characters and it implements the interface CharSequence. This interface is a general way of representing several classes, including String and StringBuilder.

The String class has dozens of methods.String is a sequence of characters and Java counts from 0 when indexed.You also need to know that a String is immutable, or unchangeable. This means calling a method on a String will return a different String object rather than changing the value of the reference.

`Determining the Length`:- The method length() returns the number of characters in the String. The method signature is as follows:

```java
public int length()
```

The following code shows how to use length():

```java
var name = "animals";
System.out.println(name.length());// 7
```

`Getting a Single Character`The method charAt() lets you query the string to find out what character is at a specific index.
The method signature is as follows:

```java
public char charAt(int index)
```

The following code shows how to use charAt():

```java
var name = "animals";
System.out.println(name.charAt(0));// a
System.out.println(name.charAt(6));// s
System.out.println(name.charAt(7));// exception
```

`Finding an Index`;- The method indexOf() looks at the characters in the string and finds the first index that matches the desired value. The indexOf method can work with an individual character or a whole String as input. It can also start from a requested position. Remember that a char can be passed to an int parameter type.
The method signatures are as follows:

```java
public int indexOf(int ch)
public int indexOf(int ch, int fromIndex)
public int indexOf(String str)
public int indexOf(String str, int fromIndex)
```

The following code shows you how to use indexOf():

```java
var name = "animals";
System.out.println(name.indexOf('a'));// 0
System.out.println(name.indexOf("al"));//4
System.out.println(name.indexOf('a', 4));//4
System.out.println(name.indexOf("al", 5))//-1
```

`Getting a Substring`:- The method substring() also looks for characters in a string. It returns parts of the string.The first parameter is the index to start with for the returned string. As usual, this is a zero-­based index. There is an optional second parameter, which is the end index you want to stop at.
The endIndex parameter is allowed to be one past the end of the sequence if you want to stop at the end of the sequence. That would be redundant, though, since you could omit the second parameter entirely in that case.
The method signatures are as follows:

```java
public String substring(int beginIndex)
public String substring(int beginIndex, int endIndex)
```

It helps to think of indexes a bit differently for the substring methods. Pretend the indexes are right before the character they would point to.

```java
var name = "animals";
System.out.println(name.substring(3));//mals
System.out.println(name.substring(name.indexOf('m')));//mals
System.out.println(name.substring(3, 4));//m
System.out.println(name.substring(3, 7));//mals
```

`Adjusting Case`These methods make it easy to convert your data. The method signatures are as follows:

```java
public String toLowerCase()
public String toUpperCase()
```

The following code shows how to use these methods:

```java
var name = "animals";
System.out.println(name.toUpperCase());// ANIMALS
System.out.println("Abc123".toLowerCase()); // abc123
```

`Checking for Equality`:- The equals() method checks whether two String objects contain exactly the same characters in the same order. The equalsIgnoreCase() method checks whether two String objects contain the same characters, with the exception that it ignores the characters’ case.
The method signatures are as follows:

```java
public boolean equals(Object obj)
public boolean equalsIgnoreCase(String str)
```

The equals() takes an Object rather than a String. This is because the method is the same for all objects. If you pass in something that isn’t a String, it will just return false. By contrast, the equalsIgnoreCase() method only applies to String objects, so it can take the more specific type as the parameter.

```java
System.out.println("abc".equals("ABC"));//false
System.out.println("ABC".equals("ABC"));//true
System.out.println("abc".equalsIgnoreCase("ABC"));//true
```

`Searching for Substrings`:- Often, you need to search a larger string to determine if a substring is contained within it.The startsWith() and endsWith() methods look at whether the provided value matches part of the String. The contains() method isn’t as particular; it looks for matches anywhere in the String. The method signatures are as follows:

```java
public boolean startsWith(String prefix)
public boolean endsWith(String suffix)
public boolean contains(CharSequence charSeq)
```

The following code shows how to use these methods:

```java
System.out.println("abc".startsWith("a")); // true
System.out.println("abc".startsWith("A")); // false

System.out.println("abc".endsWith("c"));//true
System.out.println("abc".endsWith("a"));// false

System.out.println("abc".contains("b"));//true
System.out.println("abc".contains("B"));// false
```

Java is doing a case-­sensitive check on the values provided. Note that the contains() method is a convenience method so you don’t have to write str.indexOf(otherString) != -­1.

`Replacing Values`:- The replace() method does a simple search and replace on the string. There’s a version that takes char parameters as well as a version that takes CharSequence parameters. The method signatures are as follows:

```java
public String replace(char oldChar, char newChar)
public String replace(CharSequence target, CharSequence replacement)
```

The following code shows how to use these methods:

```java
System.out.println("abcabc".replace('a', 'A')); // AbcAbc
System.out.println("abcabc".replace("a", "A")); // AbcAbc
```

The first example uses the first method signature, passing in char parameters. The second example uses the second method signature, passing in String parameters.

`Removing Whitespace`:-These methods remove blank space from the beginning and/or end of a String. The strip() and trim() methods remove whitespace from the beginning and end of a String.Whitespace consists of spaces along with the \t (tab) and \n (newline) characters.Other characters, such as \r (carriage return), are also included in what gets trimmed. The strip() method does everything that trim() does, but it supports Unicode.

Additionally, the stripLeading() method removes whitespace from the beginning of the String and leaves it at the end. The stripTrailing() method does the opposite. It
removes whitespace from the end of the String and leaves it at the beginning. The method signatures are as follows:

```java
public String strip()
public String stripLeading()
public String stripTrailing()
public String trim()
```

The following code shows how to use these methods:

```java
System.out.println("abc".strip());// abc
System.out.println("\t a b c\n".strip());// a b c

String text = " abc\t ";
System.out.println(text.trim().length());// 3
System.out.println(text.strip().length());// 3
System.out.println(text.stripLeading().length()); // 5
System.out.println(text.stripTrailing().length());// 4
```

`Working with Indentation`:- Now that Java supports text blocks, it is helpful to have methods that deal with indentation.

```java
public String indent(int numberSpaces)
public String stripIndent()
```

The indent() method adds the same number of blank spaces to the beginning of each line if you pass a positive number. If you pass a negative number, it tries to remove that
number of whitespace characters from the beginning of the line. If you pass zero, the indentation will not change.

The stripIndent() method is useful when a String was built with concatenation rather than using a text block. It gets rid of all incidental whitespace. This means that all non-­blank lines are shifted left so the same number of whitespace characters are removed from each line and the first character that remains is not blank. Like indent(), \r\n is turned into \n. However, the stripIndent() method does not add a trailing line break if it is missing.

`Translating Escapes`:- When we escape characters, we use a single backslash. For example, \t is a tab. If we don’t want this behavior, we add another backslash to escape the backslash, so \\t is the literal string \t. The translateEscapes() method takes these literals and turns them into the equivalent escaped character. The method signature is as follows:

```java
public String translateEscapes()
```

The following code shows how to use these methods:

```java
var str = "1\\t2";
System.out.println(str);// 1\t2
System.out.println(str.translateEscapes()); // 1   2
```

The first line prints the literal string \t because the backslash is escaped. The second line prints an actual tab since we translated the escape. This method can be used for escape sequences such as \t (tab), \n (new line), \s (space), \" (double quote), and \' (single quote.)

`Checking for Empty or Blank Strings`:- Java provides convenience methods for whether a String has a length of zero or contains only whitespace characters. The method signatures are as follows:

```java
public boolean isEmpty()
public boolean isBlank()
```

The following code shows how to use these methods:

```java
System.out.println(" ".isEmpty());// false
System.out.println("".isEmpty());// true
System.out.println(" ".isBlank());// true
System.out.println("".isBlank());// true
```

The first line prints false because the String is not empty; it has a blank space in it.
The second line prints true because this time, there are no characters in the String. The
final two lines print true because there are no characters other than whitespace present.

`Formatting Values`:- There are methods to format String values using formatting flags. Two of the methods take the format string as a parameter, and the other uses an instance for that value. One method takes a Locale
The method parameters are used to construct a formatted String in a single method call,rather than via a lot of format and concatenation operations. They return a reference to the instance they are called on so that operations can be chained together. The method signatures are as follows:

```java
public static String format(String format, Object args...)
public static String format(Locale loc, String format, Object args...)
public String formatted(Object args...)
```

The following code shows how to use these methods:

```java
var name = "Kate";
var orderId = 5;

// All print: Hello Kate, order 5 is ready
System.out.println("Hello "+name+", order "+orderId+" is ready");
System.out.println(String.format("Hello %s, order %d is ready",name, orderId));
System.out.println("Hello %s, order %d is ready".formatted(name, orderId));
```

In the format() and formatted() operations, the parameters are inserted and formatted via symbols in the order that they are provided in the vararg.
Common formatting symbols:-

1. %s - Applies to any type, commonly String values
2. %d - Applies to integer values like int and long
3. %f - Applies to floating-­point values like float and double
4. %n - Inserts a line break using the system-­dependent line separator

```java
var name = "James";
var score = 90.25;
var total = 100;

System.out.println("%s:%n Score: %f out of %d".formatted(name, score, total));
```

This prints the following:
James:
   Score: 90.250000 out of 100

Mixing data types may cause exceptions at runtime. For example, the following throws an exception because a floating-­point number is used when an integer value is expected:

```java
var str = "Food: %d tons".formatted(2.0); // IllegalFormatConversionException
```

Using format() with Flags:- Besides supporting symbols, Java also supports optional flags between the % and the symbol character. In the previous example, the floating-­point number was printed as 90.250000. By default, %f displays exactly six digits past the decimal. If you want to display only one digit after the decimal, you can use %.1f instead of %f. The format() method relies on rounding rather than truncating when shortening numbers. For example, 90.250000 will be displayed as 90.3 (not 90.2) when passed to format() with %.1f.
The format() method also supports two additional features. You can specify the total length of output by using a number before the decimal symbol. By default, the method will
fill the empty space with blank spaces. You can also fill the empty space with zeros by placing a single zero before the decimal symbol. The following examples use brackets, [], to show the start/end of the formatted value:

```java
var pi = 3.14159265359;
System.out.format("[%f]",pi);// [3.141593]
System.out.format("[%12.8f]",pi);// [   3.14159265]
System.out.format("[%012f]",pi);// [00003.141593]
System.out.format("[%12.2f]",pi);// [           3.14]
System.out.format("[%.3f]",pi);// [3.142]
```

*Method Chaining*:- It is common to call multiple methods as shown here:

```java
var start = "AniMaL  ";
var trimmed = start.trim();// "AniMaL"
var lowercase = trimmed.toLowerCase();// "animal"
var result = lowercase.replace('a', 'A');// "AnimAl"
System.out.println(result);
```

This is just a series of String methods. Each time one is called, the returned value is put in a new variable. There are four String values along the way, and AnimAl is output.
Here’s an example:

```java
String result = "AniMaL ".trim().toLowerCase().replace('a', 'A');
System.out.println(result);
```

**Overriding toString(), equals(Object), and hashCode()**:-

1. toString(): The toString() method is called when you try to print an object or concatenate the object with a String. It is commonly overridden with a version that
prints a unique description of the instance using its instance fields.
2. equals(Object): The equals(Object) method is used to compare objects, with the default implementation just using the == operator. You should override the equals(Object) method any time you want to conveniently compare elements for equality, especially if this requires checking numerous fields.
3. hashCode(): Any time you override equals(Object), you must override hashCode() to be consistent. This means that for any two objects, if a.equals(b) is true, then a.hashCode()==b.hashCode() must also be true. If they are not consistent, this could lead to invalid data and side effects in hash-­based collections such as HashMap and HashSet.

All of these methods provide a default implementation in Object, but if you want to make intelligent use of them, you should override them.

## Dates and Times

Java provides a number of APIs for working with dates and times.You need an import a statement to work with modern date and time classes.To use it,add this import to your program.

```java
import java.time.*//import time classes
```

`Creating Dates and Times`:When working with dates and times, the first thing to do is to decide how much information you need.

1. LocalDate:- Contains just a date—­no time and no time zone. A good example of LocalDate is your birthday this year. It is your birthday for a full day, regardless of what time it is.
2. LocalTime:- Contains just a time—­no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day.
3. LocalDateTime:- Contains both a date and time but no time zone. A good example of LocalDateTime is “the stroke of midnight on New Year’s Eve.” Midnight on January 2 isn’t nearly as special, making the date relatively unimportant, and clearly an hour after midnight isn’t as special either.
4. ZonedDateTime:- Contains a date, time, and time zone. A good example of ZonedDateTime is “a conference call at 9:00 a.m. EST.” If you live in California,you’ll have to get up really early since the call is at 6:00 a.m. local time!

Each of the four classes has a static method called now(), which gives the current date and time. Your output is going to depend on the date/time when you run it and where you live.

```java
System.out.println(LocalDate.now());
System.out.println(LocalTime.now());
System.out.println(LocalDateTime.now());
System.out.println(ZonedDateTime.now());
```

`Instants`:-The Instant class represents a specific moment in time in the GMT time zone.The Instant gets rid of the time zone and turns it into an Instant of
time in GMT.You cannot convert a LocalDateTime to an Instant. Remember that an Instant is a point in time. A LocalDateTime does not contain a time zone, and it is therefore not universally recognized around the world as the same moment in time.

Suppose that you want to run a timer:

```java
var now = Instant.now();
// do something time consuming
var later = Instant.now();
var duration = Duration.between(now, later);
System.out.println(duration.toMillis()); // Returns number milliseconds
```

## Maths APIs

Java comes with powerful Math class with many methods.Defined in java.lang package,not imported it is there explicitly.

`Finding the Minimum and Maximum`:- The min() and max() methods compare two values and return one of them.
The method signatures for min() are as follows:

```java
public static double min(double a, double b)
public static float min(float a, float b)
public static int min(int a, int b)
public static long min(long a, long b)
```

There are four overloaded methods, so you always have an API available with the same type. Each method returns whichever of a or b is smaller. The max() method works the
same way, except it returns the larger value.

The following shows how to use these methods:

```java
int first = Math.max(3, 7);// 7
int second = Math.min(7, -­9);// -­9
```

`Rounding Numbers`:- The round() method gets rid of the decimal portion of the value, choosing the next higher number if appropriate. If the fractional part is .5 or higher, we round up.
The method signatures for round() are as follows:

```java
public static long round(double num)
public static int round(float num)
```

There are two overloaded methods to ensure that there is enough room to store a rounded double if needed. The following shows how to use this method:

```java
long low = Math.round(123.45);// 123
long high = Math.round(123.50);// 124
int fromFloat = Math.round(123.45f); // 123
```

`Determining the Ceiling and Floor`:- The ceil() method takes a double value. If it is a whole number, it returns the same value. If it has any fractional value, it rounds up to the next whole number. By contrast, the floor() method discards any values after the decimal.
The method signatures are as follows:

```java
public static double ceil(double num)
public static double floor(double num)
```

The following shows how to use these methods:

```java
double c = Math.ceil(3.14); // 4.0
double f = Math.floor(3.14); // 3.0
```

`Calculating Exponents`:- The pow() method handles exponents.
The method signature is as follows:

```java
public static double pow(double number, double exponent)
```

The following shows how to use this method:

```java
double squared = Math.pow(5, 2); // 25.0
```

Notice that the result is 25.0 rather than 25 since it is a double.

`Generating Random Numbers`:- The random() method returns a value greater than or equal to 0 and less than 1.
The method signature is as follows:

```java
public static double random()
```

The following shows how to use this method:

```java
double num = Math.random();
int result = (int) Math.round(Math.random() * 100)// result is random e.g 66
int result = (int) Math.random() * 100;// result = 0
int result = (int) (Math.random() * 100)// result is random e.g 67
```

Since it is a random number, we can’t know the result in advance. However, we can rule out certain numbers. For example, it can’t be negative because that’s less than 0. It can’t be 1.0 because that’s not less than 1.

## Arrays

Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.An array is a collection of a fixed number of elements, wherein the elements are of same data types.

- Properties
   1. Stores data of specified type.
   2. Elements are located in contiguous memory.
   3. Each elements has unique index.
   4. Size of array is defined.

- Types of Arrays

1. One Dimensional: An array with a bunch of values having been declared with single index.i.e a[i]->i btwn 0 and N.
2. Multi Dimensional- Two dimensional, Three dimensional..N dimensional: 2D array with bunch of values declared with double index.i.e `a[i(Row)][j(Column)]`->i and j btwn 0 and N.

- `Creating Array`

We can:

- Declare: Create reference to Array.
- Instantiate: Creates an array
- Initialization: Assigns value to cells in array.

- `Declaring(O(1))`

Syntax:

dataType arrayName[];

To declare an array, define the variable type with square brackets:

```Java
String[] cars;
```

- `Insatiate.(O(1))`

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

- `Initialize`

- When array is initialised, Java automatically initialises it's components to their default values.e.g numeric are initialised to 0.

- `Insertion`

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

- `Accessing Array Components`:- The general format to access an array is:

arrayName[indexExp]

```Java
myNum[1];
```

The [] operator is called **array subscripting operator**

```java
import java.util.Arrays;

public class Array1 {

 public static void main (String[] args) 
 {   
 // declares an Array of integers.
 int[] arr;
  
 // allocating memory for 5 integers.(Insatiate)
 arr = new int[5];
  
 // initialize the elements of the array
 arr[0] = 10;
 arr[1] = 20;
 arr[2] = 30;
 arr[3] = 40;
 arr[4] = 50;
  
 // accessing element at a position

 System.out.println(arr[1]);
 
 // accessing the elements of the specified array
 for (int i = 0; i < arr.length; i++)
  System.out.println("index " + i + 
         " : "+ arr[i]);   
 
 // Print all the array elements using for-each
 System.out.println("Print using foreach loop");
    for (int element: arr)
        System.out.println(element);

 String[] cars= {"Volvo", "Mercedes"};

 // Accessing arrays using Array class
 System.out.println(Arrays.toString(cars));

 
    }

 
}
```

- `Sorting`:- Java makes it easy to sort an array by providing a sort method—­or rather, a bunch of sort methods. Just like StringBuilder allowed you to pass almost anything to append(), you can pass almost any array to Arrays.sort().
Arrays requires an import. To use it, you must have either of the following two statements in your class:

```java
import java.util.*;// import whole package including Arrays
import java.util.Arrays;// import just Arrays
```

There is one exception,You can write java.util.Arrays every time it is used in the class instead of specifying it as an import.
Remember that if you are shown a code snippet, you can assume the necessary imports are there. This simple example sorts three numbers:

```java
int[] numbers = { 6, 9, 1 };
Arrays.sort(numbers);
for (int i = 0; i < numbers.length; i++)
  System.out.print(numbers[i] + " ");
```

- Just printing the array variable directly would give the annoying hash of `[I@2bd9c3e7`. Alternatively, we could have printed Arrays.toString(numbers) instead of using the loop. That would have output [1, 6, 9].

```java
String[] strings = { "10", "9", "100" };
Arrays.sort(strings);
for (String s : strings)
  System.out.print(s + " ");
```

- `Searching`:- Java also provides a convenient way to search, but only if the array is already sorted.Rules for binary search.
  1. Target element found in sorted array - Index of match
  2. Target element not found in sorted array - Negative value showing one smaller than the negative of the index, where a match needs to be inserted to preserve sorted order
  3. Unsorted array - A surprise; this result is undefined

```java
int[] numbers = {2,4,6,8};
System.out.println(Arrays.binarySearch(numbers, 2)); // 0
System.out.println(Arrays.binarySearch(numbers, 4)); // 1
System.out.println(Arrays.binarySearch(numbers, 1)); // -­
System.out.println(Arrays.binarySearch(numbers, 3)); // -­
System.out.println(Arrays.binarySearch(numbers, 9)); // -­
```

- `Comparing`:- Java also provides methods to compare two arrays to determine which is “smaller.” First we cover the compare() method, and then we go on to mismatch(). These methods are overloaded to take a variety of parameters.

- Using compare():- There are a bunch of rules you need to know before calling compare().
  1. A negative number means the first array is smaller than the second.
  2. A zero means the arrays are equal.
  3. A positive number means the first array is larger than the second.

```java
System.out.println(Arrays.compare(new int[] {1}, new int[] {2}));
```

This code prints a negative number. It should be pretty intuitive that 1 is smaller than 2,
making the first array smaller.
Now that you know how to compare a single value, let’s look at how to compare arrays
of different lengths:
■■
■■
■■
If both arrays are the same length and have the same values in each spot in the same
order, return zero.
If all the elements are the same but the second array has extra elements at the end,
return a negative number.
If all the elements are the same, but the first array has extra elements at the end, return a
positive number.
■■If the first element that differs is smaller in the first array, return a negative number.
■■If the first element that differs is larger in the first array, return a positive number.
Finally, what does smaller mean? Here are some more rules that apply here and to
compareTo(), which you see in Chapter 8, “Lambdas and Functional Interfaces”:
■■null is smaller than any other value.
■■For numbers, normal numeric order applies.
■■For strings, one is smaller if it is a prefix of another.
■■For strings/characters, numbers are smaller than letters.
■■For strings/characters, uppercase is smaller than lowercase.

Using mismatch()
Now that you are familiar with compare(), it is time to learn about mismatch(). If the
arrays are equal, mismatch() returns -­1. Otherwise, it returns the first index where they
differ. Can you figure out what these print?
System.out.println(Arrays.mismatch(new int[] {1}, new int[] {1}));
System.out.println(Arrays.mismatch(new String[] {"a"},
new String[] {"A"}));
System.out.println(Arrays.mismatch(new int[] {1, 2}, new int[] {1}));
In the first example, the arrays are the same, so the result is -­1. In the second example,
the entries at element 0 are not equal, so the result is 0. In the third example, the entries at
element 0 are equal, so we keep looking. The element at index 1 is not equal. Or, more spe-
cifically, one array has an element at index 1, and the other does not. Therefore, the result is 1.
To make sure you understand the compare() and mismatch() methods, study
Table 4.5. If you don’t understand why all of the values are there, please go back and study
this section again.

Using Methods with Varargs
When you’re creating an array yourself, it looks like what we’ve seen thus far. When one
is passed to your method, there is another way it can look. Here are three examples with a
main() method:
public static void main(String[] args)
public static void main(String args[])
public static void main(String... args) // varargs

- **Working with Multidimensional Arrays**:-Arrays are objects, and of course, array components can be objects and it can hold other arrays

- `Creating a Multidimensional Array`:- Multiple array separators are all it takes to declare arrays with multiple dimensions. You can locate them with the type or variable name in the declaration, just as before:

```java
int[][] vars1;// 2D array
int vars2 [][];// 2D array
int[] vars3[];// 2D array
int[] vars4 [], space [][]; // a 2D AND a 3D array
```

You can specify the size of your multidimensional array in the declaration if you like:

```java
String [][] rectangle = new String[3][2];
```

Result of this statement is an array rectangle with three elements, each of which refers to an array of two elements. You can think of the addressable range as `[0][0]`through `[2][1]`, but don’t think of it as a structure of addresses like [0,0] or [2,1].

Using a Multidimensional Array
The most common operation on a multidimensional array is to loop through it. This
example prints out a 2D array:
var twoD = new int[3][2];
for(int i = 0; i < twoD.length; i++) {
for(int j = 0; j < twoD[i].length; j++)
System.out.print(twoD[i][j] + " "); // print element
System.out.println();
// time for a new row
}
We have two loops here. The first uses index i and goes through the first subarray for twoD.
The second uses a different loop variable, j. It is important that these be different variable names
so the loops don’t get mixed up. The inner loop looks at how many elements are in the second-­
level array. The inner loop prints the element and leaves a space for readability. When the inner
loop completes, the outer loop goes to a new line and repeats the process for the next element.
This entire exercise would be easier to read with the enhanced for loop.
for(int[] inner : twoD) {
for(int num : inner)
System.out.print(num + " ");
System.out.println();
}