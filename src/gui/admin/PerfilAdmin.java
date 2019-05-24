package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.all.PanelPerfil;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

public class PerfilAdmin extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023274207853491447L;
	private JPanel contentPane;
	private JButton btnVolver;
	public String usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilAdmin frame = new PerfilAdmin();
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
	public PerfilAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 399);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(430, 307, 131, 31);
		contentPane.add(btnVolver);
		
		PanelPerfil panel = new PanelPerfil(usuario);
		panel.setBounds(0, 0, 593, 361);
		contentPane.add(panel);
		
		btnVolver.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver) {
			InicioAdmin inicioAdmin = new InicioAdmin();
			inicioAdmin.setVisible(true);
			this.dispose();
		}
		
	}
}
