
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antcha
 */
public class dialogoModal extends JDialog {

    private JTextField textField;

    public dialogoModal(JFrame parent) {
// the constructor receives as parameter that window
// who called him, that is, his father

        super(parent, true); // I invoke the constructor of the case, with two 
        // parameters: who is your father 
// then true for modal and false for non-modal

        setTitle("Enter a data");
        textField = new JTextField(20);
        add(textField);

        // The window is hidden when pressing <enter> on the textfield
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
