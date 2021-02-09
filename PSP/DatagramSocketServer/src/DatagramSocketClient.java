
import java.io.IOException;
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
public class DatagramSocketClient {

    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;

    public void init(String host, int port) throws SocketException,
            UnknownHostException {
        serverIP = InetAddress.getByName("localhost");
        serverPort = 5555;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte[] receivedData = new byte[1024];
        byte[] sendingData;
        //inicio
        sendingData = getFirstRequest();
        //el servidor atén el port indefinidament
        while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData,
                    sendingData.length, serverIP, serverPort);
            //enviando la respuesta
            socket.send(packet);
            //creacion del paquete para  recibir los datos
            packet = new DatagramPacket(receivedData, 1024);
            //espera los datos
            socket.receive(packet);
            // procesamiento de los datos recibidos y obtención de la respuesta
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }
    }

    private byte[] getDataToRequest(byte[] data, int length) {


    }

    private byte[] getFirstRequest() {
   
    }

    private boolean mustContinue(byte[] sendingData) {
       
    }


}
