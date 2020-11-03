/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author antcha
 */
public class examen3 extends JFrame{
    
     JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    
    public examen3(){
        
        setTitle(" Examen2");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1));
        
        
         panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        add(panel);

        
        
    }
    
}
