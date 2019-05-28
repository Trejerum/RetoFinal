package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Logic;
import control.LogicFactory;
import gui.user.BestSellersUser.JPanelBackground;
import model.Compra;
import java.awt.Graphics;
import java.awt.Image;
 
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ComprasRealizadas extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4599970365472572583L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JSeparator separator;
	private JLabel lblCompras;
	private String nUsuario;
	private JTable table;
	private DefaultTableModel modelo;

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
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public ComprasRealizadas(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 495);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 405, 784, 2);
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
		
		//Botón Compras
		btnCompras = new JButton("");
		Image carrito = new ImageIcon(this.getClass().getResource("/shopping-cart.png")).getImage();
		Image newcarrito = carrito.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		btnCompras.setIcon(new ImageIcon(newcarrito));
		
		btnCompras.setBackground(new Color(176, 196, 222));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 407, 156, 61);
		contentPane.add(btnCompras);
		
		//Botón BUSCAR
		btnBuscar = new JButton("");
		Image lupa = new ImageIcon(this.getClass().getResource("/loupe2.png")).getImage();
		Image newlupa = lupa.getScaledInstance(29, 29, java.awt.Image.SCALE_SMOOTH);
		btnBuscar.setIcon(new ImageIcon(newlupa));
		
		
		btnBuscar.setBackground(SystemColor.activeCaption);
		btnBuscar.setBounds(309, 407, 156, 61);
		contentPane.add(btnBuscar);
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		lblCompras = new JLabel("Compras realizadas:");
		lblCompras.setForeground(new Color(0, 0, 128));
		lblCompras.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblCompras.setBounds(37, 16, 234, 27);
		contentPane.add(lblCompras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 85, 694, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		modelo = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"IdCompra", "Nombre Usuario", "ISBN", "Cantidad", "Fecha", "Importe", "NumCuenta"
				}
			) {
			
			//Make the cells non editable
			@Override
			public boolean isCellEditable(int row, int column) {
				//For make the cells editable return true
				return false;
			}
		};
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		btnBestSellers.addActionListener(this);
		btnHome.addActionListener(this);
		btnUsuario.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		
		cargarCompras();
		

		JPanelBackground jPanelBackground = new JPanelBackground();
		jPanelBackground.setBackground("./images/fondo3.jpg");
		jPanelBackground.setBounds(1, 0, 784, 439);
		contentPane.add(jPanelBackground);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
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
			BestSellersUser bestSellers = new BestSellersUser(nUsuario);
			bestSellers.setVisible(true);
			this.dispose();
		}
	}
	
	public void cargarCompras() {
		ArrayList<Compra> compras = new ArrayList<Compra>();
		try {
			Logic logic = LogicFactory.getLogic();
			compras = logic.consultarCompras(nUsuario);
		for (Compra compra : compras) {
			Object rowdata[]= {compra.getIdCompra(), compra.getNombreUsuario(), compra.getIsbn(), compra.getUnidades(), compra.getFechaCompra(), compra.getImporteTotal(), compra.getNumCuenta()};
			modelo.addRow(rowdata);
		}
		table.setModel(modelo);
		
		}catch(Exception e) {
			String message = "Error. No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
