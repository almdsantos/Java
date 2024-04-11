class TestaPessoal {
    public static void main(String[] args) {
    Coordenador c = new Coordenador();
        c.setNome ("Bruno");
        c.setTelefone (1011121314);
        c.setEmail ("bruno.lima@gmail.com");
        c.setArea ("Tecnologia da Informação");
        c.setSalarioC (1500);
        
    Professor p = new Professor();
        p.setNome("Aliston Santos");
        p.setTelefone (1234567891);
        p.setEmail ("aliston.santos@gmail.com");
        p.setSalarioP (1000);
                
        Aluno a = new Aluno();
        a.setNome("Joao Henrique");
        a.setTelefone (2021222324);
        a.setEmail ("joao.henrique@gmail.com");
        a.setRa (12345);
        a.setNota(10);
        
        c.mostrarDados();
        p.mostrarDados();
        a.mostrarDados();  
    }    
}
    