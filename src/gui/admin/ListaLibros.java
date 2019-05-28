package gui.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Logic;
import control.LogicFactory;
import model.Libro;

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
	private JTable tablaLibros;
	private JButton btnVolver;


	/**
	 * Create the frame.
	 */
	public ListaLibros(String usuario) {
		setResizable(false);
		nusuario = usuario;
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
		btnModificar.setBounds(334, 229, 89, 23);
		contentPane.add(btnModificar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(350, 468, 90, 25);
		contentPane.add(btnVolver);
		
		buscar();
		
		btnModificar.addActionListener(this);
		btnVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnModificar) {
			getISBN();
		}else if(e.getSource()==btnVolver) {
			InicioAdmin inicio = new InicioAdmin();
			inicio.setVisible(true);
			this.dispose();
		}
		
	}

	private void getISBN() {
		try {
			int columna = 0;
			int fila = tablaLibros.getSelectedRow();
			String isbn = tablaLibros.getModel().getValueAt(columna, fila).toString();
			ModificarLibro modificarLibro = new ModificarLibro(isbn, nusuario);
			modificarLibro.setVisible(true);
			this.dispose();
		}catch(Exception e) {
			String message="Selecciona el libro en la Lista";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);	
		}
		
	}
	

	public void buscar() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<Libro> libros= new ArrayList<Libro>();
			DefaultTableModel modelo = new DefaultTableModel(
						new Object[][] {
							
						},
						new String[] {
								"ISBN", "Titulo"
						}
					);
			for (Libro libro : libros) {
				Object rowdata[]= {libro.getIsbn(), libro.getTitulo()};
				modelo.addRow(rowdata);
			}
			tablaLibros.setModel(modelo);
			
		}catch(Exception e) {
			String message="Error. No se han podido encontrar libros";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
