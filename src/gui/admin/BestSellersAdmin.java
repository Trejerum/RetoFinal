package gui.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Logic;
import control.LogicFactory;
import gui.all.PanelBestSellers;
import model.Usuario;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;

/**
 * Esta ventana sirve para visualizar los bestSellers
 * 
 * @author EquipoB
 *
 */
public class BestSellersAdmin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5008628838388360466L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnVolver;
	private JLabel lblSesionIniciada;
	private JLabel lblnameAdmin;
	private PanelBestSellers panel;
	private String nUsuario;

	/**
	 * Create the frame.
	 */
	public BestSellersAdmin(String usuario) {
		nUsuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 526);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		// Separador entre la cabezera y el cuerpo
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 420, 784, 2);
		contentPane.add(menu_separator);

		// Boton para volver a la ventana de inicio
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(65, 439, 167, 31);
		contentPane.add(btnVolver);

		// Aqui se visualiza quien ha iniciado sesion en la aplicacion
		lblSesionIniciada = new JLabel("Sesi\u00F3n iniciada como: ");
		lblSesionIniciada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSesionIniciada.setBounds(26, 11, 134, 14);
		contentPane.add(lblSesionIniciada);

		// Aqui se visuliza el nombre del administrador conectado
		lblnameAdmin = new JLabel("");
		lblnameAdmin.setBounds(170, 11, 87, 16);
		contentPane.add(lblnameAdmin);

		// Este llama al panel qeu creamos para las dos vetanas, para el admin y el
		// usuario convencional
		panel = new PanelBestSellers();
		panel.setBounds(0, 0, 784, 488);
		contentPane.add(panel);

		// Action Listener de la ventana
		btnVolver.addActionListener(this);

		cargarDatos();
	}

	/**
	 * Esta funcion carga los datos de la base de datos en la tabla
	 */
	private void cargarDatos() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			Usuario usuario = new Usuario();
			usuario = logic.cargarUsuario(nUsuario, logic.esAdmin(nUsuario));
			lblnameAdmin.setText(usuario.getNombre());
		} catch (Exception e) {
			message = "Error. No se pudo cargar el usuario";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * Aqui se dan funciones a los botones
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			InicioAdmin inicio = new InicioAdmin(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}

	}
}
