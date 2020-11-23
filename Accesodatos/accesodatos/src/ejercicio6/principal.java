/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.util.Scanner;

/**
 *
 * @author antcha
 */
public class principal {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        //variables
        String nombre="";
        int edad=0;
        char sexo='H';
        double peso, altura;
        
        System.out.println("Introduce nombre");
        nombre = teclado.nextLine();
        System.out.println("Introduce edad");
        edad = teclado.nextInt();
        System.out.println("Introduce sexo");
        sexo = teclado.next().charAt(0);
        System.out.println("Introduce peso");
        peso = teclado.nextDouble();
        System.out.println("Introduce altura");
        altura = teclado.nextDouble();
        //creo 3 objetos
        Persona persona = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        /*creo un objeto anadiendo los valores con los metodos set*/
        Persona persona3= new Persona();
        persona3.setNombre("pepito");
        persona3.setEdad(19);
        persona3.setSexo('H');
        persona3.setPeso(64.6);
        persona3.setAltura(76);
        
        //CALCULAR IMC
        System.out.println(persona.calcularIMC());
       System.out.println(persona2.calcularIMC());
       System.out.println(persona3.calcularIMC());
       
       //CALCULAR SI ES MAYOR DE EDAD
       System.out.println(persona.esMAyorDeEdad());
       System.out.println(persona2.esMAyorDeEdad());
       System.out.println(persona3.esMAyorDeEdad());
       //MUESTRO TODA LA INFORMACION
       System.out.println(persona.toString());
       System.out.println(persona2.toString());
       System.out.println(persona3.toString());
        
    }
    
}
