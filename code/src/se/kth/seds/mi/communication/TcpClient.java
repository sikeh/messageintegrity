package se.kth.seds.mi.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Presents a TCP client
 * @author Sike Huang
 */
public class TcpClient implements Client{
    private Log logger = LogFactory.getLog(getClass());
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private String host;
    private int port;

    /**
     * Initializes communication client, e.g. open socket
     * @throws IOException failed in initialization, e.g. socket can't be opened
     */
    public void init() throws IOException {
        socket = new Socket(host, port);
        logger.info("Client ready on " + socket);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * Destroys communication client, i.e. release resource
     * @throws IOException failed in destroying, e.g. socket can't be colsed
     */
    public void destory() throws IOException {
        objectOutputStream.close();
        socket.close();
    }
}
