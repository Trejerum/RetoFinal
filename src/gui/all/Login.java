package gui.all;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import gui.admin.InicioAdmin;
import gui.user.InicioUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1420215672832566793L;
	private JPanel contentPane;
	private JTextField tfNombreUsurio;
	private JPasswordField pfContraseña;
	private JLabel lblLibreria;
	private JLabel lblLogin;
	private JLabel lblNombreUsuario;
	private JLabel lblContraseña;
	private JButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLibreria = new JLabel("Librer\u00EDa Virtual");
		lblLibreria.setForeground(Color.RED);
		lblLibreria.setFont(new Font("Maiandra GD", Font.PLAIN, 33));
		lblLibreria.setBounds(81, 60, 211, 56);
		contentPane.add(lblLibreria);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogin.setBounds(54, 168, 53, 23);
		contentPane.add(lblLogin);
		
		lblNombreUsuario = new JLabel("Nombre de usuario");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreUsuario.setBounds(54, 208, 141, 14);
		contentPane.add(lblNombreUsuario);
		
		tfNombreUsurio = new JTextField();
		tfNombreUsurio.setBounds(53, 227, 253, 20);
		contentPane.add(tfNombreUsurio);
		tfNombreUsurio.setColumns(10);
		
		lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseña.setBounds(54, 264, 88, 19);
		contentPane.add(lblContraseña);
		
		btnIniciarSesion = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIniciarSesion.setBounds(105, 324, 148, 23);
		contentPane.add(btnIniciarSesion);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(54, 283, 252, 20);
		contentPane.add(pfContraseña);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setBounds(105, 358, 148, 23);
		contentPane.add(btnRegistrarse);
		
		btnIniciarSesion.addActionListener(this);
		btnRegistrarse.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIniciarSesion) {
			validarUsuario();
		}
		else {
			registrarUsuario();
		}
		
	}
	
	public void validarUsuario() {
		String nUsuario=tfNombreUsurio.getText();
		String contraseña=new String(pfContraseña.getPassword());
		Boolean esAdmin = false;
		Logic logic = LogicFactory.getLogic();
		try {
			boolean validado=logic.validarUsuario(nUsuario, contraseña);
			esAdmin=logic.esAdmin(nUsuario);
			if(validado) {
				if(esAdmin) {
					InicioAdmin admin = new InicioAdmin(nUsuario);
					admin.setVisible(true);
					this.dispose();
				}
				else {
					InicioUser inicio = new InicioUser(nUsuario);
					inicio.setVisible(true);
					this.dispose();
				}
			}
			else {
				String message="Error. El nombre de usuario o contraseña son incorrectos";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			String message="Error. No se ha podido validar el usuario";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
			this.dispose();
			System.exit(0);
		}
	}
	
	public void registrarUsuario() {
		Registro registro = new Registro();
		registro.setVisible(true);
		this.dispose();
	}

	
}
