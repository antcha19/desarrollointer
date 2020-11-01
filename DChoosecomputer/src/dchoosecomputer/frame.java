/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dchoosecomputer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    String[][] ram = {{"RAM 1GB", "20"}, {"RAM 2GB", "30"}, {"RAM 4GB ", "50"}, {"RAM 8GB", "80"}};
    String[][] Monitors = {{"LG1", "100"}, {"LG2", "200"}, {"hp1", "400"}, {"hp2", "122"}};
    String[][] Miscellanea = {{"Mouse normal", "20"}, {"mouse pro", "56"}, {"keyborad normal ", "54"}, {"keyborad pro", "67"}};

    public frame() {
        setSize(600, 400);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        JButton buttonimprimir = new JButton("Print");
        panel.add(buttonimprimir, BorderLayout.SOUTH);
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
        /// RAm
        //creo el titulo para el borde
        TitledBorder title2;
        //creo el titulo para el borde
        title2 = BorderFactory.createTitledBorder("RAM");
        //anado el nombre al borde
        panel3.setBorder(title2);
        panel3.setLayout(new GridLayout(ram.length, 1, 10, 10));
        //bucle para crear  el radio butoon
        ButtonGroup bgram = new ButtonGroup();
        for (int j = 0; j < ram.length; j++) {
            JRadioButton jb2 = new JRadioButton(ram[j][0]);
            bgram.add(jb2);
            panel3.add(jb2);
        }

        //Monitores
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

        ///
        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("Miscellanea");
        panel5.setBorder(title4);
        panel5.setLayout(new GridLayout(Miscellanea.length, 1, 10, 10));
        for (int j = 0; j < Miscellanea.length; j++) {
            JCheckBox CB = new JCheckBox(Miscellanea[j][0]);
            panel5.add(CB);
        }

        //creo el listener 
        buttonimprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                metodoimprimir();

            }
        });

    }

    private void metodoimprimir() {
        //PRIMERO MIRAR LA SELECCION DEL USUARIO
        //recorrer los elementos del panel de micros

        String imprimir = "";
        Integer valor = 0;
        for (int i = 0; i < panel2.getComponentCount(); i++) {
            JRadioButton radio2 = (JRadioButton) panel2.getComponent(i);
            if (radio2.isSelected()) {
               //anade el texto selecionado del array y tambienla se gunda parte de array micros[i][1] 
                imprimir = imprimir + " Selected micro:"+ radio2.getText() + " " + micros[i][1] + "\n";
               // de string a entero la parte del precio
                valor = valor + Integer.parseInt(micros[i][1]);
            }

        }
        //panel ram
        for (int j = 0; j < panel3.getComponentCount(); j++) {
            JRadioButton radio3 = (JRadioButton) panel3.getComponent(j);
            if (radio3.isSelected()) {
                //anade el texto selecionado del array y tambienla se gunda parte de array tam[j][1] 
                imprimir = imprimir +"select ram :" + radio3.getText() + " " + ram[j][1]+ "\n";
                 // de string a entero la parte del precio
                valor = valor + Integer.parseInt(ram[j][1]);
            }
        }
        //panel monitores
        for (int k = 0; k < panel4.getComponentCount(); k++) {
            JRadioButton radio4 = (JRadioButton) panel4.getComponent(k);
            if (radio4.isSelected()) {
                 //anade el texto selecionado del array y tambienla se gunda parte de array monitors[k][1] 
                imprimir = imprimir + " select monitors : "+ radio4.getText() + " " + Monitors[k][1]+ "\n";
                 // de string a entero la parte del precio
                valor = valor + Integer.parseInt(Monitors[k][1]);
            }
        }
        //panel Miscellanea
        for (int l = 0; l < panel5.getComponentCount(); l++) {
            JCheckBox check = (JCheckBox) panel5.getComponent(l);
            if (check.isSelected()) {
             
                //anade el texto selecionado del array y tambienla se gunda parte de array miscallanea[l][1] 
                imprimir = imprimir +" select varios"+ check.getText() + " " + Miscellanea[l][1]+ "\n";
                 // de string a entero la parte del precio
                valor = valor + Integer.parseInt(Miscellanea[l][1]);
            }
        }
        // imprmimos el resutlado imprimira mas el valor  que pasamos a String para que pueda imprimir
        imprimir = imprimir + "total " + valor.toString();

        //SEGUNDO IMPRIMIR 
        //tenemos que hacer  try pues la impresión puede generar errores
        try {
            // anadimos imprimir al textarea
            texto.append(imprimir);
            boolean ok = texto.print();
            if (ok) {
                System.out.println("All good");
            } else {
                System.out.println("Cancelled operation");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
