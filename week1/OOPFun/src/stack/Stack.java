package stack;

public interface Stack {

    void push(Object t);

    Object pop();

    int length();

    void clear();

    boolean isEmpty();

    Object peek();

}
