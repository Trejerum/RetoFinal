package gui.all;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import control.Logic;
import control.LogicFactory;
import model.Libro;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class PanelBusquedaLibro extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7581356853066506062L;

	private JTable tablaBusqueda;
	private JTextField tfBusqueda;
	private JSeparator menu_separator;
	private JLabel lblResultados;
	private JButton btnBuscarLupa;
	private JScrollPane scrollPane;
	private JButton btnVerDescripcion;
	private JLabel lblBuscar;
	private String nUsuario;
	
	
	/**
	 * Create the panel.
	 * @param nUsuario 
	 */
	
	public PanelBusquedaLibro(String usuario) {
		nUsuario=usuario;
		setBackground(new Color(0, 153, 51));
		setForeground(new Color(0, 0, 0));
		
		setLayout(null);
		
		menu_separator = new JSeparator();
		menu_separator.setBounds(10, 60, 784, 2);
		add(menu_separator);
		
		btnBuscarLupa = new JButton("(Lupa)");
		btnBuscarLupa.setBounds(666, 22, 89, 27);
		add(btnBuscarLupa);
		
		
		tfBusqueda = new JTextField();
		tfBusqueda.setBounds(109, 22, 547, 27);
		add(tfBusqueda);
		tfBusqueda.setColumns(10);
		
		lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblResultados.setBounds(10, 73, 132, 27);
		add(lblResultados);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 122, 561, 236);
		add(scrollPane);
		
		tablaBusqueda = new JTable();
		tablaBusqueda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaBusqueda.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"ISBN", "Titulo", "Genero", "Editorial", "Precio"
			}
		));
		scrollPane.setViewportView(tablaBusqueda);
		
		btnVerDescripcion = new JButton("Ver descripcion");
		btnVerDescripcion.setBounds(641, 202, 132, 40);
		add(btnVerDescripcion);
		
		lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Maiandra GD", Font.PLAIN, 23));
		lblBuscar.setBounds(10, 22, 89, 27);
		add(lblBuscar);
		
		buscar();
		
		btnBuscarLupa.addActionListener(this);
		btnVerDescripcion.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnBuscarLupa) {
			buscar();
		}
		else {
			mostrarDescripcion();
		}
	}
	
	public void buscar() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<Libro> libros= new ArrayList<Libro>();
			String busqueda = tfBusqueda.getText();
			libros=logic.buscarLibro(busqueda);
			DefaultTableModel modelo = new DefaultTableModel(
						new Object[][] {
							
						},
						new String[] {
								"ISBN", "Titulo", "Genero", "Editorial", "Precio"
						}
			);
			for (Libro libro : libros) {
				Object rowdata[]= {libro.getIsbn(), libro.getTitulo(), libro.getGenero(), libro.getEditorial(), libro.getPrecio()};
				modelo.addRow(rowdata);
			}
			tablaBusqueda.setModel(modelo);
			
		}catch(Exception e) {
			String message="Error. No se han podido encontrar libros";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void mostrarDescripcion() {
		int columna=0;
		int fila = tablaBusqueda.getSelectedRow();
		String isbn = tablaBusqueda.getModel().getValueAt(fila, columna).toString();
		Descripcion descripcion = new Descripcion(isbn, nUsuario);
		descripcion.setVisible(true);
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.dispose();
	}
	
	public void verRecomendados(ArrayList<Libro> libros) {
		DefaultTableModel modelo = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"ISBN", "Titulo", "Genero", "Editorial", "Precio"
				}
				);
		for (Libro libro : libros) {
			Object rowdata[]= {libro.getIsbn(), libro.getTitulo(), libro.getGenero(), libro.getEditorial(), libro.getPrecio()};
			modelo.addRow(rowdata);
		}
		tablaBusqueda.setModel(modelo);
	}
	
	public String getIsbn() {
		int columna=0;
		int fila = tablaBusqueda.getSelectedRow();
		String isbn = tablaBusqueda.getModel().getValueAt(fila, columna).toString();
		return isbn;
	}
}
