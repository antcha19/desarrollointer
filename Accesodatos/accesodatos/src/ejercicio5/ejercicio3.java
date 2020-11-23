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
public class ejercicio3 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);

        //variable
        int numero = 0;

        System.out.println("Introduce numero ");
        numero = teclado.nextInt();
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                System.out.println(i);
            }
        }
    }

}
