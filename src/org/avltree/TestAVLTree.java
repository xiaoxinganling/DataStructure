/**
 * 二叉平衡树测试类
 */
package org.avltree;

public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree avlt = new AVLTree();
        Integer[] b = {45,28,15,12,14,13};
        for(Integer i: b)
        {
            avlt.doInsert(i);
        }
        avlt.doHierarchy();
        System.out.println();
        avlt.doInOrder();
    }
}
