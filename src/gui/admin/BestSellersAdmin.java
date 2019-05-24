package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.PanelBestSellers;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.time.LocalDate;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class BestSellersAdmin extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5008628838388360466L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnVolver;
	private JButton btnBuscarLibro;
	private JLabel lblSesionIniciada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestSellersAdmin frame = new BestSellersAdmin();
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
	public BestSellersAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 526);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 420, 784, 2);
		contentPane.add(menu_separator);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(65, 439, 167, 31);
		contentPane.add(btnVolver);
		
		btnBuscarLibro = new JButton("Buscar libro");
		btnBuscarLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarLibro.setBounds(241, 439, 167, 31);
		contentPane.add(btnBuscarLibro);
		
		lblSesionIniciada = new JLabel("Sesi\u00F3n iniciada como: ");
		lblSesionIniciada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSesionIniciada.setBounds(26, 11, 134, 14);
		contentPane.add(lblSesionIniciada);
		
		PanelBestSellers panel = new PanelBestSellers();
		panel.setBounds(0, 0, 784, 488);
		contentPane.add(panel);
		
		JLabel lblnameAdmin = new JLabel("");
		lblnameAdmin.setBounds(170, 11, 87, 16);
		panel.add(lblnameAdmin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
