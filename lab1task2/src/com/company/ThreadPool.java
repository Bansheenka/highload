package com.company;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool{

    static int[] mass = {1,2,3,4,5,6,7};
    static int find;
    public static BoolPointer gotIt = new BoolPointer(false);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите искомое число: ");
        find = in.nextInt();
        in.close();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        for(int i = 0; i < mass.length; i++)
        {
            Task task = new Task(mass[i], find, i, gotIt);
            executor.execute(task);
        }
        executor.shutdown();
        if(!gotIt.value)
            System.out.print("Массив не содержит такого числа\n");

    }
}

class BoolPointer
{
    boolean value;
    public BoolPointer(boolean val)
    {
        this.value = val;
    }
}