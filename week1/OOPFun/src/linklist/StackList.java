package linklist;

public class StackList implements Stack {
    protected LinkListImpl stack;

    public StackList() {
        stack = new LinkListImpl();
    }

    public static StackList CreateNoDuplicateStack() {
        return new StackList() {
            @Override
            public void push(int item) {
                if (isDuplicate(item)) {
                    System.out.println("this element is already in the stack");
                    return;
                } else {
                    stack.addFirst(item);
                }
            }

            private boolean isDuplicate(int element) {
                
                int length = stack.size();
                if (length == 0){
                    return false;
                }else{
                    int i = 1;
                    while (i < length+1 && !(stack.get(i) == element)) {
                        i++;
                    }
                    if (i == length+1) {
                        return false;
                    }
                    return true;
                }
            }

        };

    }

    @Override
    public void push(int item) {
        stack.addFirst(item);
    }

    @Override
    public int pop() {
        return stack.removeFirst();
    }

    @Override
    public int length() {
        return stack.size();
    }

    @Override
    public void clear() {
        stack.setHead(null);
        stack.setTail(null);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int peek() {
        return stack.getFirst();
    }

}
