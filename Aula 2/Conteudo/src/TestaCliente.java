
public class TestaCliente {
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.nome = "Henrique";
        c1.codigo = 1;
          
       Cliente c2 = new Cliente();
       c2.nome = "Marinho";
       c2.codigo = 2;
       
       System.out.println(c1.nome);
       System.out.println(c1.codigo);
       System.out.println(c2.nome);
       System.out.println(c2.codigo);
           
    }
    
}
