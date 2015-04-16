package immutablelist;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang3.SerializationUtils;

public class ImmutableList<E extends Serializable> extends ArrayList<E>{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    ImmutableList(Collection<? extends E> collection){
        super.addAll(collection);
    }
    
    @Override
    public boolean add(E arg0) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @Override
    public void add(int arg0, E arg1) {
        throw new UnsupportedOperationException("You can't modify this list");
        
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean addAll(Collection arg0) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean addAll(int arg0, Collection arg1) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("You can't modify this list");
        
    }

    @Override
    public boolean contains(Object arg0) {
        return super.contains(arg0);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean containsAll(Collection arg0) {
        return super.containsAll(arg0);
    }

    @Override
    public E get(int arg0) {
        return SerializationUtils.clone(super.get(arg0));
    }

    @Override
    public int indexOf(Object arg0) {
        
        return super.indexOf(arg0);
    }

    @Override
    public boolean isEmpty() {
       return super.isEmpty();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator iterator() {
        return super.iterator();
    }

    @Override
    public int lastIndexOf(Object arg0) {
        return super.lastIndexOf(arg0);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public ListIterator listIterator() {
       return super.listIterator();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public ListIterator listIterator(int arg0) {
        return super.listIterator(arg0);
    }

    @Override
    public boolean remove(Object arg0) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @Override
    public E remove(int arg0) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean removeAll(Collection arg0) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean retainAll(Collection arg0) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @Override
    public E set(int arg0, E arg1) {
        throw new UnsupportedOperationException("You can't modify this list");
    }

    @Override
    public int size() {
        return super.size();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<E> subList(int arg0, int arg1) {
            List<E> list = new ArrayList<E>();
            for(int i = arg0; i<arg1; i++){
                list.add(SerializationUtils.clone(super.get(i)));
            }
            List<E> result = new ImmutableList(list);
            return result;
    }

    @Override
    public E[] toArray() {
            @SuppressWarnings("unchecked")
            E[] array = (E[]) new Object[super.size()];
            
            for(int i = 0; i<super.size(); i++){
                array[i] = SerializationUtils.clone(super.get(i));
            }
            return array;
    
    }

    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray(Object[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @SafeVarargs
    public static <T> List<T> asList(T... arguments){
        return Arrays.asList(arguments);
    }

}
