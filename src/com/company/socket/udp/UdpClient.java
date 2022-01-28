package com.company.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    public static void main(String[] args){

        try{
            DatagramSocket ds = new DatagramSocket();
            String requestString = "client request";
            byte[] requestBytes = requestString.getBytes();

            InetAddress ip = InetAddress.getLocalHost();

            DatagramPacket  dp = new DatagramPacket(requestBytes, requestBytes.length, ip, 7000);
            ds.send(dp);

            // server response
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length, ip, 7000);
            ds.receive(response);

            String serverResponse = new String(response.getData());

            System.out.println("server response : "+ serverResponse);

            ds.close();

        }catch (Exception e){
            System.out.println("..."+ e.getMessage());
        }

    }

}
