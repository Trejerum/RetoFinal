package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Autor;
import model.Genero;
import model.Usuario;

public interface DataAccess {
	
	public boolean validarUsuario(String nUsuario, String contraseña) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsUsuarios(Usuario usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsUConvencional(Usuario usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsGustoAutor(String autor, String usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void regUsGustoGenero(String genero, String usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void listarBestsellers() throws SQLException, ClassNotFoundException, IOException;
	
	public void insertarLibro() throws SQLException, ClassNotFoundException, IOException;
	
	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void verRecomendados(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void buscarLibro(String busqueda) throws SQLException, ClassNotFoundException, IOException;
	
	public void modificarLibro(String isbn) throws SQLException, ClassNotFoundException, IOException;
	
	public void consultarCompras(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public boolean comprobarNUsuario(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<Genero> cargarGeneros() throws SQLException, ClassNotFoundException, IOException;
	
	public ArrayList<Autor> cargarAutores() throws SQLException, ClassNotFoundException, IOException;

}
