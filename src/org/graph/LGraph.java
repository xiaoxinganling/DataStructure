/***
 * Class Link Graph
 */
package org.graph;

public class LGraph extends Graph{

    protected ENode[] a;
    public LGraph(int mSize)
    {
        n = mSize;
        e = 0;
        a= new ENode[n];
    }
    @Override
    public boolean insert(int u, int v, int w) {
        if(u<0||v<0||u>n-1||v>n-1||u==v||exist(u,v))
            return false;//参数不符合规范&&已经有边了
        //插的时候直接插在链表头,省事
        ENode p = new ENode(v,w,a[u]);
        a[u] = p;
        e++;
        return true;
    }

    @Override
    public boolean remove(int u, int v) {
        if(u<0||v<0||u>n-1||v>n-1||u==v)
            return false;
        ENode p = a[u];
        ENode q = null;
        while(p!=null&&p.getAdjVex()!=v)
        {
            q = p;
            p = p.getNextArc();
        }
        if(p==null)
            return false;//没有该边
        if(q==null)
        {
            //删除的是第一个
            a[u] = p.getNextArc();
        }
        else
        {
            q.setNextArc(p.getNextArc());
        }
        e--;
        return true;
    }

    @Override
    public boolean exist(int u, int v) {
        if(u<0||v<0||u>n-1||v>n-1||u==v)
            return false;
        ENode p = a[u];
        while(p!=null&&p.getAdjVex()!=v)
            p = p.getNextArc();
        if(p==null)
            return false;
        return true;
    }

    @Override
    public void print() {
        for(int i=0;i<n;i++)
        {
            System.out.print(i);
            ENode p = a[i];
            while(p!=null)
            {
                System.out.print("->"+p.getAdjVex());
                p = p.getNextArc();
            }
            System.out.println();
        }
    }
}
