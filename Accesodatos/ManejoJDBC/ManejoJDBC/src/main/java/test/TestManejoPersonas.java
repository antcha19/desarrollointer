/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;
import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

/**
 *
 * @author antcha
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas = personaDao.seleccionar();

        //insertando nuevo objeto de tipo persona
        /*Persona personaNueva = new Persona("Maria","Ramon",66);
        personaDao.insertar(personaNueva);*/
        
        
      //  Persona perupdate = new Persona(1,"Jose","perez",64);
        //personaDao.actualizar(perupdate);
    
    
    //    Persona borrar= new Persona(2);
      //  personaDao.borrar(borrar);
    
        //metodo lambda
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }

}
