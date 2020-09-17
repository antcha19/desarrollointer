/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import javax.swing. *;
import java.awt. *;
import java.awt.event.*;

public class textfield extends JFrame{
    
JTextField textfield1, textfield2;
    JPanel panel = new JPanel();
    

public textfield(){
    
    setTitle("JTextField ejemplo");
        setSize (300,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel.setLayout(new GridLayout(3,1,5,5));
        //creo textfield y escucha
        textfield1 = new JTextField ("Type something and press return", 20); // 20 columns wide
        textfield1.addActionListener (new TextFieldListener ());
        // Assign a black border line.
        textfield1.setBorder (BorderFactory.createLineBorder (Color.black));
        
        textfield2 = new JTextField (20);
        textfield2.setBorder (BorderFactory.createLineBorder (Color.blue));

        JButton button = new JButton ("Clear");
        button.addActionListener (new ButtonListener ());
        // Add the elements to the panel
        panel.add (textfield1);
        panel.add (textfield2);
        panel.add (button);
        add (panel);
            }
            // textfield listener
        class TextFieldListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
        // get the text typed in textfield1
        // and assign it to the other textfield.
        String text = textfield1.getText ();
        textfield2.setText (text);

        }
        }
        // listener of the button.
        class ButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
        // clean the textfields.
        textfield1.setText ("");
        textfield1.requestFocus (); // Give focus to textfield1
        textfield2.setText ("");

        }
        
}    
}
