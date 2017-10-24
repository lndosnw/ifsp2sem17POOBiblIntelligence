/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import pedrosantos.hto.ifsp.bibintelligence.view.RegistraBaixa;
import pedrosantos.hto.ifsp.bibintelligence.view.REPerg;
import pedrosantos.hto.ifsp.bibintelligence.view.ListaGrupoSeg;
import pedrosantos.hto.ifsp.bibintelligence.view.CadAutor;
import pedrosantos.hto.ifsp.bibintelligence.view.MudarSenha;
import pedrosantos.hto.ifsp.bibintelligence.view.ListaPermGrupo;
import pedrosantos.hto.ifsp.bibintelligence.view.ListaAutor;
import pedrosantos.hto.ifsp.bibintelligence.view.CadGrupoSeg;
import pedrosantos.hto.ifsp.bibintelligence.view.CadPermGrupo;
import pedrosantos.hto.ifsp.bibintelligence.view.CadUsuario;
import pedrosantos.hto.ifsp.bibintelligence.view.CadLivro;
import pedrosantos.hto.ifsp.bibintelligence.view.ListaEditora;
import pedrosantos.hto.ifsp.bibintelligence.view.ListaUsuario;
import pedrosantos.hto.ifsp.bibintelligence.view.TelaInicial;
import pedrosantos.hto.ifsp.bibintelligence.view.RegistraDevolucao;
import pedrosantos.hto.ifsp.bibintelligence.view.CadEditora;
import pedrosantos.hto.ifsp.bibintelligence.view.LogonUsuario;
import pedrosantos.hto.ifsp.bibintelligence.view.RegistraEmprestimo;
import pedrosantos.hto.ifsp.bibintelligence.view.REUsuarios;
import pedrosantos.hto.ifsp.bibintelligence.view.ListaLivro;
/*
import pedrosantos.hto.ifsp.view.ListaPermGrupo;
import pedrosantos.hto.ifsp.view.RegistraEmprestimo;
import pedrosantos.hto.ifsp.view.CadEditora;
import pedrosantos.hto.ifsp.view.MudarSenha;
import pedrosantos.hto.ifsp.view.CadAutor;
import pedrosantos.hto.ifsp.view.ListaLivro;
import pedrosantos.hto.ifsp.view.ListaUsuario;
import pedrosantos.hto.ifsp.view.REPerg;
import pedrosantos.hto.ifsp.view.CadGrupoSeg;
import pedrosantos.hto.ifsp.view.RegistraBaixa;
import pedrosantos.hto.ifsp.view.LogonUsuario;
import pedrosantos.hto.ifsp.view.ListaAutor;
import pedrosantos.hto.ifsp.view.CadUsuario;
import pedrosantos.hto.ifsp.view.CadLivro;
import pedrosantos.hto.ifsp.view.Conexao;
import pedrosantos.hto.ifsp.view.RegistraDevolucao;
import pedrosantos.hto.ifsp.view.ListaGrupoSeg;
import pedrosantos.hto.ifsp.view.CadPermGrupo;
import pedrosantos.hto.ifsp.view.ListaEditora;
import pedrosantos.hto.ifsp.view.TelaInicial;
import pedrosantos.hto.ifsp.view.REUsuarios;*/
import java.sql.SQLException;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;



/**
 *
 * @author Pedro
 */
public class BibIntelligence {
    
    /**/
    //LogonUsuario logonUsuario = LogonUsuario.getInstancia();
    /**/
    
    
    public static String login,senha,nome,idPC;
    public static int idUsuarioLogado;
    public static Boolean autoEmprestimo,empOutroUsuario,autoDevolucao,devolOutroUsuario;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
   
    
    public static boolean Deslogar(){
        nome = "Visitante";
        login = "visitante";
        senha = "visitante";
        idUsuarioLogado = 0;
        TelaInicial telainicial = TelaInicial.getInstancia();
        telainicial.lbUsuario.setText(nome);
        telainicial.setLogonLogoff();
        CarregaPermissoes(idUsuarioLogado);
        return true;
    }
    
    public static boolean CarregaIni(){
        return true;
    }
		
