# Hash Note

- for any data type X, if it uses at msot as many bits as an integer, its hash code can be taken by casting it to an integer
```java
Float.floatToIntBits(x);
```
- for any data type X that is larger than an int, only half of the hash would be created, meaning it will be more likely that a collision occurs
- 