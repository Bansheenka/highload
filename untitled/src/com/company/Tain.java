package com.company;

import java.util.concurrent.ForkJoinPool;
import java.util.Scanner;

class Tain{

    public static void main(String[] args) {
        int find;
        int[] numb = {1, 2, 3, 4, 5, 6, 7};
        Scanner in = new Scanner(System.in);
        System.out.print("Введите искомое число: ");
        find = in.nextInt();
        int answer = new ForkJoinPool().invoke(new Task(0, 7, find, numb));
        if (answer == Integer.MIN_VALUE)
            System.out.println("Массив не содержит такого элемента");
    }

}
