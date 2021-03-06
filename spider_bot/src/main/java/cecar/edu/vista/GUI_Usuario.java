/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecar.edu.vista;

import cecar.edu.componentesReutilizable.ConectarMySQL;
import cecar.edu.componentesReutilizable.TextPrompt;
import cecar.edu.controlador.ControladorPaginaDAO;
import cecar.edu.controlador.ControladorScraping;
import cecar.edu.modelo.Pagina;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.validator.UrlValidator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ProFanor
 */
public class GUI_Usuario extends javax.swing.JFrame {

    FileInputStream fis;
    int longitudBytes;

    /**
     * Creates new form GUI_Usuario
     */
    public GUI_Usuario() {
        initComponents();
        TextPrompt url = new TextPrompt("URL *", JTextUrl);
        TextPrompt num = new TextPrompt("Nº Limite de paginas *", jTextField2);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JTextUrl = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3url = new javax.swing.JLabel();
        jLabel3tipoArchivo = new javax.swing.JLabel();
        jLabel3fechayhora = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scraping (spider-bot)");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(3, 5, 850, 70);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 860, 80);

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Scraping");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 204), null));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(0, 90, 130, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Consultar");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(0, 200, 130, 50);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 80, 130, 410);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        JTextUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextUrlActionPerformed(evt);
            }
        });
        JTextUrl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTextUrlKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTextUrlKeyTyped(evt);
            }
        });
        jPanel3.add(JTextUrl);
        JTextUrl.setBounds(20, 30, 590, 30);

        jButton2.setBackground(new java.awt.Color(0, 0, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fanorpro\\Documents\\NetBeansProjects\\proyectospider-bot\\spider_bot\\src\\main\\java\\cecar\\edu\\vista\\icons8-limpieza-de-alfombras-25.png")); // NOI18N
        jButton2.setText("Comenzar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(490, 93, 120, 40);

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel3.add(jTextField2);
        jTextField2.setBounds(20, 90, 180, 30);

        jPanel5.add(jPanel3);
        jPanel3.setBounds(30, 30, 650, 160);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(130, 80, 730, 410);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(null);

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        jPanel7.add(jLabel2);
        jLabel2.setBounds(40, 50, 130, 120);

        jButton4.setText("Cargar imagen");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4);
        jButton4.setBounds(40, 170, 130, 32);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de busqueda"));
        jPanel1.setLayout(null);

        jLabel3url.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3url.setText("URL: ");
        jPanel1.add(jLabel3url);
        jLabel3url.setBounds(20, 30, 460, 40);

        jLabel3tipoArchivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3tipoArchivo.setText("Tipo de Archivo:");
        jPanel1.add(jLabel3tipoArchivo);
        jLabel3tipoArchivo.setBounds(20, 130, 460, 40);

        jLabel3fechayhora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3fechayhora.setText("Fecha y Hora:");
        jPanel1.add(jLabel3fechayhora);
        jLabel3fechayhora.setBounds(20, 80, 460, 40);

        jPanel7.add(jPanel1);
        jPanel1.setBounds(190, 40, 500, 340);

        jButton5.setText("Burcar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5);
        jButton5.setBounds(40, 330, 130, 50);

        getContentPane().add(jPanel7);
        jPanel7.setBounds(130, 80, 730, 410);

        setSize(new java.awt.Dimension(872, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:

        //Validacion de numeros.
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo números");
        }
        if (jTextField2.getText().length() >= 10) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    void cursorCargando() {

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jPanel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jPanel3.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jPanel4.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jPanel5.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        jPanel7.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

    }

    void cursorDefault() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jPanel3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jPanel4.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jPanel5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        jPanel7.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            int recorrer=Integer.parseInt(jTextField2.getText());
            if (Integer.parseInt(jTextField2.getText()) >= 0) {
                cursorCargando();
                String url = JTextUrl.getText();
                //Validar URL
                if (urlValidator(url)) {
                    try {
                        //comienza el scraping
                        ControladorScraping.getPagina(url);
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        cursorDefault();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La url dada " + JTextUrl.getText() + " NO es válida");
                    JTextUrl.setText("");
                    cursorDefault();
                }
                for(int c=0;c<recorrer;c++){
                    if (urlValidator(ControladorScraping.paginasEncontradas.get(c))) {
                    try {
                        //comienza el scraping
                        ControladorScraping.getPagina(ControladorScraping.paginasEncontradas.get(c));
                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        cursorDefault();
                    }
                }
                    ControladorScraping.paginasEncontradas.clear();
                }
            }
             cursorDefault();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Porfavor ponga limite de paginas");
            jTextField2.setFocusable(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void JTextUrlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextUrlKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextUrlKeyTyped

    private void JTextUrlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextUrlKeyPressed

    }//GEN-LAST:event_JTextUrlKeyPressed

    private void JTextUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextUrlActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel7.setVisible(true);
        jPanel5.setVisible(false);

        jButton4.setVisible(true);
        jButton5.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel7.setVisible(false);
        jPanel5.setVisible(true);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed
    JFileChooser j = null;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jLabel2.setIcon(null);
        j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas
        int estado = j.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(j.getSelectedFile());
                //necesitamos saber la cantidad de bytes
                this.longitudBytes = (int) j.getSelectedFile().length();
                try {
                    Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT);
                    jLabel2.setIcon(new ImageIcon(icono));
                    jLabel2.updateUI();
                    System.out.println(j.getSelectedFile());

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "imagen: " + ex);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            // TODO add your handling code here:
            ControladorPaginaDAO controladorPaginaDAO = new ControladorPaginaDAO();
            Pagina pagina = new Pagina();
            pagina = controladorPaginaDAO.consultar(j.getSelectedFile() + "", this.longitudBytes);
            if (pagina != null) {
                jLabel3url.setText("URL: " + pagina.getUrl());
                jLabel3fechayhora.setText("Fecha y Hora: " + pagina.getFecha());
                jLabel3tipoArchivo.setText("Tipo de archivo: "+ControladorPaginaDAO.tipoA);
            } else {
                JOptionPane.showMessageDialog(null, "no encontrada");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "verifiqui img");
            Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    public static boolean urlValidator(String url) {
        //validación de url

        UrlValidator defaultValidator = new UrlValidator();
        return defaultValidator.isValid(url);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
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
            java.util.logging.Logger.getLogger(GUI_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(GUI_Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                new GUI_Usuario().setVisible(true);

            }
        });
        ConectarMySQL.getConectarMySQL();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextUrl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3fechayhora;
    private javax.swing.JLabel jLabel3tipoArchivo;
    private javax.swing.JLabel jLabel3url;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
