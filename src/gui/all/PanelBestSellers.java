package gui.all;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Logic;
import control.LogicFactory;
import model.Libro;

public class PanelBestSellers extends JPanel {
	private JLabel lblBestSellers;
	private JTextField tfDate;
	private JSeparator separator;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5934182603239436311L;
	private JTable tablaBestSellers;

	/**
	 * Create the panel.
	 */
	public PanelBestSellers() {
		setBackground(UIManager.getColor("Button.background"));
		setLayout(null);
		
		lblBestSellers = new JLabel("Best Sellers:");
		lblBestSellers.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBestSellers.setBounds(235, 65, 144, 27);
		add(lblBestSellers);
		
		tfDate = new JTextField();
		tfDate.setForeground(new Color(0, 0, 153));
		tfDate.setFont(new Font("Malgun Gothic", Font.PLAIN, 24));
		tfDate.setEditable(false);
		tfDate.setBackground(UIManager.getColor("Button.background"));
		tfDate.setBounds(389, 65, 135, 27);
		add(tfDate);
		tfDate.setColumns(10);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		tfDate.setText(fecha);
		

		separator = new JSeparator();
		separator.setBounds(0, 114, 784, 2);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 127, 609, 270);
		add(scrollPane);
		
		tablaBestSellers = new JTable();
		tablaBestSellers.setForeground(new Color(0, 0, 0));
		tablaBestSellers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA", "Titulo", "Autor", "Ventas"
			}
		));
		tablaBestSellers.setEnabled(false);
		scrollPane.setViewportView(tablaBestSellers);
		
		cargarLibros();
	}
	
	public void cargarLibros() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<Libro> libros= new ArrayList<Libro>();
			libros=logic.listarBestsellers();
			DefaultTableModel modelo = new DefaultTableModel(
						new Object[][] {
							
						},
						new String[] {
								"ISBN", "Titulo", "Genero", "Editorial", "Ventas"
						}
					);
			for (Libro libro : libros) {
				Object rowdata[]= {libro.getIsbn(), libro.getTitulo(), libro.getGenero(), libro.getEditorial(), libro.getNumVentas()};
				modelo.addRow(rowdata);
			}
			tablaBestSellers.setModel(modelo);
			
		}catch(Exception e) {
			String message="Error. No se han podido encontrar libros";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
