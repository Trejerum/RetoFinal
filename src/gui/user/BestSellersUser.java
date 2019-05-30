package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.PanelBestSellers;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BestSellersUser extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7292890646500760064L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private String nUsuario;
		
	/**
	 * Aquí se definen los botones del menú.
	 * Se introducen los valores de tamaño, color de fondo, se declara el ActionPerformed y se indica una imagen que hace de icono.
	 */
	public BestSellersUser(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 451, 784, 2);
		contentPane.add(menu_separator);
		
		// Botón HOME
		btnHome = new JButton("");
		Image house = new ImageIcon(this.getClass().getResource("/home2.png")).getImage();
		Image newhouse = house.getScaledInstance(27, 27, java.awt.Image.SCALE_SMOOTH);
		btnHome.setIcon(new ImageIcon(newhouse));

		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(SystemColor.activeCaption);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 451, 156, 61);
		contentPane.add(btnHome);
		
		
		// Botón BestSellers
		btnBestSellers = new JButton("");
		Image estrella = new ImageIcon(this.getClass().getResource("/favorites.png")).getImage();
		Image newestrella = estrella.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnBestSellers.setIcon(new ImageIcon(newestrella));
		
		btnBestSellers.setBackground(new Color(176, 196, 222));
		btnBestSellers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBestSellers.setBounds(154, 451, 157, 61);
		contentPane.add(btnBestSellers);
		
		
		// Botón Usuario
		btnUsuario = new JButton("");
		Image monigote = new ImageIcon(this.getClass().getResource("/users.png")).getImage();
		Image newmonigote = monigote.getScaledInstance(36, 36, java.awt.Image.SCALE_SMOOTH);
		btnUsuario.setIcon(new ImageIcon(newmonigote));
		
		btnUsuario.setBackground(SystemColor.activeCaption);
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUsuario.setBounds(617, 451, 167, 61);
		contentPane.add(btnUsuario);
		
		// Botón Compras
		btnCompras = new JButton("");
		Image carrito = new ImageIcon(this.getClass().getResource("/shopping-cart.png")).getImage();
		Image newcarrito = carrito.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnCompras.setIcon(new ImageIcon(newcarrito));
		
		btnCompras.setBackground(SystemColor.activeCaption);
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 451, 156, 61);
		contentPane.add(btnCompras);
		
		// Botón Buscar
		btnBuscar = new JButton("");
		Image lupa = new ImageIcon(this.getClass().getResource("/loupe2.png")).getImage();
		Image newlupa = lupa.getScaledInstance(29, 29, java.awt.Image.SCALE_SMOOTH);
		btnBuscar.setIcon(new ImageIcon(newlupa));
		
		btnBuscar.setBackground(SystemColor.activeCaption);
		btnBuscar.setBounds(309, 451, 156, 61);
		contentPane.add(btnBuscar);
		
		PanelBestSellers panel = new PanelBestSellers();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 791, 512);
		contentPane.add(panel);
		
		btnBestSellers.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnHome.addActionListener(this);
		btnUsuario.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnHome) {
			InicioUser inicio = new InicioUser(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnBuscar){
			BusquedaUser busqueda = new BusquedaUser(nUsuario);
			busqueda.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnCompras) {
			ComprasRealizadas compras = new ComprasRealizadas(nUsuario);
			compras.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnUsuario){
			PerfilUser perfil = new PerfilUser(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		}
		else {
			BestSellersUser best = new BestSellersUser(nUsuario);
			best.setVisible(true);
			this.dispose();
		}
		
	}
}
