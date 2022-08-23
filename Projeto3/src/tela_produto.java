import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.TextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import java.awt.TextField;
import java.awt.ScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Canvas;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

	

public class tela_produto extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtCompra;
	private JTextField txtDescriacao;
	private JTextField txtVenda;
	private String codigo;
	int a=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_produto frame = new tela_produto();
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
	
	
	
	cadastro_produtos cp = new cadastro_produtos();
	private JTextField textField;
	private JTextField textQuantidade;
	
	public tela_produto() {
		
		Random ale = new Random();
		int codigo;
		
	
		
		codigo = ale.nextInt(9999999);
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btVoltar = new JButton("VOLTAR");
		btVoltar.setBounds(5, 5, 89, 36);
		btVoltar.setToolTipText("Voltar ao Menu Principal");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				
			}
		});
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setBounds(550, 5, 89, 36);
		btnSalvar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				//falta espiner
				
				if(txtProduto.getText().length() > 0 && txtCompra.getText().length() > 0 && txtVenda.getText().length() > 0 &&
						textField.getText().length() > 0 && textQuantidade.getText().length() > 0) {
					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
					
					cp.setNomeProduto(txtProduto.getText());
					cp.setDescricao(txtDescriacao.getText());
					cp.setPrecoCompra(txtCompra.getText());
					cp.setPrecoVenda(txtVenda.getText());
					cp.setQuantidade(textQuantidade.getText());
					cp.setCodigo(textField.getText());
					
					try {
						cp.salvarDados();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Todos os dados são obrigatórios ");
					
				}
				dispose();	
			}
			
		});
		
		
		btnSalvar.setToolTipText("");
		
		JLabel lblNomeDoProduto = new JLabel("Nome do Produto");
		lblNomeDoProduto.setBounds(25, 69, 104, 14);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(25, 92, 371, 20);
		txtProduto.setColumns(10);
		
		JLabel lblPreoDeCompra = new JLabel("Pre\u00E7o de Compra (Uni)");
		lblPreoDeCompra.setBounds(478, 69, 119, 14);
		
		txtCompra = new JTextField();
		txtCompra.setBounds(478, 92, 104, 20);
		txtCompra.setColumns(10);
		
		JLabel lblR = new JLabel("R$");
		lblR.setBounds(444, 95, 33, 14);
		
		JLabel lblCad = new JLabel("CADASTRO DE PRODUTOS");
		lblCad.setBounds(245, 5, 170, 36);
		lblCad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDescrio = new JLabel("DESCRI\u00C7\u00C3O");
		lblDescrio.setBounds(25, 144, 104, 14);
		
		txtDescriacao = new JTextField();
		txtDescriacao.setBounds(25, 167, 371, 20);
		txtDescriacao.setColumns(10);
		
		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o de Venda (Uni)");
		lblPreoDeVenda.setBounds(478, 144, 119, 14);
		
		JLabel label = new JLabel("R$");
		label.setBounds(444, 170, 33, 14);
		
		txtVenda = new JTextField();
		txtVenda.setBounds(478, 167, 104, 20);
		txtVenda.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade ");
		lblQuantidade.setBounds(25, 228, 104, 14);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo ");
		lblCdigo.setBounds(25, 311, 46, 14);
		
		textField = new JTextField();
		textField.setBounds(68, 308, 109, 20);
		textField.setEditable(false);
		textField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(btVoltar);
		contentPane.add(btnSalvar);
		contentPane.add(lblNomeDoProduto);
		contentPane.add(txtProduto);
		contentPane.add(lblPreoDeCompra);
		contentPane.add(txtCompra);
		contentPane.add(lblR);
		contentPane.add(lblCad);
		contentPane.add(lblDescrio);
		contentPane.add(txtDescriacao);
		contentPane.add(lblPreoDeVenda);
		contentPane.add(label);
		contentPane.add(txtVenda);
		contentPane.add(lblQuantidade);
		contentPane.add(lblCdigo);
		contentPane.add(textField);
		
		textQuantidade = new JTextField();
		textQuantidade.setBounds(91, 225, 86, 20);
		contentPane.add(textQuantidade);
		textQuantidade.setColumns(10);
		
		JButton gerador = new JButton("Gerar C\u00F3digo");
		gerador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(a==0) {
				textField.replaceSelection(Integer.toString(codigo));
				a++;
			}
			}
		});
		gerador.setBounds(68, 279, 109, 23);
		contentPane.add(gerador);
		
		
	}

}