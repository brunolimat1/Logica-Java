package br.com.projeto.papelaria.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		setState(MAXIMIZED_BOTH);
		
		setTitle("Gerenciamento da Papelaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 385);
		
		JMenuBar mnuBar = new JMenuBar();
		setJMenuBar(mnuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		mnuBar.add(mnNewMenu);
		
		JMenuItem mnuItemUsuario = new JMenuItem("Usuário");
		mnuItemUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserCadView ucv = new UserCadView();
				ucv.setClosable(true);//Botão Fechar
				ucv.setIconifiable(true);//Botão minimizar
				ucv.setResizable(true);//Botão
				
				ucv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				getContentPane().add(ucv);
				
				ucv.setVisible(true);
			}
		});
		mnNewMenu.add(mnuItemUsuario);
		
		JMenuItem mnuItemCliente = new JMenuItem("Cliente");
		mnuItemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientCadView ccv = new ClientCadView();
				ccv.setClosable(true);//Botão Fechar
				ccv.setIconifiable(true);//Botão minimizar
				add(ccv);				
				ccv.setVisible(true);
			}
		});
		mnNewMenu.add(mnuItemCliente);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Fornecedor");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Funcionário");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Consulta");
		mnuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		contentPane = new JDesktopPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
