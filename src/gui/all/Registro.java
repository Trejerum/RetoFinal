package gui.all;

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
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JList;

public class Registro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 900575914733176176L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfEmail;
	private JTextField tfNombreUsuario;
	private JPasswordField pfContrase�a;
	private JLabel lblLibreriaVirtual;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblNombreUsuario;
	private JLabel lblContrase�a;
	private JButton btnRegistrarme;
	private JSeparator separator;
	private JLabel lblRegistro;
	private JButton btnVolver;
	private JPasswordField pfConfirmar;
	private JList<String> listaGeneros;
	private JList<String> listaAutores;
	private JLabel lblAutores;
	private JLabel lblGeneros;
	private JScrollPane scrollPane;
	private JTextField tfNumCuenta;
	private JLabel lblNumeroDeCuenta;

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
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
		lblNombreUsuario.setBounds(38, 414, 162, 14);
		contentPane.add(lblNombreUsuario);

		tfNombreUsuario = new JTextField();
		tfNombreUsuario.setBounds(38, 439, 272, 20);
		contentPane.add(tfNombreUsuario);
		tfNombreUsuario.setColumns(10);

		lblContrase�a = new JLabel("Contrase\u00F1a");
		lblContrase�a.setBounds(38, 470, 120, 14);
		contentPane.add(lblContrase�a);

		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setBackground(UIManager.getColor("Button.background"));
		btnRegistrarme.setForeground(new Color(0, 0, 128));
		btnRegistrarme.setBounds(101, 603, 130, 35);
		contentPane.add(btnRegistrarme);

		separator = new JSeparator();
		separator.setBounds(38, 401, 272, 2);
		contentPane.add(separator);

		pfContrase�a = new JPasswordField();
		pfContrase�a.setBounds(38, 495, 272, 20);
		contentPane.add(pfContrase�a);

		lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistro.setBounds(38, 95, 80, 23);
		contentPane.add(lblRegistro);

		btnVolver = new JButton("VOLVER ATRAS");
		btnVolver.setBounds(101, 649, 130, 23);
		contentPane.add(btnVolver);

		JLabel lblConfirmar = new JLabel("Confirmar contrase\u00F1a");
		lblConfirmar.setBounds(38, 526, 147, 14);
		contentPane.add(lblConfirmar);

		pfConfirmar = new JPasswordField();
		pfConfirmar.setBounds(38, 551, 272, 20);
		contentPane.add(pfConfirmar);

		JLabel lblGustos = new JLabel("Gustos");
		lblGustos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGustos.setBounds(434, 99, 59, 14);
		contentPane.add(lblGustos);

		lblAutores = new JLabel("Autores");
		lblAutores.setBounds(434, 351, 46, 14);
		contentPane.add(lblAutores);

		lblGeneros = new JLabel("Generos");
		lblGeneros.setBounds(434, 160, 52, 14);
		contentPane.add(lblGeneros);

		cargarGenerosAutores();

		JScrollPane spGeneros = new JScrollPane();
		spGeneros.setBounds(387, 192, 162, 117);
		contentPane.add(spGeneros);
		spGeneros.setViewportView(listaGeneros);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 395, 162, 111);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(listaAutores);

		tfNumCuenta = new JTextField();
		tfNumCuenta.setBounds(38, 370, 272, 20);
		contentPane.add(tfNumCuenta);
		tfNumCuenta.setColumns(10);

		lblNumeroDeCuenta = new JLabel("Numero de cuenta");
		lblNumeroDeCuenta.setBounds(38, 351, 120, 14);
		contentPane.add(lblNumeroDeCuenta);

		btnRegistrarme.addActionListener(this);
		btnVolver.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarme) {
			registrarUsuario();
		} else {
			volverAtras();
		}
	}

	public void cargarGenerosAutores() {

		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<String> generosStr = new ArrayList<String>();
			ArrayList<String> autoresStr = new ArrayList<String>();
			generosStr = logic.cargarGeneros();
			autoresStr = logic.cargarAutores();

			DefaultListModel<String> modeloGen = new DefaultListModel<String>();
			for (String s : generosStr) {
				modeloGen.addElement(s);
			}
			DefaultListModel<String> modeloAut = new DefaultListModel<String>();
			for (String s : autoresStr) {
				modeloAut.addElement(s);
			}

			listaGeneros = new JList<String>(modeloGen);
			listaAutores = new JList<String>(modeloAut);

		} catch (Exception e) {
			String message = "Error. No se han podido cargar los generos y autores";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			this.dispose();
			System.exit(0);
		}
	}

	public void registrarUsuario() {
		String message;
		try {
			String contrase�a = new String(pfContrase�a.getPassword());
			String confirmacion = new String(pfConfirmar.getPassword());
			if (contrase�a.equalsIgnoreCase(confirmacion)) {
				Usuario usuario = new Usuario();
				usuario.setNombre(tfNombre.getText());
				usuario.setApellidos(tfApellido.getText());
				usuario.setDireccion(tfDireccion.getText());
				usuario.setEmail(tfEmail.getText());
				usuario.setTelefono(Integer.parseInt(tfTelefono.getText()));
				usuario.setNombreUsuario(tfNombreUsuario.getText());
				usuario.setContrase�a(new String(pfContrase�a.getPassword()));
				usuario.setNumCuenta(Integer.parseInt(tfNumCuenta.getText()));
				ArrayList<String> autoresSelec = (ArrayList<String>) listaAutores.getSelectedValuesList();
				ArrayList<String> generosSelec = (ArrayList<String>) listaGeneros.getSelectedValuesList();
				Logic logic = LogicFactory.getLogic();
				try {
					Boolean repetido = logic.comprobarNUsuario(usuario.getNombreUsuario());
					if (repetido) {
						message = "Error. El nombre de usuario ya esta en uso";
						JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						message = "Se ha registrado correctamente";
						logic.registrarUsuario(usuario, autoresSelec, generosSelec);
						JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);

					}
				} catch (Exception ex) {
					message = "Error. No se ha podido registrar el usuario";
					JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					this.dispose();
					System.exit(0);
				}
			} else {
				message = "Error. Las contrase�as no coinciden";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			message = "Error. Por favor rellene todas las casillas";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void volverAtras() {
		Login login = new Login();
		login.setVisible(true);
		this.dispose();
	}
}
