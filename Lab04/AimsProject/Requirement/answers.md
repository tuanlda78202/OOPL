### 1. Is JAVA a Pass by Value or a Pass by Reference programming language

`Answer`: JAVA always pass by value programming language. In Java, method parameter values are copied to another variable and the copied object is passed to the method.

### 2. After the call of `swap(jungleDVD, cinderellaDVD)` why does the title of these two objects still remain?

`Answer`: Because when we changed value of 2 objects, we just copied "jungleDVD" and "cinderellaDVD" reference locations, so no change in the values of 2 object.

### 3. After the call of `changeTitle(jungleDVD, cinderellaDVD.getTitle())` why is the title of the JungleDVD changed?
`Answer`: Because when we call method same as called Object at the reference location.


### 4. Write `swap()` method that can correctly swap the two objects
`Answer`:
```java
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String tempt = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(tempt);
	}
```

### 5. What should be the return type of this method?

`Answer`: It will return a string.