###TDDIntro###


###JUnit Hello world###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/TDDIntro/src/junitHelloWorld)
Implement a method 'getNumberOfDigits(int)' which just counts the number of digits.

1) Write the signature of the method  
2) Write the test, make sure it fails beautifully. Think of some edge cases.  
 3) Implement the method  
4) Pass your own test! Woohoo!  


###Implement a join method### 
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/TDDIntro/src/joinMethod)

Java does not have a String join method. Apache StringUtils does have, but, well, that's not an excuse.

Make a method that joins strings, with a **glue** given from the caller of your method.

Can you think of a way for it to work with every object, not just string? Even primitives?

//Glue is the first argument => " "
`stichMeUp(" ", "Днес", "видях", 5, "ходещи", "медузи") => "Днес видях 5 ходещи медузи"` 

1) Think of a good name for this method
2) Make a test class
3) Make several test cases, see that your tests fail mightily : )
4) Implement! 


###Reduce file path! In Java. In a test-driven way. ###
[Source](https://github.com/dsspasov/CoreJava/tree/master/week1/TDDIntro/src/filePath)

See Problem 27 @ https://github.com/HackBulgaria/Programming101/blob/master/week0/simple_problems2.md