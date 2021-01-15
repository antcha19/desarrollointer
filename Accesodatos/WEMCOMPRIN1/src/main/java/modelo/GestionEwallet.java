/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.lang.System.Logger;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Ewallet;


/**
 *
 * @author antonio
 */
public class GestionEwallet {
    
  //  static Logger log = LogManager.getFormatterLogger();

    public static void altawallet(String nombre, String apellidos, String DNI, Date fecha_nacimiento, String email, int saldo_puntos, int saldo_euros) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Iniciamos la transacción
        tx.begin();
        Ewallet wallet = new Ewallet(nombre, apellidos, DNI, fecha_nacimiento, email, saldo_puntos, saldo_euros);
    //    log.debug("Wallet a insertar: " + wallet);
        //Persistimos el objeto
        em.persist(wallet);
        //Terminamos la transaccion
        tx.commit();
       // log.debug("Wallet insertada: " + wallet);
        em.close();
    }

    public void borrarwallet(int idwallet) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Ewallet wallet = em.find(Ewallet.class, idwallet);
     //   log.debug("Wallet a borrar: " + wallet);
        //Borramos el objeto
        em.remove(wallet);
        //Terminamos la transaccion
        tx.commit();
     //   log.debug("Wallet borrada: " + wallet);
        em.close();
    }

    public List<Ewallet> recuperarwallets() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String jpql = "Select c from Ewallet c";
        Query qr = em.createQuery(jpql);
        List<Ewallet> listawallet = (List<Ewallet>) qr.getResultList();
        //Terminamos la transaccion
        tx.commit();
        for (int i = 0; i < listawallet.size(); i++) {
            Ewallet aux = listawallet.get(i);
          //  log.debug("Wallet: " + listawallet);
        }
        em.close();
        return listawallet;
    }

    public Ewallet buscarwallet(String email) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        String jpql = "Select c from Ewallet c where c.email=:email";
        TypedQuery<Ewallet> tq = em.createQuery(jpql, Ewallet.class);
        Ewallet wallet = new Ewallet();
        wallet = tq.getSingleResult();
        //Termicontactosnamos la transaccion
        tx.commit();
        em.close();

        return wallet;
    }
}
