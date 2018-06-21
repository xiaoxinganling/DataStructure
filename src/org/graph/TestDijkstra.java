package org.graph;

import org.utils.Utils;

public class TestDijkstra {
    public static void main(String[] args) {
        ExtMGraph emg = new ExtMGraph(6);
        int[] s = {0,0,0,1,1,2,2,3,3,4,5};
        int[] e = {1,2,4,2,4,0,3,1,4,3,3};
        int[] w = {50,10,70,15,10,20,15,20,35,30,3};
        for(int i=0;i<s.length;i++)
            emg.insert(s[i],e[i],w[i]);
        int[] d = new int[emg.n];
        int[] path = new int[emg.n];
        emg.dijkstra(0,d,path);
        for(int i=0;i<d.length;i++)
            System.out.print(d[i]+","+path[i]+" ");
        Utils.doWriteLine();
    }
}
