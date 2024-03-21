class Funcionario{
    String nome;
    double salario;
    
    void aumenta(double valor) {
        this.salario += valor;
    }
    void imprimeSalario(){
        System.out.println("SALDO: " + this.salario);
    }
}