/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.*;

public class ejercicio6 {

    public static void main(String[] args) {

        Random naleatorio = new Random();
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0;
        int matriz[][] = new int[18][10];
        int numero;
        int suma = 0;

        while (!salir) {
            System.out.println("1.Almacenar");
            System.out.println("2.Revisar");
            System.out.println("3.Suma total");
            System.out.println("4.salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:

                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[j].length; j++) {
                            numero = naleatorio.nextInt(50)+1;
                            matriz[i][j] = numero;
                            System.out.print(matriz[i][j] + "\t");
                        }
                        System.out.println("");
                    }
                    break;
                    
                case 2:
                    int posicionI = 0;
                    int posicionJ = 0;
                    int valor = 0;
                    System.out.println("posicion I");
                    posicionI = teclado.nextInt();
                    System.out.println("posicion J");
                    posicionJ = teclado.nextInt();
                    System.out.println("numero a revisar");
                    valor = teclado.nextInt();
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[j].length; j++) {
                            matriz[posicionI][posicionJ] = valor;
                            System.out.print(matriz[i][j] + "\t");
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            suma = suma + matriz[i][j];
                        }
                    }
                    System.out.println("la suma es " + suma);
                    System.out.println("");
                    break;
                case 4:
                    salir = true;

                    break;

            }
        }

    }

}
