/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.view;

import pedrosantos.hto.ifsp.bibintelligence.controller.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pedrosantos.hto.ifsp.bibintelligence.controller.BibIntelligence;

/**
 *
 * @author Pedro
 */
public class ListaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form ListaUsuario
     */
    
    int ativa=0;
    int bloq=0;
    DefaultTableModel modelo;
    
    private ListaUsuario() {
        initComponents();
        modelo = (DefaultTableModel) tblUsuarios.getModel();
    }
    
    private static ListaUsuario instancia;
    public static ListaUsuario getInstancia(){
        if (instancia == null){
            instancia = new ListaUsuario();
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

        Usuarios = new javax.swing.JPanel();
        jspUsuarios = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        botoes = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btAtivadosDesativados = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btBloqDesbloq = new javax.swing.JButton();
        btAtivaDesativa = new javax.swing.JButton();
        btBloqueadosDesbloqueados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "login", "email", "nome", "endereco", "telefone", "grupo", "erros", "bloqueado", "desativado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setColumnSelectionAllowed(true);
        jspUsuarios.setViewportView(tblUsuarios);
        tblUsuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout UsuariosLayout = new javax.swing.GroupLayout(Usuarios);
        Usuarios.setLayout(UsuariosLayout);
        UsuariosLayout.setHorizontalGroup(
            UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        UsuariosLayout.setVerticalGroup(
            UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btAtivadosDesativados.setText("Exibir Desativados");
        btAtivadosDesativados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivadosDesativadosActionPerformed(evt);
            }
        });

        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btBloqDesbloq.setText("Bloquear");
        btBloqDesbloq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBloqDesbloqActionPerformed(evt);
            }
        });

        btAtivaDesativa.setText("Desativar");
        btAtivaDesativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtivaDesativaActionPerformed(evt);
            }
        });

        btBloqueadosDesbloqueados.setText("Exibir Bloqueados");
        btBloqueadosDesbloqueados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBloqueadosDesbloqueadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botoesLayout = new javax.swing.GroupLayout(botoes);
        botoes.setLayout(botoesLayout);
        botoesLayout.setHorizontalGroup(
            botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(btBloqueadosDesbloqueados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtivadosDesativados)
                .addGap(104, 104, 104))
            .addGroup(botoesLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBloqDesbloq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAtivaDesativa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botoesLayout.setVerticalGroup(
            botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btEditar)
                    .addComponent(btBloqDesbloq)
                    .addComponent(btAtivaDesativa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar)
                    .addComponent(btAtivadosDesativados)
                    .addComponent(btBloqueadosDesbloqueados))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        CadUsuario.getInstancia().edit=0;
        CadUsuario.getInstancia().setVisible(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
        CadUsuario cadusuario = CadUsuario.getInstancia();
        cadusuario.edit=1;
        if(tblUsuarios.getSelectedRow() != -1){
            cadusuario.usuario = (String) modelo.getValueAt(tblUsuarios.getSelectedRow(), 1);
            cadusuario.idUsuario = BibIntelligence.VerificaID("SELECT idUsuario from usuarios where login= \""+cadusuario.usuario+"\"", "idUsuario",3);
            cadusuario.email = (String) modelo.getValueAt(tblUsuarios.getSelectedRow(), 2);
            cadusuario.nome = (String) modelo.getValueAt(tblUsuarios.getSelectedRow(), 3);
            cadusuario.endereco = (String) modelo.getValueAt(tblUsuarios.getSelectedRow(), 4);
            cadusuario.telefone = (long) modelo.getValueAt(tblUsuarios.getSelectedRow(), 5);
            cadusuario.grupo = BibIntelligence.VerificaGrupoUsuario((String) modelo.getValueAt(tblUsuarios.getSelectedRow(), 6));
            cadusuario.erros = (int) modelo.getValueAt(tblUsuarios.getSelectedRow(), 7);
            cadusuario.bloqueado = (boolean) modelo.getValueAt(tblUsuarios.getSelectedRow(), 8);
            cadusuario.desativado = (boolean) modelo.getValueAt(tblUsuarios.getSelectedRow(), 9);
            cadusuario.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione Um Usuário Para Editar", "Erro !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        // TODO add your handling code here:
        //setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        modelo.setNumRows(0);

        if(ativa==0){
            
            if(bloq==0){
                try{
                    String SQL = "call listaUsuariosDesbloqAtivos";
                    while(Conexao.getResultSet(SQL).next()){
                        modelo.addRow(new Object[]{Conexao.getRsInt("idUsuario"), Conexao.getRsString("login"), Conexao.getRsString("email"), Conexao.getRsString("nome"), Conexao.getRsString("endereco"), Conexao.getRsLong("telefone"), Conexao.getRsString("grupo"), Conexao.getRsInt("erroLogin"), Conexao.getRsBoolean("bloqueado"), Conexao.getRsBoolean("desativado")});
                    }
                }catch(SQLException ex){
                           System.out.println("SQLException: " + ex.getMessage());
                           System.out.println("SQLState: " + ex.getSQLState());
                           System.out.println("VendorError: " + ex.getErrorCode());
                  }
                  catch(Exception e){
                        System.out.println("Problemas ao tentar conectar com o banco de dados");	
                }
            }else{
                try{
                    String SQL = "call listaUsuariosBloqAtivos";
                    while(Conexao.getResultSet(SQL).next()){
                        modelo.addRow(new Object[]{Conexao.getRsInt("idUsuario"), Conexao.getRsString("login"), Conexao.getRsString("email"), Conexao.getRsString("nome"), Conexao.getRsString("endereco"), Conexao.getRsLong("telefone"), Conexao.getRsString("grupo"), Conexao.getRsInt("erroLogin"), Conexao.getRsBoolean("bloqueado"), Conexao.getRsBoolean("desativado")});
                    }
                }catch(SQLException ex){
                           System.out.println("SQLException: " + ex.getMessage());
                           System.out.println("SQLState: " + ex.getSQLState());
                           System.out.println("VendorError: " + ex.getErrorCode());
                  }
                  catch(Exception e){
                        System.out.println("Problemas ao tentar conectar com o banco de dados");	
                }
            }
        }else{
            if(bloq==0){
                try{
                    String SQL = "call listaUsuariosDesbloqDesativados";
                    while(Conexao.getResultSet(SQL).next()){
                        modelo.addRow(new Object[]{Conexao.getRsInt("idUsuario"), Conexao.getRsString("login"), Conexao.getRsString("email"), Conexao.getRsString("nome"), Conexao.getRsString("endereco"), Conexao.getRsLong("telefone"), Conexao.getRsString("grupo"), Conexao.getRsInt("erroLogin"), Conexao.getRsBoolean("bloqueado"), Conexao.getRsBoolean("desativado")});
                    }
                }catch(SQLException ex){
                           System.out.println("SQLException: " + ex.getMessage());
                           System.out.println("SQLState: " + ex.getSQLState());
                           System.out.println("VendorError: " + ex.getErrorCode());
                  }
                  catch(Exception e){
                        System.out.println("Problemas ao tentar conectar com o banco de dados");	
                }
            }else{
                try{
                    String SQL = "call listaUsuariosBloqDesativados";
                    while(Conexao.getResultSet(SQL).next()){
                        modelo.addRow(new Object[]{Conexao.getRsInt("idUsuario"), Conexao.getRsString("login"), Conexao.getRsString("email"), Conexao.getRsString("nome"), Conexao.getRsString("endereco"), Conexao.getRsLong("telefone"), Conexao.getRsString("grupo"), Conexao.getRsInt("erroLogin"), Conexao.getRsBoolean("bloqueado"), Conexao.getRsBoolean("desativado")});
                    }
                }catch(SQLException ex){
                           System.out.println("SQLException: " + ex.getMessage());
                           System.out.println("SQLState: " + ex.getSQLState());
                           System.out.println("VendorError: " + ex.getErrorCode());
                  }
                  catch(Exception e){
                        System.out.println("Problemas ao tentar conectar com o banco de dados");	
                }
            }
        }
        try {
            Conexao.finalizaUso();
        }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
        }
    }//GEN-LAST:event_formWindowActivated

    private void btAtivadosDesativadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivadosDesativadosActionPerformed
        // TODO add your handling code here:
        if(ativa==0){    
        ativa=1;
        formWindowActivated(null);
        corrigeBotoes();
        }else{   
        ativa=0;
        formWindowActivated(null);
        corrigeBotoes();
        }
    }//GEN-LAST:event_btAtivadosDesativadosActionPerformed

    private void btBloqDesbloqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBloqDesbloqActionPerformed
        // TODO add your handling code here:
        if(bloq==0){
        bloq=1;
        formWindowActivated(null);
        corrigeBotoes();
        }else{    
        bloq=0;
        formWindowActivated(null);
        corrigeBotoes();
        }
    }//GEN-LAST:event_btBloqDesbloqActionPerformed

    private void btAtivaDesativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtivaDesativaActionPerformed
        // TODO add your handling code here:
        if(ativa==0){
        ativa=1;
        BibIntelligence.AtvDestvUsuario(ativa, (int) tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0));
        formWindowActivated(null);
        corrigeBotoes();
        }else{    
        ativa=0;
        BibIntelligence.AtvDestvUsuario(ativa, (int) tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0));
        formWindowActivated(null);
        corrigeBotoes();
        }
    }//GEN-LAST:event_btAtivaDesativaActionPerformed

    private void btBloqueadosDesbloqueadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBloqueadosDesbloqueadosActionPerformed
        // TODO add your handling code here:
        if(bloq==0){
        bloq=1;
        BibIntelligence.BlqDsblqUsuario(bloq, (int) tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0));
        formWindowActivated(null);
        corrigeBotoes();
        }else{    
        bloq=0;
        BibIntelligence.BlqDsblqUsuario(bloq, (int) tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0));
        formWindowActivated(null);
        corrigeBotoes();
        }
    }//GEN-LAST:event_btBloqueadosDesbloqueadosActionPerformed

        public Boolean BlDsbItem(int op,int permissao){
        Boolean resultado = false;
        if(op==0){
            switch(permissao){
                case 1: btNovo.setEnabled(false); resultado=true; break;
                case 2: btEditar.setEnabled(false); resultado=true; break;
                case 3: btAtivaDesativa.setEnabled(false); resultado=true; break;
                case 4: btBloqDesbloq.setEnabled(false); resultado=true; break;
                default: resultado=false; break;
            }    
        }else if(op==1){
            switch(permissao){
                case 1: btNovo.setEnabled(true); resultado=true; break;
                case 2: btEditar.setEnabled(true); resultado=true; break;
                case 3: btAtivaDesativa.setEnabled(true); resultado=true; break;
                case 4: btBloqDesbloq.setEnabled(true); resultado=true; break;
                default: resultado=false; break;
            }
        }
        else{
            resultado=false;
        }
        return resultado;
    }
        
    private void corrigeBotoes(){
        if(ativa==0){
            btAtivaDesativa.setText("Desativar");
            btAtivadosDesativados.setText("Exibir Desativados");
        }else{
            btAtivaDesativa.setText("Reativar");
            btAtivadosDesativados.setText("Exibir Ativos");
        }
        if(bloq==0){
            btBloqDesbloq.setText("Bloquear");
            btBloqueadosDesbloqueados.setText("Exibir Bloqueados");
        }else{
            btBloqDesbloq.setText("Desbloquear");
            btBloqueadosDesbloqueados.setText("Exibir Desbloqueados");
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
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Usuarios;
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btAtivaDesativa;
    private javax.swing.JButton btAtivadosDesativados;
    private javax.swing.JButton btBloqDesbloq;
    private javax.swing.JButton btBloqueadosDesbloqueados;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JScrollPane jspUsuarios;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
