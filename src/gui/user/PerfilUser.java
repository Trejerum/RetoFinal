package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.PanelPerfil;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilUser extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 2542411058982798072L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private String nUsuario;

	/**
	 * Create the frame.
	 */
	public PerfilUser(String usuario) {
		nUsuario=usuario;
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
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(0, 204, 51));
		btnHome.setBounds(0, 417, 128, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(0, 204, 51));
		btnBestSellers.setBounds(126, 417, 124, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(0, 153, 51));
		btnUsuario.setBounds(493, 417, 128, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(0, 204, 51));
		btnCompras.setBounds(370, 417, 128, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(0, 204, 51));
		btnBuscar.setBounds(248, 417, 124, 61);
		contentPane.add(btnBuscar);
		
		PanelPerfil panel = new PanelPerfil(usuario);
		panel.setBounds(0,0,710,450);
		contentPane.add(panel);
		
		btnBestSellers.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnHome.addActionListener(this);
		btnUsuario.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBestSellers) {
			BestSellersUser bestSellers = new BestSellersUser(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnBuscar) {
			BusquedaUser busqueda = new BusquedaUser(nUsuario);
			busqueda.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnCompras) {
			ComprasRealizadas compras = new ComprasRealizadas(nUsuario);
			compras.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnHome) {
			InicioUser inicio = new InicioUser(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
		else {
			PerfilUser perfil = new PerfilUser(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		}
	}
}
	