/**
 * 排序算法的实现
 */
package org.sort;

import org.utils.Utils;

public class SortAlgorithm {
    //简单选择排序
    public static void simpleSort(int[] nums)
    {
        int len = nums.length;
        for(int i=0;i<len-1;i++)//最后一个不用选择了,所以为len-1
        {
            int least = i;
            for(int j = i+1;j<len;j++)
            {
                if(nums[j]<nums[least])
                    least = j;
            }
            if(least!=i)
            {
                int tmp = nums[least];
                nums[least] = nums[i];
                nums[i] = tmp;
            }
        }
    }
    //直接插入排序
    public static void insertSort(int[] nums)
    {
        int len = nums.length;
        for(int i=1;i<len;i++)
        {
            int j = i;
            int tmp = nums[i];
            while(j>0&&tmp<nums[j-1])
            {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = tmp;
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] nums)
    {
        int boundary = nums.length-1;
        int last = 0;
        while(boundary>0)
        {
            last = 0;//要记得在进入循环时将last初始化为0,否则当没有swap操作时,last不会改变将陷入死循环

            for(int i=0;i<boundary;i++)
            {
                if(nums[i]>nums[i+1])
                {
                    int tmp = nums[i+1];
                    nums[i+1] = nums[i];
                    nums[i] = tmp;
                    last = i;

                }
            }
            boundary = last;//使用了一个状态变量对算法进行了优化,在这种情况下,可以避免一些不必要的计算
        }
    }
    //快速排序
    public static void quickSort(int left,int right,int[] nums)
    {
        int part = partition(left,right,nums);
        if(part>left+1)
            quickSort(left,part-1,nums);
        if(part<right-1)
            quickSort(part+1,right,nums);
    }
    //快速排序辅助：partition函数
    private static int partition(int i,int j,int[] nums)
    {
        int tmp = nums[i];
        int left = i;
        while(i<j)
        {
            while(nums[j]>=tmp&&i<j)
                j--;
            while(nums[i]<=tmp&&i<j)//这里不能加等于号
                i++;
            if(i<j)
            {
                int a = nums[j];
                nums[j] = nums[i];
                nums[i] = a;
            }
        }
        nums[left] = nums[i];
        nums[i] = tmp;
        return i;
    }
    //归并排序
    public static void mergeSort(int[] nums)
    {
        int size = 1;
        int len = nums.length;
        while(size<len)
        {
            int i1 = 0;
            while(i1+size<len)
            {
                int i2 = i1 + size;
                int j1 = i2 -1;
                int j2 = j1+size;
                if(j1+size>=len)
                    j2 = len-1;
                merge(nums,i1,j1,i2,j2);
                i1 = j2 + 1;
            }
            size*=2;
        }
    }
    //归并排序辅助：归并两个数组
    private static void merge(int[] nums,int i1,int j1,int i2,int j2)//归并nums数组的[i1,j1]和[i2,j2]两个区间
    {
        int[] tmp = new int[j2-i1+1];//辅助数组
        int i = i1;
        int j = i2;
        int k = 0;
        while(i<=j1&&j<=j2)
        {
            if(nums[i]<=nums[j])
                tmp[k++] = nums[i++];
            else
                tmp[k++] = nums[j++];
        }
        while(i<=j1)
            tmp[k++] = nums[i++];
        while(j<=j2)
            tmp[k++] = nums[j++];
        for(i = 0;i<k;i++)
            nums[i1++] = tmp[i];//此处不是nums[i] = tmp[i],因为归并的起点是i1
    }
    //堆排序
    public static void heapSort(int[] nums)
    {
        int len = nums.length;
        //create heap
        for(int i= (len-2)/2;i>=0;i--)
            adjustDown(nums,i,len-1);
        //sort
        for(int i=len-1;i>0;i--)
        {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            adjustDown(nums,0,i-1);
        }
    }
    //堆排序辅助:adjustDown函数(此处为构建最大堆的adjustDown函数,与package minheap中的adjustDown函数有略微差异)
    private static void adjustDown(int[] nums,int r,int j)//r未成最大堆,[r-1,j]已成最大堆,因此向下调整
    {
        int tmp = nums[r];
        int child = 2*r+1;
        while(child<=j)
        {
            if(child<j&&nums[child+1]>nums[child])//child<j写在前面,否则会出现array out of bounds的错误
                child++;
            if(tmp>=nums[child])//tmp已经更大了
                break;
            nums[(child-1)/2] = nums[child];
            child = 2*child +1;
        }
        nums[(child-1)/2] = tmp;
    }
    //打印数组
    public static void show(int[] nums)
    {
        for(int i: nums)
            System.out.print(" "+i);
        Utils.doWriteLine();
    }
    //测试main函数
    public static void main(String[] args) {
        int[] nums = {48,36,68,72,12,48,2};
        //test Simple Sort
        //simpleSort(nums);

        //test Insert Sort
        //insertSort(nums);

        //test Bubblel Sort
        //int[] nums2 = {2,12,48,36,72,68,48};
        //bubbleSort(nums2);

        //test quickSort
//        int[] nums2 = {17,485,59,73,50,475,49,66,89,440,75,119,120,187,79};
//        quickSort(0,nums2.length-1,nums2);
//        show(nums2);

        //test mergeSort
        //mergeSort(nums);
        //show(nums);

        //test heapSort
        heapSort(nums);
        show(nums);
    }
}
