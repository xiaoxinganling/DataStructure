package org.stack;

public class SeqStack extends Stack {
    private int top;//栈顶指针
    private int maxTop;//最大栈顶指针
    private Object[] s;
    public SeqStack(int mSize)
    {
        maxTop = mSize - 1;
        s = new Object[mSize];
        top = -1;
    }
    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public boolean isFull() {
        return top==maxTop;
    }

    @Override
    public Object top() {
        if(isEmpty())
        {
            System.out.println("Empty Stack");
            return null;
        }
        return s[top];
    }

    @Override
    public boolean push(Object x) {
        if(isFull())
        {
            System.out.println("Full Stack");
            return false;
        }
        s[++top] = x;
        return true;
    }

    @Override
    public boolean pop() {
        if(isEmpty())
        {
            System.out.println("Empty Stack");
            return false;
        }
        top--;
        return true;
    }

    @Override
    public void clear() {
        top = -1;
    }
}
