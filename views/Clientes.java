package views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Clientes.
 */
public class Clientes extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The txt cpf. */
	private JTextField txtCpf;

	/** The txt nomecliente. */
	private JTextField txtNomecliente;

	/** The txt fone. */
	private JTextField txtFone;

	/** The txt whatsapp. */
	private JTextField txtWhatsapp;

	/** The txt email. */
	private JTextField txtEmail;

	/** The txt cep. */
	private JTextField txtCep;

	/** The txt endereco. */
	private JTextField txtEndereco;

	/** The txt numero. */
	private JTextField txtNumero;

	/** The txt complemento. */
	private JTextField txtComplemento;

	/** The txt bairro. */
	private JTextField txtBairro;

	/** The txt cidade. */
	private JTextField txtCidade;

	/** The txt id. */
	private JTextField txtId;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	public Clientes() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/clientes].png")));
		setBounds(100, 100, 640, 697);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(207, 198, 30, 14);
		getContentPane().add(lblId);

		btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setIcon(new ImageIcon(Clientes.class.getResource("/img/search 28x28.png")));
		btnBuscar.setToolTipText("Buscar ID");
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBounds(312, 187, 30, 28);
		getContentPane().add(btnBuscar);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(353, 241, 66, 14);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setToolTipText("Coloque o CPF");
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321./-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCpf.setBounds(389, 238, 171, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNomeCliente = new JLabel(" Cliente");
		lblNomeCliente.setBounds(10, 241, 78, 14);
		getContentPane().add(lblNomeCliente);

		txtNomecliente = new JTextField();

		txtNomecliente.setToolTipText("Coloque o nome do Cliente");
		txtNomecliente.setBounds(54, 238, 205, 20);
		getContentPane().add(txtNomecliente);
		txtNomecliente.setColumns(10);

		JLabel lblFone = new JLabel("Fone");
		lblFone.setBounds(10, 289, 46, 14);
		getContentPane().add(lblFone);

		txtFone = new JTextField();
		txtFone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321-()";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtFone.setToolTipText("Coloque o telefone");
		txtFone.setBounds(54, 286, 86, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);

		JLabel lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setBounds(155, 289, 65, 14);
		getContentPane().add(lblWhatsapp);

		txtWhatsapp = new JTextField();
		txtWhatsapp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321-()";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtWhatsapp.setToolTipText("Coloque o Whatsapp");
		txtWhatsapp.setBounds(219, 286, 89, 20);
		getContentPane().add(txtWhatsapp);
		txtWhatsapp.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(340, 289, 46, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "AaBbcCdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890@._-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		txtEmail.setToolTipText("Coloque o e-mail");
		txtEmail.setBounds(377, 286, 183, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(200, 362, 46, 14);
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCep.setToolTipText("Coloque o CEP");
		txtCep.setBounds(233, 359, 79, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblendereco = new JLabel("Endere\u00E7o");
		lblendereco.setBounds(67, 401, 58, 14);
		getContentPane().add(lblendereco);

		txtEndereco = new JTextField();
		txtEndereco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
		});

		txtEndereco.setToolTipText("Coloque o Endereço");
		txtEndereco.setBounds(143, 398, 293, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(63, 476, 66, 23);
		getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});

		txtNumero.setToolTipText("Coloque o Número ");
		txtNumero.setBounds(120, 477, 66, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(208, 479, 96, 14);
		getContentPane().add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});

		txtComplemento.setToolTipText("Coloque o Complemento");
		txtComplemento.setBounds(295, 476, 141, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(71, 436, 46, 20);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
		});

		txtBairro.setToolTipText("Coloque o Bairro");
		txtBairro.setBounds(109, 436, 124, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(249, 436, 50, 22);
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
		});

		txtCidade.setToolTipText("Coloque a Cidade");
		txtCidade.setBounds(295, 438, 141, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(446, 459, 46, 14);
		getContentPane().add(lblUf);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321./-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtId.setToolTipText("Coloque ID");
		txtId.setBounds(241, 195, 58, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		cboUf = new JComboBox<Object>();
		cboUf.setBackground(new Color(102, 205, 170));
		cboUf.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(468, 457, 46, 22);
		getContentPane().add(cboUf);

		btnUpdate = new JButton("");
		btnUpdate.setBorderPainted(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Atualizar Cliente");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();

			}
		});
		btnUpdate.setIcon(new ImageIcon(Clientes.class.getResource("/img/update.png")));
		btnUpdate.setBounds(206, 529, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setBorderPainted(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Excluir Cliente");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnDelete.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnDelete.setBounds(287, 529, 64, 64);
		getContentPane().add(btnDelete);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(159, 43, 78, 14);
		getContentPane().add(lblCliente);

		txtPesquisar = new JTextArea();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarCliente();
			}
		});
		txtPesquisar.setBounds(218, 38, 242, 22);
		getContentPane().add(txtPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 604, 105);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setarIdCli();
			}
		});
		scrollPane.setViewportView(table);

		RestrictedTextField id = new RestrictedTextField(txtId);
		id.setLimit(7);

		RestrictedTextField cnpj = new RestrictedTextField(txtCpf);
		cnpj.setLimit(20);

		RestrictedTextField NomeCli = new RestrictedTextField(txtNomecliente);
		NomeCli.setLimit(60);
		NomeCli.setOnlyText(true);
		NomeCli.setAcceptSpace(true);
		NomeCli.setLimit(50);

		RestrictedTextField cep  = new RestrictedTextField(txtCep);
		cep.setLimit(10);

		RestrictedTextField endereco = new RestrictedTextField(txtEndereco);

		endereco.setOnlyText(true);
		endereco.setAcceptSpace(true);
		endereco.setLimit(50);

		RestrictedTextField numero = new RestrictedTextField(txtNumero);
		numero.setLimit(6);

		RestrictedTextField complemento = new RestrictedTextField(txtComplemento);
		complemento.setLimit(20);

		RestrictedTextField Bairro = new RestrictedTextField(txtBairro);
		Bairro.setLimit(30);
		Bairro.setOnlyText(true);
		Bairro.setAcceptSpace(true);

		RestrictedTextField Cidade = new RestrictedTextField(txtCidade);
		Cidade.setLimit(40);
		Cidade.setOnlyText(true);
		Cidade.setAcceptSpace(true);

		RestrictedTextField Fone = new RestrictedTextField(txtFone);
		Fone.setLimit(10);

		RestrictedTextField Whatsapp = new RestrictedTextField(txtWhatsapp);
		Whatsapp.setLimit(11);

		RestrictedTextField Email = new RestrictedTextField(txtEmail);

		Email.setLimit(30);

		lblStatus = new JLabel("");
		lblStatus.setIcon(null);
		lblStatus.setToolTipText("Status");
		lblStatus.setBounds(312, 362, 16, 16);
		getContentPane().add(lblStatus);

		btnCreate = new JButton("");
		btnCreate.setBorderPainted(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setToolTipText("Adicionar Cliente");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setIcon(new ImageIcon(Clientes.class.getResource("/img/add.png")));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setBounds(120, 529, 64, 64);
		getContentPane().add(btnCreate);

		btnPesquisar = new JButton("");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();

			}
		});
		btnPesquisar.setIcon(new ImageIcon(Clientes.class.getResource("/img/search 28x28.png")));
		btnPesquisar.setToolTipText("Buscar ID");
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBounds(340, 348, 28, 28);
		getContentPane().add(btnPesquisar);

		panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBackground(new Color(32, 178, 170));
		panelUsuarios.setBounds(0, 638, 624, 20);
		getContentPane().add(panelUsuarios);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Clientes.class.getResource("/img/icon120x120.png")));
		lblNewLabel.setBounds(10, -10, 124, 120);
		getContentPane().add(lblNewLabel);

		panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1.setBounds(0, 0, 624, 20);
		getContentPane().add(panelUsuarios_1);

		btnCreate.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);

		JPanel panelUsuarios_1_1 = new JPanel();
		panelUsuarios_1_1.setLayout(null);
		panelUsuarios_1_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1_1.setBounds(0, 219, 624, 8);
		getContentPane().add(panelUsuarios_1_1);

		JPanel panelUsuarios_1_1_1 = new JPanel();
		panelUsuarios_1_1_1.setLayout(null);
		panelUsuarios_1_1_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1_1_1.setBounds(0, 175, 624, 8);
		getContentPane().add(panelUsuarios_1_1_1);

		panelUsuarios_1_2 = new JPanel();
		panelUsuarios_1_2.setLayout(null);
		panelUsuarios_1_2.setBackground(new Color(32, 178, 170));
		panelUsuarios_1_2.setBounds(0, 335, 624, 8);
		getContentPane().add(panelUsuarios_1_2);

		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton.setToolTipText("Limpar");
		btnNewButton.setIcon(new ImageIcon(Clientes.class.getResource("/img/eraser.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(375, 529, 64, 64);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Clientes.class.getResource("/img/clientes.png")));
		lblNewLabel_1.setBounds(-16, -54, 640, 700);
		getContentPane().add(lblNewLabel_1);
		txtId.setEditable(false);

	}

	/** The dao. */
	DAO dao = new DAO();

	/** The btn buscar. */
	private JButton btnBuscar;

	/** The cbo uf. */
	private JComboBox<Object> cboUf;

	/** The txt pesquisar. */
	private JTextArea txtPesquisar;

	/** The table. */
	private JTable table;

	/** The lbl status. */
	private JLabel lblStatus;

	/** The btn update. */
	private JButton btnUpdate;

	/** The btn delete. */
	private JButton btnDelete;

	/** The btn create. */
	private JButton btnCreate;

	/** The btn pesquisar. */
	private JButton btnPesquisar;

	/** The panel usuarios. */
	private JPanel panelUsuarios;

	/** The lbl new label. */
	private JLabel lblNewLabel;

	/** The panel usuarios 1. */
	private JPanel panelUsuarios_1;

	/** The panel usuarios 1 2. */
	private JPanel panelUsuarios_1_2;

	/**
	 * Setar id cli.
	 */
	private void setarIdCli() {
		int setar = table.getSelectedRow();
		txtId.setText(table.getModel().getValueAt(setar, 0).toString());
	}

	/**
	 * Buscar cep.
	 */
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			org.dom4j.Document documento = xml.read(url);
			Element root = ((org.dom4j.Document) documento).getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}

			txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Pesquisar cliente.
	 */
	private void pesquisarCliente() {
		String read2 = "select id as ID, nome as Cliente, whatsapp as Whatsapp, fone as Telefone from tbclientes where nome like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtPesquisar.getText() + "%");
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Pesquisar.
	 */
	private void pesquisar() {

		/**
		 * validacao
		 */
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Id do cliente");
			txtId.requestFocus();
		} else {
			String read = "select * from tbclientes where id = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtId.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtId.setText(rs.getString(1));
					txtNomecliente.setText(rs.getString(2));

					txtCpf.setText(rs.getString(3));
					txtFone.setText(rs.getString(4));
					txtWhatsapp.setText(rs.getString(5));

					txtCep.setText(rs.getString(6));
					txtEmail.setText(rs.getString(7));
					txtEndereco.setText(rs.getString(8));
					txtNumero.setText(rs.getString(9));
					txtComplemento.setText(rs.getString(10));
					txtBairro.setText(rs.getString(11));
					txtCidade.setText(rs.getString(12));
					cboUf.setSelectedItem(rs.getString(13));

					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnCreate.setEnabled(false);
					txtId.setEnabled(false);

				} else {

					JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
					btnBuscar.setEnabled(true);
					txtId.setEditable(false);
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					txtNomecliente.requestFocus();
					limpar();
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
	public void adicionar() {

		if (txtNomecliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome do Cliente");
			txtNomecliente.requestFocus();

		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP");
			txtCep.requestFocus();
		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CPF");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o endereco");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o numero");
			txtNumero.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a cidade");
			txtCidade.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o e-mail");
			txtEmail.requestFocus();

		} else {
			String create = "insert into tbclientes (nome,cpf,fone, whatsapp,cep ,email, endereco, numero, complemento, bairro, cidade, uf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtNomecliente.getText());
				pst.setString(2, txtCpf.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtWhatsapp.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEmail.getText());
				pst.setString(7, txtEndereco.getText());
				pst.setString(8, txtNumero.getText());
				pst.setString(9, txtComplemento.getText());
				pst.setString(10, txtBairro.getText());
				pst.setString(11, txtCidade.getText());
				pst.setString(12, cboUf.getSelectedItem().toString());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnCreate.setEnabled(false);
					txtId.setEnabled(true);
					btnBuscar.setEnabled(true);

					con.close();
				}

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇÃO: Cliente Duplicado");
				limpar();
				txtCpf.setText(null);
				txtCpf.requestFocus();

			}

			catch (Exception e2) {
				System.out.println(e2);

			}
		}
	}

	/**
	 * Atualizar.
	 */
	public void atualizar() {

		if (txtNomecliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do Cliente");
			txtNomecliente.requestFocus();

		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CPF");
			txtCpf.requestFocus();

		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o endereco");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o numero");
			txtNumero.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a cidade");
			txtCidade.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nome do contato");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a nome do contato");
			txtEmail.requestFocus();
		} else {

			String update = "update tbclientes set nome = ?, cpf = ?, fone = ?, whatsapp = ?, cep = ?, email = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ? where id = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtNomecliente.getText());

				pst.setString(2, txtCpf.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtWhatsapp.getText());

				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEmail.getText());
				pst.setString(7, txtEndereco.getText());
				pst.setString(8, txtNumero.getText());
				pst.setString(9, txtComplemento.getText());
				pst.setString(10, txtBairro.getText());
				pst.setString(11, txtCidade.getText());
				pst.setString(12, cboUf.getSelectedItem().toString());

				pst.setString(13, txtId.getText());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Informações do cliente Atualizados com Sucesso.");
					btnCreate.setEnabled(false);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnPesquisar.setEnabled(true);

				}

				con.close();
			}

			catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Cliente não atualizado - CPF Duplicado");
				txtCpf.setText(null);
				txtCpf.requestFocus();

			}

			catch (Exception e2) {
				System.out.println(e2);
				JOptionPane.showConfirmDialog(null, e2);
				limpar();
			}
		}
	}

	/**
	 * Excluir.
	 */
	public void excluir() {

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão deste Cliente?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {

			String delete = "delete from tbclientes where id = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());

				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
					txtId.setEnabled(false);
					btnBuscar.setEnabled(true);
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);

				}

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {

				JOptionPane.showMessageDialog(null, "ATENÇÃO! Exclusão não permitida, cliente relacionado a uma OS.");
				txtId.setEnabled(true);
				txtId.requestFocus();
				btnCreate.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	/**
	 * Limpar.
	 */
	public void limpar() {
		txtPesquisar.setText(null);
		txtId.setText(null);
		txtCpf.setText(null);
		txtNomecliente.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem("");
		txtFone.setText(null);
		txtWhatsapp.setText(null);
		txtEmail.setText(null);
		btnCreate.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);

		((DefaultTableModel) table.getModel()).setRowCount(0);

	}
}
