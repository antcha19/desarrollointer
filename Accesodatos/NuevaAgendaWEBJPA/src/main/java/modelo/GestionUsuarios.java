/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author antcha
 */
public class GestionUsuarios {
    //metodo para obtener el objeto EntityManager

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("WebPU");
        return factory.createEntityManager();
    }

    public boolean autenticar(String usuario, String pwd) {
        EntityManager em = getEntityManager();
        boolean res = false;
        TypedQuery<Usuario> qr = em.createNamedQuery("Usuario.findByUserAndPwd", Usuario.class);
        qr.setParameter(1, usuario);
        qr.setParameter(2, pwd);
        try {
            qr.getSingleResult();
            res = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

}
