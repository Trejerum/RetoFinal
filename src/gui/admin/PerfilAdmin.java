package gui.admin;
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
	 * Create the frame.
	 */
	public PerfilAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 439);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelPerfil panel = new PanelPerfil(usuario);
		panel.setBounds(0, 0, 616, 401);
		contentPane.add(panel);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(475, 359, 131, 31);
		panel.add(btnVolver);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		
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