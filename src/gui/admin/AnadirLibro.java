package gui.admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Logic;
import control.LogicFactory;
import model.Autor;
import model.Genero;
import model.Libro;
import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
/**
 * Esta ventana sirve para amafir un libro a la libreria
 * @author EquipoB
 *
 */
public class AnadirLibro extends JFrame implements ActionListener{

	private static final long serialVersionUID = -146475275276116997L;
	private JPanel contentPane;
	private JTextField tfIsbn;
	private JTextField tfTitulo;
	private JTextField tfFechaPubli;
	private JTextField tfPrecio;
	private JTextField tfDescuento;
	private JTextField tfStock;
	private JLabel lblModificarLibro;
	private JSeparator separator;
	private JLabel lblIsbn;
	private JLabel lblPrecio;
	private JButton btnAñadirLibro;
	private JLabel lblTitulo;
	private JLabel lblAutor;
	private JLabel lblFechaPubli;
	private JLabel lblOferta;
	private JButton btnVolver;
	private JLabel lblDescuento;
	private JLabel lblStock;
	private JLabel lblGenero;
	private JLabel lblDescripcion;
	private JTextArea taDescripcion;
	private JLabel lblFormateFecha;
	private JComboBox<String> cbGenero;
	private JButton btnMasAutores;
	private JTextField tfNombreAutor;
	private JLabel lblNombreAutor;
	private JTextField tfGenero;
	private JLabel lblNuevoGenero;
	private JLabel lblNuevoAutor;
	private JLabel lblNombreGenero;
	private JTextField tfNombreGenero;
	private JButton btnMasGeneros;
	private JComboBox<String> cbAutor;
	private JButton btnPasarGenero;
	private JButton btnPasarAutor;
	private JButton btnEliminarAutor;
	DefaultListModel<String> modeloLista = new DefaultListModel<String>();
	private JList<String> listaAutores;
	private String nUsuario;
	private JLabel lblEditorial;
	private JTextField tfEditorial;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private ButtonGroup rdbtnGrp;
	private JTextField tfNumVentas;
	private JLabel lblSeleccionarAutores;
	private JLabel lblSeleccionarGenero;
	private JLabel lblAadirGenero;
	private JLabel lblAdirAutor;
	private JLabel lblnumventas;


	/**
	 * Create the frame.
	 */

	public AnadirLibro(String usuario) {
		nUsuario = usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 712);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta Añadir Libro, cabezera de la ventana
		lblModificarLibro = new JLabel("A\u00F1adir Libro");
		lblModificarLibro.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblModificarLibro.setBounds(20, 13, 255, 37);
		contentPane.add(lblModificarLibro);
		
		//Separador entre la cabezera del cuerpo
		separator = new JSeparator();
		separator.setBounds(0, 56, 816, 2);
		contentPane.add(separator);
		
