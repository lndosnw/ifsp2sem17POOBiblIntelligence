/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.view;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;
import pedrosantos.hto.ifsp.bibintelligence.controller.BibIntelligence;
import pedrosantos.hto.ifsp.bibintelligence.controller.Sender;

/**
 *
 * @author Pedro
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    
    private static TelaInicial instancia;
    public static TelaInicial getInstancia(){
        if (instancia == null){
            instancia = new TelaInicial();
        }
        return instancia;
    }
    
    private TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUsuario = new javax.swing.JLabel();
        lbBemVindo = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        mpAcesso = new javax.swing.JMenu();
        mpaLogonLogoff = new javax.swing.JMenuItem();
        mpaSeparador1 = new javax.swing.JPopupMenu.Separator();
        mpaUsuarios = new javax.swing.JMenuItem();
        mpaTrocaSenha = new javax.swing.JMenuItem();
        mpaEventos = new javax.swing.JMenuItem();
        mpCadastro = new javax.swing.JMenu();
        mpLivros = new javax.swing.JMenuItem();
        mpAutores = new javax.swing.JMenuItem();
        mpEditoras = new javax.swing.JMenuItem();
        mpEmprestimos = new javax.swing.JMenu();
        mpaEmprestimo = new javax.swing.JMenuItem();
        mpaDevolucao = new javax.swing.JMenuItem();
        mpaBaixa = new javax.swing.JMenuItem();
        mpSeguranca = new javax.swing.JMenu();
        mpaGrupoSeg = new javax.swing.JMenuItem();
        mpaPermissoesGrupo = new javax.swing.JMenuItem();
        mpSobre = new javax.swing.JMenu();
        mpConfiguracao = new javax.swing.JMenu();
        mpConfigBD = new javax.swing.JMenuItem();
        mpConfigGerais = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mpSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BiblIntelligence  -  Sistema de Gerenciamento de Biblioteca");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setName("frmPrincipal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbUsuario.setText("#");

        lbBemVindo.setText("Bem Vindo");

        mpAcesso.setText("Acesso");

        mpaLogonLogoff.setText("Logon");
        mpaLogonLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaLogonLogoffActionPerformed(evt);
            }
        });
        mpAcesso.add(mpaLogonLogoff);
        mpAcesso.add(mpaSeparador1);

        mpaUsuarios.setText("Usuarios");
        mpaUsuarios.setEnabled(false);
        mpaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaUsuariosActionPerformed(evt);
            }
        });
        mpAcesso.add(mpaUsuarios);

        mpaTrocaSenha.setText("Troca Senha");
        mpaTrocaSenha.setEnabled(false);
        mpaTrocaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaTrocaSenhaActionPerformed(evt);
            }
        });
        mpAcesso.add(mpaTrocaSenha);

        mpaEventos.setText("Eventos");
        mpaEventos.setEnabled(false);
        mpaEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaEventosActionPerformed(evt);
            }
        });
        mpAcesso.add(mpaEventos);

        menuPrincipal.add(mpAcesso);

        mpCadastro.setText("Cadastros");

        mpLivros.setText("Livros");
        mpLivros.setEnabled(false);
        mpLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpLivrosActionPerformed(evt);
            }
        });
        mpCadastro.add(mpLivros);

        mpAutores.setText("Autores");
        mpAutores.setEnabled(false);
        mpAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpAutoresActionPerformed(evt);
            }
        });
        mpCadastro.add(mpAutores);

        mpEditoras.setText("Editoras");
        mpEditoras.setEnabled(false);
        mpEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpEditorasActionPerformed(evt);
            }
        });
        mpCadastro.add(mpEditoras);

        menuPrincipal.add(mpCadastro);

        mpEmprestimos.setText("Empréstimos");

        mpaEmprestimo.setText("Realizar Empréstimo");
        mpaEmprestimo.setEnabled(false);
        mpaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaEmprestimoActionPerformed(evt);
            }
        });
        mpEmprestimos.add(mpaEmprestimo);

        mpaDevolucao.setText("Realizar Devolução");
        mpaDevolucao.setEnabled(false);
        mpaDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaDevolucaoActionPerformed(evt);
            }
        });
        mpEmprestimos.add(mpaDevolucao);

        mpaBaixa.setText("Dar Baixa Em Devolução");
        mpaBaixa.setEnabled(false);
        mpaBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaBaixaActionPerformed(evt);
            }
        });
        mpEmprestimos.add(mpaBaixa);

        menuPrincipal.add(mpEmprestimos);

        mpSeguranca.setText("Segurança");

        mpaGrupoSeg.setText("Grupos de Segurança");
        mpaGrupoSeg.setEnabled(false);
        mpaGrupoSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaGrupoSegActionPerformed(evt);
            }
        });
        mpSeguranca.add(mpaGrupoSeg);

        mpaPermissoesGrupo.setText("Permissões");
        mpaPermissoesGrupo.setEnabled(false);
        mpaPermissoesGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpaPermissoesGrupoActionPerformed(evt);
            }
        });
        mpSeguranca.add(mpaPermissoesGrupo);

        menuPrincipal.add(mpSeguranca);

        mpSobre.setText("Sobre");
        mpSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpSobreMouseClicked(evt);
            }
        });
        menuPrincipal.add(mpSobre);

        mpConfiguracao.setText("Configuração");

        mpConfigBD.setText("Configurações BD");
        mpConfigBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpConfigBDActionPerformed(evt);
            }
        });
        mpConfiguracao.add(mpConfigBD);

        mpConfigGerais.setText("Cofigurações Gerais");
        mpConfigGerais.setEnabled(false);
        mpConfigGerais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpConfigGeraisActionPerformed(evt);
            }
        });
        mpConfiguracao.add(mpConfigGerais);

        menuPrincipal.add(mpConfiguracao);

        jMenu1.setText("Registro");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        menuPrincipal.add(jMenu1);

        mpSair.setText("Sair");
        mpSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mpSairMouseClicked(evt);
            }
        });
        menuPrincipal.add(mpSair);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1089, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbBemVindo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(531, Short.MAX_VALUE)
                .addComponent(lbBemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsuario)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mpaLogonLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaLogonLogoffActionPerformed
        // TODO add your handling code here:
        if(mpaLogonLogoff.getText() == "Logon"){
        LogonUsuario logonusuario = LogonUsuario.getInstancia();
        logonusuario.setVisible(true);
        }
        else
        {
            BibIntelligence.Deslogar();
        }
    }//GEN-LAST:event_mpaLogonLogoffActionPerformed

    private void mpaTrocaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaTrocaSenhaActionPerformed
        // TODO add your handling code here:
        MudarSenha mudarsenha = MudarSenha.getInstancia();
        mudarsenha.setVisible(true);
    }//GEN-LAST:event_mpaTrocaSenhaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        splash splashx = splash.getInstancia();
        //splashx.setVisible(false);
        splashx.dispose();
        setExtendedState(MAXIMIZED_BOTH);
        if(BibIntelligence.senha == "mudar123"){
            mpaTrocaSenhaActionPerformed(null);
        }
    }//GEN-LAST:event_formWindowActivated

    private void mpaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaUsuariosActionPerformed
        // TODO add your handling code here:
        ListaUsuario.getInstancia().setVisible(true);
    }//GEN-LAST:event_mpaUsuariosActionPerformed

    private void mpLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpLivrosActionPerformed
        // TODO add your handling code here:
        ListaLivro.getInstancia().setVisible(true);
    }//GEN-LAST:event_mpLivrosActionPerformed

    private void mpAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpAutoresActionPerformed
        // TODO add your handling code here:
        ListaAutor.getInstancia().setVisible(true);
    }//GEN-LAST:event_mpAutoresActionPerformed

    private void mpEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpEditorasActionPerformed
        // TODO add your handling code here:
        ListaEditora.getInstancia().setVisible(true);
    }//GEN-LAST:event_mpEditorasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
                BibIntelligence.Deslogar();
    }//GEN-LAST:event_formWindowOpened

    private void mpSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpSairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mpSairMouseClicked

    private void mpConfigGeraisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpConfigGeraisActionPerformed
        // TODO add your handling code here:
        ConfigGerais configgerais = new ConfigGerais();
        configgerais.setVisible(true);
    }//GEN-LAST:event_mpConfigGeraisActionPerformed

    private void mpSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mpSobreMouseClicked
        // TODO add your handling code here:
        Sobre sobre = new Sobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_mpSobreMouseClicked

    private void mpConfigBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpConfigBDActionPerformed
        // TODO add your handling code here:
        ConfigBD configbd = ConfigBD.getInstancia();
        configbd.setVisible(true);
    }//GEN-LAST:event_mpConfigBDActionPerformed

    private void mpaEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaEventosActionPerformed
        // TODO add your handling code here:
        ListaEvento listaevento = new ListaEvento();
        listaevento.setVisible(true);
    }//GEN-LAST:event_mpaEventosActionPerformed

    private void mpaGrupoSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaGrupoSegActionPerformed
        // TODO add your handling code here:
        ListaGrupoSeg listagruposeg = ListaGrupoSeg.getInstancia();
        listagruposeg.setVisible(true);
    }//GEN-LAST:event_mpaGrupoSegActionPerformed

    private void mpaPermissoesGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaPermissoesGrupoActionPerformed
        // TODO add your handling code here:
        ListaGrupoPerm listagrupoperm = new ListaGrupoPerm();
        listagrupoperm.setVisible(true);
    }//GEN-LAST:event_mpaPermissoesGrupoActionPerformed

    private void mpaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaEmprestimoActionPerformed
        // TODO add your handling code here:
        RegistraEmprestimo registraemprestimo = RegistraEmprestimo.getInstancia();
        registraemprestimo.setVisible(true);
    }//GEN-LAST:event_mpaEmprestimoActionPerformed

    private void mpaDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaDevolucaoActionPerformed
        // TODO add your handling code here:
        if((BibIntelligence.autoDevolucao) && (BibIntelligence.devolOutroUsuario)){
            //caso ambos
            RDPerg rdperg = RDPerg.getInstancia();
            rdperg.setVisible(true);
        }else if (BibIntelligence.autoDevolucao){
            //caso autodevolucao
            RegistraDevolucao registraDevolucao = RegistraDevolucao.getInstancia();
            registraDevolucao.usuario = BibIntelligence.idUsuarioLogado;
            registraDevolucao.op = 0;
            registraDevolucao.setVisible(true);
        }else if (BibIntelligence.devolOutroUsuario){
            //caso devolucao outro usuario
            RDUsuarios rdusuarios = RDUsuarios.getInstancia();
            rdusuarios.setVisible(true);
        }else{
            //nao possui permissoes para realizar emprestimos
            JOptionPane.showMessageDialog(null,"Usuario Não Possui Permissão Para Realizar Devoluções!","Erro Ao Devolver",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_mpaDevolucaoActionPerformed

    private void mpaBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpaBaixaActionPerformed
        // TODO add your handling code here:
        RegistraBaixa registraBaixa = RegistraBaixa.getInstancia();
        registraBaixa.setVisible(true);
    }//GEN-LAST:event_mpaBaixaActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        TelaRegistro telaRegistro = new TelaRegistro();
        telaRegistro.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    public void setLogonLogoff(){
        if(BibIntelligence.idUsuarioLogado==0){
            mpaLogonLogoff.setText("Logon");
        }
        else
        {
            mpaLogonLogoff.setText("Logoff");
        }
    }

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                instancia = new TelaInicial();
                instancia.setVisible(true); 
                        }
        });
    }
    
    public void trava(Boolean op){
        if (op){
            setEnabled(true);
        }else{
            setEnabled(false);
        }
        
        
        
    }
    
    public Boolean BlDsbItem(int op,int permissao){
        Boolean resultado = false;
        if(op==0){
            switch(permissao){
                case 1: mpaUsuarios.setEnabled(false); resultado=true; break;
                case 2: mpaTrocaSenha.setEnabled(false); resultado=true; break;
                case 3: mpaEventos.setEnabled(false); resultado=true; break;
                case 4: mpLivros.setEnabled(false); resultado=true; break;
                case 5: mpAutores.setEnabled(false); resultado=true; break;
                case 6: mpEditoras.setEnabled(false); resultado=true; break;
                case 7: mpaEmprestimo.setEnabled(false); resultado=true; break;
                case 8: mpConfigGerais.setEnabled(false); resultado=true; break;
                case 9: mpaPermissoesGrupo.setEnabled(false); resultado=true; break;
                case 10: mpaDevolucao.setEnabled(false); resultado=true; break;
                case 11: mpaBaixa.setEnabled(false); resultado=true; break;
                case 12: mpaGrupoSeg.setEnabled(false); resultado=true; break;
                default: resultado=false; break;
            }    
        }else if(op==1){
            switch(permissao){
                case 1: mpaUsuarios.setEnabled(true); resultado=true; break;
                case 2: mpaTrocaSenha.setEnabled(true); resultado=true; break;
                case 3: mpaEventos.setEnabled(true); resultado=true; break;
                case 4: mpLivros.setEnabled(true); resultado=true; break;
                case 5: mpAutores.setEnabled(true); resultado=true; break;
                case 6: mpEditoras.setEnabled(true); resultado=true; break;
                case 7: mpaEmprestimo.setEnabled(true); resultado=true; break;
                case 8: mpConfigGerais.setEnabled(true); resultado=true; break;
                case 9: mpaPermissoesGrupo.setEnabled(true); resultado=true; break;
                case 10: mpaDevolucao.setEnabled(true); resultado=true; break;
                case 11: mpaBaixa.setEnabled(true); resultado=true; break;
                case 12: mpaGrupoSeg.setEnabled(true); resultado=true; break;
                default: resultado=false; break;
            }
        }
        else{
            resultado=false;
        }
        return resultado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lbBemVindo;
    public javax.swing.JLabel lbUsuario;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenu mpAcesso;
    private javax.swing.JMenuItem mpAutores;
    private javax.swing.JMenu mpCadastro;
    private javax.swing.JMenuItem mpConfigBD;
    private javax.swing.JMenuItem mpConfigGerais;
    private javax.swing.JMenu mpConfiguracao;
    private javax.swing.JMenuItem mpEditoras;
    private javax.swing.JMenu mpEmprestimos;
    private javax.swing.JMenuItem mpLivros;
    private javax.swing.JMenu mpSair;
    private javax.swing.JMenu mpSeguranca;
    private javax.swing.JMenu mpSobre;
    private javax.swing.JMenuItem mpaBaixa;
    private javax.swing.JMenuItem mpaDevolucao;
    private javax.swing.JMenuItem mpaEmprestimo;
    private javax.swing.JMenuItem mpaEventos;
    private javax.swing.JMenuItem mpaGrupoSeg;
    private javax.swing.JMenuItem mpaLogonLogoff;
    private javax.swing.JMenuItem mpaPermissoesGrupo;
    private javax.swing.JPopupMenu.Separator mpaSeparador1;
    private javax.swing.JMenuItem mpaTrocaSenha;
    private javax.swing.JMenuItem mpaUsuarios;
    // End of variables declaration//GEN-END:variables
}
