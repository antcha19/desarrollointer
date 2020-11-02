/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dejemplo3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author antonio
 */
public class Dejemploframe3 extends JFrame {

    private JPanel panelPrin = new JPanel();
    private JPanel panelIzq, panelDer, panelBtn, panelResult;
    private JLabel lblLuz, lblAgua, lblGas, lblResult;
    private JButton btnCalc;
    private JTextField txtLuz, txtAgua, txtGas;

    public Dejemploframe3() {
        setTitle("Gastos");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelPrin.setLayout(new GridLayout(1, 2));
        panelIzq = new JPanel();
        panelIzq.setLayout(new GridLayout(4, 1));
        lblLuz = new JLabel("Luz");
        lblAgua = new JLabel("Agua");
        lblGas = new JLabel("Gas");
        btnCalc = new JButton("Calcular");
        btnCalc.addActionListener(new ButtonListener());
        panelIzq.add(lblLuz);
        panelIzq.add(lblAgua);
        panelIzq.add(lblGas);
        panelIzq.add(btnCalc);
        panelPrin.add(panelIzq);
        panelDer = new JPanel();
        panelDer.setLayout(new GridLayout(4, 1));
        txtLuz = new JTextField();
        txtAgua = new JTextField();
        txtGas = new JTextField();
        lblResult = new JLabel("");
        panelDer.add(txtLuz);
        panelDer.add(txtAgua);
        panelDer.add(txtGas);
        panelDer.add(lblResult);
        panelPrin.add(panelDer);

        add(panelPrin);
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int luz, agua, gas;
            if (txtLuz.getText().equals("")) {
                luz = 0;
            } else {
                luz = Integer.parseInt(txtLuz.getText());

            }

            if (txtAgua.getText().equals("")) {
                agua = 0;
            } else {
                agua = Integer.parseInt(txtAgua.getText());

            }

            if (txtGas.getText().equals("")) {
                gas = 0;
            } else {
                gas = Integer.parseInt(txtGas.getText());

            }
            int result = luz + agua + gas;
            txtLuz.setText("");
            txtAgua.setText("");
            txtGas.setText("");
            lblResult.setText(String.valueOf(result));
        }

    }
}
