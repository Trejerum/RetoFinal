package control;

import java.util.ArrayList;

import model.Autor;
import model.Genero;
import model.Usuario;

public class LogicImpl implements Logic{

	private DataAccess dataAccess = DataAccessFactory.getDataAccess();


	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception {
			boolean validado = false;
			validado=dataAccess.validarUsuario(nUsuario, contraseña);
		return validado;
	}


	@Override
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


	@Override
	public void listarBestsellers() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void insertarLibro() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void verRecomendados(String nUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buscarLibro(String busqueda) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificarLibro(String isbn) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
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

	
}
