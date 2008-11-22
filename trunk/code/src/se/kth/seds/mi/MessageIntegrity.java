package se.kth.seds.mi;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 9:56:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageIntegrity {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ");
        }
        Launcher launcher = new Launcher();
        if (args[0].equalsIgnoreCase("sharedsecret")) {
            launcher.lunchSharedSecret();
        } else if (args[0].equalsIgnoreCase("keypair")) {
            launcher.lunchKeyPair();
        } else {
            System.out.println("Invalid parameter");
        }
    }
}
