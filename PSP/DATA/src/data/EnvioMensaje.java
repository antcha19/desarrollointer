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
import java.util.Scanner;

/**
 *
 * @author antcha
 */

public class EnvioMensaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        //bytes del mensaje a enviar
        Scanner teclado = new Scanner(System.in);
        //variables
        String mensajeintroducido = "";
        System.out.println("Introduce el mensaje a enviar");
        mensajeintroducido = teclado.nextLine();

        byte[] mensaje = mensajeintroducido.getBytes();

        //ip de destino
        InetAddress ipdestino = InetAddress.getByName("localhost");
        //  InetAddress ipdestino = InetAddress.getByName("192.168.26.110");
        //puerto destino
        int portdestino = 2222;
        try {
            //creacion del paquete a enviar
            DatagramPacket packet = new DatagramPacket(mensaje, mensaje.length, ipdestino, portdestino);
            //creacion de un socket temporal con el que voy a realixar el envio
            DatagramSocket socket = new DatagramSocket();
            //enviar mensaje
            socket.send(packet);
        } catch (UnknownHostException ex) {
            System.out.println("error ex");
        } catch (SocketException soc) {
            System.out.println("error del socket");
        } catch (IOException io) {
            System.out.println("error del io");
        }
        // String str1 = new String(mensaje);
        //  System.out.println("mensaje enviado desde servidor "+str1);

    }

}
