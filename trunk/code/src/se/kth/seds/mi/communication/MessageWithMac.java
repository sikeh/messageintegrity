package se.kth.seds.mi.communication;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 6:54:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessageWithMac implements Serializable {
    private String message;
    private String mac;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
}
