package com.company.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

    public static void main(String[] args){

        try{

            DatagramSocket ds = new DatagramSocket(7000);
            byte[] b = new byte[1024];

            DatagramPacket request = new DatagramPacket(b, b.length);
            ds.receive(request);

            String requestString = new String(request.getData());
            System.out.println("request from client: " + requestString);

            // sending response back

            byte[] buffer;

            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();

            String data = "Message from server!";
            buffer = data.getBytes();

            DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            ds.send(response);

            ds.close();


        }catch (Exception e){
            System.out.println("..." + e.getMessage());
        }

    }

}
