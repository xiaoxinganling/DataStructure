package org.graph;

import org.queue.SeqQueue;

public class ExtMGraph extends MGraph {
    public ExtMGraph(int mSize) {
        super(mSize);
    }

    public void doDfs() {
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i])
                dfs(i, isVisited);
        }
    }

    private void dfs(int u, boolean[] isVisited) {
        System.out.print(u + " ");
        isVisited[u] = true;
        for (int j = 0; j < n; j++) {
            if (a[u][j] > 0 && a[u][j] < Integer.MAX_VALUE && !isVisited[j])
                dfs(j, isVisited);
        }
    }

    public void doBfs() {
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                bfs(i, isVisited);
            }
        }
    }

    private void bfs(int u, boolean[] isVisited) {
        SeqQueue sq = new SeqQueue(n);
        System.out.print(u + " ");
        isVisited[u] = true;
        sq.enQueue(u);
        while (!sq.isEmpty()) {
            Object o = sq.front();
            sq.deQueue();
            int index = Integer.valueOf(o.toString());
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && a[index][j]>0&&
                        a[index][j]<Integer.MAX_VALUE) {
                    System.out.print(j+" ");
                    isVisited[j] = true;
                    sq.enQueue(j);
                }
            }
        }
    }
}
