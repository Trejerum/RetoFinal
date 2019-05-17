package gui.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class InicioAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7415743493945038660L;
	private JPanel contentPane;
	private JTextField txtDiego;
	private JLabel lblSesionIniciada;
	private JButton btnEditarInfo;
	private JLabel lblLibros;
	private JSeparator separator;
	private JButton btnBestSellers;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnA�adir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioAdmin frame = new InicioAdmin();
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
	public InicioAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSesionIniciada = new JLabel("Sesi\u00F3n iniciada como: ");
		lblSesionIniciada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSesionIniciada.setBounds(10, 13, 142, 14);
		contentPane.add(lblSesionIniciada);
		
		txtDiego = new JTextField();
		txtDiego.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiego.setText("Diego");
		txtDiego.setBounds(152, 11, 42, 20);
		contentPane.add(txtDiego);
		txtDiego.setColumns(10);
		
		btnEditarInfo = new JButton("Editar Info.");
		btnEditarInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarInfo.setBounds(213, 12, 109, 21);
		contentPane.add(btnEditarInfo);
		
		lblLibros = new JLabel("Libros");
		lblLibros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLibros.setBounds(10, 78, 73, 14);
		contentPane.add(lblLibros);
		
		separator = new JSeparator();
		separator.setBounds(10, 101, 311, 2);
		contentPane.add(separator);
		
		btnBestSellers = new JButton("Best sellers");
		btnBestSellers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBestSellers.setBounds(10, 112, 142, 23);
		contentPane.add(btnBestSellers);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(10, 146, 142, 23);
		contentPane.add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(180, 112, 142, 23);
		contentPane.add(btnBuscar);
		
		btnA�adir = new JButton("A\u00F1adir");
		btnA�adir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnA�adir.setBounds(180, 148, 142, 23);
		contentPane.add(btnA�adir);
	}
}
