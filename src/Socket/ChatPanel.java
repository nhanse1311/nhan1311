/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author Nhan
 */
public class ChatPanel extends javax.swing.JPanel {

    File file;
    Socket socket = null;
    BufferedReader bf = null;
    DataOutputStream os = null;
    OutputThreads t = null;
    String sender;
    String receiver;
    boolean changed = true;
    CardLayout cl =new CardLayout();
    
    /**
     * Creates new form ChatPanel
     */
    public ChatPanel(Socket s, String sender, String receiver) {
        initComponents();
        this.setSize(700, 400);
        jPanelCvsE.add(jpMessage,"mess");
        jPanelCvsE.add(jpEmoji, "emoji");
        cl =  (CardLayout)(this.jPanelCvsE.getLayout());
        cl.show(jPanelCvsE, "mess");
        try {
            BufferedImage imageSend = ImageIO.read(new File("send.png"));
            BufferedImage imageFile = ImageIO.read(new File("file.png"));
            BufferedImage imageEmoji = ImageIO.read(new File("emoji.png"));
            ImageIcon icon = new ImageIcon(imageSend.getScaledInstance(70, 50, BufferedImage.SCALE_AREA_AVERAGING));
            ImageIcon icon2 = new ImageIcon(imageFile.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            ImageIcon icon3 = new ImageIcon(imageEmoji.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            btnsend.setIcon(icon);
            btnFile.setIcon(icon2);
            btnEmoji.setIcon(icon3);
            BufferedImage emjSmile = ImageIO.read(new File("smile.png"));
            ImageIcon ieSmile = new ImageIcon(emjSmile.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eSmile.setIcon(ieSmile);
            BufferedImage emjSmile2 = ImageIO.read(new File("smile2.png"));
            ImageIcon ieSmile2 = new ImageIcon(emjSmile2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eSmile2.setIcon(ieSmile2);
            BufferedImage emjSad = ImageIO.read(new File("sad.png"));
            ImageIcon ieSad = new ImageIcon(emjSad.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eSad.setIcon(ieSad);
            BufferedImage emjSad2 = ImageIO.read(new File("sad2.png"));
            ImageIcon ieSad2 = new ImageIcon(emjSad2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eSad2.setIcon(ieSad2);
            BufferedImage emjSad3 = ImageIO.read(new File("sad3.png"));
            ImageIcon ieSad3 = new ImageIcon(emjSad3.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eSad3.setIcon(ieSad3);
            BufferedImage emLOL = ImageIO.read(new File("LOL.png"));
            ImageIcon ieLOL = new ImageIcon(emLOL.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eLOL.setIcon(ieLOL);
            BufferedImage emLOL2 = ImageIO.read(new File("LOL2.png"));
            ImageIcon ieLOL2 = new ImageIcon(emLOL2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eLOL2.setIcon(ieLOL2);
            BufferedImage emLOL3 = ImageIO.read(new File("LOL3.png"));
            ImageIcon ieLOL3 = new ImageIcon(emLOL3.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eLOL3.setIcon(ieLOL3);
            BufferedImage emjEye = ImageIO.read(new File("eye.png"));
            ImageIcon iejEye = new ImageIcon(emjEye.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eEye.setIcon(iejEye);
            BufferedImage emjEye2 = ImageIO.read(new File("eye.png"));
            ImageIcon iejEye2 = new ImageIcon(emjEye2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eEye2.setIcon(iejEye2);
            BufferedImage emjTon = ImageIO.read(new File("ton.png"));
            ImageIcon iejTon = new ImageIcon(emjTon.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eTongue.setIcon(iejTon);
            BufferedImage emjTon2 = ImageIO.read(new File("ton2.png"));
            ImageIcon iejTon2 = new ImageIcon(emjTon2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eTongue2.setIcon(iejTon2);
            BufferedImage emjKiss = ImageIO.read(new File("kiss.png"));
            ImageIcon iejKiss = new ImageIcon(emjKiss.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eKiss.setIcon(iejKiss);
            BufferedImage emjKiss2 = ImageIO.read(new File("kiss2.png"));
            ImageIcon iejKiss2 = new ImageIcon(emjKiss2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eKiss2.setIcon(iejKiss2);
            BufferedImage emjHeart = ImageIO.read(new File("heart.png"));
            ImageIcon iejHeart = new ImageIcon(emjHeart.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eHeart.setIcon(iejHeart);
            BufferedImage emjCute = ImageIO.read(new File("cute.png"));
            ImageIcon iejCute = new ImageIcon(emjCute.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eCute.setIcon(iejCute);
            BufferedImage emjAngry = ImageIO.read(new File("angry.png"));
            ImageIcon iejAngry = new ImageIcon(emjAngry.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eAngry.setIcon(iejAngry);
            BufferedImage emjCry = ImageIO.read(new File("sup.png"));
            ImageIcon iejCry = new ImageIcon(emjCry.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eCry.setIcon(iejCry);
            BufferedImage emjCry2 = ImageIO.read(new File("cry2.png"));
            ImageIcon iejCry2 = new ImageIcon(emjCry2.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eCry2.setIcon(iejCry2);
            BufferedImage emjLag = ImageIO.read(new File("lag.png"));
            ImageIcon iejLag = new ImageIcon(emjLag.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eLagging.setIcon(iejLag);
            BufferedImage emjSup = ImageIO.read(new File("sup2.png"));
            ImageIcon iejSup = new ImageIcon(emjSup.getScaledInstance(30, 30, BufferedImage.SCALE_AREA_AVERAGING));
            eSurprise.setIcon(iejSup);
        } catch (Exception e) {
        }
        socket = s;
        this.sender = sender;
        this.receiver = receiver;
        try {
            // Input buffer and output buffer
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new DataOutputStream(socket.getOutputStream());
            t = new OutputThreads(s, txtMessages, sender, receiver);
            t.start();
        } catch (Exception e) {
        }

    }

    public JTextArea getTxtMessages() {
        return this.txtMessages;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanelCvsE = new javax.swing.JPanel();
        jpMessage = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        jpEmoji = new javax.swing.JPanel();
        eSmile = new javax.swing.JButton();
        eSmile2 = new javax.swing.JButton();
        eSad = new javax.swing.JButton();
        eSad2 = new javax.swing.JButton();
        eLOL = new javax.swing.JButton();
        eLOL2 = new javax.swing.JButton();
        eEye = new javax.swing.JButton();
        eEye2 = new javax.swing.JButton();
        eTongue = new javax.swing.JButton();
        eTongue2 = new javax.swing.JButton();
        eKiss = new javax.swing.JButton();
        eKiss2 = new javax.swing.JButton();
        eHeart = new javax.swing.JButton();
        eCute = new javax.swing.JButton();
        eAngry = new javax.swing.JButton();
        eCry = new javax.swing.JButton();
        eSad3 = new javax.swing.JButton();
        eCry2 = new javax.swing.JButton();
        eLOL3 = new javax.swing.JButton();
        eLagging = new javax.swing.JButton();
        eSurprise = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnsend = new javax.swing.JButton();
        btnFile = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnEmoji = new javax.swing.JButton();
        btnDisconnecet = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessages = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setPreferredSize(new java.awt.Dimension(166, 60));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanelCvsE.setLayout(new java.awt.CardLayout());

        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtMessage.setRows(5);
        jpMessage.setViewportView(txtMessage);

        jPanelCvsE.add(jpMessage, "card2");

        jpEmoji.setLayout(new java.awt.GridLayout(7, 0));

        eSmile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSmileActionPerformed(evt);
            }
        });
        jpEmoji.add(eSmile);

        eSmile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSmile2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eSmile2);

        eSad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSadActionPerformed(evt);
            }
        });
        jpEmoji.add(eSad);

        eSad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSad2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eSad2);

        eLOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eLOLActionPerformed(evt);
            }
        });
        jpEmoji.add(eLOL);

        eLOL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eLOL2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eLOL2);

        eEye.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eEyeActionPerformed(evt);
            }
        });
        jpEmoji.add(eEye);

        eEye2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eEye2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eEye2);

        eTongue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eTongueActionPerformed(evt);
            }
        });
        jpEmoji.add(eTongue);

        eTongue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eTongue2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eTongue2);

        eKiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eKissActionPerformed(evt);
            }
        });
        jpEmoji.add(eKiss);

