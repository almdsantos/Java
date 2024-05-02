/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author aliston.msantos
 */

import java.sql.Connection; //Conexçao com o banco de dados
import java.sql.DriverManager; //Driver de conexão, em nosso caso MySql
import java.sql.ResultSet; //Resultados das operações em banco de dados
import java.sql.Statement; //Interpretação dos comandos SQL - CRUD

public class Conexao {
    //Atributos de conexão ligados a bibliotecas importadas
    public Connection con = null;
    public Statement stmt = null;
    public ResultSet resultset = null;
    
    //Atributos de conexão
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/login"; //servidor de banco de dados
    private final String usuario = "root"; //Usuário do banco de dados
    private final String senha = ""; //Senha do banco de dados
    private final String driver = "com.mysql.jdbc.Driver"; //Driver de conexão
    //Método de abertura da conexão com banco de dados
    public Connection AbrirConexao(){
        try{
            Class.forName(driver); //Driver de utilização
            //Atributos de conexão
            con = DriverManager.getConnection(servidor, usuario, senha);
            stmt = con.createStatement(); //Fazendo a conexão com o banco de dados
            //Mensagem informando que a conexão foi realizada com sucesso
            System.out.println("Conexao aberta com sucesso");
        } catch (Exception e) {
            //Mensagem de saida caso haja erro
            System.out.println("Erro ao acessar banco de dados, verifique");
        }
        return con; //Retorna a conexão
    }
    //Método de fechamento da conexão com o banco de dados
    public void FecharConexao(){
        try {
            con.close();//Fechamento da conexão com o banco de dados
            //Mensagem que fechou a conexão
            System.out.println("Conexao finalizada com sucesso");
        }catch (Exception e) {
            //Mensagem de erro ao fechar conexão
            System.out.println("Erro ao encerrar conexao "+ e.getMessage());
        }
    }
}
