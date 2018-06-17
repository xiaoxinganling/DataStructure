/**
 * 测试二叉搜索树
 */
package org.searchtree;

import org.tree.BinaryTree;

public class TestBSTree {
    public static void main(String[] args) {
        Integer[] items = {28,21,25,36,33,43,23,35,34};
        BSTree bst = new BSTree();
        for(Integer i: items)
            bst.insert(i);
//        测试search和delete
//        System.out.println();
//        System.out.println("27: "+bst.search(new Integer(27)));
//        System.out.println("33: "+bst.search(new Integer(33)));
//        bst.delete(new Integer(28));
//        bst.show(bst.getRoot());
        //insert over
        testChange(bst);
        //delte 23
        bst.delete(new Integer(23));
        testChange(bst);
        //delte 21
        bst.delete(new Integer(21));
        testChange(bst);
        //delete 28
        bst.delete(28);
        testChange(bst);

    }
    public static void testChange(BSTree bst)
    {
        bst.show(bst.getRoot());
        System.out.println();
        BinaryTree bt = new BinaryTree();
        bt.setRoot(bst.getRoot());
        bt.doHierarchy();
        System.out.println();
    }
}
