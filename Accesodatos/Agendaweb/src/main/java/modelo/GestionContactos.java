/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*; 
import mx.com.gm.sga.domain.Contacto;
import org.apache.logging.log4j.*;


/**
 *
 * @author antcha
 */
public class GestionContactos {
    //static Logger log = LogManager.getFormatterLogger();

    public void altacontacto(String nombre, String email, int telefono){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Contacto contactoalta = new Contacto(nombre, email, telefono);
        em.persist(contactoalta);
        //terminamos la transaccion
        tx.commit();
        em.clear();
    }
    
    public void borrarcontacto(int id){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Contacto contactoborrar  = new Contacto();
        contactoborrar=em.find(Contacto.class, id);
        em.remove(contactoborrar);
        tx.commit();
        em.close();
        
    } 
    
    public List<Contacto>recuperarcontactos (){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ContactoPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql ="Select c from Contacto c";
        Query qr = em.createQuery(jpql);
         List<Contacto> listacontactos = qr.getResultList();
        em.clear();
        
     
        return listacontactos;
    }

    
    
       
    

}
