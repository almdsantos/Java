package login;

import java.awt.Font;  //Trabalhar com fontes
import java.awt.SystemColor; //Trabalhar com cores
import java.awt.event.ActionEvent; //Trabalhar com evento
import java.awt.event.ActionListener; //Lista de eventos
import javax.swing.JButton;  //Trabalhar com botões
import javax.swing.JFrame;   //Trabalhar com frames
import javax.swing.JLabel;   //Trabalhar com labels
import javax.swing.JOptionPane; //Trabalhar com mensagens
import javax.swing.JOptionPane; //Trabalhar com mensagens
import javax.swing.JPanel; //Trabalhar com painéis
import javax.swing.JPasswordField; //Trabalhar com campos de senha
import javax.swing.JTextField;  //Trabalhar com campos de texto

public class TelaLogin extends JFrame{    
    
    //tela Objeto JPanel (tela em si)
    private final JPanel  panelTela;
   
    //txtusuario Objeto JTextField (campo na tela)
    private final JTextField txtUsuario;
    
    //pswSenha Objeto PasswordField (campo na tela)
    private final JPasswordField pswSenha;
    
    //validar se o usuario é correto
    private boolean usuarioValido;
    
    //Método construtor
    public TelaLogin() { 
        //coloca o objeto na referencia do centro da tela
        setLocationRelativeTo(null);                    
        
        //não permite que o objeto seja expandido
        setResizable(false);                            
        
        //coloca título na caixa JFrame
        setTitle("Login - Senac");                              
        
        //Quando clicado no X eu encerro todo o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //define posionamento e tamanho
        //         x    y  width height
        setBounds(500, 200, 426, 212);
        
        //Crio um objeto JPanel e atributo ele a variável tela
        panelTela = new JPanel();     
        
        //Define a cor de fundo do JPanel (tela)
        panelTela.setBackground(SystemColor.white); 
        setContentPane(panelTela);
        
        //Vou utilizar o meu panel sem utilizar o padrão
        panelTela.setLayout(null);         
               
        //Adicionando elementos na tela:
        // Criando um objeto do tipo JLabel e atribuindo o valor ao atributo         
        JLabel lblIdentificao = new JLabel("IDENTIFICAÇÃO"); 
        
        //Localização na tela
        lblIdentificao.setBounds(144, 0, 160, 39);
        
        //Definindo a Fonte
        lblIdentificao.setFont(new Font("Times New Roman", 3, 19));
        
        //Adicionando o meu label ao meu Panel
        panelTela.add(lblIdentificao);   
        
        //Identificação e Posicionamento dos labels        
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(24, 65, 70, 15);
        panelTela.add(lblUsuario);
        
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(24, 92, 70, 15);
        panelTela.add(lblSenha);
        
        //Identificação e Posicionamento dos texts fields        
        txtUsuario = new JTextField();
        txtUsuario.setBounds(112, 63, 219, 19);
        panelTela.add(txtUsuario);
        txtUsuario.setColumns(10);
                   
        pswSenha = new JPasswordField();
        pswSenha.setBounds(112, 90, 219, 19);
        panelTela.add(pswSenha);
        
        //Identificação e Posicionamento dos botões
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(200, 136, 117, 25);
        panelTela.add(btnEntrar);  
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(50, 136, 117, 25);
        panelTela.add(btnCadastrar);           
    
        
        //Ação no botão de entrar no sistema
        btnEntrar.addActionListener(new ActionListener(){
            //Fazer críticas de tela, verificando se o usuário e
            //Senha foram mencionados pelo usuario
            public void actionPerformed(ActionEvent e) {
            //Instancio a classe usuario
            Usuario usu = new Usuario();

            //Utilizo o setter de usuario e senha
            usu.setUsuario(txtUsuario.getText());
            usu.setSenha(pswSenha.getText());

            if("".equals(txtUsuario.getText())){
                //Vamos dar uma mensagem na tela
                JOptionPane.showMessageDialog(null,
                        "Campo usuário precisa ser informado!",
                        "Atençao",
                        JOptionPane.ERROR_MESSAGE);
                //Voltar o cursor para o campo txtUsuario
                txtUsuario.grabFocus();
            } else if("".equals(pswSenha.getText())){
                //Vamos dar uma mensagem na tela
                JOptionPane.showMessageDialog(null,
                        "Campo senha precisa ser informado!",
                        "Atenção",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                //Verifico se o usuario consta no banco de dados
                usuarioValido = usu.verificaUsuario(usu.getUsuario(), usu.getSenha());
                if(usuarioValido == true){
                    //Usuario e senha bateram no banco estão corretos
                    JOptionPane.showMessageDialog(null,
                        "Usuario válido em nossa base de dados",
                        "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,
                        "Usuário inválido ou inexistente",
                        "Atenção",
                        JOptionPane.ERROR_MESSAGE);

                    //Método para limpar os textos
                    LimpaText();

                    //Mando o foco para o campo usuário
                    txtUsuario.grabFocus();
                }
            }
        } 
    });
   }
    public void AbreTela(){
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }

    public void LimpaText(){
        txtUsuario.setText("");
        pswSenha.setText("");
    }
}