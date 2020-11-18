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
public class proceso2 implements Runnable {

    @Override
    public void run() {
       
        for (int i = 0; i < 10; i++) {
         
            System.out.println("implements Runnable " + i );
        }
    }

}
