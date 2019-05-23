package gui.all;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.Logic;
import control.LogicFactory;
import model.Usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPerfil extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2213188828851106990L;
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
	private JButton btnGuardar;
	private JLabel lblApellidos;
	private JLabel lblDireccin;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JButton btnCancelar;
	private String nUsuario;
	private JButton btnEditar;
	/**
	 * Create the panel.
	 */
	public PanelPerfil(String usuario) {
		setBackground(new Color(0, 153, 51));
		
		setLayout(null);
		nUsuario=usuario;
		JLabel label = new JLabel("Perfil");
		label.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		label.setBounds(24, 11, 68, 37);
		add(label);
		
		separator = new JSeparator();
		separator.setBounds(0, 56, 784, 2);
		add(separator);

		lblNombreDeUsuario = new JLabel("Usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeUsuario.setBounds(92, 99, 50, 14);
		add(lblNombreDeUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		tfUsuario.setForeground(new Color(0, 0, 205));
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUsuario.setBounds(161, 99, 145, 14);
		add(tfUsuario);
		tfUsuario.setColumns(10);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(87, 275, 61, 14);
		add(lblNombre);
		
		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardar.setForeground(new Color(0, 0, 255));
		btnGuardar.setBounds(418, 196, 167, 31);
		add(btnGuardar);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(85, 127, 56, 22);
		add(lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setForeground(new Color(0, 0, 205));
		tfApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(161, 131, 145, 14);
		add(tfApellidos);
		
		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDireccin.setBounds(80, 167, 61, 14);
		add(lblDireccin);
		
		tfDireccion = new JTextField();
		tfDireccion.setForeground(new Color(0, 0, 205));
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(161, 167, 145, 14);
		add(tfDireccion);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(83, 203, 57, 14);
		add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setForeground(new Color(0, 0, 205));
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(161, 203, 145, 14);
		add(tfTelefono);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(99, 239, 42, 14);
		add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setForeground(new Color(0, 0, 205));
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEmail.setColumns(10);
		tfEmail.setBounds(161, 239, 145, 14);
		add(tfEmail);
		
		tfNombre = new JTextField();
		tfNombre.setForeground(new Color(0, 0, 205));
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfNombre.setColumns(10);
		tfNombre.setBounds(161, 275, 145, 14);
		add(tfNombre);
		
		lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(65, 309, 79, 14);
		add(lblContrasea);
		
		tfContraseña = new JTextField();
		tfContraseña.setForeground(new Color(0, 0, 205));
		tfContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(161, 311, 145, 14);
		add(tfContraseña);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditar.setBounds(418, 98, 167, 73);
		add(btnEditar);
		
		btnEditar.addActionListener(this);
		
		cargarDatos();
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
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			Usuario usuario = new Usuario();
			usuario.setNombre(tfNombre.getText());
			usuario.setApellidos(tfApellidos.getText());
			usuario.setDireccion(tfDireccion.getText());
			usuario.setEmail(tfEmail.getText());
			usuario.setTelefono(Integer.parseInt(tfTelefono.getText()));
			usuario.setContraseña(tfContraseña.getText());
			usuario.setNombreUsuario(tfUsuario.getText());
			logic.guardarCambios(usuario, nUsuario);
			message="Modificacion realizada correctamente";
			JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
			nUsuario=usuario.getNombreUsuario();
			tfNombre.setEditable(false);
			tfApellidos.setEditable(false);
			tfDireccion.setEditable(false);
			tfEmail.setEditable(false);
			tfTelefono.setEditable(false);
			tfUsuario.setEditable(false);
			tfContraseña.setEditable(false);
			tfNombre.setForeground(new Color(0, 0, 0));
			tfApellidos.setForeground(new Color(0, 0, 0));
			tfDireccion.setForeground(new Color(0, 0, 0));
			tfEmail.setForeground(new Color(0, 0, 0));
			tfTelefono.setForeground(new Color(0, 0, 0));
			tfUsuario.setForeground(new Color(0, 0, 0));
			tfContraseña.setForeground(new Color(0, 0, 0));
			btnGuardar.setEnabled(false);
			
		}catch(Exception e) {
			message="Error. No se ha podido realizar el guardado";
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
			
		}catch(Exception e) {
			message="Error. No se pudo cargar el usuario";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEditar) {
			editar();
		}
		else {
			guardarCambios();
		}
		
	}
}

	

