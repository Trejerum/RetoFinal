package gui.admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gui.all.PanelBusquedaLibro;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

public class BusquedaAdmin extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7057016663401901410L;
	private JPanel contentPane;
	private JSeparator menu_separator;
	private JButton btnVolver;
	private static String nUsuario;

	/**
	 * Create the frame.
	 */
	public BusquedaAdmin(String usuario) {
		nUsuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 460);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Separador del cuerpo y del pie de la ventana
		menu_separator = new JSeparator();
		menu_separator.setBounds(0, 380, 784, 2);
		contentPane.add(menu_separator);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 388, 89, 27);
		contentPane.add(btnVolver);
		
		//Esto llama al panel que creamos para las dos ventanas, la de usuario convencional y administrador
		PanelBusquedaLibro panel = new PanelBusquedaLibro(nUsuario);
		panel.setBounds(0,0,785,450);
		contentPane.add(panel);
		
		//ActionListener de la ventana
		btnVolver.addActionListener(this);
	}

	@Override
	/**
	 * Aqui se dan funciones a los botones de la ventana
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver) {
			InicioAdmin inicio = new InicioAdmin(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
	}
}