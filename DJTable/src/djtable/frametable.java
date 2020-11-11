/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djtable;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antcha
 */
public class frametable extends JFrame {

    private JTable jTable1;
    private JScrollPane jscrollPanel1;

    public frametable() {

        setSize(400, 400);
        setTitle("tabla");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] headers = new String[]{"Name", "Address", "Telephone", "Car?"};

        // Data for the table
        Object[][] data = new Object[][]{
            {"Alfons González Pi", "Argentona, Barcelona", new Long(933333333), true},
            {"Ana María Cuesta Suñer", "Gijón, Asturias", new Long(984454545), false},
            {"Elena Veiguela Suárez", "Pontevedra", new Long(986678678), false},
            {"Pedro Aguado Rodríguez", "Madrid", new Long(912804574), true}
        };

        // Headers for the columns of the table
        jTable1 = new JTable();
        jTable1.setModel(
                new DefaultTableModel(data, headers) {
            // Types of each column
            Class[] tipoColumn = {String.class, String.class, Long.class, Boolean.class};
            // override the getColumnClass method

            @Override
            public Class getColumnClass(int indColum
            ) {

                return tipoColumn[indColum];
            }
        }
        );
        jTable1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                Object datoCelda = jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn());
                System.out.print(datoCelda);
            }

        }
        );

      //  jscrollPanel1 = new JScrollPane(jTable1);
     //   add(jscrollPanel1, BorderLayout.CENTER);
        
      add(jTable1);
        
    }

}
