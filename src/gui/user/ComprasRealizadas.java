package gui.user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JList;

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
	private JList listaComprasRealizadas;
	DefaultListModel modeloLista;

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
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 405, 784, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(0, 204, 51));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 407, 156, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(0, 204, 51));
		btnBestSellers.setBounds(154, 407, 157, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(0, 153, 51));
		btnUsuario.setBounds(617, 407, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(0, 204, 51));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 407, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(0, 204, 51));
		btnBuscar.setBounds(309, 407, 156, 61);
		contentPane.add(btnBuscar);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		lblCompras = new JLabel("Compras realizadas:");
		lblCompras.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblCompras.setBounds(20, 22, 234, 27);
		contentPane.add(lblCompras);
		
		listaComprasRealizadas = new JList();
		listaComprasRealizadas.setBounds(49, 108, 667, 263);
		contentPane.add(listaComprasRealizadas);
		modeloLista = new DefaultListModel();
		listaComprasRealizadas.setModel(modeloLista);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
