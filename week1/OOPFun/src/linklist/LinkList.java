package linklist;

public interface LinkList {

    void addFirst(int element);
    
    void addLast(int element);
    
    void addAtIndex(int element, int index);
    
    int removeFirst();
    
    int removeLast();
    
    int removeAtIndex(int index);
    
    int getFirst();
    
    int get(int index);
    
    int size();
    
    boolean isEmpty();
    
    
    
}
