/**
 * 利用BinaryTree和PrioQueue实现哈夫曼树的构造
 */
package org.tree.hfmtree;

import org.tree.BTNode;
import org.tree.BinaryTree;

public class HfmTree extends BinaryTree {
    private Integer weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.valueOf(weight);
    }

    public void enCode(BTNode node,String cur)
    {
        if(node==null)
            return;
        if(node.getlChild()==null&&node.getrChild()==null){
            System.out.println(node.getElement()+": "+cur);
            return;
        }
        cur+="0";
        enCode(node.getlChild(),cur);
        cur = cur.substring(0,cur.length()-1);
        cur+="1";
        enCode(node.getrChild(),cur);
    }
}
