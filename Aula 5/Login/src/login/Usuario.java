package login;

public class Usuario{
    //Criação dos atributos privados da classe
    private String usuario;
    private String nome;
    private String senha;
    
    static String nomeUsuario;
    static String usuarioSistema;
    
    //Atributo que armazenará o retorno do banco de dados
    private boolean resultUsuario;
    private boolean resultCadastro;
    
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
    //Método de verificação se o usuário (somente) existe na base
    public Boolean verificaUsuario(String usuario){
        //Fazer a instâncoa da coexão com o banco de dados
        Conexao banco = new Conexao();

        try{
            //Abro a conexão com o banco de dados
            banco.AbrirConexao();

            //Criando parâmetro de retorno
            banco.stmt= banco.con.createStatement();
            
            //Executando a consulta no banco de dados
            banco.resultset = banco.stmt.executeQuery("SELECT * FROM usuario WHERE apelido = '" + usuario + "'");
            
            //Verificando se existe retorno de dados no banco
            if (banco.resultset.next()){
                //Caso tenha
                resultUsuario = true;
            } else {
                //Caso não tenho
                resultUsuario = false;
            }

            banco.FecharConexao(); //Fecha nossa conexão com o banco de dados
        }catch (Exception ec) {
            System.out.println("Erro ao consultar usuário" + ec.getMessage());
        }
        
        return resultUsuario;
    }

    public Boolean cadastraUsuario(String nome, String usuario, String senha) {
        //Fazer a instância da conexão com o banco de dados
        Conexao banco = new Conexao();

        try{
            //Abro a conexão com o banco de dados
            banco.AbrirConexao();

            //Criando parâmetro de retorno
            banco.stmt = banco.con.createStatement();

            //Executando a inserção no banco de dados
            banco.stmt.execute("INSERT INTO usuario (nome, apelido, senha) VALUES ('" + nome + "','" + usuario + "','" + senha + "')");   
        //Caso insira
        resultCadastro = true;
        
        } catch (Exception ec) {
            //Aconteceu algum problema
            System.out.println("Erro ao inserir usuário " + ec.getMessage());   
            resultCadastro = false;
        }
        banco.FecharConexao(); //Fecha nossa conexão com o banco de dados

        return resultCadastro;
    }

    boolean excluiUsuario(String usuarioSistema) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean alteraUsuario(String nome, String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}