		//Espacio para meter el ISBN del libro
		lblIsbn = new JLabel("*ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(88, 90, 50, 20);
		contentPane.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setForeground(new Color(0, 0, 205));
		tfIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIsbn.setBounds(148, 90, 145, 20);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		//Espacio para meter el Precio del libro
		lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(88, 331, 61, 20);
		contentPane.add(lblPrecio);

		tfPrecio = new JTextField();
		tfPrecio.setEditable(true);
		tfPrecio.setForeground(new Color(0, 0, 205));
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(162, 331, 145, 20);
		contentPane.add(tfPrecio);
		
		//Espacio para meter el Titulo del libro
		lblTitulo = new JLabel("*T\u00EDtulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(82, 134, 56, 20);
		contentPane.add(lblTitulo);
		
		tfTitulo = new JTextField();
		tfTitulo.setEditable(true);
		tfTitulo.setForeground(new Color(0, 0, 205));
		tfTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(148, 134, 197, 20);
		contentPane.add(tfTitulo);
		
		//Lista donde metes los autores del libro
		lblAutor = new JLabel("*Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(81, 220, 61, 20);
		contentPane.add(lblAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 207, 145, 63);
		contentPane.add(scrollPane);
		
		listaAutores = new JList<String>();
		listaAutores.setEnabled(true);
		scrollPane.setViewportView(listaAutores);
		modeloLista = new DefaultListModel<String>();
		listaAutores.setModel(modeloLista);
		
		//Lugar donde metes la fecha de publicacion
		lblFechaPubli = new JLabel("Fecha publicaci\u00F3n:");
		lblFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaPubli.setBounds(27, 282, 121, 14);
		contentPane.add(lblFechaPubli);
		
		tfFechaPubli = new JTextField();
		tfFechaPubli.setEditable(true);
		tfFechaPubli.setForeground(new Color(0, 0, 205));
		tfFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFechaPubli.setColumns(10);
		tfFechaPubli.setBounds(162, 282, 86, 20);
		contentPane.add(tfFechaPubli);
		
		lblFormateFecha = new JLabel("(dd-mm-yyyy)");
		lblFormateFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormateFecha.setBounds(253, 284, 74, 14);
		contentPane.add(lblFormateFecha);
		
		//Sirve para seleccionar si el libro tiene oferta o no
		lblOferta = new JLabel("Oferta:");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOferta.setBounds(88, 371, 79, 14);
		contentPane.add(lblOferta);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(162, 369, 40, 23);
		contentPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(218, 369, 109, 23);
		contentPane.add(rdbtnNo);
		
		rdbtnGrp = new ButtonGroup();
		rdbtnGrp.add(rdbtnNo);
		rdbtnGrp.add(rdbtnSi);
		
		// Boton para volver a la pestaña anterior
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(635, 626, 122, 37);
		contentPane.add(btnVolver);
		
		//Lugar donde metes el descuento del libro
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(163, 400, 74, 14);
		contentPane.add(lblDescuento);
		
		tfDescuento = new JTextField();
		tfDescuento.setEditable(true);
		tfDescuento.setForeground(new Color(0, 0, 205));
		tfDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescuento.setColumns(10);
		tfDescuento.setBounds(248, 399, 61, 16);
		contentPane.add(tfDescuento);
		
		
		//Lugar donde metes el stock que tienes del libro
		lblStock = new JLabel("*Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(91, 432, 61, 14);
		contentPane.add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setEditable(true);
		tfStock.setForeground(new Color(0, 0, 205));
		tfStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfStock.setColumns(10);
		tfStock.setBounds(162, 435, 66, 20);
		contentPane.add(tfStock);
		
		//Sirve para añadir un genero y para crear uno nuevo
		lblGenero = new JLabel("*G\u00E9nero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(81, 497, 68, 20);
		contentPane.add(lblGenero);
		
		tfGenero = new JTextField();
		tfGenero.setEditable(true);
		tfGenero.setBounds(162, 499, 145, 20);
		contentPane.add(tfGenero);
		tfGenero.setColumns(10);
		
		tfNombreGenero = new JTextField();
		tfNombreGenero.setBounds(380, 454, 120, 20);
		contentPane.add(tfNombreGenero);
		tfNombreGenero.setColumns(10);
		
		cbGenero = new JComboBox<String>();
		cbGenero.setEnabled(true);
		cbGenero.setBounds(380, 499, 120, 20);
		contentPane.add(cbGenero);
		cbGenero.setSelectedIndex(-1);

		lblNuevoGenero = new JLabel("NUEVO GENERO");
		lblNuevoGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevoGenero.setBounds(414, 402, 123, 14);
		contentPane.add(lblNuevoGenero);
		
		btnPasarGenero = new JButton("<<<");
		btnPasarGenero.setEnabled(true);
		btnPasarGenero.setBounds(314, 499, 61, 20);
		contentPane.add(btnPasarGenero);

		lblSeleccionarGenero = new JLabel("Seleccionar genero: ");
		lblSeleccionarGenero.setBounds(380, 485, 120, 14);
		contentPane.add(lblSeleccionarGenero);
		
		lblNombreGenero = new JLabel("Nombre");
		lblNombreGenero.setBounds(380, 434, 46, 14);
		contentPane.add(lblNombreGenero);
		
		btnMasGeneros = new JButton("+");
		btnMasGeneros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMasGeneros.setBounds(510, 454, 50, 20);
		contentPane.add(btnMasGeneros);
		
		lblAadirGenero = new JLabel("A\u00F1adir genero");
		lblAadirGenero.setBounds(575, 457, 86, 14);
		contentPane.add(lblAadirGenero);

		//Descripcion
		lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(63, 557, 79, 14);
		contentPane.add(lblDescripcion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(157, 540, 419, 111);
		contentPane.add(scrollPane_1);
		
		taDescripcion = new JTextArea();
		scrollPane_1.setViewportView(taDescripcion);
		taDescripcion.setEditable(true);
		taDescripcion.setLineWrap(true);
		
		//Autores
		btnMasAutores = new JButton("+");
		btnMasAutores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMasAutores.setBounds(510, 172, 50, 20);
		contentPane.add(btnMasAutores);

		lblNombreAutor = new JLabel("Nombre");
		lblNombreAutor.setBounds(380, 152, 46, 14);
		contentPane.add(lblNombreAutor);
		
		tfNombreAutor = new JTextField();
		tfNombreAutor.setBounds(380, 172, 120, 20);
		contentPane.add(tfNombreAutor);
		tfNombreAutor.setColumns(10);
		
		lblNuevoAutor = new JLabel("NUEVO AUTOR");
		lblNuevoAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevoAutor.setBounds(414, 123, 129, 15);
		contentPane.add(lblNuevoAutor);
		
		cbAutor = new JComboBox<String>();
		cbAutor.setEnabled(true);
		cbAutor.setBounds(380, 250, 163, 20);
		cbAutor.setSelectedIndex(-1);
		contentPane.add(cbAutor);

		btnAñadirLibro = new JButton("Añadir Libro");
		btnAñadirLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAñadirLibro.setForeground(new Color(0, 0, 255));
		btnAñadirLibro.setBounds(593, 69, 167, 31);
		contentPane.add(btnAñadirLibro);
		
		btnPasarAutor = new JButton("<<<");
		btnPasarAutor.setEnabled(true);
		btnPasarAutor.setBounds(314, 250, 61, 20);
		contentPane.add(btnPasarAutor);
		
		btnEliminarAutor = new JButton(">>>");
		btnEliminarAutor.setEnabled(true);
		btnEliminarAutor.setBounds(316, 220, 56, 20);
		contentPane.add(btnEliminarAutor);
		
		lblSeleccionarAutores = new JLabel("Seleccionar Autores:");
		lblSeleccionarAutores.setBounds(380, 226, 120, 14);
		contentPane.add(lblSeleccionarAutores);
		
		lblAdirAutor = new JLabel("A\u00F1adir autor");
		lblAdirAutor.setBounds(570, 177, 91, 14);
		contentPane.add(lblAdirAutor);
		
		//Editorial
		lblEditorial = new JLabel("*Editorial:");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEditorial.setBounds(74, 173, 86, 14);
		contentPane.add(lblEditorial);
		
		tfEditorial = new JTextField();
		tfEditorial.setForeground(new Color(0, 0, 205));
		tfEditorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEditorial.setEditable(true);
		tfEditorial.setBounds(148, 172, 167, 20);
		contentPane.add(tfEditorial);
		tfEditorial.setColumns(10);
		
		//Numero de ventas
		lblnumventas = new JLabel("*NumVentas: ");
		lblnumventas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnumventas.setBounds(63, 472, 104, 14);
		contentPane.add(lblnumventas);
		
		tfNumVentas = new JTextField();
		tfNumVentas.setEditable(true);
		tfNumVentas.setBounds(162, 468, 86, 20);
		contentPane.add(tfNumVentas);
		tfNumVentas.setColumns(10);
		
		//ActionListener
		btnVolver.addActionListener(this);
		btnAñadirLibro.addActionListener(this);
		btnMasAutores.addActionListener(this);
		btnMasGeneros.addActionListener(this);
		btnPasarAutor.addActionListener(this);
		btnEliminarAutor.addActionListener(this);
		btnPasarGenero.addActionListener(this);
		
		cargarDatos();
	}

	@Override
	/**
	 * Aqui se dan funciones a los botones
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver) {
			InicioAdmin inicio = new InicioAdmin(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnAñadirLibro) {
			AñadirLibro();
		}else if(e.getSource()==btnMasAutores) {
			comprobarAutor();
		}else if(e.getSource()== btnMasGeneros)  {
			comprobarGenero();
		}else if(e.getSource() == btnPasarAutor) {
			pasarAutor();
		}else if(e.getSource() == btnEliminarAutor) {
			eliminarAutor();
		}else if(e.getSource()== btnPasarGenero) {
			pasarGenero();
		}
		
	}
	/**
	 * Esta funcion sirve para eliminar un autor de la lista del libro
	 */
	private void eliminarAutor() {
		try {
			int eliminar = listaAutores.getSelectedIndex();
			modeloLista.remove(eliminar);
		}catch (Exception e) {
			String message="Selecciona el autor en la Lista";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}
	/**
	 * Esta funcion sirve para pasar un autor de la combo box a la lista de autores
	 */
	private void pasarAutor() {
		try{
			String autor = cbAutor.getSelectedItem().toString();
			modeloLista.addElement("-" + autor);
			cbAutor.setSelectedIndex(-1);
			
		}catch (Exception e) {
			String message="Selecciona el autor en la Combo Box";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Esta funcion sirve para pasar un genero de la combo box al textField de genero
	 */
	private void pasarGenero() {
		try {
			String genero = cbGenero.getSelectedItem().toString();
			tfGenero.setText(genero);
			cbGenero.setSelectedIndex(-1);
		}catch(Exception e) {
			String message="Selecciona el genero en la Combo Box";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Comprueba si el textField del genero que quiere crear esta vacio o no, despues si ese genero ya esta creado en la tabla y
	 * si todo es correcto los inserta en la combobox
	 */
	private void comprobarGenero() {
		String message;
		try{
			if(tfNombreGenero.getText().length() == 0) {
				message="El campo genero debe estar lleno";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
				
			}else {
				Genero genero = new Genero();
				genero.setNomGenero(tfNombreGenero.getText());
				if(genero.getNomGenero().length()<4) {
					genero.setCodGenero(genero.getNomGenero().substring(0, genero.getNomGenero().length()));
				}
				else {
					genero.setCodGenero(genero.getNomGenero().substring(0, 3));
				}
				Logic logic = LogicFactory.getLogic();
				if(!logic.existeGenero(genero.getCodGenero())) {
					logic.insertarGenero(genero);
					message="Genero insertado correctamente";
					JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					message="El genero ya existe";
					JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				cbGenero.addItem(genero.getNomGenero());
				tfNombreGenero.setText("");
			}
		}catch(Exception e) {
			message="No se ha podido comprobar el genero";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	/**
	 * Comprueba si el textField del nombre del autor y del codigo del autor que quiere crear esta vacio o no, despues si ese autor ya esta creado en la tabla y
	 * si todo esta correcto los inserta en la combobox
	 */
	private void comprobarAutor() {
		String message;
		try{
			if(tfNombreAutor.getText().length() == 0) {
				message="El campo autor debe estar lleno";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				Autor autor = new Autor(); 
				autor.setNomAutor(tfNombreAutor.getText());
				if(autor.getNomAutor().length()<4) {
					autor.setCodAutor(autor.getNomAutor().substring(0, autor.getNomAutor().length()));
				}
				else {
					autor.setCodAutor(autor.getNomAutor().substring(0, 3).toUpperCase());
				}
				Logic logic = LogicFactory.getLogic();
				if(!logic.existeAutor(autor)) {
					logic.insertarAutor(autor);
					message="Autor insertado correctamente";
					JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					message="El autor ya existe";
					JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
				}
				cbAutor.addItem(autor.getNomAutor());
				tfNombreAutor.setText("");
				
			}
		}catch(Exception e) {
			message="No se ha podido comprobar el autor";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	/**
	 * Esta funcion inserta los datos que hemos introducido del libro en la tabla de libros
	 */
	private void AñadirLibro() {
		String message;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			Logic logic = LogicFactory.getLogic();
			Libro libro = new Libro();
			libro.setIsbn(tfIsbn.getText());
			libro.setTitulo(tfTitulo.getText());
			libro.setEditorial(tfEditorial.getText());
			libro.setDescripcion(taDescripcion.getText());
			libro.setFechaPublicacion(LocalDate.parse(tfFechaPubli.getText(), formatter));
			libro.setGenero(tfGenero.getText());
			libro.setPrecio(Double.parseDouble(tfPrecio.getText()));
			libro.setStock(Integer.parseInt(tfStock.getText()));
			libro.setDescuento(Double.parseDouble(tfDescuento.getText()));
			Enumeration<AbstractButton> botones = rdbtnGrp.getElements();
			while (botones.hasMoreElements()) {
				AbstractButton b = (AbstractButton) botones.nextElement();
				if(b.isSelected()) {
					libro.setOferta(Boolean.parseBoolean(b.getText()));
				}
			}
			libro.setNumVentas(Integer.parseInt(tfNumVentas.getText()));
			ArrayList<Autor> autores = new ArrayList<Autor>();
			
			ListModel<String> modelo = listaAutores.getModel();
			for (int i = 0; i < modelo.getSize() ; i++) {
				Autor autor = logic.cargarAutor(modelo.getElementAt(i).substring(1));
				autores.add(autor);
			}
			logic.insertarLibro(libro, autores);
			message="Libro añadido correctamente";
			JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
			vaciarTf();

		}catch(Exception e) {
			message="Error. No se ha podido añadir el libro";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Esta funcion carga en las combo Box los autores y genero de la lista
	 */
	public void cargarDatos() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<String> autores = logic.cargarAutores();
			ArrayList<String> generos = logic.cargarGeneros();
			for (String string : generos) {
				cbGenero.addItem(string);
			}
			for (String string : autores) {
				cbAutor.addItem(string);
			}
		}catch(Exception e) {
			message="Error. No se pudo cargar el libro";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	/**
	 * 
	 */
	public void vaciarTf() {
		tfIsbn.setText("");
		tfTitulo.setText("");
		listaAutores.setModel(modeloLista);
		tfPrecio.setText("");
		tfDescuento.setText("");
		tfGenero.setText("");
		taDescripcion.setText("");
		tfFechaPubli.setText("");
		tfStock.setText("");
		tfEditorial.setText("");
		tfNumVentas.setText("");
		rdbtnSi.setSelected(false);
		rdbtnNo.setSelected(false);
	}
}
