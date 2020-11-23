/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.util.Random;

/**
 *
 * @author antcha
 */
public class Persona {
    private String nombre="";
    private int edad=0;
    private String DNI="";
    private char sexo;
    private double peso=0;
    private double altura=0;
    
    
    public Persona(){
        this.nombre=nombre;
        this.edad=edad;
        this.DNI=generaDNI();
        this.sexo=comprobarSexo(sexo);
        this.peso=peso;
        this.altura=altura;
    }
    
   
    public Persona(String nombre,int edad, char sexo){
        this.nombre=nombre;
        this.edad=edad;
        this.DNI=generaDNI();
        this.sexo=comprobarSexo(sexo);
        this.peso=peso;
        this.altura=altura;
    }
    
    
    public Persona(String nombre,int edad, char sexo, double peso,double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.DNI=generaDNI();
        this.sexo=comprobarSexo(sexo);
        this.peso=peso;
        this.altura=altura;
    }
    
    public boolean esMAyorDeEdad() {
        boolean mayor= false;
        if(edad >= 18){
            mayor = true;
        }else{
            mayor = false;
        }
        return mayor;
    }
    public char comprobarSexo(char sexo){
        /*comprueba que el sexo introducido es
            correcto. Si no es correcto, sera H. No sera visible al exterior*/
        if(sexo!='H' && sexo!= 'M' ){
            sexo = 'H';
        }else{
            sexo= sexo;
        }
       
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public String generaDNI(){
        Random aleatorio = new Random();
        String resultado;
         char [] letras = {'A','B','C','D','E','F','G','H','I','J',
            'K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
         int numaleatorios = aleatorio.nextInt(90000000) + 1;
         int resto = 0;
        resto = numaleatorios%23;
         System.out.println("Su numero de Dni es " + numaleatorios+letras[resto] );
         resultado = Integer.toString(resto) + letras[resto];
         return  resultado;
    }
    
    
     @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura + '}';
    }
    public double calcularIMC(){
        double resultado = 0;
        double respuesta = 0;
        resultado = (peso / (altura*altura));
        if(resultado<20){
            respuesta = -1;
        }else if(resultado>=20 && resultado<=25){
            respuesta = 0;
        }else if (resultado>25){
            respuesta = 1;
        }
        return respuesta;
    }
    
    
}
