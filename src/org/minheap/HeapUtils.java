/**
 * 堆工具类，包括adjustDown,adjustUp,createHeap方法
 */
package org.minheap;

public class HeapUtils {
    public static void adjustDown(Object[] heap,int r,int j)//r+1->j已经满足最小堆
    {
        Object tmp = heap[r];
        int child = 2*r+1;
        while(child<=j)
        {
            if((child<j)&&(Integer.valueOf(heap[child+1].toString())<
                    Integer.valueOf(heap[child].toString())))//若是最大堆则取最大值
                child++;
            if(Integer.valueOf(tmp.toString())
                    <=Integer.valueOf(heap[child].toString()))//若是最大堆则为>=
                break;
            heap[(child-1)/2] = heap[child];
            child = 2*child+1;
        }
        heap[(child-1)/2] = tmp;
    }
    public static void adjustUp(Object[] heap,int index)
    {
        Object tmp = heap[index];
        int i = index;
        while(i>0&&Integer.valueOf(heap[(i-1)/2].toString())>
            Integer.valueOf(tmp.toString())){//如果是最大堆,heap[(i-1)/2]<tmp循环进行,即tmp更大,tmp应该网上走
            heap[i] = heap[(i-1)/2];
            i = (i-1)/2;
        }
        heap[i] = tmp;
    }
    public static void createHeap(Object[] heap,int n)//n表示需要建堆数组长度
    {
        int start = (n-2)/2;
        for(int i=start;i>=0;i--)
        {
            adjustDown(heap,i,n-1);
        }
    }

    public static void main(String[] args) {
        Integer[] array = {61,28,81,43,36,47,83,5};
        createHeap(array,array.length);
        for(int i:array)
            System.out.print(i+" ");
    }
}
