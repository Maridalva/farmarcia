package farmacia;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class SistemaPerfilAcesso extends JFrame {
		
	    private JTextField textFieldUsuario;
	    private JPasswordField passwordFieldSenha;

	    public SistemaPerfilAcesso() {
	        // Configurar a janela principal
	        setTitle("Sistema de Perfil de Acesso");
	        setSize(400, 200);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Criar painel de login
	        JPanel painelLogin = new JPanel();
	        painelLogin.setLayout(new GridLayout(3, 2));

	        JLabel labelUsuario = new JLabel("Usuário:");
	        textFieldUsuario = new JTextField();
	        JLabel labelSenha = new JLabel("Senha:");
	        passwordFieldSenha = new JPasswordField();
	        JButton btnLogin = new JButton("Login");

	        painelLogin.add(labelUsuario);
	        painelLogin.add(textFieldUsuario);
	        painelLogin.add(labelSenha);
	        painelLogin.add(passwordFieldSenha);
	        painelLogin.add(new JLabel()); // Espaço vazio
	        painelLogin.add(btnLogin);

	        // Configurar ação do botão de login
	        btnLogin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String usuario = textFieldUsuario.getText();
	                String senha = String.valueOf(passwordFieldSenha.getPassword());

	                // Realizar autenticação no banco de dados
	                if (autenticarUsuario(usuario, senha)) {
	                    // Redirecionar para o menu do administrador ou usuário
	                    if (isUsuarioAdministrador(usuario)) {
	                        abrirMenuAdministrador();
	                    } else {
	                        abrirMenuUsuario();
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Autenticação falhou. Tente novamente.");
	                }
	            }
	        });

	        // Adicionar o painel de login à janela
	        add(painelLogin);

	        // Tornar a janela visível
	        setVisible(true);
	    }

	    private boolean autenticarUsuario(String usuario, String senha) {
	        // Conecte-se ao banco de dados e verifique a autenticação
	        String url = "jdbc:mysql://localhost:3306/seubanco";
	        String user = "seuusuario";
	        String password = "suasenha";

	        try (Connection connection = DriverManager.getConnection(url, user, password)) {
	            String query = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, usuario);
	            preparedStatement.setString(2, senha);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            return resultSet.next(); // Se há resultados, a autenticação foi bem-sucedida
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    private boolean isUsuarioAdministrador(String usuario) {
	        // Verificar se o usuário é administrador (você pode adaptar esta lógica ao seu banco de dados)
	        return usuario.equals("admin");
	    }

	    private void abrirMenuAdministrador() {
	        // Implemente a lógica para abrir o menu do administrador
	        JOptionPane.showMessageDialog(null, "Bem-vindo, Administrador!");
	    }

	    private void abrirMenuUsuario() {
	        // Implemente a lógica para abrir o menu do usuário
	        JOptionPane.showMessageDialog(null, "Bem-vindo, Usuário!");
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new SistemaPerfilAcesso();
	            }
	        });
	    }
	}

}
