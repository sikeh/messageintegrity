package se.kth.seds.mi.communication;

import java.io.IOException;

/**
 * Presents a communication client
 * @author Sike Huang
 */
public interface Client {

    /**
     * Sends object over the communicaion channel
     * @param obj the {@code java.io.Serializable} object to be sent
     * @throws IOException failed in sending, i.e. can't push object into communication channel
     */
    public void send(Object obj) throws IOException;
}
