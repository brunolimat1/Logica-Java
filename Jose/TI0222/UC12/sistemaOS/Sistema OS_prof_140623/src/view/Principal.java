package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import java.awt.Font;

public class Principal extends JFrame {

	// Instaciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblData;

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
		setTitle("InfoX - Sistema OS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/pc.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// evento ativar janela
				status();
				setarData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// abrir tela de usuários
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setBounds(42, 23, 128, 128);
		contentPane.add(btnUsuarios);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 386, 700, 54);
		contentPane.add(panel);
		panel.setLayout(null);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/bdoff.png")));
		lblStatus.setBounds(638, 13, 32, 32);
		panel.add(lblStatus);
		
		lblData = new JLabel("");
		lblData.setBounds(22, 13, 317, 30);
		panel.add(lblData);
		lblData.setForeground(SystemColor.text);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSobre = new JButton("");
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorder(null);
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		btnSobre.setBounds(611, 31, 48, 48);
		contentPane.add(btnSobre);
		
		JButton btnUsuarios_1 = new JButton("");
		btnUsuarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnUsuarios_1.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		btnUsuarios_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios_1.setToolTipText("Clientes");
		btnUsuarios_1.setBounds(202, 23, 128, 128);
		contentPane.add(btnUsuarios_1);
		
		JButton btnUsuarios_2 = new JButton("");
		btnUsuarios_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicos servicos = new Servicos();
				servicos.setVisible(true);
			}
		});
		btnUsuarios_2.setIcon(new ImageIcon(Principal.class.getResource("/img/os.png")));
		btnUsuarios_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios_2.setToolTipText("Ordem de Serviço");
		btnUsuarios_2.setBounds(42, 175, 128, 128);
		contentPane.add(btnUsuarios_2);
		
		JButton btnUsuarios_3 = new JButton("");
		btnUsuarios_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnUsuarios_3.setIcon(new ImageIcon(Principal.class.getResource("/img/report.png")));
		btnUsuarios_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios_3.setToolTipText("Relatórios");
		btnUsuarios_3.setBounds(361, 175, 128, 128);
		contentPane.add(btnUsuarios_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/x.png")));
		lblNewLabel.setBounds(519, 204, 181, 181);
		contentPane.add(lblNewLabel);
		
		JButton btnFornecedores = new JButton("");
		btnFornecedores.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedores.png")));
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setBounds(361, 23, 128, 128);
		contentPane.add(btnFornecedores);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.setIcon(new ImageIcon(Principal.class.getResource("/img/produtos.png")));
		btnProdutos.setToolTipText("Clientes");
		btnProdutos.setBounds(202, 175, 128, 128);
		contentPane.add(btnProdutos);
	}// fim do construtor

	/**
	 * Método responsável por exibir o status da conexão
	 */
	private void status() {
		try {
			// abrir a conexão
			con = dao.conectar();
			if (con == null) {
				// System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/bdoff.png")));
			} else {
				// System.out.println("Banco conectado");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/bdon.png")));
			}
			// NUNCA esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método status()
	
	/**
	 * Método responsável por setar a data no rodapé
	 */
	private void setarData() {
		// criar objeto para trazer a data do sistema
		Date data = new Date();
		// criar objeto para formatar a data
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		// alterar o texto da label pela data atual formatada
		lblData.setText(formatador.format(data));
	}
}// fim do código
