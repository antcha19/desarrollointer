
package fristwindow;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class colores extends JFrame{
    JPanel panel2 = new JPanel();
    
    private JButton blue,pink,yellow, green;
    
    public colores(){
       //titulo de la ventana
        setTitle("hola");
        //tamano de la ventana
        setSize(500,500);
        //cierra la ventana y termina
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        panel2.setLayout(new BorderLayout());
        //creo el boton
        blue = new JButton("Blue");
        Dimension d = new Dimension();
        d.height = 40;
        d.width = 100;
        blue.setPreferredSize(d); 
        blue.addActionListener (new listener_button_blue());
        
          pink = new JButton("pink");
        d.height = 40;
        d.width = 100;
        pink.setPreferredSize(d);
         pink.addActionListener (new listener_button_pink());
        
         yellow = new JButton("yellow");
        d.height = 40;
        d.width = 100;
        yellow.setPreferredSize(d);
        yellow.addActionListener (new listener_button_yellow());
       
         green = new JButton("green");
        d.height = 40;
        d.width = 100;
        green.setPreferredSize(d);
        //para escuchar el boton
        green.addActionListener (new listener_button_green());
        
        //añado a la pantalla
        panel2.add(blue,BorderLayout.SOUTH);
        panel2.add (green, BorderLayout.NORTH);
        panel2.add (yellow, BorderLayout.EAST);
        panel2.add (pink, BorderLayout.WEST);
        add (panel2);
        panel2.setBackground (Color.red);
    }
    
    // clase escucha el boton
    class listener_button_blue implements ActionListener {

        public void actionPerformed (ActionEvent e) {
         panel2.setBackground (Color.blue);
        }  
      
    }
    class listener_button_pink implements ActionListener {

        public void actionPerformed (ActionEvent e) {
         panel2.setBackground (Color.pink);
       // pink.setBackground(Color.pink);
        }  
      
    }
    class listener_button_yellow implements ActionListener {

        public void actionPerformed (ActionEvent e) {
         panel2.setBackground (Color.yellow);
        }  
      
    }
    class listener_button_green implements ActionListener {

        public void actionPerformed (ActionEvent e) {
         panel2.setBackground (Color.green);
        }  
      
    }
    
}
