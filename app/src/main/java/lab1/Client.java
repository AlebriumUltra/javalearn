/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1;

import java.io.*;
import java.net.*;

/**
 *
 * @author vlad
 */
public class Client {

    private String lowStep;
    private String highStep;
    private String integralStep;
    private String integralResult;

//    public String setCL(String low) {
//        this.lowStep = low;
//        return this.lowStep;
//    }
//
//    public String setCH(String high) {
//        this.highStep = high;
//        return this.highStep;
//    }
//
//    public String setCS(String step) {
//        this.integralStep = step;
//        return this.integralStep;
//    }
//    
//    public String setS(String S){
//       this.integralResult=S;
//       return this.integralResult;
//    }
    
    public String getRes(){
        return this.integralResult;
    }

    public void cln(String l, String h, String s) {
        String result;
        
        
        try {
            ServerSoket thread = new ServerSoket();
            thread.start();
            DatagramSocket aSocket = new DatagramSocket();
            String str = l + " " + h + " " + s;
            byte[] message = str.getBytes();
            InetAddress aHost = InetAddress.getByName("localhost");
            int sPort = 2100;
            DatagramPacket request = new DatagramPacket(message, message.length, aHost, sPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];

            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            result=new String(reply.getData(),0,reply.getLength());
            System.out.println("reply" + new String(reply.getData()));
            this.integralResult=result;
            aSocket.close();
        } catch (IOException e) {
            System.out.println("IO" + e.getMessage());
        }
         
    }
}
