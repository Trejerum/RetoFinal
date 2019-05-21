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

public class BestSellersUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7292890646500760064L;
	private JPanel contentPane;
	private JTextField tfDate;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JLabel lblBestSellers;
	private JSeparator separator;
	private JLabel label_1;
	private JLabel lblTituloAutor_1;
	private JLabel lblTtuloAutor_2;
	private JLabel label_2;
	private JLabel lblTtuloAutor_3;
	private JLabel label_3;
	private JLabel lblTtuloAutor_4;
	private JLabel label_4;
	private JLabel lblTtuloAutor_5;
	private JLabel label_5;
	private JLabel lblTtuloAutor_6;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel lblTtuloAutor_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblTtuloAutor_9;
	private JLabel lblTtuloAutor_10;
	private JLabel label_10;
	private JLabel lblTtuloAutor_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestSellersUser frame = new BestSellersUser();
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
	public BestSellersUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 451, 784, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(245, 245, 220));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 451, 156, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(245, 222, 179));
		btnBestSellers.setBounds(154, 451, 157, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(245, 245, 220));
		btnUsuario.setBounds(617, 451, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(245, 245, 220));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 451, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(245, 245, 220));
		btnBuscar.setBounds(309, 451, 156, 61);
		contentPane.add(btnBuscar);
		
		lblBestSellers = new JLabel("Best Sellers:");
		lblBestSellers.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBestSellers.setBounds(235, 65, 144, 27);
		contentPane.add(lblBestSellers);
		
		tfDate = new JTextField();
		tfDate.setForeground(Color.RED);
		tfDate.setFont(new Font("Malgun Gothic", Font.PLAIN, 24));
		tfDate.setEditable(false);
		tfDate.setBackground(new Color(245, 222, 179));
		tfDate.setBounds(389, 65, 135, 27);
		contentPane.add(tfDate);
		tfDate.setColumns(10);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		tfDate.setText(fecha);
		
		separator = new JSeparator();
		separator.setBounds(0, 114, 784, 2);
		contentPane.add(separator);
		
		label_1 = new JLabel("1.");
		label_1.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_1.setBounds(68, 164, 19, 27);
		contentPane.add(label_1);
		
		lblTituloAutor_1 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTituloAutor_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTituloAutor_1.setBounds(94, 170, 259, 14);
		contentPane.add(lblTituloAutor_1);
		
		lblTtuloAutor_2 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_2.setBounds(94, 222, 259, 14);
		contentPane.add(lblTtuloAutor_2);
		
		label_2 = new JLabel("2.");
		label_2.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_2.setBounds(65, 217, 19, 27);
		contentPane.add(label_2);
		
		lblTtuloAutor_3 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_3.setBounds(94, 276, 259, 14);
		contentPane.add(lblTtuloAutor_3);
		
		label_3 = new JLabel("3.");
		label_3.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_3.setBounds(66, 270, 19, 27);
		contentPane.add(label_3);
		
		lblTtuloAutor_4 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_4.setBounds(94, 328, 259, 14);
		contentPane.add(lblTtuloAutor_4);
		
		label_4 = new JLabel("4.");
		label_4.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_4.setBounds(65, 322, 19, 27);
		contentPane.add(label_4);
		
		lblTtuloAutor_5 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_5.setBounds(94, 376, 259, 14);
		contentPane.add(lblTtuloAutor_5);
		
		label_5 = new JLabel("5.");
		label_5.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_5.setBounds(65, 371, 19, 27);
		contentPane.add(label_5);
		
		lblTtuloAutor_6 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_6.setBounds(471, 170, 259, 14);
		contentPane.add(lblTtuloAutor_6);
		
		label_6 = new JLabel("6.");
		label_6.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_6.setBounds(442, 164, 19, 27);
		contentPane.add(label_6);
		
		label_7 = new JLabel("7.");
		label_7.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_7.setBounds(443, 217, 19, 27);
		contentPane.add(label_7);
		
		lblTtuloAutor_7 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_7.setBounds(471, 222, 259, 14);
		contentPane.add(lblTtuloAutor_7);
		
		label_8 = new JLabel("8.");
		label_8.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_8.setBounds(443, 270, 19, 27);
		contentPane.add(label_8);
		
		label_9 = new JLabel("9.");
		label_9.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_9.setBounds(442, 322, 19, 27);
		contentPane.add(label_9);
		
		lblTtuloAutor_9 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_9.setBounds(471, 328, 259, 14);
		contentPane.add(lblTtuloAutor_9);
		
		lblTtuloAutor_10 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_10.setBounds(471, 376, 259, 14);
		contentPane.add(lblTtuloAutor_10);
		
		label_10 = new JLabel("10.");
		label_10.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_10.setBounds(435, 371, 31, 27);
		contentPane.add(label_10);
		
		lblTtuloAutor_8 = new JLabel("T\u00EDtulo - autor (ventas)");
		lblTtuloAutor_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTtuloAutor_8.setBounds(471, 276, 259, 14);
		contentPane.add(lblTtuloAutor_8);
		
		JButton btnComprar1 = new JButton("Comprar");
		btnComprar1.setBounds(234, 167, 89, 20);
		contentPane.add(btnComprar1);
		
		JButton btnComprar2 = new JButton("Comprar");
		btnComprar2.setBounds(235, 219, 89, 20);
		contentPane.add(btnComprar2);
		
		JButton btnComprar3 = new JButton("Comprar");
		btnComprar3.setBounds(235, 273, 89, 20);
		contentPane.add(btnComprar3);
		
		JButton btnComprar4 = new JButton("Comprar");
		btnComprar4.setBounds(235, 328, 89, 20);
		contentPane.add(btnComprar4);
		
		JButton btnComprar5 = new JButton("Comprar");
		btnComprar5.setBounds(235, 373, 89, 20);
		contentPane.add(btnComprar5);
		
		JButton btnComprar6 = new JButton("Comprar");
		btnComprar6.setBounds(608, 170, 89, 20);
		contentPane.add(btnComprar6);
		
		JButton btnComprar7 = new JButton("Comprar");
		btnComprar7.setBounds(608, 219, 89, 20);
		contentPane.add(btnComprar7);
		
		JButton btnComprar8 = new JButton("Comprar");
		btnComprar8.setBounds(608, 273, 89, 20);
		contentPane.add(btnComprar8);
		
		JButton btnComprar9 = new JButton("Comprar");
		btnComprar9.setBounds(608, 325, 89, 20);
		contentPane.add(btnComprar9);
		
		JButton btnComprar10 = new JButton("Comprar");
		btnComprar10.setBounds(608, 373, 89, 20);
		contentPane.add(btnComprar10);
		
	}
}
