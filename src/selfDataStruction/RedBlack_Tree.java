package selfDataStruction;

public class RedBlack_Tree {
    public Node rootNode;
    public static final Boolean TREE_COLOR_RED = true;
    public static final Boolean TREE_COLOR_BLACK = false;
    static class Node{
        private Boolean color;
        private int hash;
        private Object value;
        private Node leftNode;
        private Node rightNode;

        public Boolean getColor() {
            return color;
        }

        public void setColor(Boolean color) {
            this.color = color;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }
    }

    public RedBlack_Tree(){}

    public void add(int hash,Object value){
        Node node=new Node();
        node.setHash(hash);
        node.setValue(value);
        node.setColor(TREE_COLOR_RED);
        if(this.rootNode==null){
            this.rootNode=node;
        }else {
            Node tem = this.rootNode;
            for(;tem!=null;){
                if(node.getHash()<=tem.getHash()){
                    if(tem.getLeftNode()!=null) tem=tem.getLeftNode();
                    else tem.setLeftNode(node);
                } else {
                    if(tem.getRightNode()!=null) tem=tem.getRightNode();
                    else tem.setRightNode(node);
                }
            }
        }
        revise(this.rootNode);
    }

    public void get(Object key){

    }

    public void remove(){

    }

    public void set(){

    }

    public void count(){

    }

    public void revise(Node rootNode){

    }
}
