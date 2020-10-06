/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author antcha
 */
public class frame extends JFrame{
    
    private  JPanel panel = new JPanel();
    private  JPanel panel2 = new JPanel();
    private  JPanel panel3 = new JPanel();
     private JLabel label1, label2, label3;
     private Button boton1, boton2, boton3, boton4, boton5 ;
    
    public frame(){
        setTitle("my series");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       panel.setLayout(new BorderLayout());
       panel2.setLayout(new GridLayout(5,2,10,10));
       panel3.setLayout( new FlowLayout());
       add(panel);
       panel.add(panel3,BorderLayout.NORTH);
       panel.add(panel2,BorderLayout.CENTER);
        
    }

}
