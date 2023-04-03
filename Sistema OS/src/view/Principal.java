package view;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {
	DAO dao = new DAO();
	private Connection con;


	private JLabel lblStatus;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		status();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseoff.png")));
		lblStatus.setBounds(10, 268, 64, 64);
		contentPane.add(lblStatus);
		
		JLabel lblAbout = new JLabel("");
		lblAbout.setIcon(new ImageIcon(Principal.class.getResource("/img/aboutnew.png")));
		lblAbout.setBounds(426, 268, 64, 64);
		contentPane.add(lblAbout);
	}



/**
 * Método responsável por exibir o status da conexão
 */
	private void status( ) {
		try {
			//abrir a conexão
			con = dao.conectar();
			if (con == null) {
				//System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseoff.png")));
			} else {
				//System.out.println("Banco conectado");
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseon.png")));
			}
			//NUNCA esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}// fim do método status()
