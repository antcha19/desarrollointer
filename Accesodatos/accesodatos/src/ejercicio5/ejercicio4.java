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
public class ejercicio4 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);

        int numero;
        int contador = 0;
        System.out.println("introduce el numero");
        numero = teclado.nextInt();
        while (numero > 0) {
            contador++;
            System.out.println(contador + "\t" + contador * 2 + "\t" + contador * 3);
            if (contador > numero) {
                break;
            }
        }

    }

}
