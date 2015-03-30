package stack;

import java.util.Arrays;

//this class won't have any duplicate elements
public class StackImplInvariant extends StackImpl {

    StackImplInvariant() {
        super();
    }

    @Override
    public void push(Object t) {
        if (super.index < super.elements.length) {
            if (super.index>0 && isElementDuplicate(t)) {
                System.out.println("This element is already in the stack!");
                return;
            }
            super.elements[index++] = t;
        } else {
            int newSize = SIZE * 2;
            elements = Arrays.copyOf(elements, newSize);
            elements[index++] = t;
        }

    }

    private boolean isElementDuplicate(Object elem) {
        int i = 0;       
        while (i <= super.length()-1) {
            if (super.elements[i].equals(elem)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
