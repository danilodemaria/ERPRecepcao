package dolar;

import BackEnd.AplicaNimbusLookAndFeel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Dolar extends javax.swing.JFrame {

    double valorAtual = 0;

    public Dolar() throws NoSuchFieldException, FileNotFoundException, ParseException, IOException {
        AplicaNimbusLookAndFeel.pegaNimbus();
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        iniciar();
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    public void fechar() {
        this.dispose();
    }

    public void iniciar() throws NoSuchFieldException, FileNotFoundException, ParseException, IOException {
        String aux;
        String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        dataLabel.setText(data);
        buscaDados();
        aux = String.valueOf(valorAtual);
        dolarAtual.setText(String.format("%.2f", valorAtual));
        dolarCambio.setText(String.format("%.2f", (valorAtual - 0.05)));
        reais.addKeyListener(new ValorMasc(reais, 7, 2));
        dolar.addKeyListener(new ValorMasc(dolar, 7, 2));
        reais.addKeyListener(listener);
        dolar.addKeyListener(listDolar);
        Color minhaCor = new Color(204, 255, 204);
        this.getContentPane().setBackground(minhaCor);
    }

    KeyListener listener = new KeyListener() {

        @Override
        public void keyPressed(KeyEvent event) {
        }

        @Override
        public void keyReleased(KeyEvent event) {
            if (event.getKeyCode() == 17) {
                reais.setText(null);
                dolar.setText(null);
            } else {
                calculateMouseClicked(null);
            }
        }

        @Override
        public void keyTyped(KeyEvent event) {
        }
    };

    KeyListener listDolar = new KeyListener() {

        @Override
        public void keyPressed(KeyEvent event) {
        }

        @Override
        public void keyReleased(KeyEvent event) {
            if (event.getKeyCode() == 17) {
                dolar.setText(null);
                reais.setText(null);
            } else {
                cambio();
            }
        }

        @Override
        public void keyTyped(KeyEvent event) {
        }
    };

    public void cambio() {
        double aux, aux1;
        DecimalFormat df = new DecimalFormat("####.##");
        aux = converteValor(dolar.getText());
        aux1 = Double.parseDouble(dolarCambio.getText().replace(",", "."));
        aux = aux * (aux1);
        reais.setText(String.valueOf(df.format(aux)));
    }

    public void buscaDados() throws NoSuchFieldException, FileNotFoundException, ParseException, MalformedURLException, IOException {

        URL url;
        URLConnection uc;
        StringBuilder parsedContentFromUrl = new StringBuilder();
        String urlString = "https://api.hgbrasil.com/finance/quotations?format=json-cors&key=c55e6599";
        url = new URL(urlString);
        uc = url.openConnection();
        uc.addRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        uc.connect();
        uc.getInputStream();
        BufferedInputStream in = new BufferedInputStream(uc.getInputStream());
        int ch;
        while ((ch = in.read()) != -1) {
            parsedContentFromUrl.append((char) ch);
        }

        valorAtual = Double.parseDouble(parsedContentFromUrl.substring(102, 107));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String aux = String.valueOf(formatter.format(date));

        String dataEmUmFormato = aux;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        Date data = formato.parse(dataEmUmFormato);
        formato.applyPattern("dd/MM/yyyy HH:mm:SS");
        String dataFormatada = formato.format(data);
        textEuro.setText("R$ " + parsedContentFromUrl.substring(168, 173));
        textPeso.setText("R$ " + parsedContentFromUrl.substring(320, 324));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dolarAtual = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dolarCambio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        reais = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dolar = new javax.swing.JTextField();
        calculate = new javax.swing.JButton();
        cleanFields = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        dolarAtual1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textEuro = new javax.swing.JLabel();
        textPeso = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conversor de Dolar");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Guarda-sol.jpg"))); // NOI18N
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 463, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Dolar Atual: R$");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 97, -1, -1));

        dolarAtual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dolarAtual.setForeground(new java.awt.Color(255, 0, 0));
        dolarAtual.setText("jLabel2");
        getContentPane().add(dolarAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 97, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Dolar Câmbio: R$");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 97, -1, -1));

        dolarCambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dolarCambio.setForeground(new java.awt.Color(255, 0, 0));
        dolarCambio.setText("jLabel2");
        getContentPane().add(dolarCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 97, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Valor em R$ ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 159, -1, -1));

        reais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reais.setForeground(new java.awt.Color(0, 0, 255));
        reais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reaisActionPerformed(evt);
            }
        });
        getContentPane().add(reais, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 156, 166, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Valor em US$");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 186, -1, -1));

        dolar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dolar.setForeground(new java.awt.Color(0, 0, 255));
        dolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolarActionPerformed(evt);
            }
        });
        getContentPane().add(dolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 183, 166, -1));

        calculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/shuffle.png"))); // NOI18N
        calculate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateMouseClicked(evt);
            }
        });
        getContentPane().add(calculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 297, -1, -1));

        cleanFields.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cleanFields.setText("Limpar Campos");
        cleanFields.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleanFieldsMouseClicked(evt);
            }
        });
        getContentPane().add(cleanFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 299, -1, -1));

        refresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refresh.setText("Atualizar");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        getContentPane().add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 297, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Taxa de Câmbio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 118, -1, -1));

        dolarAtual1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dolarAtual1.setForeground(new java.awt.Color(255, 0, 0));
        dolarAtual1.setText("R$ 0,05");
        getContentPane().add(dolarAtual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 118, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Data:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 118, -1, -1));

        dataLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataLabel.setForeground(new java.awt.Color(255, 0, 0));
        dataLabel.setText("R$ 0,05");
        getContentPane().add(dataLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 118, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("*Desenvolvido por Danilo de Maria");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 340, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Euro");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, -1, -1));

        textEuro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textEuro.setForeground(new java.awt.Color(255, 0, 0));
        textEuro.setText("jLabel2");
        getContentPane().add(textEuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 234, -1, -1));

        textPeso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textPeso.setForeground(new java.awt.Color(255, 0, 0));
        textPeso.setText("jLabel2");
        getContentPane().add(textPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 255, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Peso");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 255, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reaisActionPerformed
        dolar.requestFocus();
    }//GEN-LAST:event_reaisActionPerformed

    private void cleanFieldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleanFieldsMouseClicked
        reais.setText(null);
        dolar.setText(null);
        reais.requestFocus();
    }//GEN-LAST:event_cleanFieldsMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked

        try {            
            iniciar();
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(null, "Valores atualizados com sucesso!");
        reais.requestFocus();
    }//GEN-LAST:event_refreshMouseClicked

    private void dolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolarActionPerformed
        reais.requestFocus();
    }//GEN-LAST:event_dolarActionPerformed

    private void calculateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculateMouseClicked
        double aux, aux1;
        DecimalFormat df = new DecimalFormat("####.##");
        aux = converteValor(reais.getText());
        aux1 = Double.parseDouble(dolarCambio.getText().replace(",", "."));
        aux = aux / (aux1);
        dolar.setText(String.valueOf(df.format(aux)));
    }//GEN-LAST:event_calculateMouseClicked

    public double converteValor(String aux) {
        aux = aux.replace(".", "");
        aux = aux.replace(",", ".");
        return Double.parseDouble(aux);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dolar().setVisible(true);
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Dolar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calculate;
    private javax.swing.JButton cleanFields;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JTextField dolar;
    private javax.swing.JLabel dolarAtual;
    private javax.swing.JLabel dolarAtual1;
    private javax.swing.JLabel dolarCambio;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField reais;
    private javax.swing.JButton refresh;
    private javax.swing.JLabel textEuro;
    private javax.swing.JLabel textPeso;
    // End of variables declaration//GEN-END:variables
}
