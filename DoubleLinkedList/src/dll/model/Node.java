package dll.model;

public class Node {
    public int data;
    public Node rightNode;
    public Node leftNode;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        this.rightNode = null;
        this.leftNode = null;
    }


}
