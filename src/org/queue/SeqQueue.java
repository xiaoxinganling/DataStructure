/**
 *  顺序表示队列
 */
package org.queue;

public class SeqQueue extends Queue {
    private int front;
    private int real;
    private int maxSize;
    private Object[] q;
    public SeqQueue(int mSize)
    {
        front = 0;
        real = 0;
        maxSize = mSize;
        q = new Object[mSize];
    }
    @Override
    public boolean isEmpty() {
        return front==real;
    }

    @Override
    public boolean isFull() {
        return (real+1)%maxSize==front;
    }

    @Override
    public Object front() {
        if(isEmpty())
        {
            return "Empty Queue";
        }
        return q[(front+1)%maxSize];
    }

    @Override
    public boolean enQueue(Object x) {
        if(isFull())
        {
            System.out.println("Full Queue");
            return false;
        }
        real = (real+1)%maxSize;
        q[real] = x;
        return true;
    }

    @Override
    public boolean deQueue() {
        if(isEmpty()){
            System.out.println("Empty Queue");
            return false;
        }
        front = (front+1)%maxSize;
        return true;
    }

    @Override
    public void clear() {
        front = 0;
        real = 0;
    }
}
