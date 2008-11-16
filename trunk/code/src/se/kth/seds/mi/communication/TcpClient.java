package se.kth.seds.mi.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 7:20:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TcpClient implements Client{
    private Log logger = LogFactory.getLog(getClass());
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private String host;
    private int port;

    public void init() throws IOException {
        socket = new Socket(host, port);
        logger.info("Client ready on " + socket);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public void send(Object obj) throws IOException {
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void destory() throws IOException {
        objectOutputStream.close();
        socket.close();
    }
}
