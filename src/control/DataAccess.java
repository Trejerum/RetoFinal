package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public interface DataAccess {
	
	public boolean validarUsuario(String nUsuario, String contraseña) throws SQLException, ClassNotFoundException, IOException;
	
	public void registrarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void listarBestsellers() throws SQLException, ClassNotFoundException, IOException;
	
	public void insertarLibro() throws SQLException, ClassNotFoundException, IOException;
	
	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void verRecomendados(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public void buscarLibro(String busqueda) throws SQLException, ClassNotFoundException, IOException;
	
	public void modificarLibro(String isbn) throws SQLException, ClassNotFoundException, IOException;
	
	public void consultarCompras(String nUsuario) throws SQLException, ClassNotFoundException, IOException;
	
	public boolean comprobarNUsuario(String nUsuario) throws SQLException, ClassNotFoundException, IOException;

}
