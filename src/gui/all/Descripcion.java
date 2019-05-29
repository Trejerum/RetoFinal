package gui.all;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import gui.admin.BusquedaAdmin;
import gui.user.BusquedaUser;
import gui.user.ConfirmarCompra;
import model.Autor;
import model.Libro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;

public class Descripcion extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2181783806316666064L;
	private JPanel contentPane;
	private JTextArea taLibro;
	private JLabel lbltituloLibro;
	private JLabel lblPrecio;
	private JLabel lblDescuento;
	private JLabel lblValorPrecio;
	private JLabel lblValorDescuento;
	private JButton btnComprar;
	private JButton btnVolverAtras;
	private String nUsuario;
	private String selectedIsbn;

	/**
	 * Create the frame.
	 * @param isbn 
	 * @param usuario 
	 */
	public Descripcion(String isbn, String usuario) {
		selectedIsbn=isbn;
		nUsuario=usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbltituloLibro = new JLabel("(Titulo libro)");
		lbltituloLibro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltituloLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lbltituloLibro.setBounds(128, 11, 207, 35);
		contentPane.add(lbltituloLibro);
		
		taLibro = new JTextArea();
		taLibro.setEditable(false);
		taLibro.setBounds(10, 132, 622, 272);
		taLibro.setLineWrap(true);
		contentPane.add(taLibro);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(468, 43, 119, 44);
		contentPane.add(btnComprar);
		
		lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(10, 65, 46, 14);
		contentPane.add(lblPrecio);
		
		lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(10, 92, 67, 14);
		contentPane.add(lblDescuento);
		
		lblValorPrecio = new JLabel("");
		lblValorPrecio.setBounds(49, 65, 46, 14);
		contentPane.add(lblValorPrecio);
		
		lblValorDescuento = new JLabel("");
		lblValorDescuento.setBounds(75, 92, 46, 14);
		contentPane.add(lblValorDescuento);
		
		btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.setBounds(468, 98, 119, 23);
		contentPane.add(btnVolverAtras);
		
		btnComprar.addActionListener(this);
		btnVolverAtras.addActionListener(this);
		
		cargarDatos(isbn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnComprar) {
			comprar();
		}
		else {
			volverAtras();
		}
		
	}
	
	public void cargarDatos(String isbn) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			Logic logic = LogicFactory.getLogic();
			if(logic.esAdmin(nUsuario)) {
				btnComprar.setVisible(false);
			}
			Libro libro = logic.cargarLibro(isbn);
			ArrayList<Autor> autores = logic.cargarAutoresLibro(isbn);
			String fechaStr = libro.getFechaPublicacion().format(formatter);
			lbltituloLibro.setText(libro.getTitulo());
			lblValorPrecio.setText(" " + String.valueOf(libro.getPrecio()) + "€");
			lblValorDescuento.setText(" " + String.valueOf(libro.getDescuento()) + "%");
			taLibro.setText("");
			taLibro.append("Fecha de Publicacion: " + fechaStr + "\n");
			taLibro.append("ISBN: " + isbn + "\n");
			taLibro.append("Editorial: " + libro.getEditorial() + "\n");
			taLibro.append("Autor/es: ");
			int i = 0;
			for (Autor autor : autores) {
				if(i==0) {
					taLibro.append(autor.getNomAutor());
					i++;
				}
				else {
					taLibro.append(", " + autor.getNomAutor());
				}
			}
			taLibro.append("\n");
			taLibro.append("Descripcion: " + "\n");
			taLibro.append(libro.getDescripcion() + "\n");
			
		}catch(Exception e) {
			String message = "Error. No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void comprar() {
		ConfirmarCompra confirmar = new ConfirmarCompra(selectedIsbn, nUsuario);
		confirmar.setVisible(true);
		this.dispose();
	}
	
	public void volverAtras() {
		try {
			Logic logic = LogicFactory.getLogic();
			if(logic.esAdmin(nUsuario)) {
				BusquedaAdmin buscar = new BusquedaAdmin(nUsuario);
				buscar.setVisible(true);
				this.dispose();
			}else {
				BusquedaUser busqueda = new BusquedaUser(nUsuario);
				busqueda.setVisible(true);
				this.dispose();
			}	
		} catch (Exception e) {
			String message = "Error. No se ha podido volver atras";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
