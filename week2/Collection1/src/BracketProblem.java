import java.util.Stack;

public class BracketProblem {

    private String expression;

    BracketProblem(String str) {
        this.expression = str;
    }

    public boolean isCorrect(){
        int length = this.expression.length();
        if((this.expression.charAt(0) != '(') ||(this.expression.charAt(length-1)!= ')')){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while(i<length){
            if(this.expression.charAt(i) == '('){
                stack.push('(');
            }
            if(this.expression.charAt(i) == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args){
        BracketProblem x = new BracketProblem("())()()");
        System.out.println(x.isCorrect());
    }
}
