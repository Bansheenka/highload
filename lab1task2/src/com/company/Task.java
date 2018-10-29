package com.company;

public class Task implements Runnable{
    int el;
    int find;
    int i;
    BoolPointer flag;

    public Task(int el, int find, int i, BoolPointer flag) {
        this.el = el;
        this.find = find;
        this.i = i;
        this.flag = flag;
    }

    @Override
    public void run() {
        if(el == find)
        {
            flag.value = true;
            System.out.println(el + " находится на " + (i+1) + " позиции");
        }
    }
}
