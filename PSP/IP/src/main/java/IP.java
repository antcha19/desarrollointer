/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antcha
 */
import java.net.InetAddress;

public class IP {

    public static void main(String[] args) throws Exception {
        InetAddress[] addresses = new InetAddress[3];

        addresses[0] = InetAddress.getLoopbackAddress();
        addresses[1] = InetAddress.getByName("iesserpis.org");
        addresses[2] = InetAddress.getLocalHost();
        try {

            for (InetAddress adress : addresses) {
                System.out.println("nombre");
                if (adress.isLoopbackAddress()) {
                    System.out.println(adress.getHostName() + " es una ip lookback");
                } else if (adress.isSiteLocalAddress()) {
                    System.out.println(adress.getHostName() + " es una ip local");
                } else if (adress.isMulticastAddress()) {
                    System.out.println(adress.getHostName() + " es una ip multicas");

                }
            }
        } catch (Exception e) {
        }
    }
}
