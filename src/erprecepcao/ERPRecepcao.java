package erprecepcao;

import Checkin.Checkin;
import Voucher.Voucher;
import dolar.Dolar;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ERPRecepcao {
    
    static MenuPrincipal menu = new MenuPrincipal();

    public static void main(String[] args) {        
        menu.setVisible(true);
        aplicaSystem();
    }
    
    public static void aplicaSystem() {

        final TrayIcon trayIcon; // declarando uma constante do tipo TrayIcon

        // Aqui vamos testar se o recurso é suportado
        if (SystemTray.isSupported()) {
            //declarando uma variavel  do tipo SystemTray
            SystemTray tray = SystemTray.getSystemTray();
            //declarando uma variavel  do tipo Image que contera a imagem tray.gif
            java.awt.Image image = Toolkit.getDefaultToolkit().getImage(ERPRecepcao.class.getResource("/Imagens/02.png"));
            //Criamos um listener para escutar os eventos de mouse
            MouseListener mouseListener = new MouseListener() {
                public void mouseClicked(MouseEvent e) {

                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mousePressed(MouseEvent e) {
                    //Toda vez que for clicado imprime uma mensagem na tela
                    menu.requestFocus();
                }

                public void mouseReleased(MouseEvent e) {

                }

            };

            // Criamos um ActionListener para a ação de encerramento do programa.
            ActionListener exitListener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };

            ActionListener voucher = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    Voucher booking = new Voucher();
                    booking.setVisible(true);
                }
            };

            ActionListener quiosqueShort = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    Checkin lanca = new Checkin();
                    lanca.setVisible(true);
                }
            };

            ActionListener checkinShort = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    Dolar menuCheck = null;
                    try {
                        menuCheck = new Dolar();
                    } catch (NoSuchFieldException ex) {
                        Logger.getLogger(ERPRecepcao.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(ERPRecepcao.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ERPRecepcao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    menuCheck.setVisible(true);
                }
            };

            // Criamos um ActionListener para a exibir uma mensagem na tela ao clicarmos
            //em um item do menu.
            ActionListener mostramsglistener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    menu.setVisible(true);
                }
            };

            //Criando um objeto PopupMenu
            PopupMenu popup = new PopupMenu("Menu de Opções");

            //criando itens do menu
            MenuItem abrir = new MenuItem("Abrir");
            MenuItem cartao = new MenuItem("Voucher");
            MenuItem quiosque = new MenuItem("Check-in");
            MenuItem checkin = new MenuItem("Dólar");

            MenuItem sair = new MenuItem("Sair");

            //na linha a seguir associamos os objetos aos eventos
            abrir.addActionListener(mostramsglistener);

            sair.addActionListener(exitListener);
            cartao.addActionListener(voucher);
            quiosque.addActionListener(quiosqueShort);
            checkin.addActionListener(checkinShort);
            //Adicionando itens ao PopupMenu
            popup.add(abrir);
            popup.add(cartao);
            popup.add(quiosque);
            popup.add(checkin);
            popup.add(sair);

            trayIcon = new TrayIcon(image, "ERP Marin Château Recepção", popup);

            ActionListener actionListener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {

//                    trayIcon.displayMessage("Marin Château",
//                            "Abrindo aplicação",
//                            TrayIcon.MessageType.INFO);
                    menu.setVisible(true);

                }

            };

            //Na linha a seguir a imagem a ser utilizada como icone sera redimensionada
            trayIcon.setImageAutoSize(true);

            //Seguida adicionamos os actions listeners
            trayIcon.addActionListener(actionListener);

            trayIcon.addMouseListener(mouseListener);

            //Tratamento de erros
            try {

                tray.add(trayIcon);

            } catch (AWTException e) {

                System.err.println("Erro, TrayIcon não sera adicionado.");

            }

        } else {

            //Caso o item  System Tray não for suportado
            JOptionPane.showMessageDialog(null, "recurso ainda não esta disponível pra o seu sistema");

        }

    }
    
}
