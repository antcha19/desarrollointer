
import java.io.*;
import java.net.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antcha
 */
public class DatagramSocketServer {

    DatagramSocket socket;

    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void runServer() throws IOException {
        byte[] receivingData = new byte[1024];
        byte[] sendingData;
        InetAddress clientIP;
        int clientPort = 5555;
        //el servidor atén el port indefinidament
        while (true) {
            //creacion del paquete
            DatagramPacket packet = new DatagramPacket(receivingData, 1024);
            //espera los datos
            socket.receive(packet);
            //procesamiento de los datos recibidos y obtención de la respuesta
            sendingData = processData(packet.getData(), packet.getLength());
            //obtencin de la direccion del cliente
            clientIP = packet.getAddress();
            //obtencidel puerto del cliente
            clientPort = packet.getPort();
            //creacion del paquete para enviar la  respuesta
            packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);
            //enviament de la resposta
            socket.send(packet);
        }

    }

    private byte[] processData(byte[] data, int length) {
        
        return null;

    }
}
