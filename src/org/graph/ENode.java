/**
 * 边结点类,包括adjVex(边尾的下标),w(权值),nextArc(下一个边界点)
 */
package org.graph;

public class ENode {
    private int adjVex;
    private int w;
    private ENode nextArc;

    public ENode(int adjVex, int w, ENode nextArc) {
        this.adjVex = adjVex;
        this.w = w;
        this.nextArc = nextArc;
    }

    public int getAdjVex() {
        return adjVex;
    }

    public void setAdjVex(int adjVex) {
        this.adjVex = adjVex;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public ENode getNextArc() {
        return nextArc;
    }

    public void setNextArc(ENode nextArc) {
        this.nextArc = nextArc;
    }
}
