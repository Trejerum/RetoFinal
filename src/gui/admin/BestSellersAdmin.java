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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class BestSellersAdmin extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5008628838388360466L;
	private JPanel contentPane;
	private JTextField tfDate;
	private JSeparator menu_separator;
	private JLabel lblBestSellers;
	private JSeparator separator;
	private JLabel label;
	private JLabel lblTituloautorventas;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_9;
	private JButton btnVolver;
	private JButton btnBuscarLibro;
	private JLabel lblSesionIniciada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BestSellersAdmin frame = new BestSellersAdmin();
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
	public BestSellersAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 526);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 420, 784, 2);
		contentPane.add(menu_separator);
		
		lblBestSellers = new JLabel("Best Sellers:");
		lblBestSellers.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBestSellers.setBounds(235, 65, 144, 27);
		contentPane.add(lblBestSellers);
		
		tfDate = new JTextField();
		tfDate.setFont(new Font("Maiandra GD", Font.PLAIN, 24));
		tfDate.setEditable(false);
		tfDate.setBackground(UIManager.getColor("Button.background"));
		tfDate.setBounds(389, 65, 134, 27);
		contentPane.add(tfDate);
		tfDate.setColumns(10);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		tfDate.setText(fecha);
		
		separator = new JSeparator();
		separator.setBounds(0, 114, 784, 2);
		contentPane.add(separator);
		
		label = new JLabel("1.");
		label.setFont(new Font("Tunga", Font.PLAIN, 20));
		label.setBounds(65, 164, 19, 27);
		contentPane.add(label);
		
		lblTituloautorventas = new JLabel("Titulo/autor (ventas)");
		lblTituloautorventas.setBounds(94, 173, 259, 14);
		contentPane.add(lblTituloautorventas);
		
		label_1 = new JLabel("Titulo/autor (ventas)");
		label_1.setBounds(94, 225, 259, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("2.");
		label_2.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_2.setBounds(65, 217, 19, 27);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Titulo/autor (ventas)");
		label_3.setBounds(94, 278, 259, 14);
		contentPane.add(label_3);
		
		label_4 = new JLabel("3.");
		label_4.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_4.setBounds(65, 270, 19, 27);
		contentPane.add(label_4);
		
		label_5 = new JLabel("Titulo/autor (ventas)");
		label_5.setBounds(94, 330, 259, 14);
		contentPane.add(label_5);
		
		label_6 = new JLabel("4.");
		label_6.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_6.setBounds(65, 322, 19, 27);
		contentPane.add(label_6);
		
		label_7 = new JLabel("Titulo/autor (ventas)");
		label_7.setBounds(94, 380, 259, 14);
		contentPane.add(label_7);
		
		label_8 = new JLabel("5.");
		label_8.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_8.setBounds(65, 371, 19, 27);
		contentPane.add(label_8);
		
		label_10 = new JLabel("Titulo/autor (ventas)");
		label_10.setBounds(471, 172, 259, 14);
		contentPane.add(label_10);
		
		label_11 = new JLabel("6.");
		label_11.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_11.setBounds(442, 164, 19, 27);
		contentPane.add(label_11);
		
		label_12 = new JLabel("7.");
		label_12.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_12.setBounds(442, 217, 19, 27);
		contentPane.add(label_12);
		
		label_13 = new JLabel("Titulo/autor (ventas)");
		label_13.setBounds(471, 225, 259, 14);
		contentPane.add(label_13);
		
		label_14 = new JLabel("8.");
		label_14.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_14.setBounds(442, 270, 19, 27);
		contentPane.add(label_14);
		
		label_15 = new JLabel("9.");
		label_15.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_15.setBounds(442, 322, 19, 27);
		contentPane.add(label_15);
		
		label_16 = new JLabel("Titulo/autor (ventas)");
		label_16.setBounds(471, 330, 259, 14);
		contentPane.add(label_16);
		
		label_17 = new JLabel("Titulo/autor (ventas)");
		label_17.setBounds(471, 380, 259, 14);
		contentPane.add(label_17);
		
		label_18 = new JLabel("10.");
		label_18.setFont(new Font("Tunga", Font.PLAIN, 20));
		label_18.setBounds(432, 371, 31, 27);
		contentPane.add(label_18);
		
		label_9 = new JLabel("Titulo/autor (ventas)");
		label_9.setBounds(471, 278, 259, 14);
		contentPane.add(label_9);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(65, 439, 167, 31);
		contentPane.add(btnVolver);
		
		btnBuscarLibro = new JButton("Buscar libro");
		btnBuscarLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarLibro.setBounds(241, 439, 167, 31);
		contentPane.add(btnBuscarLibro);
		
		lblSesionIniciada = new JLabel("Sesi\u00F3n iniciada como: ");
		lblSesionIniciada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSesionIniciada.setBounds(26, 11, 134, 14);
		contentPane.add(lblSesionIniciada);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
