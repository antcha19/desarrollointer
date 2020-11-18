/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilo;

/**
 *
 * @author antonio
 */
public class Hilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       
        proceso hilo = new proceso(" hilo 1");
        proceso hilo3 = new proceso(" hilo 2");
        Thread hilo2 = new Thread(new proceso2());
        
        hilo.valorcondicion(5);
        hilo3.valorcondicion(5);
        hilo.start();
        hilo2.start();
        hilo3.start();
        
        
        
    }

}
