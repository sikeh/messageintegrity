package se.kth.seds.mi.communication;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 7:31:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Server {
    public void init() throws IOException;
    public void read(JTextArea textAreaReceivedMessage, JTextArea textAreaReceivedHash) throws IOException;
}
