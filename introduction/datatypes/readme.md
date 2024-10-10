# Data Types

1. Primitives - for storing simple values.
2. Refernce - for storing complex objects

## Primitive Types
- byte(1 Byte)
- short(2 Bytes)
- int(4 Bytes)
- long(8 Bytes)
- float(4 Bytes)
- double(8 Bytes)
- char(2 Bytes)
- boolean

```Java
byte age =21;
int viewsCount=10_000_000;
long views = 100_000_000_000L;
double price=10.99;
float discount = 10.99F;
char letter ='A';
boolean isEligable = false;
```

## Reference Types

```Java
Date date = new Date();
date.getTime();
```

- **new** keyword allocates memory.

- Reference type are copied by their efernce while primitive are copied by their value hence independent.