package com.chengong.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by cheng on 3/3/2017.
 */
public class H502IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        MyComparator comp = new MyComparator();
        MyComparator2 comp2 = new MyComparator2();
        PriorityQueue<Project> q = new PriorityQueue<Project>(comp);
        for (int i = 0; i < Profits.length; i++) {
            q.add(new Project(Profits[i], Capital[i]));
        }
        int w = W;
        PriorityQueue<Project> pq = new PriorityQueue<Project>(comp2);
        for (int i = 0; i < k; i++) {
            while(!q.isEmpty() && q.peek().c <= w) {
                pq.add(q.poll());
            }
            if (pq.isEmpty()) break;
            w = w + pq.peek().p;
            pq.remove();
        }
        return w;
    }

    class MyComparator implements Comparator<Project> {
        public int compare(Project left, Project right) {
            return left.c - right.c;
        }
    }

    class MyComparator2 implements Comparator<Project> {
        public int compare(Project left, Project right) {
            return right.p - left.p;
        }
    }

    class Project {
        int p;
        int c;
        public Project(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        H502IPO sol = new H502IPO();
        int rst =sol.findMaximizedCapital(2, 0, new int[] {1,2,3}, new int[] {0,1,1});
        System.out.print(rst);
    }
}
