# UUID

A class that represents an immutable universally unique identifier (UUID). A UUID represents a 128-bit value.

There exist different variants of these global identifiers. The methods of this class are for manipulating the Leach-Salz variant, although the constructors allow the creation of any variant of UUID (described below). 

 The variant field contains a value which identifies the layout of the UUID. The bit layout described above is valid only for a UUID with a variant value of 2, which indicates the Leach-Salz variant.

The version field holds a value that describes the type of this UUID. There are four different basic types of UUIDs: time-based, DCE security, name-based, and randomly generated UUIDs. These types have a version value of 1, 2, 3 and 4, respectively. 

Used for creating random files name,session id in web applications, transactions id

## constructor

```java
    public UUID(long mostSigBits,
                long leastSigBits)
```

Constructs a new UUID using the specified data. mostSigBits is used for the most significant 64 bits of the UUID and leastSigBits becomes the least significant 64 bits of the UUID.

Parameters:

* mostSigBits - The most significant bits of the UUID
* leastSigBits - The least significant bits of the UUID
