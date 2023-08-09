package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class Agenda extends JFrame {
	//Instanciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//ativação da janela
				status();
			}
		});
		setResizable(false);
		setTitle("Agenda de contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/notebook.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(41, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(74, 37, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(41, 91, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(101, 88, 303, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setBounds(41, 143, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtFone = new JTextField();
		txtFone.setBounds(101, 140, 174, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(41, 199, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(101, 196, 303, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnAdicionar.setBorder(null);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setToolTipText("Adicionar contato");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setIcon(new ImageIcon(Agenda.class.getResource("/img/adicionar.png")));
		btnAdicionar.setBounds(46, 247, 64, 64);
		contentPane.add(btnAdicionar);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Agenda.class.getResource("/img/editar.png")));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setToolTipText("Editar contato");
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorder(null);
		btnEditar.setBounds(118, 247, 64, 64);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(Agenda.class.getResource("/img/excluir.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setToolTipText("Excluir contato");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorder(null);
		btnExcluir.setBounds(190, 247, 64, 64);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Agenda.class.getResource("/img/eraser.png")));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar campos");
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorder(null);
		btnLimpar.setBounds(264, 247, 64, 64);
		contentPane.add(btnLimpar);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				buscar();
			}
		});
		btnPesquisar.setIcon(new ImageIcon(Agenda.class.getResource("/img/pesquisar.png")));
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorder(null);
		btnPesquisar.setBounds(420, 82, 32, 32);
		contentPane.add(btnPesquisar);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(509, 281, 48, 48);
		contentPane.add(lblStatus);
		
		// substituir o click pela tecla <ENTER> em um botão
		getRootPane().setDefaultButton(btnPesquisar);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clicar no botão sobre
				//mostrar a janela sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorder(null);
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Agenda.class.getResource("/img/about.png")));
		btnSobre.setBounds(509, 22, 48, 48);
		contentPane.add(btnSobre);
		
	}// FIM DO CONSTRUTOR
	
	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
	}//fim do método limparCampos()
	
	/**
	 * Método responsável por exibir o status da conexão
	 */
	private void status() {
		try {
			//abrir a conexão
			con = dao.conectar();
			if (con == null) {
				//System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				//System.out.println("Banco conectado");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
			}
			//NUNCA esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método status()
	
	/**
	 * Método para buscar um contato pelo nome
	 */
	private void buscar() {
		//dica - testar o evento primeiro
		//System.out.println("teste do botão buscar");
		
		// Criar uma variável com a query (instrução do banco)
		String read = "select * from contatos where nome = ?";
		//tratamento de exceções
		try {
			//abrir a conexão
			con = dao.conectar();
			//preparar a execução da query(instrução sql - CRUD Read)
			// O parâmetro 1 substitui a ? pelo conteúdo da caixa de texto
			pst = con.prepareStatement(read);
			pst.setString(1, txtNome.getText());
			// executar a query e buscar o resultado
			rs = pst.executeQuery();
			// uso da estrura if else para verificar se existe o contato
			// rs.next() -> se existir um contato no banco
			if (rs.next()) {
				//preencher as caixas de texto com as informações
				txtID.setText(rs.getString(1)); //1º campo da tabela ID
				txtFone.setText(rs.getString(3)); //3º campo (Fone)
				txtEmail.setText(rs.getString(4)); //4º campo (Email)
			} else {
				//se não existir um contato no banco
				JOptionPane.showMessageDialog(null, "Contato inexistente");
			}
			// fechar a conexão (IMPORTANTE!)
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método buscar
	
	/**
	 * Método para dicionar um novo contato
	 */
	private void adicionar() {
		//System.out.println("teste");
		//validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o nome do contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Prencha o fone do contato");
			txtFone.requestFocus();
		} else {
			//lógica principal
			//CRUD Create
			String create = "insert into contatos(nome,fone,email) values (?,?,?)";
			//tratamento de exceções
			try {
				//abrir a conexão
				con = dao.conectar();
				//preparar a execução da query(instrução sql - CRUD Create)
				pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				//executa a query(instrução sql (CRUD - Create))
				pst.executeUpdate();
				//confirmar
				JOptionPane.showMessageDialog(null, "Contato adicionado");
				//limpar os campos
				limparCampos();
				//fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}			
		}
	}// fim do método adicionar
	
}// FIM DO CÓDIGO
