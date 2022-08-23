package Cliente;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class tela_clientes extends JFrame {

	private JPanel contentPane;
	private JLabel lblCPF;
	private JTextField txtNomeCliente;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblNewLabel;
	private JLabel lblTelefone;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_clientes frame = new tela_clientes();
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
	private JPasswordField passwordField;
	public tela_clientes() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(20, 239, 104, 14);
		contentPane.add(lblCPF);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setBounds(20, 72, 104, 14);
		contentPane.add(lblNomeDoCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(20, 96, 371, 20);
		contentPane.add(txtNomeCliente);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(20, 152, 371, 20);
		contentPane.add(txtEmail);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 127, 104, 14);
		contentPane.add(lblEmail);
		
		lblNewLabel = new JLabel("CADASTRO DE CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(240, 0, 170, 36);
		contentPane.add(lblNewLabel);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(20, 352, 104, 14);
		contentPane.add(lblTelefone);
		
		MaskFormatter maskFone = new MaskFormatter("(##) 9 ####-####");
		maskFone.setPlaceholderCharacter('_');
		JFormattedTextField formtxtFone = new JFormattedTextField(maskFone);
		formtxtFone.setBounds(20, 377, 102, 20);
		contentPane.add(formtxtFone);
		
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.setPlaceholderCharacter('_');
		JFormattedTextField formtxtCpf = new JFormattedTextField(maskCpf);
		formtxtCpf.setBounds(20, 264, 94, 20);
		contentPane.add(formtxtCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(20, 295, 104, 14);
		contentPane.add(lblDataDeNascimento);
		
		MaskFormatter maskData = new MaskFormatter("##/##/####");
		maskData.setPlaceholderCharacter('_');
		JFormattedTextField formtxtData = new JFormattedTextField(maskData);
		formtxtData.setBounds(20, 320, 69, 20);
		contentPane.add(formtxtData);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 208, 69, 20);
		contentPane.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(20, 183, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				}
		});
		btnVoltar.setToolTipText("Voltar ao Menu Inicial");
		btnVoltar.setBounds(0, 0, 89, 36);
		contentPane.add(btnVoltar);
		
		JButton btnSalvar = new JButton("SALVAR");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtNomeCliente.getText().length() > 0 && txtEmail.getText().length() > 0 && formtxtCpf.isEditValid() && formtxtFone.isEditValid() && formtxtData.isEditValid()) {
					
					String senha = String.valueOf(passwordField.getPassword());
					String cpf = String.valueOf(formtxtCpf.getText());
					String fone = formtxtFone.getSelectedText();
					String data = String.valueOf(formtxtData.getText());
					
					cc.setNome(txtNomeCliente.getText());
					cc.setEmail(txtEmail.getText());
					cc.setCpf(cpf);
					cc.setFone(fone);
					cc.setData(data);
					cc.setSenha(senha);
					
					try {
						cc.salvarDados();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Salvo com sucsso!", "", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Dado faltando!", "", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(545, 0, 89, 36);
		contentPane.add(btnSalvar);
	}
}
