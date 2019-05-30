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

/**
 * En esta ventana aparaecen tus datos de usuario, y desde aqui podras
 * modificarlos
 * 
 * @author EquipoB
 *
 */
public class PerfilAdmin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023274207853491447L;
	private JPanel contentPane;
	private JButton btnVolver;
	private String nUsuario;

	/**
	 * Create the frame.
	 */
	public PerfilAdmin(String usuario) {
		nUsuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 439);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		// Aqui se llama al panel que creamos para los dos usuarios
		PanelPerfil panel = new PanelPerfil(nUsuario);
		panel.setBounds(0, 0, 616, 401);
		contentPane.add(panel);

		// Este boton te lleva a la pagina de inicio
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(475, 359, 131, 31);
		panel.add(btnVolver);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));

		// ActionListener
		btnVolver.addActionListener(this);

	}

	/**
	 * Aqui se dan funciones a los Botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			InicioAdmin inicioAdmin = new InicioAdmin(nUsuario);
			inicioAdmin.setVisible(true);
			this.dispose();
		}

	}
}