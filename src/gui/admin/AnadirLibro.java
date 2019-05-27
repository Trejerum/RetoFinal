package gui.admin;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
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

public class AnadirLibro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7256736251514104367L;
	private JPanel contentPane;
	private JTextField tfIsbn;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfFechaPubli;
	private JTextField tfPrecio;
	private JTextField tfDescuento;
	private JTextField tfStock;
	private JLabel lblEAnadirLibro;
	private JSeparator separator;
	private JLabel lblIsbn;
	private JLabel lblPrecio;
	private JButton btnAñadirLibro;
	private JLabel lblApellidos;
	private JLabel lblAutor;
	private JLabel lblFechaPubli;
	private JLabel lblOferta;
	private JButton btnCancelar;
	private JCheckBox chckbxOfertaSi;
	private JCheckBox chckbxOfertaNo;
	private JLabel lblDescuento;
	private JLabel lblStock;
	private JLabel lblGenero;
	private JLabel lblDescripcion;
	private JTextArea tfDescripcion;
	private JButton btnMasAutores;
	private JLabel label;

	/**
	 * Create the frame.
	 * @param nUsuario 
	 */
	public AnadirLibro(String nUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 597);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEAnadirLibro = new JLabel("A\u00F1adir libro");
		lblEAnadirLibro.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		lblEAnadirLibro.setBounds(20, 13, 255, 37);
		contentPane.add(lblEAnadirLibro);
		
		separator = new JSeparator();
		separator.setBounds(0, 56, 784, 2);
		contentPane.add(separator);
		
		lblIsbn = new JLabel("*ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIsbn.setBounds(92, 99, 50, 14);
		contentPane.add(lblIsbn);
		
		tfIsbn = new JTextField();
		tfIsbn.setForeground(new Color(0, 0, 205));
		tfIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIsbn.setBounds(161, 99, 145, 14);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(87, 306, 61, 14);
		contentPane.add(lblPrecio);
		
		btnAñadirLibro = new JButton("A\u00F1adir");
		btnAñadirLibro.setEnabled(false);
		btnAñadirLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAñadirLibro.setForeground(new Color(0, 0, 255));
		btnAñadirLibro.setBounds(350, 141, 167, 31);
		contentPane.add(btnAñadirLibro);
		
		lblApellidos = new JLabel("*T\u00EDtulo:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(85, 127, 56, 22);
		contentPane.add(lblApellidos);
		
		tfTitulo = new JTextField();
		tfTitulo.setForeground(new Color(0, 0, 205));
		tfTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTitulo.setColumns(10);
		tfTitulo.setBounds(161, 131, 145, 14);
		contentPane.add(tfTitulo);
		
		lblAutor = new JLabel("*Autor:");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAutor.setBounds(83, 167, 61, 14);
		contentPane.add(lblAutor);
		
		tfAutor = new JTextField();
		tfAutor.setForeground(new Color(0, 0, 205));
		tfAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAutor.setColumns(10);
		tfAutor.setBounds(161, 167, 145, 14);
		contentPane.add(tfAutor);
		
		lblFechaPubli = new JLabel("Fecha publicaci\u00F3n:");
		lblFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaPubli.setBounds(29, 279, 121, 14);
		contentPane.add(lblFechaPubli);
		
		tfFechaPubli = new JTextField();
		tfFechaPubli.setForeground(new Color(0, 0, 205));
		tfFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFechaPubli.setColumns(10);
		tfFechaPubli.setBounds(161, 279, 86, 14);
		contentPane.add(tfFechaPubli);
		
		tfPrecio = new JTextField();
		tfPrecio.setForeground(new Color(0, 0, 205));
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(161, 306, 145, 14);
		contentPane.add(tfPrecio);
		
		lblOferta = new JLabel("Oferta:");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOferta.setBounds(93, 339, 79, 14);
		contentPane.add(lblOferta);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCancelar.setBounds(351, 99, 167, 31);
		contentPane.add(btnCancelar);
		
		chckbxOfertaSi = new JCheckBox("S\u00ED");
		chckbxOfertaSi.setBounds(167, 337, 50, 23);
		contentPane.add(chckbxOfertaSi);
		
		chckbxOfertaNo = new JCheckBox("No");
		chckbxOfertaNo.setBounds(214, 337, 50, 23);
		contentPane.add(chckbxOfertaNo);
		
		tfDescuento = new JTextField();
		tfDescuento.setForeground(new Color(0, 0, 205));
		tfDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescuento.setEditable(false);
		tfDescuento.setColumns(10);
		tfDescuento.setBounds(245, 367, 61, 16);
		contentPane.add(tfDescuento);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(161, 369, 74, 14);
		contentPane.add(lblDescuento);
		
		lblStock = new JLabel("*Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(90, 391, 61, 14);
		contentPane.add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setForeground(new Color(0, 0, 205));
		tfStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfStock.setColumns(10);
		tfStock.setBounds(161, 394, 66, 14);
		contentPane.add(tfStock);
		
		lblGenero = new JLabel("*G\u00E9nero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(80, 416, 68, 14);
		contentPane.add(lblGenero);
		
		lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(64, 444, 79, 14);
		contentPane.add(lblDescripcion);
		
		tfDescripcion = new JTextArea();
		tfDescripcion.setBounds(161, 446, 247, 84);
		contentPane.add(tfDescripcion);
		
		btnMasAutores = new JButton("+");
		btnMasAutores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnMasAutores.setBounds(87, 198, 47, 17);
		contentPane.add(btnMasAutores);
		
		label = new JLabel("(dd-mm-yyyy)");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(255, 279, 74, 14);
		contentPane.add(label);
		
		JLabel lblMasAutores = new JLabel("Pulse para poder a\u00F1adir un autor m\u00E1s.");
		lblMasAutores.setBounds(161, 199, 247, 14);
		contentPane.add(lblMasAutores);
		
		JComboBox cbGeneros = new JComboBox();
		cbGeneros.setBounds(161, 419, 130, 14);
		contentPane.add(cbGeneros);
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
