package gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaLibros extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8708312469028487504L;
	private JPanel contentPane;
	private JButton btnModificar;
	private JLabel lblSeleccionaUnLibro;
	private JScrollPane scrollPane;
	private String nusuario;
	private String nisbn;
	private JTable tablaLibros;


	/**
	 * Create the frame.
	 */
	public ListaLibros(String usuario, String isbn) {
		nusuario = usuario;
		nisbn = isbn;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblSeleccionaUnLibro = new JLabel("Selecciona un libro");
		lblSeleccionaUnLibro.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblSeleccionaUnLibro.setBounds(49, 54, 251, 30);
		contentPane.add(lblSeleccionaUnLibro);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 121, 251, 338);
		contentPane.add(scrollPane);
		
		tablaLibros = new JTable();
		tablaLibros.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "Titulo"
			}
		));
		scrollPane.setViewportView(tablaLibros);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(334, 253, 89, 23);
		contentPane.add(btnModificar);
		
		btnModificar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnModificar) {
			validarSeleccion();
		}
		
	}

	private void validarSeleccion() {
		try {
			//String isbn = tablaLibros;
		}catch(Exception e) {
			String message="Selecciona el libro en la Lista";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);	
		}
		
	}
}
