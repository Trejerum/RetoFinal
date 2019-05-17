package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class PerfilAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023274207853491447L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfContraseña;
	private JLabel lblEditarInfo;
	private JSeparator separator;
	private JLabel lblNombreDeUsuario;
	private JLabel lblNombre;
	private JButton btnGuardarCambios;
	private JLabel lblApellidos;
	private JLabel lblDireccin;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAdmin frame = new PerfilAdmin();
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
	public PerfilAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 399);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEditarInfo = new JLabel("Editar informaci\u00F3n");
		lblEditarInfo.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblEditarInfo.setBounds(20, 13, 255, 37);
		contentPane.add(lblEditarInfo);
		
		separator = new JSeparator();
		separator.setBounds(0, 56, 784, 2);
		contentPane.add(separator);
		
		lblNombreDeUsuario = new JLabel("Usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeUsuario.setBounds(92, 99, 50, 14);
		contentPane.add(lblNombreDeUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		tfUsuario.setForeground(new Color(0, 0, 205));
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUsuario.setBounds(161, 99, 145, 14);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(87, 275, 61, 14);
		contentPane.add(lblNombre);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setEnabled(false);
		btnGuardarCambios.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardarCambios.setForeground(new Color(0, 0, 255));
		btnGuardarCambios.setBounds(350, 141, 167, 31);
		contentPane.add(btnGuardarCambios);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(85, 127, 56, 22);
		contentPane.add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setForeground(new Color(0, 0, 205));
		tfApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(161, 131, 145, 14);
		contentPane.add(tfApellidos);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(80, 167, 61, 14);
		contentPane.add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setForeground(new Color(0, 0, 205));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(161, 167, 145, 14);
		contentPane.add(tfDireccion);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(83, 203, 57, 14);
		contentPane.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setForeground(new Color(0, 0, 205));
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(161, 203, 145, 14);
		contentPane.add(tfTelefono);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(99, 239, 42, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setForeground(new Color(0, 0, 205));
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEmail.setColumns(10);
		tfEmail.setBounds(161, 239, 145, 14);
		contentPane.add(tfEmail);
		
		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(0, 0, 205));
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNombre.setColumns(10);
		tfNombre.setBounds(161, 275, 145, 14);
		contentPane.add(tfNombre);
		
		lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(65, 309, 79, 14);
		contentPane.add(lblContrasea);
		
		tfContraseña = new JTextField();
		tfContraseña.setForeground(new Color(0, 0, 205));
		tfContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(161, 311, 145, 14);
		contentPane.add(tfContraseña);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCancelar.setBounds(351, 99, 167, 31);
		contentPane.add(btnCancelar);
		
		
		
		
		
	}
}
