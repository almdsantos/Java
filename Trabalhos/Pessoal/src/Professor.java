public class Professor extends Pessoal {
    private int salarioP;

    public int getSalarioP() {
        return salarioP;
    }

    public void setSalarioP(int salarioP) {
        this.salarioP = salarioP;
    }
    
    public double bonificacaoProfessor(){
        return this.getSalarioP() * 0.15;
    }
    
    void mostrarDados(){
        System.out.println("Professor");
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("Salario: " + getSalarioP());
        System.out.println("Bonificacao - 15%: " + bonificacaoProfessor());
    }
}
