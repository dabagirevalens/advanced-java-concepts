package com.company.socket;

import java.net.*;
import java.io.*;

public class Server
{

    public static void main(String[] args)
    {

        final  String green_bg = "\u001B[42m";
        final String ANSI_RESET = "\u001B[0m";
//        Server server = new Server(5000);

        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            Socket socket = serverSocket.accept();
            System.out.println("client connected ... ");

//          accept input from client
            DataInputStream fromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            String msgFromClient = "", msgToClient;

            while (!msgFromClient.equals("over")){
                try{
                    //read msg from client
                    msgFromClient = fromClient.readUTF();
                    System.out.println(green_bg + "New msg : " + msgFromClient + ANSI_RESET);

                    //send response to client
                    msgToClient = input.readLine();
                    outToClient.writeUTF(msgToClient);
                    outToClient.flush();
                }catch (Exception e){
                    System.out.println("receiving msg failed : " + e);
                }
            }


            fromClient.close();
            socket.close();
            serverSocket.close();

        }catch (Exception e){
            System.out.println("..." +e);
        }
    }
}