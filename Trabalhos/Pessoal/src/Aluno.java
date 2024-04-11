public class Aluno extends Pessoal{
    private int ra;
    private int nota;

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    void mostrarDados(){
        System.out.println("Aluno");
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("Registro do Aluno: " + getRa());
        System.out.println("Nota Final: " + getNota());
    }    
}

