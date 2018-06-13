package org.list.josephus;

import org.list.Node;
import org.list.SingleList;

public class RotateSingleList extends SingleList {
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
            //get last code
            Node last = first;
            for(int j=0;j<n;j++)
            {
                last = last.getNext();
            }
            last.setNext(first);
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
            Node last = first;
            for(int j=0;j<n-1;j++)
            {
                last = last.getNext();
            }
            first = first.getNext();
            last.setNext(first);

        }
        else
        {
            p = q.getNext();
            q.setNext(p.getNext());
        }
        p = null;//java中内存自动回收
        n--;
        if(n==0)
        {
            first = null;
        }
        return true;
    }

    @Override
    public void output() {
        Node p = first;
        int i = 0;
        while(i<n)
        {
            System.out.print(p.getElement()+" ");
            p = p.getNext();
            i++;
        }
        System.out.println();
    }
    //共计n人,从第s个人开始，下标为s-1
    public void rotate(int n,int s,int m){
        for(int i=0;i<n;i++)
            insert(i-1,i+1);
        Node p = first;
        for(int i=0;i<s-1;i++)
            p = p.getNext();
        int count = 1;
        while(first!=null)
        {
            if(count%m==0)
            {
                Object toPrint = p.getElement();
                count++;
                p = p.getNext();
                System.out.print(toPrint+"  ");
                delete(search(toPrint));
                output();
            }
            else
            {
                count++;
                p = p.getNext();
            }
        }

    }
}
