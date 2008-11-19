package se.kth.seds.mi.communication;

import java.io.Serializable;

/**
 * The {@code java.io.Serializable} object sent over communication channel, it encapsulates message itself and its corresponding MAC
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
