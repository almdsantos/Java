public class TestaFuncionario {
    public static void main(String[] args){
        Funcionario f = new Funcionario();
        f.nome = "Aliston";
        f.salario = 100;
        
        f.aumenta(1000);
        f.imprimeSalario();
    }
}
