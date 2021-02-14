/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Compra;
import modelo.GestionCompra;
import mx.com.gm.sga.domain.Ewallet;

/**
 *
 * @author antonio
 */
public class GestionCompra {

    public List<Compra> recuperarcompras() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //iniciamos la trasaccion
        tx.begin();
        String select = "Select c from Compra c";
        Query qr = em.createQuery(select);
        List<Compra> listacompra = (List<Compra>) qr.getResultList();
        //terminamos la trasaccion
        tx.commit();
      
        em.close();
        return listacompra;
    }
    
    public void nuevacompra(java.sql.Date fechacompra, int idwallet, int idproducto) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
         EntityTransaction tx = em.getTransaction();
         Ewallet nuevo =  new Ewallet(idwallet);
        Compra nueva = new Compra(fechacompra, nuevo, idproducto);
        
        tx.begin();
        em.persist(nueva);
        tx.commit();
        em.clear();
    }
    
    
    
    public void eliminarcompra( int idcompra){
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Compra eliminar = new Compra();
        tx.begin();
        eliminar=em.find(Compra.class, idcompra);
        em.remove(eliminar);
        tx.commit();
        em.clear();
        
        
    }
    
    public Compra buscarcompra( int idcompra){
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Compra buscar = new Compra();
       
        buscar=em.find(Compra.class, idcompra);
     //    tx.begin();
       // tx.commit();
        em.clear();   
        return buscar;
    }

}
