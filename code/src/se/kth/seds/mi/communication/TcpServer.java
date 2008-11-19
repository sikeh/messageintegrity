package se.kth.seds.mi.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 7:32:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class TcpServer implements Server {
    private Log logger = LogFactory.getLog(getClass());

    private ServerSocket serverSocket;
    private int port;

    public void init() throws IOException {
        serverSocket = new ServerSocket(port);
        logger.info("Server ready, listenning on: " + serverSocket);
    }

    public void read(final JTextArea textAreaReceivedMessage, final JTextArea textAreaReceivedHash) throws IOException {
        Socket socket = serverSocket.accept();
        logger.info("Client from " + socket.getRemoteSocketAddress() + " connected!");
        final ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        MessageWithMac messageWithMac = (MessageWithMac) objectInputStream.readObject();
                        logger.info("received Message: " + messageWithMac.getMessage() + ", with MAC: " + messageWithMac.getMac());
                        textAreaReceivedMessage.setText(messageWithMac.getMessage());
                        textAreaReceivedHash.setText(messageWithMac.getMac());
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
