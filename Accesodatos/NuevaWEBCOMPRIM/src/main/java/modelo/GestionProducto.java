/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.sga.domain.Producto;

/**
 *
 * @author antonio
 */
public class GestionProducto {

    public List<Producto> recuperarproductos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        
        //Inicamos la transaccion
        tx.begin();
        String jpql ="Select c from Producto c";
        Query qr = em.createQuery(jpql);
        List<Producto> listaproductos = qr.getResultList();
        tx.commit();
        em.close();
        return listaproductos;

        
    }
    public void borrarproducto(int idproducto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Producto pro = em.find(Producto.class,idproducto);
        em.remove(pro);
        tx.commit();
        em.close();
    }
    
  
    public Producto buscarproducto( int idproducto){
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Producto buscarproducto = new Producto();
       
        buscarproducto=em.find(Producto.class, idproducto);
     //   tx.begin();
     //   tx.commit();
        em.clear();   
        return buscarproducto;
    }

}
