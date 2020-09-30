/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.event.ItemListener;

public class combos extends JFrame {
    
    private  JComboBox combo;
    private JPanel panel;
    private JLabel label;
    private String[] images={"Rabbit", "Cat", "Dog", "Bird", "Pig"};
    private Icon img;
    
    public combos(){
        setSize(400, 500);
        setTitle("combos and images");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
       
        
        combo=new JComboBox(images);
        panel.add(combo,BorderLayout.NORTH);
        combo.addItemListener(new Listenercombo());
        
        System.out.println(System.getProperty("java.class.path"));
 
        img = new ImageIcon (getClass().getResource("images/Rabbit.gif"));
        label = new JLabel();
        label.setText("Rabbit");
        label.setIcon(img);
        
      
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setToolTipText("esto es um label");
        panel.add(label,BorderLayout.CENTER);
        
        add(panel);
        
             
    }
    //eleg la opcion correcta 
    private class Listenercombo implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            int indice=combo.getSelectedIndex();
            String s = images[indice];
            img = new ImageIcon(getClass().getResource("images/" + s + ".gif"));
            label.setIcon(img);
            label.setText(s);
        }
    }
}
