package com.company.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void  main(String[] args){

        ServerSocket serverSocket = null;

        try{

            serverSocket = new ServerSocket(5000);

            System.out.println("Server started");
            System.out.println("Waiting for a client ...");

            serverSocket.setReuseAddress(true);

            // run infinite loop to receive incoming clints
            while (true){
                Socket client = serverSocket.accept();

                System.out.println("New client connected : "+ client.getInetAddress().getHostAddress() + "  ");

                // create new thread object
                ClientHandler clientSocket = new ClientHandler(client);

                // this will handler the new incoming client
                new Thread(clientSocket).start();
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                }catch (IOException e){
                    System.out.println(".." + e.getMessage());
                }
            }
        }
    }

//    client handler class

    private static  class ClientHandler implements  Runnable{
        private final Socket clientSocket;

        public  ClientHandler(Socket socket){
            this.clientSocket = socket;
        }

        public void run(){

            try{

                DataInputStream fromClient = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

                String msgFromClient = "", msgToClient;

                while (!msgFromClient.equals("over")){
                    try{
                        //read msg from client
                        msgFromClient = fromClient.readUTF();
                        System.out.println("New msg : " + msgFromClient);

                        //send response to client
                        msgToClient = input.readLine();
                        outToClient.writeUTF(msgToClient);
                        outToClient.flush();

                    }catch (Exception e){
                        System.out.println("receiving msg failed : " + e);
                    }
                }

            }catch (IOException e){
                System.out.println(" .." + e.getMessage());
            }
        }
    }
}
