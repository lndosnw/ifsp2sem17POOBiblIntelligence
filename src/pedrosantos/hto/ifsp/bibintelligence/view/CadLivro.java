/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pedrosantos.hto.ifsp.bibintelligence.controller.BibIntelligence;

/**
 *
 * @author lndosnw
 */
public class CadLivro extends javax.swing.JFrame {

    /**
     * Creates new form CadLivro
     */
    
    int edit,idLivro,edicao,editora,autor,ano,paginas;
    String tombo,nome,estado,descricao;
    Long isbn;
    Boolean emprestado,desativado;
    
    private CadLivro() {
        initComponents();
    }
    
    private static CadLivro instancia;
    public static CadLivro getInstancia(){
        if (instancia == null){
            instancia = new CadLivro();
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

        lbTombo = new javax.swing.JLabel();
        lbIsbn = new javax.swing.JLabel();
        lbExemplares = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbPaginas = new javax.swing.JLabel();
        tfTombo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tfIsbn = new javax.swing.JTextField();
        lbEdicao = new javax.swing.JLabel();
        tfEdicao = new javax.swing.JTextField();
        lbEditora = new javax.swing.JLabel();
        cbEditora = new javax.swing.JComboBox<>();
        lbAutor = new javax.swing.JLabel();
        cbAutor = new javax.swing.JComboBox<>();
        lbAno = new javax.swing.JLabel();
        jsPaginas = new javax.swing.JSpinner();
        lbEstado = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jsExemplares = new javax.swing.JSpinner();
        jspDescricao = new javax.swing.JScrollPane();
        taDescricao = new javax.swing.JTextArea();
        lbDescricao = new javax.swing.JLabel();
        lbInstrucao = new javax.swing.JLabel();
        jsAno = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Livros");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lbTombo.setText("Tombo:");

        lbIsbn.setText("ISBN :");

        lbExemplares.setText("* Exemplares :");

        lbNome.setText("* Nome :");

        lbPaginas.setText("Paginas :");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        lbEdicao.setText("Edição :");

        lbEditora.setText("* Editora :");

        lbAutor.setText("* Autor :");

        lbAno.setText("* Ano :");

        jsPaginas.setModel(new javax.swing.SpinnerNumberModel());

        lbEstado.setText("Estado :");

        taDescricao.setColumns(20);
        taDescricao.setRows(5);
        jspDescricao.setViewportView(taDescricao);

        lbDescricao.setText("Descrição:");

        lbInstrucao.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lbInstrucao.setText("Todos os itens marcados com * são de preenchimento obrigatório !");

        jsAno.setModel(new javax.swing.SpinnerNumberModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbPaginas)
                            .addComponent(lbExemplares)
                            .addComponent(lbTombo)
                            .addComponent(lbIsbn)
                            .addComponent(lbNome)
                            .addComponent(lbEdicao)
                            .addComponent(lbEditora)
                            .addComponent(lbAutor)
                            .addComponent(lbAno)
                            .addComponent(lbEstado)
                            .addComponent(lbDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbInstrucao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jspDescricao)
                            .addComponent(cbAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbEditora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfEdicao)
                            .addComponent(tfTombo)
                            .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addComponent(tfIsbn)
                            .addComponent(jsPaginas)
                            .addComponent(tfEstado)
                            .addComponent(jsExemplares, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jsAno, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTombo)
                    .addComponent(tfTombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIsbn)
                    .addComponent(tfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEdicao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEditora)
                    .addComponent(cbEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAutor)
                    .addComponent(cbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAno)
                    .addComponent(jsAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPaginas)
                    .addComponent(jsPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEstado)
                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao)
                    .addComponent(jspDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbExemplares)
                    .addComponent(jsExemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbInstrucao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:
        if (BibIntelligence.CadLivro(edit, idLivro, tfTombo.getText(), Long.valueOf(tfIsbn.getText()), tfNome.getText(), Integer.valueOf(tfEdicao.getText()), cbEditora.getSelectedIndex()+1, cbAutor.getSelectedIndex()+1, Integer.valueOf(jsAno.getValue().toString()), Integer.valueOf(jsPaginas.getValue().toString()), tfEstado.getText(), taDescricao.getText(), false, 1)){
                JOptionPane.showMessageDialog(null, "Livro Cadastrado Com Sucesso !", "Sucesso !", JOptionPane.ERROR_MESSAGE);
            }
        else{
            JOptionPane.showMessageDialog(null, "Falha Ao Cadastrar Livro", "Erro !", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        //setVisible(false);  // this.dispose();
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        
    //inicio do preenchimento do listbox editora
        try{
                cbEditora.removeAllItems();
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/biblintelligence",
					"root", "");

		  Statement stmt = conn.createStatement();
		  String query = "SELECT * from editoras";
		  ResultSet rs = stmt.executeQuery(query);
		  while(rs.next()){ 
			String nome = rs.getString("nome");
                        cbEditora.addItem(nome);
		  }
                  
		  } 
		  catch(SQLException ex){
			   System.out.println("SQLException: " + ex.getMessage());
			   System.out.println("SQLState: " + ex.getSQLState());
			   System.out.println("VendorError: " + ex.getErrorCode());
		  }
		  catch(Exception e){
			System.out.println("Problemas ao tentar conectar com o banco de dados");	
		}
    //fim do preeenchimenmto do listbox editora
    
    //inicio do preenchimento do listbox autor
        try{
            cbAutor.removeAllItems();
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/biblintelligence",
					"root", "");

		  Statement stmt = conn.createStatement();
		  String query = "SELECT * from autores";
		  ResultSet rs = stmt.executeQuery(query);
		  while(rs.next()){ 
			String nome = rs.getString("nome");
                        cbAutor.addItem(nome);
		  }
                  
		  } 
		  catch(SQLException ex){
			   System.out.println("SQLException: " + ex.getMessage());
			   System.out.println("SQLState: " + ex.getSQLState());
			   System.out.println("VendorError: " + ex.getErrorCode());
		  }
		  catch(Exception e){
			System.out.println("Problemas ao tentar conectar com o banco de dados");	
		}
    //fim do preeenchimenmto do listbox autor
        

        tfTombo.setText(tombo);
        tfNome.setText(nome);
        tfEstado.setText(estado);
        taDescricao.setText(descricao);
        tfEdicao.setText(String.valueOf(edicao));
        //combobox editora
        //combobox autor
        jsAno.setValue(new Integer(ano));//testar
        jsPaginas.setValue(new Integer(paginas));//testar
        tfIsbn.setText(String.valueOf(isbn));
        if(edit==1){
            lbExemplares.setVisible(false);
            lbExemplares.setEnabled(false);
            jsExemplares.setVisible(false);
            jsExemplares.setEnabled(false);
        }else{
            lbExemplares.setVisible(true);
            lbExemplares.setEnabled(true);
            jsExemplares.setVisible(true);
            jsExemplares.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(CadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbAutor;
    private javax.swing.JComboBox<String> cbEditora;
    private javax.swing.JSpinner jsAno;
    private javax.swing.JSpinner jsExemplares;
    private javax.swing.JSpinner jsPaginas;
    private javax.swing.JScrollPane jspDescricao;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbEdicao;
    private javax.swing.JLabel lbEditora;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbExemplares;
    private javax.swing.JLabel lbInstrucao;
    private javax.swing.JLabel lbIsbn;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbPaginas;
    private javax.swing.JLabel lbTombo;
    private javax.swing.JTextArea taDescricao;
    private javax.swing.JTextField tfEdicao;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfIsbn;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTombo;
    // End of variables declaration//GEN-END:variables
}
