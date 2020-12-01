/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.apache.logging.log4j.LogManager;


import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;
public class ClienteEntidadPersona {
    
    static Logger log =LogManager.getFormatterLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();
        //iniciomos transaccion
        
        tx.begin();
        Persona persona1 = new Persona("antonio", "yepez", "antonio@yepez");
        log.debug("objeto a persistir " +persona1);
        //persistimos el objeto
        em.persist(persona1);
        //terminamos la transaccion
        tx.commit();
        log.debug("objeto persistido " +persona1);
        em.clear();
    }
}
