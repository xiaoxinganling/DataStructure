package org.list;

public class InterSectionSingleList {
    private static void intersection(SingleList a,SingleList b)
    {
        for(int i=0;i<a.length();i++)
        {
            if(b.search(a.find(i))==-1)
            {
                a.delete(i);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        SingleList a = new SingleList();
        SingleList b = new SingleList();
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
        intersection(a,b);
        a.output();
        b.output();
    }
}
