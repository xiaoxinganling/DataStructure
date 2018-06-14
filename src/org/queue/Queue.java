/**
 *  队列ADT
 */
package org.queue;

public abstract class Queue {
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract Object front();
    public abstract boolean enQueue(Object x);
    public abstract boolean deQueue();
    public abstract void clear();
}
