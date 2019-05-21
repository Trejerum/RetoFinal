package gui.user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;

public class InicioUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2752882210597083244L;
	private JPanel contentPane;
	private JTextField txtNombreusuario;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioUser frame = new InicioUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(1, 377, 784, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(245, 222, 179));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 378, 157, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(245, 245, 220));
		btnBestSellers.setBounds(155, 378, 156, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(245, 245, 220));
		btnUsuario.setBounds(617, 378, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(245, 245, 220));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 378, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(245, 245, 220));
		btnBuscar.setBounds(309, 378, 156, 61);
		contentPane.add(btnBuscar);
		
		lblBienvenido = new JLabel("!!Bienvenid@ a la \r\nlibrer\u00EDa virtual!!");
		lblBienvenido.setForeground(Color.RED);
		lblBienvenido.setFont(new Font("Maiandra GD", Font.PLAIN, 40));
		lblBienvenido.setBounds(85, 72, 590, 98);
		contentPane.add(lblBienvenido);
		
		lblHola = new JLabel("Hola ");
		lblHola.setFont(new Font("Maiandra GD", Font.PLAIN, 15));
		lblHola.setBounds(72, 198, 46, 16);
		contentPane.add(lblHola);
		
		txtNombreusuario = new JTextField();
		txtNombreusuario.setEditable(false);
		txtNombreusuario.setText("nombreUsuario");
		txtNombreusuario.setBounds(110, 196, 98, 20);
		contentPane.add(txtNombreusuario);
		txtNombreusuario.setColumns(10);
		
		lblAcabasDeEntrar = new JLabel("acabas de entrar a la liber\u00EDa virtual. Esta aplicaci\u00F3n tiene diferentes funciones:");
		lblAcabasDeEntrar.setBounds(74, 226, 511, 36);
		contentPane.add(lblAcabasDeEntrar);
		
		lbllaEstrellaSirve = new JLabel("- La estrella sirve para ver los libros que se encuentran entre los Best Sellers");
		lbllaEstrellaSirve.setBounds(87, 261, 490, 36);
		contentPane.add(lbllaEstrellaSirve);
		
		lblLaLupa = new JLabel("- La lupa sirve para hacer una busqueda sobre algun libro que le pueda interesar o para ver tus libros recomendados");
		lblLaLupa.setBounds(87, 297, 590, 27);
		contentPane.add(lblLaLupa);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
	}
}
