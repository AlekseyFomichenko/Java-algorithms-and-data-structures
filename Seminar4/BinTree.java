/**
 * BinTree
 */
public class BinTree<T extends Comparable<T>> { // Красно-черное левостороннее дерево

    enum Color{RED, BLACK}
    
    private Node root;
    
    private class Node{
        int value;
        Node rightChild;
        Node leftChild;
        Color color;
        Node(){
            this.color = Color.RED;
        }
        Node(int _value){
            this.value = _value;
        }
    }

    private Node leftSwap(Node node){
        Node left = node.leftChild;
        Node between = node.leftChild.rightChild;
        left.rightChild = node;
        node.leftChild = between;
        left.color = node.color;
        node.color = Color.RED;
        return node;
    }

    private Node rightSwap(Node node){
        Node right = node.rightChild;
        Node between = right.leftChild;
        right.leftChild = node;
        node.rightChild = between;
        right.color = node.color;
        node.color = Color.RED;
        return node;
    }

    private void colorSwap(Node node){
        node.color = Color.RED;
        node.leftChild.color = Color.BLACK;
        node.rightChild.color = Color.BLACK;
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance = false;
        do{
            if(result.rightChild != null && result.rightChild.color == Color.RED &&
            (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if(result.leftChild != null && result.leftChild.color == Color.RED &&
            result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if(result.leftChild != null && result.leftChild.color == Color.RED &&
            result.rightChild != null && result.rightChild.color == Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        } while(needRebalance);
        return result;
    }

    private Node addNode(Node node, int value){
        if(node.value == value) {return null;}
        if(value < node.value){
            if(node.leftChild == null){
                node.leftChild = new Node(value);
                node.leftChild = rebalance(node.leftChild);
                return node.leftChild;
            }else{
                return addNode(node.leftChild, value);
            }
        }else{
            if(node.rightChild == null){
                node.rightChild = new Node(value);
                node.rightChild = rebalance(node.rightChild);
                return node.rightChild;
            }else{
                return addNode(node.rightChild, value);
            }
        }
    }

    public boolean contain(int value){
        Node currentNode = root;
        while(currentNode != null){
            if(currentNode.value == value) {return true;}
            if(value < currentNode.value) {currentNode = currentNode.leftChild;}
            else {currentNode = currentNode.rightChild;}
        }
        return false;
    }

    public boolean add(int value){
        if(root == null){
            root = new Node(value);
            root.color = Color.BLACK;
            root = rebalance(root);
            return true;
        }
        if(addNode(root, value) != null) {return true;}
        return false;
    }
}