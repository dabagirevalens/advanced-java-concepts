package com.company.socket;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        final  String green_bg = "\u001B[42m";
        final String ANSI_RESET = "\u001B[0m";
        try {

            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server ...");

            DataInputStream fromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            String msgToServer = " ", msgFromServer;

            while (!msgToServer.equals("over")){
                try {

                    //send msg
                    msgToServer = input.readLine();
                    toServer.writeUTF(msgToServer);
                    toServer.flush();

                    //read response
                    msgFromServer = fromServer.readUTF();
                    System.out.println(green_bg + "New reply : " + msgFromServer + ANSI_RESET);

                }catch (Exception e){
                    System.out.println("something went wrong ..."+ e.getMessage());
                }
            }

            toServer.close();
            socket.close();

        }catch (Exception e){
            System.out.println(".. " + e);
        }
    }

}