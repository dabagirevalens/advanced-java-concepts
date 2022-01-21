package com.company.socket;


import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        try {

            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Connected to server ...");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(System.in);

            DataInputStream fromServer = new DataInputStream(socket.getInputStream());

            String line = " ";

            while (!line.equals("over")){
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                }catch (Exception e){
                    System.out.println("something went wrong ..."+ e.getMessage());
                }
            }

            // get response from client
            String msg = " ";

            while (!msg.equals("end")){
                try{
                    msg = fromServer.readUTF();
                    System.out.println("New res : " + msg);
                }catch (Exception e){
                    System.out.println("receiving res failed : " + e);
                }
            }


            try{
                socket.close();
                out.close();
                input.close();
            }catch (Exception e){
                System.out.println("Failed ... "+ e.getMessage());
            }

        }catch (Exception e){
            System.out.println(".. " + e);
        }
    }

}