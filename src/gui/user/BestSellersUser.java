package gui.user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.PanelBestSellers;

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

public class BestSellersUser extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7292890646500760064L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnHome;
	private JButton btnBestSellers;
	private JButton btnUsuario;
	private JButton btnCompras;
	private JButton btnBuscar;
	
	

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 451, 784, 2);
		contentPane.add(menu_separator);
		
		btnHome = new JButton("Casa(HOME)");
		btnHome.setForeground(new Color(0, 0, 0));
		btnHome.setBackground(new Color(0, 204, 51));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBounds(0, 451, 156, 61);
		contentPane.add(btnHome);
		
		btnBestSellers = new JButton("Estrella(BestSellers)");
		btnBestSellers.setBackground(new Color(0, 153, 51));
		btnBestSellers.setBounds(154, 451, 157, 61);
		contentPane.add(btnBestSellers);
		
		btnUsuario = new JButton("Monigote(usuario)");
		btnUsuario.setBackground(new Color(0, 204, 51));
		btnUsuario.setBounds(617, 451, 167, 61);
		contentPane.add(btnUsuario);
		
		btnCompras = new JButton("Carrito(Compras)");
		btnCompras.setBackground(new Color(0, 204, 51));
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompras.setBounds(463, 451, 156, 61);
		contentPane.add(btnCompras);
		
		btnBuscar = new JButton("Lupa(buscar)");
		btnBuscar.setBackground(new Color(0, 204, 51));
		btnBuscar.setBounds(309, 451, 156, 61);
		contentPane.add(btnBuscar);
		
		PanelBestSellers panel = new PanelBestSellers();
		panel.setBounds(0, 0, 791, 512);
		contentPane.add(panel);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
