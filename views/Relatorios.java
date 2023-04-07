package views;

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
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.DAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Relatorios.
 */
public class Relatorios extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * The main method.
	 *
	 * @param args the arguments
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
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Relatorios.class.getResource("/img/1622837_analytics_docs_documents_graph_pdf_icon (1).png")));
		setTitle("Relatórios");
		setBounds(100, 100, 640, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Relatórios de Clientes");
		btnNewButton.setIcon(new ImageIcon(
				Relatorios.class.getResource("/img/7632703_presentation_business_office_chart_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relClientes();
			}
		});
		btnNewButton.setBounds(50, 78, 128, 128);
		getContentPane().add(btnNewButton);

		JButton btnRelatoriosPendentes = new JButton("");
		btnRelatoriosPendentes.setBorderPainted(false);
		btnRelatoriosPendentes.setContentAreaFilled(false);
		btnRelatoriosPendentes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatoriosPendentes.setToolTipText("Aguardando  aprovação");
		btnRelatoriosPendentes.setIcon(new ImageIcon(Relatorios.class.getResource("/img/report waiting.png")));
		btnRelatoriosPendentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relPendentes();
			}
		});
		btnRelatoriosPendentes.setBounds(236, 78, 128, 128);
		getContentPane().add(btnRelatoriosPendentes);

		JButton btnRelatoriosEntregues = new JButton("");
		btnRelatoriosEntregues.setBorderPainted(false);
		btnRelatoriosEntregues.setContentAreaFilled(false);
		btnRelatoriosEntregues.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatoriosEntregues.setToolTipText("Relatorios Entregues");
		btnRelatoriosEntregues.setIcon(new ImageIcon(Relatorios.class.getResource("/img/entregue.png")));
		btnRelatoriosEntregues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relEntregues();
			}
		});
		btnRelatoriosEntregues.setBounds(431, 78, 128, 128);
		getContentPane().add(btnRelatoriosEntregues);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Relatorios.class.getResource("/img/icon120x120.png")));
		lblNewLabel.setBounds(244, 457, 120, 120);
		getContentPane().add(lblNewLabel);

		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBackground(new Color(32, 178, 170));
		panelUsuarios.setBounds(0, 541, 624, 20);
		getContentPane().add(panelUsuarios);

		JPanel panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1.setBounds(-14, 0, 638, 20);
		getContentPane().add(panelUsuarios_1);

		btnMecanico = new JButton("");
		btnMecanico.setBorderPainted(false);
		btnMecanico.setContentAreaFilled(false);
		btnMecanico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMecanico.setToolTipText("Aguardando mêcanico");
		btnMecanico.setIcon(new ImageIcon(Relatorios.class.getResource("/img/reportmec.png")));
		btnMecanico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relPenMecanico();
			}
		});
		btnMecanico.setBounds(50, 275, 128, 128);
		getContentPane().add(btnMecanico);

		JButton btnRetirada = new JButton("");
		btnRetirada.setBorderPainted(false);
		btnRetirada.setContentAreaFilled(false);
		btnRetirada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRetirada.setToolTipText("Aguardando retirada de  veículo");
		btnRetirada.setIcon(new ImageIcon(Relatorios.class.getResource("/img/reportpen.png")));
		btnRetirada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relVeic();
			}
		});
		btnRetirada.setBounds(236, 275, 128, 128);
		getContentPane().add(btnRetirada);

		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.setToolTipText("Aguardando peças");
		btnNewButton_1_1_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/penpecas.png")));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relPenPecas();
			}
		});
		btnNewButton_1_1_1.setBounds(431, 275, 128, 128);
		getContentPane().add(btnNewButton_1_1_1);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Relatorios.class.getResource("/img/relatorios2.png")));
		lblNewLabel_1.setBounds(-14, -50, 640, 600);
		getContentPane().add(lblNewLabel_1);

	}

	/** The dao. */
	DAO dao = new DAO();
	
	/** The lbl new label 1. */
	private JLabel lblNewLabel_1;
	
	/** The btn mecanico. */
	private JButton btnMecanico;

	/**
	 * Rel pendentes.
	 */
	private void relPendentes() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("relpendentes.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Serviços aguardando aprovação "));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(6);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Mêcanico"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Placa"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Marca"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Modelo"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);

			String relPendentes = "select tbos.os as OS, tbos.mecanico, tbclientes.nome as Cliente, tbos.placa as Placa, tbos.marca as Marca, tbos.modelo as Modelo from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Aguardando aprovação'";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relPendentes);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("relpendentes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Rel pen mecanico.
	 */
	private void relPenMecanico() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("relpendentesmecanico.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Serviços aguardando mêcanico "));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Placa"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Marca"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Modelo"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			String relMecanico = "select tbos.os as OS,  tbclientes.nome as Cliente, tbos.placa as Placa, tbos.marca as Marca, tbos.modelo as Modelo from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Aguardando mêcanico'";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relMecanico);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("relpendentesmecanico.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Rel pen pecas.
	 */
	private void relPenPecas() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("relpecas.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Serviços aguardando peças "));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(6);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Mêcanico"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Placa"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Marca"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Modelo"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);

			String relPecas = "select tbos.os as OS, tbos.mecanico, tbclientes.nome as Cliente, tbos.placa as Placa, tbos.marca as Marca, tbos.modelo as Modelo from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Aguardando peças'";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relPecas);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("relpecas.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Rel entregues.
	 */
	private void relEntregues() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("relentregues.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Serviços entregues "));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(7);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Mêcanico"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Placa"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Marca"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Modelo"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Data de Saída"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);

			String relPendentes = "select tbos.os as OS, tbos.mecanico, tbclientes.nome as Cliente, tbos.placa as Placa, tbos.marca as Marca, tbos.modelo as Modelo, tbos.data_saida from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Entregue ao cliente'";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relPendentes);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
					tabela.addCell(rs.getString(7));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("relentregues.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Rel veic.
	 */
	private void relVeic() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("relretiradaveiculo.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Serviços aguardando retirada do veículo "));
			document.add(new Paragraph(" "));
			PdfPTable tabela = new PdfPTable(6);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Mêcanico"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Placa"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Marca"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Modelo"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);

			String relVeic = "select tbos.os as OS, tbos.mecanico, tbclientes.nome as Cliente, tbos.placa as Placa , tbos.marca as Marca, tbos.modelo as Modelo from tbos inner join tbclientes on tbos.id= tbclientes.id where status_os = 'Aguardando retirada de veículo'";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relVeic);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("relretiradaveiculo.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Rel clientes.
	 */
	private void relClientes() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("relclientes.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Clientes "));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Email"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Contato"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			String relPendentes = "select tbclientes.nome , tbclientes.email, tbclientes.fone from tbclientes";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relPendentes);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("relclientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

