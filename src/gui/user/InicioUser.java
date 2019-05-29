package gui.user;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSeparator;
import java.awt.Color;
import gui.all.JPanelBackground;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

public class InicioUser extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 2752882210597083244L;
	private JPanel contentPane;
	private JLabel lblNombreusuario;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JLabel lblBienvenido;
	private JLabel lblHola;
	private JLabel lblAcabasDeEntrar;
	private JLabel lbllaEstrellaSirve;
	private JLabel lblLaLupa;
	private String nUsuario;
	private JLabel lblElCarrito;
	private JLabel lblPerfil;
	


	 
	/**
	 * Clase que extiende de JPanel y permite poner una imagen como fondo.
	 */
	 
	public class JPanelBackground extends JPanel {
	 
		// Atributo que guardara la imagen de Background que le pasemos.
		private Image background;
	 
		// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
		public void paintComponent(Graphics g) {
	 
			/* Obtenemos el tamaño del panel para hacer que se ajuste a este
			cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
			int width = this.getSize().width;
			int height = this.getSize().height;
	 
			// Mandamos que pinte la imagen en el panel
			if (this.background != null) {
				g.drawImage(this.background, 0, 0, width, height, null);
			}
	 
			super.paintComponent(g);
		}
	 
		// Metodo donde le pasaremos la dirección de la imagen a cargar.
		public void setBackground(String imagePath) {
			
			// Construimos la imagen y se la asignamos al atributo background.
			this.setOpaque(false);
			this.background = new ImageIcon(imagePath).getImage();
			repaint();
		}
	 
	}
	
	/**
	 * Aquí de sefinen los botones del menú.
	 * Se introducen los valores de tamaño, color de fondo, se declara el ActionPerformed y se indica una imagen que hace de icono.
	 */
	public InicioUser(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(1, 377, 784, 2);
		contentPane.add(menu_separator);
		/**
		 * Aquí de sefinen los botones del menú.
		 * Se introducen los valores de tamaño, color de fondo y se indica una imagen que hace de icono.
		 */
		// Botón HOME
		btnHome = new JButton("");
		Image house = new ImageIcon(this.getClass().getResource("/home2.png")).getImage();
		Image newhouse = house.getScaledInstance(27, 27, java.awt.Image.SCALE_SMOOTH);
		btnHome.setIcon(new ImageIcon(newhouse));
		
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(176, 196, 222));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 378, 157, 61);
		contentPane.add(btnHome);
		
		// Botón BestSellers
		btnBestSellers = new JButton("");
		Image estrella = new ImageIcon(this.getClass().getResource("/favorites.png")).getImage();
		Image newestrella = estrella.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnBestSellers.setIcon(new ImageIcon(newestrella));
		
		btnBestSellers.setBackground(SystemColor.activeCaption);
		btnBestSellers.setBounds(155, 378, 156, 61);
		contentPane.add(btnBestSellers);
		
		// Botón Usuario
		btnUsuario = new JButton("");
		Image monigote = new ImageIcon(this.getClass().getResource("/users.png")).getImage();
		Image newmonigote = monigote.getScaledInstance(36, 36, java.awt.Image.SCALE_SMOOTH);
		btnUsuario.setIcon(new ImageIcon(newmonigote));
		
		btnUsuario.setBackground(SystemColor.activeCaption);
		btnUsuario.setBounds(617, 378, 167, 61);
		contentPane.add(btnUsuario);
		
		//Botón Compras
		btnCompras = new JButton("");
		Image carrito = new ImageIcon(this.getClass().getResource("/shopping-cart.png")).getImage();
		Image newcarrito = carrito.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnCompras.setIcon(new ImageIcon(newcarrito));
		
		btnCompras.setBackground(SystemColor.activeCaption);
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 378, 156, 61);
		contentPane.add(btnCompras);
		
		//Botón BUSCAR
		btnBuscar = new JButton("");
		Image lupa = new ImageIcon(this.getClass().getResource("/loupe2.png")).getImage();
		Image newlupa = lupa.getScaledInstance(36, 36, java.awt.Image.SCALE_SMOOTH);
		btnBuscar.setIcon(new ImageIcon(newlupa));
		btnBuscar.setBackground(SystemColor.activeCaption);
		btnBuscar.setBounds(309, 378, 156, 61);
		contentPane.add(btnBuscar);
		/**
		 * Aqui se definen las labels que aparecen en pantalla
		 */
		lblBienvenido = new JLabel("\u00A1\u00A1Bienvenid@ a la \r\nlibrer\u00EDa virtual!!");
		lblBienvenido.setForeground(new Color(0, 0, 128));
		lblBienvenido.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
		lblBienvenido.setBounds(85, 72, 590, 98);
		contentPane.add(lblBienvenido);
		
		lblHola = new JLabel("Hola ");
		lblHola.setForeground(new Color(0, 0, 128));
		lblHola.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHola.setBounds(85, 200, 46, 16);
		contentPane.add(lblHola);
		
		lblNombreusuario = new JLabel();
		lblNombreusuario.setForeground(new Color(0, 0, 128));
		lblNombreusuario.setBackground(new Color(0, 153, 51));
		lblNombreusuario.setText("nombreUsuario");
		lblNombreusuario.setBounds(110, 198, 98, 20);
		contentPane.add(lblNombreusuario);
		
		lblAcabasDeEntrar = new JLabel("Acabas de entrar a la liber\u00EDa virtual. Esta aplicaci\u00F3n tiene diferentes funciones:");
		lblAcabasDeEntrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAcabasDeEntrar.setForeground(new Color(0, 0, 128));
		lblAcabasDeEntrar.setBounds(74, 226, 511, 25);
		contentPane.add(lblAcabasDeEntrar);
		
		lbllaEstrellaSirve = new JLabel("- La estrella sirve para ver los libros que se encuentran entre los Best Sellers");
		lbllaEstrellaSirve.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbllaEstrellaSirve.setForeground(new Color(0, 0, 128));
		lbllaEstrellaSirve.setBounds(85, 250, 490, 25);
		contentPane.add(lbllaEstrellaSirve);
		
		lblLaLupa = new JLabel("- La lupa sirve para hacer una busqueda sobre algun libro que le pueda interesar o para ver tus libros recomendados");
		lblLaLupa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLaLupa.setForeground(new Color(0, 0, 128));
		lblLaLupa.setBounds(85, 275, 638, 25);
		contentPane.add(lblLaLupa);
		
		lblNombreusuario.setText(nUsuario);
		
		lblElCarrito = new JLabel("- El carrito sirve para ver tus compras realizadas");
		lblElCarrito.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblElCarrito.setForeground(new Color(0, 0, 128));
		lblElCarrito.setBounds(85, 300, 638, 25);
		contentPane.add(lblElCarrito);
		
		lblPerfil = new JLabel("- Las personas sirven para acceder a tu perfil y desde ahi puedes modificar tus datos personales");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPerfil.setForeground(new Color(0, 0, 128));
		lblPerfil.setBounds(85, 325, 574, 25);
		contentPane.add(lblPerfil);
		
		/*
		 * Aqui definimos los Action Listener
		 */
		btnBestSellers.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnUsuario.addActionListener(this);
		/**
		 * Aqui debajo se declara el fondo
		 */
		JPanelBackground jPanelBackground = new JPanelBackground();
		jPanelBackground.setBackground("./images/fondo1.jpg");
		jPanelBackground.setBounds(1, 0, 784, 439);
		contentPane.add(jPanelBackground);
		
		
	}

	@Override
	/**
	 * Aqui ponemos las funciones a cada actionPerfomed
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBestSellers) {
			BestSellersUser bestSellers = new BestSellersUser(nUsuario);
			bestSellers.setVisible(true);
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
		else {
			PerfilUser perfil = new PerfilUser(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		}
		
	}
}
