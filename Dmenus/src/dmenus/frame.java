/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmenus;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author antcha
 */
public class frame extends JFrame {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JButton binfo = new JButton("info");
    JButton badvertencia = new JButton("advertencia");
    JButton berror = new JButton("error");
    JButton bconfirmacion = new JButton("confirmacion");
    JButton btexto = new JButton("texto");
    JButton bcombo = new JButton("combo");
    JButton bmas = new JButton("mas");

    public frame() {
        setTitle(" botones");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(2, 1));
        panel1.add(binfo);
        panel1.add(badvertencia);
        panel1.add(berror);
        panel1.add(bconfirmacion);
        panel1.add(btexto);
        panel1.add(bcombo);
        panel1.add(bmas);

        binfo.addActionListener(new Button());
        badvertencia.addActionListener(new Button());
        berror.addActionListener(new Button());
        bconfirmacion.addActionListener(new Button());
        btexto.addActionListener(new Button());
        bcombo.addActionListener(new Button());
        bmas.addActionListener(new Button());
        panel.add(panel1);
        add(panel);
    }

    class Button implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //informacion
            if (e.getSource() == binfo) {
                //Esta es la forma más sencilla de mostrar información al usuario:
                JOptionPane.showMessageDialog(null, "Este es un mensaje Simple tipo Informacion");
            }
            //advertencia
            if (e.getSource() == badvertencia) {
                JOptionPane.showMessageDialog(null, "Esto es un mensaje de advertencia",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }
            //error
            if (e.getSource() == berror) {
                  JOptionPane.showMessageDialog(null, "Esto es un mensaje de UN ERROR",
                        "eRROR",
                        JOptionPane.ERROR_MESSAGE);
            
            }
            //confirmacion
            if (e.getSource() == bconfirmacion) {
                
                int confirmar = JOptionPane.showConfirmDialog(null, "Do you confirm this?");
                if (JOptionPane.OK_OPTION == confirmar) {
                    System.out.println("confirmar");
                } else {
                    System.out.println("ok ... I don't delete anything ...");
                }
            }
            //texto
            if (e.getSource() == btexto) {
                int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese un"+" numero para multiplicarlo por 2"));
                if (numero >= 0){
                  int  resultado = numero * 2;
                    JOptionPane.showMessageDialog(null, "El resultado es: 2*" +numero+"="+resultado);
                }
            }
            //combo
            if (e.getSource() == bcombo) {
                Object selec = JOptionPane.showInputDialog(
                        null,
                        "Select option",
                        "Options Selector",
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null for default icon
                        new Object[]{"amarrillo", "azul", "verde"},
                        "option 1");

                JOptionPane.showMessageDialog(null, "color seleccionado " + selec);
            }
            //varias ventanas
            if (e.getSource() == bmas) {
                // showOptionDialog
                int selection = JOptionPane.showOptionDialog(
                        null, // parent component
                        "Seleccionas una opcion",
                        "Usas mucho el JOPtionPane?",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, // null for default icon or an icon.
                        new Object[]{"Si", "NO", "cancelar"},
                        // null for YES, NO and CANCEL
                        "option 1");
                if (selection == 0) {

                }
                if (selection == 1) {

                    JOptionPane.showMessageDialog(null, "Pues es muy util ");
                }
            }

        }
    }

}
