/**
 * 二叉树结点类
 */
package org.tree;

public class BTNode {
    private Object element;
    private BTNode lChild;
    private BTNode rChild;

    public BTNode(Object element) {
        this.element = element;
    }

    public BTNode(Object element, BTNode lChild, BTNode rChild) {
        this.element = element;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BTNode getlChild() {
        return lChild;
    }

    public void setlChild(BTNode lChild) {
        this.lChild = lChild;
    }

    public BTNode getrChild() {
        return rChild;
    }

    public void setrChild(BTNode rChild) {
        this.rChild = rChild;
    }
}
