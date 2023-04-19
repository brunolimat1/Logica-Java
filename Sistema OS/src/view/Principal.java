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
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	private Connection con;
	@SuppressWarnings("unused")
	private PreparedStatement pst;
	@SuppressWarnings("unused")
	private ResultSet rs;

	private JPanel contentPane;
	private JLabel lblStatus;
	private JLabel lblAgenda;
	private JLabel lblData;
	private JLabel lblPrinter;
	private JButton btnRelatorio;
	private JButton btnClient;
	private JButton btnService;

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
		setTitle("Ordem de Serviços");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 410, 624, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
				lblData = new JLabel("");
				lblData.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblData.setHorizontalAlignment(SwingConstants.CENTER);
				lblData.setBounds(424, 5, 162, 24);
				panel.add(lblData);

		lblStatus = new JLabel("");
		lblStatus.setBounds(590, 5, 24, 24);
		lblStatus.setBorder(null);
		panel.add(lblStatus);
		lblStatus.setIcon(new ImageIcon(Principal.class.getResource("/img/databasedesligada.png")));
		
				JButton btnAbout = new JButton("");
				btnAbout.setContentAreaFilled(false);
				btnAbout.setBounds(0, 0, 33, 33);
				panel.add(btnAbout);
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

		JButton btnUsers = new JButton("");
		btnUsers.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnUsers.setToolTipText("Buscar Usuarios");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuario = new Usuarios();
				usuario.setVisible(true);
			}
		});
		btnUsers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsers.setIcon(new ImageIcon(Principal.class.getResource("/img/22193_client_icon.png")));
		btnUsers.setBounds(238, 74, 128, 128);
		contentPane.add(btnUsers);
		
		lblPrinter = new JLabel("");
		lblPrinter.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrinter.setIcon(new ImageIcon(Principal.class.getResource("/img/7309625.png")));
		lblPrinter.setBounds(53, 157, 128, 128);
		contentPane.add(lblPrinter);
		
		btnRelatorio = new JButton("");
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRelatorio.setIcon(new ImageIcon(Principal.class.getResource("/img/34779_clipboard_icon.png")));
		btnRelatorio.setToolTipText("Relatórios");
		btnRelatorio.setBounds(461, 248, 128, 128);
		contentPane.add(btnRelatorio);
		
		btnClient = new JButton("");
		btnClient.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClient.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnClient.setIcon(new ImageIcon(Principal.class.getResource("/img/118828_system_users_icon.png")));
		btnClient.setToolTipText("Buscar Clientes");
		btnClient.setBounds(238, 248, 128, 128);
		contentPane.add(btnClient);
		
		btnService = new JButton("");
		btnService.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnService.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnService.setIcon(new ImageIcon(Principal.class.getResource("/img/60190_maintenance_icon.png")));
		btnService.setToolTipText("Serviço");
		btnService.setBounds(461, 74, 128, 128);
		contentPane.add(btnService);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 0, 654, 31);
		contentPane.add(panel_1);
		
		JLabel lblData_1 = new JLabel("");
		lblData_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblData_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblData_1.setBounds(448, 5, 162, 24);
		panel_1.add(lblData_1);
		
		JLabel lblStatus_1 = new JLabel("");
		lblStatus_1.setBorder(null);
		lblStatus_1.setBounds(620, 5, 24, 24);
		panel_1.add(lblStatus_1);
		
		JButton btnAbout_1 = new JButton("");
		btnAbout_1.setToolTipText("Sobre");
		btnAbout_1.setFocusable(false);
		btnAbout_1.setContentAreaFilled(false);
		btnAbout_1.setBorderPainted(false);
		btnAbout_1.setBounds(0, 0, 33, 33);
		panel_1.add(btnAbout_1);
		
				lblAgenda = new JLabel("3DPrintTechGenius");
				lblAgenda.setBounds(10, 5, 203, 24);
				panel_1.add(lblAgenda);
				lblAgenda.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
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
