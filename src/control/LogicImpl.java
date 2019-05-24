package control;

import java.util.ArrayList;

import model.Libro;
import model.Usuario;

public class LogicImpl implements Logic{

	private DataAccess dataAccess = DataAccessFactory.getDataAccess();


	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception {
			boolean validado = false;
			validado=dataAccess.validarUsuario(nUsuario, contraseña);
		return validado;
	}

	public void registrarUsuario(Usuario usuario, ArrayList<String> autoresSelec, ArrayList<String> generosSelec) throws Exception {
		dataAccess.regUsUsuarios(usuario);
		dataAccess.regUsUConvencional(usuario);
		for (String autor : autoresSelec) {
			dataAccess.regUsGustoAutor(autor, usuario.getNombreUsuario());
		}
		for (String genero : generosSelec) {
			dataAccess.regUsGustoGenero(genero, usuario.getNombreUsuario());
		}
	}

	public void listarBestsellers() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void insertarLibro() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void verRecomendados(String nUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Libro> buscarLibro(String busqueda) throws Exception {
		ArrayList<Libro> libros = dataAccess.buscarLibro(busqueda);
		return libros;		
	}

	public void modificarLibro(String isbn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void consultarCompras(String nUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean comprobarNUsuario(String nUsuario) throws Exception {
		Boolean repetido = dataAccess.comprobarNUsuario(nUsuario);
		return repetido;
	}

	public ArrayList<String> cargarGeneros() throws Exception {
		ArrayList<String> generos = dataAccess.cargarGeneros();
		return generos;
	}

	public ArrayList<String> cargarAutores() throws Exception {
		ArrayList<String> autores = dataAccess.cargarAutores();
		return autores;
	}

	public Usuario cargarUsuario(String nUsuario) throws Exception {
		Usuario usuario = dataAccess.cargarUsuario(nUsuario);
		return usuario;
	}

	public void guardarCambios(Usuario usuario, String nUsuario) throws Exception {
		dataAccess.guardarCambiosUCon(usuario, nUsuario);
		dataAccess.guardarCambiosUs(usuario, nUsuario);
		
	}

	
}
