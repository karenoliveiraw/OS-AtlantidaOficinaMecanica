package views;

import java.awt.Color;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import java.awt.Cursor;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The lbl status. */
	private JLabel lblStatus;
	
	/** The txt login. */
	private JTextField txtLogin;
	
	/** The txt senha. */
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/users 32x32.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// a linha abaixo centraliza o JFrame/ Jdialog
		setLocationRelativeTo(null);
		btnAcessar = new JButton("");
		btnAcessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcessar.setToolTipText("Fazer login");
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/img/accesslogin.png")));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setBounds(181, 181, 32, 32);
		contentPane.add(btnAcessar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(10, 242, 48, 48);
		contentPane.add(lblStatus);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/users 32x32.png")));
		lblNewLabel.setBounds(97, 94, 48, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/password 32x32.png")));
		lblNewLabel_1.setBounds(98, 146, 32, 32);
		contentPane.add(lblNewLabel_1);

		txtLogin = new JTextField();
		txtLogin.setBounds(140, 100, 128, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(140, 150, 128, 20);
		contentPane.add(txtSenha);

		getRootPane().setDefaultButton(btnAcessar);

		panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBackground(new Color(32, 178, 170));
		panelUsuarios.setBounds(0, 0, 395, 10);
		contentPane.add(panelUsuarios);

		panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1.setBounds(0, 310, 395, 10);
		contentPane.add(panelUsuarios_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/img/icon120x120.png")));
		lblNewLabel_2.setBounds(126, 224, 120, 120);
		contentPane.add(lblNewLabel_2);

		RestrictedTextField senha = new RestrictedTextField(txtSenha);
		senha.setLimit(50);
		RestrictedTextField login = new RestrictedTextField(txtLogin);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/img/login.png")));
		lblNewLabel_3.setBounds(-16, -10, 411, 320);
		contentPane.add(lblNewLabel_3);
		login.setLimit(15);
		login.setOnlyText(true);

	}

	/** The dao. */
	DAO dao = new DAO();
	
	/** The btn acessar. */
	private JButton btnAcessar;
	
	/** The panel usuarios. */
	private JPanel panelUsuarios;
	
	/** The panel usuarios 1. */
	private JPanel panelUsuarios_1;
	
	/** The lbl new label 2. */
	private JLabel lblNewLabel_2;

	/**
	 * Status.
	 */
	private void status() {

		try {
			Connection con = dao.conectar();
			if (con == null) {

				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dboff.png")));
			} else {

				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dbon.png")));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Logar.
	 */
	private void logar() {

		String capturaSenha = new String(txtSenha.getPassword());

		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua Senha");
			txtSenha.requestFocus();
		} else {

			String read = "select * from tbusuarios where login = ? and senha = md5(?)";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);

				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					Main main = new Main();

					String perfil = rs.getString(5);

					if (perfil.equals("admin")) {
						main.setVisible(true);
						main.lblUsuario.setText(rs.getString(2));
						main.btnRelatorios.setEnabled(true);
						main.btnUsuarios.setEnabled(true);
						main.panelUsuarios.setBackground(Color.black);

						this.dispose();
					} else {
						main.setVisible(true);
						main.lblUsuario.setText(rs.getString(2));
						this.dispose();
						main.btnRelatorios.setEnabled(false);
						main.btnUsuarios.setEnabled(false);
					}

				} else {
					JOptionPane.showMessageDialog(null, " Login e/ou senha inválido(s)");

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
	void limpar() {

		txtLogin.setText(null);
		txtSenha.setText(null);

	}
}
