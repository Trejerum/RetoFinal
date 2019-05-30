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

/**
 * Esta ventana te muestra la lista de los libros
 * 
 * @author EquipoB
 *
 */
public class ListaLibros extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8708312469028487504L;
	private JPanel contentPane;
	private JButton btnModificar;
	private JLabel lblSeleccionaUnLibro;
	private JScrollPane scrollPane;
	private JTable tablaLibros;
	private JButton btnVolver;
	private String nUsuario;

	/**
	 * Create the frame.
	 * 
	 * @param usuario
	 */
	public ListaLibros(String usuario) {
		setResizable(false);
		nUsuario = usuario;
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
		tablaLibros.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ISBN", "Titulo" }));
		scrollPane.setViewportView(tablaLibros);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(334, 229, 89, 23);
		contentPane.add(btnModificar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(334, 263, 90, 25);
		contentPane.add(btnVolver);

		cargarLibros();

		// ActionListener
		btnModificar.addActionListener(this);
		btnVolver.addActionListener(this);
	}

	@Override
	/**
	 * Aqui se dan funciones a los botones
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			String isbn = getIsbn();
			ModificarLibro modificarLibro = new ModificarLibro(nUsuario, isbn);
			modificarLibro.setVisible(true);
			this.dispose();
		} else if (e.getSource() == btnVolver) {
			InicioAdmin inicio = new InicioAdmin(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}

	}

	/**
	 * Esta funcion te lleva a la base datos y te carga los libros en la tabla
	 */
	public void cargarLibros() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<Libro> libros = new ArrayList<Libro>();
			String busqueda = "";
			libros = logic.buscarLibro(busqueda);
			DefaultTableModel modelo = new DefaultTableModel(new Object[][] {

			}, new String[] { "ISBN", "Titulo" });
			for (Libro libro : libros) {
				Object rowdata[] = { libro.getIsbn(), libro.getTitulo() };
				modelo.addRow(rowdata);
			}
			tablaLibros.setModel(modelo);

		} catch (Exception e) {
			String message = "Error. No se han podido encontrar libros";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Ets funcion sirve para sacar el ISBN del libro seleccionado en la tabla
	 * 
	 * @return isbn
	 */
	public String getIsbn() {
		int columna = 0;
		int fila = tablaLibros.getSelectedRow();
		String isbn = tablaLibros.getModel().getValueAt(fila, columna).toString();
		return isbn;
	}
}
