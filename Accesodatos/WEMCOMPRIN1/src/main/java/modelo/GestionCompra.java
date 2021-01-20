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
        String jpql = "Select c from Compra c";
        Query qr = em.createQuery(jpql);
        List<Compra> listacompra = (List<Compra>) qr.getResultList();
        //terminamos la trasaccion
        tx.commit();
      
        em.close();
        return listacompra;
    }

}
