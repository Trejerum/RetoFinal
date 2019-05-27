package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Autor;
import model.Compra;
import model.Libro;
import model.Usuario;

public interface DataAccess {
	
	public boolean validarUsuario(String nUsuario, String contraseña) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsUsuarios(Usuario usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsUConvencional(Usuario usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsGustoAutor(String autor, String usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsGustoGenero(String genero, String usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<Libro> listarBestsellers() throws SQLException, ClassNotFoundException, IOException;
	
	public void insertarLibro() throws SQLException, ClassNotFoundException, IOException;
	
	public void comprarLibro(Compra compra) throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<Libro> verRecomendados(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<Libro> buscarLibro(String busqueda) throws SQLException, ClassNotFoundException, IOException;
	
	public void modificarLibro(String isbn) throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<Compra> consultarCompras(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public boolean comprobarNUsuario(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<String> cargarGeneros() throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<String> cargarAutores() throws SQLException, ClassNotFoundException, IOException;

	public Usuario cargarUsuario(String nUsuario) throws SQLException, ClassNotFoundException, IOException;

	public void guardarCambiosUCon(Usuario usuario, String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void guardarCambiosUs(Usuario usuario, String nUsuario) throws SQLException, ClassNotFoundException, IOException;

	public Libro cargarLibro(String isbn) throws SQLException, ClassNotFoundException, IOException;

	public ArrayList<Autor> cargarAutoresLibro(String isbn) throws SQLException, ClassNotFoundException, IOException;
	
	public void aumentarVentas(String isbn, int cantidad) throws SQLException, ClassNotFoundException, IOException;
	
	public boolean esAdmin(String nUsuario) throws SQLException, ClassNotFoundException, IOException;

}
