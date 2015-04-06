import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class OnOffCollection<T> {

    private Collection<T> collection;

    OnOffCollection(Collection<T> elements) {
        this.collection = elements;
    }

    public boolean add(T e) {
        if (collection.contains(e)) {
            collection.remove(e);
            return true;
        } else {
            collection.add(e);
            return false;
        }
    }
    
    public String toString(){
        return collection.toString();
        
    }
    
    public static void main(String[] args) {
        List<Integer> l =new ArrayList<Integer>();
        OnOffCollection<Integer> coll = new OnOffCollection<Integer>(l);
        System.out.println(coll.add(null));
        System.out.println(coll.add(2));
        System.out.println(coll.add(3));
        System.out.println(coll.add(null));
        System.out.println(coll.toString());
    }
}
