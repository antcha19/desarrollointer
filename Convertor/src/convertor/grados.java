/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertor;

//importamos paquetes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class grados extends JFrame {

    JTextField textfield1, textfield2;
    JPanel panel = new JPanel();
    JButton button;

    public grados() {
        setTitle("convertor");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(3, 2,10,10));
        //creo los dos label
        JLabel label1 = new JLabel("Celsius grades");
        JLabel label2 = new JLabel("Centigrades grades");
        
        //creo textflied
        textfield1 = new JTextField();
        textfield1.setBorder(BorderFactory.createLineBorder(Color.red));
        textfield1.addActionListener(new TextField1Listener());
        textfield2 = new JTextField(textfield2.RIGHT);
         textfield1.addActionListener(new TextField2Listener());
        textfield2.setBorder(BorderFactory.createLineBorder(Color.red));
        
        //creo el boton
         button = new JButton("Clean");
         button.addActionListener(new ButtonListener());

        //anado al panel
        panel.add(label1);
        panel.add(textfield1);
        panel.add(label2);
        panel.add(textfield2);
        panel.add(button);                                                                      
        add(panel);

    }
    
    class TextField1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           
          String celsius = textfield1.getText();
          float flotante = Float.parseFloat(celsius);
          float rt = (float) 273.15;
          float r = flotante + rt;
          String resultado = Float.toString(r);
         textfield2.setText(resultado);
            
        }
    }
    class TextField2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           
          String celsius = textfield2.getText();
          float flotante = Float.parseFloat(celsius);
          float rt = (float) 273.15;
          float r = flotante - rt;
          String resultado = Float.toString(r);
         textfield1.setText(resultado);
            
        }
    }
    //clase del boton
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // limpia los  textfields. 
            textfield1.setText("");
            textfield1.requestFocus(); // Give focus to textfield1
            textfield2.setText("");

        }
    }
}
