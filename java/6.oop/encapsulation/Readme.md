# Encapsulation

It is a mechanism of binding member data(variabes) and member function(methods) that operate on the daa together into a single unit i.e. class.Encapsulation is an striking feature of OOPs that provides data security.

The main advantage of encapsulation is that data is hidden and protected from access by outside non-member methods of a class. In other words, only member
functions defined in a class will have access to the data.

In encapsulation, data(variables) are declared as private and methods are declared as public.

```java
public class Person{
    private int id;
    private String name;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void getName(){
        return name;;
    }
}
```
