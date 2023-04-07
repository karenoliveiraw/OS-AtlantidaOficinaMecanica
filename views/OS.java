package views;

import java.awt.EventQueue;
import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.DAO;
import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class OS.
 */
public class OS extends JDialog {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The txt os. */
	private JTextField txtOs;
	
	/** The txt placa. */
	private JTextField txtPlaca;
	
	/** The txt marca. */
	private JTextField txtMarca;
	
	/** The txt modelo. */
	private JTextField txtModelo;
	
	/** The txt cor. */
	private JTextField txtCor;
	
	/** The txt ano. */
	private JTextField txtAno;
	
	/** The txt km. */
	private JTextField txtKm;
	
	/** The txt defeito. */
	private JTextField txtDefeito;
	
	/** The txt data saida. */
	private JTextField txtDataSaida;
	
	/** The txt mecanico. */
	private JTextField txtMecanico;
	
	/** The txt valor. */
	private JTextField txtValor;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OS dialog = new OS();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public OS() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
		getContentPane().setBackground(new Color(255, 255, 255));
		setResizable(false);
		setModal(true);
		setTitle("Ordem de Serviço");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OS.class.getResource("/img/icon120x120.png")));
		setBounds(100, 100, 700, 800);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("N° OS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(SystemColor.infoText);
		lblNewLabel.setBounds(63, 81, 46, 14);
		getContentPane().add(lblNewLabel);

		txtOs = new JTextField();
		txtOs.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarOsReleased();
			}
		});
		txtOs.setColumns(10);
		txtOs.setBounds(102, 78, 137, 20);
		getContentPane().add(txtOs);

		btnCreate = new JButton("");
		btnCreate.setBorderPainted(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setToolTipText("Adicionar uma ordem de serviço");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setIcon(new ImageIcon(OS.class.getResource("/img/add.png")));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar();
			}
		});
		btnCreate.setBounds(128, 665, 64, 64);
		getContentPane().add(btnCreate);

		btnDelete = new JButton("");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteOs();
			}
		});
		btnDelete.setIcon(new ImageIcon(OS.class.getResource("/img/delete.png")));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Deletar uma ordem de serviço");
		btnDelete.setBounds(271, 666, 64, 64);
		getContentPane().add(btnDelete);

		JLabel lblNewLabel_12 = new JLabel("Data");
		lblNewLabel_12.setForeground(SystemColor.infoText);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setBounds(249, 45, 63, 14);
		getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Descrição do veículo:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setForeground(SystemColor.infoText);
		lblNewLabel_13.setBounds(118, 272, 156, 14);
		getContentPane().add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Placa");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setForeground(SystemColor.infoText);
		lblNewLabel_14.setBounds(128, 297, 35, 14);
		getContentPane().add(lblNewLabel_14);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(161, 291, 78, 20);
		getContentPane().add(txtPlaca);
		txtPlaca.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Marca");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setForeground(SystemColor.infoText);
		lblNewLabel_15.setBounds(249, 297, 43, 14);
		getContentPane().add(lblNewLabel_15);

		txtMarca = new JTextField();
		txtMarca.setBounds(289, 291, 73, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Modelo");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_16.setForeground(SystemColor.infoText);
		lblNewLabel_16.setBounds(369, 297, 46, 14);
		getContentPane().add(lblNewLabel_16);

		txtModelo = new JTextField();
		txtModelo.setBounds(415, 291, 80, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Cor");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_17.setForeground(SystemColor.infoText);
		lblNewLabel_17.setBounds(128, 335, 34, 14);
		getContentPane().add(lblNewLabel_17);

		txtCor = new JTextField();
		txtCor.setBounds(161, 332, 78, 20);
		getContentPane().add(txtCor);
		txtCor.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("Ano");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_18.setForeground(SystemColor.infoText);
		lblNewLabel_18.setBounds(249, 335, 25, 14);
		getContentPane().add(lblNewLabel_18);

		txtAno = new JTextField();
		txtAno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtAno.setBounds(289, 332, 73, 20);
		getContentPane().add(txtAno);
		txtAno.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("Km");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_19.setForeground(SystemColor.infoText);
		lblNewLabel_19.setBounds(379, 335, 31, 14);
		getContentPane().add(lblNewLabel_19);

		txtKm = new JTextField();
		txtKm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtKm.setBounds(415, 332, 80, 20);
		getContentPane().add(txtKm);
		txtKm.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Defeito:");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_20.setForeground(SystemColor.infoText);
		lblNewLabel_20.setBounds(115, 386, 80, 14);
		getContentPane().add(lblNewLabel_20);

		txtDefeito = new JTextField();
		txtDefeito.setBounds(161, 363, 333, 60);
		getContentPane().add(txtDefeito);
		txtDefeito.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("Data de Saída");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_21.setForeground(SystemColor.infoText);
		lblNewLabel_21.setBounds(174, 610, 84, 14);
		getContentPane().add(lblNewLabel_21);

		txtDataSaida = new JTextField();
		txtDataSaida.setEditable(false);
		txtDataSaida.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789/";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtDataSaida.setBounds(258, 607, 169, 20);
		getContentPane().add(txtDataSaida);
		txtDataSaida.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Pagamento");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_22.setForeground(SystemColor.infoText);
		lblNewLabel_22.setBounds(272, 568, 138, 14);
		getContentPane().add(lblNewLabel_22);

		JLabel lblNewLabel_23 = new JLabel("Mecânico");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_23.setForeground(SystemColor.infoText);
		lblNewLabel_23.setBounds(102, 528, 64, 14);
		getContentPane().add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("Status:");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_24.setForeground(SystemColor.infoText);
		lblNewLabel_24.setBounds(272, 528, 73, 14);
		getContentPane().add(lblNewLabel_24);

		txtMecanico = new JTextField();
		txtMecanico.setBounds(162, 525, 102, 20);
		getContentPane().add(txtMecanico);
		txtMecanico.setColumns(10);

		cboPagamento = new JComboBox<Object>();
		cboPagamento.setBackground(new Color(248, 248, 255));
		cboPagamento.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "Pix", "Dinheiro", "Crédito", "Débito", "Boleto Bancário" }));
		cboPagamento.setBounds(340, 564, 133, 22);
		getContentPane().add(cboPagamento);

		JLabel lblNewLabel_25 = new JLabel("Valor");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_25.setForeground(SystemColor.infoText);
		lblNewLabel_25.setBounds(128, 568, 35, 14);
		getContentPane().add(lblNewLabel_25);

		txtValor = new JTextField();
		txtValor.setText("0.00");
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		txtValor.setBounds(162, 565, 78, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarOs();
			}
		});
		btnPesquisar.setToolTipText("Pesquisar uma ordem de serviço");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setIcon(new ImageIcon(OS.class.getResource("/img/search 28x28.png")));
		btnPesquisar.setBounds(244, 73, 28, 28);
		getContentPane().add(btnPesquisar);

		cboStatus = new JComboBox<Object>();
		cboStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				if (cboStatus.getSelectedItem().equals("Entregue ao cliente")) {
					txtDataSaida.setText(formatador.format(data));
				} else {
					txtDataSaida.setText(null);
				}

			}
		});
		cboStatus.setBackground(new Color(248, 248, 255));
		cboStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Aguardando aprovação", "Aguardando mêcanico",
				"Aguardando retirada de veículo", "Aguardando peças", "Entregue ao cliente" }));
		cboStatus.setBounds(326, 524, 169, 22);
		getContentPane().add(cboStatus);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setForeground(SystemColor.infoText);
		lblCliente.setBounds(394, 78, 64, 14);
		getContentPane().add(lblCliente);

		txtPesquisarCliente = new JTextArea();
		txtPesquisarCliente.addMouseListener(new MouseAdapter() {

		});
		txtPesquisarCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarCliente();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "abcdefghijklmnopqrstuvwxyz";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}

			}
		});
		txtPesquisarCliente.setBounds(436, 73, 137, 20);
		getContentPane().add(txtPesquisarCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarIdCli();
			}
		});
		scrollPane.setBounds(389, 106, 270, 105);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarIdCli();

			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(SystemColor.infoText);
		lblNewLabel_1.setBounds(588, 78, 25, 14);
		getContentPane().add(lblNewLabel_1);

		txtIdCli = new JTextField();
		txtIdCli.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtIdCli.setEditable(false);
		txtIdCli.setBounds(613, 75, 46, 20);
		getContentPane().add(txtIdCli);
		txtIdCli.setColumns(10);

		dateEntrada = new JDateChooser();
		dateEntrada.setEnabled(false);
		dateEntrada.setBounds(280, 42, 133, 20);
		getContentPane().add(dateEntrada);

		btnUpdate = new JButton("");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setToolTipText("Atualizar uma ordem de serviço");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(OS.class.getResource("/img/update.png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateOs();
			}
		});
		btnUpdate.setBounds(197, 665, 64, 64);
		getContentPane().add(btnUpdate);

		RestrictedTextField validarMarca = new RestrictedTextField(txtMarca);
		validarMarca.setOnlyText(true);
		validarMarca.setLimit(15);
		RestrictedTextField validarModelo = new RestrictedTextField(txtModelo);
		validarModelo.setLimit(15);

		RestrictedTextField validarCor = new RestrictedTextField(txtCor);
		validarCor.setLimit(15);
		validarCor.setOnlyText(true);

		RestrictedTextField placa = new RestrictedTextField(txtPlaca);
		placa.setLimit(7);

		RestrictedTextField ano = new RestrictedTextField(txtAno);
		ano.setLimit(4);

		RestrictedTextField valor = new RestrictedTextField(txtValor);
		valor.setLimit(5);

		RestrictedTextField km = new RestrictedTextField(txtKm);
		km.setLimit(6);

		RestrictedTextField validarMecanico = new RestrictedTextField(txtMecanico);
		validarMecanico.setOnlyText(true);
		validarMecanico.setAcceptSpace(true);
		validarMecanico.setLimit(30);

		btnImprimirOs = new JButton("");
		btnImprimirOs.setContentAreaFilled(false);
		btnImprimirOs.setBorderPainted(false);
		btnImprimirOs.setToolTipText("Imprimir uma ordem de serviço");
		btnImprimirOs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnImprimirOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirOs();
			}
		});
		btnImprimirOs.setIcon(new ImageIcon(OS.class.getResource("/img/impressora64x64.png")));
		btnImprimirOs.setBounds(345, 665, 64, 64);
		getContentPane().add(btnImprimirOs);

		scrollPaneOs = new JScrollPane();
		scrollPaneOs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarOs();
			}
		});
		scrollPaneOs.setBounds(52, 106, 270, 105);
		getContentPane().add(scrollPaneOs);

		tableOs = new JTable();
		tableOs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarOs();
			}
		});
		scrollPaneOs.setViewportView(tableOs);

		JLabel lblNewLabel_20_1 = new JLabel("Serviço");
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_20_1.setForeground(SystemColor.infoText);
		lblNewLabel_20_1.setBounds(115, 462, 80, 14);
		getContentPane().add(lblNewLabel_20_1);

		txtServico = new JTextField();
		txtServico.setColumns(10);
		txtServico.setBounds(160, 439, 333, 60);
		getContentPane().add(txtServico);

		cboOrcamento = new JComboBox<Object>();
		cboOrcamento.setModel(new DefaultComboBoxModel(new String[] { "Orçamento", "Ordem de serviço" }));
		cboOrcamento.setBackground(new Color(255, 255, 255));
		cboOrcamento.setBounds(259, 233, 149, 22);
		getContentPane().add(cboOrcamento);

		JLabel lblOs = new JLabel("OS:");
		lblOs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOs.setForeground(SystemColor.infoText);
		lblOs.setBounds(222, 237, 46, 14);
		getContentPane().add(lblOs);

		txtPesquisarCliente.setEditable(true);
		btnImprimirOs.setEnabled(false);
		txtOs.setEditable(true);
		btnCreate.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		txtIdCli.setEditable(true);
		btnPesquisar.setEnabled(true);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(OS.class.getResource("/img/eraser.png")));
		btnNewButton.setToolTipText("Limpar");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(410, 665, 64, 64);
		getContentPane().add(btnNewButton);

		JPanel panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1.setBounds(0, 0, 684, 20);
		getContentPane().add(panelUsuarios_1);

		JPanel panelUsuarios_1_1_1 = new JPanel();
		panelUsuarios_1_1_1.setLayout(null);
		panelUsuarios_1_1_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1_1_1.setBounds(0, 222, 690, 8);
		getContentPane().add(panelUsuarios_1_1_1);

		JPanel panelUsuarios_1_1 = new JPanel();
		panelUsuarios_1_1.setLayout(null);
		panelUsuarios_1_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1_1.setBounds(-6, 257, 690, 8);
		getContentPane().add(panelUsuarios_1_1);

		JPanel panelUsuarios_1_2 = new JPanel();
		panelUsuarios_1_2.setLayout(null);
		panelUsuarios_1_2.setBackground(new Color(32, 178, 170));
		panelUsuarios_1_2.setBounds(0, 741, 684, 20);
		getContentPane().add(panelUsuarios_1_2);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(OS.class.getResource("/img/os2.png")));
		lblNewLabel_2.setBounds(-16, -58, 700, 800);
		getContentPane().add(lblNewLabel_2);

	}

	/** The dao. */
	DAO dao = new DAO();
	
	/** The btn create. */
	private JButton btnCreate;
	
	/** The btn update. */
	private JButton btnUpdate;
	
	/** The btn delete. */
	private JButton btnDelete;
	
	/** The table. */
	private JTable table;
	
	/** The cbo status. */
	private JComboBox<Object> cboStatus;
	
	/** The cbo pagamento. */
	private JComboBox<Object> cboPagamento;
	
	/** The txt pesquisar cliente. */
	private JTextArea txtPesquisarCliente;
	
	/** The txt id cli. */
	private JTextField txtIdCli;
	
	/** The date entrada. */
	private JDateChooser dateEntrada;
	
	/** The btn pesquisar. */
	private JButton btnPesquisar;
	
	/** The btn imprimir os. */
	private JButton btnImprimirOs;
	
	/** The table os. */
	private JTable tableOs;
	
	/** The scroll pane os. */
	private JScrollPane scrollPaneOs;
	
	/** The txt servico. */
	private JTextField txtServico;
	
	/** The cbo orcamento. */
	private JComboBox<Object> cboOrcamento;
	
	/** The lbl new label 2. */
	private JLabel lblNewLabel_2;
	
	/** The btn new button. */
	private JButton btnNewButton;

	/**
	 * Pesquisar os released.
	 */
	private void pesquisarOsReleased() {
		String read5 = "select os as OS, modelo as Modelo, placa as Placa, status_os as Status from tbos where os like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read5);
			pst.setString(1, txtOs.getText() + "%");
			ResultSet rs = pst.executeQuery();

			tableOs.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Pesquisar cliente.
	 */
	private void pesquisarCliente() {

		String read2 = "select id, nome, fone  from tbclientes where nome like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtPesquisarCliente.getText() + "%");
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Setar os.
	 */
	private void setarOs() {
		int setar = tableOs.getSelectedRow();
		txtOs.setText(tableOs.getModel().getValueAt(setar, 0).toString());
	}

	/**
	 * Setar id cli.
	 */
	private void setarIdCli() {
		int setar = table.getSelectedRow();
		txtIdCli.setText(table.getModel().getValueAt(setar, 0).toString());
	}

	/**
	 * Pesquisar os.
	 */
	private void pesquisarOs() {

		if (txtOs.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o número da ordem de serviço");
			txtOs.requestFocus();
		} else {

			String read = "select * from tbos where os = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtOs.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					txtIdCli.setEditable(false);
					btnCreate.setEnabled(false);
					((DefaultTableModel) table.getModel()).setRowCount(0);

					txtOs.setText(rs.getString(1));
					String setarData = rs.getString(2);
					Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
					dateEntrada.setDate(dataFormatada);
					txtPlaca.setText(rs.getString(3));
					txtMarca.setText(rs.getString(4));
					txtModelo.setText(rs.getString(5));
					txtCor.setText(rs.getString(6));
					txtAno.setText(rs.getString(7));
					txtKm.setText(rs.getString(8));
					cboOrcamento.setSelectedItem(rs.getString(9));
					txtServico.setText(rs.getString(10));
					txtDefeito.setText(rs.getString(11));
					txtMecanico.setText(rs.getString(12));
					cboStatus.setSelectedItem(rs.getString(13));
					txtValor.setText(rs.getString(14));
					txtDataSaida.setText(rs.getString(15));
					cboPagamento.setSelectedItem(rs.getString(16));
					txtIdCli.setText(rs.getString(17));
					txtIdCli.setEditable(false);
					txtPesquisarCliente.setEditable(false);
					btnImprimirOs.setEnabled(true);
					btnCreate.setEnabled(false);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Ordem de Serviço inexistente");

					txtPesquisarCliente.setEditable(true);
					btnImprimirOs.setEnabled(false);
					txtOs.setEditable(false);
					txtOs.setText(null);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
					txtIdCli.setEditable(true);
					txtIdCli.setText(null);
					btnPesquisar.setEnabled(false);

					((DefaultTableModel) table.getModel()).setRowCount(0);
					((DefaultTableModel) tableOs.getModel()).setRowCount(0);
					limpar();
					btnCreate.setEnabled(true);
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Adicionar.
	 */
	private void Adicionar() {
		/**
		 * Validacao
		 */

		if (cboOrcamento.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira se é um orçamento ou uma ordem de serviço ");
			cboOrcamento.requestFocus();

		} else if (txtIdCli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Cliente ");
			txtIdCli.requestFocus();

		} else if (txtPlaca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Placa");
			txtPlaca.requestFocus();

		} else if (txtMarca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Marca");
			txtMarca.requestFocus();
		} else if (txtModelo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Modelo");
			txtModelo.requestFocus();
		} else if (txtCor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Cor");
			txtCor.requestFocus();
		} else if (txtAno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Ano");
			txtAno.requestFocus();
		} else if (txtKm.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Km");
			txtKm.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Defeito");
			txtDefeito.requestFocus();

		} else if (cboStatus.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira o Status do Serviço");

		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Valor");
			txtValor.requestFocus();

		} else if (txtIdCli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Cliente ");
			txtIdCli.requestFocus();

		} else {

			String create = "insert into tbos (placa,marca,modelo,cor,ano,km, orcamento, servico, defeito, mecanico,status_os,valor,data_saida,forma_pagamento,id) values (?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);

				pst.setString(1, txtPlaca.getText());
				pst.setString(2, txtMarca.getText());
				pst.setString(3, txtModelo.getText());
				pst.setString(4, txtCor.getText());
				pst.setString(5, txtAno.getText());
				pst.setString(6, txtKm.getText());
				pst.setString(7, cboOrcamento.getSelectedItem().toString());
				pst.setString(8, txtServico.getText());
				pst.setString(9, txtDefeito.getText());
				pst.setString(10, txtMecanico.getText());
				pst.setString(11, cboStatus.getSelectedItem().toString());
				pst.setString(12, txtValor.getText());
				pst.setString(13, txtDataSaida.getText());
				pst.setString(14, cboPagamento.getSelectedItem().toString());
				pst.setString(15, txtIdCli.getText());

				txtOs.setEditable(false);
				txtOs.setText(null);
				txtIdCli.setEditable(true);

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Ordem de serviço -  cadastrada com sucesso!");

					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(false);
					btnPesquisar.setEnabled(true);
					txtOs.setEditable(true);
					txtIdCli.setEditable(false);
					btnImprimirOs.setEnabled(true);
					con.close();
					btnCreate.setEnabled(false);
				}

				this.showClientOrders(txtIdCli.getText());

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Ordem de serviço não adicionada - OS Duplicada");
				btnCreate.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				btnImprimirOs.setEnabled(false);

			}

			catch (Exception e2) {
				System.out.println(e2);

				JOptionPane.showConfirmDialog(null, e2);

			}
		}
	}

	/**
	 * Show client orders.
	 *
	 * @param clientId the client id
	 */
	private void showClientOrders(String clientId) {
		String read5 = "select os as OS, marca as Marca, placa as Placa, status_os as Status from tbos where id = ? order by os desc";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read5);
			pst.setString(1, clientId);
			ResultSet rs = pst.executeQuery();

			tableOs.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Update os.
	 */
	private void updateOs() {

		if (cboOrcamento.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira se é um orçamento ou uma ordem de serviço ");
			cboOrcamento.requestFocus();
		} else if (txtPlaca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Placa");
			txtPlaca.requestFocus();

		} else if (txtMarca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Marca");
			txtMarca.requestFocus();
		} else if (txtModelo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Modelo");
			txtModelo.requestFocus();
		} else if (txtCor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Cor");
			txtCor.requestFocus();
		} else if (txtAno.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Ano");
			txtAno.requestFocus();
		} else if (txtKm.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Km");
			txtKm.requestFocus();
		} else if (txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Defeito");
			txtDefeito.requestFocus();

		} else if (cboStatus.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira o Status do Serviço");

		} else if (txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Valor");
			txtValor.requestFocus();

		} else if (txtIdCli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Cliente ");
			txtIdCli.requestFocus();

		} else {

			String update = "update tbos set placa = ?, marca = ?, modelo = ?, cor = ?, ano = ?, km = ?, orcamento = ?, servico = ?, defeito = ?,  mecanico = ?, status_os = ?, valor = ?, data_saida = ?, forma_pagamento = ?, id = ?  where os = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtPlaca.getText());
				pst.setString(2, txtMarca.getText());
				pst.setString(3, txtModelo.getText());
				pst.setString(4, txtCor.getText());
				pst.setString(5, txtAno.getText());
				pst.setString(6, txtKm.getText());
				pst.setString(7, cboOrcamento.getSelectedItem().toString());
				pst.setString(8, txtServico.getText());
				pst.setString(9, txtDefeito.getText());
				pst.setString(10, txtMecanico.getText());
				pst.setString(11, cboStatus.getSelectedItem().toString());
				pst.setString(12, txtValor.getText());
				pst.setString(13, txtDataSaida.getText());
				pst.setString(14, cboPagamento.getSelectedItem().toString());
				pst.setString(15, txtIdCli.getText());
				pst.setString(16, txtOs.getText());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {

					JOptionPane.showMessageDialog(null, "Ordem de Serviço - atualizada com sucesso");
					btnCreate.setEnabled(false);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnPesquisar.setEnabled(true);
					btnImprimirOs.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - OS já existente");

					txtIdCli.setEnabled(true);
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

				}

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇÃO! OS: Duplicada");

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	/**
	 * Delete os.
	 */
	public void deleteOs() {

		// Validacao
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão desta OS?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {

			String delete = "delete from tbos where os = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtOs.getText());

				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {

					JOptionPane.showMessageDialog(null, "OS excluida com sucesso");
					txtOs.setEnabled(true);
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

				}

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				limpar();
				JOptionPane.showMessageDialog(null, "ATENÇÃO! O relacionado a uma OS.");
				txtOs.setEnabled(true);
				txtOs.requestFocus();
				btnCreate.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				btnImprimirOs.setEnabled(true);

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	/**
	 * Imprimir os.
	 */
	private void imprimirOs() {

		Document document = new Document();

		try {

			PdfWriter.getInstance(document, new FileOutputStream("ordemdeservico.pdf"));
			document.open();

			String relImprimirOs = "select tbos.os, date_format(tbos.data_os,'%d/%m/%Y - %H:%i'),tbclientes.nome, tbclientes.fone, tbos.servico, tbos.defeito, tbos.modelo , tbos.placa ,  tbos.forma_pagamento , tbos.valor, tbos.data_saida, tbos.orcamento from tbos inner join tbclientes on tbos.id= tbclientes.id where os like ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relImprimirOs);
				pst.setString(1, txtOs.getText() + "%"); // atencao "%
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {

					document.add(new Paragraph(" "));
					Paragraph ordemdeservico = new Paragraph("N° OS: " + rs.getString(1));
					ordemdeservico.setAlignment(Element.ALIGN_CENTER);
					document.add(ordemdeservico);
					document.add(new Paragraph(" "));

					Paragraph orcamento = new Paragraph("" + rs.getString(12));
					orcamento.setAlignment(Element.ALIGN_CENTER);
					document.add(orcamento);
					document.add(new Paragraph(" "));

					Paragraph dataentrada = new Paragraph("Data de entrada: " + rs.getString(2));
					dataentrada.setAlignment(Element.ALIGN_LEFT);
					document.add(dataentrada);
					document.add(new Paragraph(" "));

					Paragraph cliente = new Paragraph("Cliente: " + rs.getString(3));
					cliente.setAlignment(Element.ALIGN_LEFT);
					document.add(cliente);
					document.add(new Paragraph(" "));

					Paragraph telefone = new Paragraph("Telefone: " + rs.getString(4));
					telefone.setAlignment(Element.ALIGN_LEFT);
					document.add(telefone);
					document.add(new Paragraph(" "));

					Paragraph servico = new Paragraph("Serviço: " + rs.getString(5));
					servico.setAlignment(Element.ALIGN_LEFT);
					document.isInline();
					document.add(servico);
					document.add(new Paragraph(" "));

					Paragraph defeito = new Paragraph("Defeito: " + rs.getString(6));
					defeito.setAlignment(Element.ALIGN_LEFT);
					document.isInline();
					document.add(defeito);
					document.add(new Paragraph(" "));

					Paragraph modelo = new Paragraph("Modelo: " + rs.getString(7));
					modelo.setAlignment(Element.ALIGN_LEFT);
					document.add(modelo);
					document.add(new Paragraph(" "));

					Paragraph placa = new Paragraph("Placa: " + rs.getString(8));
					placa.setAlignment(Element.ALIGN_LEFT);
					document.add(placa);
					document.add(new Paragraph(" "));

					Paragraph pagamento = new Paragraph("Forma de pagamento: " + rs.getString(9));
					pagamento.setAlignment(Element.ALIGN_LEFT);
					document.add(pagamento);
					document.add(new Paragraph(" "));

					Paragraph valor = new Paragraph("Valor: R$ " + rs.getString(10));
					valor.setAlignment(Element.ALIGN_LEFT);
					document.add(valor);
					document.add(new Paragraph(" "));

					Paragraph datasaida = new Paragraph("Data de Saída: " + rs.getString(11));
					datasaida.setAlignment(Element.ALIGN_LEFT);
					document.add(datasaida);
					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));

					Paragraph linha = new Paragraph("______________________________________________");
					linha.setAlignment(Element.ALIGN_CENTER);
					document.add(linha);
					Paragraph asscli = new Paragraph("Assinatura do Mêcanico");
					asscli.setAlignment(Element.ALIGN_CENTER);
					document.add(asscli);

					document.add(new Paragraph(" "));
					document.add(new Paragraph(" "));
					Paragraph linha2 = new Paragraph("______________________________________________");
					linha2.setAlignment(Element.ALIGN_CENTER);
					document.add(linha2);

					Paragraph assmec = new Paragraph("Assinatura do Cliente");
					assmec.setAlignment(Element.ALIGN_CENTER);
					document.add(assmec);

					Image imagem = Image.getInstance(OS.class.getResource("/img/logoo.png"));
					imagem.scaleToFit(250, 200);
					imagem.setAbsolutePosition(200, 700);

					document.add(imagem);

				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("ordemdeservico.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Limpar.
	 */
	private void limpar() {
		txtPesquisarCliente.setEditable(true);
		btnImprimirOs.setEnabled(false);
		btnCreate.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		txtIdCli.setText(null);
		txtOs.setText(null);
		txtPlaca.setText(null);
		txtMarca.setText(null);
		txtModelo.setText(null);
		txtCor.setText(null);
		txtAno.setText(null);
		txtKm.setText(null);
		txtDefeito.setText(null);
		txtServico.setText(null);
		txtValor.setText(null);
		txtMecanico.setText(null);
		txtDataSaida.setText(null);
		cboStatus.setSelectedItem(null);
		cboOrcamento.setSelectedItem(null);
		cboPagamento.setSelectedItem(null);
		dateEntrada.setDate(null);
		((DefaultTableModel) table.getModel()).setRowCount(0);
		((DefaultTableModel) tableOs.getModel()).setRowCount(0);

	}
}
