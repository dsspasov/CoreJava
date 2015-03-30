package stack;

public class Main {

    public static void main(String[] args){
        /*StackImpl stack = new StackImpl();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        
        System.out.println(stack.pop());
        stack.clear();
        System.out.println(stack.isEmpty());
        System.out.println(stack.length());
        System.out.println(stack.peek());
        */
        
        
        StackImplInvariant stack2 = new StackImplInvariant();
        stack2.push(5);
        stack2.push(7);
        stack2.push(3);
        stack2.push(7);
       
        stack2.push(5);
        
        
        System.out.println(stack2.pop());
        System.out.println(stack2.peek());
        System.out.println(stack2.length());
        
        
    }
}
