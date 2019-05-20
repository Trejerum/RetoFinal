package gui.admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class ModificarLibro extends JFrame {

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
	private JTextField tfGenero;
	private JLabel lblModificarLibro;
	private JSeparator separator;
	private JLabel lblIsbn;
	private JLabel lblPrecio;
	private JButton btnModificarLibro;
	private JLabel lblApellidos;
	private JLabel lblAutor;
	private JTextField tfAutor;
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
	private JLabel lblFormateFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarLibro frame = new ModificarLibro();
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
	public ModificarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 597);
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
		tfIsbn.setForeground(new Color(0, 0, 205));
		tfIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfIsbn.setBounds(161, 99, 145, 14);
		contentPane.add(tfIsbn);
		tfIsbn.setColumns(10);
		
		lblPrecio = new JLabel("*Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(87, 293, 61, 14);
		contentPane.add(lblPrecio);
		
		btnModificarLibro = new JButton("Modificar");
		btnModificarLibro.setEnabled(false);
		btnModificarLibro.setFont(new Font("Arial", Font.PLAIN, 15));
		btnModificarLibro.setForeground(new Color(0, 0, 255));
		btnModificarLibro.setBounds(350, 141, 167, 31);
		contentPane.add(btnModificarLibro);
		
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
		lblFechaPubli.setBounds(26, 257, 121, 14);
		contentPane.add(lblFechaPubli);
		
		tfFechaPubli = new JTextField();
		tfFechaPubli.setForeground(new Color(0, 0, 205));
		tfFechaPubli.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFechaPubli.setColumns(10);
		tfFechaPubli.setBounds(161, 257, 86, 14);
		contentPane.add(tfFechaPubli);
		
		tfPrecio = new JTextField();
		tfPrecio.setForeground(new Color(0, 0, 205));
		tfPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(161, 293, 145, 14);
		contentPane.add(tfPrecio);
		
		lblOferta = new JLabel("Oferta:");
		lblOferta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOferta.setBounds(93, 326, 79, 14);
		contentPane.add(lblOferta);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCancelar.setBounds(351, 99, 167, 31);
		contentPane.add(btnCancelar);
		
		chckbxOfertaSi = new JCheckBox("S\u00ED");
		chckbxOfertaSi.setBounds(167, 324, 50, 23);
		contentPane.add(chckbxOfertaSi);
		
		chckbxOfertaNo = new JCheckBox("No");
		chckbxOfertaNo.setBounds(214, 324, 50, 23);
		contentPane.add(chckbxOfertaNo);
		
		tfDescuento = new JTextField();
		tfDescuento.setForeground(new Color(0, 0, 205));
		tfDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDescuento.setEditable(false);
		tfDescuento.setColumns(10);
		tfDescuento.setBounds(245, 354, 61, 16);
		contentPane.add(tfDescuento);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(161, 356, 74, 14);
		contentPane.add(lblDescuento);
		
		lblStock = new JLabel("*Stock:");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStock.setBounds(90, 378, 61, 14);
		contentPane.add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setForeground(new Color(0, 0, 205));
		tfStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfStock.setColumns(10);
		tfStock.setBounds(161, 381, 66, 14);
		contentPane.add(tfStock);
		
		tfGenero = new JTextField();
		tfGenero.setForeground(new Color(0, 0, 205));
		tfGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfGenero.setColumns(10);
		tfGenero.setBounds(161, 406, 150, 14);
		contentPane.add(tfGenero);
		
		lblGenero = new JLabel("*G\u00E9nero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(80, 403, 68, 14);
		contentPane.add(lblGenero);
		
		lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(64, 431, 79, 14);
		contentPane.add(lblDescripcion);
		
		tfDescripcion = new JTextArea();
		tfDescripcion.setBounds(161, 433, 247, 84);
		contentPane.add(tfDescripcion);
		
		lblFormateFecha = new JLabel("(dd-mm-yyyy)");
		lblFormateFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormateFecha.setBounds(252, 259, 74, 14);
		contentPane.add(lblFormateFecha);
		
		JButton button = new JButton("+");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(87, 192, 47, 17);
		contentPane.add(button);
		
		JLabel label = new JLabel("Pulse para poder a\u00F1adir un autor m\u00E1s.");
		label.setBounds(161, 193, 247, 14);
		contentPane.add(label);
		
		
		
		
		
	}
}
