/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;

public class access {

    private static File f = new File("series.dat");

    //guardar
    public static void saveLS(listShow ls) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(ls);
            oss.close();
        } catch (IOException e) {
            System.out.println("failed to open file");
        }
    }

    public static listShow loadLS() {
        listShow ls = new listShow();
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ls = (listShow) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.out.println("failed to open file");
        }finally{
            return ls;
        }
    }
}
