/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoptionpanels;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author antcha
 */
public class djoptionFrame extends JFrame {

    public djoptionFrame() {

        //Esta es la forma más sencilla de mostrar información al usuario:
        JOptionPane.showMessageDialog(null, "Operation Successful");

        /*El método showMessageDialog tiene dos parámetros, con el primero se 
        indica quién es la ventana padre, no es un parámetro necesario y con el segundo la cadena a mostrar.*/
        JOptionPane.showMessageDialog(null, "Message inside window",
                "Message in the title bar",
                JOptionPane.WARNING_MESSAGE);

        //el método showConfirmDialog, este método devuelve la opción elegida por el usuario:
        int confirmed = JOptionPane.showConfirmDialog(null, "Do you confirm this?");

        if (JOptionPane.OK_OPTION == confirmed) {
            System.out.println("confirmed");
        } else {
            System.out.println("ok ... I don't delete anything ...");
        }

        //Podemos personalizar el contenido de los botones y la respuesta con showOptionDialog:
        int selection = JOptionPane.showOptionDialog(
                null, // parent component
                "Select option",
                "Options Selector",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // null for default icon or an icon.
                new Object[]{"option 1", "option 2", "option 3"},
                // null for YES, NO and CANCEL
                "option 1");
        if (selection != -1) {
            System.out.println("selected option" + (selection + 1));
        }

        //Para solicitar algún tipo de datos al usuario utilizamos el método showInputDialog:
        String sel = JOptionPane.showInputDialog(null, "Input dialog",
                JOptionPane.QUESTION_MESSAGE); // the icon will be a questioner

        System.out.println("The user has typed" + sel);

        //menu ITEMS
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
            // We instantiate the menu bar.
        menuBar = new JMenuBar();
        // The first option on the menu.
        menu = new JMenu("First Menu");
        menuBar.add(menu);
        // to the first option of the menu we put two items.
        menuItem = new JMenuItem("Option 1");
        menu.add(menuItem);
        menu.addSeparator(); //separator
        menuItem = new JMenuItem("Option 2");
        menu.add(menuItem);
        // Second option in the menu bar without any item.
        menu = new JMenu("Second Menu");
        menuBar.add(menu);

    }
    
    
}
