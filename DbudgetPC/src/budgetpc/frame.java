package budgetpc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class frame extends JFrame {

    //algunos paneles necesarios
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JTextArea texto; //usada para imprimir
    //componentes micros
    String[][] micros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};

    public frame() {

        setSize(1000, 700);
        setTitle("Choose a computer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(1, 4, 10, 10));
        add(panel);
        panel.add(panel1, BorderLayout.CENTER);
        JButton button = new JButton("Print");
        panel.add(button, BorderLayout.SOUTH);
        panel1.add(panel2);
        //la uso para imprimir, no la añado a ningún panel:
        texto = new JTextArea();
        //añado borde al panel de micros
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Micros");
        panel2.setBorder(title);
        panel2.setLayout(new GridLayout(micros.length, 1, 10, 10));
        //creo los radiobuttons agrupados en un ButtonGroup
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < micros.length; i++) {
            JRadioButton jb = new JRadioButton(micros[i][0]);
            bg.add(jb);
            panel2.add(jb);
        }
        //Creo el listner directamente, es otra de las 
        //posibilidades de java
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                budgeting();
            }
        });

    }

    private void budgeting() {
        //PRIMERO MIRAR LA SELECCION DEL USUARIO
        //recorrer los elementos del panel de micros
        for (int x = 0; x < panel2.getComponentCount(); x++) {
            JRadioButton rb = (JRadioButton) panel2.getComponent(x);
            if (rb.isSelected()) {
                //Esto solamente es un ejemplo:
                //uso el JtextArea para ir dejando la seleccion
                texto.append("Selected micro:\n");//conteno un salto de línea: \n 
                texto.append(rb.getText() + "\n");
            }
        }
        //SEGUNDO IMPRIMIR 
        //se hace con try pues la impresión puede generar errores
        try {
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
