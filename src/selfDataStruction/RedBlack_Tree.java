package selfDataStruction;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class RedBlack_Tree {
    public Node rootNode;
    public static final Boolean TREE_COLOR_RED = true;
    public static final Boolean TREE_COLOR_BLACK = false;
    static final Node leafNode = new Node(TREE_COLOR_BLACK, 0, 0, null, null, null);

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    static class Node {
        private Boolean color;
        private int hash;
        private Object value;
        private Node leftNode;
        private Node rightNode;
        private Node parentNode;

        public Node() {
        }

        public Node(Boolean color, int hash, Object value, Node leftNode, Node rightNode, Node parentNode) {
            this.color = color;
            this.hash = hash;
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.parentNode = parentNode;
        }
    }

    public RedBlack_Tree() {
        this.size = 0;
    }

    public void add(int hash, Object value) {
        Node node = new Node();
        node.hash = hash;
        node.value = value;
        node.color = TREE_COLOR_RED;

        if (this.rootNode == null) {
            this.rootNode = node;
            node.color = TREE_COLOR_BLACK;
        } else {
            Node tem = this.rootNode;
            Boolean sizeChange = true;
            for (; tem != null; ) {
                if (node.hash < tem.hash) {
                    if (tem.leftNode == null) {
                        node.parentNode = tem;
                        tem.leftNode = node;
                        break;
                    }
                    tem = tem.leftNode;
                } else if (node.hash > tem.hash) {
                    if (tem.rightNode == null) {
                        node.parentNode = tem;
                        tem.rightNode = node;
                        break;
                    }
                    tem = tem.rightNode;
                } else {
                    tem.hash = node.hash;
                    sizeChange = false;
                    break;
                }
            }
            if (sizeChange)
                revise(node);
        }
        size++;
    }

    public void get(int hashKey) {

    }

    public void remove() {

    }

    public void set() {

    }

    public void count() {

    }

    public void revise(Node node) {
        Node parentNode = node.parentNode;
        if (this.rootNode == node) {
            node.color = TREE_COLOR_BLACK;
            return;
        } else if (parentNode.color == TREE_COLOR_BLACK) {
            return;
        } else {
            Node grParentNode = parentNode.parentNode;
            if (getLeftNode(grParentNode).color != getRightNode(grParentNode).color) {
                if (parentNode == grParentNode.leftNode) {
                    if (node == parentNode.leftNode) {
                        revertFunc(grParentNode, parentNode);
                        grParentNode.leftNode = parentNode.rightNode;
                        parentNode.rightNode = grParentNode;
                        node.color = TREE_COLOR_RED;
                    } else {
                        revertFunc(grParentNode, node);
                        parentNode.parentNode = node;
                        parentNode.rightNode = node.leftNode;
                        grParentNode.leftNode = node.rightNode;
                        node.leftNode = parentNode;
                        node.rightNode = grParentNode;
                        parentNode.color = TREE_COLOR_RED;
                    }
                } else {
                    if (node == parentNode.leftNode) {
                        revertFunc(grParentNode,node);
                        grParentNode.rightNode = node.leftNode;
                        parentNode.leftNode = node.rightNode;
                        node.leftNode = grParentNode;
                        node.rightNode = parentNode;
                        parentNode.parentNode = node;
                        parentNode.color = TREE_COLOR_RED;
                    } else {
                        revertFunc(grParentNode, parentNode);
                        grParentNode.rightNode = parentNode.leftNode;
                        parentNode.leftNode = grParentNode;
                        node.color = TREE_COLOR_RED;
                    }
                }
            } else {
                grParentNode.color = TREE_COLOR_RED;
                grParentNode.leftNode.color = TREE_COLOR_BLACK;
                grParentNode.rightNode.color = TREE_COLOR_BLACK;
                revise(grParentNode);
            }
        }
    }

    private Node getLeftNode(Node node) {
        return node.leftNode == null ? leafNode : node.leftNode;
    }

    private Node getRightNode(Node node) {
        return node.rightNode == null ? leafNode : node.rightNode;
    }

    private void revertFunc(Node node1, Node node2) {
        node1.color = TREE_COLOR_RED;
        node2.color = TREE_COLOR_BLACK;
        if (node1.parentNode != null) {
            if (node1.parentNode.leftNode == node1) node1.parentNode.leftNode = node2;
            else node1.parentNode.rightNode = node2;
            node2.parentNode = node1.parentNode;
        }else {
            rootNode = node2;
            node2.parentNode = null;
        }
        node1.parentNode = node2;
    }

    public static void main(String[] args) {
        RedBlack_Tree redBlack_tree = new RedBlack_Tree();
//        int[] elements = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            redBlack_tree.add(random.nextInt(1000), String.valueOf(random.nextInt(1000)));
            System.out.println(System.currentTimeMillis());
        }
        System.out.println(1);
        HashMap map = new HashMap<>();
        map.remove("2");
        Hashtable a = null;
    }
}
