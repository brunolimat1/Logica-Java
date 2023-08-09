package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorios extends JDialog {
	
	//objetos JDBC
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
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
	public Relatorios() {
		setTitle("Relatórios");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
			
		});
		btnClientes.setBounds(104, 115, 89, 23);
		getContentPane().add(btnClientes);
		
		JButton btnServicos = new JButton("Serviços");
		btnServicos.setBounds(242, 115, 89, 23);
		getContentPane().add(btnServicos);

	}//fim do construtor
	
	private void relatorioClientes() {
		//instanciar um objeto para construir a página pdf
		Document document = new Document();
		//configurar como A4 e modo paisagem
		//document.setPageSize(PageSize.A4.rotate());
		//gerar o documento pdf
		try {
			//criar um documento em branco (pdf) de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			//abrir o documento (formatar e inserir o conteúdo)
			document.open();
			//adicionar a data atual
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			//adicionar um páragrafo
			document.add(new Paragraph("Clientes:"));
			document.add(new Paragraph(" ")); //pular uma linha
			//----------------------------------------------------------
			//query (instrução sql para gerar o relatório de clientes)
			String readClientes = "select nome,fone from clientes order by nome";
			try {
				//abrir a conexão com o banco
				con = dao.conectar();
				//preparar a query (executar a instrução sql)
				pst = con.prepareStatement(readClientes);
				//obter o resultado (trazer do banco de dados)
				rs = pst.executeQuery();
				//atenção uso do while para trazer todos os clientes
				// Criar uma tabela de duas colunas usando o framework(itextPDF)
				PdfPTable tabela = new PdfPTable(2); //(2) número de colunas
				// Criar o cabeçalho da tabela
				PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				while (rs.next()) {
					//popular a tabela
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
				}				
				//adicionar a tabela ao documento pdf
				document.add(tabela);
				//fechar a conexão com o banco
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		//fechar o documento (pronto para "impressão" (exibir o pdf))
		document.close();
		//Abrir o desktop do sistema operacional e usar o leitor padrão
		//de pdf para exibir o documento
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
	
}//fim do código
