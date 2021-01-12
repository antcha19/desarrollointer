import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
/**
 *
 * @author antonio
 */
public class url {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        try {

            URL url = new URL("http://media1.ciutat-de-valencia.webgarden.es/files/media1:4b0ad20518e43.gif.upl/o_a_Alvarito14_valencia_4591_20090829221504.gif");

            if (isGifFormat(url)) {
                System.out.println("es un gif");
            } else {
                System.out.println("no es un gif");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static boolean isGifFormat(URL url) {
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
