package se.kth.seds.mi.ui;

import se.kth.seds.mi.core.crypto.sharedsecret.SharedSecretCrypto;
import se.kth.seds.mi.communication.Client;
import se.kth.seds.mi.communication.MessageWithMac;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 5:25:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class SharedSecretSenderForm implements Form {
    private JPanel panel1;
    private JTextField textFieldSharedSecret;
    private JTextArea textAreaMessage;
    private JComboBox comboBoxHashFunc;
    private JTextArea textAreaGeneratedHash;
    private JButton hashButton;
    private JButton sendButton;

    private static SharedSecretCrypto sharedSecretCrypto;
    private static Client client;

    private static String title;
    private static String sharedSecret;

    public SharedSecretSenderForm() {
        
        textFieldSharedSecret.setText(sharedSecret);

        hashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sharedSecret = textFieldSharedSecret.getText();
                String message = textAreaMessage.getText();
                String algorithm = (String) comboBoxHashFunc.getSelectedItem();
                if (sharedSecret.trim().equals("")) {
                    JOptionPane.showMessageDialog(panel1, "shard secret is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else if (message.trim().equals("")) {
                    JOptionPane.showMessageDialog(panel1, "message is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else {
//                    sharedSecretCrypto.setMessage(message);
//                    sharedSecretCrypto.setSharedSecret(sharedSecret);
//                    sharedSecretCrypto.setAlgorithm(algorithm);
//                    String mac = null;
//                    try {
//                        mac = sharedSecretCrypto.createMAC();
//                    } catch (NoSuchAlgorithmException e1) {
//                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                        JOptionPane.showMessageDialog(panel1, e1.getMessage(), "Crypto Exception", JOptionPane.ERROR_MESSAGE);
//                    }
//                    if (mac != null) {
//                        MessageWithMac messageWithMac = new MessageWithMac();
//                        messageWithMac.setMac(mac);
//                        messageWithMac.setMessage(message);
//                        try {
//                            client.send(messageWithMac);
//                        } catch (IOException e1) {
//                            e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                            JOptionPane.showMessageDialog(panel1, e1.getMessage(), "Network Exception", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }
                    MessageWithMac messageWithMac = new MessageWithMac();
                    messageWithMac.setMac("123");
                    messageWithMac.setMessage("hello world!");
                    try {
                        client.send(messageWithMac);
                    } catch (IOException e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
        });
    }

    public void show() {
        JFrame frame = new JFrame(title);
        frame.setContentPane(new SharedSecretSenderForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

//    public void setSharedSecretCrypto(SharedSecretCrypto sharedSecretCrypto) {
//        this.sharedSecretCrypto = sharedSecretCrypto;
//    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }
}
