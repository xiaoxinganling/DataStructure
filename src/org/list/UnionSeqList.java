/**
 * 利用顺序表实现两集合的并
 */
package org.list;
public class UnionSeqList {
    private static void union(SeqList a,SeqList b)
    {
        for(int i=0;i<b.length();i++)
        {
            Object x = b.find(i);
            if(a.search(x) == -1)
            {
                a.insert(a.length()-1,x);
            }
        }
    }

    public static void main(String[] args) {
        SeqList a = new SeqList(20);
        SeqList b = new SeqList(20);
        for(int i=0;i<5;i++)
        {
            a.insert(i-1,i);
        }
        for(int i=5;i<10;i++)
        {
            b.insert(i-6,i);
        }
        b.insert(-1,0);
        b.insert(3,2);
        b.insert(b.length()-1,4);
        a.output();
        b.output();
        //传对象进去会改变对象的值，因为实际上传的是引用
        union(a,b);
        a.output();
        b.output();
    }
}
