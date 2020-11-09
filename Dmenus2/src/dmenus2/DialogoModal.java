/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmenus2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author antcha
 */
class DialogoModal extends JDialog {

    private JTextField textField;

    public DialogoModal(JFrame parent) {

// el constructor recibe como parámetro esa ventana
// quien lo llamó, es decir, su padre
        super(parent, true);
        // Invoco al constructor del caso, con dos
        // parámetros: quién es tu padre
// luego es verdadero para modal y falso para no modal

        setTitle("Enter a data");
        textField = new JTextField(20);
        add(textField);

        //La ventana se oculta al presionar <enter> en el campo de texto
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });
    }

    public String getText() {
        return textField.getText();
    }

}
