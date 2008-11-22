package se.kth.seds.mi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 20, 2008
 * Time: 12:18:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {
    public void lunchSharedSecret() {
        new ClassPathXmlApplicationContext("/spring-config-sharedsecret.xml");
    }

    public void lunchKeyPair() {
        new ClassPathXmlApplicationContext("/spring-config-keypair.xml");
    }
}
