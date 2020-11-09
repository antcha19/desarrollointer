package dmenus2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antcha
 */
public class fmenus2 extends JFrame {

    public fmenus2() {

        setSize(400, 400);
        setTitle("Modal and non-modal windows");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        //MENU:
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        // Create the menu bar.
        menuBar = new JMenuBar();
        // Build the first menu.
        menu = new JMenu("First Menu");
        menuBar.add(menu);
        // a group of JMenuItems
        menuItem = new JMenuItem("Option 1");
        // Add listener to a menu option:
        menuItem.addActionListener((ActionListener) new em(this));
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Option 2");
      
        menu.add(menuItem);
        // Build second menu in the menu bar.
        menu = new JMenu("Second Menu");
        menuBar.add(menu);
        add(menuBar);
    }

    // LISTEN OUT:
    class em implements ActionListener {

        JFrame miFrame;

        public em(JFrame f) {
            miFrame = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            DialogoModal dialogoModal = new DialogoModal(miFrame);
            dialogoModal.pack();
            // to automatically resize the window.
            dialogoModal.setVisible(true);
            // As it is a modal window it will not return to this line 
            // until the other one is closed
            System.out.println(dialogoModal.getText());
        }
    }
}
