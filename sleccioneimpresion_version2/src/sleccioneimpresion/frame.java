/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleccioneimpresion;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.sql.SQLException;
import DAO.all;
import DAO.client;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;


/**
 *
 * @author antcha
 */
public class frame extends JFrame {

    private ArrayList<client> listclients = new ArrayList<>();
    private JButton boton1, boton2, boton3;
    private JList list, list2;
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    public frame() throws SQLException {
        setTitle("seleccion e impresion");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //panel

        panel.setLayout(new BorderLayout());
        //panel botones 
        panel3.setLayout(new GridLayout(3, 1, 10, 10));
        boton1 = new JButton(">>>>");
        boton2 = new JButton("<<<<");
        boton3 = new JButton("Imprimir");

        //botones
        panel3.add(boton1);
        panel3.add(boton2);
        panel3.add(boton3);
        panel.add(panel2, BorderLayout.WEST);
        panel.add(panel3, BorderLayout.CENTER);
        panel.add(panel4, BorderLayout.EAST);
        add(panel);

        all todo = new all();

        listclients = (ArrayList<client>) todo.obtainData();
        //foreach para recorrer el arraylist
        String nombre;
        for (client cli : listclients) {

            //anado todo el cliente 
            listModel.addElement(cli);
        }

        list = new JList(listModel);
        panel2.add(list);
        list2 = new JList(listModel2);
        panel4.add(list2);

        //boton uno
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                //toma el indice del elemnto seleccionado de la list
                int index = list.getSelectedIndex();
                if (index >= 0) {
                    //devuelve el valor selecionado
                    client aux = (client) list.getSelectedValue();
                    listModel2.addElement(aux);
                    listModel.remove(index);
                }
            }

        });

        // boton dos
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //toma el indice del elemnto seleccionado de la list
                int index = list2.getSelectedIndex();
                if (index >= 0) {
                    //devuelve el cliente
                    client devuelve = (client) list2.getSelectedValue();
                    //anadira a la listamodel
                    listModel.addElement(devuelve);
                    //eliminara de la lista
                    listModel2.remove(index);
                }
            }

        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //crea el texto y lo inserta en la variable 'text'
                    String text = "Lista de clientes:\n\n";
                    for (Object o : listModel2.toArray()) {

                        client c = (client) o;
                        text = text + c.Muestra();
                    }

                    //esta parte es fija, no se cambia
                    Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
                    PdfWriter.getInstance(doc,new FileOutputStream("clientes.pdf"));
                    doc.open();
                    Paragraph p = new Paragraph(text);
                    p.setAlignment(Element.ALIGN_JUSTIFIED);

                    doc.add(p);
                    doc.close();
                } catch (DocumentException | FileNotFoundException f) {
                    f.printStackTrace();
                }

            }
        });

    }
}
