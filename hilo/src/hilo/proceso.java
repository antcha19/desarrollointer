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
public class proceso extends Thread {

    int numerointer;
    public  proceso(String msg){
        super(msg);
    }

    @Override
    public void run() {

        for (int i = 0; i < numerointer; i++) {
            System.out.println(i + this.getName());
        }
       
    }
    
    public void valorcondicion(int valor){
        this.numerointer= valor;
    }

}
