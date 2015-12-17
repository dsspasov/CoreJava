###OOP fun!###

###1###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/cars)

Make a class Car. 
Make several(at least 4) subtypes of Car, representing the different brands of cars - Audi, BMW, Wolkswagen (of course!), etc. 

Later, for the Audi type you need to return its mileage, because all the German brand manufacturers require it - how you will do it?

###2###
[Source]()

Make a class `Time` to hold information about the current time and *the current date* .

Make an *easy-to-use* constructor (from client perspective), that would represent the time and date the client wants to hold in your class.

Implement the toString() method, returning the time and date in format : "hh:mm:ss dd.MM.YY". 

Check out String.format method

*Bonus*
Make a factory method `now()` for your class, returning the Time at the present moment :)

See http://en.wikipedia.org/wiki/Factory_method_pattern

###3###
[Source]()


Make a class `Pair`, representing a pair of *Objects* (later we will revisit this with Generics)

Create getter methods for the first and second member of the pair.
http://stackoverflow.com/questions/2036970/how-do-getters-and-setters-work

Implement the toString method, giving a meaningful representation of the class.
Override the equals method from Object => two pairs are equal if both their members are equal.

Make the class *immutable*.

###4###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/stack)

Create and implement a class `StackImpl`, representing a... well, stack. 

Think about all the required (public) operations needed, so that one can use a stack class. You know, stuff like actually pushing an element, popping an element, length, clear, isEmpty, stuff like that. Think about the return types of those operations (see task 5, you may get a hint about one). *Extract them all to an interface  `Stack`, which your class should implement*. 

###5###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/stack)

Create an implementation of your `Stack` interface, which has the added invariant:
-It does not allow an element to be duplicated. If there is an element 'a' in the stack, and some smart guy pushes 'a' again, his operation should fail, and the smart guy should have a way to know this.


###6###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/linklist)

Implement a (doubly-linked) list (using ints only). Just as before, extract all of its required public operations in an interface. Some of those operations are add, *remove*, size, get(int elementIndex), getHead (getFirst), getTail(getLast), etc. 
Think good and hard about your implementation, and whether you will need another class for a List Node.

###7###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/linklist)

Implement your own `Stack` with your own (doubly) `LinkedList` class : )

*Bonus* implement a unique stack just as before, but using your `LinkedList` and an *anonymous implementation*, combined with a factory method. 
See http://www.programmerinterview.com/index.php/java-questions/java-anonymous-class-example/

Return your anonymous implementation from a factory method!

###8###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/matrix)

Make a mutable class 'Matrix' represeting a NxM (Pixel[][]) matrix. `Pixel` is a POJO containing three float values - R, G, B. Think good about your constructors, your data. Your goal is to make this class as convenient as possible for the person using it.

Your class `Matrix` should have another cool thing about it => it would allow operations with every pixel.
In order for this to work, your class should declare a public method `operate(MatrixOperation op)`

Where `MatrixOperation` is an interface, containing a method 'Pixel withPixel(int x, int y, Pixel[][] matrix)'.
*Think - why are we getting x, y, and the matrix instead of just passing the pixel value?*

Implement the toString(), converting the whole matrix into a String in a way that it would be visible on the console.

The method should `operate(MatrixOperation op)`  should call the `withPixel` method for every x and y in the matrix and assign the result of `withPixel` to the matrix.

Now that you have this, implement:
- brightness reduce
- grayscale
- gaussian blur (optional)

###9###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/OOPFun/src/calculator)

Create a friendly interactive calculator in java

Supported operations: 
- addition  
- multiplication  
- division (this is not integer division! 2/3 = 0.666666667, not 0!)  
- brackets   
- Negative numbers.  

Multiplication and addition take precedence and have higher priority than addition.  
Priority list: () before * before / before + before -  

Your program should support a *variable* ammount of spaces in the expression.


*Bonus challenge objectives*
- Add 'power' support: 2^3 = 8, 3^2 = 9, etc. It has the same priority as multiplication!
- Add 'log' support
- Add 'sqrt' support
- Add 'sin' support
- Add 'cos' support
- Add 'tg' support
- Add 'cotg' support