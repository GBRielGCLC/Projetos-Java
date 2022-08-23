package Cliente;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class consulta_cadastro_cliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField formtxtConsultaCpf;
	
	ArrayList<String> Dados = new ArrayList<String>();
	private String email;
	private String senha;
	private String cpf;
	private String nome;
	private String fone;
	private String data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					consulta_cadastro_cliente frame = new consulta_cadastro_cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	cadastro_cliente cc = new cadastro_cliente();
	public consulta_cadastro_cliente() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTAR CLIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(240, 11, 170, 36);
		contentPane.add(lblNewLabel);
		
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setPlaceholderCharacter('_');
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 102, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 127, 371, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JFormattedTextField formtxtCpf = new JFormattedTextField(maskCpf);
		formtxtCpf.setBounds(527, 127, 94, 20);
		contentPane.add(formtxtCpf);
		
		MaskFormatter maskData = new MaskFormatter("##/##/####");
		maskData.setPlaceholderCharacter('_');
		JFormattedTextField formtxtData = new JFormattedTextField(maskData);
		formtxtData.setBounds(412, 127, 69, 20);
		contentPane.add(formtxtData);
		
		MaskFormatter maskFone = new MaskFormatter("(##) 9 ####-####");
		maskFone.setPlaceholderCharacter('_');
		JFormattedTextField formtxtFone = new JFormattedTextField(maskFone);
		formtxtFone.setBounds(412, 226, 102, 20);
		contentPane.add(formtxtFone);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(527, 102, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblDatanascimento = new JLabel("Data de nascimento");
		lblDatanascimento.setBounds(391, 102, 123, 14);
		contentPane.add(lblDatanascimento);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 226, 371, 20);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 201, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(412, 201, 57, 14);
		contentPane.add(lblTelefone);
		
		JButton btnNewButton = new JButton("Alterar e Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cc.alterarDados();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 340, 132, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(532, 340, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCarregarDados = new JButton("Carregar Dados");
		btnCarregarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String linha;
					FileReader arquivoFisico = new FileReader("Login.txt");
					BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
					linha = arquivoLogico.readLine();

					while (linha != null) {
						Dados.add(linha);
						linha = arquivoLogico.readLine();
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				formtxtCpf.replaceSelection(Dados.get(2));
				txtNome.replaceSelection(Dados.get(3));
				formtxtFone.replaceSelection(Dados.get(4));
				formtxtData.replaceSelection(Dados.get(5));
				
			}
		});
		btnCarregarDados.setBounds(252, 340, 150, 23);
		contentPane.add(btnCarregarDados);
		
	}
}
