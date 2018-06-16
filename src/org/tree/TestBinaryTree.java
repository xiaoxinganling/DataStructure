/**
 * 测试二叉树类
 */
package org.tree;

public class TestBinaryTree {
    //step 1
    private static BinaryTree a = new BinaryTree();
    private static BinaryTree b = new BinaryTree();
    private static BinaryTree x = new BinaryTree();
    private static BinaryTree y = new BinaryTree();
    private static BinaryTree z = new BinaryTree();
    public static void main(String[] args) {
        System.out.print("step 1:");
        doPrint();
        //step2
        y.makeTree('E',a,b);
        z.makeTree('F',a,b);
        System.out.print("step 2:");
        doPrint();
        //step 3
        x.makeTree('C',y,z);
        System.out.print("step 3:");
        doPrint();
        //step 4
        y.makeTree('D',a,b);
        System.out.print("step 4:");
        doPrint();
        //step 5
        z.makeTree('B',y,x);
        System.out.print("step 5:");
        doPrint();
        System.out.println(z.getSize());
        BinaryTree newTree = new BinaryTree();
        newTree.setRoot(copy(z.getRoot()));
        newTree.doInOrder();
        System.out.println();
//        clear(newTree.getRoot());
//        newTree.doInOrder();
        newTree.doHierarchy();
    }

    public static void doPrint() {
        x.doInOrder();
        y.doInOrder();
        z.doInOrder();
        System.out.println();
    }
    public static BTNode copy(BTNode node)
    {
        if(node==null)
            return null;
        BTNode q = new BTNode(node.getElement());
        q.setlChild(copy(node.getlChild()));
        q.setrChild(copy(node.getrChild()));
        return q;
    }
    public static void clear(BTNode node)
    {
        if(node==null)
            return;
        clear(node.getlChild());
        clear(node.getrChild());
        node.setElement(node.getElement()+"acc");
//        node.setlChild(null);
//        node.setrChild(null);
    }
}