package farmacia;
import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


	import javax.swing.JButton;

	import javax.swing.JFrame;

	import javax.swing.JLabel;

	import javax.swing.JPasswordField;

	import javax.swing.JTextField;


public class Login  extends JFrame implements ActionListener {

	                     //herda(herança)



	JLabel LblUsuario, LblSenha, LblMensagem;

	JTextField txtUsuario;

	JPasswordField txtSenha;

	JButton btnLogin, btnCadastro,btnSair;


	public Login() {

	super("tela de login");

	//molde do login

	this.setSize(400,300);
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	LblUsuario =new JLabel("Usuario");
    LblUsuario.setBounds(50,50,100,25);


	txtUsuario=new JTextField();
    txtUsuario.setBounds(110,50,200,25);


	LblSenha =new JLabel("Senha");
    LblSenha.setBounds(50,80,100,25);


	txtSenha=new JPasswordField();
    txtSenha.setBounds(110,80,200,25);


	btnLogin=new JButton("Login");
    btnLogin.setBounds(20,120,100,25);
    btnLogin.addActionListener(this);
	  
	btnSair = new JButton("Sair");
    btnSair.setBounds(250, 120, 100, 25);
    btnSair.addActionListener(this);

	btnCadastro=new JButton("Cadastro");
    btnCadastro.setBounds(135,120,100,25);

	btnCadastro.addActionListener(this);



	this.add(LblUsuario);
    this.add(txtUsuario);
    this.add(LblSenha);
    this.add(txtSenha);
    this.add(btnLogin);
    this.add(btnCadastro);
    this.add(btnSair);
    this.add(LblMensagem);
	}

	public void VerificarLogin() {

   String usuario= txtUsuario.getText();
   String senha= new String(txtSenha.getPassword());




	if(usuario.equals("admin")&& senha.equals("123")) {
     LblMensagem.setText("Seja bem vindo administrador!");
     LblMensagem.setForeground(Color.blue);
     
	}else if (usuario.equals("usuario") && senha.equals("456")){
		LblMensagem.setText("Seja bem-vindo, Usuário");

		LblMensagem.setForeground(Color.black);

		} else {

		LblMensagem.setText("Usuário ou Senha estão incorretos");

		LblMensagem.setForeground(Color.red);

		}

		}
	@Override
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == btnLogin) {
    VerificarLogin();
  } 
  else if (e.getSource() == btnSair) {
  System.exit(0);
 }

else if (e.getSource() == btnCadastro) {
dispose();
Cadastro cadastro = new Cadastro();
cadastro.setVisible(true);

}

}

public static void main(String[] args) {

SwingUtilities.invokeLater(() -> {
JFrame janela = new Login();
janela.setVisible(true);


	});

	}
}

	


	

	






	


