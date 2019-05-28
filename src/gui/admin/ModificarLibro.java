package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import model.Libro;

import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ModificarLibro extends JFrame implements ActionListener{

	/**
	 * TODO Comprobar si el autor esta ya en la lista
	 */
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
	private JButton btnModificarLibro;
	private JLabel lblApellidos;
	private JLabel lblAutor;
	private JLabel lblFechaPubli;
	private JLabel lblOferta;
	private JButton btnVolver;
	private JCheckBox chckbxOfertaSi;
	private JCheckBox chckbxOfertaNo;
	private JLabel lblDescuento;
	private JLabel lblStock;
	private JLabel lblGenero;
	private JLabel lblDescripcion;
	private JTextArea tfDescripcion;
	private JLabel lblFormateFecha;
	private JComboBox<String> cbGenero;
	private JButton btnMasAutores;
	private JButton btnGuardar;
	private JTextField tfCodAutor;
	private JTextField tfNombreAutor;
	private JLabel lblNombre;
	private JLabel lblCodigoDeAutor;
	private JTextField tfGenero;
	private JLabel lblNuevoGenero;
	private JLabel lblNuevoAutor;
	private JLabel lblNombre_1;
	private JTextField tfNombreGenero;
	private JButton btnMasGeneros;
	private JComboBox<String> cbAutor;
	private JButton btnPasarGenero;
	private JButton btnPasarAutor;
	private JButton btnEliminarAutor;
	DefaultListModel<String> modeloLista = new DefaultListModel<String>();
	private JList<String> listAutores;
	private String nisbn;
	private String nusuario;
	


	/**
	 * Create the frame.
	 */

	public ModificarLibro(String usuario, String isbn) {
		nisbn = isbn;
		nusuario = usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 712);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModificarLibro = new JLabel("Modificar libro");
		lblModificarLibro.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblModificarLibro.setBounds(20, 13, 255, 37);
		contentPane.add(lblModificarLibro);
		
		separator = new JSeparator();
		separator.setBounds(0, 56, 816, 2);
		contentPane.add(separator);
		
		lblIsbn = new JLabel("*ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(88, 119, 50, 20);
		contentPane.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setEditable(false);
		tfIsbn.setForeground(new Color(0, 0, 205));
		tfIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIsbn.setBounds(157, 119, 145, 20);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(88, 331, 61, 20);
		contentPane.add(lblPrecio);
		
		btnModificarLibro = new JButton("Modificar");
		btnModificarLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarLibro.setForeground(new Color(0, 0, 255));
		btnModificarLibro.setBounds(593, 69, 167, 31);
		contentPane.add(btnModificarLibro);
		
		lblApellidos = new JLabel("*T\u00EDtulo:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(81, 172, 56, 20);
		contentPane.add(lblApellidos);
		
		tfTitulo = new JTextField();
		tfTitulo.setEditable(false);
		tfTitulo.setForeground(new Color(0, 0, 205));
		tfTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(157, 176, 145, 20);
		contentPane.add(tfTitulo);
		
		lblAutor = new JLabel("*Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(81, 220, 61, 20);
		contentPane.add(lblAutor);
		
		lblFechaPubli = new JLabel("Fecha publicaci\u00F3n:");
		lblFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaPubli.setBounds(27, 282, 121, 14);
		contentPane.add(lblFechaPubli);
		
		tfFechaPubli = new JTextField();
		tfFechaPubli.setEditable(false);
		tfFechaPubli.setForeground(new Color(0, 0, 205));
		tfFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFechaPubli.setColumns(10);
		tfFechaPubli.setBounds(162, 282, 86, 20);
		contentPane.add(tfFechaPubli);
		
		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setForeground(new Color(0, 0, 205));
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(162, 331, 145, 20);
		contentPane.add(tfPrecio);
		
		lblOferta = new JLabel("Oferta:");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOferta.setBounds(88, 371, 79, 14);
		contentPane.add(lblOferta);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(635, 626, 122, 37);
		contentPane.add(btnVolver);
		
		chckbxOfertaSi = new JCheckBox("S\u00ED");
		chckbxOfertaSi.setEnabled(false);
		chckbxOfertaSi.setBounds(162, 369, 50, 23);
		contentPane.add(chckbxOfertaSi);
		
		chckbxOfertaNo = new JCheckBox("No");
		chckbxOfertaNo.setEnabled(false);
		chckbxOfertaNo.setBounds(209, 369, 50, 23);
		contentPane.add(chckbxOfertaNo);
		
		tfDescuento = new JTextField();
		tfDescuento.setEditable(false);
		tfDescuento.setForeground(new Color(0, 0, 205));
		tfDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescuento.setColumns(10);
		tfDescuento.setBounds(248, 399, 61, 16);
		contentPane.add(tfDescuento);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(163, 400, 74, 14);
		contentPane.add(lblDescuento);
		
		lblStock = new JLabel("*Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(91, 432, 61, 14);
		contentPane.add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setEditable(false);
		tfStock.setForeground(new Color(0, 0, 205));
		tfStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfStock.setColumns(10);
		tfStock.setBounds(162, 435, 66, 20);
		contentPane.add(tfStock);
		
		lblGenero = new JLabel("*G\u00E9nero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(74, 485, 68, 20);
		contentPane.add(lblGenero);
		
		lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(63, 557, 79, 14);
		contentPane.add(lblDescripcion);
		
		tfDescripcion = new JTextArea();
		tfDescripcion.setEditable(false);
		tfDescripcion.setBounds(161, 554, 247, 84);
		contentPane.add(tfDescripcion);
		
		lblFormateFecha = new JLabel("(dd-mm-yyyy)");
		lblFormateFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormateFecha.setBounds(253, 284, 74, 14);
		contentPane.add(lblFormateFecha);
		
		btnMasAutores = new JButton("+");
		btnMasAutores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMasAutores.setBounds(526, 164, 50, 20);
		contentPane.add(btnMasAutores);
		
		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardar.setBounds(593, 111, 167, 37);
		contentPane.add(btnGuardar);
		
		cbGenero = new JComboBox<String>();
		cbGenero.setEnabled(false);
		cbGenero.setBounds(380, 485, 120, 20);
		contentPane.add(cbGenero);
		cbGenero.setSelectedIndex(-1);
		
		lblCodigoDeAutor = new JLabel("Codigo de Autor");
		lblCodigoDeAutor.setBounds(380, 119, 91, 14);
		contentPane.add(lblCodigoDeAutor);
		
		tfCodAutor = new JTextField();
		tfCodAutor.setBounds(380, 139, 120, 20);
		contentPane.add(tfCodAutor);
		tfCodAutor.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(380, 170, 46, 14);
		contentPane.add(lblNombre);
		
		tfNombreAutor = new JTextField();
		tfNombreAutor.setBounds(380, 190, 120, 20);
		contentPane.add(tfNombreAutor);
		tfNombreAutor.setColumns(10);
		
		tfGenero = new JTextField();
		tfGenero.setEditable(false);
		tfGenero.setBounds(162, 485, 145, 20);
		contentPane.add(tfGenero);
		tfGenero.setColumns(10);
		
		lblNuevoGenero = new JLabel("NUEVO GENERO");
		lblNuevoGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevoGenero.setBounds(420, 394, 123, 14);
		contentPane.add(lblNuevoGenero);
		
		lblNuevoAutor = new JLabel("NUEVO AUTOR");
		lblNuevoAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevoAutor.setBounds(420, 99, 129, 15);
		contentPane.add(lblNuevoAutor);
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(380, 420, 46, 14);
		contentPane.add(lblNombre_1);
		
		tfNombreGenero = new JTextField();
		tfNombreGenero.setBounds(380, 445, 120, 20);
		contentPane.add(tfNombreGenero);
		tfNombreGenero.setColumns(10);
		
		btnMasGeneros = new JButton("+");
		btnMasGeneros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMasGeneros.setBounds(515, 445, 50, 20);
		contentPane.add(btnMasGeneros);
		
		cbAutor = new JComboBox<String>();
		cbAutor.setEnabled(false);
		cbAutor.setBounds(380, 250, 120, 20);
		cbAutor.setSelectedIndex(-1);
		contentPane.add(cbAutor);
		
		btnPasarGenero = new JButton("<<<");
		btnPasarGenero.setEnabled(false);
		btnPasarGenero.setBounds(314, 485, 61, 20);
		contentPane.add(btnPasarGenero);
		
		btnPasarAutor = new JButton("<<<");
		btnPasarAutor.setEnabled(false);
		btnPasarAutor.setBounds(314, 250, 61, 20);
		contentPane.add(btnPasarAutor);
		
		btnEliminarAutor = new JButton(">>>");
		btnEliminarAutor.setEnabled(false);
		btnEliminarAutor.setBounds(316, 220, 56, 20);
		contentPane.add(btnEliminarAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 207, 145, 63);
		contentPane.add(scrollPane);
		
		listAutores = new JList<String>();
		listAutores.setEnabled(false);
		scrollPane.setViewportView(listAutores);
		modeloLista = new DefaultListModel<String>();
		listAutores.setModel(modeloLista);
		
		
		btnVolver.addActionListener(this);
		btnModificarLibro.addActionListener(this);
		btnMasAutores.addActionListener(this);
		btnGuardar.addActionListener(this);
		btnMasGeneros.addActionListener(this);
		btnPasarAutor.addActionListener(this);
		btnEliminarAutor.addActionListener(this);
		
		
		
		cargarDatos(isbn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver) {
			InicioAdmin inicioAdmin = new InicioAdmin();
			inicioAdmin.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnModificarLibro) {
			modificarLibro();
		}else if(e.getSource()==btnGuardar) {
			guardarCambios();
		}else if(e.getSource()==btnMasAutores) {
			comprobarCampos();
		}else if(e.getSource()== btnMasGeneros)  {
			comprobarGenero();
		}else if(e.getSource() == btnPasarAutor) {
			pasarAutor();
		}else if(e.getSource() == btnEliminarAutor) {
			eliminarAutor();
		}
		
	}

	private void eliminarAutor() {
		try {
			int eliminar = listAutores.getSelectedIndex();
			modeloLista.remove(eliminar);
		}catch (Exception e) {
			String message="Selecciona el autor en la Lista";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}

	private void pasarAutor() {
		try{
			String autor = cbAutor.getSelectedItem().toString();
			modeloLista.addElement(autor);
			cbAutor.setSelectedIndex(-1);
			
		}catch (Exception e) {
			String message="Selecciona el autor en la Combo Box";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void comprobarGenero() {
		if(tfNombreGenero.getText().length() == 0) {
			String message="El campo genero debe estar lleno";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			String genero = tfNombreGenero.getText();
			cbGenero.addItem(genero);
			cbGenero.setSelectedIndex(-1);
			tfNombreGenero.setText("");
		}
		
	}

	private void comprobarCampos() {
		if(tfCodAutor.getText().length() == 0 || tfNombreAutor.getText().length() == 0) {
			String message="Los campos deben estar llenos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			String autor = tfNombreAutor.getText();
			cbAutor.addItem(autor);
			cbAutor.setSelectedIndex(-1);
			tfNombreAutor.setText("");
			tfCodAutor.setText("");
		}
		
	}

	private void guardarCambios() {
		btnGuardar.setEnabled(false);
		tfIsbn.setEditable(false);
		tfTitulo.setEditable(false);
		tfPrecio.setEditable(false);
		tfFechaPubli.setEditable(false);
		tfStock.setEditable(false);
		tfDescuento.setEditable(false);
		tfDescripcion.setEditable(false);
		chckbxOfertaSi.setEnabled(false);
		chckbxOfertaNo.setEnabled(false);
		cbAutor.setEnabled(false);
		cbGenero.setEnabled(false);
		btnModificarLibro.setEnabled(true);
		btnPasarAutor.setEnabled(false);
		btnPasarGenero.setEnabled(false);
		btnEliminarAutor.setEnabled(false);
		listAutores.setEnabled(true);
		
	}

	private void modificarLibro() {
		tfIsbn.setEditable(true);
		tfTitulo.setEditable(true);
		tfPrecio.setEditable(true);
		tfFechaPubli.setEditable(true);
		tfStock.setEditable(true);
		tfDescuento.setEditable(true);
		tfDescripcion.setEditable(true);
		tfNombreAutor.setEditable(true);
		chckbxOfertaSi.setEnabled(true);
		chckbxOfertaNo.setEnabled(true);
		cbAutor.setEnabled(true);
		cbGenero.setEnabled(true);
		btnModificarLibro.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnPasarAutor.setEnabled(true);
		btnPasarGenero.setEnabled(true);
		btnEliminarAutor.setEnabled(true);
		listAutores.setEnabled(true);
			
	}
	
	public void cargarDatos(String isbn) {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			Libro libro = new Libro();
			libro = logic.cargarLibro(isbn);
			tfIsbn.setText(libro.getIsbn());
			tfTitulo.setText(libro.getTitulo());
			//listAutores.add(libro.getAutor());
			//tfFechaPubli.setText(libro.getFechaPublicacion().toString());
			tfPrecio.setText(String.valueOf(libro.getPrecio()));
			tfDescuento.setText(String.valueOf(libro.getDescuento()));
			tfGenero.setText(libro.getGenero());
			tfDescripcion.setText(libro.getDescripcion());
		}catch(Exception e) {
			message="Error. No se pudo cargar el libro";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
	    }
	}
	
}
