package com.zhou.Collection;

/**
 * Created by Administrator on 2017/1/9.
 *
 * BST二叉查找树 是一个课二叉树，它的左子节点的值比父节点的值要小，右节点的值要比父节点的值大
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;
    private class Node{
        private Key key;
        private Value val;
        private Node left,right;
        private int size;

        public Node(Key key,Value val,int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST(){}

    public boolean isEmpty(){
        return size()==0;
    }

    public  int size(){
        return size(root);
    }

    public int size(Node x){
        if (x==null){
            return 0;
        }else {
            return x.size;
        }
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if (x == null) return null;
        //compareTo 如果key大于x.key则大于零
        int cmp = key.compareTo(x.key);
        if (cmp<0) return get(x.left,key);
        else if (cmp>0) return get(x.right,key);
        else return x.val;
    }

    public void put(Key key,Value val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null){
            //删除key

            return;
        }
        root = put(root,key,val);

    }

    private Node put(Node x,Key key,Value val){
        if (x == null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);

        if (cmp<0) x.left = put(x.left,key,val);
        else if (cmp>0) x.right = put(x.right,key,val);
        else  x.val = val;
        x.size = 1+size(x.left)+size(x.right);
        return x;
    }

    //删除
    public void delete(Key key){
        if (key==null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root,key);
    }

    private Node delete(Node x,Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);

        if (cmp<0) x.left = delete(x.left,key);
        else if (cmp>0) x.right = delete(x.right,key);
        else {
            //删除根节点

            //如果待删除的节点不是叶子节点，则先找到待删除节点的中序遍历的后继节点，用该后继节点的值替换待删除的节点的值，然后删除后继节点。
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.size = size(x.left)+size(x.right)+1;
        return x;
    }

    private Node deleteMin(Node x){
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min(Node x){
        if (x.left == null) return x;
        else         return min(x.left);
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        BST<String,Integer> bst = new BST<>();
        bst.put("aa",1);

        System.out.println(bst.get("aa"));
    }
}
