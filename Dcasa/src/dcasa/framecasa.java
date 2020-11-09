/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcasa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author antcha
 */
public class framecasa extends JFrame {

    //chechk
    private JCheckBoxMenuItem jCheckMenu;
    //radiobutton
    private JRadioButtonMenuItem radio1, radio2;
    private ButtonGroup optionsGroup;

    public framecasa() {

        setSize(400, 400);
        setTitle("menucasa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //Menu
        JMenuBar menubar;
        JMenu menu, menuhabitacion;
        JMenuItem menuItem;
        
        
        

        //creo el menu bar
        menubar = new JMenuBar();
        //creo el primer menu;
        menu = new JMenu("Casa");
        menubar.add(menu);
        //menu habitaciones
        menuhabitacion = new JMenu("Habitaciones");
        menu.add(menuhabitacion);
        //agrega habitacion al menu habitaciones
        menuItem = new JMenuItem("habitacion 1");
        menuhabitacion.add(menuItem);
        //agrega habitacion al menu habitaciones
        menuItem = new JMenuItem("habitacion 2");
        menuItem.setEnabled(false);
        menuhabitacion.add(menuItem);

        //check
        jCheckMenu = new JCheckBoxMenuItem("Salon");

        menu.add(jCheckMenu);
        
        



        //pongo un separador
        menu.addSeparator();
        //radioboton
        radio1 = new JRadioButtonMenuItem("Cocina");
        radio2 = new JRadioButtonMenuItem("Baño");
      //  optionsGroup.add(radio1);
      //  optionsGroup.add(radio2);
        menu.add(radio1);
        menu.add(radio2);

        //Menu extras
        menu = new JMenu("Extras");
        menubar.add(menu);

        add(menubar);

    }
}