    public static boolean CarregaPermissoes(int usuario){ //classe reponsavel pelas permissoes
            Boolean resultado = false;
            TelaInicial telainicial = TelaInicial.getInstancia();
            ListaUsuario listausuario = ListaUsuario.getInstancia();
            ListaAutor listaautor = ListaAutor.getInstancia();
            ListaEditora listaeditora = ListaEditora.getInstancia();
            ListaLivro listalivro = ListaLivro.getInstancia();
            ListaGrupoSeg listagruposeg = ListaGrupoSeg.getInstancia();
            ListaPermGrupo listapermgrupo = ListaPermGrupo.getInstancia();
            /*reinicializa permissoes*/    
            for(int i=0;i<19;i++){
                telainicial.BlDsbItem(0, i);
            }
            for(int i=0;i<5;i++){
                listausuario.BlDsbItem(0, i);
            }
            for(int i=0;i<4;i++){
                listaautor.BlDsbItem(0, i);
            }
            for(int i=0;i<4;i++){
                listaeditora.BlDsbItem(0, i);
            }
            for(int i=0;i<4;i++){
                listalivro.BlDsbItem(0, i);
            }
            for(int i=0;i<4;i++){
                listagruposeg.BlDsbItem(0, i);
            }
            for(int i=0;i<4;i++){
                listapermgrupo.BlDsbItem(0, i);
            }
            CadUsuario.getInstancia().BlDsbItem(0,1); //resetsenhausuario
            autoEmprestimo=false;//emprestimo a si
            empOutroUsuario=false;//emprestimo a outro
            autoDevolucao=false;//devolucao a si
            devolOutroUsuario=false;//devolucao a outro
            /*seta permissoes*/
            try {
                while(Conexao.getResultSet("call permissoesusuario("+usuario+")").next())
                {
                    switch(Conexao.getRsInt("permissao")){
                        case 1: telainicial.BlDsbItem(1,1); break;//acessar usuarios
                        case 2: listausuario.BlDsbItem(1,1); break;//cria usuario
                        case 3: listausuario.BlDsbItem(1,2); break;//edita usuario
                        case 4: listausuario.BlDsbItem(1,3); break;//ativa/desativa usuario
                        case 5: telainicial.BlDsbItem(1,3); break;//acessa eventos
                        case 6: telainicial.BlDsbItem(1,5); break;//acessa autores
                        case 7: listaautor.BlDsbItem(1,1); break;//cria autores
                        case 8: listaautor.BlDsbItem(1,2); break;//edita autores
                        case 9: listaautor.BlDsbItem(1,3); break;//ativa/desativa autores
                        case 10: telainicial.BlDsbItem(1,6); break;//acessa editoras
                        case 11: listaeditora.BlDsbItem(1,1); break;//cria editoras
                        case 12: listaeditora.BlDsbItem(1,2); break;//edita editoras
                        case 13: listaeditora.BlDsbItem(1,3); break;//ativa/desativa editoras
                        case 14: telainicial.BlDsbItem(1,4); break;//acessa livros
                        case 15: listalivro.BlDsbItem(1,1); break;//cria livros
                        case 16: listalivro.BlDsbItem(1,2); break;//edita livros
                        case 17: listalivro.BlDsbItem(1,3); break;//ativa/desativa livros
                        case 18: telainicial.BlDsbItem(1,12); break;//acessa grupos de seg
                        case 19: listagruposeg.BlDsbItem(1,1); break;//cria grupos de seg
                        case 20: listagruposeg.BlDsbItem(1,2); break;//edita grupos de seg
                        case 21: listagruposeg.BlDsbItem(1,3); break;//ativa/desativa grupos de seg
                        case 22: listapermgrupo.BlDsbItem(1,1); break;//adiciona permissao a grupos de seg
                        case 23: listapermgrupo.BlDsbItem(1,2); break;//remove permissao de grupos de seg
                        case 24: CadUsuario.getInstancia().BlDsbItem(1,1); break;//reset senha usuario
                        case 25: telainicial.BlDsbItem(1,2); break;//troca senha
                        case 26: telainicial.BlDsbItem(1,8); break;//configuracao geral
                        case 27: telainicial.BlDsbItem(1,9); break;//acessar permissoes
                        case 28: telainicial.BlDsbItem(1,7); break;//acesso tela de emprestimo
                        case 29: autoEmprestimo=true; break;//realizar emprestimo na propria conta
                        case 30: empOutroUsuario=true; break;//realizar emprestimo a outro usuario
                        case 31: telainicial.BlDsbItem(1,10); break;//acesso tela de devolucao
                        case 32: autoDevolucao=true; break;//realizar devolucao na propria conta
                        case 33: devolOutroUsuario=true; break;//realizar devolucao a outro usuario
                        case 34: telainicial.BlDsbItem(1,11); break;//acesso tela de baixa
                        case 35: listausuario.BlDsbItem(1,4); break;//bloquear/desbloquear usuario
                        default:System.out.println("Opa ! Alguem tem mais permissões do que devia !"); break;
                    }
                }
                resultado = true;
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally 
        return resultado;
    }
    
    public static boolean Logar(String usuario,String psenha) throws MessagingException{
        LogonUsuario logonUsuario = LogonUsuario.getInstancia();
        Boolean resultado=false;
        if(usuario.equals("") || psenha.equals("")){
            JOptionPane.showMessageDialog(logonUsuario, "Login ou Senha inválido.", "Erro !", JOptionPane.ERROR_MESSAGE);
            resultado = false;
        }else{
            try {
                while(Conexao.getResultSet("Select * from usuarios where login = '"+ usuario +"';").next()) {
                    String loginn = Conexao.getRsString("login");
                    String senhaa = Conexao.getRsString("senha");
                    String nomee = Conexao.getRsString("nome");
                    int idd = Conexao.getRsInt("idUsuario");
                    if(loginn==""){System.out.print("null");}
                    
                    if(usuario.equals(loginn) && psenha.equals(senhaa)){
                        JOptionPane.showMessageDialog(logonUsuario,"Seja bem vindo: " + nomee,"Bem Vindo !",JOptionPane.INFORMATION_MESSAGE);
                        nome = nomee;
                        login = loginn;
                        senha = senhaa;
                        idUsuarioLogado = idd;//guarda o id do usuario que esta logando no sistema
                        TelaInicial telainicial = TelaInicial.getInstancia();
                        telainicial.lbUsuario.setText(nome);
                        telainicial.setLogonLogoff();
                        resultado = true;
                    }else{
                        JOptionPane.showMessageDialog(logonUsuario,"Login ou Senha inválidos.","Erro Ao Logar",JOptionPane.ERROR_MESSAGE);
                        resultado = false;
                    }
                }
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(logonUsuario,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                resultado = false;
                Deslogar();
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(logonUsuario,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }//else do login e senha vazios
        CarregaPermissoes(idUsuarioLogado);
        SenderFacade.getInstancia().enviar(BibIntelligence.idUsuarioLogado, "Login realizado na sua conta");
        return resultado;
    }
    
    public static boolean ResetSenha(int usuario){
        CadUsuario cadusuario = CadUsuario.getInstancia();
        Boolean resultado = false;
                try {
                    while(Conexao.getResultSet("select fcResetaSenha("+idUsuarioLogado+","+usuario+") \"resultado\"").next()){
                        if(Conexao.getRsBoolean("resultado")){
                            resultado = true;
                        }else{
                            resultado = false;
                        }
                    }
                }catch(SQLException e){
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                    JOptionPane.showMessageDialog(cadusuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }finally {
                    try{
                        Conexao.finalizaUso();
                    }catch(SQLException onConClose){
                        //System.out.println("Houve erro no fechamento da conexão");
                        JOptionPane.showMessageDialog(cadusuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                        onConClose.printStackTrace();
                        resultado = false;
                    }
                } // fim do bloco try-catch-finally
        return resultado;
    }
    
    public static boolean MudarSenha(String senhaAtual,String senhaNova,String senhaConf){
        MudarSenha mudarsenha = MudarSenha.getInstancia();
        Boolean resultado = false;
        if (!senhaNova.equals(senhaConf)){
            JOptionPane.showMessageDialog(mudarsenha,"As senhas não conferem !","Senha Incorreta !",JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else{
                try {
                    while(Conexao.getResultSet("select fcMudarSenha("+idUsuarioLogado+",\""+senhaAtual+"\",\""+senhaNova+"\",\""+senhaConf+"\") \"resultado\"").next()){
                        if(Conexao.getRsBoolean("resultado")){
                            resultado = true;
                        }else{
                            JOptionPane.showMessageDialog(mudarsenha,"As Senhas Não Conferem!","Erro!",JOptionPane.WARNING_MESSAGE);
                            resultado = false;
                        }
                    }
                }catch(SQLException e){
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                    JOptionPane.showMessageDialog(mudarsenha,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }finally {
                    try{
                        Conexao.finalizaUso();
                    }catch(SQLException onConClose){
                        //System.out.println("Houve erro no fechamento da conexão");
                        JOptionPane.showMessageDialog(mudarsenha,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                        onConClose.printStackTrace();
                        resultado = false;
                    }
                } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static Integer VerificaGrupoUsuario(String grupo){
        int idGrupo=-2;
        try{
		  while(Conexao.getResultSet("SELECT idGrupo FROM gruposeg where gruposeg.nomeGrupo= "+"\""+grupo+"\"").next()){ 
			idGrupo = Conexao.getRsInt("idGrupo");                        
		  }
		  } 
		  catch(SQLException ex){
			   System.out.println("SQLException: " + ex.getMessage());
			   System.out.println("SQLState: " + ex.getSQLState());
			   System.out.println("VendorError: " + ex.getErrorCode());
                           idGrupo = -1;
		  }
		  catch(Exception e){
			System.out.println("Problemas ao tentar conectar com o banco de dados");
                        idGrupo = -1;
		}finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    ListaUsuario listaUsuario = ListaUsuario.getInstancia(); JOptionPane.showMessageDialog(listaUsuario,"Erro na conexão, com o banco de dados!","Erro Ao Obter Grupo",JOptionPane.WARNING_MESSAGE);
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    idGrupo = -1;
                }
            }
            return idGrupo;
    }
    
    public static Integer VerificaID(String SQL,String nomeID,int telaNum){
            int id=-2;
            try{
		  while(Conexao.getResultSet(SQL).next()){ 
			id = Conexao.getRsInt(nomeID);                        
		  }
		  } 
		  catch(SQLException ex){
			   System.out.println("SQLException: " + ex.getMessage());
			   System.out.println("SQLState: " + ex.getSQLState());
			   System.out.println("VendorError: " + ex.getErrorCode());
                           id = -1;
		  }
		  catch(Exception e){
			System.out.println("Problemas ao tentar conectar com o banco de dados");
                        id = -1;
		}finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    switch(telaNum){
                        case 0:ListaAutor listaAutor = ListaAutor.getInstancia(); JOptionPane.showMessageDialog(listaAutor,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE); break;
                        case 1:ListaEditora listaEditora = ListaEditora.getInstancia(); JOptionPane.showMessageDialog(listaEditora,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE); break;
                        case 2:ListaLivro listaLivro = ListaLivro.getInstancia(); JOptionPane.showMessageDialog(listaLivro,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE); break;
                        case 3:ListaUsuario listaUsuario = ListaUsuario.getInstancia(); JOptionPane.showMessageDialog(listaUsuario,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE); break;
                    }
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Erro Ao Logar",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    id = -1;
                }
            }
            return id;
    }
    
    public static boolean CadUsuario(int edit,int pid,String plogin,String psenha,String psenhaconf,String pemail,String pnome,String pendereco,long ptelefone,int pgrupo,int perros,boolean pbloqueado,boolean pdesativado){
        CadUsuario cadUsuario = CadUsuario.getInstancia();
        Boolean resultado=false;
        if(edit==0){
            if(plogin.equals("") || psenha.equals("")|| psenhaconf.equals("")|| pnome.equals("")|| pendereco.equals("")|| psenha.equals("")|| psenha.equals("")){
            JOptionPane.showMessageDialog(cadUsuario, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
            try {
                
                while(Conexao.getResultSet("SELECT insertUsuario("+BibIntelligence.idUsuarioLogado+",\""+plogin+"\",\""+psenha+"\",\""+pemail+"\",\""+pnome+"\",\""+pendereco+"\","+ptelefone+","+pgrupo+") \"resultado\"").next()) {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(cadUsuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                System.out.println(e.toString());
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadUsuario,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }//else do login e senha vazios
        }else{
            if(edit==1){
            if(plogin.equals("") || pnome.equals("")|| pendereco.equals("")|| psenha.equals("")|| psenha.equals("")){
            JOptionPane.showMessageDialog(cadUsuario, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            resultado = false;
            }else{
            try {
                while(Conexao.getResultSet("SELECT editUsuario("+BibIntelligence.idUsuarioLogado+","+pid+",\""+plogin+"\",\""+psenha+"\",\""+pemail+"\",\""+pnome+"\",\""+pendereco+"\","+ptelefone+","+pgrupo+") \"resultado\"").next()) {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(cadUsuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadUsuario,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }//else do login e senha vazios
        }
    }
        return resultado;
    }
    
    public static boolean AtvDestvUsuario(int op, int pid){
        ListaUsuario listaUsuario = ListaUsuario.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT atdstUsuario("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaUsuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaUsuario,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT atdstUsuario("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaUsuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaUsuario,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static boolean BlqDsblqUsuario(int op,int pid){
        ListaUsuario listaUsuario = ListaUsuario.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT bldsbUsuario("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaUsuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaUsuario,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT bldsbUsuario("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaUsuario,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaUsuario,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static boolean CadAutor(int edit, int pid, String pnome, String pdescricao){
        CadAutor cadAutor = CadAutor.getInstancia();
        Boolean resultado=false;
        if(edit==0){
            if(pnome.equals("")){
            JOptionPane.showMessageDialog(cadAutor, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
            try {
                while(Conexao.getResultSet("SELECT insertAutor("+BibIntelligence.idUsuarioLogado+",\""+pnome+"\",\""+pdescricao+"\") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(cadAutor,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadAutor,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
            }
        }else{
            if(pnome.equals("")){
            JOptionPane.showMessageDialog(cadAutor, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
                try {
                    while(Conexao.getResultSet("SELECT editAutor("+BibIntelligence.idUsuarioLogado+","+pid+",\""+pnome+"\",\""+pdescricao+"\") \"resultado\"").next())
                    {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
                }catch(SQLException e){
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                    JOptionPane.showMessageDialog(cadAutor,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadAutor,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
                } // fim do bloco try-catch-finally
            }//else do login e senha vazios
        }
        return resultado;
    }
    
    public static boolean AtvDestvAutor(int op, int pid){
        ListaAutor listaAutor = ListaAutor.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT atdstAutor("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaAutor,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaAutor,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT atdstAutor("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaAutor,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaAutor,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static boolean CadEditora(int edit, int pid, String pnome, String pendereco, long ptelefone,String psite){
        CadEditora cadEditora = CadEditora.getInstancia();
        Boolean resultado=false;
        if(edit==0){
            if(pnome.equals("")){
            JOptionPane.showMessageDialog(cadEditora, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
            try {
                while(Conexao.getResultSet("SELECT insertEditora("+BibIntelligence.idUsuarioLogado+",\""+pnome+"\",\""+pendereco+"\","+ptelefone+",\""+psite+"\") \"resultado\"").next()) {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
                }catch(SQLException e){
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                    JOptionPane.showMessageDialog(cadEditora,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }finally {
                    try{
                        Conexao.finalizaUso();
                    }catch(SQLException onConClose){
                        //System.out.println("Houve erro no fechamento da conexão");
                        JOptionPane.showMessageDialog(cadEditora,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                        onConClose.printStackTrace();
                        resultado = false;
                    }
                } // fim do bloco try-catch-finally
            }
        }else{
            if(pnome.equals("")){
            JOptionPane.showMessageDialog(cadEditora, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
                try {
                    while(Conexao.getResultSet("SELECT editEditora("+BibIntelligence.idUsuarioLogado+","+pid+",\""+pnome+"\",\""+pendereco+"\","+ptelefone+",\""+psite+"\") \"resultado\"").next()) {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
                    }catch(SQLException e){
                        e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                        JOptionPane.showMessageDialog(cadEditora,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                        resultado = false;
                    }finally {
                        try{
                            Conexao.finalizaUso();
                        }catch(SQLException onConClose){
                            //System.out.println("Houve erro no fechamento da conexão");
                            JOptionPane.showMessageDialog(cadEditora,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                            onConClose.printStackTrace();
                            resultado = false;
                        }
                    } // fim do bloco try-catch-finally
                }//else do login e senha vazios
        } 
        return resultado;
    }
    
    public static boolean AtvDestvEditora(int op, int pid){
        ListaEditora listaEditora = ListaEditora.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT atdstEditora("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaEditora,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaEditora,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT atdstEditora("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaEditora,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaEditora,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static boolean CadLivro(int edit, int pid, String ptombo, long pisbn, String pnome, int pedicao, int peditora, int pautor,int pano, int ppaginas, String pestado, String pdescricao, Boolean pemprestado, int pexemplares){
        CadLivro cadLivro = CadLivro.getInstancia();
        Boolean resultado = false;

        if(edit==0){
            if(pnome.equals("")||peditora==0||pautor==0||pano==0||pexemplares==0){
            JOptionPane.showMessageDialog(cadLivro, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
            try {
                while(Conexao.getResultSet("SELECT insertLivros("+BibIntelligence.idUsuarioLogado+",\""+ptombo+"\","+pisbn+",\""+pnome+"\","+pedicao+","+peditora+","+pautor+","+pano+","+ppaginas+",\""+pestado+"\",\""+pdescricao+"\") \"resultado\"").next()) {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
                }catch(SQLException e){
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                    JOptionPane.showMessageDialog(cadLivro,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }finally {
                    try{
                        Conexao.finalizaUso();
                    }catch(SQLException onConClose){
                        //System.out.println("Houve erro no fechamento da conexão");
                        JOptionPane.showMessageDialog(cadLivro,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                        onConClose.printStackTrace();
                        resultado = false;
                    }
                } // fim do bloco try-catch-finally     
            }
        }else{
            if(pnome.equals("")||peditora==0||pautor==0||pano==0){
            JOptionPane.showMessageDialog(cadLivro, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
                try {
                    while(Conexao.getResultSet("SELECT editLivros("+BibIntelligence.idUsuarioLogado+","+pid+",\""+ptombo+"\","+pisbn+",\""+pnome+"\","+pedicao+","+peditora+","+pautor+","+pano+","+ppaginas+",\""+pestado+"\",\""+pdescricao+"\","+pemprestado+") \"resultado\"").next()) {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
                    }catch(SQLException e){
                        e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                        JOptionPane.showMessageDialog(cadLivro,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                        resultado = false;
                    }finally {
                        try{
                            Conexao.finalizaUso();
                        }catch(SQLException onConClose){
                            //System.out.println("Houve erro no fechamento da conexão");
                            JOptionPane.showMessageDialog(cadLivro,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                            onConClose.printStackTrace();
                            resultado = false;
                        }
                    } // fim do bloco try-catch-finally     
            }//else do login e senha vazios
        }   
        return resultado;
    }
    
    public static boolean AtvDestvLivro(int op, int pid){
        ListaLivro listaLivro = ListaLivro.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT atdstLivros("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaLivro,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaLivro,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT atdstLivros("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaLivro,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaLivro,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static boolean RegistraEmprestimo(int op, int usuario,int livro,String idPC,int telaNum){
        Boolean resultado = false;
            try {
                while(Conexao.getResultSet("SELECT registraEmprestimo("+op+","+usuario+","+livro+","+idUsuarioLogado+",\""+idPC+"\") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                switch(telaNum){
                    case 0: RegistraEmprestimo registraEmprestimo = RegistraEmprestimo.getInstancia(); JOptionPane.showMessageDialog(registraEmprestimo,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE); break;
                    case 1: REPerg rePerg = REPerg.getInstancia(); JOptionPane.showMessageDialog(rePerg,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE); break;
                    case 2: REUsuarios reUsuarios = REUsuarios.getInstancia();  JOptionPane.showMessageDialog(reUsuarios,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE); break;
                }
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    switch(telaNum){
                    case 0: RegistraEmprestimo registraEmprestimo = RegistraEmprestimo.getInstancia(); JOptionPane.showMessageDialog(registraEmprestimo,"Erro2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE); break;
                    case 1: REPerg rePerg = REPerg.getInstancia(); JOptionPane.showMessageDialog(rePerg,"Erro2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE); break;
                    case 2: REUsuarios reUsuarios = REUsuarios.getInstancia();  JOptionPane.showMessageDialog(reUsuarios,"Erro2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE); break;
                    }
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        return resultado;
    }
    
    public static boolean RegistraDevolucao(int op, int pid, int idEmprestimo,int telaNum){
        Boolean resultado = false;
            try {
                while(Conexao.getResultSet("SELECT registraDevolucao("+op+","+pid+","+idEmprestimo+","+idUsuarioLogado+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                RegistraDevolucao registraDevolucao = RegistraDevolucao.getInstancia(); JOptionPane.showMessageDialog(registraDevolucao,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    RegistraDevolucao registraDevolucao = RegistraDevolucao.getInstancia(); JOptionPane.showMessageDialog(registraDevolucao,"Erro2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        return resultado;
    }
    
    public static boolean RegistraBaixa(int idEmprestimo){
        RegistraBaixa registraBaixa = RegistraBaixa.getInstancia();
        Boolean resultado = false;
            try {
                while(Conexao.getResultSet("SELECT registraBaixa("+idEmprestimo+","+idUsuarioLogado+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(registraBaixa,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(registraBaixa,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        return resultado;
    }
    
    public static boolean CadGrupoSeg(int edit, int pid, String pnome){
        CadGrupoSeg cadGrupoSeg = CadGrupoSeg.getInstancia();
        Boolean resultado=false;
        if(edit==0){
            if(pnome.equals("")){
            JOptionPane.showMessageDialog(cadGrupoSeg, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
            try {
                while(Conexao.getResultSet("SELECT insertGrupoSeg("+BibIntelligence.idUsuarioLogado+",\""+pnome+"\") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(cadGrupoSeg,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadGrupoSeg,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
            }
        }else{
            if(pnome.equals("")){
            JOptionPane.showMessageDialog(cadGrupoSeg, "Os dados marcados com * não podem ficar em branco !", "Erro !", JOptionPane.ERROR_MESSAGE);
            return false;
            }else{
                try {
                    while(Conexao.getResultSet("SELECT editGrupoSeg("+BibIntelligence.idUsuarioLogado+","+pid+",\""+pnome+"\") \"resultado\"").next())
                    {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
                }catch(SQLException e){
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                    JOptionPane.showMessageDialog(cadGrupoSeg,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    resultado = false;
                }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadGrupoSeg,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
                } // fim do bloco try-catch-finally
            }//else do login e senha vazios
        }
        return resultado;
    }
    
    public static boolean AtvDestvGrupoSeg(int op, int pid){
        ListaGrupoSeg listaGrupoSeg = ListaGrupoSeg.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT atdstGrupoSeg("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaGrupoSeg,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaGrupoSeg,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT atdstGrupoSeg("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaGrupoSeg,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaGrupoSeg,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static boolean CadPermGrupoSeg(int grupo,int permissao){
        CadPermGrupo cadPermGrupo = CadPermGrupo.getInstancia();
        Boolean resultado=false;
            try {
                while(Conexao.getResultSet("SELECT insertPermissaoGrupo("+BibIntelligence.idUsuarioLogado+","+grupo+","+permissao+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(cadPermGrupo,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(cadPermGrupo,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        return resultado;
    }
    
    public static boolean AtvDestvPermGrupoSeg(int op, int pid){
        ListaPermGrupo listaPermGrupo = ListaPermGrupo.getInstancia();
        Boolean resultado = false;
        if(op==0){ //
            try {
                while(Conexao.getResultSet("SELECT atdstPermissaoGrupo("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaPermGrupo,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaPermGrupo,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }else{
            try {
                while(Conexao.getResultSet("SELECT atdstPermissaoGrupo("+op+","+BibIntelligence.idUsuarioLogado+","+pid+") \"resultado\"").next())
                {
					if(Conexao.getRsBoolean("resultado")){
                                            resultado = true;
                                        }else{
                                            resultado = false;
                                        }
				}
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(listaPermGrupo,"Erro na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                resultado = false;
            }finally {
                try{
                    Conexao.finalizaUso();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(listaPermGrupo,"Erro 2 na conexão, com o banco de dados!","Erro!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                    resultado = false;
                }
            } // fim do bloco try-catch-finally
        }
        return resultado;
    }
    
    public static Boolean estaRegistrado(Registro reg){
        Boolean resultado = false;
        
        if((reg.getNomeRegistro().equals("") == false) && (reg.getTipoRegistro().equals("") == false)){
            resultado = true;
        }   
        
        return resultado;
    }
    
}
