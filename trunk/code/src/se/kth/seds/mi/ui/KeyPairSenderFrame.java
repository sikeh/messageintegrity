package se.kth.seds.mi.ui;

import se.kth.seds.mi.core.crypto.keypair.KeyPairCrypto;
import se.kth.seds.mi.core.crypto.keypair.KeyPairIF;
import se.kth.seds.mi.core.crypto.keypair.KeyPairGeneratorIF;
import se.kth.seds.mi.core.exceptions.OperationFailedException;
import se.kth.seds.mi.core.common.HashAlgorithm;
import se.kth.seds.mi.communication.Client;
import se.kth.seds.mi.communication.MessageWithMac;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Sike Huang
 * Date: Nov 21, 2008
 * Time: 5:20:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class KeyPairSenderFrame extends javax.swing.JFrame {
    private KeyPairCrypto keyPairCrypto;
    private Client client;
    private KeyPairGeneratorIF keyPairGeneratorIF;

    private KeyPairIF keyPairIF;

    public void setKeyPairGeneratorIF(KeyPairGeneratorIF keyPairGeneratorIF) {
        this.keyPairGeneratorIF = keyPairGeneratorIF;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setKeyPairCrypto(KeyPairCrypto keyPairCrypto) {
        this.keyPairCrypto = keyPairCrypto;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel_heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_message = new javax.swing.JTextArea();
        jLabel_message = new javax.swing.JLabel();
        jComboBox_hashSignFunc = new javax.swing.JComboBox();
        jLabel_hashSignFunc = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_generatedSignature = new javax.swing.JTextArea();
        jLabel_generatedMac = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_privateKey = new javax.swing.JTextArea();
        jLabel_privateKey = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea_publicKey = new javax.swing.JTextArea();
        jLabel_publicKey = new javax.swing.JLabel();
        jButton_generateKeyPair = new javax.swing.JButton();
        jButton_hashAndSignAndSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jLabel_heading.setText("Key Pair Sender"); // NOI18N
        jLabel_heading.setName("jLabel_heading"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea_message.setColumns(20);
        jTextArea_message.setLineWrap(true);
        jTextArea_message.setRows(5);
        jTextArea_message.setName("jTextArea_message"); // NOI18N
        jScrollPane1.setViewportView(jTextArea_message);

        jLabel_message.setText("Message:"); // NOI18N
        jLabel_message.setName("jLabel_message"); // NOI18N

        jComboBox_hashSignFunc.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        jComboBox_hashSignFunc.setName("jComboBox_hashSignFunc"); // NOI18N

        jLabel_hashSignFunc.setText("Hash & Sign Func:"); // NOI18N
        jLabel_hashSignFunc.setName("jLabel_hashSignFunc"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextArea_generatedSignature.setColumns(20);
        jTextArea_generatedSignature.setEditable(false);
        jTextArea_generatedSignature.setLineWrap(true);
        jTextArea_generatedSignature.setRows(5);
        jTextArea_generatedSignature.setName("jTextArea_generatedSignature"); // NOI18N
        jScrollPane2.setViewportView(jTextArea_generatedSignature);

        jLabel_generatedMac.setText("Generated Signature:"); // NOI18N
        jLabel_generatedMac.setName("jLabel_generatedMac"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTextArea_privateKey.setColumns(20);
        jTextArea_privateKey.setEditable(false);
        jTextArea_privateKey.setLineWrap(true);
        jTextArea_privateKey.setRows(5);
        jTextArea_privateKey.setName("jTextArea_privateKey"); // NOI18N
        jScrollPane3.setViewportView(jTextArea_privateKey);

        jLabel_privateKey.setText("Private Key:"); // NOI18N
        jLabel_privateKey.setName("jLabel_privateKey"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTextArea_publicKey.setColumns(20);
        jTextArea_publicKey.setEditable(false);
        jTextArea_publicKey.setLineWrap(true);
        jTextArea_publicKey.setRows(5);
        jTextArea_publicKey.setName("jTextArea_publicKey"); // NOI18N
        jScrollPane4.setViewportView(jTextArea_publicKey);

        jLabel_publicKey.setText("Public Key:"); // NOI18N
        jLabel_publicKey.setName("jLabel_publicKey"); // NOI18N

        jButton_generateKeyPair.setText("Generate Key Pair"); // NOI18N
        jButton_generateKeyPair.setName("jButton_generateKeyPair"); // NOI18N
        jButton_generateKeyPair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generateKeyPairActionPerformed(evt);
            }
        });

        jButton_hashAndSignAndSend.setText("Hash & Sign & Send"); // NOI18N
        jButton_hashAndSignAndSend.setName("jButton_hashAndSignAndSend"); // NOI18N
        jButton_hashAndSignAndSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_hashAndSignAndSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_generateKeyPair)
                                .addComponent(jLabel_publicKey)
                                .addComponent(jLabel_privateKey)
                                .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_message)
                                        .addComponent(jLabel_hashSignFunc)
                                        .addComponent(jLabel_generatedMac))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jComboBox_hashSignFunc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_hashAndSignAndSend))
                                .addComponent(jLabel_heading))))
                        .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_heading)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_hashSignFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_hashSignFunc)))
                                .addComponent(jLabel_message))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_generatedMac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_privateKey))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel_publicKey))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_generateKeyPair)
                                .addComponent(jButton_hashAndSignAndSend))
                        .addContainerGap(31, Short.MAX_VALUE))
        );

        jComboBox_hashSignFunc.setModel(new DefaultComboBoxModel(HashAlgorithm.values()));
        setVisible(true);
        pack();
    }// </editor-fold>

    private void jButton_hashAndSignAndSendActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTextArea_message.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Message is required!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (jTextArea_privateKey.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Please generate key pair first!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        keyPairCrypto.setHashAlgorithm((HashAlgorithm) jComboBox_hashSignFunc.getSelectedItem());
        try {
            keyPairCrypto.setMessage(jTextArea_message.getText());
            String signature = keyPairCrypto.hashAndSign(keyPairIF.getPrivateKey());
            jTextArea_generatedSignature.setText(signature);
            MessageWithMac messageWithMac = new MessageWithMac();
            messageWithMac.setMessage(jTextArea_message.getText());
            messageWithMac.setMac(signature);
            client.send(messageWithMac);
            client.send(keyPairIF.getPublicKey());
        } catch (OperationFailedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void jButton_generateKeyPairActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            keyPairIF = keyPairGeneratorIF.createKeyPair();
            jTextArea_privateKey.setText(keyPairIF.getPrivateKeyInString());
            jTextArea_publicKey.setText(keyPairIF.getPublicKeyInString());
        } catch (OperationFailedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton_generateKeyPair;
    private javax.swing.JButton jButton_hashAndSignAndSend;
    private javax.swing.JComboBox jComboBox_hashSignFunc;
    private javax.swing.JLabel jLabel_generatedMac;
    private javax.swing.JLabel jLabel_hashSignFunc;
    private javax.swing.JLabel jLabel_heading;
    private javax.swing.JLabel jLabel_message;
    private javax.swing.JLabel jLabel_privateKey;
    private javax.swing.JLabel jLabel_publicKey;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea_generatedSignature;
    private javax.swing.JTextArea jTextArea_message;
    private javax.swing.JTextArea jTextArea_privateKey;
    private javax.swing.JTextArea jTextArea_publicKey;
    // End of variables declaration

}