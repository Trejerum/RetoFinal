package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import model.Usuario;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class PerfilUser extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 2542411058982798072L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfUsuario;
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
	private JLabel lblContraseña;
	private JButton btnEditar;
	private String nUsuario;

	/**
	 * Create the frame.
	 */
	public PerfilUser(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 417, 620, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(0, 204, 51));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 417, 128, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(0, 204, 51));
		btnBestSellers.setBounds(126, 417, 124, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(0, 153, 51));
		btnUsuario.setBounds(493, 417, 128, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(0, 204, 51));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(370, 417, 128, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(0, 204, 51));
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
		lblNombreDeUsuario.setBounds(102, 256, 50, 14);
		contentPane.add(lblNombreDeUsuario);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setForeground(new Color(0, 0, 0));
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfNombre.setBounds(160, 99, 145, 14);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(91, 99, 61, 14);
		contentPane.add(lblNombre);
		
		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardar.setForeground(new Color(0, 0, 255));
		btnGuardar.setBounds(417, 184, 167, 34);
		contentPane.add(btnGuardar);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(91, 120, 56, 22);
		contentPane.add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setEditable(false);
		tfApellidos.setForeground(new Color(0, 0, 0));
		tfApellidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(160, 127, 145, 14);
		contentPane.add(tfApellidos);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(86, 153, 61, 14);
		contentPane.add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setEditable(false);
		tfDireccion.setForeground(new Color(0, 0, 0));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(160, 157, 145, 14);
		contentPane.add(tfDireccion);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(91, 184, 57, 14);
		contentPane.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setEditable(false);
		tfTelefono.setForeground(new Color(0, 0, 0));
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(160, 184, 145, 14);
		contentPane.add(tfTelefono);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(108, 215, 42, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setEditable(false);
		tfEmail.setForeground(new Color(0, 0, 0));
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfEmail.setColumns(10);
		tfEmail.setBounds(160, 215, 145, 14);
		contentPane.add(tfEmail);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		tfUsuario.setForeground(new Color(0, 0, 0));
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(160, 256, 145, 14);
		contentPane.add(tfUsuario);
		
		lblContraseña = new JLabel("Contrase\u00F1a: ");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseña.setBounds(75, 290, 79, 14);
		contentPane.add(lblContraseña);
		
		tfContraseña = new JTextField();
		tfContraseña.setEditable(false);
		tfContraseña.setForeground(new Color(0, 0, 0));
		tfContraseña.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(160, 290, 145, 14);
		contentPane.add(tfContraseña);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditar.setBounds(418, 98, 167, 73);
		contentPane.add(btnEditar);
		
		btnBestSellers.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnEditar.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnHome.addActionListener(this);
		
		cargarDatos();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBestSellers) {
			BestSellersUser bestSellers = new BestSellersUser();
			bestSellers.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnBuscar) {
			BusquedaUser busqueda = new BusquedaUser();
			busqueda.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnCompras) {
			ComprasRealizadas compras = new ComprasRealizadas();
			compras.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnHome) {
			InicioUser inicio = new InicioUser(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnEditar) {
			editar();
		}
		else {
			guardarCambios();
		}
	}
	
	public void editar() {
		tfNombre.setEditable(true);
		tfApellidos.setEditable(true);
		tfDireccion.setEditable(true);
		tfEmail.setEditable(true);
		tfTelefono.setEditable(true);
		tfUsuario.setEditable(true);
		tfContraseña.setEditable(true);
		tfNombre.setForeground(new Color(0, 0, 205));
		tfApellidos.setForeground(new Color(0, 0, 205));
		tfDireccion.setForeground(new Color(0, 0, 205));
		tfEmail.setForeground(new Color(0, 0, 205));
		tfTelefono.setForeground(new Color(0, 0, 205));
		tfUsuario.setForeground(new Color(0, 0, 205));
		tfContraseña.setForeground(new Color(0, 0, 205));
		btnGuardar.setEnabled(true);
	}
	
	public void guardarCambios() {
		try {
			Logic logic = LogicFactory.getLogic();
			Usuario usuario = new Usuario();
			usuario.setNombre(tfNombre.getText());
			usuario.setApellidos(tfApellidos.getText());
			usuario.setDireccion(tfDireccion.getText());
			usuario.setEmail(tfEmail.getText());
			usuario.setTelefono(tfTelefono.getText());	//TODO resolver error (cambiar el tipo a int)
			usuario.setContraseña(tfContraseña.getText());
			usuario.setNombreUsuario(tfUsuario.getText());
			
		}catch(Exception e) {
			String message="Error. No se ha podido realizar el guardado";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void cargarDatos() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			Usuario usuario = new Usuario();
			usuario = logic.cargarUsuario(nUsuario);
			tfNombre.setText(usuario.getNombre());
			tfApellidos.setText(usuario.getApellidos());
			tfDireccion.setText(usuario.getDireccion());
			tfEmail.setText(usuario.getEmail());
			tfUsuario.setText(usuario.getNombreUsuario());
			tfContraseña.setText(usuario.getContraseña());
			tfTelefono.setText(String.valueOf(usuario.getTelefono()));
			
		}catch(Exception e) {
			message="Error. No se pudo cargar el usuario";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
