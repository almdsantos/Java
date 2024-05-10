
package login;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Professor Marcos Costa
 */
public class TelaInicio extends JFrame{
    private final JPanel tela;   
    private boolean exclusaoValida;
    
     public TelaInicio() {  
                
        setLocationRelativeTo(null); 
        setResizable(false);        
        setTitle("Menu - Senac");          
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(500, 200, 426, 212);        
                
        tela = new JPanel();        
        tela.setBackground(SystemColor.gray); 
        setContentPane(tela);
        tela.setLayout(null);
        
        //Concateno o Label com o atributo global nome da classe Usuario
        JLabel lblUsuario = new JLabel("Bem vindo " + Usuario.nomeUsuario);
        lblUsuario.setBounds(24, 65, 200, 15);
        tela.add(lblUsuario);        
               
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(2, 130, 117, 25);
        tela.add(btnExcluir); 
        
        JButton btnAlterar = new JButton("Alterar Dados"); //****
        btnAlterar.setBounds(150, 130, 117, 25);
        tela.add(btnAlterar); 
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(300, 130, 117, 25);
        tela.add(btnVoltar);   
        
        btnVoltar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              try{
                  TelaLogin telaLogin = new TelaLogin();
                  telaLogin.setVisible(true);
                  dispose();
              }catch (Exception ec) {
                  System.out.println("Erro ao consultar usuário " 
                                                             + ec.getMessage());
              }

          }
        });
        
        btnAlterar.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              try{
                  TelaAlteracao telaAlterar = new TelaAlteracao();
                  telaAlterar.setVisible(true);              
                  dispose();
                  
              }catch (Exception ec) {
                  System.out.println("Erro ao consultar usuário " 
                                                             + ec.getMessage());
              }

          }
        });
        
        btnExcluir.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              try{
                  //Array que recebe as opções
                  Object[] options = { "Sim", "Não" }; 
                  int opcao = JOptionPane.showOptionDialog(null, 
                              Usuario.nomeUsuario + 
                              ", deseja se excluir?", "Atenção", 
                              JOptionPane.DEFAULT_OPTION, 
                              JOptionPane.QUESTION_MESSAGE, null, 
                              options, options[0]); 
                  
                  if (opcao == 0) {
                    //Excluir o usuario                     
                    //Instancio a classe usuario
                    Usuario usu = new Usuario();
                    
                     exclusaoValida = 
                               usu.excluiUsuario(Usuario.usuarioSistema);
                        
                        if (exclusaoValida == true){
                            //Usuario excluído na base de dados
                            JOptionPane.showMessageDialog(null,
                             "Usuário deletado corretamente, voltaremos "
                           + "a tela de login.",
                             "Atenção", 
                            JOptionPane.INFORMATION_MESSAGE);
                            
                            //Abrimos a tela de login novamente
                            TelaLogin tLogin = new TelaLogin();
                            tLogin.AbreTela();
                            dispose();
                            
                        }else{                            
                            JOptionPane.showMessageDialog(null,
                             "Problemas ao excluir o usuário",
                             "Atenção", 
                            JOptionPane.ERROR_MESSAGE);
                        }
                  }
                  
              }catch (Exception ec) {
                  System.out.println("Erro ao consultar usuário " 
                                                             + ec.getMessage());
              }

          }
        });
    }
     
    public void AbreTela(){
        TelaInicio telaInicio = new TelaInicio();
        telaInicio.setVisible(true);
    }
}
