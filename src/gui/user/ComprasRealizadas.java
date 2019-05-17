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

public class ComprasRealizadas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4599970365472572583L;
	private JPanel contentPane;
	private JTextField tfCompra1;
	private JTextField tfCompra2;
	private JTextField tfCompra3;
	private JTextField tfCompra4;
	private JTextField tfCompra5;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JSeparator separator;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel lblCompras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprasRealizadas frame = new ComprasRealizadas();
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
	public ComprasRealizadas() {
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
		btnUsuario.setBackground(new Color(245, 245, 220));
		btnUsuario.setBounds(617, 407, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(245, 222, 179));
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
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		label_1 = new JLabel("1.");
		label_1.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_1.setBounds(23, 83, 19, 27);
		contentPane.add(label_1);
		
		label_2 = new JLabel("2.");
		label_2.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_2.setBounds(20, 136, 19, 27);
		contentPane.add(label_2);
		
		label_3 = new JLabel("3.");
		label_3.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_3.setBounds(21, 189, 19, 27);
		contentPane.add(label_3);
		
		label_4 = new JLabel("4.");
		label_4.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_4.setBounds(20, 241, 19, 27);
		contentPane.add(label_4);
		
		label_5 = new JLabel("5.");
		label_5.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_5.setBounds(20, 290, 19, 27);
		contentPane.add(label_5);
		
		lblCompras = new JLabel("Compras realizadas:");
		lblCompras.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblCompras.setBounds(20, 22, 234, 27);
		contentPane.add(lblCompras);
		
		tfCompra1 = new JTextField();
		tfCompra1.setBackground(new Color(255, 248, 220));
		tfCompra1.setEditable(false);
		tfCompra1.setColumns(10);
		tfCompra1.setBounds(52, 80, 711, 27);
		contentPane.add(tfCompra1);
		
		tfCompra2 = new JTextField();
		tfCompra2.setBackground(new Color(255, 248, 220));
		tfCompra2.setEditable(false);
		tfCompra2.setColumns(10);
		tfCompra2.setBounds(52, 136, 711, 27);
		contentPane.add(tfCompra2);
		
		tfCompra3 = new JTextField();
		tfCompra3.setBackground(new Color(255, 248, 220));
		tfCompra3.setEditable(false);
		tfCompra3.setColumns(10);
		tfCompra3.setBounds(52, 189, 711, 27);
		contentPane.add(tfCompra3);
		
		tfCompra4 = new JTextField();
		tfCompra4.setBackground(new Color(255, 248, 220));
		tfCompra4.setEditable(false);
		tfCompra4.setColumns(10);
		tfCompra4.setBounds(52, 241, 711, 27);
		contentPane.add(tfCompra4);
		
		tfCompra5 = new JTextField();
		tfCompra5.setBackground(new Color(255, 248, 220));
		tfCompra5.setEditable(false);
		tfCompra5.setColumns(10);
		tfCompra5.setBounds(52, 290, 711, 27);
		contentPane.add(tfCompra5);
		
	}
}
