package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static int find = 5;
    public static long finish = 0;
    public static long start = 0;
    public static String entry;

    public static void main(String[] args){
        try (ServerSocket server = new ServerSocket(3360)){
            Socket client = server.accept();
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            out.writeUTF("Enter the number\n");
            start = System.currentTimeMillis();
            while(!client.isClosed()){
                entry = in.readLine();
                if(entry.equalsIgnoreCase("quit")){
                    out.flush();
                    quit();
                }
                else if(Integer.parseInt(entry) > find)
                    out.writeUTF("The number is less then entered\n");
                else if(Integer.parseInt(entry) < find)
                    out.writeUTF("The number is more then entered\n");
                else if(Integer.parseInt(entry) == find) {
                    finish = System.currentTimeMillis();
                    long time = finish - start;
                    out.writeUTF("The number is found in " + time + " milliseconds\n");
                    quit();
                }
                out.flush();
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quit() {System.exit(0);}
}