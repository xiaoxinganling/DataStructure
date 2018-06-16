/**
 * 哈夫曼树工具类,包括新建一个哈夫曼树
 */
package org.tree.hfmtree;

import org.minheap.PrioQueue;
import org.tree.BTNode;

public class HfmUtils {
    public static HfmTree createHfmTree(Integer[] w,int n)//以数组的n个元素构造哈夫曼树
    {
        PrioQueue pq = new PrioQueue(n);
        for(int i=0;i<n;i++)
        {
            HfmTree h = new HfmTree();
            h.setRoot(new BTNode(w[i]));
            h.setWeight(w[i]);
            pq.append(h);
        }
        for(int i =1;i<n;i++)
        {
            HfmTree h1 = (HfmTree) pq.serve();
            HfmTree h2 = (HfmTree) pq.serve();
            HfmTree h = new HfmTree();
            h.makeTree(h1.getWeight()+h2.getWeight(),h1,h2);
            h.setWeight(h1.getWeight()+h2.getWeight());
            pq.append(h);
        }
        return (HfmTree)pq.serve();
    }

    public static void main(String[] args) {
        Integer[] a = {3,5,9,11,12,13};
        //Integer[] a = {9,11,13,3,5,12};
        //Integer[] a = {4,2,1,1};
        HfmTree h = createHfmTree(a,a.length);
        h.doHierarchy();
        System.out.println();
        h.enCode(h.getRoot(),"");
    }
}
