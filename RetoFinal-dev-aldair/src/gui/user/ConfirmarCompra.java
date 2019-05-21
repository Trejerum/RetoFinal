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
import javax.swing.JComboBox;

public class ConfirmarCompra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196680677816620968L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JLabel lblConfirmarCompra;
	private JSeparator separator;
	private JButton btnCancelar;
	private JLabel lblLibrosCarrito;
	private JButton btnConfirmar;
	private JLabel lblInfoLibro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmarCompra frame = new ConfirmarCompra();
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
	public ConfirmarCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 505);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 405, 784, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(245, 245, 220));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 407, 156, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(245, 245, 220));
		btnBestSellers.setBounds(154, 407, 157, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(245, 222, 179));
		btnUsuario.setBounds(617, 407, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(245, 245, 220));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 407, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(245, 245, 220));
		btnBuscar.setBounds(309, 407, 156, 61);
		contentPane.add(btnBuscar);
		
		lblConfirmarCompra = new JLabel("Confirmar compra");
		lblConfirmarCompra.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblConfirmarCompra.setBounds(10, 20, 349, 27);
		contentPane.add(lblConfirmarCompra);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(518, 358, 89, 23);
		contentPane.add(btnCancelar);
		
		lblLibrosCarrito = new JLabel("Libros en el carrito:");
		lblLibrosCarrito.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLibrosCarrito.setBounds(28, 73, 146, 27);
		contentPane.add(lblLibrosCarrito);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setBounds(617, 358, 134, 23);
		contentPane.add(btnConfirmar);
		
		lblInfoLibro = new JLabel("ISBN / T\u00EDtulo / Editorial / Precio ");
		lblInfoLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfoLibro.setBounds(28, 123, 201, 14);
		contentPane.add(lblInfoLibro);
		
		JComboBox cbUnidades = new JComboBox();
		cbUnidades.setBounds(241, 122, 44, 15);
		contentPane.add(cbUnidades);
		
	}
}
