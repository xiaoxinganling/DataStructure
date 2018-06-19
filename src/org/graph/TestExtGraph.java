package org.graph;

public class TestExtGraph {
    public static void main(String[] args) {
        ExtLGraph elg = new ExtLGraph(7);
        createExtGraph(elg);
        elg.doDfs();
        System.out.println();
        elg.doBfs();

        System.out.println();
        ExtMGraph emg = new ExtMGraph(7);
        createExtGraph(emg);
        emg.doDfs();
        System.out.println();
        emg.doBfs();
        System.out.println();
        emg = new ExtMGraph(12);
        createNewExtGraph(emg);
        emg.doBfs();
        elg = new ExtLGraph(12);
        createNewExtGraph(elg);
        System.out.println();
        elg.doBfs();
        System.out.println();
        emg.doDfs();
        System.out.println();
        elg.doDfs();

    }
    public static void createExtGraph(Graph g)
    {
        g.insert(0,1,1);
        g.insert(1,2,1);
        g.insert(1,3,1);
        g.insert(2,0,1);
        g.insert(3,2,1);
        g.insert(4,5,1);
        g.insert(4,6,1);
        g.insert(5,1,1);
        g.insert(6,5,1);
        g.insert(6,3,1);
    }
    public static void createNewExtGraph(Graph g)
    {
        int[] a = {0,0,0,1,1,1,10,10,10,2,2,5,5,6,6,9,3,4,7};
        int[] b = {1,10,11,2,5,11,6,9,11,3,5,6,4,7,9,8,4,7,8};
        for(int i=0;i<a.length;i++)
        {
            g.insert(a[i],b[i],1);
            g.insert(b[i],a[i],1);
        }


    }
}
