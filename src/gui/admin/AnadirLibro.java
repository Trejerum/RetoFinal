package gui.admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import control.Logic;
import control.LogicFactory;
import model.Autor;
import model.Libro;
import javax.swing.JSeparator;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class AnadirLibro extends JFrame implements ActionListener{

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
	private JLabel lblAnadirLibro;
	private JSeparator separator;
	private JLabel lblIsbn;
	private JLabel lblPrecio;
	private JButton btnAnadir;
	private JLabel lblApellidos;
	private JLabel lblAutor;
	private JLabel lblFechaPubli;
	private JLabel lblOferta;
	private JButton btnVolver;
	private JLabel lblDescuento;
	private JLabel lblStock;
	private JLabel lblGenero;
	private JLabel lblDescripcion;
	private JTextArea tfDescripcion;
	private JLabel lblFormateFecha;
	private JComboBox<String> cbGenero;
	private JButton btnMasAutores;
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
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private ButtonGroup rbgOferta;
	private String nUsuario;


	/**
	 * Create the frame.
	 */

	public AnadirLibro(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 712);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAnadirLibro = new JLabel("A\u00F1adir libro");
		lblAnadirLibro.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblAnadirLibro.setBounds(20, 13, 255, 37);
		contentPane.add(lblAnadirLibro);
		
		separator = new JSeparator();
		separator.setBounds(0, 56, 816, 2);
		contentPane.add(separator);
		
		lblIsbn = new JLabel("*ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(88, 119, 50, 20);
		contentPane.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setForeground(new Color(0, 0, 205));
		tfIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIsbn.setBounds(157, 119, 145, 20);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(88, 331, 61, 20);
		contentPane.add(lblPrecio);
		
		btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAnadir.setForeground(new Color(0, 0, 255));
		btnAnadir.setBounds(593, 69, 167, 31);
		contentPane.add(btnAnadir);
		
		lblApellidos = new JLabel("*T\u00EDtulo:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(81, 172, 56, 20);
		contentPane.add(lblApellidos);
		
		tfTitulo = new JTextField();
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
		tfFechaPubli.setForeground(new Color(0, 0, 205));
		tfFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFechaPubli.setColumns(10);
		tfFechaPubli.setBounds(157, 280, 86, 20);
		contentPane.add(tfFechaPubli);
		
		tfPrecio = new JTextField();
		tfPrecio.setForeground(new Color(0, 0, 205));
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(157, 331, 145, 20);
		contentPane.add(tfPrecio);
		
		lblOferta = new JLabel("Oferta:");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOferta.setBounds(88, 371, 79, 14);
		contentPane.add(lblOferta);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(635, 626, 122, 37);
		contentPane.add(btnVolver);
		
		tfDescuento = new JTextField();
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
		
		cbGenero = new JComboBox<String>();
		cbGenero.setEditable(true);
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
		cbAutor.setBounds(380, 250, 120, 20);
		cbAutor.setSelectedIndex(-1);
		contentPane.add(cbAutor);
		
		btnPasarGenero = new JButton("<<<");
		btnPasarGenero.setBounds(314, 485, 61, 20);
		contentPane.add(btnPasarGenero);
		
		btnPasarAutor = new JButton("<<<");
		btnPasarAutor.setBounds(314, 250, 61, 20);
		contentPane.add(btnPasarAutor);
		
		btnEliminarAutor = new JButton(">>>");
		btnEliminarAutor.setBounds(316, 220, 56, 20);
		contentPane.add(btnEliminarAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 207, 145, 63);
		contentPane.add(scrollPane);
		
		listAutores = new JList<String>();
		scrollPane.setViewportView(listAutores);
		modeloLista = new DefaultListModel<String>();
		listAutores.setModel(modeloLista);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(157, 367, 33, 23);
		contentPane.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(204, 367, 39, 23);
		contentPane.add(rdbtnNo);
		
		rbgOferta = new ButtonGroup();
		rbgOferta.add(rdbtnSi);
		rbgOferta.add(rdbtnNo);
		
		btnVolver.addActionListener(this);
		btnAnadir.addActionListener(this);
		btnMasAutores.addActionListener(this);
		btnMasGeneros.addActionListener(this);
		btnPasarAutor.addActionListener(this);
		btnEliminarAutor.addActionListener(this);
		btnPasarGenero.addActionListener(this);
		
		//cargarDatos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver) {
			InicioAdmin inicioAdmin = new InicioAdmin(nUsuario);
			inicioAdmin.setVisible(true);
			this.dispose();
		}else if(e.getSource()==btnAnadir) {
			anadirLibro();
		}else if(e.getSource()==btnMasAutores) {
			comprobarCampos();
		}else if(e.getSource()== btnMasGeneros)  {
			comprobarGenero();
		}else if(e.getSource() == btnPasarAutor) {
			pasarAutor();
		}else if(e.getSource() == btnEliminarAutor) {
			eliminarAutor();
		}else if(e.getSource()==btnPasarGenero) {
			pasarGenero();
		}
		
	}

	private void pasarGenero() {
		try{
			String genero = cbGenero.getSelectedItem().toString();
			tfGenero.setText(genero);
			cbGenero.setSelectedIndex(-1);
			
		}catch (Exception e) {
			String message="Selecciona el genero en la Combo Box";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	private void anadirLibro() {
		Libro libro = new Libro();
		libro.setIsbn(tfIsbn.getText());
		libro.setTitulo(tfTitulo.getText());
		ArrayList<Autor> autores = new ArrayList<Autor>();
		for (int i = 0; i < modeloLista.getSize(); i++) {
			Autor autor = new Autor();
			autor.setNomAutor(modeloLista.getElementAt(i));
		}
		DateTimeFormatter format = DateTimeFormatter.ISO_LOCAL_DATE;
		LocalDate fechaPubli = LocalDate.parse(tfFechaPubli.getText(), format);
		libro.setFechaPublicacion(fechaPubli);
		libro.setPrecio(Double.parseDouble(tfPrecio.getText()));
		boolean oferta = false;
		if(rbgOferta.getSelection() == rdbtnSi) {
			oferta = true;
		}
		libro.setOferta(oferta);
		libro.setDescuento(Double.parseDouble(tfDescuento.getText()));
		libro.setStock(Integer.parseInt(tfStock.getText()));
		libro.setGenero(tfGenero.getText());
		libro.setDescripcion(tfDescripcion.getText());
		
		Logic logic = LogicFactory.getLogic();
		try {
			logic.insertarLibro(libro, autores);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void eliminarAutor() {
		try {
			int eliminar = listAutores.getSelectedIndex();
			modeloLista.remove(eliminar);
		}catch (Exception e) {
			String message="Selecciona el autor en la lista";
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
	
	public void cargarDatos() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			Libro libro = new Libro();
			libro = logic.cargarLibro(nisbn);
			tfIsbn.setText(libro.getIsbn());
			tfTitulo.setText(libro.getTitulo());
			//listAutores.add(libro.getAutor());
			tfFechaPubli.setText(libro.getFechaPublicacion().toString());
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
