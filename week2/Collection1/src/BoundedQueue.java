import java.util.ArrayList;
import java.util.List;
//trqbva da se implement-ne Queue

public class BoundedQueue<T> {
    
    private static final int firstIndex = 0;
    private int size;
    private List<T> list;
    
    public BoundedQueue(int size){
        this.size = size;
        this.list = new ArrayList<T>();
    }
    
    public void offer(T element){
        if(list.size()<size){
            this.list.add(element);
        }else{
            this.list.add(element);
            this.list.remove(firstIndex);
        }
    }
    
    public String toString(){
        return list.toString();
    }
    
    public static void main(String[] args){
        
        BoundedQueue<Integer> x =new BoundedQueue<Integer>(3);
        x.offer(1);
        x.offer(2);
        x.offer(3);
        x.offer(4);
        x.offer(5);
        
        System.out.println(x.toString());
    }
    
}
    

