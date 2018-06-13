/**
 * 单链表
 */
package org.list;

public class SingleList extends LinearList{
    protected Node first;

    public SingleList(){
        first = null;
        n = 0;
    }
    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int length() {
        return n;
    }

    @Override
    public Object find(int i) {
        if(i<0||i>n-1)
        {
            System.out.println("Out of bounds.");
            return null;
        }
        Node p = first;
        for(int j = 0;j<i;j++)
        {
            p = p.getNext();
        }
        return p.getElement();
    }

    //返回链表中第一个与该元素相同的下标
    @Override
    public int search(Object i) {
        Node p = first;
        int j = 0;
        while(p!=null&&!(p.getElement().equals(i)))
        {
            p = p.getNext();
            j++;
        }
        if(p!=null)
            return j;
        return -1;
    }

    @Override
    public boolean insert(int i, Object x) {
        if(i<-1||i>n-1)
        {
            System.out.println("Out of bounds.");
            return false;
        }
        Node q = new Node();
        q.setElement(x);
        Node p =first;
        for(int j=0;j<i;j++)
            p = p.getNext();
        if(i>-1)
        {
            q.setNext(p.getNext());
            p.setNext(q);
        }
        else
        {
            q.setNext(first);
            first = q;
        }
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
        if(i<0||i>n-1) {
            System.out.println("Out of bounds.");
            return false;
        }
        Node p,q = first;
        for(int j=0;j<i-1;j++)
            q = q.getNext();
        if(i==0)
        {
            first = first.getNext();
        }
        else
        {
           p = q.getNext();
           q.setNext(p.getNext());
        }
        p = null;//java中内存自动回收
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
        Node p =first;
        for(int j=0;j<i;j++)
            p = p.getNext();
        p.setElement(x);
        return true;
    }

    @Override
    public void output() {
        Node p = first;
        while(p!=null)
        {
            System.out.print(p.getElement()+" ");
            p = p.getNext();
        }
        System.out.println();
    }

    @Override
    public void clear() {
        Node p;
        while(first!=null)
        {
            p = first.getNext();
            first = null;//delete first
            first = p;
        }
        n = 0;
        System.out.println("clear ok");
    }
}
