/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class Cliente {

    Socket socket = null;
    BufferedReader lector = null;
    PrintWriter escritor = null;

    public static void main(String[] args) {
        new Cliente();
    }

    public Cliente() {
        puerto();
    }

    public void leer() {
        Thread leerhilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while (true) {
                        //lo que envio el cliente lo leo y lo guardo
                        String mensajerecibido = lector.readLine();
                        System.out.println("Servidor " + mensajerecibido);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        });
        leerhilo.start();

    }

    public void escribir() {
        Thread escribirhilo = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner teclado = new Scanner(System.in);
                try {
                    //recibe el objeto para obtner la salida "a quien le quiero enviar"
                    escritor = new PrintWriter(socket.getOutputStream(), true);
                    String enviarmensaje = teclado.nextLine();
                    //para enviar mensaje
                    escritor.println(enviarmensaje);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //para ejecutar el hilo 
        escribirhilo.start();

    }

    public void puerto() {
        Thread escucha = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                   
                        //esta conectado por el puerto
                        socket = new Socket("localhost", 5002);

                        //siempre va aceptar las conexiones para este puerto
                        leer();
                        escribir();
                    

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //para ejecutar el hilo 
        escucha.start();

    }

}
