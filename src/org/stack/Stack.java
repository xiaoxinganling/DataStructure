package org.stack;

public abstract class Stack  {
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract Object top();
    public abstract boolean push(Object x);
    public abstract boolean pop();
    public abstract void clear();
}
