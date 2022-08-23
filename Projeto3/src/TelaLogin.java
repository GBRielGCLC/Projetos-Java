package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JLabel lblSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	cadastro_cliente cc = new cadastro_cliente();
	public TelaLogin() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(13, 72, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(69, 66, 308, 27);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(69, 119, 308, 27);
		contentPane.add(passwordField);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 125, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnLogar = new JButton("Fazer login");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cc.setPesquisa(txtEmail.getText());
					cc.login();
					boolean email = false, senha=false;
					String pass = new String(passwordField.getPassword());
					if(txtEmail.getText().equals(cc.Cadastro.get(cc.getPosicao()))) {
						email = true;
					}
					if(pass.equals(cc.Cadastro.get(cc.getPosicao()+1))) {
						senha = true;
					}
					if(email==false){
						JOptionPane.showMessageDialog(null, "Email incorreto!", "", JOptionPane.ERROR_MESSAGE);
					}
					if(senha==false) {
						JOptionPane.showMessageDialog(null, "Senha incorreta!", "", JOptionPane.ERROR_MESSAGE);
					}
					if(email==true && senha==true) {
						JOptionPane.showMessageDialog(null, "Logado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
						FileWriter arquivoFisico = new FileWriter("Login.txt");
						PrintWriter aql = new PrintWriter(arquivoFisico);
						
						
						aql.println(cc.Cadastro.get(cc.posicao));
						aql.println(cc.Cadastro.get(cc.posicao+1));
						aql.println(cc.Cadastro.get(cc.posicao+2));
						aql.println(cc.Cadastro.get(cc.posicao+3));
						aql.println(cc.Cadastro.get(cc.posicao+4));
						aql.println(cc.Cadastro.get(cc.posicao+5));
						aql.println();
						
						aql.close();
						
						dispose();
					}
						
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogar.setBounds(147, 197, 123, 23);
		contentPane.add(btnLogar);
	}
}
