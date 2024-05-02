package login;

/**
 *
 * @author aliston.msantos
 */
public class TestaConexao {
//Teste para verificar se o banco conecta e desconecta
    public static void main(String[] args) {
        Conexao c = new Conexao(); //Instanciamos o objeto c de conexão
        c.AbrirConexao(); //Chamamos o método para abertura da conexão com o DB
        
        try {
            Thread.sleep(4000); //Fazemos uma pausa de 4 segundos
            c.FecharConexao(); //Fechamos a conexão
        } catch(InterruptedException ex){
            //Mensagen de saida caso haja erro
            System.out.println("Deu ruim em");
        }
    }
}
