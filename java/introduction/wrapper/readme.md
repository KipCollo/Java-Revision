# Wrapper class

If you want to store integer value, you store it in **int** data type.Java provides primitive data types that's why Java is 99.9% OOP.Primitive helps us improve the performance(saves data directly) but certain feature work only with objects i.e collection framework.

- int: Integer class
- char: Character class
- long: Long class
- boolean: Boolean class
- float: Float class

## Boxing
It is manual mrthod to convert primitive type data into non-primitive type.

```Java
int num=2;
Integer num1 =new integer(8);
```
## Unboxing
It is manual method to convert non-primitive data type to primitive types.
```Java
int num2=num1.intValue(); //unboxing
```

## AutoBoxing
AutoBoxing:It is automatic conversion of primitive type data into non-primitive data type.
```Java
int num3=5;
Integer num4=num3; //autoboxing
```
## AutoUnBoxing:
It is automatic conversion of non primitive type data into primitive data type.
```java
int num5=num4; //autounboxing
```
int num=7;

- how to store data as Object
```Java
Integer num1=new Integer(8); //this syntax is depreciated 
Integer num1=Integer.valueOf(8); //Now we use this syntax
Integer num1=8; //autoboxing 
int num2=num1.intValue();//unboxing 
int num3=num1; //autounboxing 
```
- convert string into int type using parseInt
```java
String str="12";
int num4=Integer.parseInt(str); 
```
- Convert number into String 
```Java
String str1=Integer.toString(23); //convert number into string
```
