package gui.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import model.Autor;
import model.Genero;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MantAutores extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853583411736807709L;
	private JPanel contentPane;
	private JLabel lblAñadirAutor;
	private JList<String> listaAutores;
	private JLabel lblBorrarAutor;
	private JTextField tfAñadir;
	private JButton btnAadir;
	private JButton btnEliminar;
	private JTextField tfEliminar;
	private JLabel lblListaAutores;
	private DefaultListModel<String> modeloAut;
	private String nUsuario;
	private JButton btnVolver;
	/**
	 * Create the frame.
	 */
	public MantAutores(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAñadirAutor = new JLabel("A\u00F1adir Genero");
		lblAñadirAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAñadirAutor.setBounds(27, 85, 82, 23);
		contentPane.add(lblAñadirAutor);
		
		lblBorrarAutor = new JLabel("Borrar Genero");
		lblBorrarAutor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBorrarAutor.setBounds(413, 85, 82, 23);
		contentPane.add(lblBorrarAutor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 41, 183, 264);
		contentPane.add(scrollPane);
		
		listaAutores = new JList<String>();
		scrollPane.setViewportView(listaAutores);
		
		lblListaAutores = new JLabel("Lista Autores");
		lblListaAutores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaAutores.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblListaAutores);
		
		tfAñadir = new JTextField();
		tfAñadir.setBounds(10, 119, 129, 20);
		contentPane.add(tfAñadir);
		tfAñadir.setColumns(10);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(27, 150, 89, 23);
		contentPane.add(btnAadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(413, 150, 89, 23);
		contentPane.add(btnEliminar);
		
		tfEliminar = new JTextField();
		tfEliminar.setBounds(388, 119, 129, 20);
		contentPane.add(tfEliminar);
		tfEliminar.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(428, 308, 89, 23);
		contentPane.add(btnVolver);
		
		cargarAutores();
		
		btnAadir.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnVolver.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAadir) {
			añadirAutor();
		}
		else if(e.getSource()==btnEliminar) {
			eliminarAutor();
		}
		else if(e.getSource()==btnVolver) {
			InicioAdmin inicio = new InicioAdmin(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
		
	}
	
	public void cargarAutores() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<String> autores = logic.cargarAutores();
			modeloAut = new DefaultListModel<String>();
			for (String s : autores) {
				modeloAut.addElement(s);
			}
			listaAutores.setModel(modeloAut);
		}catch(Exception e) {
			String message = "No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void añadirAutor() {
		String message;
		try{
			if(tfAñadir.getText().length() == 0) {
				message="El campo autor debe estar lleno";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				Autor autor = new Autor(); 
				autor.setNomAutor(tfAñadir.getText());
				if(autor.getNomAutor().length()<4) {
					autor.setCodAutor(autor.getNomAutor().substring(0, autor.getNomAutor().length()).toUpperCase());
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
				modeloAut.addElement(autor.getNomAutor());
				tfAñadir.setText("");
				
			}
		}catch(Exception e) {
			message="No se ha podido comprobar el autor";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	private void eliminarAutor() {
		//TODO crear el procedimiento en la base de datos y escribir el codigo de acceso
	}
}
