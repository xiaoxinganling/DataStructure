/**
 * 二叉树类
 */
package org.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private BTNode root;

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public boolean isEmpty()
    {
        return false;
    }
    public void clear()
    {

    }
    public Object getRootElement()
    {
        return root.getElement();
    }
    public void makeTree(Object x,BinaryTree left,BinaryTree right)//以x为根结点，left为左子树，right为右子树进行树的构造
    {
        //build tree
//        if(root!=null||left==right)
//            return;
        root = new BTNode(x,left.getRoot(),right.getRoot());
    }
    public List<Object> breakTree(Object x, BinaryTree left, BinaryTree right)
    {
        List<Object> res = new ArrayList<>();
        res.add(root.getElement());
        BinaryTree l = new BinaryTree();
        BinaryTree r = new BinaryTree();
        l.setRoot(root.getlChild());
        r.setRoot(root.getrChild());
        res.add(l);
        res.add(r);
        root = null;
        return res;
    }
    public void doPreOrder()
    {
        preOrder(root);
    }
    private void preOrder(BTNode root)
    {
        if(root==null)
            return;
        System.out.print(root.getElement().toString()+" ");
        preOrder(root.getlChild());
        preOrder(root.getrChild());
    }
    public void doInOrder()
    {
        inOrder(root);
    }
    private void inOrder(BTNode root)
    {
        if(root==null)
            return;
        inOrder(root.getlChild());
        System.out.print(root.getElement().toString()+" ");
        inOrder(root.getrChild());
    }
    public void doPostOrder()
    {
        postOrder(root);
    }
    private void postOrder(BTNode root)
    {
        if(root==null)
            return;
        postOrder(root.getlChild());
        postOrder(root.getrChild());
        System.out.print(root.getElement()+" ");
    }
    public int getSize()
    {
        return size(root);
    }
    private int size(BTNode root)
    {
        if(root==null)
            return 0;
        return size(root.getlChild())+size(root.getrChild())+1;
    }
}
