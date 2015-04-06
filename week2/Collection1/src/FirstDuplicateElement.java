import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;


public class FirstDuplicateElement {
    public static <T> T getFirstDuplicateElement(Collection<T> collection){
        List<T> list = new LinkedList<T>();
        list.addAll(collection);
        
        ListIterator<T> listite = list.listIterator();
        T item = null;
        while(listite.hasNext()){
            item = listite.next();
            listite.remove();
            if(!list.contains(item)){
                return item;
            }
        
        }
        
       return item;
    }
    
    @SafeVarargs
    public static <T> Set<T> getDuplicateElements(Set<T> ... sets){
        if(sets.length == 1){
            return sets[0];
        } else{
            Set<T> intersectedSet = sets[0];
            for(int i=1; i<sets.length; i++){
                intersectedSet.retainAll(sets[i]);
            }
            return intersectedSet;
        }        
    }

   /* 
    public static int pow(int base, int pow){
        if(pow == 1)
            return base;
        return sum(base, pow(base, pow-1));
        
    }
    
    public static int sum(int number, int times){
        int sum = 0;
        for(int i = 1; i<=times; i++)
            sum+=number;
        return sum;
    }
    
    */
    public static void main(String[] args){ 
        //HashMap x = new HashMap();
        
        Collection<Integer> ints = Arrays.asList(1,2,3,4,5,5,4,3,1);
        System.out.println(getFirstDuplicateElement(ints));
        
        Set<Integer> A = new HashSet<Integer>();
        A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
        Set<Integer> B = new HashSet<Integer>();
        B.add(4);B.add(5);B.add(6);
        Set<Integer> C = new HashSet<Integer>();
        C.add(5);C.add(6);C.add(7);C.add(8);
        
        System.out.println(getDuplicateElements(A,B,C));

        
        //System.out.println(pow(3,3));
        
    }

}
