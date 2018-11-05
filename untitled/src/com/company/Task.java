package com.company;

import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Integer> {
    private static int THRESHOLD = 2;
    private int start;
    private int end;
    private int find;
    private int[] numb;

    public Task(int start, int end, int find, int[] numb) {
        this.start = start;
        this.end = end;
        this.find = find;
        this.numb = numb;
    }
    @Override
    protected Integer compute() {
        int length = end - start;
        if (length < THRESHOLD) {
            return computeDirectly();
        }
        int offset = length / 2;
        Task left = new Task(start, start + offset, find, numb);
        left.fork();
        Task right = new Task(start + offset, end,find, numb);
        return findDigit(right.compute(), left.join());
    }

    private Integer findDigit(Integer right, Integer left) {
        if (right.equals(find))
            return right;
        if (left.equals(find))
            return left;
        else return Integer.MIN_VALUE;
    }

    private Integer computeDirectly() {
        int digit = 0;
        for (int i = start; i < end; i++) {
            if (numb[i] == find) {
                digit = numb[i];
                System.out.println(digit + " найдена, она находится на " + (i+1) + " позиции");
                break;
            }
        }
        return digit;
    }
}
