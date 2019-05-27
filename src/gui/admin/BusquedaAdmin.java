package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.PanelBusquedaLibro;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.time.LocalDate;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class BusquedaAdmin extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7057016663401901410L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnVolver;
	private static String nisbn;
	private static String nUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusquedaAdmin frame = new BusquedaAdmin(nUsuario, nisbn);
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
	public BusquedaAdmin(String isbn, String usuario) {
		nisbn = isbn;
		nUsuario = usuario;
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
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 388, 89, 27);
		contentPane.add(btnVolver);
		
		PanelBusquedaLibro panel = new PanelBusquedaLibro(isbn);
		panel.setBounds(0,0,785,450);
		contentPane.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
