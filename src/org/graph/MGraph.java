/**
 * Class Matrix Graph
 */
package org.graph;

public class MGraph extends Graph{
    protected int[][] a;
    protected int noEdge = Integer.MAX_VALUE;

    public MGraph(int mSize) {
        n = mSize;
        e = 0;
        a = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j] = noEdge;
            }
            a[i][i] = 0;
        }
    }

    @Override
    public boolean insert(int u, int v, int w) {
        if(u<0||u>n-1||v<0||v>n-1||u==v||a[u][v]!=noEdge)
            return false;//参数无效or重复
        a[u][v] = w;
        e++;
        return true;
    }

    @Override
    public boolean remove(int u, int v) {
        if(u<0||u>n-1||v<0||v>n-1||u==v||a[u][v]==noEdge)
            return false;//参数无效or没有该边
        a[u][v] = noEdge;
        e--;
        return true;
    }

    @Override
    public boolean exist(int u, int v) {
        if(a[u][v]==noEdge||u<0||u>n-1||v<0||v>n-1||u==v)
            return false;
        return true;
    }

    @Override
    public void print() {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
