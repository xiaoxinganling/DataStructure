/**
 * 测试关键路径
 */
package org.graph;

import org.graph.criticalpath.Edge;
import org.utils.Utils;

import java.util.List;

public class TestKeyPath {
    public static void main(String[] args) {
        ExtLGraph elg = new ExtLGraph(9);
        elg.insert(0,3,5);
        elg.insert(0,2,4);
        elg.insert(0,1,6);

        elg.insert(1,4,1);
        elg.insert(2,4,1);
        elg.insert(3,5,2);
        elg.insert(4,7,8);
        elg.insert(4,6,9);
        elg.insert(5,7,4);
        elg.insert(6,8,2);
        elg.insert(7,8,4);
        int[] earliest = elg.earliest();
        Utils.doWriteLine();
        int[] latest = elg.latest();
        Utils.doWriteLine();
        for(int i:earliest)
            System.out.print(i+" ");
        Utils.doWriteLine();
        for(int i:latest)
            System.out.print(i+" ");
        Utils.doWriteLine();
        List<Edge> activities = elg.getKeyAct(earliest,latest);
        for(Edge e:activities)
        {
            System.out.print(e.getEarly()+" ");
        }
        Utils.doWriteLine();
        for(Edge e:activities)
        {
            System.out.print(e.getLate()+" ");
        }
    }
}
