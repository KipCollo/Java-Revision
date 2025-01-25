# JSON

1. Introduction
2. Syntax
3. XML vs JSON
4. Json Serializion and Json Deserialization
5. JACKSON
6. JSON Annotations

## Introduction

JSON stands for JAvascript Object Notation.it is derived from Javascript but not dependending on javascript.JSON data is lightweight and human readable text.
It has file extension of .json and its Media Type is "application/json"

### Why Learn JSON

Json is used in communication btwn application,since Json is not specific to any technologies,its generic for all technologies.

## JSON Syntax and Data Types

JSON Data is in the form of key value pair.
JSON syntax is: {key1:value1,key2:value2..} where key is String and value can be String,number,Boolean,Object,null,Array

There are 6 JSON Data types:

1. Boolean
2. String
3. Number
4. Object
5. Null
6. Arrays -Enclosed with a square brackets

eg

```json
{"orderId":123,"name":"book","isDelivered":true,"desc":null}
{
    "orders":[
        {"orderId":234,
        "name":"laptop",
        "isDelivered":true
        },
        {"orderId":908,
        "name":"watch",
        "isDelivered":false
        }
    ]
}
```

## XML vs JSON

- XML is heavy weight while JSON is lightweight

```xml
<orders>
  <order>
    <orderId>567</orderId>
    <name>Phone</name>
    <isDelivered>false</isDelivered>
  </order>
</orders>
```

- JSON Data is less in size, so data transfer in network is of high speed than XML

## Json Serializion and Json Deserialization

JSON Serialization is the process of converting Java Object into JSON and Deserialization is converting from JSON into Java Object.For every request consumer: JSON Serialization happens and for every response provider end.For every response consumer and request provider deserilization happens

Jackson library takes care json serilization and deserialization in java

## JACKSON

Jackson is used to perform JSON Serialization and Deserialization.We add Jackson dependency(jackson-databind) to our project.

It comes with other dependencies ie:

- Jackson-core
- Jackson-Annotations

Jackson has provided utility classes to perform Json Serialization and Deserialization.
The class is called ObjectMapper with the methods:

- writeValue()- Java Object to Json
- readValue()- JSON to Java Object

Eg

```java
public class Order{
    private int orderId;
    private String name;
    private boolean delivered;

    //Setters and Getters
}
```

JSON Serialization

```java
Order order1 =new Order();
order1.setOrderId(1234);
order1.setName("Monitor");
order1.setDelivered(true);

ObjectMapper mapper =new ObjectMapper();
String json = mapper.writeValueAsString(order1)
```

NOTE: While doing serialization, Java Properties is converted to JSON Keys

## JSON Annotations
