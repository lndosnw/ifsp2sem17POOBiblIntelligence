/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.view;

import javax.swing.JOptionPane;
import pedrosantos.hto.ifsp.bibintelligence.controller.BibIntelligence;

/**
 *
 * @author a1520784
 */
public class REPerg extends javax.swing.JFrame {

    /**
     * Creates new form REPerg
     */
    
    
    public int livro;
    
    private REPerg() {
        initComponents();
    }
    private static REPerg instancia;
    public static REPerg getInstancia(){
        if (instancia == null){
            instancia = new REPerg();
        }
        return instancia;
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
        lbPergunta = new javax.swing.JLabel();
        btParaSi = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btParaOutro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emprestimo");

        lbPergunta.setText("Para Quem Se Destina O Empréstimo");

        btParaSi.setText("Para Mim");
        btParaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParaSiActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btParaOutro.setText("Para Outro Usuario");
        btParaOutro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btParaOutroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btParaSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btParaOutro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lbPergunta)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPergunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btParaSi)
                    .addComponent(btParaOutro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btParaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParaSiActionPerformed
        // TODO add your handling code here:
        /*ListaPermGrupo cadpermgrupo = new ListaPermGrupo();
        cadpermgrupo.grupo = cbUsuarios.getSelectedIndex();
        cadpermgrupo.setVisible(true);*/
        if (BibIntelligence.RegistraEmprestimo(0, BibIntelligence.idUsuarioLogado, livro, BibIntelligence.idPC,1)){    
            JOptionPane.showMessageDialog(this,"Emprestimo Realizado Com Sucesso !","Sucesso !",JOptionPane.WARNING_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btParaSiActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btParaOutroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btParaOutroActionPerformed
        // TODO add your handling code here:
        REUsuarios reusuarios = REUsuarios.getInstancia();
        reusuarios.livro = livro;
        reusuarios.setVisible(true);
    }//GEN-LAST:event_btParaOutroActionPerformed

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
            java.util.logging.Logger.getLogger(REPerg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REPerg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REPerg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REPerg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REPerg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btParaOutro;
    private javax.swing.JButton btParaSi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbPergunta;
    // End of variables declaration//GEN-END:variables
}