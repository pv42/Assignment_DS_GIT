package assignmentDS.util;

import java.util.AbstractCollection;
import java.util.Iterator;

public class MyBinTree<T> extends AbstractCollection<T> {
    class Node {

        //Knotenpunkte für BinBaum
        private T data;
        private Node left, right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getChildCount() {
            int leftc = 0, rightc = 0;
            if (left != null) leftc = left.getChildCount() + 1;
            if (right != null) rightc = right.getChildCount() + 1;
            return leftc + rightc;
        }

    }

    private Node root = null;

    private void rekInsert(Node ast, T data) {
        if (ast.left == null) {
            ast.left = new Node(data);
        } else if (ast.right == null) {
            ast.right = new Node(data);
        } else {
            if (ast.left.getChildCount() <= ast.right.getChildCount()) {
                rekInsert(ast.left, data);
            } else {
                rekInsert(ast.right, data);
            }
        }
    }

    @Override
    public boolean add(T data) {
        if (root == null) {
            root = new Node(data);
        } else {
            rekInsert(root, data);
        }
        return true;
    }


    private String rekRunThrough(Node ast) { //Astausgabe
        String str = "";
        if (ast != null) {
            str += ast.getData() + "\n";
            str += rekRunThrough(ast.left);
            str += rekRunThrough(ast.right);
        }
        return str;
    }

    @Override
    public String toString() { //Ausgeben
        String str = "";
        if (root != null) {
            str += root.getData() + "\n";
            str += rekRunThrough(root.left);
            str += rekRunThrough(root.right);
        }
        return str;
    }
    public Iterator<T> iterator() {
        return new MyTreeIterator<T>(root);
    }

    @Override
    public int size() {
        if(root == null) return 0;
        return root.getChildCount()+1;
    }
}
