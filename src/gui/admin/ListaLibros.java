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
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;
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
		
		buscar();
		
		btnModificar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnModificar) {
			getISBN();
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
