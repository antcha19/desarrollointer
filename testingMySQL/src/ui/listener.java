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
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

/**
 *
 * @author antcha
 */
public class listener implements  ActionListener{

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
            // in searches disabled movement buttons<búsquedas botones de movimiento desactivados>
            forward.setEnabled(false);
            backwards.setEnabled(false);
            try {
                Connection_DB DB_Connection = new Connection_DB();
                Connection con = DB_Connection.openConnection();
                ClientDAO clientDAO = new ClientDAO();
                c.setId(idSearch.getText());
                c = clientDAO.findById(con, c);
                DB_Connection.CloseConnection(con);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        // LOAD ALL CLIENTS

        if (e.getSource() == this.all) {
            // on all motion buttons enabled<todos los botones de movimiento habilitados>
            forward.setEnabled(true);
            backwards.setEnabled(true);
            position = 0;
            // All clients:
            try {
                Connection_DB DB_Connection = new Connection_DB();
                Connection con = DB_Connection.openConnection();
                ClientDAO clientDAO = new ClientDAO();
                clients = clientDAO.findAll(con);
                DB_Connection.CloseConnection(con);
                // charge the first customer
                position = 0;
                c = clients.get(position);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        //ahead,forward <adelante>
        if(e.getSource()==this.forward){
            position++;
            if(position==clients.size()){
                position--;
            }
            c = clients.get(position);
        }
        //BEHIND <detras>
        if(e.getSource()==this.backwards){
            if(position>0){
                position--;
            }
            c=clients.get(position);
        }
        update(c);
    }
    
    private void update(client c){
        this.id.setText(c.getId());
        this.notes.setText(c.getNotes());
    }

}
