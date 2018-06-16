/**
 * 优先权队列类,此处为最小堆
 */
package org.minheap;

public class PrioQueue {
    private int[] heap;
    int n;
    int maxSize;

    public PrioQueue(int mSize) {
        heap = new int[mSize];
        n = 0;
        maxSize = mSize;
    }
    public boolean isEmpty()
    {
        return n==0;
    }
    public boolean isFull()
    {
        return n==maxSize;
    }
    public void append(int x)
    {
        if(isFull())
            System.out.println("OverFlow");
        heap[n++] = x;
        HeapUtils.adjustUp(heap,n-1);
        for(int i=0;i<n;i++)
         System.out.print(heap[i]+" ");
        System.out.println();
    }
    public Integer serve()//return the min value
    {
        if(isEmpty()){
            System.out.println("UnderFlow");
            return null;
        }
        int res = heap[0];
        heap[0]=heap[--n];
        HeapUtils.adjustDown(heap,0,n-1);
        return res;
    }
}
