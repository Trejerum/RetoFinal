package control;

import java.util.ArrayList;

public class LogicImpl implements Logic{

	private DataAccess dataAccess = DataAccessFactory.getDataAccess();


	public boolean validarUsuario(String nUsuario, String contraseņa) throws Exception {
			boolean validado = false;
			
		return false;
	}


	@Override
	public void registrarUsuario() throws Exception {
		// TODO Auto-generated method stub
		
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
	
}
