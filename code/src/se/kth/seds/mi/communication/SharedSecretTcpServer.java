package se.kth.seds.mi.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;

import se.kth.seds.mi.ui.KeyPairReceiverFrame;
import se.kth.seds.mi.ui.SharedSecretReceiverFrame;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 7:32:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class SharedSecretTcpServer implements Server {
    private Log logger = LogFactory.getLog(getClass());

    private ServerSocket serverSocket;
    private int port;

    public void init() throws IOException {
        serverSocket = new ServerSocket(port);
        logger.info("Server ready, listenning on: " + serverSocket);
    }

    /**
     * {@inheritDoc}
     */
    public void read(final JFrame frame) throws IOException {
        Socket socket = serverSocket.accept();
        logger.info("Client from " + socket.getRemoteSocketAddress() + " connected!");
        final ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        MessageWithMac messageWithMac = (MessageWithMac) objectInputStream.readObject();
                        logger.info("received Message: " + messageWithMac.getMessage() + ", with MAC: " + messageWithMac.getMac());
                        SharedSecretReceiverFrame receiverFrame = (SharedSecretReceiverFrame) frame;
                        receiverFrame.setReceivedMessage(messageWithMac.getMessage());
                        receiverFrame.setReceivedMac(messageWithMac.getMac());
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        }.start();
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void destory() throws IOException {
        serverSocket.close();
    }
}