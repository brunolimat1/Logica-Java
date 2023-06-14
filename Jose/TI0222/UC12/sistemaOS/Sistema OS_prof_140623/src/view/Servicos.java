package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Servicos extends JDialog {
	
	//instanciar objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOS;
	private JTextField txtData;
	private JTextField txtEquipamento;
	private JTextField txtDefeito;
	private JTextField txtValor;
	private JTextField txtID;
	private JTextField txtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servicos dialog = new Servicos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Servicos() {
		setTitle("Serviços");
		setModal(true);
		setBounds(100, 100, 686, 409);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OS");
		lblNewLabel.setBounds(31, 37, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtOS = new JTextField();
		txtOS.setEditable(false);
		txtOS.setBounds(66, 34, 86, 20);
		getContentPane().add(txtOS);
		txtOS.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Data");
		lblNewLabel_1.setBounds(31, 87, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(85, 84, 167, 20);
		getContentPane().add(txtData);
		txtData.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Equipamento");
		lblNewLabel_2.setBounds(31, 138, 77, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtEquipamento = new JTextField();
		txtEquipamento.setBounds(125, 135, 488, 20);
		getContentPane().add(txtEquipamento);
		txtEquipamento.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Defeito");
		lblNewLabel_3.setBounds(31, 190, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtDefeito = new JTextField();
		txtDefeito.setBounds(106, 187, 507, 20);
		getContentPane().add(txtDefeito);
		txtDefeito.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Valor");
		lblNewLabel_4.setBounds(31, 246, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtValor = new JTextField();
		txtValor.setBounds(92, 243, 204, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(42, 312, 89, 23);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(163, 312, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(284, 312, 89, 23);
		getContentPane().add(btnExcluir);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(175, 33, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(551, 312, 89, 23);
		getContentPane().add(btnLimpar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(332, 11, 251, 113);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(10, 28, 180, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(44, 69, 63, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		JLabel ID = new JLabel("ID");
		ID.setBounds(10, 72, 24, 14);
		panel.add(ID);
		
		JButton btnOS = new JButton("OS");
		btnOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirOS();
			}
		});
		btnOS.setBounds(402, 312, 89, 23);
		getContentPane().add(btnOS);

	}//fim do construtor
	
	private void limpar() {
		txtOS.setText(null);
		txtData.setText(null);
		txtEquipamento.setText(null);
		txtDefeito.setText(null);
		txtID.setText(null);
		txtValor.setText(null);
	}
	
	private void buscar() {
		//captura do número da OS (sem usar a caixa de texto)
		String numOS = JOptionPane.showInputDialog("Número da OS ");
		
		String read = "select * from servicos where os = ?";
		try {
			//abrir a conexão
			con = dao.conectar();
			//preparar a query
			pst = con.prepareStatement(read);
			//substituir a ? (parâmetro) pelo número da OS
			pst.setString(1, numOS);
			rs = pst.executeQuery();
			if (rs.next()) {				
				txtOS.setText(rs.getString(1));
				txtData.setText(rs.getString(2));
				txtEquipamento.setText(rs.getString(3));
				txtDefeito.setText(rs.getString(4));
				txtValor.setText(rs.getString(5));
				txtID.setText(rs.getString(6));
			} else {
				JOptionPane.showMessageDialog(null, "OS inexistente");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Impressão da OS
	 */
	private void imprimirOS() {
		// instanciar objeto para usar os métodos da biblioteca
		Document document = new Document();
		// documento pdf
		try {
			// criar um documento em branco (pdf) de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("os.pdf"));
			// abrir o documento (formatar e inserir o conteúdo)
			document.open();
			String readOS = "select * from servicos where os = ?";
			// conexão com o banco
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar a execução da query (instrução sql)
				pst = con.prepareStatement(readOS);
				pst.setString(1, txtOS.getText());
				// executar a query
				rs = pst.executeQuery();
				// se existir a OS
				if (rs.next()) {					
					//document.add(new Paragraph("OS: " + rs.getString(1)));
					Paragraph os = new Paragraph ("OS: " + rs.getString(1));
					os.setAlignment(Element.ALIGN_RIGHT);
					document.add(os);					
						
					Paragraph equipamento = new Paragraph ("Equipamento: " + rs.getString(3));
					equipamento.setAlignment(Element.ALIGN_LEFT);
					document.add(equipamento);
					
					Paragraph defeito = new Paragraph ("Defeito: " + rs.getString(4));
					defeito.setAlignment(Element.ALIGN_LEFT);
					document.add(defeito);
				
					//imprimir imagens
					Image imagem = Image.getInstance(Servicos.class.getResource("/img/os.png"));
					//resolução da imagem
					imagem.scaleToFit(128,128);
					//(x,y) (referência: canto inferior esquerdo)
					imagem.setAbsolutePosition(20, 20);
					document.add(imagem);					
				}
				// fechar a conexão com o banco
				con.close();
				} catch (Exception e) {
					System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// fechar o documento (pronto para "impressão" (exibir o pdf))
		document.close();
		// Abrir o desktop do sistema operacional e usar o leitor padrão
		// de pdf para exibir o documento
		try {
			Desktop.getDesktop().open(new File("os.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}//fim do código
