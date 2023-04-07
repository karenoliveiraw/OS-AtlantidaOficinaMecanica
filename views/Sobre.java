package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class Sobre.
 */
public class Sobre extends JDialog {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/icon120x120.png")));
		setTitle("Sobre");
		setBounds(100, 100, 578, 301);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Sobre.class.getResource("/img/licensemit.png")));
		btnNewButton.setToolTipText("Licença MIT");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(195, 139, 124, 124);
		getContentPane().add(btnNewButton);
		
		JTextPane txtpnAEmpresaFoi = new JTextPane();
		txtpnAEmpresaFoi.setText("Projeto desenvolvido no Senac Tatuapé na UC 12");
		txtpnAEmpresaFoi.setSize(new Dimension(4, 0));
		txtpnAEmpresaFoi.setOpaque(false);
		txtpnAEmpresaFoi.setForeground(Color.BLACK);
		txtpnAEmpresaFoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnAEmpresaFoi.setBounds(103, 106, 310, 22);
		getContentPane().add(txtpnAEmpresaFoi);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sobre.class.getResource("/img/icon120x120.png")));
		lblNewLabel.setBounds(210, 39, 192, 53);
		getContentPane().add(lblNewLabel);
		
		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setLayout(null);
		panelUsuarios.setBackground(new Color(32, 178, 170));
		panelUsuarios.setBounds(0, 0, 562, 20);
		getContentPane().add(panelUsuarios);
		
		JPanel panelUsuarios_1 = new JPanel();
		panelUsuarios_1.setLayout(null);
		panelUsuarios_1.setBackground(new Color(32, 178, 170));
		panelUsuarios_1.setBounds(0, 244, 562, 20);
		getContentPane().add(panelUsuarios_1);
		
		JTextPane txtpnOrdemDeServio = new JTextPane();
		txtpnOrdemDeServio.setText(" Ordem de serviço para uma oficina de carros.");
		txtpnOrdemDeServio.setSize(new Dimension(4, 0));
		txtpnOrdemDeServio.setOpaque(false);
		txtpnOrdemDeServio.setForeground(Color.BLACK);
		txtpnOrdemDeServio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnOrdemDeServio.setBounds(113, 125, 289, 53);
		getContentPane().add(txtpnOrdemDeServio);
		
		JTextPane txtpnDevsCelsoKaren = new JTextPane();
		txtpnDevsCelsoKaren.setText("Devs: Celso. Karen e Luiz");
		txtpnDevsCelsoKaren.setSize(new Dimension(4, 0));
		txtpnDevsCelsoKaren.setOpaque(false);
		txtpnDevsCelsoKaren.setForeground(Color.BLACK);
		txtpnDevsCelsoKaren.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnDevsCelsoKaren.setBounds(159, 146, 289, 53);
		getContentPane().add(txtpnDevsCelsoKaren);
		
		JTextPane txtpnVerso = new JTextPane();
		txtpnVerso.setText("Versão: 1.0");
		txtpnVerso.setSize(new Dimension(4, 0));
		txtpnVerso.setOpaque(false);
		txtpnVerso.setForeground(Color.BLACK);
		txtpnVerso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnVerso.setBounds(0, 221, 289, 53);
		getContentPane().add(txtpnVerso);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/img/sobre.png")));
		lblNewLabel_1.setBounds(-16, -53, 578, 304);
		getContentPane().add(lblNewLabel_1);

	}
}

