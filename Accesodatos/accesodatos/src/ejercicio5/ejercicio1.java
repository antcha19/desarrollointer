/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class ejercicio1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        //variables
        int tipo = 1;
        System.out.println("Conductores tipo 1: autobús, taxi, ambulancia");
        System.out.println("Conductores tipo 2: ciclistas");
        System.out.print("Introduce tipo de conductor ");
        tipo = teclado.nextInt();

        if (tipo == 1) {
            System.out.println("La tasa de alcohol es 0,3 ");
        }
        if (tipo == 2) {
            System.out.println("La tasa de alcohol  es de 0,5.");
        }
    }

}
