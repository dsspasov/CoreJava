package stack;

import java.util.Arrays;

public class StackImpl implements Stack {

    protected static final int SIZE = 50;
    protected Object[] elements;
    protected int index = 0;

    public StackImpl() {
        this.elements = new Object[SIZE];
    }

    @Override
    public void push(Object t) {
        if (index < this.elements.length) {
            this.elements[index++] = t;
        } else {
            int newSize = SIZE * 2;
            elements = Arrays.copyOf(elements, newSize);
            elements[index++] = t;
        }

    }

    @Override
    public Object pop() {
        if (index >= 0) {
            return this.elements[--index];
        }
        return 0;

    }

    @Override
    public int length() {
        return this.index;
    }

    @Override
    public void clear() {
        this.index = 0;
    }

    @Override
    public boolean isEmpty() {
        return (this.index == 0);
    }

    @Override
    public Object peek() {
        if (index == 0) {
            return null;
        } else {
            return this.elements[index - 1];
        }
    }
}
