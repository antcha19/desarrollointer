/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Ewallet;

/**
 *
 * @author antonio
 */
public class GestionEwallet {
    
    //metodo para obtener el objeto EntityManager
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ewalletPU");
        return factory.createEntityManager();
    }
    
    //Recuperar wallet
    public List<Ewallet> recuperarwallet() {
        EntityManager em = getEntityManager();
        String select = "SELECT c from Ewallet c";
        Query qr = em.createQuery(select);  
       // List<Ewallet> listawall = qr.getResultList();
        List<Ewallet> listawall = (List<Ewallet>) qr.getResultList();
        em.clear();
        return listawall;
    }
    
}
