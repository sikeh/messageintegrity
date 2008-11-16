package se.kth.seds.mi.ui;

import se.kth.seds.mi.communication.MessageWithMac;
import se.kth.seds.mi.communication.Server;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 6:33:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SharedSecretReceiverForm implements Form {
    private JTextArea textAreaReceivedMessage;
    private JTextField textFieldSharedSecret;
    private JComboBox comboBoxHashFunc;
    private JTextArea textAreaReceivedHash;
    private JTextArea textAreaGeneratedHash;
    private JButton hashButton;
    private JPanel panel1;

    private static String title;
    private static String sharedSecret;

    private static Server server;

    public SharedSecretReceiverForm() {
        textFieldSharedSecret.setText(sharedSecret);

        hashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(textFieldSharedSecret.getText());
                textFieldSharedSecret.setText(sharedSecret);
            }
        });


    }

    public void show() {
        JFrame frame = new JFrame(title);
        SharedSecretReceiverForm sharedSecretReceiverForm = new SharedSecretReceiverForm();
        frame.setContentPane(sharedSecretReceiverForm.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
//        new Thread() {
//            public void run() {
        try {
            server.read(sharedSecretReceiverForm.textAreaReceivedMessage, sharedSecretReceiverForm.textAreaReceivedHash);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            JOptionPane.showMessageDialog(null, e.getMessage(), "Network Exception", JOptionPane.ERROR_MESSAGE);
        }
//            }
//        }.start();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
