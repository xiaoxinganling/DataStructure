/**
 * 实现散列表并进行测试
 */
package org.hashtable;

import org.utils.Utils;

public class HashTable {
    private int m;//max length
    private Object[] ht;
    private boolean[] empty;
    public HashTable(int mSize)
    {
        m = mSize;
        ht = new Object[m];
        empty = new boolean[m];
        for(int i=0;i<m;i++)
        {
            empty[i] = true;
        }
    }
    private int h(Object x)
    {
        return Integer.valueOf(x.toString())%11;
    }
    //find: return pos,c++中可以通过指针的方式"返回"多个参数出去
    public int find(Object x)
    {
        int pos = h(x);
        int i = pos;
        int j = -1;
        while(true)
        {
            if(ht[pos]==null&&j==-1)
                j = pos;//记录第一个为null的位置
            if(empty[pos])
                return -1;
            if(x.equals(ht[pos]))//null.equals(x)会报空指针错误
                return pos;
            pos = (pos+1)%m;
            if(pos==i)
                break;
        }
        return j==-1 ? -2 : pos;
    }
    //search:return state
    public String search(Object x)
    {
        int pos = find(x);
        if(pos==-1)
            return "NotPresent";
        else if(pos==-2)
            return "OverFlow";
        return String.valueOf(pos);
    }
    //insert
    public boolean insert(Object x)
    {
        int pos = find(x);
        if(pos==-1)
        {
            pos = h(x);
            while(true)
            {
                if(ht[pos]==null)
                    break;
                pos = (pos+1)%m;
            }
            ht[pos] = x;
            empty[pos] = false;
            return true;
        }
        return false;//有重复元素or散列表满了
    }
    //remove
    public boolean remove(Object x)
    {
        int pos = find(x);
        if(pos==-1)
            return false;
        else if(pos==-2)
        {
            pos = h(x);
            while(true)
            {
                if(ht[pos].equals(x))
                    break;
                pos = (pos+1)%m;
            }
        }
        ht[pos] = null;
        return true;
    }
    public void show()
    {
        for(int i=0;i<m;i++)
            System.out.print(" "+ht[i]);
        Utils.doWriteLine();
    }
    public static void main(String[] args) {
        HashTable ht = new HashTable(11);
        ht.insert(80);
        ht.insert(40);
        ht.insert(65);
        ht.show();
        ht.insert(58);
        ht.insert(24);
        ht.show();
        ht.insert(35);
        ht.show();
        ht.remove(58);
        ht.show();
        ht.insert(48);
        ht.show();
    }
}
