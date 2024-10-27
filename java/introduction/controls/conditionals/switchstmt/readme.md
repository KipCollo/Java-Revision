# Switch

It is a multibranch stmnt that allows a variable to be tested for equality against a list of values.Each values is called a case, and the variable being switched on is checked for each switch case.
it can e used with byte, char,short and int primitive data types.Can also be used with enumerated types, String class and few wrapper classes.

```Java
int value;// values can be strings,floats...

 switch(value){
    case value1:
     //statements
     break;

    case value2:
     //statements
     break;

    case value3:
     //statements
     break;

    default:
     // statement
 }
 ```

 - break statements is necessary coz without them, statements in switch block fall through: all statements after matching case label are executed in sequence, regardless of the expression of subsequent case labels, until a break statement is encountered.

 ## New Switch statement

 ```java

int value;// values can be strings,floats...

 switch(value){
    case value1 ->
     //statements

    case value2 ->
     //statements

    case value3->
     //statements

    default->
     // statement
 }
 ```
 
  ```java

int value=null;// values can be strings,floats...

 switch(value){
    case value1 -> value =1
    case value2 -> value =2
    case value3-> value=3
    default->value =4

 }

  system.out.println(value);
 ```

```java

int value=null;// values can be strings,floats...

 switch(value){
    case value1: yield value =1
    case value2: yield value =2
    case value3: yield value=3
    default: yield value =4

 }

  system.out.println(value);
 ```