package control;

import java.util.ArrayList;

public interface DataAccess {
	
	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception;
	
	public void registrarUsuario() throws Exception;
	
	public void listarBestsellers() throws Exception;
	
	public void insertarLibro() throws Exception;
	
	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws Exception;
	
	public void verRecomendados(String nUsuario) throws Exception;
	
	public void buscarLibro(String busqueda) throws Exception;
	
	public void modificarLibro(String isbn) throws Exception;
	
	public void consultarCompras(String nUsuario) throws Exception;
}
