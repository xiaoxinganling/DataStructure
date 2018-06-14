/**
 * 链接队列的实现
 */
package org.queue;

import org.list.Node;

public class LinkQueue extends Queue {
    private Node front;
    private Node real;
    public LinkQueue()
    {
        front = null;
        real = null;
    }
    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public boolean isFull() {
        return false;//永不满
    }

    @Override
    public Object front() {
        if(isEmpty())
            return "Empty Queue";
        return front.getElement();
    }

    @Override
    public boolean enQueue(Object x) {
        Node p = new Node();
        p.setElement(x);
        if(front==null)
        {
            //空队列
            front = p;
            real = p;
        }
        else{
            real.setNext(p);
            real = p;
        }
        return true;

    }

    @Override
    public boolean deQueue() {
        if(isEmpty())
        {
            System.out.println("Empty Queue");
            return false;
        }
        front = front.getNext();
        return true;
    }

    @Override
    public void clear() {
        front = null;
        real = null;
    }
}
