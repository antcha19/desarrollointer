/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acomprin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Domain.*;
import datos.Conexion;
import java.sql.Connection;
import datos.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author antonio
 */
public class Acomprin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, SQLException {
        
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);

        // variables
        int opcion = 0;
        boolean salir = false;

        // menu
        while (!salir) {
            menu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    insertarwallet();
                    break;
                case 2:
                    selecwallet();
                    break;
                
                case 3:
                    recargarwallet();
                    
                    break;
                case 4:
                    insertarProducto();
                    break;
                case 5:
                    selecproducto();
                    break;
                
                case 6:
                    
                    break;
                
                case 7:
                    
                    break;
                
                case 8:
                
                case 9:
                    salir = true;
                    System.out.println("adios ");
                    break;
            }
            
        }
        
    }
    
    public static void menu() {
        System.out.println("1.agregar cliente a wallet");
        System.out.println("2.- consultar wallet");
        System.out.println("3-recargarwallet");
        System.out.println("4.-insertarproducto");
        System.out.println("5-select producto");
        System.out.println("6-Borrar coche");
        System.out.println("7-Actualizar coche");
        System.out.println("8-Listar propietarios y muestra sus coches");
        System.out.println("9-salir");
    }
    
    public static Date fechaintroducir() throws ParseException {
        Scanner teclado = new Scanner(System.in);
        String dateInString = "";
        // Usaremos el formato de fecha que necesitemos
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateInString = teclado.nextLine();

        // crear el objeto de tipo Date
        Date fecha = sdf.parse(dateInString);
        System.out.println(fecha);
        return fecha;
        
    }
    
    public static void insertarwallet() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        String nombre = "";
        String apellidos = "";
        String fechanacimiento;
        String dni = "";
        String email = "";
        
        try {
            
            Ewallet nuevawallet = new Ewallet();
            conexion = Conexion.getConnection();
            
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            EwalletDAO walletdao = new EwalletDAO(conexion);
            System.out.println("introduce nombre");
            nombre = teclado.nextLine();
            System.out.println("introduce apellido");
            apellidos = teclado.nextLine();
            System.out.println("dni");
            dni = teclado.nextLine();
            System.out.println("introduce fechanacimiento - yyyy-MM-dd");
            fechanacimiento = teclado.nextLine();

            //comprobamos si es mayor de 18
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNac = LocalDate.parse(fechanacimiento, fmt);
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fechaNac, ahora);
            System.out.printf("Tu edad es: %s años", periodo.getYears());
            if (periodo.getYears() < 18) {
                System.out.println("lo siento eres menor de edad");
                return;
            }
            // Usaremos el formato de fecha que necesitemos
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // crear el objeto de tipo Date
            Date fecha = sdf.parse(fechanacimiento);
            System.out.println();
            System.out.println("email");
            email = teclado.nextLine();
            //fecha sql
            java.sql.Date fechasql = new java.sql.Date(fecha.getYear(), fecha.getMonth(), fecha.getDay());
            nuevawallet = new Ewallet(nombre, apellidos, dni, fechasql, email, 0, 0);
            walletdao.insertarwallet(nuevawallet);
            System.out.println();
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
    public static void selecwallet() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        
        try {
            
            conexion = Conexion.getConnection();
            
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            EwalletDAO walletdao = new EwalletDAO(conexion);
            List<Ewallet> ewallet = walletdao.seleccionarwallet();
            ewallet.forEach(Ewallet -> {
                System.out.println("ewallet = " + Ewallet.toString());
            });
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    //2.	El cliente sólo puede hacer una recarga de saldo en euros entre el día 1 y 5 de cada mes. 
    public static void recargarwallet() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        java.util.Date fechaactual = new Date();
        
        if (fechaactual.getDay() > 1 & fechaactual.getDay() < 5) {
            try {
                
                conexion = Conexion.getConnection();
                
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                //recorro la lista para sacartodos los ewallet introducidos
                EwalletDAO walletdao = new EwalletDAO(conexion);
                List<Ewallet> ewallet = walletdao.seleccionarwallet();
                ewallet.forEach(Ewallet -> {
                    System.out.println("ewallet = " + Ewallet.toString());
                });
                
                System.out.println("cual id quieres actualizar");
                int id = teclado.nextInt();
                System.out.println("cual id quieres actualizar");
                int cantidadrecargar = teclado.nextInt();
                System.out.println("");
               Ewallet aux = ewallet.get(id);
               aux.setSaldoeuros(cantidadrecargar);
               walletdao.actualizarwallet(aux);
                 
                
                
                conexion.commit();
                System.out.println("se ha hecho commit de la transaccion");
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("entramos al rollback");
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
            }
        }
        
    }
    
    public static void insertarProducto() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        
        try {
            
            Producto productonuevo = new Producto();
            conexion = Conexion.getConnection();
            
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            ProductoDAO productodao = new ProductoDAO(conexion);
            System.out.println("introduce nombre producto");
            String nombre = teclado.nextLine();
            System.out.println("introduce precio prodcuto");
            int precioproducto = teclado.nextInt();
            System.out.println("puntos producto");
            int puntosproducto = teclado.nextInt();
            productonuevo = new Producto(nombre, precioproducto, puntosproducto);
            productodao.insertarproducto(productonuevo);
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
    public static void selecproducto() throws SQLException, ParseException {
        Connection conexion = null;
        Scanner teclado = new Scanner(System.in);
        
        try {
            
            conexion = Conexion.getConnection();
            
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //recorro la lista para sacartodos los ewallet introducidos
            ProductoDAO productodao = new ProductoDAO(conexion);
            List<Producto> productoslistas = productodao.seleccionarproducto();
            productoslistas.forEach(Producto -> {
                System.out.println("ewallet = " + Producto);
            });
            conexion.commit();
            System.out.println("e ha hecho commit de la transaccion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
    
}
