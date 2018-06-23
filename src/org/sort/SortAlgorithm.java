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
            for(int i=0;i<boundary;i++)
            {
                last = 0;//要记得在进入循环时将last初始化为0,否则当没有swap操作时,last不会改变将陷入死循环
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
    //

    public static void show(int[] nums)
    {
        for(int i: nums)
            System.out.print(" "+i);
        Utils.doWriteLine();
    }
    public static void main(String[] args) {
        int[] nums = {48,36,68,72,12,48,2};
        int[] nums2 = {2,12,48,36,72,68,48};
        //test Simple Sort
        //simpleSort(nums);
        //test Insert Sort
        //insertSort(nums);
        //test Bubblel Sort
        bubbleSort(nums2);
        show(nums2);
    }
}
