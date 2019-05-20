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
	private JSeparator menu_separator;
	private JLabel lblBusqueda;
	private JSeparator separator;
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
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 388, 89, 27);
		contentPane.add(btnVolver);
		
	}
}
