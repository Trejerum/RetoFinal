package gui.user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.Login;
import gui.all.PanelPerfil;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilUser extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2542411058982798072L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private String nUsuario;
	private JButton btnCerrarSesion;
	private JButton btnEditarGustos;

	/**
	 * Create the frame.
	 */
	public PerfilUser(String usuario) {
		nUsuario = usuario;
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

		// Botón HOME
		btnHome = new JButton("");
		Image house = new ImageIcon(this.getClass().getResource("/home2.png")).getImage();
		Image newhouse = house.getScaledInstance(27, 27, java.awt.Image.SCALE_SMOOTH);
		btnHome.setIcon(new ImageIcon(newhouse));

		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(SystemColor.activeCaption);
		btnHome.setBounds(0, 417, 128, 61);
		contentPane.add(btnHome);

		// Botón BestSellers
		btnBestSellers = new JButton("");
		Image estrella = new ImageIcon(this.getClass().getResource("/favorites.png")).getImage();
		Image newestrella = estrella.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnBestSellers.setIcon(new ImageIcon(newestrella));

		btnBestSellers.setBackground(SystemColor.activeCaption);
		btnBestSellers.setBounds(126, 417, 124, 61);
		contentPane.add(btnBestSellers);

		// Botón Usuario
		btnUsuario = new JButton("");
		Image monigote = new ImageIcon(this.getClass().getResource("/users.png")).getImage();
		Image newmonigote = monigote.getScaledInstance(36, 36, java.awt.Image.SCALE_SMOOTH);
		btnUsuario.setIcon(new ImageIcon(newmonigote));

		btnUsuario.setBackground(new Color(176, 196, 222));
		btnUsuario.setBounds(493, 417, 128, 61);
		contentPane.add(btnUsuario);

		// Botón Compras
		btnCompras = new JButton("");
		Image carrito = new ImageIcon(this.getClass().getResource("/shopping-cart.png")).getImage();
		Image newcarrito = carrito.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnCompras.setIcon(new ImageIcon(newcarrito));

		btnCompras.setBackground(SystemColor.activeCaption);
		btnCompras.setBounds(370, 417, 128, 61);
		contentPane.add(btnCompras);

		// Botón Buscar
		btnBuscar = new JButton("");
		Image lupa = new ImageIcon(this.getClass().getResource("/loupe2.png")).getImage();
		Image newlupa = lupa.getScaledInstance(36, 36, java.awt.Image.SCALE_SMOOTH);
		btnBuscar.setIcon(new ImageIcon(newlupa));

		btnBuscar.setBackground(SystemColor.activeCaption);
		btnBuscar.setBounds(248, 417, 124, 61);
		contentPane.add(btnBuscar);

		PanelPerfil panel = new PanelPerfil(usuario);
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 620, 478);
		contentPane.add(panel);

		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setBounds(494, 30, 117, 23);
		panel.add(btnCerrarSesion);

		btnEditarGustos = new JButton("Editar gustos");
		btnEditarGustos.setBounds(440, 241, 117, 35);
		panel.add(btnEditarGustos);

		btnBestSellers.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnHome.addActionListener(this);
		btnUsuario.addActionListener(this);
		btnCerrarSesion.addActionListener(this);
		btnEditarGustos.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBestSellers) {
			BestSellersUser bestSellers = new BestSellersUser(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnBuscar) {
			BusquedaUser busqueda = new BusquedaUser(nUsuario);
			busqueda.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCompras) {
			ComprasRealizadas compras = new ComprasRealizadas(nUsuario);
			compras.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnHome) {
			InicioUser inicio = new InicioUser(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnCerrarSesion) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnUsuario) {
			PerfilUser perfil = new PerfilUser(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnEditarGustos) {
			GustosUser gustos = new GustosUser(nUsuario);
			gustos.setVisible(true);
			this.dispose();
		}
	}
}
