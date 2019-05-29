package control;

import java.util.ArrayList;

import model.Autor;
import model.Compra;
import model.Genero;
import model.Libro;
import model.Usuario;

public interface Logic {

	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception;
	
	public void registrarUsuario(Usuario usuario, ArrayList<String> autoresSelec, ArrayList<String> generosSelec) throws Exception;
	
	public ArrayList<Libro> listarBestsellers() throws Exception;
	
	public void insertarLibro(Libro libro, ArrayList<Autor> autores) throws Exception;
	
	public void comprarLibro(Compra compra) throws Exception;
	
	public ArrayList<Libro> verRecomendados(String nUsuario) throws Exception;
	
	public ArrayList<Libro> buscarLibro(String busqueda) throws Exception;
	
	public void modificarLibro(Libro libro) throws Exception;
	
	public ArrayList<Compra> consultarCompras(String nUsuario) throws Exception;
	
	public boolean comprobarNUsuario(String nUsuario) throws Exception;
	
	public ArrayList<String> cargarGeneros() throws Exception;
	
	public ArrayList<String> cargarAutores() throws Exception;

	public Usuario cargarUsuario(String nUsuario, boolean esAdmin) throws Exception;
	
	public void guardarCambios(Usuario usuario) throws Exception;

	public Libro cargarLibro(String isbn) throws Exception;

	public ArrayList<Autor> cargarAutoresLibro(String isbn) throws Exception;
	
	public boolean esAdmin(String nUsuario) throws Exception;
	
	public void insertarAutor(Autor autor) throws Exception;
	
	public boolean existeAutor(Autor autor) throws Exception;
	
	public void insertarGenero(Genero genero) throws Exception;
	
	public boolean existeGenero(String genero) throws Exception;
	
	public Autor cargarAutor(String autor) throws Exception;
	
	public void guardarDatosLibro(Libro libro, Autor autor) throws Exception;
	
	

}
