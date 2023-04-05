package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import model.DAO;

import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;

public class Principal extends JFrame {
	//Instanciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblAgenda;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("Tela Principal");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 191, 224, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(5, 5, 24, 24);
		lblStatus.setBorder(null);
		panel.add(lblStatus);
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databasedesligada.png")));
		
		lblAgenda = new JLabel("Agenda de Contatos");
		lblAgenda.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblAgenda.setBounds(21, 11, 203, 19);
		contentPane.add(lblAgenda);
		
		JButton btnUsers = new JButton("");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUsers.setFocusable(false);
		btnUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsers.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsers.setBounds(34, 73, 64, 64);
		contentPane.add(btnUsers);
		
		JButton btnAbout = new JButton("");
		btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbout.setFocusable(false);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnAbout.setIcon(new ImageIcon(Principal.class.getResource("/img/about3.png")));
		btnAbout.setBounds(132, 73, 64, 64);
		contentPane.add(btnAbout);
	}
	private void status( ) {
		    try {
		        //abrir a conexão
		        con = dao.conectar();
		        if (con == null) {
		            //System.out.println("Erro de conexão");
		        	lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseDesligada.png")));
		        } else {
		            //System.out.println("Banco conectado");
		        	lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseLigada.png")));
		        }
		    } catch (Exception e) {
		        System.out.println(e);
		    } finally {
		        try {
		            //NUNCA esquecer de fechar a conexão
		            if (con != null) {
		                con.close();
		            }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }
		}// fim do método status()

}
