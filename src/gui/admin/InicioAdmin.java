package gui.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gui.all.Login;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

/**
 * Esta venta es la de inicio del administrador y desde ahi puede hacer todo, es
 * como el pilar de la aplicacion porque te conecta con todas las ventanas
 * 
 * @author EquipoB
 *
 */
public class InicioAdmin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7415743493945038660L;
	private JPanel contentPane;
	private JLabel lblSesionIniciada;
	private JButton btnEditarInfo;
	private JLabel lblLibros;
	private JSeparator separator;
	private JButton btnBestSellers;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnAñadir;
	private JLabel lblAdmin;
	private String nUsuario;
	private JButton btnCerrarSesion;
	private JButton btnMantGeneros;
	private JButton btnMantAutores;

	/**
	 * Create the frame.
	 * 
	 * @param usuario Sirve para mostrarlo por pantalla al usuario
	 */
	public InicioAdmin(String usuario) {
		nUsuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		lblSesionIniciada = new JLabel("Sesi\u00F3n iniciada como: ");
		lblSesionIniciada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSesionIniciada.setBounds(10, 13, 142, 14);
		contentPane.add(lblSesionIniciada);

		// Esta ventana te lleva a editar tus datos del perfil
		btnEditarInfo = new JButton("Editar Info.");
		btnEditarInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarInfo.setBounds(228, 10, 109, 21);
		contentPane.add(btnEditarInfo);

		lblLibros = new JLabel("Libros");
		lblLibros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLibros.setBounds(10, 74, 73, 14);
		contentPane.add(lblLibros);

		// Este separador separa entre la cabezera y el cuerpo
		separator = new JSeparator();
		separator.setBounds(10, 99, 311, 2);
		contentPane.add(separator);

		// Este boton te lleva a la ventana de bestSellers
		btnBestSellers = new JButton("Best sellers");
		btnBestSellers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBestSellers.setBounds(10, 112, 149, 23);
		contentPane.add(btnBestSellers);

		// Este boton sirve para llevarte a la venta de modificar un libro
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(UIManager.getColor("Button.background"));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(10, 156, 149, 23);
		contentPane.add(btnModificar);

		// Este boton te lleva a la ventana de busqueda de libro
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(220, 112, 153, 23);
		contentPane.add(btnBuscar);

		// Este boton sirve para añadir un nuevo libro
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadir.setBounds(220, 156, 153, 23);
		contentPane.add(btnAñadir);

		// Este boton sirve para cerrar sesion
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrarSesion.setBounds(116, 299, 142, 46);
		contentPane.add(btnCerrarSesion);

		// Aqui aparece quien ha iniciado sesion
		lblAdmin = new JLabel(nUsuario);
		lblAdmin.setBounds(156, 15, 55, 12);
		contentPane.add(lblAdmin);

		// Este boton te lleva a la ventana de mantenimiento de autores
		btnMantAutores = new JButton("Mantenimiento autores");
		btnMantAutores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMantAutores.setBounds(92, 209, 196, 23);
		contentPane.add(btnMantAutores);

		// Este boton te lleva a la ventana de mantenimiento de generos
		btnMantGeneros = new JButton("Mantenimiento generos");
		btnMantGeneros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMantGeneros.setBounds(92, 245, 196, 23);
		contentPane.add(btnMantGeneros);

		// Action Listener para los botones
		btnModificar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnAñadir.addActionListener(this);
		btnBestSellers.addActionListener(this);
		btnEditarInfo.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
		btnMantAutores.addActionListener(this);
		btnMantGeneros.addActionListener(this);

	}

	@Override
	/**
	 * Aqui se dan funciones a los botones, que sirve para navegar entre diferentes
	 * ventanas
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			ListaLibros listaLibros = new ListaLibros(nUsuario);
			listaLibros.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnEditarInfo) {
			PerfilAdmin perfil = new PerfilAdmin(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnBuscar) {
			BusquedaAdmin busqueda = new BusquedaAdmin(nUsuario);
			busqueda.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnAñadir) {
			AnadirLibro anadirLibro = new AnadirLibro(nUsuario);
			anadirLibro.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnBestSellers) {
			BestSellersAdmin bestSellers = new BestSellersAdmin(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCerrarSesion) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnMantAutores) {
			MantAutores autores = new MantAutores(nUsuario);
			autores.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnMantGeneros) {
			MantGeneros generos = new MantGeneros(nUsuario);
			generos.setVisible(true);
			this.dispose();
		}

	}
}
