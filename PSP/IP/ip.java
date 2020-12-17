
import java.net.InetAddress;


public class ip {

    public static void main(String[] args) throws Exception {
          InetAddress[] addresses = new InetAddress[3];
        
        addresses[0] = InetAddress.getLoopbackAddress();
        addresses[1] = InetAddress.getByName("iesserpis.org");
        addresses[2] = InetAddress.getLocalHost();
        try {
            
            for (InetAddress adress : addresses) {
                if (adress.isLoopbackAddress()) {
                    System.out.println(adress.getHostName() + " es una ip lookback");
                }
                if (adress.isSiteLocalAddress()) {
                    System.out.println(adress.getHostName() + " es una ip lookback");
                }
                
            }
        } catch (Exception e) {
        }
    }
}
