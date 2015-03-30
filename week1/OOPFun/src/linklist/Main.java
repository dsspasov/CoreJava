package linklist;

public class Main {
    public static void main(String[] args){
        /*LinkListImpl x = new LinkListImpl();
        x.addLast(6);
        x.addFirst(5);
        x.addFirst(4);
        x.addFirst(3);
        x.addFirst(2);
        x.addFirst(1);
        
        System.out.println(x.size());
        x.addAtIndex(8, 2);
        */
        //System.out.println(x.removeFirst());
        //System.out.println(x.removeFirst());
        //System.out.println(x.removeFirst());
        //System.out.println(x.removeFirst());
        
        //x.addAtIndex(8, 6);
        
        //System.out.println(x.removeAtIndex(1));
        
        //System.out.println(x.removeLast());
        //System.out.println(x.removeLast());
        //System.out.println(x.isEmpty());
        //System.out.println(x.removeFirst());
        //System.out.println(x.removeLast());
        //x.addLast(6);
        //System.out.println(x.removeLast());
        //System.out.println(x.size());
        
        
        StackList x = StackList.CreateNoDuplicateStack();
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(1);
        x.push(2);
        System.out.println(x.length());
    }
}
