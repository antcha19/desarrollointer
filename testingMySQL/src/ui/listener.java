/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DAO.ClientDAO;
import DAO.Connection_DB;
import DAO.client;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

/**
 *
 * @author antcha
 */
public class listener {

    private JTextField id, idSearch;
    private JTextArea notes;
    private JButton backwards, forward, search, all;
    private List<client> clients;
    private int position;

    public listener(JTextField id, JTextArea notes, JTextField idSearch,
            JButton backwards, JButton forward, JButton search, JButton all) {
        this.id = id;
        this.notes = notes;
        this.idSearch = idSearch;
        this.backwards = backwards;
        this.forward = forward;
        this.search = search;
        this.all = all;
        position = 0;
    }

    public void actionPerformed(ActionEvent e) {
        client c = new client();
        // FIND A CLIENT
        if (e.getSource() == this.search) {
            // in searches disabled movement buttons
            forward.setEnabled(false);
            backwards.setEnabled(false);
        }
        try {
            Connection_DB DB_Connection = new Connection_DB();
            Connection with = DB_Connection.OpenConexion();
            ClientDAO customerDAO = new ClientDAO();
            c.setId(idSearch.getText());
            c = customerDAO.findById(with, c);
            DB_Connection.CerrarConexion(with);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // LOAD ALL CLIENTS

        if (e.getSource() == this.all) {
            // on all motion buttons enabled
            forward.setEnabled(true);
            backwards.setEnabled(true);
            position = 0;
            // All clients:
        }
        try {
            Connection_DB DB_Connection = new Connection_DB();
            Connection with = DB_Connection.OpenConexion();
            ClientDAO customerDAO = new ClientDAO();
            customers = customerDAO.findAll(with);
            DB_Connection.CloseConexion(with);
            // charge the first customer
            position = 0;
            c = customers.get(position);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
