package Voucher;

import BackEnd.AplicaNimbusLookAndFeel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Voucher extends javax.swing.JFrame {

    MaskFormatter mascaraData;

    public Voucher() {
        initComponents();
        pb.setVisible(false);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        valorTotal.addKeyListener(new ValorMasc(valorTotal, 8, 2));
        valorRecebido.addKeyListener(new ValorMasc(valorRecebido, 8, 2));
        AplicaNimbusLookAndFeel.pegaNimbus();
        Color minhaCor = new Color(204, 255, 204);
        this.getContentPane().setBackground(minhaCor);
        URL url1 = this.getClass().getResource("/Imagens/02.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url1);
        this.setIconImage(iconeTitulo);
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
        buttonGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // All code inside SwingWorker runs on a seperate thread
                pb.setVisible(true);
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    public Void doInBackground() throws InterruptedException {
                        pb.setStringPainted(true);
                        pb.setIndeterminate(true);
                        pb.setForeground(Color.BLUE);
                        pb.setString("CARREGANDO - AGUARDE");
                        buttonGerar.setEnabled(false);
                        buttonSair.setEnabled(false);
                        executa();
                        return null;
                    }

                    @Override
                    public void done() {
                        try {
                            Void doc = get();
                            pb.setString("FINALIZADO");
                            pb.setIndeterminate(false);
                            buttonGerar.setEnabled(true);
                            buttonSair.setEnabled(true);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };

                worker.execute();
            }
        });

    }
    
    public void fechar() {
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        valorTotal = new javax.swing.JTextField();
        valorRecebido = new javax.swing.JTextField();
        in = new javax.swing.JTextField();
        out = new javax.swing.JTextField();
        numPessoas = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox();
        comboAndar = new javax.swing.JComboBox();
        buttonSair = new javax.swing.JButton();
        buttonGerar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        nomeRecepcionista = new javax.swing.JTextField();
        comboLingua = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pb = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerador de Voucher de Entrada");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Hotel Marin Château");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Gerador de Voucher Automático");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome Hóspede");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Valor Total Reserva");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Valor Recebido");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Check-in");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Check-out");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Número de Pessoas");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tipo Suíte");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Andar");

        nome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        valorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        valorRecebido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}

        in  = new JFormattedTextField(mascaraData);
        in.setCaretPosition(0);
        in.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        try{
            mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp){}

        out  = new JFormattedTextField(mascaraData);
        out.setCaretPosition(0);
        out.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        numPessoas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PLATINUM (SEM VISTA MAR)", "GOLDEN (LATERAL - VISTA SACADA)", "DIAMOND (FRENTE MAR)", "MASTER (FRENTE MAR COM HIDROMASSAGEM)" }));

        comboAndar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboAndar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TÉRREO", "SUPERIOR" }));

        buttonSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSair.setText("SAIR");
        buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSairMouseClicked(evt);
            }
        });

        buttonGerar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonGerar.setText("GERAR VOUCHER");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Recepcionista");

        nomeRecepcionista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboLingua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboLingua.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Português", "Espanhol" }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Idioma");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("*Desenvolvido por Danilo de Maria");

        pb.setBackground(new java.awt.Color(204, 255, 204));
        pb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        pb.setForeground(new java.awt.Color(255, 0, 0));
        pb.setOpaque(true);
        pb.setRequestFocusEnabled(false);
        pb.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(144, 144, 144))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(in, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(valorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(nome)
                                                .addComponent(numPessoas)
                                                .addComponent(out)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12))
                                    .addGap(43, 43, 43)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboLingua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nomeRecepcionista)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pb, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(buttonGerar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(valorRecebido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboAndar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nomeRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboLingua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonSairMouseClicked

    public void executa() {

        double vr = 0, vt = 0, total = 0;
        String aux1, aux2, saldo, data, lingua, nomePDF;
        JasperReport jr = null;
        String aux = System.getProperty("user.home") + "/Desktop/Voucher de Entrada/";
        JasperPrint jp = null;
        DecimalFormat formatoDois = new DecimalFormat("R$ ##,###,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
        formatoDois.setMinimumFractionDigits(2);
        formatoDois.setParseBigDecimal(true);
        data = new SimpleDateFormat("dd-MM-yyyy HHmmss").format(Calendar.getInstance().getTime());
        //Conversão de mascara monetária real para double (banco)
        aux1 = valorRecebido.getText();
        aux1 = aux1.replace(".", "");
        aux1 = aux1.replace(",", ".");
        vr = Double.parseDouble(aux1);
        aux2 = valorTotal.getText();
        aux2 = aux2.replace(".", "");
        aux2 = aux2.replace(",", ".");
        vt = Double.parseDouble(aux2);
        total = vt - vr;
        saldo = formatoDois.format(total);

        nomePDF = nome.getText().toUpperCase();

        URL url = this.getClass().getResource("/Imagens/01.jpg");
        BufferedImage img = null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
        }
        if (comboLingua.getSelectedItem().equals("Português")) {

            try {
                jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("Voucher.jrxml"));

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("hospede", nome.getText().toUpperCase());
                params.put("valorTotal", "R$ " + valorTotal.getText());
                params.put("valorRecebido", "R$ " + valorRecebido.getText());
                params.put("in", in.getText());
                params.put("out", out.getText());
                params.put("numPessoas", numPessoas.getText());
                params.put("saldo", saldo);
                params.put("recepcionista", nomeRecepcionista.getText() + ".");
                params.put("tipo", (String) comboTipo.getSelectedItem());
                params.put("andar", (String) comboAndar.getSelectedItem());
                params.put("logo", img);
                jp = JasperFillManager.fillReport(jr, params, new JREmptyDataSource());
                limpaCampos();
                JasperExportManager.exportReportToPdfFile(jp, aux + data + " - " + nomePDF + ".pdf");
                JasperViewer.viewReport(jp, false);
            } catch (JRException ex) {
                Logger.getLogger(Voucher.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                lingua = String.valueOf(comboAndar.getSelectedItem());
                jr = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("VoucherEsp.jrxml"));
                if (lingua.equals("TÉRREO")) {
                    lingua = "PLANTA BAJA";
                }
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("hospede", nome.getText().toUpperCase());
                params.put("valorTotal", "R$ " + valorTotal.getText());
                params.put("valorRecebido", "R$ " + valorRecebido.getText());
                params.put("in", in.getText());
                params.put("out", out.getText());
                params.put("numPessoas", numPessoas.getText());
                params.put("saldo", saldo);
                params.put("recepcionista", nomeRecepcionista.getText() + ".");
                params.put("tipo", (String) comboTipo.getSelectedItem());
                params.put("andar", lingua);
                params.put("logo", img);
                jp = JasperFillManager.fillReport(jr, params, new JREmptyDataSource());
                limpaCampos();
                JasperExportManager.exportReportToPdfFile(jp, aux + data + " - " + nomePDF + ".pdf");
                JasperViewer.viewReport(jp, false);

            } catch (JRException ex) {
                Logger.getLogger(Voucher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void limpaCampos() {
        nomeRecepcionista.setText(null);
        nome.setText(null);
        valorRecebido.setText(null);
        valorTotal.setText(null);
        numPessoas.setText(null);
        in.setText(null);
        out.setText(null);
        comboTipo.setSelectedIndex(0);
        comboAndar.setSelectedIndex(0);
        nome.requestFocus();
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Voucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGerar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JComboBox comboAndar;
    private javax.swing.JComboBox comboLingua;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JTextField in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nomeRecepcionista;
    private javax.swing.JTextField numPessoas;
    private javax.swing.JTextField out;
    private javax.swing.JProgressBar pb;
    private javax.swing.JTextField valorRecebido;
    private javax.swing.JTextField valorTotal;
    // End of variables declaration//GEN-END:variables
}
