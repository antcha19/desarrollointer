/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Devolucion;
 
/**
 *
 * @author antonio
 */
public class GestionDevolucion {
    
    
    public List<Devolucion> recuperardevoluciones(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        
        //Inicamos la transaccion
        tx.begin();
        String jpql ="Select c from Devolucion c";
        Query qr = em.createQuery(jpql);
        List<Devolucion> listadevo = qr.getResultList();
        tx.commit();
        em.close();
        return listadevo;
    }
    public void borrardevolucion(int iddevolucion) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Devolucion devo = em.find(Devolucion.class, iddevolucion);
    
        //Borramos el objeto
        em.remove(devo);
        //Terminamos la transaccion
        tx.commit();
     
        em.close();
    }
    
}
