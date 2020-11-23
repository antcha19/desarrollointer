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
public class ejercicio2 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        
        int lado1;
        int lado2;
        int lado3;
        int suma,suma2,suma3;
        
        System.out.println("introduce los lados de un triangulo");
        System.out.println("lado numero 1");
        lado1 = teclado.nextInt();
        System.out.println("lado numero 2");
        lado2 = teclado.nextInt();
        System.out.println("lado numero 3");
        lado3 = teclado.nextInt();
        suma =lado1+lado2;
        suma2 =lado1+lado3;
        suma3=lado2+lado3;
        if(suma > lado3 && suma2>lado2  && suma3>lado1){
            System.out.println("es un triangulo");
        }
       else{
            System.out.println("no es un triangulo");
        }
        
    }
    
}
