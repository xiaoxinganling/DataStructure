/**
 * Extent Link Graph
 */
package org.graph;

import org.queue.SeqQueue;

public class ExtLGraph extends LGraph{
    public ExtLGraph(int mSize) {
        super(mSize);
    }
    public void doDfs()
    {
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!isVisited[i])
                dfs(i,isVisited);
        }
    }
    private void dfs(int u,boolean[] isVisited)
    {
        System.out.print(u+" ");
        isVisited[u] = true;
        ENode p = a[u];
        while(p!=null)
        {
            if(!isVisited[p.getAdjVex()])
                dfs(p.getAdjVex(),isVisited);
            p = p.getNextArc();
        }
    }
    public void doBfs()
    {
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!isVisited[i])
            {
                bfs(i,isVisited);
            }
        }
    }
    private void bfs(int u,boolean[] isVisited)
    {
        SeqQueue sq = new SeqQueue(n);
        System.out.print(u+" ");
        isVisited[u] = true;
        sq.enQueue(u);
        while(!sq.isEmpty())
        {
            Object o = sq.front();
            sq.deQueue();
            int index = Integer.valueOf(o.toString());
            ENode p = a[index];
            while(p!=null)
            {
                if(!isVisited[p.getAdjVex()])
                {
                    //进队就意味着已经遍历,必须设置isVisited为true,否则在将队首元素的邻接顶点的加入队列时,
                    //会将isVisited没设置为false的元素加入(多加入了一次)
                    System.out.print(p.getAdjVex()+" ");
                    isVisited[p.getAdjVex()] = true;
                    sq.enQueue(p.getAdjVex());
                }
                p = p.getNextArc();
            }
        }
    }
}

