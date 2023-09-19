package farmacia;


	
	import java.awt.event.ActionListener;


	import javax.swing.JButton;

	import javax.swing.JFrame;

	import javax.swing.JLabel;

	import javax.swing.JPasswordField;

	import javax.swing.JTextField;


	public class Login  extends JFrame implements ActionListener {

	                     //herda(herança)



	JLabel LblUsuario, LblSenha; 

	JTextField txtUsuario;

	JPasswordField txtSenha;

	JButton btnLogin, btnCadastro;


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

	txtSenha.setBounds(110,50,100,25);


	btnLogin=new JButton("Login");

	btnLogin.setBounds(50,120,100,25);

	btnLogin.addActionListener(this);


	btnCadastro=new JButton("Cadastro");

	btnCadastro.setBounds(50,120,100,25);

	btnCadastro.addActionListener(this);



	this.add(LblUsuario);

	this.add(txtUsuario);

	this.add(LblSenha);

	this.add(txtSenha);

	this.add(btnLogin);

	this.add(btnCadastro);


	}

	public void VerificarLogin() {


	String usuario= txtUsuario.getText();

	String senha= new String(txtSenha.getPassword());




	if(usuario.equals("admin")&& senha.equals("123")) {


	}}


	public static void main(String[] args) {




	}


	}


	


