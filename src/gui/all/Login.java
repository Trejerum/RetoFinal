package gui.all;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	private JLabel lblRegistrarse;
	private JLabel lblAqui;

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
		
		lblRegistrarse = new JLabel("Si no tienes una cuenta, reg\u00EDstrese gratuitamente ");
		lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRegistrarse.setBounds(51, 369, 241, 14);
		contentPane.add(lblRegistrarse);
		
		lblAqui = new JLabel("aqu\u00ED");
		lblAqui.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAqui.setForeground(Color.RED);
		lblAqui.setBounds(291, 369, 27, 14);
		contentPane.add(lblAqui);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setBounds(54, 283, 252, 20);
		contentPane.add(pfContraseña);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
