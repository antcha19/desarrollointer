
package fristwindow;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author antcha
 */
public class myfirstframe  extends JFrame{
    
  // creo un objeto tipo Panel
    JPanel panel = new JPanel ();
    
    private JButton blue;
    
    public myfirstframe(){
        //titulo de la ventana
        setTitle("hello");
        //tamano de la ventana
        setSize(300,200);
        //cierra la ventana y termina
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
    
    // anado el panel al frame
    add (panel);
    // pone el color al panel
    panel.setBackground (Color.red);
    
    JButton button = new JButton ("text goes here");
    button.addActionListener (new listener_button());
   
    // establece el tamano del boton
    Dimension d = new Dimension ();
    d.height = 40;
    d.width = 170;
    button.setPreferredSize (d);
    
    // anade el boton a la pantalla
    panel.add (button);

   
  
    }
  // clase escucha el boton
    class listener_button implements ActionListener {

        public void actionPerformed (ActionEvent e) {
         panel.setBackground (Color.blue);

        }  
      
    } 
    
}
