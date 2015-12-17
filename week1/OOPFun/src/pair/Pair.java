package pair;

public final class Pair {
    private final Object obj1;
    private final Object obj2;
    
    Pair(Object first, Object second){
        super();
        this.obj1 = first;
        this.obj2 = second;
    }
    
    public Object getObj1() {
        return obj1;
    }

    public Object getObj2() {
        return obj2;
    }
    
    @Override
    public String toString(){
        return obj1.toString() + " - " + obj2.toString();
    }

    public boolean equals(Pair one, Pair two){
        return (one.obj1.equals(two.obj1)&& one.obj2.equals(two.obj2));
    }

}
