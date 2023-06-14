package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import javax.swing.SwingConstants;

public class Principal extends JFrame {
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblAgenda;
	private JLabel lblData;
	private JLabel lblNewLabel;

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

	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				setarData();
			}
		});
		setTitle("Tela Principal");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 207, 432, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
				lblData = new JLabel("");
				lblData.setHorizontalAlignment(SwingConstants.CENTER);
				lblData.setBounds(55, 5, 191, 24);
				panel.add(lblData);

		lblStatus = new JLabel("");
		lblStatus.setBounds(5, 5, 24, 24);
		lblStatus.setBorder(null);
		panel.add(lblStatus);
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databasedesligada.png")));

		lblAgenda = new JLabel("Agenda de Contatos");
		lblAgenda.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblAgenda.setBounds(35, 11, 203, 19);
		contentPane.add(lblAgenda);

		JButton btnUsers = new JButton("");
		btnUsers.setBorderPainted(false);
		btnUsers.setToolTipText("Buscar Usuarios");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuario = new Usuarios();
				usuario.setVisible(true);
			}
		});
		btnUsers.setFocusable(false);
		btnUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsers.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsers.setBounds(10, 91, 91, 78);
		contentPane.add(btnUsers);

		JButton btnAbout = new JButton("");
		btnAbout.setBorderPainted(false);
		btnAbout.setToolTipText("Sobre");
		btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbout.setFocusable(false);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnAbout.setIcon(new ImageIcon(Principal.class.getResource("/img/about3.png")));
		btnAbout.setBounds(152, 91, 91, 78);
		contentPane.add(btnAbout);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/pc.png")));
		lblNewLabel.setBounds(112, 41, 32, 39);
		contentPane.add(lblNewLabel);
	}

	private void status() {
		try {
			con = dao.conectar();
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseDesligada.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databaseLigada.png")));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void setarData() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}

}
