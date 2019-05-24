package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import model.Libro;
import model.Usuario;

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
	 * 
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
	private String nUsuario;
	private String nIsbn;
	private JComboBox cbGenero;
	private JButton btnMasAutores;
	private JButton btnGuardar;
	private JList listAutores;
	private JTextField tfCodAutor;
	private JTextField tfNombre;
	private DefaultListModel modelo;
	private JLabel lblNombre;
	private JLabel lblCodigoDeAutor;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String Usuario;
			private String Isbn;

			public void run() {
				try {
					ModificarLibro frame = new ModificarLibro(Usuario, Isbn);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModificarLibro(String usuario, String isbn) {
		nUsuario = usuario;
		nIsbn = isbn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 698);
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
		separator.setBounds(0, 56, 784, 2);
		contentPane.add(separator);
		
		lblIsbn = new JLabel("*ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(92, 99, 50, 14);
		contentPane.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setEditable(false);
		tfIsbn.setForeground(new Color(0, 0, 205));
		tfIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIsbn.setBounds(161, 99, 145, 14);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(88, 330, 61, 14);
		contentPane.add(lblPrecio);
		
		btnModificarLibro = new JButton("Modificar");
		btnModificarLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarLibro.setForeground(new Color(0, 0, 255));
		btnModificarLibro.setBounds(357, 92, 167, 31);
		contentPane.add(btnModificarLibro);
		
		lblApellidos = new JLabel("*T\u00EDtulo:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(85, 127, 56, 22);
		contentPane.add(lblApellidos);
		
		tfTitulo = new JTextField();
		tfTitulo.setEditable(false);
		tfTitulo.setForeground(new Color(0, 0, 205));
		tfTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(161, 131, 145, 14);
		contentPane.add(tfTitulo);
		
		lblAutor = new JLabel("*Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(83, 167, 61, 14);
		contentPane.add(lblAutor);
		
		lblFechaPubli = new JLabel("Fecha publicaci\u00F3n:");
		lblFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaPubli.setBounds(27, 294, 121, 14);
		contentPane.add(lblFechaPubli);
		
		tfFechaPubli = new JTextField();
		tfFechaPubli.setEditable(false);
		tfFechaPubli.setForeground(new Color(0, 0, 205));
		tfFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFechaPubli.setColumns(10);
		tfFechaPubli.setBounds(162, 294, 86, 14);
		contentPane.add(tfFechaPubli);
		
		tfPrecio = new JTextField();
		tfPrecio.setEditable(false);
		tfPrecio.setForeground(new Color(0, 0, 205));
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(162, 330, 145, 14);
		contentPane.add(tfPrecio);
		
		lblOferta = new JLabel("Oferta:");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOferta.setBounds(94, 363, 79, 14);
		contentPane.add(lblOferta);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVolver.setBounds(473, 618, 103, 31);
		contentPane.add(btnVolver);
		
		chckbxOfertaSi = new JCheckBox("S\u00ED");
		chckbxOfertaSi.setEnabled(false);
		chckbxOfertaSi.setBounds(168, 361, 50, 23);
		contentPane.add(chckbxOfertaSi);
		
		chckbxOfertaNo = new JCheckBox("No");
		chckbxOfertaNo.setEnabled(false);
		chckbxOfertaNo.setBounds(215, 361, 50, 23);
		contentPane.add(chckbxOfertaNo);
		
		tfDescuento = new JTextField();
		tfDescuento.setEditable(false);
		tfDescuento.setForeground(new Color(0, 0, 205));
		tfDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescuento.setColumns(10);
		tfDescuento.setBounds(246, 391, 61, 16);
		contentPane.add(tfDescuento);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(162, 393, 74, 14);
		contentPane.add(lblDescuento);
		
		lblStock = new JLabel("*Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(91, 415, 61, 14);
		contentPane.add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setEditable(false);
		tfStock.setForeground(new Color(0, 0, 205));
		tfStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfStock.setColumns(10);
		tfStock.setBounds(162, 418, 66, 14);
		contentPane.add(tfStock);
		
		lblGenero = new JLabel("*G\u00E9nero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(81, 452, 68, 14);
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
		lblFormateFecha.setBounds(253, 296, 74, 14);
		contentPane.add(lblFormateFecha);
		
		btnMasAutores = new JButton("+");
		btnMasAutores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMasAutores.setBounds(478, 222, 47, 17);
		contentPane.add(btnMasAutores);
		
		btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnGuardar.setBounds(357, 134, 167, 37);
		contentPane.add(btnGuardar);
		
		cbGenero = new JComboBox();
		cbGenero.setEnabled(false);
		cbGenero.setBounds(379, 450, 145, 16);
		contentPane.add(cbGenero);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(161, 167, 152, 116);
		contentPane.add(scrollPane);
		
		listAutores = new JList();
		listAutores.setEnabled(false);
		modelo = new DefaultListModel();
		listAutores.setModel(modelo);
		scrollPane.setViewportView(listAutores);
		
		lblCodigoDeAutor = new JLabel("Codigo de Autor");
		lblCodigoDeAutor.setBounds(342, 182, 91, 14);
		contentPane.add(lblCodigoDeAutor);
		
		tfCodAutor = new JTextField();
		tfCodAutor.setEditable(false);
		tfCodAutor.setBounds(347, 202, 121, 20);
		contentPane.add(tfCodAutor);
		tfCodAutor.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(342, 233, 46, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setBounds(347, 250, 121, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		
		btnVolver.addActionListener(this);
		btnModificarLibro.addActionListener(this);
		btnMasAutores.addActionListener(this);
		btnGuardar.addActionListener(this);
		
		//cargarDatos();
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
		}
		
	}

	@SuppressWarnings("unchecked")
	private void comprobarCampos() {
		if(tfCodAutor.getText().length() == 0 || tfNombre.getText().length() == 0) {
			String message="Los campos deben estar llenos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			String autor = tfNombre.getText();
			modelo.addElement(autor);
			tfNombre.setText("");
			tfCodAutor.setText("");
		}
		
	}

	private void guardarCambios() {
		btnGuardar.setEnabled(false);
		tfIsbn.setEditable(false);
		tfTitulo.setEditable(false);
		listAutores.setEnabled(false);
		tfPrecio.setEditable(false);
		tfFechaPubli.setEditable(false);
		tfStock.setEditable(false);
		tfDescuento.setEditable(false);
		tfDescripcion.setEditable(false);
		tfNombre.setEditable(false);
		tfCodAutor.setEditable(false);
		chckbxOfertaSi.setEnabled(false);
		chckbxOfertaNo.setEnabled(false);
		cbGenero.setEnabled(false);
		btnModificarLibro.setEnabled(true);
	}

	private void modificarLibro() {
		tfIsbn.setEditable(true);
		tfTitulo.setEditable(true);
		listAutores.setEnabled(true);
		tfPrecio.setEditable(true);
		tfFechaPubli.setEditable(true);
		tfStock.setEditable(true);
		tfDescuento.setEditable(true);
		tfDescripcion.setEditable(true);
		tfNombre.setEditable(true);
		tfCodAutor.setEditable(true);
		chckbxOfertaSi.setEnabled(true);
		chckbxOfertaNo.setEnabled(true);
		cbGenero.setEnabled(true);
		btnModificarLibro.setEnabled(false);
		btnGuardar.setEnabled(true);
		
		
		
	}
}
