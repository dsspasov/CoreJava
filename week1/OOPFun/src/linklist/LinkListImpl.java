package linklist;

public class LinkListImpl implements LinkList {
    private int size;
    private Node head;
    private Node tail;

    public void setHead(Node x) {
        head = x;
    }

    public void setTail(Node x) {
        tail = x;
    }

    public LinkListImpl() {
        size = 0;
        head = new Node();
        tail = new Node();
    }

    @Override
    public void addFirst(int element) {
        if (head.getRight() == null) {
            Node newNode = new Node(element, head, tail);
            head.setRight(newNode);
            tail.setLeft(newNode);
            size++;
        } else {
            Node temp = head.getRight();
            Node newNode = new Node(element, head, temp);
            head.setRight(newNode);
            temp.setLeft(newNode);
            size++;
        }
    }

    @Override
    public void addLast(int element) {
        if (tail.getLeft() == null) {
            Node newNode = new Node(element, head, tail);
            head.setRight(newNode);
            tail.setLeft(newNode);
            size++;
        } else {
            Node temp = tail.getLeft();
            Node newNode = new Node(element, temp, tail);
            tail.setLeft(newNode);
            temp.setRight(newNode);
            size++;
        }

    }

    @Override
    public void addAtIndex(int element, int index) {
        Node currentNode = head;
        while (!currentNode.getRight().equals(tail) && index > 1) {
            currentNode = currentNode.getRight();
            index--;
        }
        if (index == 1) {
            Node newNode = new Node(element, currentNode, currentNode.getRight());
            currentNode.getRight().setLeft(newNode);
            currentNode.setRight(newNode);
            size++;
        } else {
            System.out.println("there is no such index");
        }
    }

    @Override
    public int removeFirst() {
        int element = 0;
        if (!isEmpty()) {
            element = head.getRight().getElement();
            head.setRight(head.getRight().getRight());
            size--;
        } else {
            System.out.println("empty");
        }
        return element;
    }

    @Override
    public int removeLast() {
        int element = 0;
        if (tail.getLeft() != null) {
            element = tail.getLeft().getElement();
            tail.setLeft(tail.getLeft().getLeft());
            size--;
        } else {
            System.out.println("empty");
        }
        return element;
    }

    @Override
    public int removeAtIndex(int index) {
        int element = 0;
        Node currentNode = head.getRight();
        while (!currentNode.getRight().equals(tail) && index > 1) {
            currentNode = currentNode.getRight();
            index--;
        }
        if (index == 1) {
            element = currentNode.getElement();
            Node l = currentNode.getLeft();
            Node r = currentNode.getRight();
            l.setRight(r);
            r.setLeft(l);
            currentNode.setLeft(null);
            currentNode.setRight(null);
            size--;
        } else {
            System.out.println("there is no such index");
        }
        return element;
    }

    @Override
    public int getFirst() {
        return head.getRight().getElement();
    }

    @Override
    public int get(int index) {
        int element = 0;
        Node currentNode = head.getRight();
        while (!currentNode.getRight().equals(tail) && index > 1) {
            currentNode = currentNode.getRight();
            index--;
        }
        if (index == 1) {
            element = currentNode.getElement();
        } else {
            System.out.println("there is no such index");
        }
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
