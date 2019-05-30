package gui.user;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import gui.all.PanelBusquedaLibro;
import model.Libro;

import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

public class BusquedaUser extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196680677816620968L;
	
	
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JPanel contentPane;
	private JSeparator separator;
	private JButton btnRecomendados;
	private JButton btnComprar;
	private String nUsuario;
	private PanelBusquedaLibro panel;

	/**
	 * Aquí de sefinen los botones del menú.
	 * Se introducen los valores de tamaño, color de fondo, se declara el ActionPerformed y se indica una imagen que hace de icono.
	 */
	public BusquedaUser(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 495);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// Botón HOME
		btnHome = new JButton("");
		Image house = new ImageIcon(this.getClass().getResource("/home2.png")).getImage();
		Image newhouse = house.getScaledInstance(27, 27, java.awt.Image.SCALE_SMOOTH);
		btnHome.setIcon(new ImageIcon(newhouse));
		
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(SystemColor.activeCaption);
		btnHome.setBounds(0, 407, 156, 61);
		contentPane.add(btnHome);
		
		// Botón BestSellers
		btnBestSellers = new JButton("");
		Image estrella = new ImageIcon(this.getClass().getResource("/favorites.png")).getImage();
		Image newestrella = estrella.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnBestSellers.setIcon(new ImageIcon(newestrella));
		
		btnBestSellers.setBackground(SystemColor.activeCaption);
		btnBestSellers.setBounds(154, 407, 157, 61);
		contentPane.add(btnBestSellers);
		
		// Botón Usuario
		btnUsuario = new JButton("");
		Image monigote = new ImageIcon(this.getClass().getResource("/users.png")).getImage();
		Image newmonigote = monigote.getScaledInstance(36, 36, java.awt.Image.SCALE_SMOOTH);
		btnUsuario.setIcon(new ImageIcon(newmonigote));
		
		btnUsuario.setBackground(SystemColor.activeCaption);
		btnUsuario.setBounds(617, 407, 167, 61);
		contentPane.add(btnUsuario);
		
		// Botón Compras
		btnCompras = new JButton("");
		Image carrito = new ImageIcon(this.getClass().getResource("/shopping-cart.png")).getImage();
		Image newcarrito = carrito.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnCompras.setIcon(new ImageIcon(newcarrito));
		
		btnCompras.setBackground(SystemColor.activeCaption);
		btnCompras.setBounds(463, 407, 156, 61);
		contentPane.add(btnCompras);
		
		// Botón BUSCAR
		btnBuscar = new JButton("");
		Image lupa = new ImageIcon(this.getClass().getResource("/loupe2.png")).getImage();
		Image newlupa = lupa.getScaledInstance(29, 29, java.awt.Image.SCALE_SMOOTH);
		btnBuscar.setIcon(new ImageIcon(newlupa));
		
		btnBuscar.setBackground(new Color(176, 196, 222));
		btnBuscar.setBounds(310, 407, 156, 61);
		contentPane.add(btnBuscar);
		
		separator = new JSeparator();
		separator.setBounds(0, 407, 784, 2);
		contentPane.add(separator);
		
		btnRecomendados = new JButton("Ver recomendados");
		btnRecomendados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRecomendados.setBounds(588, 79, 167, 23);
		contentPane.add(btnRecomendados);
		
		//BOTON COMPRAR
		btnComprar = new JButton("Comprar\r\n");
		btnComprar.setBounds(641, 259, 132, 40);
		contentPane.add(btnComprar);
		
		panel = new PanelBusquedaLibro(nUsuario);
		panel.setBackground(new Color(176,196,222));
		panel.setBounds(0,0,785,450);
		contentPane.add(panel);
		
		btnBestSellers.addActionListener(this);
		btnHome.addActionListener(this);
		btnUsuario.addActionListener(this);
		btnRecomendados.addActionListener(this);
		btnComprar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnBuscar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnHome) {
			InicioUser inicio = new InicioUser(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnBestSellers) {
			BestSellersUser bestSellers = new BestSellersUser(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnComprar) {
			comprar();
		}
		else if(e.getSource()==btnCompras) {
			ComprasRealizadas compras = new ComprasRealizadas(nUsuario);
			compras.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnRecomendados) {
			verRecomendados();
		}
		else if(e.getSource()==btnUsuario){
			PerfilUser perfil = new PerfilUser(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		}
		else {
			BusquedaUser buscar = new BusquedaUser(nUsuario);
			buscar.setVisible(true);
			this.dispose();
		}
	}
	
	public void comprar() {
		try {
			String isbn = panel.getIsbn();
			ConfirmarCompra confirmarCompra = new ConfirmarCompra(isbn, nUsuario);
			confirmarCompra.setVisible(true);
			this.dispose();
		} catch (Exception e) {
			String message = "Error. No has seleccionado ningun libro";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void verRecomendados() {
		ArrayList<Libro> libros=new ArrayList<Libro>();
		try {
			Logic logic = LogicFactory.getLogic();
			libros=logic.verRecomendados(nUsuario);
			panel.verRecomendados(libros);
		}catch(Exception e) {
			String message = "Error. No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}