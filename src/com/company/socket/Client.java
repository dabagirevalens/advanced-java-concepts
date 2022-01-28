package com.company.socket;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        final  String white_bg = "\u001B[47m";
        final String ANSI_RESET = "\u001B[0m";
        final String black_color ="\u001B[30m";
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
                    System.out.println(white_bg + black_color + "New reply : " + msgFromServer + ANSI_RESET);

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