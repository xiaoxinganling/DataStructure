/**
 * 线性表ADT
 */
package org.list;
public abstract class LinearList {
    protected int n;//

    public abstract boolean isEmpty();
    public abstract int length();
    public abstract Object find(int i);//return the index of i's object
    public abstract int search(Object i);//search:return the index
    public abstract boolean insert(int i,Object x);
    public abstract boolean delete(int i);
    public abstract boolean update(int i,Object x);
    public abstract void output();
}
