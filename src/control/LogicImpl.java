package control;

import java.util.ArrayList;

import model.Autor;
import model.Compra;
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

	public ArrayList<Libro> listarBestsellers() throws Exception {
		ArrayList<Libro> libros = dataAccess.listarBestsellers();
		return libros;
		
	}

	public void insertarLibro(Libro libro) throws Exception {
		dataAccess.insertarLibro(libro);
		
	}

	public void comprarLibro(Compra compra) throws Exception {
		dataAccess.comprarLibro(compra);
		dataAccess.aumentarVentas(compra.getIsbn(), compra.getUnidades());
		
	}

	public ArrayList<Libro> verRecomendados(String nUsuario) throws Exception {
		ArrayList<Libro> libros = dataAccess.verRecomendados(nUsuario);
		return libros;
	}

	public ArrayList<Libro> buscarLibro(String busqueda) throws Exception {
		ArrayList<Libro> libros = dataAccess.buscarLibro(busqueda);
		return libros;		
	}

	public void modificarLibro(Libro libro) throws Exception {
		dataAccess.modificarLibro(libro);
		
	}

	public ArrayList<Compra> consultarCompras(String nUsuario) throws Exception {
		ArrayList<Compra> compras = dataAccess.consultarCompras(nUsuario);
		return compras;
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

	public void guardarCambios(Usuario usuario) throws Exception {
		dataAccess.guardarCambiosUCon(usuario);
		dataAccess.guardarCambiosUs(usuario);
		
	}

	public Libro cargarLibro(String isbn) throws Exception {
		Libro libro = dataAccess.cargarLibro(isbn);
		return libro;
		
	}

	public ArrayList<Autor> cargarAutoresLibro(String isbn) throws Exception {
		ArrayList<Autor> autores = dataAccess.cargarAutoresLibro(isbn);
		return autores;
	}

	@Override
	public boolean esAdmin(String nUsuario) throws Exception {
		Boolean esAdmin=dataAccess.esAdmin(nUsuario);
		return esAdmin;
	}

	
}
