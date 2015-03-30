package linklist;

public class Node {
    private int element;
    private Node left;
    private Node right;
    
    public Node(){
        this(0, null, null);
    }
    
    public Node(int element, Node left, Node right){
        this.element = element;
        this.left = left;
        this.right = right;
    }
    
    public void setElement(int element) {
        this.element = element;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getElement(){
        return element;
    }
    
    public Node getLeft(){
        return left;
    }
    
    public Node getRight(){
        return right;
    }
    
}
