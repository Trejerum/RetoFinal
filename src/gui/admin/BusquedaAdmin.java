package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.time.LocalDate;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class BusquedaAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7057016663401901410L;
	private JPanel contentPane;
	private JTextField tfResultado1;
	private JTextField tfResultado2;
	private JTextField tfResultado3;
	private JTextField tfResultado4;
	private JTextField tfResultado5;
	private JSeparator menu_separator;
	private JLabel lblBusqueda;
	private JSeparator separator;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JTextField tfBusqueda;
	private JButton btnLupa;
	private JLabel lblResultados;
	private JButton btnVolver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaAdmin frame = new BusquedaAdmin();
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
	public BusquedaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 460);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 380, 784, 2);
		contentPane.add(menu_separator);
		
		lblBusqueda = new JLabel("Buscar:");
		lblBusqueda.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBusqueda.setBounds(10, 20, 89, 27);
		contentPane.add(lblBusqueda);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		label = new JLabel("1.");
		label.setFont(new Font("Tunga", Font.PLAIN, 20));
		label.setBounds(80, 123, 19, 27);
		contentPane.add(label);
		
		label_1 = new JLabel("2.");
		label_1.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_1.setBounds(77, 176, 19, 27);
		contentPane.add(label_1);
		
		label_2 = new JLabel("3.");
		label_2.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_2.setBounds(78, 229, 19, 27);
		contentPane.add(label_2);
		
		label_3 = new JLabel("4.");
		label_3.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_3.setBounds(77, 281, 19, 27);
		contentPane.add(label_3);
		
		label_4 = new JLabel("5.");
		label_4.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_4.setBounds(77, 330, 19, 27);
		contentPane.add(label_4);
		
		tfBusqueda = new JTextField();
		tfBusqueda.setBounds(109, 22, 547, 27);
		contentPane.add(tfBusqueda);
		tfBusqueda.setColumns(10);
		
		btnLupa = new JButton("(Lupa)");
		btnLupa.setBounds(666, 22, 89, 27);
		contentPane.add(btnLupa);
		
		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblResultados.setBounds(10, 73, 132, 27);
		contentPane.add(lblResultados);
		
		tfResultado1 = new JTextField();
		tfResultado1.setBackground(UIManager.getColor("Button.background"));
		tfResultado1.setEditable(false);
		tfResultado1.setColumns(10);
		tfResultado1.setBounds(109, 120, 547, 27);
		contentPane.add(tfResultado1);
		
		tfResultado2 = new JTextField();
		tfResultado2.setBackground(UIManager.getColor("Button.background"));
		tfResultado2.setEditable(false);
		tfResultado2.setColumns(10);
		tfResultado2.setBounds(109, 176, 547, 27);
		contentPane.add(tfResultado2);
		
		tfResultado3 = new JTextField();
		tfResultado3.setBackground(UIManager.getColor("Button.background"));
		tfResultado3.setEditable(false);
		tfResultado3.setColumns(10);
		tfResultado3.setBounds(109, 229, 547, 27);
		contentPane.add(tfResultado3);
		
		tfResultado4 = new JTextField();
		tfResultado4.setBackground(UIManager.getColor("Button.background"));
		tfResultado4.setEditable(false);
		tfResultado4.setColumns(10);
		tfResultado4.setBounds(109, 281, 547, 27);
		contentPane.add(tfResultado4);
		
		tfResultado5 = new JTextField();
		tfResultado5.setBackground(UIManager.getColor("Button.background"));
		tfResultado5.setEditable(false);
		tfResultado5.setColumns(10);
		tfResultado5.setBounds(109, 330, 547, 27);
		contentPane.add(tfResultado5);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 388, 89, 27);
		contentPane.add(btnVolver);
		
	}
}
