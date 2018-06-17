/**
 * 二叉搜索树实现
 */
package org.searchtree;

import org.queue.SeqQueue;
import org.tree.BTNode;

public class BSTree {
    private BTNode root;
    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }
    public boolean search(Object x)
    {
        BTNode p = root;
        while(p!=null)
        {
            if(Double.valueOf(x.toString())<
                    Double.valueOf(p.getElement().toString()))
            {
                p = p.getlChild();
            }
            else if(Double.valueOf(x.toString())>
                    Double.valueOf(p.getElement().toString()))
            {
                p = p.getrChild();
            }
            else
            {
                return true;
            }
        }
        return false;
    }
    public boolean insert(Object x)
    {
        BTNode node = new BTNode(x);
        //考虑空二叉树的情况
        if(root==null)
        {
            root = node;
            return true;
        }
        BTNode p = root;
        BTNode q = null;
        while(p!=null)
        {
            q = p;
            if(Double.valueOf(x.toString())<
                    Double.valueOf(p.getElement().toString()))
            {
                p = p.getlChild();
            }
            else if(Double.valueOf(x.toString())>
                    Double.valueOf(p.getElement().toString()))
            {
                p = p.getrChild();
            }
            else
            {
                return false;//有重复的不再插入
            }
        }
        if(Double.valueOf(x.toString())<
                Double.valueOf(q.getElement().toString()))
            q.setlChild(node);
        else
            q.setrChild(node);
        return true;
    }
    public boolean delete(Object x)
    {
        BTNode p = root;
        BTNode q = null;
        while(p!=null&&!(p.getElement().equals(x)))
        {
            q = p;
            if(Double.valueOf(x.toString())<
                    Double.valueOf(p.getElement().toString()))
            {
                p = p.getlChild();
            }
            else
                p = p.getrChild();
        }
        //1.没有该元素,p为null
        if(p==null)
            return false;
        //2.p既有左孩子又有右孩子
        if(p.getlChild()!=null&&p.getrChild()!=null)
        {
            //找p的右子树的最左结点s,同时还有s的双亲结点r,因为找到之后把s替换到要删除的元素的位置
            //删除该节点的情况就变为了第3种情况:p只有一个孩子
            BTNode s = p.getrChild();
            BTNode r = null;
            while(s.getlChild()!=null)
            {
                r = s;
                s = s.getlChild();
            }
            p.setElement(s.getElement());
            p = s;
            q = r;//转到第三种情况
        }
        //3.p只有左孩子或者右孩子
        BTNode child = null;//记录下自己的孩子
        if(p.getlChild()!=null)
            child = p.getlChild();
        if(p.getrChild()!=null)
            child = p.getrChild();
        //p是根结点的话,q==null
        if(p.equals(root))
            root = child;
        //p不是根结点,判断p是q的左孩子还是右孩子
        if(q.getlChild().equals(p))
            q.setlChild(child);
        else
            q.setrChild(child);
        //p = null;c语言中需要delete,java中的话让p自生自灭吧
        return true;

    }
    public void show(BTNode node)
    {
        if(node!=null)
        {
            show(node.getlChild());
            System.out.print(node.getElement()+" ");
            show(node.getrChild());
        }
    }
}
