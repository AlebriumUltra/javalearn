package lab1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vlad
 */
public class ServerSoket extends Thread {

    public ArrayList<RecIntegral> integralList = new ArrayList<>();
    DatagramSocket aSocket = null;
    String values[];

    public void run() {
        try {
            aSocket = new DatagramSocket(2100);
            byte[] buffer = new byte[1000];
            byte[] temp = new byte[1000];
            byte[] byteArray;
            String result;
            String[] values;
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);

                temp = request.getData();
                result = new String(temp, 0, temp.length);
                values = result.split(" ");
                System.out.println(values);
                integralList.add(0, new RecIntegral(values[0], values[1], values[2]));
                integralList.get(0).integralCalculate();
                result = integralList.get(0).getIntegralResult();
                byteArray = result.getBytes();
                DatagramPacket reply = new DatagramPacket(byteArray, request.getLength(), request.getAddress(), request.getPort());

                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());

        } catch (NumException ex) {
            System.out.println("Socket:" + ex.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
