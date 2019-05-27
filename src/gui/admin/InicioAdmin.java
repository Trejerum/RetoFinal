package gui.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	/**
	 * Create the frame.
	 */
	public InicioAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 215);
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
		lblLibros.setBounds(10, 78, 73, 14);
		contentPane.add(lblLibros);
		
		separator = new JSeparator();
		separator.setBounds(10, 101, 311, 2);
		contentPane.add(separator);
		
		btnBestSellers = new JButton("Best sellers");
		btnBestSellers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBestSellers.setBounds(10, 112, 149, 23);
		contentPane.add(btnBestSellers);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(UIManager.getColor("Button.background"));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(10, 146, 149, 23);
		contentPane.add(btnModificar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.setBounds(184, 112, 153, 23);
		contentPane.add(btnBuscar);
		
		btnAñadir = new JButton("A\u00F1adir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAñadir.setBounds(184, 146, 153, 23);
		contentPane.add(btnAñadir);
		
		lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(156, 15, 55, 12);
		contentPane.add(lblAdmin);
		
		btnModificar.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnAñadir.addActionListener(this);
		btnBestSellers.addActionListener(this);
		btnEditarInfo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {			//TODO Completar action listeners
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
			AnadirLibro añadir = new AnadirLibro(nUsuario);
			añadir.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnBestSellers) {
			BestSellersAdmin bestSellers = new BestSellersAdmin(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		}
		
	}
}
