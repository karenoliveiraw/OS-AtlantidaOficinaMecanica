package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import models.DAO;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JPanel;
import java.awt.Toolkit;

/**
 * The Class Usuarios.
 */
public class Usuarios extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The txt id. */
	private JTextField txtId;

	/** The txt usuario. */
	private JTextField txtUsuario;

	/** The txt login. */
	private JTextField txtLogin;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
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
	public Usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/usuarios.png")));
		getContentPane().setBackground(UIManager.getColor("Button.background"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
		setResizable(false);
		setModal(true);
		setTitle("Usuarios");
		setBounds(100, 100, 450, 360);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(336, 31, 46, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(314, 34, 46, 14);
		getContentPane().add(lblNewLabel);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(144, 101, 173, 20);
		getContentPane().add(txtUsuario);

		JLabel lblUsuarios = new JLabel("Usuario");
		lblUsuarios.setBounds(96, 84, 48, 48);
		getContentPane().add(lblUsuarios);

		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(144, 70, 173, 20);
		getContentPane().add(txtLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(96, 70, 46, 14);
		getContentPane().add(lblLogin);

		btnCreate = new JButton("");
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnCreate.setToolTipText("Adicionar novo usu\u00E1rio");
		btnCreate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/add.png")));
		btnCreate.setBounds(108, 189, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!chckSenha.isSelected()) {
					alterarUsuarioSenha();
				} else {
					alterarUsuario();
				}
			}
		});
		btnUpdate.setToolTipText("Atualizar usu\u00E1rio");
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/update.png")));
		btnUpdate.setBounds(191, 189, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnDelete.setToolTipText("Apagar usu\u00E1rio");
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete.png")));
		btnDelete.setBounds(275, 189, 64, 64);
		getContentPane().add(btnDelete);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(96, 132, 46, 14);
		getContentPane().add(lblSenha);

		btnRead = new JButton("");
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setToolTipText("Pesquisar usu\u00E1rio");
		btnRead.setIcon(new ImageIcon(Usuarios.class.getResource("/img/search 28x28.png")));
		btnRead.setBounds(334, 80, 28, 28);
		getContentPane().add(btnRead);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(144, 132, 173, 20);
		getContentPane().add(txtPassword);

		JLabel lblNewLabel_1 = new JLabel("Perfil");
		lblNewLabel_1.setBounds(167, 35, 64, 14);
		getContentPane().add(lblNewLabel_1);

		cboPerfil = new JComboBox();
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] { "", "admin", "user" }));
		cboPerfil.setBounds(207, 31, 64, 22);
		getContentPane().add(cboPerfil);

		chckSenha = new JCheckBox("Alterar senha");
		chckSenha.setContentAreaFilled(false);
		chckSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtPassword.setEditable(true);
				txtPassword.setText(null);
				txtPassword.requestFocus();
				txtPassword.setBackground(Color.yellow);
			}
		});
		chckSenha.setVisible(false);
		chckSenha.setBounds(168, 159, 103, 23);
		getContentPane().add(chckSenha);

		panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBackground(new Color(32, 178, 170));
		panelUsuarios.setBounds(0, 301, 434, 20);
		getContentPane().add(panelUsuarios);

		panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1.setBounds(0, 0, 434, 20);
		getContentPane().add(panelUsuarios_1);

		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setLimit(15);
		login.setOnlyText(true);
		RestrictedTextField usuario = new RestrictedTextField(txtUsuario);
		usuario.setLimit(15);
		RestrictedTextField senha = new RestrictedTextField(txtPassword);
		senha.setLimit(250);

		btnCreate.setEnabled(true);
		btnRead.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);

		RestrictedTextField vsenha = new RestrictedTextField(txtPassword);
		vsenha.setLimit(250);
		vsenha.setAcceptSpace(false);
		RestrictedTextField vlogin = new RestrictedTextField(txtLogin);
		vlogin.setLimit(15);
		vlogin.setAcceptSpace(false);
		RestrictedTextField vusuario = new RestrictedTextField(txtUsuario);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Usuarios.class.getResource("/img/osusuario.png")));
		lblNewLabel_3.setBounds(0, -19, 434, 360);
		getContentPane().add(lblNewLabel_3);
		vusuario.setLimit(15);
		vusuario.setAcceptSpace(false);

	}

	/** The dao. */
	DAO dao = new DAO();

	/** The btn read. */
	private JButton btnRead;

	/** The btn create. */
	private JButton btnCreate;

	/** The btn update. */
	private JButton btnUpdate;

	/** The btn delete. */
	private JButton btnDelete;

	/** The txt password. */
	private JPasswordField txtPassword;

	/** The cbo perfil. */
	@SuppressWarnings("rawtypes")
	private JComboBox cboPerfil;

	/** The chck senha. */
	private JCheckBox chckSenha;

	/** The panel usuarios. */
	private JPanel panelUsuarios;

	/** The panel usuarios 1. */
	private JPanel panelUsuarios_1;

	/**
	 * Pesquisar usuario.
	 */
	void pesquisarUsuario() {

		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome do login");
			txtLogin.requestFocus();

		} else {

			String read = "select * from  tbusuarios where login = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtLogin.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					txtId.setText(rs.getString(1));
					txtLogin.setText(rs.getString(3));
					txtUsuario.setText(rs.getString(2));
					txtPassword.setText(rs.getString(4));
					cboPerfil.setSelectedItem(rs.getString(5));

					chckSenha.setVisible(true);

					txtPassword.setEditable(false);

					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnCreate.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente");

					limpar();
					txtLogin.requestFocus();

					btnCreate.setEnabled(true);
					btnRead.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);

				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Adicionar usuario.
	 */
	private void adicionarUsuario() {

		String capturaSenha = new String(txtPassword.getPassword());

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuario");
			txtUsuario.requestFocus();

		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login ");
			txtLogin.requestFocus();

		} else if (cboPerfil.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira o perfil");
			cboPerfil.requestFocus();

		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a Senha ");
			txtLogin.requestFocus();

		} else {
			String create = "insert into tbusuarios (usuario, login, senha, perfil) values (?, ?, md5(?), ?)";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(create);

				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
					limpar();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Usuário não adicionado");
				}
				limpar();

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Usuário não adicionado - Login existente");
				limpar();
				txtLogin.setText(null);
				txtLogin.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	/**
	 * Alterar usuario.
	 */
	private void alterarUsuario() {

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuario");
			txtUsuario.requestFocus();

		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login ");
			txtLogin.requestFocus();

		} else {

			String capturaSenha2 = new String(txtPassword.getPassword());
			String update = "update tbusuarios set usuario = ?, login = ?, senha = md5 (?), perfil = ? where id = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha2);
				pst.setString(4, cboPerfil.getSelectedItem().toString());
				pst.setString(5, txtId.getText());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {

					JOptionPane.showMessageDialog(null, "Dados do usuário atualizados com sucesso");
					limpar();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(true);
					btnDelete.setEnabled(true);
					btnUpdate.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Dados do usuário não foram alterados");
					limpar();
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Alterar usuario senha.
	 */
	private void alterarUsuarioSenha() {

		String capturaSenha = new String(txtPassword.getPassword());

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuario");
			txtUsuario.requestFocus();

		} else if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login ");
			txtLogin.requestFocus();

		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Preencha a Senha ");
			txtLogin.requestFocus();
		} else {

			String update = "update tbusuarios set usuario = ?, login = ?, senha = md5 (?), perfil = ? where id = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(update);

				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtLogin.getText());
				pst.setString(3, capturaSenha);
				pst.setString(4, cboPerfil.getSelectedItem().toString());
				pst.setString(5, txtId.getText());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Dados do usuário atualizados com sucesso");
					limpar();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Dados do usuário  não foram alterados");
					limpar();
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Excluir usuario.
	 */
	private void excluirUsuario() {

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_OPTION) {

			String delete = "delete from tbusuarios where id = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());

				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso!");
					limpar();
					btnCreate.setEnabled(true);
					btnRead.setEnabled(true);
					btnDelete.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "ERRO na exclusãoo do usuario");
				}

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Limpar.
	 */
	private void limpar() {
		txtId.setText(null);
		txtUsuario.setText(null);
		txtLogin.setText(null);
		txtPassword.setText(null);
		txtPassword.setBackground(Color.WHITE);
		txtUsuario.requestFocus();
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnRead.setEnabled(true);
		txtPassword.setEditable(true);
		cboPerfil.setSelectedItem("");
		chckSenha.setSelected(false);
		chckSenha.setVisible(false);

	}
}
