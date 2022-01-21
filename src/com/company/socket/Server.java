package com.company.socket;

import java.net.*;
import java.io.*;

public class Server
{

    public static void main(String[] args)
    {
//        Server server = new Server(5000);

        try{
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            Socket socket = serverSocket.accept();
            System.out.println("client connected ... ");

//          accept input from client
            DataInputStream fromClient = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(System.in);

            String line = " ";

            while (!line.equals("over")){
                try{
                    line = fromClient.readUTF();
                    System.out.println("New msg : " + line);
                }catch (Exception e){
                    System.out.println("receiving msg failed : " + e);
                }
            }

            String msg = " ";

            while (!msg.equals("end")){
                try {
                    msg = input.readLine();
                    outToClient.writeUTF(msg);
                }catch (Exception e){
                    System.out.println("something went wrong ..."+ e.getMessage());
                }
            }

            outToClient.writeUTF("hello this is server");

            socket.close();
            fromClient.close();
            outToClient.close();

        }catch (Exception e){
            System.out.println("..." +e);
        }
    }
}