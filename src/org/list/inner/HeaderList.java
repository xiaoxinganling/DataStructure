/**
 * 带表头的单链表
 */
package org.list.inner;

import org.list.Node;
import org.list.SingleList;

public class HeaderList extends SingleList {
    public HeaderList()
    {
        first = new Node();
        first.setElement(null);
        n = 0;
    }

    @Override
    public boolean insert(int i, Object x) {
        if(i<-1||i>n-1)
        {
            System.out.println("Out of bounds.");
            return false;
        }
        Node p = first;
        for(int j=0;j<=i;j++)
            p = p.getNext();
        Node q = new Node();
        q.setElement(x);
        q.setNext(p.getNext());
        p.setNext(q);
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
        if(i<0||i>n-1){
            System.out.println("Out of bounds.");
            return false;
        }
        Node p;
        Node q = first;
        for(int j=0;j<i;j++)
        {
            q = q.getNext();
        }
        p = q.getNext();
        q.setNext(p.getNext());
        p = null;//delete p
        n--;
        return true;
    }

    @Override
    public int search(Object i) {
        Node p = first.getNext();
        int j = 0;
        while(p!=null&&!(p.getElement().equals(i))) {
            j++;
            p = p.getNext();
        }
        if(p==null)
            return -1;
        return j;
    }

    @Override
    public Object find(int i) {
        if(i<0||i>n-1)
        {
            System.out.println("Out of bounds.");
            return null;
        }
        Node p = first.getNext();
        for(int j=0;j<i;j++)
            p = p.getNext();
        return p.getElement();
    }

    @Override
    public boolean update(int i,Object x) {
        if(i<0||i>n-1)
        {
            System.out.println("Out of bounds.");
            return false;
        }
        Node p = first.getNext();
        for(int j=0;j<i;j++)
            p = p.getNext();
        p.setElement(x);
        return true;
    }

    @Override
    public void clear() {
        Node newFirst = first.getNext();
        first.setNext(null);
        //此处内存泄漏
        for(int i=0;i<n;i++)
        {
            Node p = newFirst.getNext();
            newFirst = null;
            newFirst = p;
        }
        n = 0;
        System.out.println("clear ok");
    }
}
