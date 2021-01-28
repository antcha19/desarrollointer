/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author antcha
 */
public class RecepcionMensaje {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        //puerto que escucha el servicio
        try {
            int puertoescucha = 5555;
            //vector de bytes en el cual recibir el mensaje con capacidad de 1.024 bytes
            byte[] mensaje = new byte[1024];
            //creacion del paquete en el qual rebre les dades de 1.024 bytes 
            DatagramPacket packet = new DatagramPacket(mensaje, mensaje.length);
            //creació d’un socket que escolti el port passat per paràmetre
            DatagramSocket socket = new DatagramSocket(puertoescucha);
            //recibe el paquete
            socket.receive(packet);

            //mensaje traducido
            String traducido = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Mensaje recibido  " + traducido);
        } catch (UnknownHostException ex) {
            System.out.println("error ex");
        } catch (SocketException soc) {
            System.out.println("error del socket");
        } catch (IOException io) {
            System.out.println("error del io");
        }

    }

}
