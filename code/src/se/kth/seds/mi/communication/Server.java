package se.kth.seds.mi.communication;

import javax.swing.*;
import java.io.IOException;

/**
 * Presents a communication server
 * @author Sike Huang
 */
public interface Server {
    /**
     * Reads data from communication channel sent from client
     * @param textAreaReceivedMessage UI field that will be updated with value of received message from client
     * @param textAreaReceivedHash UI field that will be updated with value of received MAC from client
     * @throws IOException failed in reading data
     */
    public void read(JTextArea textAreaReceivedMessage, JTextArea textAreaReceivedHash) throws IOException;
}
