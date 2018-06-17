/**
 * 二叉平衡树结点类：search与二叉搜索树一致，此处不再赘述
 * insert函数为重点实现对象,delete函数由于过于复杂,此处不予实现
 */
package org.avltree;

import org.queue.SeqQueue;

public class AVLTree {
    private AVLNode root;
    private static boolean unBalanced = false;//默认它是平衡的
    public AVLNode getRoot() {
        return root;
    }
    private SeqQueue queue;
    public void setRoot(AVLNode root) {
        this.root = root;
    }
    public boolean doInsert(Object x)
    {
        return insert(null,root,x,false);
    }
    private boolean insert(AVLNode parent,AVLNode p,Object x,boolean isLeft)
    {
        boolean result = true;
        if(root==null)
        {
            root = new AVLNode();
            root.setElement(x);
            unBalanced = false;
        }
        else if(p==null)
        {
            p = new AVLNode();
            p.setElement(x);
            if(isLeft)
                parent.setlChild(p);
            else
                parent.setrChild(p);
            unBalanced = true;
        }
        else if(Double.valueOf(x.toString())<Double.valueOf(p.getElement().toString()))
        {
            result = insert(p,p.getlChild(),x,true);
            if(unBalanced)
            {
                if(p.getbF()==-1)
                {
                    p.setbF(0);
                    unBalanced = false;
                }
                else if(p.getbF()==0)
                {
                    p.setbF(1);
                }
                else
                {
                    p = lRotation(p);
                    if(parent==null)
                        root = p;
                    else
                    {
                        if(isLeft)
                            parent.setlChild(p);
                        else
                            parent.setrChild(p);
                    }
                }
            }
        }
        else if(Double.valueOf(x.toString())==Double.valueOf(p.getElement().toString()))
        {
            //重复元素插入失败
            unBalanced = false;
            return false;
        }
        else
        {
            result = insert(p,p.getrChild(),x,false);
            if(unBalanced)
            {
                if(p.getbF()==1)
                {
                    p.setbF(0);
                    unBalanced = false;
                }
                else if(p.getbF()==0)
                {
                    p.setbF(-1);
                }
                else
                {
                    p = rRotation(p);
                    if(parent==null)
                        root = p;
                    else
                    {
                        if(isLeft)
                            parent.setlChild(p);
                        else
                            parent.setrChild(p);
                    }
                }
            }
        }
        return result;
    }
    private AVLNode lRotation(AVLNode s)
    {
        AVLNode u;
        AVLNode r = s.getlChild();//L
        if(r.getbF()==1)
        {
            //LL
            s.setlChild(r.getrChild());
            r.setrChild(s);
            s.setbF(0);
            s = r;
        }
        else
        {
            //LR
            u = r.getrChild();
            r.setrChild(u.getlChild());
            u.setlChild(r);
            s.setlChild(u.getrChild());
            u.setrChild(s);
            if(u.getbF()==1)
            {
                s.setbF(-1);
                r.setbF(0);
            }
            else if(u.getbF()==-1)
            {
                s.setbF(0);
                r.setbF(1);
            }
            else
            {
                s.setbF(0);
                r.setbF(0);
            }
            s = u;
        }
        s.setbF(0);
        unBalanced = false;
        return s;
    }
    private AVLNode rRotation(AVLNode s)
    {
        AVLNode u;
        AVLNode r = s.getrChild();//R
        if(r.getbF()==-1)
        {
            //RR
            s.setrChild(r.getlChild());
            r.setlChild(s);
            s.setbF(0);
            s = r;
        }
        else
        {
            //RL
            u = r.getlChild();
            r.setlChild(u.getrChild());
            u.setrChild(r);
            s.setrChild(u.getlChild());
            u.setlChild(s);
            if(u.getbF()==1)
            {
                s.setbF(0);
                r.setbF(-1);
            }
            else if(u.getbF()==-1)
            {
                s.setbF(1);
                r.setbF(0);
            }
            else
            {
                s.setbF(0);
                r.setbF(0);
            }
            s = u;
        }
        s.setbF(0);
        unBalanced = false;
        return s;
    }
    public void doHierarchy(){
        queue = new SeqQueue(getSize());
        queue.enQueue(root);
        hierarchy();
    }
    private void hierarchy()
    {
        while(!queue.isEmpty())
        {
            AVLNode parent = (AVLNode) queue.front();
            System.out.print(parent.getElement()+" ");
            AVLNode left = parent.getlChild();
            AVLNode right = parent.getrChild();
            if(left!=null)
                queue.enQueue(left);
            if(right!=null)
                queue.enQueue(right);
            queue.deQueue();
        }
    }
    public int getSize()
    {
        return size(root);
    }
    private int size(AVLNode root)
    {
        if(root==null)
            return 0;
        return size(root.getlChild())+size(root.getrChild())+1;
    }
    public void doInOrder()
    {
        inOrder(root);
    }
    private void inOrder(AVLNode root)
    {
        if(root==null)
            return;
        inOrder(root.getlChild());
        System.out.print(root.getElement().toString()+" ");
        inOrder(root.getrChild());
    }
}
