/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;

/**
 *
 * @author antonio
 */
public class CompraDAO {
    
    
     //atributo 
    private Connection conexionTransaccional;

    //  sentencias de acceso a la BD
    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellidos,edad FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellidos,edad) VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona=?";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellidos=?, edad=? where idpersona=?";
    
    
    //constructor vacio
    //Para recibir el objeto conexión desde dentro de la clase. Sola para manejar una transaccion interna
    public CompraDAO() {

    }

    //Para recibir el objeto conexión desde fuera de la clase
    public CompraDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
}
