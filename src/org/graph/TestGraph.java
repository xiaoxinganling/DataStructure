/**
 * Test Graph Operation
 */
package org.graph;

public class TestGraph {
    public static void main(String[] args) {
        MGraph mg = new MGraph(4);
        doTest(mg);
        mg.remove(3,1);
        mg.print();
        System.out.println(mg.remove(3,2));
        LGraph lg = new LGraph(4);
        doTest(lg);
        lg.remove(3,1);
        lg.print();
        System.out.println(lg.remove(3,2));
    }
    public static void doTest(Graph g)
    {
        g.insert(1,0,4);
        g.insert(1,2,5);
        g.insert(2,3,3);
        g.insert(3,0,1);
        g.insert(3,1,1);
        g.print();
    }
}
