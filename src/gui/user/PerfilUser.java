package gui.user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class PerfilUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2542411058982798072L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfNCuenta;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombre;
	private JTextField tfContraseña;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JLabel lblPerfil;
	private JSeparator separator;
	private JLabel lblNombreDeUsuario;
	private JLabel lblNombre;
	private JButton btnGuardar;
	private JLabel lblApellidos;
	private JLabel lblDireccin;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblNumeroDeCuenta;
	private JLabel lblContraseña;
	private JButton btnEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUser frame = new PerfilUser();
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
	public PerfilUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 417, 620, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(245, 245, 220));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 417, 128, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(245, 245, 220));
		btnBestSellers.setBounds(126, 417, 124, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(245, 222, 179));
		btnUsuario.setBounds(493, 417, 128, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(245, 245, 220));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(370, 417, 128, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(245, 245, 220));
		btnBuscar.setBounds(248, 417, 124, 61);
		contentPane.add(btnBuscar);
		
		lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblPerfil.setBounds(24, 11, 68, 37);
		contentPane.add(lblPerfil);
		
		separator = new JSeparator();
		separator.setBounds(0, 56, 784, 2);
		contentPane.add(separator);
		
		lblNombreDeUsuario = new JLabel("Usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeUsuario.setBounds(91, 99, 50, 14);
		contentPane.add(lblNombreDeUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		tfUsuario.setForeground(new Color(0, 0, 205));
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUsuario.setBounds(160, 99, 145, 14);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(86, 315, 61, 14);
		contentPane.add(lblNombre);
		
		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardar.setForeground(new Color(0, 0, 255));
		btnGuardar.setBounds(417, 187, 167, 31);
		contentPane.add(btnGuardar);
		
		tfNCuenta = new JTextField();
		tfNCuenta.setEditable(false);
		tfNCuenta.setForeground(new Color(0, 0, 205));
		tfNCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNCuenta.setColumns(10);
		tfNCuenta.setBounds(160, 135, 145, 14);
		contentPane.add(tfNCuenta);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(84, 167, 56, 22);
		contentPane.add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setEditable(false);
		tfApellidos.setForeground(new Color(0, 0, 205));
		tfApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(160, 171, 145, 14);
		contentPane.add(tfApellidos);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(79, 207, 61, 14);
		contentPane.add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setEditable(false);
		tfDireccion.setForeground(new Color(0, 0, 205));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(160, 207, 145, 14);
		contentPane.add(tfDireccion);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(82, 243, 57, 14);
		contentPane.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setEditable(false);
		tfTelefono.setForeground(new Color(0, 0, 205));
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(160, 243, 145, 14);
		contentPane.add(tfTelefono);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(98, 279, 42, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setForeground(new Color(0, 0, 205));
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEmail.setColumns(10);
		tfEmail.setBounds(160, 279, 145, 14);
		contentPane.add(tfEmail);
		
		lblNumeroDeCuenta = new JLabel("N\u00BA de cuenta: ");
		lblNumeroDeCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeCuenta.setBounds(54, 135, 90, 14);
		contentPane.add(lblNumeroDeCuenta);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setForeground(new Color(0, 0, 205));
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNombre.setColumns(10);
		tfNombre.setBounds(160, 315, 145, 14);
		contentPane.add(tfNombre);
		
		lblContraseña = new JLabel("Contrase\u00F1a: ");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseña.setBounds(64, 349, 79, 14);
		contentPane.add(lblContraseña);
		
		tfContraseña = new JTextField();
		tfContraseña.setEditable(false);
		tfContraseña.setForeground(new Color(0, 0, 205));
		tfContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(160, 351, 145, 14);
		contentPane.add(tfContraseña);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditar.setBounds(418, 98, 167, 73);
		contentPane.add(btnEditar);
		
		
		
		
		
	}
}
