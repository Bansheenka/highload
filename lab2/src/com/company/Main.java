package com.company;

public class Main {
    public static void main(String[] args) {
        try {
            Server socketServer = new Server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}