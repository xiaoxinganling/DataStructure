/*
 * Extent Link Graph
 */
package org.graph;

import org.graph.criticalpath.Edge;
import org.queue.SeqQueue;

import java.util.ArrayList;
import java.util.List;

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
    //拓扑排序
    public List<Integer> topoSort()
    {
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[n];
        calInDegree(inDegree);
        int top = -1;
        for(int i=0;i<n;i++)//入度为0的顶点入栈
        {
            if(inDegree[i]==0)
            {
                inDegree[i] = top;
                top = i;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(top==-1)
            {
                System.out.println("Has Cycle");
                return null;
            }
            else
            {
                int tmp = top;
                top = inDegree[top];
                System.out.print(tmp+" ");
                res.add(tmp);
                ENode p = a[tmp];
                while (p!=null)
                {
                    int k = p.getAdjVex();
                    inDegree[k]--;
                    if(inDegree[k]==0)
                    {
                        inDegree[k] = top;
                        top = k;
                    }
                    p = p.getNextArc();
                }
            }
        }
        return res;
    }
    //计算各顶点的入度
    private void calInDegree(int[] inDegree)
    {
        for(int i=0;i<n;i++)
        {
            ENode p = a[i];
            while(p!=null)
            {
                inDegree[p.getAdjVex()]++;
                p = p.getNextArc();
            }
        }
    }
    //计算事件(点)可能的最早发生时间
    public int[] earliest()
    {
        List<Integer> topoList = topoSort();
        int[] earliest = new int[n];
        for(int i=0;i<topoList.size();i++)
        {
            int k = topoList.get(i);
            ENode p = a[k];
            while(p!=null)
            {
                if(earliest[k]+p.getW()>earliest[p.getAdjVex()])
                {
                    earliest[p.getAdjVex()] = earliest[k]+p.getW();
                }
                p = p.getNextArc();
            }
        }
        return earliest;
    }
    //计算事件(点)允许的最迟发生时间
    public int[] latest()
    {
        int[] earliest = earliest();
        List<Integer> topoList = topoSort();
        int[] latest = new int[n];
        for(int i=0;i<latest.length;i++)
        {
            latest[i] = earliest[n-1];
        }
        for(int i=topoList.size()-1;i>=0;i--)
        {
            int k = topoList.get(i);
            ENode p = a[k];
            while(p!=null)
            {
                if(latest[p.getAdjVex()]-p.getW()<latest[k])
                    latest[k] = latest[p.getAdjVex()]-p.getW();
                p = p.getNextArc();
            }
        }
        return latest;
    }
    //计算活动(边)的early和late
    public List<Edge> getKeyAct(int[] earliest,int[] latest)
    {
        List<Edge> res = new ArrayList<>();
        for(int i=0;i<a.length;i++)
        {
            ENode p = a[i];
            while(p!=null)
            {
                Edge e = new Edge();
                e.setLate(i);
                e.setRight(p.getAdjVex());
                e.setEarly(earliest[i]);
                e.setLate(latest[p.getAdjVex()]-p.getW());
                res.add(e);
                p = p.getNextArc();
            }
        }
        return res;
    }
    //最小生成树Prim算法
    public void prim(int k,int[] nearest,int[] lowcost)//k：开始节点下标,nearest,lowcost：生成树外某一顶点到生成树最小距离的顶点下标和长度
    {
        if(k<0||k>n-1){
            System.out.println("OutOfBounds");
            return;
        }
        //初始化
        boolean[] marked = new boolean[n];
        for(int i=0;i<n;i++)
        {
            nearest[i] = -1;
            lowcost[i] = Integer.MAX_VALUE;
        }
        //将起点放入生成树
        nearest[k] = k;
        lowcost[k] = 0;
        marked[k] = true;
        //将剩余顶点放入生成树
        for(int i=1;i<n;i++)
        {
            ENode p = a[k];
            while(p!=null)
            {
                if(!marked[p.getAdjVex()]&&p.getW()<lowcost[p.getAdjVex()])
                {
                    nearest[p.getAdjVex()] = k;
                    lowcost[p.getAdjVex()] = p.getW();
                }
                p = p.getNextArc();
            }
            //找到还没放进生成树中的顶点lowcost的最小值
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(!marked[j]&&lowcost[j]<min)
                {
                    min = lowcost[j];
                    k = j;
                }
            }
            //找到了,下标为k,将k放入生成树中
            marked[k] = true;
        }
    }
}

