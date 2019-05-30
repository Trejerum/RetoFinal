package gui.user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Logic;
import control.LogicFactory;
import model.Autor;
import model.Genero;
import model.GustoAutor;
import model.GustoGenero;

import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class GustosUser extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2372092442772435617L;
	private JPanel contentPane;
	private JButton btnAñadirGen;
	private JButton btnAñadirAut;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList<String> listaAutores;
	private JLabel lblGustos;
	private JList<String> listaGustosAutores;
	private JList<String> listaGeneros;
	private JList<String> listaGustosGeneros;
	private String nUsuario;
	private DefaultListModel<String> modeloAut;
	private DefaultListModel<String> modeloGen;
	private DefaultListModel<String> modeloGustAut;
	private DefaultListModel<String> modeloGustGen;
	private JButton btnBorrarAut;
	private JButton btnBorrarGen;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 * @param nUsuario 
	 */
	public GustosUser(String usuario){
		nUsuario=usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(176, 196, 222));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 154, 144);
		contentPane.add(scrollPane);
		
		listaAutores = new JList<String>();
		listaAutores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaAutores);
		
		JLabel lblA = new JLabel("Autores");
		scrollPane.setColumnHeaderView(lblA);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 53, 143, 144);
		contentPane.add(scrollPane_1);
		
		listaGustosAutores = new JList<String>();
		listaGustosAutores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listaGustosAutores);
		
		JLabel lblAutoresQueTe = new JLabel("Autores que te interesan");
		scrollPane_1.setColumnHeaderView(lblAutoresQueTe);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 222, 154, 152);
		contentPane.add(scrollPane_2);
		
		listaGeneros = new JList<String>();
		listaGeneros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(listaGeneros);
		
		JLabel lblGeneros = new JLabel("Generos ");
		scrollPane_2.setColumnHeaderView(lblGeneros);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(299, 222, 143, 152);
		contentPane.add(scrollPane_3);
		
		listaGustosGeneros = new JList<String>();
		listaGustosGeneros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_3.setViewportView(listaGustosGeneros);
		
		JLabel lblGenerosQueTe = new JLabel("Generos que te interesan");
		scrollPane_3.setColumnHeaderView(lblGenerosQueTe);
		
		btnAñadirAut = new JButton(">>>");
		btnAñadirAut.setBounds(174, 99, 104, 23);
		contentPane.add(btnAñadirAut);
		
		btnAñadirGen = new JButton(">>>");
		btnAñadirGen.setBounds(174, 276, 104, 23);
		contentPane.add(btnAñadirGen);
		
		lblGustos = new JLabel("Gustos");
		lblGustos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGustos.setBounds(186, 11, 81, 31);
		contentPane.add(lblGustos);
		
		btnBorrarAut = new JButton("<<<");
		btnBorrarAut.setBounds(174, 133, 104, 23);
		contentPane.add(btnBorrarAut);
		
		btnBorrarGen = new JButton("<<<");
		btnBorrarGen.setBounds(174, 310, 104, 23);
		contentPane.add(btnBorrarGen);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(366, 395, 89, 23);
		contentPane.add(btnVolver);
		
		cargarDatos();
		
		btnBorrarAut.addActionListener(this);
		btnBorrarGen.addActionListener(this);
		btnAñadirAut.addActionListener(this);
		btnAñadirGen.addActionListener(this);
		btnVolver.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAñadirAut) {
			añadirAut();
		}
		else if(e.getSource()==btnAñadirGen) {
			añadirGen();
		}
		else if(e.getSource()==btnBorrarAut) {
			borrarAut();
		}
		else if(e.getSource()==btnBorrarGen) {
			borrarGen();
		}
		else if(e.getSource()==btnVolver) {
			PerfilUser perfil = new PerfilUser(nUsuario);
			perfil.setVisible(true);
			this.dispose();
		}
		
	}
	
	private void añadirAut() {
		String message;
		try{
			Logic logic = LogicFactory.getLogic();
			Autor autor = new Autor(); 
			autor.setNomAutor(listaAutores.getSelectedValue());
			logic.añadirGustoAut(nUsuario, autor.getNomAutor());
			modeloGustAut.addElement(autor.getNomAutor());
		}catch(Exception e) {
			message="El autor ya esta añadido";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void añadirGen() {
		String message;
		boolean repetido=false;
		try{
			Logic logic = LogicFactory.getLogic();
			Genero genero = new Genero(); 
			genero.setNomGenero(listaGeneros.getSelectedValue());
			ArrayList<String> gustosGen = logic.cargarGustosAut(nUsuario);
			for (String string : gustosGen) {
				if(string.equalsIgnoreCase(genero.getNomGenero())) {
					repetido=true;
				}
			}
			if(repetido) {
				message="El genero ya esta añadido";
				JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				logic.añadirGustoGen(nUsuario, genero.getNomGenero());
				modeloGustGen.addElement(genero.getNomGenero());
			}
		}catch(Exception e) {
			message="El genero ya esta añadido";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void borrarAut() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			logic.borrarGustoAut(nUsuario, listaGustosAutores.getSelectedValue());
			modeloGustAut.remove(listaGustosAutores.getSelectedIndex());
		}catch(Exception e) {
			message="No se ha podido borrar el autor";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void borrarGen() {
		String message;
		try {
			Logic logic = LogicFactory.getLogic();
			logic.borrarGustoGen(nUsuario, listaGustosGeneros.getSelectedValue());
			modeloGustGen.remove(listaGustosGeneros.getSelectedIndex());
		}catch(Exception e) {
			message="No se ha podido borrar el genero";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void cargarDatos() {
		try {
			Logic logic = LogicFactory.getLogic();
			ArrayList<String> autores = logic.cargarAutores();
			modeloAut = new DefaultListModel<String>();
			for (String s : autores) {
				modeloAut.addElement(s);
			}
			ArrayList<String> generos = logic.cargarGeneros();
			modeloGen = new DefaultListModel<String>();
			for (String s : generos) {
				modeloGen.addElement(s);
			}
			listaGeneros.setModel(modeloGen);
			listaAutores.setModel(modeloAut);
			ArrayList<String> gustosAut = logic.cargarGustosAut(nUsuario);
			modeloGustAut = new DefaultListModel<String>();
			for (String gustoAutor : gustosAut) {
				modeloGustAut.addElement(gustoAutor);
			}
			ArrayList<String> gustosGen = logic.cargarGustosGen(nUsuario);
			modeloGustGen = new DefaultListModel<String>();
			for (String gustoGenero : gustosGen) {
				modeloGustGen.addElement(gustoGenero);
			}
			listaGustosAutores.setModel(modeloGustAut);
			listaGustosGeneros.setModel(modeloGustGen);
			
		}catch(Exception e) {
			String message = "No se han podido cargar los datos";
			JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
