/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class ejemplolistas extends JFrame {
    
    private JPanel panel = new JPanel();
    //declaramos lista
    private  JList listacolours;
    //array de colores
    private final String namescolours[] = {"Black", "Blue",  "Cyan","drak grey"
            ,"grey","green","Light grey","magenta","orange","pink","white","yellow"};
    private final Color colores[] ={Color.BLACK,Color.BLUE,Color.cyan,Color.DARK_GRAY,Color.gray,
            Color.green,Color.lightGray,Color.magenta,Color.orange,Color.pink,Color.white,Color.yellow};
    public ejemplolistas(){
        setTitle("Listas");
        setSize(300,300);
        //añado la lista al panel
        panel.setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel);
        //instancio el jlist con el vector namescolours
        listacolours = new JList(namescolours);
        //muestra las filas a la vez, puedo mostrar las que quiero
        listacolours.setVisibleRowCount(15);
        //los list pueden ser de selccion multiple o simple
        listacolours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //añado la lista al panel
        panel.setLayout(new FlowLayout());
        //uso un objeto scrollopne
        panel.add(new JScrollPane(listacolours));
        
        listacolours.addListSelectionListener(new listlistener());
        
    }
    private class listlistener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            panel.setBackground(colores[listacolours.getSelectedIndex()]);
        }
    }
}
