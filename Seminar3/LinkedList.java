import java.rmi.NoSuchObjectException;

public class LinkedList {
    private Node root;
    private int size;
    public void add(int value){
        if(root == null){
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while(currentNode.next != null)
        currentNode = currentNode.next;
        currentNode.next = new Node(value);
        size++;
    }
    public void print(){
        Node currentNode = root;
        while(currentNode != null){
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public int size(){
        return size;
    }
    public void reversedList(){
        if(root != null && root.next != null){
            Node temp = root;
            reversedList(root.next, root);
            temp.next = null;
        }
    }
    private void reversedList(Node currentNode, Node previousNode){
        if(currentNode.next == null){
            root = currentNode;
        } else {
            reversedList(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }
    private class Node{
        int value;
        Node next;
        public Node(int _value) {this.value = _value;}
    }
}