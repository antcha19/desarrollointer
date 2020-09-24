/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selecionarcheck;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class selec extends JFrame {

    private JTextField textField;
    //seleccionar y deseleccionar la letra negrita
    private JCheckBox boldJCheckBox;
    //seleccionar y deseleccionar la letra cursiva
    private JCheckBox italicJCheckBox;

    // El constructor de FrameCheckBox agrega objetos JCheckBox a JFrame
    public selec() {

        setTitle("checkbox");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // establece JTextField y su tipo de letra
        textField = new JTextField("Observe changes in font style", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        // crea casilla de verificación "negrita"
        boldJCheckBox = new JCheckBox("Bold");
        // crea casilla de verificación "cursiva"
        italicJCheckBox = new JCheckBox("Italic");
        add(boldJCheckBox);
        add(italicJCheckBox);

        // listener de  JCheckBox
        ListenerCheckBox manejador = new ListenerCheckBox();
        boldJCheckBox.addItemListener(manejador);
        italicJCheckBox.addItemListener(manejador);
    }

    // clase para el escuchador de los JCheckBox, en este caso no es un ActionListener como en los botones, es un ItemListener
    private class ListenerCheckBox implements ItemListener {

        private int valBold = Font.PLAIN; // controla el estilo de tipo de letra negrita
        private int valItalic = Font.PLAIN; // controla el estilo de tipo de letra cursiva

        // cuando cambia el estado de un JCheckBox:
        public void itemStateChanged(ItemEvent event) {
            // procesa los eventos de la casilla de verificación "negrita"
            if (event.getSource() == boldJCheckBox) {
                valBold = boldJCheckBox.isSelected() ? Font.BOLD : Font.PLAIN;
            }

            // procesa los eventos de la casilla de verificación "cursiva"
            if (event.getSource() == italicJCheckBox) {
                valItalic = italicJCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN;
            }

            // establece el tipo de letra del campo de texto
            textField.setFont(new Font("Serif", valBold + valItalic, 14));
        }
    }

}
