package djtablesql;

import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class framesql extends JFrame {

    private DefaultTableModel model;
    private JTable jTable1;
    private JScrollPane jscrollPanel1;
    
    public framesql() {
        setSize(400, 400);
        setTitle("tabla sql");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        model = new DefaultTableModel();
       
        

        // configuration columns of the DefaultTableModel
        Object[] tags = new Object[2];
        tags[0] = "Id";
        tags[1] = "Notes";
         jTable1 = new JTable();
        model.setColumnIdentifiers(tags);
        
        //añado el model a ala tabla
        jTable1.setModel( model);
        
        try {

            // connection to the database
            String url = "jdbc:mysql://localhost:3306/di?useSSL=false&useTimezone="
                    + "true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Connection con = (java.sql.DriverManager.getConnection(url, "root", "serpis"));
            // We prepare the query 
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from clients");

            int numerofila = 0;
            while (rs.next()) {
                // se crea y rellena la fila para el modelo de la tabla
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = rs.getObject(1);
                rowData[1] = rs.getObject(2);
                model.addRow(rowData);
                numerofila++;
            }
            // We close the connection to the database. 
            rs.close();
            s.close();
            con.close();
        } catch (Exception e) {
            e.getMessage();
        }
        //anado scroll  a la tabla
        jscrollPanel1 = new JScrollPane(jTable1);
        add(jscrollPanel1, BorderLayout.CENTER);
        
    }

}
