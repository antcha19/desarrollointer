/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenejoCoches;

//importamos librerias
import datos.CochesDAO;
import domain.Coches;
import datos.PropietariosDAO;
import domain.Propietarios;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class main {

    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);

        PropietariosDAO propietarioDAO = new PropietariosDAO();
        CochesDAO cochesDAO = new CochesDAO();

        // variables
        int opcion = 0;
        boolean salir = false;
        String Dni = "";
        String marca = "";
        int precio = 0;
        String matricula = "";
        String nombre = "";
        int edad = 0;
        String compruebar;
        String dnipropietario;
        boolean encontradopropietario = false;

        List<Propietarios> propietario = propietarioDAO.seleccionarpropietarios();
        List<Coches> coche = cochesDAO.seleccionarcoches();

        // menu
        while (!salir) {
            menu();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("propietarios");
                    propietario.forEach(Propietarios -> {
                        System.out.println("propietarios = " + Propietarios);
                    });
                    System.out.println("Coches");

                    coche.forEach(Coches -> {
                        System.out.println("coches =  " + Coches);
                    });
                    break;
                case 2:
                    System.out.println("introduce DNI");
                    Dni = teclado.nextLine();
                    System.out.println("introduce nombre");
                    nombre = teclado.nextLine();
                    System.out.println("introduce edad");
                    edad = teclado.nextInt();
                    Propietarios propietarios = new Propietarios(Dni, nombre, edad);
                    propietarioDAO.insertar(propietarios);
                    break;

                case 3:
                    Propietarios borrarp = null;
                    System.out.println("Introduzca el dni ");
                    Dni = teclado.nextLine();

                    for (Propietarios pro : propietario) {
                        compruebar = pro.getIdDNI();
                        if (compruebar.equalsIgnoreCase(Dni) == true) {
                            borrarp = pro;
                            encontradopropietario = true;
                            break;
                        }
                    }
                    if (encontradopropietario == false) {
                        System.out.println("No se ha encontrado ");
                    } else {
                        for (Coches co : coche) {
                            compruebar = co.getDNI();
                            if (compruebar.equalsIgnoreCase(Dni) == true) {
                                cochesDAO.borrar(co);
                            }
                        }
                        propietarioDAO.borrarpro(borrarp);
                    }

                    break;
                case 4:
                    System.out.println("introduce DNI");
                    Dni = teclado.nextLine();
                    System.out.println("introduce nombre");
                    nombre = teclado.nextLine();
                    System.out.println("introduce edad");
                    edad = teclado.nextInt();
                    Propietarios propietariosupdate = new Propietarios(Dni, nombre, edad);
                    propietarioDAO.actualizarpropietarios(propietariosupdate);
                    break;
                case 5:
                    
                    System.out.println("Introduzca el dni ");
                    Dni = teclado.nextLine();

                    for (Propietarios pro : propietario) {
                        compruebar = pro.getIdDNI();
                        if (compruebar.equalsIgnoreCase(Dni) == true) {
                            System.out.println("introduzca matricula  ");
                            matricula = teclado.nextLine();
                            System.out.println("introduzca  marca ");
                            marca = teclado.nextLine();
                            System.out.println("introduzca precio ");
                            precio = teclado.nextInt();
                            
                            Coches insertarcoche = new Coches(matricula, marca, precio,Dni);
                            cochesDAO.insertar(insertarcoche);
                            encontradopropietario = true;

                            break;
                        }
                    }
                    if (encontradopropietario == false) {
                        System.out.println("No se ha encontrado ");
                    }


                    break;

                case 6:
                    System.out.println("introduzca matricula  ");
                    matricula = teclado.nextLine();
                    Coches cocheborrar = new Coches(matricula);
                    cochesDAO.borrar(cocheborrar);
                    break;

                case 7:
                    System.out.println("introduzca matricula  ");
                    matricula = teclado.nextLine();
                    System.out.println("introduzca  marca ");
                    marca = teclado.nextLine();
                    System.out.println("introduzca precio ");
                    precio = teclado.nextInt();
                    Coches cocheupdate = new Coches(matricula, marca, precio);
                    cochesDAO.actualizar(cocheupdate);
                    break;

                case 8:
                    System.out.println("Introduzca el dni ");
                    dnipropietario = teclado.nextLine();
                    for (Propietarios pro : propietario) {
                        compruebar = pro.getIdDNI();
                        if (compruebar.equalsIgnoreCase(dnipropietario) == true) {
                            System.out.println(pro);
                            break;
                        }
                    }
                    for (Coches c : coche) {
                        compruebar = c.getDNI();
                        if (compruebar.equalsIgnoreCase(dnipropietario) == true) {
                            System.out.println(c);
                        }
                    }

                    break;

                case 9:
                    salir = true;
                    System.out.println("adios ");
                    break;
            }

        }

    }

    public static void menu() {
        System.out.println("1.- Muestra propietarios y coches");
        System.out.println("2-Inserta propietario");
        System.out.println("3-Borrar propietarios");
        System.out.println("4-Actualizar propietario");
        System.out.println("5-Insertar coche");
        System.out.println("6-Borrar coche");
        System.out.println("7-Actualizar coche");
        System.out.println("8-Listar propietarios y muestra sus coches");
        System.out.println("9-salir");
    }

}
