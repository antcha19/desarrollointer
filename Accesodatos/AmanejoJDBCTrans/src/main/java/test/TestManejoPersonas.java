/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.Conexion;
import java.sql.*;
import datos.PersonaDAO;
import domain.Persona;

/**
 *
 * @author antcha
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {

        //declaramos e inicializamos la varibale conexion
        Connection conexion = null;
        conexion = Conexion.getConnection();
        if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
        }
        PersonaDAO personaDao = new PersonaDAO(conexion);
        Persona nuevapersona = new Persona("qqqqqqqq", "qqqqq", 404);
        personaDao.insertar(nuevapersona);
        conexion.rollback();

//     try {
//
//            Persona nuevaPersona = new Persona();
//            conexion = Conexion.getConnection();
//
//            if (conexion.getAutoCommit()) {
//                conexion.setAutoCommit(false);
//            }
//                PersonaDAO personaDao = new PersonaDAO(conexion);
//                Persona nuevapersona = new Persona("nodeberia", "tttttttttteee", 404);
//                personaDao.insertar(nuevapersona);
//
//                Persona nuevapersona1 = new Persona("antoniooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", "perdghjdghasdfez", 44);
//                personaDao.insertar(nuevapersona1);
//
//
//                /*     Persona cambioPersona = new Persona();
//            cambioPersona.setIdPersona(9);
//            cambioPersona.setIdPersona(1);
//            cambioPersona.setNombre("dfgasdg");
//            cambioPersona.setApellidos("Gorthwertymez");
//            cambioPersona.setEdad(23);
//            personaDao.actualizar(cambioPersona);*/
////            Persona borrarpersona = new Persona();
////            borrarpersona.setIdPersona(5);
////            personaDao.borrar(borrarpersona);
//                conexion.commit();
//                System.out.println("e ha hecho commit de la transaccion");

//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//            System.out.println("entramos al rollback");
//            try {
//                conexion.rollback();
//            } catch (SQLException ex1) {
//                ex1.printStackTrace(System.out);
//            }
//        }
    }

}
