import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class tela_consultaProd extends JFrame {

	private JPanel contentPane;
	private JTextField txtfiltro;
	private JTextField textProd;
	private JTextField textCompra;
	private JTextField textVenda;
	private JTextField textDescricao;
	private JTextField textQuantidade;
	private JTextField textcod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela_consultaProd frame = new tela_consultaProd();
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
	public tela_consultaProd() {
		
		estoque cpro = new estoque();	cadastro_produtos cp = new cadastro_produtos();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTA DE PRODUTOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(245, 5, 170, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Digite o Nome ou C\u00F3digo do Produto");
		lblNome.setBounds(10, 78, 211, 14);
		contentPane.add(lblNome);
		
		txtfiltro = new JTextField();
		txtfiltro.setBounds(218, 75, 271, 20);
		contentPane.add(txtfiltro);
		txtfiltro.setColumns(10);
		
		JLabel label = new JLabel("Nome do Produto");
		label.setBounds(25, 148, 104, 14);
		contentPane.add(label);
		
		textProd = new JTextField();
		textProd.setColumns(10);
		textProd.setBounds(25, 171, 371, 20);
		contentPane.add(textProd);
		
		JLabel label_1 = new JLabel("Pre\u00E7o de Compra");
		label_1.setBounds(488, 148, 104, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("R$");
		label_2.setBounds(456, 174, 33, 14);
		contentPane.add(label_2);
		
		textCompra = new JTextField();
		textCompra.setColumns(10);
		textCompra.setBounds(488, 171, 104, 20);
		contentPane.add(textCompra);
		
		JLabel label_3 = new JLabel("Pre\u00E7o de Venda");
		label_3.setBounds(488, 223, 104, 14);
		contentPane.add(label_3);
		
		textVenda = new JTextField();
		textVenda.setColumns(10);
		textVenda.setBounds(488, 246, 104, 20);
		contentPane.add(textVenda);
		
		JLabel label_4 = new JLabel("R$");
		label_4.setBounds(456, 249, 33, 14);
		contentPane.add(label_4);
		
		textDescricao = new JTextField();
		textDescricao.setColumns(10);
		textDescricao.setBounds(25, 246, 371, 20);
		contentPane.add(textDescricao);
		
		JLabel label_5 = new JLabel("DESCRI\u00C7\u00C3O");
		label_5.setBounds(25, 223, 104, 14);
		contentPane.add(label_5);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(91, 304, 86, 20);
		contentPane.add(textQuantidade);
		
		JLabel label_6 = new JLabel("Quantidade ");
		label_6.setBounds(25, 307, 104, 14);
		contentPane.add(label_6);
		
		textcod = new JTextField();
		textcod.setColumns(10);
		textcod.setBounds(68, 387, 109, 20);
		contentPane.add(textcod);
		
		JLabel label_7 = new JLabel("C\u00F3digo ");
		label_7.setBounds(25, 390, 46, 14);
		contentPane.add(label_7);
		
		JButton btnAlterarESalvar = new JButton("Alterar e Salvar");
		btnAlterarESalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textProd.getText().length() > 0 && textCompra.getText().length() > 0 && textVenda.getText().length() > 0 &&
						textcod.getText().length() > 0 && textQuantidade.getText().length() > 0) {
					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
					
					cp.setNomeProduto(textProd.getText());
					cp.setDescricao(textDescricao.getText());
					cp.setPrecoCompra(textCompra.getText());
					cp.setPrecoVenda(textVenda.getText());
					cp.setQuantidade(textQuantidade.getText());
					cp.setCodigo(textcod.getText());
					
					try {
						cp.salvarDados();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Todos os dados são obrigatórios ");
				
				}
			
			}
		});
		btnAlterarESalvar.setBounds(285, 307, 130, 36);
		contentPane.add(btnAlterarESalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btnVoltar.setBounds(456, 307, 130, 36);
		contentPane.add(btnVoltar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtfiltro.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "O nome deve ser informado");
				}
				cpro.setPesquisa(txtfiltro.getText());
				
				try {
					cpro.pesquisar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				textProd.replaceSelection(cpro.getNomeProduto());
				textCompra.replaceSelection(cpro.getPrecoCompra());
				textVenda.replaceSelection(cpro.getPrecoVenda());
				textDescricao.replaceSelection(cpro.getDescricao());
				textQuantidade.replaceSelection(cpro.getQuantidade());
				textcod.replaceSelection(cpro.getCodigo());
				
			}
		});
		
	
		btnPesquisar.setBounds(503, 74, 89, 23);
		contentPane.add(btnPesquisar);
	
		
		
	}
}