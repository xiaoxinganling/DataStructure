/**
 * 单链表节点
 */
package org.list;

public class Node
{
    private Object element;
    private Node next;

    public Object getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
