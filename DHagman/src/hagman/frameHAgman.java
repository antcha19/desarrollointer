/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hagman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author antonio
 */
class frameHAgman extends JFrame {

    // paneles necesarios
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    //forma de los paneles 3 y 4
    JPanel panel4 = new JPanel(new GridLayout(3, 1, 5, 5));
    JPanel panel5 = new JPanel(new GridLayout(3, 1, 5, 5));
    JLabel textojugador1 = new JLabel();
    JLabel textojugador2 = new JLabel();
    JTextField textfield1, textfield2;
    JButton button;
    JButton button2;
    JPasswordField password = new JPasswordField();

    //array de las imagenes
    private String[] imagenes = {"foto1", "foto2", "foto3", "foto4", "foto5"};
    private Icon img;
    private JLabel label;

    public frameHAgman() {

        //creo la ventana con su titulo,nombre y cuando pulse cerrar termine los procesos
        setSize(600, 400);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //imagenes codigo anado solo la primera foto
        img = new ImageIcon(getClass().getResource("imagenes/foto1.png"));
        label = new JLabel();
        label.setIcon(img);
        panel2.add(label);

        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        //modifico para que en panel3 entren el panel4 y panel5
        panel3.setLayout(new GridLayout(2, 4, 10, 10));
        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        panel1.add(panel2);
        panel1.add(panel3);

        panel3.add(panel4);
        panel3.add(panel5);

        //panel de la imagen y su codigo
        //añado borde al panel 
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Image");
        //el titulo al borde
        panel2.setBorder(title);

        //panel del jugador y su codigo
        //añado borde al panel 
        TitledBorder titlejugador;
        titlejugador = BorderFactory.createTitledBorder("Player1");
        //el titulo al borde
        panel4.setBorder(titlejugador);
        //texto 
        textojugador1 = new JLabel("word to guess");
        //creando password

        textfield1 = new JTextField();
        button = new JButton("Accept");

        panel4.add(textojugador1);
        panel4.add(password);
        panel4.add(button);

        //panel del jugador2 y su codigo
        //añado borde al panel 
        TitledBorder titlejugador2;
        titlejugador2 = BorderFactory.createTitledBorder("Player2");
        //el titulo al borde
        panel5.setBorder(titlejugador2);
        //anado al panel5 un texto
        textojugador2 = new JLabel("Letter");
        textfield2 = new JTextField();
        button2 = new JButton("Accept");
        panel5.add(textojugador2);
        panel5.add(textfield2);
        //textfield y el boton descativado hasta que pulse el boton accetar
        textfield2.setEnabled(false);
        button2.setEnabled(false);
        panel5.add(button2);

        //escuchar botones
        buttonsescuchar bl = new buttonsescuchar();
        button.addActionListener(bl);
        button2.addActionListener(bl);

    }

    class buttonsescuchar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                //activar y desactivar botones
                textfield2.setEnabled(true);
                button2.setEnabled(true);
                button.setEnabled(false);

            }
            if (e.getSource() == button2) {

                /*     password = new JPasswordField();
                char[] vc;
                vc = password.getPassword();*/
                img = new ImageIcon(getClass().getResource("imagenes/" + " .png"));
                label.setIcon(img);
                 

            }
        }

    }

}
