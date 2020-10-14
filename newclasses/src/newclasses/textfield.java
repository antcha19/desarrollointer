package newclasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class textfield extends JFrame {

    JTextField textfield1, textfield2;
    JPanel panel = new JPanel();

    public textfield() {

        setTitle("JTextField ejemplo");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(3, 1, 5, 5));
        //creo textfield y escucha
        textfield1 = new JTextField("Type something and press return", 20); // 20 columnas de ancho
        textfield1.addActionListener(new TextFieldListener());
        // Asigna una línea de borde negro.
        textfield1.setBorder(BorderFactory.createLineBorder(Color.black));

        textfield2 = new JTextField(20);
        textfield2.setBorder(BorderFactory.createLineBorder(Color.blue));

        JButton button = new JButton("Clear");
        button.addActionListener(new ButtonListener());
        // añade los elementos al panel
        panel.add(textfield1);
        panel.add(textfield2);
        panel.add(button);
        add(panel);
    }
    // textfield listener

    class TextFieldListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // obtine el texto escrito en textfield1
            // introdroce el textfield1 al text al textfield2
            String text = textfield1.getText();
            textfield2.setText(text);

        }
    }
    // listener of the button.

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // limpia los  textfields.
            textfield1.setText("");
            textfield1.requestFocus(); // Give focus to textfield1
            textfield2.setText("");

        }
    }
}
