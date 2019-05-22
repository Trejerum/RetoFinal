package control;

import java.util.ArrayList;

import model.Autor;
import model.Genero;
import model.Usuario;

public interface Logic {

	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception;
	
	public void registrarUsuario(Usuario usuario, ArrayList<String> autoresSelec, ArrayList<String> generosSelec) throws Exception;
	
	public void listarBestsellers() throws Exception;
	
	public void insertarLibro() throws Exception;
	
	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws Exception;
	
	public void verRecomendados(String nUsuario) throws Exception;
	
	public void buscarLibro(String busqueda) throws Exception;
	
	public void modificarLibro(String isbn) throws Exception;
	
	public void consultarCompras(String nUsuario) throws Exception;
	
	public boolean comprobarNUsuario(String nUsuario) throws Exception;
	
	public ArrayList<String> cargarGeneros() throws Exception;
	
	public ArrayList<String> cargarAutores() throws Exception;

	public Usuario cargarUsuario(String nUsuario) throws Exception;

}
