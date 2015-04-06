import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


//moje da se napravi newIndex=(oldIndex+step)%size;
public class RotateCollection {

    public static <T> Collection<T> collectoinRotate(Collection<T> collection, int rotateStep){
        List<T> list = new LinkedList<T>();
        list.addAll(collection);
        collection.clear();
        if(rotateStep>0){
            while(rotateStep>0){
                rotateStep--;
                T item = list.remove(list.size()-1);
                list.add(0, item);
            }
        }else{
            while(rotateStep<0){
                rotateStep++;
                T item = list.remove(0);
                list.add(item);
            }
        }
        return list;
    }
    
    public static <T> Collection<T> collectoinRotate(Collection<T> collection){
        List<T> list = new LinkedList<T>();
        list.addAll(collection);

        T item = list.remove(list.size()-1);
        list.add(0, item);
                
        return list;
    }

    
    public static void main(String[] args) {
        
        //List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)); 
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        for (Integer integer : collectoinRotate(list)) {
            System.out.print(integer + " ");
        }
 
    }

}
