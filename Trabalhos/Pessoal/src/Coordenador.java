public class Coordenador extends Pessoal {
    private String area;
    private int salarioC;
    
    public String getArea(){
    return this.area; 
}
    public int getSalarioC(){
        return this.salarioC;
    }
    public void setArea(String area){
        this.area = area;
    }
    public void setSalarioC(int salarioC){
        this.salarioC = salarioC;
    }
    
    void mostrarDados(){
        System.out.println("Coordenador");
        System.out.println("Nome: " + getNome());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Email: " + getEmail());
        System.out.println("Salario: " + getSalarioC());
    }
}
