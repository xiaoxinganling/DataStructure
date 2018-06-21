/**
 * Extent Matrix Graph
 */
package org.graph;

import org.queue.SeqQueue;

public class ExtMGraph extends MGraph {
    public ExtMGraph(int mSize) {
        super(mSize);
    }

    public void doDfs() {
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i])
                dfs(i, isVisited);
        }
    }

    private void dfs(int u, boolean[] isVisited) {
        System.out.print(u + " ");
        isVisited[u] = true;
        for (int j = 0; j < n; j++) {
            if (a[u][j] > 0 && a[u][j] < Integer.MAX_VALUE && !isVisited[j])
                dfs(j, isVisited);
        }
    }

    public void doBfs() {
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited);
            }
        }
    }

    private void bfs(int u, boolean[] isVisited) {
        SeqQueue sq = new SeqQueue(n);
        System.out.print(u + " ");
        isVisited[u] = true;
        sq.enQueue(u);
        while (!sq.isEmpty()) {
            Object o = sq.front();
            sq.deQueue();
            int index = Integer.valueOf(o.toString());
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && a[index][j]>0&&
                        a[index][j]<Integer.MAX_VALUE) {
                    System.out.print(j+" ");
                    isVisited[j] = true;
                    sq.enQueue(j);
                }
            }
        }
    }
    //迪杰斯特拉算法
    public void dijkstra(int v,int[] d,int[] path)//v:源点,d:记录当前最短路径的数组,path:当前最短路径的情况下的前驱
    {
        if(v<0||v>n-1)
        {
            System.out.println("OutOfBounds");
            return;
        }
        boolean[] s = new boolean[n];
        s[v] = true;
        d[v] = 0;
        for(int i=0;i<n;i++)
        {
            d[i] = a[v][i];
            if(i!=v&&d[i]<Integer.MAX_VALUE)
                path[i] = v;
            else
                path[i] = -1;
        }
        for(int i=1;i<n;i++)
        {
            int k = choose(d,s);
            s[k] = true;
            for(int j=0;j<n;j++)
            {
                if(!s[j]&&a[k][j]<Integer.MAX_VALUE&&d[k]+a[k][j]<d[j]){
                    //这个条件因为之前没有对a[k][j]进行判断,导致Integer.Max_VALUE+xxx = 一个负数
                    // 从而导致了结果中负数的出现,因为书上的INFTY和我的可能不太一样,因此必须把不相邻的顶点过滤掉
                    d[j] = d[k]+a[k][j];
                    path[j] = k;
                }
            }
        }
    }
    //从s为false的点中取出d为最小值的点
    private int choose(int[] d,boolean[] s)
    {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<n;i++)
        {
            if(!s[i]&&d[i]<=min)
            {
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}
