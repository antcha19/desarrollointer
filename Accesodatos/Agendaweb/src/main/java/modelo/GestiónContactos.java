/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Contacto;
import org.apache.logging.log4j.*;
import javax.persistence.*;

/**
 *
 * @author antcha
 */
public class GestiónContactos {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
    EntityManager em = emf.createEntityManager();
     EntityTransaction tx= em.getTransaction();
        //iniciomos transaccion
        
        
        Contacto contacto1 = new Contacto("antonio", "yepez@asdfas", 66666);
        
     
        //iniciomos transaccion
        
      
     
}
