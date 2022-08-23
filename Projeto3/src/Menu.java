package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	tela_produto tp = new tela_produto();
	
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lucas\\OneDrive\\Imagens\\name.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Principal");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Caixa");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mnNewMenu.add(mntmEstoque);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin frame = new TelaLogin();
				frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLogin);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					tela_clientes frame = new tela_clientes();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		mnCadastrar.add(mntmClientes);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tp.setVisible(true);
				
			}
		});
		mnCadastrar.add(mntmProdutos);
		
		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					consulta_cadastro_cliente frame = new consulta_cadastro_cliente();
					frame.setVisible(true);
				} catch (Exception a) {
					a.printStackTrace();
				}
				
			}
		});
		mnConsultar.add(mntmCliente_1);
		
		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela_consultaProd frame = new tela_consultaProd();
				frame.setVisible(true);
			}
		});
		mnConsultar.add(mntmProduto);
		
		JMenu mnNewMenu_1 = new JMenu("Alterar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mnNewMenu_1.add(mntmCliente);
		
		JMenuItem mntmProuto = new JMenuItem("Prouto");
		mnNewMenu_1.add(mntmProuto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}