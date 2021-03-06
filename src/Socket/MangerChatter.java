/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Nhan
 */
public class MangerChatter extends javax.swing.JFrame implements Runnable {

    ServerSocket srvSocket = null;
    BufferedReader br = null;
    Thread t;

    public MangerChatter() {
        initComponents();
        this.setSize(700, 650);

        int serverPort = Integer.parseInt(txtServerPort.getText());
        try {
            srvSocket = new ServerSocket(serverPort);
            this.lbMessage.setText("Mng. Server is running at the port");

        } catch (Exception e) {
            System.out.println("Error");

        }
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                //wait for a client
                Socket aStaffSocket = srvSocket.accept();
                if (aStaffSocket != null) {
                    // if there is a connection
                    // get staffname
                    //when a staff inits a connection , he , she sends his/her name first
                    br = new BufferedReader(new InputStreamReader(aStaffSocket.getInputStream()));
                    String S = br.readLine();
                    int pos = S.indexOf(":"); // format Staff : Hoa
                    String staffName = S.substring(pos + 1); // get name
                    //creat  a tab  for this connection
                    ChatPanel p = new ChatPanel(aStaffSocket, "Manager", staffName);
                    jTabbedPane1.add(staffName, p);
                    p.updateUI();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        txtServerPort = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout());

        lbMessage.setText("Manager Port");
        jPanel1.add(lbMessage);

        txtServerPort.setText("12340");
        jPanel1.add(txtServerPort);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MangerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MangerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MangerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MangerChatter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MangerChatter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JTextField txtServerPort;
    // End of variables declaration//GEN-END:variables

}
