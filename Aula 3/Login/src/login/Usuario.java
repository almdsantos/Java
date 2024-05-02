package login;

import java.sql.ResultSet; //Resultado do banco de dados

public class Usuario {
    //Criação dos atributos privados da classe
    private String usuario;
    private String nome;
    private String senha;
    
    //Atributo que armazenará o retorno do banco de dados
    private boolean resultUsuario;
    
    //Criação dos getters e setters
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }


//Método de verificação da autenticidade do usuario
public Boolean verificaUsuario(String usuario, String senha){
    //Fazer a instancia da conexão com o banco de dados
    Conexao banco = new Conexao();

    try {
        //Abro a conexão com o banco de dados
        banco.AbrirConexao();

        //Criando parâmetro de retorno
        banco.stmt= banco.con.createStatement();

        //Executando a consulta no banco de dados
        banco.resultset = banco.stmt.executeQuery("SELECT * FROM usuario " + "WHERE apelido = '" + usuario + "'" + " AND senha = '" + senha + "'");
        
        //Verificando se existe retorno de dados no banco
        if (banco.resultset.next()){
            //Caso tenha
            resultUsuario = true;
        } else {
            //Caso não tenha
            resultUsuario = false;
        }

        banco.FecharConexao(); //Fecha nossa conexão com o banco dados
    } catch (Exception ec) {
        System.out.println("Erro ao consultar usuário" + ec.getMessage());
    }

    return resultUsuario;
    }
}

