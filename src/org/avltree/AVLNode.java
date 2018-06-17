/**
 * 二叉平衡树结点类
 */
package org.avltree;

public class AVLNode {
    private Object element;
    private int bF;
    private AVLNode lChild;
    private AVLNode rChild;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public int getbF() {
        return bF;
    }

    public void setbF(int bF) {
        this.bF = bF;
    }

    public AVLNode getlChild() {
        return lChild;
    }

    public void setlChild(AVLNode lChild) {
        this.lChild = lChild;
    }

    public AVLNode getrChild() {
        return rChild;
    }

    public void setrChild(AVLNode rChild) {
        this.rChild = rChild;
    }
}
