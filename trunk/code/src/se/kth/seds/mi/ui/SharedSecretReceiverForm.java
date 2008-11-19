package se.kth.seds.mi.ui;

import se.kth.seds.mi.communication.Server;
import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.core.crypto.sharedsecret.SharedSecretCrypto;
import se.kth.seds.mi.core.exceptions.OperationFailedException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 16, 2008
 * Time: 6:33:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class SharedSecretReceiverForm implements Form {
    // ui properties
    private JTextArea textAreaReceivedMessage;
    private JTextField textFieldSharedSecret;
    private JComboBox comboBoxHashFunc;
    private JTextArea textAreaReceivedHash;
    private JTextArea textAreaGeneratedHash;
    private JButton hashButton;
    private JPanel panel1;

    // injected properties
    private String title;
    private String sharedSecret;
    private Server server;
    private SharedSecretCrypto sharedSecretCrypto;

    public SharedSecretReceiverForm() {

        ComboBoxModel comboBoxModel = new DefaultComboBoxModel(HashAlgorithm.values());
        comboBoxHashFunc.setModel(comboBoxModel);

        hashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String receivedMac = textAreaReceivedHash.getText();
                String receivedMessage = textAreaReceivedMessage.getText();
                sharedSecret = textFieldSharedSecret.getText();
                if (receivedMac.trim().equals("")) {
                    JOptionPane.showMessageDialog(panel1, "No message has been received", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                // calculate MAC on server side, and compare it with the one received from client                
                HashAlgorithm hashAlgorithm = (HashAlgorithm) comboBoxHashFunc.getSelectedItem();
                sharedSecretCrypto.setHashAlgorithm(hashAlgorithm);
                sharedSecretCrypto.setMessage(receivedMessage);
                sharedSecretCrypto.setSharedSecret(sharedSecret);
                try {
                    String mac = sharedSecretCrypto.createMAC();
                    textAreaGeneratedHash.setText(mac);
                    if (mac.equals(receivedMac)) {
                        JOptionPane.showMessageDialog(panel1, "Valid, hashes match", "Mesage Integrity", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panel1, "Invalid, hashes contradict, please check your shared secert and hash func", "Mesage Integrity", JOptionPane.ERROR_MESSAGE);                        
                    }
                } catch (OperationFailedException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    JOptionPane.showMessageDialog(panel1, e1.getMessage(), "Crypto Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void show() {
        JFrame frame = new JFrame(title);
        SharedSecretReceiverForm sharedSecretReceiverForm = new SharedSecretReceiverForm();
        sharedSecretReceiverForm.textFieldSharedSecret.setText(sharedSecret);
        sharedSecretReceiverForm.setServer(server);
        sharedSecretReceiverForm.setSharedSecretCrypto(sharedSecretCrypto);
        frame.setContentPane(sharedSecretReceiverForm.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        // start server
        try {
            server.read(sharedSecretReceiverForm.textAreaReceivedMessage, sharedSecretReceiverForm.textAreaReceivedHash);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            JOptionPane.showMessageDialog(null, e.getMessage(), "Network Exception", JOptionPane.ERROR_MESSAGE);
        }
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

    public void setSharedSecretCrypto(SharedSecretCrypto sharedSecretCrypto) {
        this.sharedSecretCrypto = sharedSecretCrypto;
    }
}
