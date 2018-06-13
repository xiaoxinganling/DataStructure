/**
 * 顺序表
 */
package org.list;

public class SeqList extends LinearList {
    private int maxLength;
    private Object[] elements;

    public SeqList(int mSize)
    {
        maxLength = mSize;
        elements = new Object[mSize];
        n = 0;
    }
    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int length() {
        return n;
    }

    @Override
    public Object find(int i) {
        if(i < 0||i > n-1)
        {
            System.out.println("Out of bounds.");
            return null;
        }
        return elements[i];
    }

    @Override
    public int search(Object i) {
        for(int j=0;j<n;j++)
        {
            if(elements[j].equals(i))
                return j;
        }
        return -1;
    }

    //在下标为i的元素之后插入
    @Override
    public boolean insert(int i, Object x) {
        if(i<-1||i>n-1)
        {
            System.out.println("Out of bounds.");
            return false;
        }
        if(n==maxLength)
        {
            System.out.println("OverFlow");
            return false;
        }
        for(int j=n-1;j>i;j--)
        {
            elements[j+1]=elements[j];
        }
        elements[i+1] = x;
        n++;
        return true;
    }

    @Override
    public boolean delete(int i) {
        if(n==0)
        {
            System.out.println("UnderFlow");
            return false;
        }
        if(i<0||i>n-1)
        {
            System.out.println("Out of bounds.");
            return false;
        }
        for(int j=i+1;j<n;j++)
        {
            elements[j-1] = elements[j];
        }
        n--;
        return true;
    }

    @Override
    public boolean update(int i, Object x) {
        if(i<0||i>n-1)
        {
            System.out.println("Out of bounds.");
            return false;
        }
        elements[i] = x;
        return true;
    }

    @Override
    public void output() {
        for(int i=0;i<n;i++)
        {
            System.out.print(elements[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for(int i=0;i<n;i++)
        {
            elements[i] = null;
        }
        System.out.println("clear ok");
        n=0;
    }
}
