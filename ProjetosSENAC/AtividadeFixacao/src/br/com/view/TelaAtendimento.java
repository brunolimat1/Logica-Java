package br.com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.dao.CRUDChamado;
import br.com.dominio.Chamado;

public class TelaAtendimento extends JDialog {
	CRUDChamado cc = new CRUDChamado();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtStatus;
	private JTextField txtResponsavel;
	private JTextArea txtObservacoes;
	private JFormattedTextField txtDataResolucao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaAtendimento dialog = new TelaAtendimento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaAtendimento() {
		setTitle("Sistema de Suporte - Atendente");
		setBounds(100, 100, 675, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("ID do Chamado:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(245, 38, 111, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtID = new JTextField();
			txtID.setColumns(10);
			txtID.setBounds(200, 63, 208, 25);
			contentPanel.add(txtID);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Status Chamado:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(472, 38, 123, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtStatus = new JTextField();
			txtStatus.setColumns(10);
			txtStatus.setBounds(430, 63, 208, 25);
			contentPanel.add(txtStatus);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Data de resolução do Chamado:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(200, 126, 233, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtResponsavel = new JTextField();
			txtResponsavel.setColumns(10);
			txtResponsavel.setBounds(430, 158, 208, 23);
			contentPanel.add(txtResponsavel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Responsável do Chamado:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(446, 128, 192, 19);
			contentPanel.add(lblNewLabel_1);
		}

		MaskFormatter dateR = null;
		try {	dateR = new MaskFormatter("####-##-##"); }
		catch(Exception e) { e.printStackTrace();}
		
		txtDataResolucao = new JFormattedTextField(dateR);
		txtDataResolucao.setBounds(200, 158, 208, 23);
		contentPanel.add(txtDataResolucao);

		JLabel lblNewLabel_1 = new JLabel("Observações:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(368, 211, 90, 19);
		contentPanel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(202, 236, 436, 244);
		contentPanel.add(scrollPane);

		txtObservacoes = new JTextArea();
		scrollPane.setViewportView(txtObservacoes);

		JLabel lblAtualizar = new JLabel("Atualizar Chamados");
		lblAtualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAtualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Atualizar();
			}
		});
		lblAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAtualizar.setBounds(26, 288, 149, 19);
		contentPanel.add(lblAtualizar);

		JLabel lblExcluir = new JLabel("Excluir Chamados");
		lblExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Excluir();
			}
		});
		lblExcluir.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExcluir.setBounds(33, 335, 137, 19);
		contentPanel.add(lblExcluir);
	}

	private void Atualizar() {
		Chamado cr = new Chamado();

		if (txtResponsavel.getText().trim().equals("") || txtStatus.getText().trim().equals("")
				|| txtID.getText().trim().equals("") || txtDataResolucao.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null,
					"Os campos Id do Chamado, Status do Chamado, Data de Resolução e Responsável do Chamado devem ser preenchidos",
					"Erro 4000765x", JOptionPane.ERROR_MESSAGE);
		} else {

			cr.setDataResolucao(Date.valueOf(txtDataResolucao.getText()));
			cr.setStatusChamado(txtStatus.getText());
			cr.setAtendente(txtResponsavel.getText());
			cr.setObservacoes(txtObservacoes.getText());
			cr.setIdChamado(Long.parseLong(txtID.getText()));
			JOptionPane.showMessageDialog(null, cc.atualizar(cr));
		}

	}

	private void Excluir() {

		if (txtID.equals(null)) {
			JOptionPane.showMessageDialog(null, "Selecione o chamado a ser excluído.", "Erro 4000770x",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (JOptionPane.showConfirmDialog(null,
					"Você tem certeza desta ação? \nEstá ação é permanente " + "e não pode ser desfeita", "ATENÇÃO",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
				Chamado cr = new Chamado();
				cr.setIdChamado(Long.parseLong(txtID.getText()));
				JOptionPane.showConfirmDialog(null, cc.apagar(cr));
			}

		}
	}
}
