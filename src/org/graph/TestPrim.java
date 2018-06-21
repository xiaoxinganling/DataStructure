/**
 * 测试Prim算法
 */
package org.graph;

import org.utils.Utils;

public class TestPrim {
    public static void main(String[] args) {
        ExtLGraph elg = new ExtLGraph(6);
        int[] s = {0,0,0,1,1,2,2,2,3,4};
        int[] e = {1,2,3,2,4,3,5,4,5,5};
        int[] w = {6,1,5,5,3,5,4,6,2,6};
        for(int i=0;i<s.length;i++)
        {
            elg.insert(s[i],e[i],w[i]);
            elg.insert(e[i],s[i],w[i]);
        }
        int[] nearest = new int[elg.n];
        int[] lowcost = new int[elg.n];
        elg.prim(0,nearest,lowcost);
        for(int i:nearest)
            System.out.print(i+" ");
        Utils.doWriteLine();
        for(int i:lowcost)
            System.out.print(i+" ");
    }
}
