package selfDataStruction;

public class RedBlack_Tree {
    public Node rootNode;
    public static final Boolean TREE_COLOR_RED = true;
    public static final Boolean TREE_COLOR_BLACK = false;

    static class Node {
        private Boolean color;
        private int hash;
        private Object value;
        private Node leftNode;
        private Node rightNode;
        private Node parentNode;
    }

    public RedBlack_Tree() {
    }

    public void add(int hash, Object value) {
        Node node = new Node();
        node.hash = hash;
        node.value = value;
        node.color = TREE_COLOR_RED;

        if (this.rootNode == null) {
            this.rootNode = node;
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
                    tem.value = node.value;
                    sizeChange = false;
                }
            }
            if (sizeChange)
                revise(node);
        }
    }

    public void get(Object key) {

    }

    public void remove() {

    }

    public void set() {

    }

    public void count() {

    }

    public void revise(Node node) {
        Node parentNode = node.parentNode;
        if (parentNode.color == TREE_COLOR_BLACK){
            return;
        }else {
            Node parent = node.parentNode;
            Node grandParent = parent.parentNode;
            if(grandParent.leftNode == null){
                if(grandParent == rootNode){
                    this.rootNode = parentNode;
                    this.rootNode.leftNode = node;
                    this.rootNode.rightNode = grandParent;
                } else if(grandParent.parentNode.leftNode == grandParent){

                }
            }
        }
    }
}
