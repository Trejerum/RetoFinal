package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import control.Logic;
import control.LogicFactory;
import model.Compra;
import model.Libro;
import model.Usuario;

import javax.swing.JSpinner;
/**
 * Esta ventana sirve para confirmar la compra de un libro
 * @author EquipoB
 *
 */
public class ConfirmarCompra extends JFrame implements ActionListener, ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196680677816620968L;
	private JPanel contentPane;
	private JLabel lblConfirmarCompra;
	private JSeparator separator;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JTable tabla;
	private String nUsuario;
	private DefaultTableModel modelo;
	private JLabel lblInformacion;
	private JLabel lblNombreDeUsuario;
	private JLabel lblNumeroDeCuenta;
	private JLabel lblFechaCompra;
	private JSpinner spinner;
	private JScrollPane scrollPane;
	private JLabel lblValorUsuario;
	private JLabel lblValorCuenta;
	private JLabel lblValorFecha;
	private String isbnCompra;
	private double precioFinal;
	private double precioLibro;
	private double descuentoLibro;

	/**
	 * Create the frame.
	 * @param nUsuario 
	 */
	public ConfirmarCompra(String isbn, String usuario) {
		nUsuario=usuario;
		isbnCompra=isbn;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 384);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConfirmarCompra = new JLabel("Confirmar compra");
		lblConfirmarCompra.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblConfirmarCompra.setBounds(10, 20, 349, 27);
		contentPane.add(lblConfirmarCompra);
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(543, 308, 89, 23);
		contentPane.add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setBounds(377, 308, 134, 23);
		contentPane.add(btnConfirmar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 202, 427, 57);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		modelo = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
						"ISBN", "Titulo", "Precio", "Descuento", "Precio Final"
				}
			);
		tabla.setModel(modelo);
		scrollPane.setViewportView(tabla);
		
		spinner = new JSpinner();
		spinner.setBounds(473, 226, 42, 20);
		contentPane.add(spinner);
		
		lblInformacion = new JLabel("Informacion: ");
		lblInformacion.setBounds(36, 77, 89, 14);
		contentPane.add(lblInformacion);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
		lblNombreDeUsuario.setBounds(53, 104, 150, 14);
		contentPane.add(lblNombreDeUsuario);
		
		lblNumeroDeCuenta = new JLabel("Numero de cuenta:");
		lblNumeroDeCuenta.setBounds(53, 129, 118, 14);
		contentPane.add(lblNumeroDeCuenta);
		
		lblFechaCompra = new JLabel("Fecha compra: ");
		lblFechaCompra.setBounds(53, 154, 100, 14);
		contentPane.add(lblFechaCompra);
		
		lblValorUsuario = new JLabel("New label");
		lblValorUsuario.setBounds(170, 104, 100, 14);
		contentPane.add(lblValorUsuario);
		
		lblValorCuenta = new JLabel("New label");
		lblValorCuenta.setBounds(170, 129, 100, 14);
		contentPane.add(lblValorCuenta);
		
		lblValorFecha = new JLabel("New label");
		lblValorFecha.setBounds(147, 154, 89, 14);
		contentPane.add(lblValorFecha);
		
		cargarDatos(isbn);
		
		btnCancelar.addActionListener(this);
		btnConfirmar.addActionListener(this);
		spinner.addChangeListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancelar) {
			BusquedaUser busqueda = new BusquedaUser(nUsuario);
			busqueda.setVisible(true);
			this.dispose();
		}
		else {
			comprar();
		}
	}
	/**
	 * Esta funcion sirve para cargar los datos del libro que el anteriormente ha seleccionado en la tabla, pasando el ISBN
	 * @param isbn
	 */
	public void cargarDatos(String isbn) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			Logic logic = LogicFactory.getLogic();
			Libro libro = logic.cargarLibro(isbn);
			precioLibro = libro.getPrecio();
			spinner.setValue(1);
			descuentoLibro = libro.getDescuento();
			precioFinal = libro.getPrecio() - libro.getPrecio() * (libro.getDescuento()/100);
			Object rowdata[]= {libro.getIsbn(), libro.getTitulo(), libro.getPrecio(), libro.getDescuento(), precioFinal};
			modelo.addRow(rowdata);
			tabla.setModel(modelo);
			Usuario usuario = logic.cargarUsuario(nUsuario, logic.esAdmin(nUsuario));
			lblValorCuenta.setText(String.valueOf(usuario.getNumCuenta()));
			lblValorUsuario.setText(nUsuario);
			LocalDate fecha=LocalDate.now();
			lblValorFecha.setText(fecha.format(formatter));
		}catch(Exception e) {
			String message = "Error. No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	/**
	 * Esta funcion sirve para que el usuario pueda comprar libros
	 */
	public void comprar() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			Usuario usuario = logic.cargarUsuario(nUsuario, logic.esAdmin(nUsuario));
			Compra compra = new Compra();
			Date fecha = convertToDate(LocalDate.parse(lblValorFecha.getText(), formatter));
			compra.setFechaCompra(fecha);
			compra.setNombreUsuario(nUsuario);
			compra.setNumCuenta(usuario.getNumCuenta());
			compra.setIsbn(isbnCompra);
			compra.setUnidades((Integer) spinner.getValue()); 
			double importeTotal = precioFinal * (Integer) spinner.getValue();
			compra.setImporteTotal(importeTotal);
			logic.comprarLibro(compra);
			
			message = "Compra realizada correctamente";
			JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
			
			InicioUser inicio = new InicioUser(nUsuario);
			inicio.setVisible(true);
			this.dispose();
			
		}catch(Exception e) {
			message = "Error. No se ha podido realizar la compra";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public Date convertToDate(LocalDate fechaAConvertir) {
	    return Date.valueOf(fechaAConvertir);
	}

	@Override
	/**
	 * Esta funcion sirve para saber cuantas unidades quiere comprar de un libro el usuario
	 */
	public void stateChanged(ChangeEvent e) {
		if((Integer) spinner.getValue()<=0) {
			spinner.setValue(1);
		}
		int cantidad = (Integer) spinner.getValue();
		precioFinal = precioLibro * cantidad - (precioLibro * cantidad) * (descuentoLibro/100);
		modelo.setValueAt(precioFinal, 0, 4);
	}
}
