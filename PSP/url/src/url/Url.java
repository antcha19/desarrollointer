/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
/**
 *
 * @author antonio
 */
public class Url {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        try {

            URL url = new URL("https://blog.wowcheeeer.co.uk/wp-content/uploads/2015/06/valencia.gif");

            if (isGifFormat(url)) {
                System.out.println("es un gif");
            } else {
                System.out.println("no es un gif");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static boolean isGifFormat(URL url) throws Exception{
        boolean ret = false;
        try {
            URLConnection con = url.openConnection();
            String headerType = con.getContentType();
            String guessType = con.guessContentTypeFromName(url.getFile());
            ret = headerType.endsWith("gif") || guessType.endsWith("gif");
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return ret;
    }

}
