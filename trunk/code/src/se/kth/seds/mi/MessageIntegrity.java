package se.kth.seds.mi;

import se.kth.seds.mi.ui.SharedSecretReceiverForm;
import se.kth.seds.mi.ui.Form;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 9:56:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageIntegrity {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        
        Form sharedSecretReceiverForm = (Form) context.getBean("sharedSecretReceiverForm");
        sharedSecretReceiverForm.show();

        Form sharedSecretSenderForm = (Form) context.getBean("sharedSecretSenderForm");
        sharedSecretSenderForm.show();
    }
}
