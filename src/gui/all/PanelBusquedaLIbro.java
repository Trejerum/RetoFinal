package gui.all;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Libro;

public class PanelBusquedaLIbro extends JPanel {
	private JTable tablaBusqueda;
	private JPanel contentPane;
	private JTextField tfBusqueda;
	private JLabel lblBuscar;
	private JSeparator menu_separator;
	private JLabel lblResultados;
	private JButton btnBuscarLupa;
	
	
	/**
	 * Create the panel.
	 */
	
	public PanelBusquedaLIbro() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 122, 561, 236);
		add(scrollPane);
		
		tablaBusqueda = new JTable();
		tablaBusqueda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "Titulo", "Genero", "Editorial", "Precio"
			}
		));
		scrollPane.setViewportView(tablaBusqueda);
		
		JButton btnVerDescripcion = new JButton("Ver descripcion");
		btnVerDescripcion.setBounds(641, 202, 105, 40);
		add(btnVerDescripcion);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Maiandra GD", Font.PLAIN, 23));
		lblBuscar.setBounds(10, 22, 89, 27);
		add(lblBuscar);
	}
}
