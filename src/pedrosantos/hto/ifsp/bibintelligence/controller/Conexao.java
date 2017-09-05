/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedrosantos.hto.ifsp.bibintelligence.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;




/**
 *
 * @author Pedro
 */
public class Conexao {
    /*
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/biblintelligence";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    */
    
    private Conexao(){
        
    }
    
    private static Statement constt;
    private static ResultSet rs;
    private static Connection conexao;
    private static String USUARIO = "root";
    private static String SENHA = "";
    private static String HOST = "localhost";
    private static String BANCO = "biblintelligence";
    
    
    /*
    // Conectar ao banco
    public static Connection abrir() throws Exception {
        // Registrar o driver
        //////Class.forName(DRIVER);
        // Capturar a conexão
        //////Connection conn = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        /////return conn;


    }*/
    
        public static Connection getConexao() throws SQLException{
            if(conexao==null){
            conexao = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+BANCO,USUARIO,SENHA);
            }
            return conexao;
        }
	
	public static Statement getStatement() throws SQLException {
		if(constt==null){
                //Class.forName("com.mysql.jdbc.Driver"); 
                constt = getConexao().createStatement();
                }        
		return constt;
        }
        
        public static ResultSet getResultSet(String SQL) throws SQLException{
            if(rs==null){
            rs = getStatement().executeQuery(SQL);
            }
            return rs;
        }
        
        public static Boolean getRsBoolean(String field) throws SQLException{
            Boolean resultado = getResultSet(null).getBoolean(field);            
            return resultado;
        }
        
        public static String getRsString(String field) throws SQLException{
            String resultado = getResultSet(null).getString(field);            
            return resultado;
        }
        
        public static int getRsInt(String field) throws SQLException{
            int resultado = getResultSet(null).getInt(field);            
            return resultado;
        }
        
        public static long getRsLong(String field) throws SQLException{
            long resultado = getResultSet(null).getLong(field);   
            return resultado;
        }
        
        public static Date getRsDate(String field) throws SQLException{
            Date resultado = getResultSet(null).getDate(field);
            return resultado;
        }
        
        public static void abortStt(){
            constt=null;
        }
        
        public static void abortRs(){
            rs=null;
        }
        
        public static void fechaConexao() throws SQLException{
            conexao.close();
            conexao = null;
        }
        
        public static void finalizaUso() throws SQLException{
            abortRs();
            abortStt();
            fechaConexao();
        }
        
        public static void setConfiguracoes(String usuario,String senha,String host,String banco){
            USUARIO = usuario;
            SENHA = senha;
            HOST = host;
            BANCO = banco;
        }
        
}
