package se.kth.seds.mi.communication;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 7:20:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Client {
    public void init() throws IOException;
    public void send(Object obj) throws IOException;
}
