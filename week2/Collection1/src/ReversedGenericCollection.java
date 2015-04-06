import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;


public class ReversedGenericCollection {

    static <T> void reverse (Collection<T> collection){
        Stack<T> stack = new Stack<T>();
        
        for(T item : collection){
            stack.push(item);
        }
        
        collection.clear();
        
        while(!stack.isEmpty()){
            collection.add(stack.pop());
        }
    }

    public static void main(String[] args){
        List<Integer> x = new ArrayList<Integer>();
        x.add(1);
        x.add(2);
        x.add(3);
        ReversedGenericCollection.reverse(x);
        
        System.out.println(x.toString());
    }
}

