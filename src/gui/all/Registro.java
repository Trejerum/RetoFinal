package gui.all;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JButton btnVolver;
	private JPasswordField pfConfirmar;

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
		setBounds(100, 100, 363, 682);
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
		lblNombre.setBounds(38, 129, 46, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(38, 143, 272, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellido(s)");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellidos.setBounds(38, 174, 59, 20);
		contentPane.add(lblApellidos);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(38, 192, 272, 20);
		contentPane.add(tfApellido);
		tfApellido.setColumns(10);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDireccion.setBounds(38, 223, 46, 14);
		contentPane.add(lblDireccion);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(38, 237, 272, 20);
		contentPane.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefono.setBounds(38, 264, 46, 14);
		contentPane.add(lblTelefono);
		
		tfTelefono = new JTextField();
		tfTelefono.setBounds(38, 278, 272, 20);
		contentPane.add(tfTelefono);
		tfTelefono.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(38, 309, 46, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(38, 325, 272, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setBounds(38, 379, 162, 14);
		contentPane.add(lblNombreUsuario);
		
		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(38, 395, 272, 20);
		contentPane.add(tfNombreUsuario);
		tfNombreUsuario.setColumns(10);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setBounds(38, 426, 120, 14);
		contentPane.add(lblContraseña);
		
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setBackground(UIManager.getColor("Button.background"));
		btnRegistrarme.setForeground(new Color(0, 0, 128));
		btnRegistrarme.setBounds(101, 538, 130, 35);
		contentPane.add(btnRegistrarme);
		
		separator = new JSeparator();
		separator.setBounds(38, 366, 272, 2);
		contentPane.add(separator);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(38, 441, 272, 20);
		contentPane.add(pfContraseña);
		
		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistro.setBounds(38, 95, 80, 23);
		contentPane.add(lblRegistro);
		
		btnVolver = new JButton("VOLVER ATRAS");
		btnVolver.setBounds(101, 596, 130, 23);
		contentPane.add(btnVolver);
		
		JLabel lblConfirmar = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmar.setBounds(38, 472, 147, 14);
		contentPane.add(lblConfirmar);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(38, 486, 272, 20);
		contentPane.add(pfConfirmar);
		
		btnRegistrarme.addActionListener(this);
		btnVolver.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrarme) {
			registrarUsuario();
		}
		else {
			volverAtras();
		}
	}
	
	public void registrarUsuario() {
		String message;
		String contraseña = new String(pfContraseña.getPassword());
		String confirmacion = new String(pfConfirmar.getPassword());
		if(contraseña.equalsIgnoreCase(confirmacion)&&contraseña!=null) {
			Usuario usuario = new Usuario();
			usuario.setNombre(tfNombre.getText());
			usuario.setApellidos(tfApellido.getText());
			usuario.setDireccion(tfDireccion.getText());
			usuario.setEmail(tfEmail.getText());
			usuario.setTelefono(Integer.parseInt(tfTelefono.getText()));
			usuario.setNombreUsuario(tfNombreUsuario.getText());
			usuario.setContraseña(new String(pfContraseña.getPassword()));
			Logic logic = LogicFactory.getLogic();
			try {
				Boolean repetido = logic.comprobarNUsuario(usuario.getNombreUsuario());
				if(repetido) {
					message="ERROR. El nombre de usuario ya esta en uso";
					JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					logic.registrarUsuario(usuario);
				}
			} catch (Exception ex) {
				message="Error";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
				this.dispose();
				System.exit(0);
			}
		}
		else {
			message="ERROR. Las contraseñas no coinciden";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void volverAtras() {
		Login login = new Login();
		login.setVisible(true);
		this.dispose();
	}
}
