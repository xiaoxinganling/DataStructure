/**
 * 图Graph
 */
package org.graph;

public abstract class Graph {
    protected int n;//点数
    protected int e;//边数
    public abstract boolean insert(int u,int v,int w);
    public abstract boolean remove(int u,int v);
    public abstract boolean exist(int u,int v);
    public int vertices(){
        return n;
    }
    public abstract void print();
}
