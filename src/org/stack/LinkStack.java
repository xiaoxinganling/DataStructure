/**
 * 使用链表实现的栈--链接栈
 */
package org.stack;

import org.list.Node;

public class LinkStack extends Stack {
    private Node first;
    public LinkStack()
    {
        first = null;
    }
    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object top() {
        if(isEmpty())
        {
            return "Empty Stack";
        }
        return first.getElement();
    }

    @Override
    public boolean push(Object x) {
        Node p = new Node();
        p.setElement(x);
        if(isEmpty())
        {
            first = p;
        }
        else
        {
            p.setNext(first);
            first = p;
        }
        return true;
    }

    @Override
    public boolean pop() {
        if(isEmpty())
        {
            System.out.println("Empty Stack");
            return false;
        }
        first = first.getNext();
        return true;
    }

    @Override
    public void clear() {
        first = null;
    }
}
