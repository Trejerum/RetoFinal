package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

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

	/**
	 * Create the frame.
	 */
	public InicioUser(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(1, 377, 784, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(0, 153, 51));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 378, 157, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(0, 204, 51));
		btnBestSellers.setBounds(155, 378, 156, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(0, 204, 51));
		btnUsuario.setBounds(617, 378, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(0, 204, 51));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 378, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(0, 204, 51));
		btnBuscar.setBounds(309, 378, 156, 61);
		contentPane.add(btnBuscar);
		
		lblBienvenido = new JLabel("!!Bienvenid@ a la \r\nlibrer\u00EDa virtual!!");
		lblBienvenido.setForeground(new Color(153, 0, 0));
		lblBienvenido.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
		lblBienvenido.setBounds(85, 72, 590, 98);
		contentPane.add(lblBienvenido);
		
		lblHola = new JLabel("Hola ");
		lblHola.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHola.setBounds(85, 200, 46, 16);
		contentPane.add(lblHola);
		
		lblNombreusuario = new JLabel();
		lblNombreusuario.setBackground(new Color(0, 153, 51));
		lblNombreusuario.setText("nombreUsuario");
		lblNombreusuario.setBounds(110, 198, 98, 20);
		contentPane.add(lblNombreusuario);
		
		lblAcabasDeEntrar = new JLabel("Acabas de entrar a la liber\u00EDa virtual. Esta aplicaci\u00F3n tiene diferentes funciones:");
		lblAcabasDeEntrar.setBounds(74, 226, 511, 36);
		contentPane.add(lblAcabasDeEntrar);
		
		lbllaEstrellaSirve = new JLabel("- La estrella sirve para ver los libros que se encuentran entre los Best Sellers");
		lbllaEstrellaSirve.setBounds(87, 261, 490, 36);
		contentPane.add(lbllaEstrellaSirve);
		
		lblLaLupa = new JLabel("- La lupa sirve para hacer una busqueda sobre algun libro que le pueda interesar o para ver tus libros recomendados");
		lblLaLupa.setBounds(87, 297, 638, 27);
		contentPane.add(lblLaLupa);
		
		btnBestSellers.addActionListener(this);
		btnBuscar.addActionListener(this);
		btnCompras.addActionListener(this);
		btnUsuario.addActionListener(this);
		
		lblNombreusuario.setText(nUsuario);
	}

	@Override
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
