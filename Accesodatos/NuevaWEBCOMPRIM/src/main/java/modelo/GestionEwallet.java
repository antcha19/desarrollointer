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

   /* public  void altawallet(String nombre, String apellidos, String DNI, Date fecha_nacimiento, String email, int saldo_puntos, int saldo_euros) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Iniciamos la transacción
        tx.begin();
        Ewallet wallet = new Ewallet(nombre, apellidos, DNI, fecha_nacimiento, email, saldo_puntos, saldo_euros);
        em.persist(wallet);
        tx.commit();
        em.close();
    }
    
    
*/
    //Alta de Ewallet
    public void altawallet(String Nombre, String Apellidos, String Dni, java.sql.Date FechaNacimiento, String Email, int SaldoPuntos, int SaldoEuros) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        Ewallet ewallet = new Ewallet(Nombre, Apellidos, Dni, FechaNacimiento, Email, SaldoPuntos, SaldoEuros);
     
        tx.begin();
        em.persist(ewallet);
        tx.commit();
        em.clear();
    }
    
    
    public void borrarwallet(int idwallet) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        Ewallet wallet = em.find(Ewallet.class, idwallet);
        em.remove(wallet);
        tx.commit();
        em.close();
    }
    
    public void actualizarwallet(Ewallet ewallet){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
         tx.begin();
        
         em.merge(ewallet);
         tx.commit();
         em.clear();
       
    }

    public List<Ewallet> recuperarwallets() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        //Iniciamos la transacción
        tx.begin();
        String select = "Select c from Ewallet c";
        Query qr = em.createQuery(select);
        List<Ewallet> listawallet = (List<Ewallet>) qr.getResultList();
        //Terminamos la transaccion
        tx.commit();
        em.close();
        return listawallet;
    }
    
    
   
     public Ewallet buscaEwallet( int idwallet){
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("WEBCOM");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
      
        Ewallet busca= new Ewallet();
       
        busca=em.find(Ewallet.class, idwallet);
    
        em.clear();   
        return busca;
    }

   

    
}
