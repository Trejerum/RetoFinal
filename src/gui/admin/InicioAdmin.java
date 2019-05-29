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

public class InicioAdmin extends JFrame implements ActionListener{

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

	/**
	 * Create the frame.
	 */
	public InicioAdmin(String usuario) {
		nUsuario=usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSesionIniciada = new JLabel("Sesi\u00F3n iniciada como: ");
		lblSesionIniciada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSesionIniciada.setBounds(10, 13, 142, 14);
		contentPane.add(lblSesionIniciada);
		
		btnEditarInfo = new JButton("Editar Info.");
		btnEditarInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarInfo.setBounds(228, 10, 109, 21);
		contentPane.add(btnEditarInfo);
		
		lblLibros = new JLabel("Libros");
		lblLibros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLibros.setBounds(10, 74, 73, 14);
		contentPane.add(lblLibros);
		
		separator = new JSeparator();
		separator.setBounds(10, 99, 311, 2);
		contentPane.add(separator);
		
		btnBestSellers = new JButton("Best sellers");
		btnBestSellers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBestSellers.setBounds(10, 112, 149, 23);
		contentPane.add(btnBestSellers);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(UIManager.getColor("Button.background"));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(10, 156, 149, 23);
		contentPane.add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(220, 112, 153, 23);
		contentPane.add(btnBuscar);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadir.setBounds(220, 156, 153, 23);
		contentPane.add(btnAñadir);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrarSesion.setBounds(122, 218, 142, 46);
		contentPane.add(btnCerrarSesion);
		
		lblAdmin = new JLabel(nUsuario);
		lblAdmin.setBounds(156, 15, 55, 12);
		contentPane.add(lblAdmin);
		
		btnModificar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnAñadir.addActionListener(this);
		btnBestSellers.addActionListener(this);
		btnEditarInfo.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {			
		if(e.getSource()==btnModificar) {
			ListaLibros listaLibros = new ListaLibros(nUsuario);
			listaLibros.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnEditarInfo) {
			PerfilAdmin perfil = new PerfilAdmin(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnBuscar) {
			BusquedaAdmin busqueda = new BusquedaAdmin(nUsuario);
			busqueda.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnAñadir) {
			AnadirLibro anadirLibro = new AnadirLibro(nUsuario);
			anadirLibro.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnBestSellers) {
			BestSellersAdmin bestSellers = new BestSellersAdmin(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnCerrarSesion) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
		
	}
}
