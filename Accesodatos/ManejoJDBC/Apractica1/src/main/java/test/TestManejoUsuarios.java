/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;
import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;

/**
 *
 * @author antcha
 */
public class TestManejoUsuarios {

    public static void main(String[] args) throws SQLException {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario>usuarios = usuarioDAO.seleccionar();

        //insertando nuevo objeto de tipo usuario
    //    Usuario personanueva =  new Usuario("maria", "45454");
    //    usuarioDAO.insertar(personanueva);
        
        
    //    Usuario usuupdate = new Usuario(5,"Jose","2222");
    //    usuarioDAO.actualizar(usuupdate);
    
    
      //  Usuario borrar= new Usuario(1);
      //  usuarioDAO.borrar(borrar);
    
        //metodo lambda
        usuarios.forEach(Usuario -> {
            System.out.println("persona = " + Usuario);
        });

    }

}
