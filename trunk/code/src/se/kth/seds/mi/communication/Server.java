package se.kth.seds.mi.communication;

import javax.swing.*;
import java.io.IOException;
import java.security.PublicKey;

/**
 * Presents a communication server
 * @author Sike Huang
 */
public interface Server {

    /**
     * Reads object sent from client from communicaion channel
     * @param frame UI frame used to show the received object
     */
    public void read(JFrame frame) throws IOException;
}
