/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Random;

/**
 *
 * @author antcha
 */
public class Ejercicio5 {

    
    public static void main(String[] args) {
        // TODO code application logic here

        Random naleatorio = new Random();
        int[] carton = new int [15];
        
        for (int i = 0; i < carton.length; i++) {
            //numero aleatorio eentre 1-90
             int valorDado = naleatorio.nextInt(90) + 1;
             System.out.print((carton[i] = valorDado) + " ");   
        }
    }

}
