/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujodedatos;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author antcha
 */
public class Flujodedatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {

            URL url = new URL("https://www.rfc-editor.org/rfc/rfc8973.txt");
            printContent(url);

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    private static void printContent(URL url) throws IOException, Exception {
        InputStream in;
        char[] cbuf = new char[512];
        int caractersLlegits;
        if (!isText(url)) {
            return;
        }
        try {
            in = url.openStream();
            InputStreamReader inr = new InputStreamReader(in);
            caractersLlegits = inr.read(cbuf);
           while(caractersLlegits != -1){
              Thread.sleep(1000);
               String str = String.copyValueOf(cbuf, 0, caractersLlegits);
               System.out.print(str);
                caractersLlegits = inr.read(cbuf);
           }
            System.out.println();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
    
    public static boolean isText(URL url) throws Exception{
        boolean ret = false;
        try {
            URLConnection con = url.openConnection();
            String headerType = con.getContentType();
            String guessType = con.guessContentTypeFromName(url.getFile());
            ret = headerType.endsWith("text/plain") || guessType.endsWith("text/plain");
            System.out.println("Es un link de tipo  " +guessType);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return ret;
    }

}
