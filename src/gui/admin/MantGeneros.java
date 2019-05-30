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
import model.Genero;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MantGeneros extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8853583411736807709L;
	private JPanel contentPane;
	private JLabel lblAñadirGenero;
	private JList<String> listaGeneros;
	private JLabel lblBorrarGenero;
	private JTextField tfAñadir;
	private JButton btnAadir;
	private JButton btnEliminar;
	private JTextField tfEliminar;
	private JLabel lblListaGeneros;
	private DefaultListModel<String> modeloGen;
	private String nUsuario;
	private JButton btnVolver;
	private JButton btnCargar;
	/**
	 * Create the frame.
	 */
	public MantGeneros(String usuario) {
		nUsuario=usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAñadirGenero = new JLabel("A\u00F1adir Genero");
		lblAñadirGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAñadirGenero.setBounds(27, 85, 82, 23);
		contentPane.add(lblAñadirGenero);
		
		lblBorrarGenero = new JLabel("Borrar Genero");
		lblBorrarGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBorrarGenero.setBounds(476, 85, 82, 23);
		contentPane.add(lblBorrarGenero);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(172, 41, 183, 264);
		contentPane.add(scrollPane);
		
		listaGeneros = new JList<String>();
		scrollPane.setViewportView(listaGeneros);
		
		lblListaGeneros = new JLabel("Lista Generos");
		lblListaGeneros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListaGeneros.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblListaGeneros);
		
		tfAñadir = new JTextField();
		tfAñadir.setBounds(10, 119, 129, 20);
		contentPane.add(tfAñadir);
		tfAñadir.setColumns(10);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(27, 150, 89, 23);
		contentPane.add(btnAadir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(469, 150, 89, 23);
		contentPane.add(btnEliminar);
		
		tfEliminar = new JTextField();
		tfEliminar.setBounds(444, 119, 129, 20);
		contentPane.add(tfEliminar);
		tfEliminar.setColumns(10);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(428, 308, 89, 23);
		contentPane.add(btnVolver);
		
		btnCargar = new JButton(">>>");
		btnCargar.setBounds(365, 118, 69, 23);
		contentPane.add(btnCargar);
		
		cargarGeneros();
		
		btnAadir.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnVolver.addActionListener(this);
		btnCargar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAadir) {
			añadirGenero();
		}
		else if(e.getSource()==btnEliminar) {
			eliminarGenero();
		}
		else if(e.getSource()==btnVolver) {
			InicioAdmin inicio = new InicioAdmin(nUsuario);
			inicio.setVisible(true);
			this.dispose();
		}
		else if(e.getSource()==btnCargar) {
			pasarGenero();
		}
		
	}
	
	public void cargarGeneros() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<String> generos = logic.cargarGeneros();
			modeloGen = new DefaultListModel<String>();
			for (String s : generos) {
				modeloGen.addElement(s);
			}
			listaGeneros.setModel(modeloGen);
		}catch(Exception e) {
			String message = "No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void añadirGenero() {
		String message;
		try{
			if(tfAñadir.getText().length() == 0) {
				message="El campo genero debe estar lleno";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				Genero genero = new Genero();
				genero.setNomGenero(tfAñadir.getText());
				if(genero.getNomGenero().length()<4) {
					genero.setCodGenero(genero.getNomGenero().substring(0, genero.getNomGenero().length()).toUpperCase());
				}
				else {
					genero.setCodGenero(genero.getNomGenero().substring(0, 3).toUpperCase());
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
				modeloGen.addElement(genero.getNomGenero());
				tfAñadir.setText("");
			}
		}catch(Exception e) {
			message="No se ha podido comprobar el autor";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void eliminarGenero() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			logic.borrarGen(tfEliminar.getText());
			modeloGen.removeElement(tfEliminar.getText());
			message="Genero borrado correctamente";
			JOptionPane.showMessageDialog(this, message, "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			message="No se ha podido comprobar el genero";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void pasarGenero() {
		tfEliminar.setText(listaGeneros.getSelectedValue());
	}
}
