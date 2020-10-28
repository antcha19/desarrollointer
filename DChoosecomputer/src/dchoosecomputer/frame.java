/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dchoosecomputer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author antcha
 */
public class frame extends JFrame {

    //algunos paneles necesarios
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
     JPanel panel5 = new JPanel();
    JTextArea texto; //usada para imprimir
    //componentes micros
    String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
    String[][] ram = {{"RAM 1GB", "1GB"}, {"RAM 2GB", "2GB"}, {"RAM 4GB ", "4GB"}, {"RAM 8GB", "8GB"}};
    String[][] Monitors = {{"LG1", "1GB"}, {"LG2", "2GB"}, {"hp1", "4GB"}, {"hp2", "8GB"}};
    String[][] Miscellanea = {{"Mouse normal", "normal"}, {"mouse pro", "pro"}, {"keyborad normal ", "normal"}, {"keyborad pro", "pro"}};

    public frame() {
        setSize(600, 400);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        JButton button = new JButton("Print");
        panel.add(button, BorderLayout.SOUTH);
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel1.add(panel5);

        //la uso para imprimir, no la añado a ningún panel:
        texto = new JTextArea();
        //añado borde al panel de micros
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Micros");
        panel2.setBorder(title);
        panel2.setLayout(new GridLayout(micros.length, 1, 10, 10));
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bg.add(jb);
            panel2.add(jb);
        }

        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("RAM");
        panel3.setBorder(title2);
        panel3.setLayout(new GridLayout(ram.length, 1, 10, 10));
        ButtonGroup bgram = new ButtonGroup();
        for (int j = 0; j < ram.length; j++) {
            JRadioButton jb2 = new JRadioButton(ram[j][0]);
            bgram.add(jb2);
            panel3.add(jb2);
        }
        
        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Monitors");
        panel4.setBorder(title3);
        panel4.setLayout(new GridLayout(Monitors.length, 1, 10, 10));
        
        ButtonGroup bgmo = new ButtonGroup();
        for (int j = 0; j < Monitors.length; j++) {
            JRadioButton jb3 = new JRadioButton(Monitors[j][0]);
            bgmo.add(jb3);
            panel4.add(jb3);
        }
        
        
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("Monitors");
        panel5.setBorder(title4);
        panel5.setLayout(new GridLayout(Miscellanea.length, 1, 10, 10));
        for (int j = 0; j < Miscellanea.length; j++) {
            JCheckBox CB = new JCheckBox(Miscellanea[j][0]);
            panel5.add(CB);
        }
        

    }
}