        eKiss2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eKiss2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eKiss2);

        eHeart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eHeartActionPerformed(evt);
            }
        });
        jpEmoji.add(eHeart);

        eCute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCuteActionPerformed(evt);
            }
        });
        jpEmoji.add(eCute);

        eAngry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eAngryActionPerformed(evt);
            }
        });
        jpEmoji.add(eAngry);

        eCry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCryActionPerformed(evt);
            }
        });
        jpEmoji.add(eCry);

        eSad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSad3ActionPerformed(evt);
            }
        });
        jpEmoji.add(eSad3);

        eCry2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCry2ActionPerformed(evt);
            }
        });
        jpEmoji.add(eCry2);

        eLOL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eLOL3ActionPerformed(evt);
            }
        });
        jpEmoji.add(eLOL3);

        eLagging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eLaggingActionPerformed(evt);
            }
        });
        jpEmoji.add(eLagging);

        eSurprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSurpriseActionPerformed(evt);
            }
        });
        jpEmoji.add(eSurprise);

        jPanelCvsE.add(jpEmoji, "card3");

        jPanel2.add(jPanelCvsE);

        jPanel3.setLayout(new java.awt.GridLayout(3, 2, 2, 2));

        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });
        jPanel3.add(btnsend);

        btnFile.setFont(new java.awt.Font("Yu Mincho Light", 1, 13)); // NOI18N
        btnFile.setText("Send File");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        jPanel3.add(btnFile);

        jPanel4.setLayout(new java.awt.GridLayout());

        btnEmoji.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEmoji.setText("Open");
        btnEmoji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmojiActionPerformed(evt);
            }
        });
        jPanel4.add(btnEmoji);

        btnDisconnecet.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDisconnecet.setText("Disconnect");
        btnDisconnecet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnecetActionPerformed(evt);
            }
        });
        jPanel4.add(btnDisconnecet);

        jPanel3.add(jPanel4);

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(166, 150));

        txtMessages.setColumns(20);
        txtMessages.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtMessages.setRows(5);
        jScrollPane2.setViewportView(txtMessages);

        add(jScrollPane2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // TODO add your handling code here:
        if (txtMessage.getText().trim().length() == 0) {
            return;
        }
        try {
            os.writeBytes(txtMessage.getText());
            os.write(13);
            os.write(10);
            os.flush();
            this.txtMessages.append("\n" + sender + ": " + txtMessage.getText());
            txtMessage.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnsendActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        StringBuilder sb = new StringBuilder();
        if (fc.showDialog(this, "Select your File") == JFileChooser.APPROVE_OPTION) {
            try {
                file = fc.getSelectedFile();
                fc.setSize(700, 400);
                try (BufferedReader sc = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                    
                    String msg;
                    while ((msg = sc.readLine()) != null) {
                        sb.append("\n");
                        sb.append(msg);
                        sb.append("\n");
                    }
                }
            } catch (Exception e) {
            }
        } else {
            sb.append("No file was selected ");

        }
        try {
            String filename = file.getName();
            String msg = "\n" + sender + "- FileName://|" + filename + "|" + sb;
            os.writeBytes(msg);
            os.write(13);
            os.write(10);
            os.flush();
            txtMessages.append(sender + " - FileName://|" + filename + "\n");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnDisconnecetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnecetActionPerformed
        // TODO add your handling code here:
        try {
            String dis= "\n" + sender + " is offlined! ";
            os.writeBytes(dis);
            os.write(13);
            os.write(10);
            os.flush();
            txtMessages.append(dis);
        } catch (Exception e) {
        }
        System.exit(0);
    }//GEN-LAST:event_btnDisconnecetActionPerformed

    private void btnEmojiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmojiActionPerformed
        // TODO add your handling code here:
        
        if (changed) {
            btnEmoji.setText("Close");
            cl.show(jPanelCvsE, "emoji");
            changed=false;
        }
        else if (changed==false) {
            btnEmoji.setText("Open");
            cl.show(jPanelCvsE, "mess");
            changed=true;
        }
    }//GEN-LAST:event_btnEmojiActionPerformed

    private void eSmileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSmileActionPerformed
        // TODO add your handling code here:
        String s = ":-)";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eSmileActionPerformed

    private void eSmile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSmile2ActionPerformed
        // TODO add your handling code here:
        String s = ":)";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eSmile2ActionPerformed

    private void eSadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSadActionPerformed
        // TODO add your handling code here:
        String s = ":-(";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eSadActionPerformed

    private void eSad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSad2ActionPerformed
        // TODO add your handling code here:
        String s = ":(";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eSad2ActionPerformed

    private void eLOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eLOLActionPerformed
        // TODO add your handling code here:
        String s = ":-D";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eLOLActionPerformed

    private void eLOL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eLOL2ActionPerformed
        // TODO add your handling code here:
        String s = ":D";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eLOL2ActionPerformed

    private void eSurpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSurpriseActionPerformed
        // TODO add your handling code here:
        String s = ":-|";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eSurpriseActionPerformed

    private void eLaggingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eLaggingActionPerformed
        // TODO add your handling code here:
        String s = ":/";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eLaggingActionPerformed

    private void eLOL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eLOL3ActionPerformed
        // TODO add your handling code here:
        String s = "xD";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eLOL3ActionPerformed

    private void eCry2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCry2ActionPerformed
        // TODO add your handling code here:
        String s = ":'(";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eCry2ActionPerformed

    private void eSad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSad3ActionPerformed
        // TODO add your handling code here:
        String s = ":-[";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eSad3ActionPerformed

    private void eCryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCryActionPerformed
        // TODO add your handling code here:
        String s = "=O";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eCryActionPerformed

    private void eAngryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eAngryActionPerformed
        // TODO add your handling code here:
        String s = ">:[";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eAngryActionPerformed

    private void eCuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCuteActionPerformed
        // TODO add your handling code here:
        String s = ":3";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eCuteActionPerformed

    private void eHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eHeartActionPerformed
        // TODO add your handling code here:
        String s = "<3";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eHeartActionPerformed

    private void eKiss2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eKiss2ActionPerformed
        // TODO add your handling code here:
        String s = ":*";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eKiss2ActionPerformed

    private void eKissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eKissActionPerformed
        // TODO add your handling code here:
        String s = ":-*";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eKissActionPerformed

    private void eTongue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eTongue2ActionPerformed
        // TODO add your handling code here:
        String s = ":p";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eTongue2ActionPerformed

    private void eTongueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eTongueActionPerformed
        // TODO add your handling code here:
        String s = ":-p";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eTongueActionPerformed

    private void eEye2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eEye2ActionPerformed
        // TODO add your handling code here:
        String s = ";)";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eEye2ActionPerformed

    private void eEyeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eEyeActionPerformed
        // TODO add your handling code here:
        String s = ";-)";
        Emoji emj = new Emoji();
        txtMessage.setText(emj.replaceInText(s, changed));
    }//GEN-LAST:event_eEyeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDisconnecet;
    private javax.swing.JButton btnEmoji;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnsend;
    private javax.swing.JButton eAngry;
    private javax.swing.JButton eCry;
    private javax.swing.JButton eCry2;
    private javax.swing.JButton eCute;
    private javax.swing.JButton eEye;
    private javax.swing.JButton eEye2;
    private javax.swing.JButton eHeart;
    private javax.swing.JButton eKiss;
    private javax.swing.JButton eKiss2;
    private javax.swing.JButton eLOL;
    private javax.swing.JButton eLOL2;
    private javax.swing.JButton eLOL3;
    private javax.swing.JButton eLagging;
    private javax.swing.JButton eSad;
    private javax.swing.JButton eSad2;
    private javax.swing.JButton eSad3;
    private javax.swing.JButton eSmile;
    private javax.swing.JButton eSmile2;
    private javax.swing.JButton eSurprise;
    private javax.swing.JButton eTongue;
    private javax.swing.JButton eTongue2;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCvsE;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpEmoji;
    private javax.swing.JScrollPane jpMessage;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextArea txtMessages;
    // End of variables declaration//GEN-END:variables
}
