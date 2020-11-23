/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author antcha
 */
public class Cuenta {

    private String titular = "";
    private double cantidad = 0;

    //constructor1 opcional con cantidad opcional
    public Cuenta(String titular) {
        this.titular = titular;
    }

    //
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "titular=" + titular + ", cantidad=" + cantidad + '}';
    }

    public void ingresar(double ingresar) {
        /*se ingresa una cantidad a la cuenta, si la
cantidad introducida es negativa, no se hará nada.*/
        if (ingresar > 0) {
            this.cantidad = cantidad + ingresar;
        } else {
            System.out.println("cantidad +");
        }
    }

    public void retirar(double retirar) {
        /*se retira una cantidad a la cuenta, si restando la
            cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta
                pasa a ser 0.*/
        if (retirar < cantidad) {
            this.cantidad = cantidad - retirar;
        } else if (retirar > cantidad) {
            this.cantidad = 0;
        }

    }

}
