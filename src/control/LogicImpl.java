package control;

import java.util.ArrayList;

import model.Autor;
import model.Compra;
import model.Genero;
import model.Libro;
import model.Usuario;

public class LogicImpl implements Logic {

	private DataAccess dataAccess = DataAccessFactory.getDataAccess();

	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception {
		boolean validado = false;
		validado = dataAccess.validarUsuario(nUsuario, contraseña);
		return validado;
	}

	public void registrarUsuario(Usuario usuario, ArrayList<String> autoresSelec, ArrayList<String> generosSelec)
			throws Exception {
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

	public void insertarLibro(Libro libro, ArrayList<Autor> autores) throws Exception {
		dataAccess.insertarLibro(libro);
		for (Autor autor : autores) {
			dataAccess.insertarLibroAutores(autor, libro.getIsbn());
		}
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

	public Usuario cargarUsuario(String nUsuario, boolean esAdmin) throws Exception {
		Usuario usuario = dataAccess.cargarUsuario(nUsuario, esAdmin);
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

	public boolean esAdmin(String nUsuario) throws Exception {
		Boolean esAdmin = dataAccess.esAdmin(nUsuario);
		return esAdmin;
	}

	@Override
	public void insertarAutor(Autor autor) throws Exception {
		dataAccess.insertarAutor(autor);

	}

	@Override
	public boolean existeAutor(Autor autor) throws Exception {
		boolean existeAutor = dataAccess.existeAutor(autor);
		return existeAutor;
	}

	@Override
	public void insertarGenero(Genero genero) throws Exception {
		dataAccess.insertarGenero(genero);

	}

	@Override
	public boolean existeGenero(String genero) throws Exception {
		boolean existeGen = dataAccess.existeGenero(genero);
		return existeGen;
	}

	@Override
	public Autor cargarAutor(String nAutor) throws Exception {
		Autor autor = dataAccess.cargarAutor(nAutor);
		return autor;
	}

	public void guardarDatosLibro(Libro libro, ArrayList<Autor> autores) throws Exception {
		dataAccess.guardarDatosLibro(libro);
		ArrayList<Autor> autoresLibro = dataAccess.cargarAutoresLibro(libro.getIsbn());
		for (int i = 0; i < autores.size(); i++) {
			for (int j = 0; j < autoresLibro.size(); j++) {
				if (autores.get(i).getCodAutor().equalsIgnoreCase(autoresLibro.get(j).getCodAutor())) {
					autores.remove(autores.get(i));
				}
			}
		}

		for (Autor autor : autores) {
			dataAccess.insertarLibroAutores(autor, libro.getIsbn());
		}
	}

	public void borrarAutor(String nAutor) throws Exception {
		dataAccess.borrarAutor(nAutor);

	}

	public void borrarGen(String nGenero) throws Exception {
		dataAccess.borrarGenero(nGenero);

	}

	@Override
	public ArrayList<String> cargarGustosGen(String nUsuario) throws Exception {
		ArrayList<String> gustosGen = dataAccess.cargarGustosGen(nUsuario);
		return gustosGen;
	}

	@Override
	public ArrayList<String> cargarGustosAut(String nUsuario) throws Exception {
		ArrayList<String> gustosAut = dataAccess.cargarGustosAut(nUsuario);
		return gustosAut;
	}

	@Override
	public void añadirGustoAut(String nUsuario, String nAutor) throws Exception {
		dataAccess.regUsGustoAutor(nAutor, nUsuario);

	}

	@Override
	public void añadirGustoGen(String nUsuario, String nGen) throws Exception {
		dataAccess.regUsGustoGenero(nGen, nUsuario);

	}

	@Override
	public void borrarGustoGen(String nUsuario, String nGen) throws Exception {
		dataAccess.borrarGustoGen(nUsuario, nGen);

	}

	@Override
	public void borrarGustoAut(String nUsuario, String nAutor) throws Exception {
		dataAccess.borrarGustoAut(nUsuario, nAutor);

	}
}
