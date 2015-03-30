package calculator;

import java.util.Stack;
import java.lang.Math;

public class ReversePolishNotation {
 
     public double ReversePolishNotation(String[] input){
        Stack<Double> result = new Stack<Double>();
        for(String token: input){
            if(token.matches("[-]?\\d+"))
                result.push(Double.valueOf(token));
            else{
                if(token.matches("\\+")){
                    result.push(result.pop()+result.pop());
                }
                else if(token.matches("-")){
                    result.push(-result.pop()+result.pop());
                }
                else if(token.matches("\\*")){
                    result.push(result.pop()*result.pop());
                }
                else if(token.matches("/")){
                    double denumerator = result.pop();
                    double numerator = result.pop();
                    result.push(numerator/denumerator);
                }
                else if(token.matches("sqrt")){
                    result.push(Math.sqrt(result.pop()));
                }
                else if(token.matches("pow")){
                    double exp = result.pop();
                    double base = result.pop();
                    result.push(Math.pow(base, exp));
                }
                else if(token.matches("log")){
                    double arg = result.pop();
                    double base = result.pop();
                    result.push(Math.log(arg)/Math.log(base));
                }
                else if(token.matches("sin")){
                    result.push(Math.sin(result.pop()));
                }
                else if(token.matches("-sin")){
                    result.push(-Math.sin(result.pop()));
                }
                else if(token.matches("cos")){
                    result.push(Math.cos(result.pop()));
                }
                else if(token.matches("tg")){
                    result.push(Math.tan(result.pop()));
                }
                else if(token.matches("cotg")){
                    result.push(1/Math.tan(result.pop()));
                }
                else if(token.matches("pi|PI")){
                    result.push(Math.PI);
                }
                else if(token.matches("e|E")){
                    result.push(Math.E);
                }
            }
        }
        if(result.size() > 1){
            //System.out.println("Error!Too many numbers");
            throw new IllegalArgumentException("Error!Too many numbers");
        }
        else {
            return result.pop();
        }
    }
}
