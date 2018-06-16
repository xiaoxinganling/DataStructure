/**
 * 测试优先权队列，测试createHeap方法和append方法产生的堆的异同
 * reason: 结果的不同的是算法的不同导致的，但他们都是最小堆
 */
package org.minheap;

public class TestPrioQueue {
    public static void main(String[] args) {
        PrioQueue pq = new PrioQueue(10);
        Integer[] array = {71,74,2,72,54,93,52,28};
        for(int i=0;i<array.length;i++)
            pq.append(array[i]);
        HeapUtils.createHeap(array,array.length);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }
}
