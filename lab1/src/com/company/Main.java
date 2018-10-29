package com.company;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Main extends RecursiveTask<Long> {
    public static void main(String[] args) {

    }
    private int[] numbers = {1,2,3,4,5,6};
    private int start;
    private int end;

    public Main(int[] n, int s, int e) {
        this.numbers = n;
        this.start = s;
        this.end = e;
    }
    protected Long compute() {
        int mid = (start + end) >>> 1;
        ForkJoinTask<Long> t1 = new Main(numbers, start, mid);
        ForkJoinTask<Long> t2 = new Main(numbers, mid, end);
        t1.fork();
        t2.fork();
        long res = 0;
        if(t1.join() == 5)
            res = t1.join();
        else if(t2.join() == 5)
            res = t2.join();
        return res;
    }
}
