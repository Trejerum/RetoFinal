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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	 * Create the frame.
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
		
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(0, 204, 51));
		btnHome.setBounds(0, 407, 156, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(0, 204, 51));
		btnBestSellers.setBounds(154, 407, 157, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(0, 204, 51));
		btnUsuario.setBounds(617, 407, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(0, 204, 51));
		btnCompras.setBounds(463, 407, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(0, 153, 51));
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
		String isbn = panel.getIsbn();
		ConfirmarCompra confirmarCompra = new ConfirmarCompra(isbn, nUsuario);
		confirmarCompra.setVisible(true);
		this.dispose();
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