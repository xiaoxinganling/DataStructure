/**
 * 测试拓扑排序
 */
package org.graph;

public class TestTopoSort {
    public static void main(String[] args) {
        ExtLGraph elg = new ExtLGraph(9);
        elg.insert(0,2,1);//如果边没有权值,则默认为1
        elg.insert(0,7,1);
        elg.insert(1,2,1);
        elg.insert(1,3,1);
        elg.insert(1,4,1);
        elg.insert(2,3,1);
        elg.insert(3,5,1);
        elg.insert(3,6,1);
        elg.insert(4,5,1);
        elg.insert(7,8,1);
        elg.insert(8,6,1);

        //加入环
        //elg.insert(6,8,1);
        elg.topoSort();
    }
}
