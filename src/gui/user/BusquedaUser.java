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

public class BusquedaUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196680677816620968L;
	private JPanel contentPane;
	private JTextField tfBusqueda;
	private JTextField tfResultado1;
	private JTextField tfResultado2;
	private JTextField tfResultado3;
	private JTextField tfResultado4;
	private JTextField tfResultado5;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	private JLabel lblBuscar;
	private JSeparator separator;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JButton btnBuscarLupa;
	private JLabel lblResultados;
	private JButton btnRecomendados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaUser frame = new BusquedaUser();
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
	public BusquedaUser() {
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
		btnCompras.setBackground(new Color(245, 245, 220));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 407, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(245, 222, 179));
		btnBuscar.setBounds(309, 407, 156, 61);
		contentPane.add(btnBuscar);
		
		lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBuscar.setBounds(10, 20, 89, 27);
		contentPane.add(lblBuscar);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		label_1 = new JLabel("1.");
		label_1.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_1.setBounds(80, 123, 19, 27);
		contentPane.add(label_1);
		
		label_2 = new JLabel("2.");
		label_2.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_2.setBounds(77, 176, 19, 27);
		contentPane.add(label_2);
		
		label_3 = new JLabel("3.");
		label_3.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_3.setBounds(78, 229, 19, 27);
		contentPane.add(label_3);
		
		label_4 = new JLabel("4.");
		label_4.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_4.setBounds(77, 281, 19, 27);
		contentPane.add(label_4);
		
		label_5 = new JLabel("5.");
		label_5.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_5.setBounds(77, 330, 19, 27);
		contentPane.add(label_5);
		
		tfBusqueda = new JTextField();
		tfBusqueda.setBounds(109, 22, 547, 27);
		contentPane.add(tfBusqueda);
		tfBusqueda.setColumns(10);
		
		btnBuscarLupa = new JButton("(Lupa)");
		btnBuscarLupa.setBounds(666, 22, 89, 27);
		contentPane.add(btnBuscarLupa);
		
		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblResultados.setBounds(10, 73, 132, 27);
		contentPane.add(lblResultados);
		
		btnRecomendados = new JButton("Ver recomendados");
		btnRecomendados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRecomendados.setBounds(588, 79, 167, 23);
		contentPane.add(btnRecomendados);
		
		tfResultado1 = new JTextField();
		tfResultado1.setBackground(new Color(255, 248, 220));
		tfResultado1.setEditable(false);
		tfResultado1.setColumns(10);
		tfResultado1.setBounds(109, 120, 547, 27);
		contentPane.add(tfResultado1);
		
		tfResultado2 = new JTextField();
		tfResultado2.setBackground(new Color(255, 248, 220));
		tfResultado2.setEditable(false);
		tfResultado2.setColumns(10);
		tfResultado2.setBounds(109, 176, 547, 27);
		contentPane.add(tfResultado2);
		
		tfResultado3 = new JTextField();
		tfResultado3.setBackground(new Color(255, 248, 220));
		tfResultado3.setEditable(false);
		tfResultado3.setColumns(10);
		tfResultado3.setBounds(109, 229, 547, 27);
		contentPane.add(tfResultado3);
		
		tfResultado4 = new JTextField();
		tfResultado4.setBackground(new Color(255, 248, 220));
		tfResultado4.setEditable(false);
		tfResultado4.setColumns(10);
		tfResultado4.setBounds(109, 281, 547, 27);
		contentPane.add(tfResultado4);
		
		tfResultado5 = new JTextField();
		tfResultado5.setBackground(new Color(255, 248, 220));
		tfResultado5.setEditable(false);
		tfResultado5.setColumns(10);
		tfResultado5.setBounds(109, 330, 547, 27);
		contentPane.add(tfResultado5);
		
	}
}
