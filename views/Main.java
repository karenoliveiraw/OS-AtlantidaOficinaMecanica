package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	 /** The btn usuarios. */
 	JButton btnUsuarios;
	 
 	/** The btn relatorios. */
 	JButton btnRelatorios;
    
    /** The panel usuarios. */
    JPanel panelUsuarios;
	
	/** The lbl usuario. */
	JLabel lblUsuario;
	
	/** The btn new button. */
	private JButton btnNewButton;
	
	/** The lbl data. */
	private JLabel lblData;
	
	/** The panel. */
	private JPanel panel;
	
	/** The lbl new label 2. */
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/icon120x120.png")));
		setTitle("Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 480);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setBorderPainted(false);
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setEnabled(false);
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setToolTipText("Usuarios");
		btnUsuarios.setIcon(new ImageIcon(Main.class.getResource("/img/clientes].png")));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Usuarios usuarios = new Usuarios ();
					usuarios.setVisible(true);
			}
		});
		btnUsuarios.setBounds(156, 62, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnOs = new JButton("");
		btnOs.setBorderPainted(false);
		btnOs.setContentAreaFilled(false);
		btnOs.setIcon(new ImageIcon(Main.class.getResource("/img/4856361.png")));
		btnOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OS  os= new OS();
				os.setVisible(true);
			}
		});
		btnOs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOs.setToolTipText("Ordem de Serviço");
		btnOs.setBounds(327, 62, 128, 128);
		contentPane.add(btnOs);
		
		JButton btnClientes = new JButton("");
		btnClientes.setBorderPainted(false);
		btnClientes.setContentAreaFilled(false);
		btnClientes.setIcon(new ImageIcon(Main.class.getResource("/img/users.png")));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes ();
				clientes.setVisible(true);
			}
			
		});
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setBounds(156, 214, 128, 128);
		contentPane.add(btnClientes);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setIcon(new ImageIcon(Main.class.getResource("/img/relatorios.png")));
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setEnabled(false);
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setToolTipText("Relatórios");
		btnRelatorios.setBounds(327, 214, 128, 128);
		contentPane.add(btnRelatorios);
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBackground(new Color(102, 205, 170));
		panelUsuarios.setBounds(0, 368, 624, 77);
		contentPane.add(panelUsuarios);
		panelUsuarios.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(29, 34, 65, 14);
		panelUsuarios.add(lblNewLabel);
		
		lblUsuario = new JLabel("");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(79, 34, 158, 14);
		panelUsuarios.add(lblUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(492, -20, 132, 133);
		panelUsuarios.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/img/icon120x120.png")));
		
		btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/img/about.png")));
		btnNewButton.setToolTipText("Sobre:");
		btnNewButton.setBounds(583, 36, 32, 32);
		contentPane.add(btnNewButton);
		
		lblData = new JLabel("");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(56, 11, 559, 14);
		contentPane.add(lblData);
		lblData.setForeground(new Color(255, 255, 255));
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 0, 624, 32);
		contentPane.add(panel);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/img/main.png")));
		lblNewLabel_2.setBounds(-17, -20, 641, 480);
		contentPane.add(lblNewLabel_2);
	}
}

