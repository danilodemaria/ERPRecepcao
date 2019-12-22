package Checkin;

import BackEnd.AplicaNimbusLookAndFeel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Checkin extends javax.swing.JFrame {

    public Checkin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        alteraIcone();
        AplicaNimbusLookAndFeel.pegaNimbus();
        Color minhaCor = new Color(204, 255, 204);
        this.getContentPane().setBackground(minhaCor);
        textNome.requestFocus();
    }
    
    public void fechar(){
        this.dispose();
    }
    
    public void alteraIcone() {
        URL url1 = this.getClass().getResource("/Imagens/02.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url1);
        this.setIconImage(iconeTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonLink = new javax.swing.JButton();
        link = new javax.swing.JTextField();
        buttonSair = new javax.swing.JButton();
        buttonCopia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Check-in Online");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Guarda-sol.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        textNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        textID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID:");

        buttonLink.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonLink.setText("Gerar Link");
        buttonLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLinkActionPerformed(evt);
            }
        });

        link.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        link.setForeground(new java.awt.Color(0, 0, 255));

        buttonSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonCopia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonCopia.setText("Copiar Texto");
        buttonCopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCopiaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Desenvolvido por Danilo de Maria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonSair)
                .addGap(241, 241, 241))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(link)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonLink)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonCopia)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonLink)
                .addGap(18, 18, 18)
                .addComponent(link, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCopia)
                .addGap(18, 18, 18)
                .addComponent(buttonSair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLinkActionPerformed
        String url = "https://www.marinchateau.com/checkin.php?id=";
        String nome = textNome.getText();
        String ID = textID.getText();
        nome = nome.replaceAll(" ", "%20");
        nome = nome.toUpperCase();
        url = url + ID + "&nome=";
        url = url + nome;
        link.setText(url);

    }//GEN-LAST:event_buttonLinkActionPerformed

    private void buttonCopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopiaActionPerformed
        StringSelection stringSelection = new StringSelection(link.getText());
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
         
    }//GEN-LAST:event_buttonCopiaActionPerformed

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        textID.requestFocus();
    }//GEN-LAST:event_textNomeActionPerformed

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        buttonLinkActionPerformed(evt);
    }//GEN-LAST:event_textIDActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCopia;
    private javax.swing.JButton buttonLink;
    private javax.swing.JButton buttonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField link;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
