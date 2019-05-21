package gui.all;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class Registro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 900575914733176176L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombreUsuario;
	private JPasswordField pfContraseña;
	private JLabel lblLibreriaVirtual;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblNombreUsuario;
	private JLabel lblContraseña;
	private JButton btnRegistrarme;
	private JSeparator separator;
	private JLabel lblRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLibreriaVirtual = new JLabel("Librer\u00EDa Virtual");
		lblLibreriaVirtual.setForeground(Color.RED);
		lblLibreriaVirtual.setFont(new Font("Maiandra GD", Font.PLAIN, 29));
		lblLibreriaVirtual.setBounds(82, 40, 192, 34);
		contentPane.add(lblLibreriaVirtual);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(38, 147, 46, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(38, 161, 272, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellido(s)");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellidos.setBounds(38, 192, 59, 20);
		contentPane.add(lblApellidos);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(38, 212, 272, 20);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDireccion.setBounds(38, 236, 46, 14);
		contentPane.add(lblDireccion);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(38, 252, 272, 20);
		contentPane.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefono.setBounds(38, 277, 46, 14);
		contentPane.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(38, 295, 272, 20);
		contentPane.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(38, 320, 46, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(38, 336, 272, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setBounds(38, 402, 162, 14);
		contentPane.add(lblNombreUsuario);
		
		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(38, 421, 272, 20);
		contentPane.add(tfNombreUsuario);
		tfNombreUsuario.setColumns(10);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(38, 447, 120, 14);
		contentPane.add(lblContraseña);
		
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setBackground(UIManager.getColor("Button.background"));
		btnRegistrarme.setForeground(new Color(0, 0, 128));
		btnRegistrarme.setBounds(101, 509, 130, 23);
		contentPane.add(btnRegistrarme);
		
		separator = new JSeparator();
		separator.setBounds(38, 381, 272, 2);
		contentPane.add(separator);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(38, 466, 272, 20);
		contentPane.add(pfContraseña);
		
		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistro.setBounds(38, 113, 80, 23);
		contentPane.add(lblRegistro);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
