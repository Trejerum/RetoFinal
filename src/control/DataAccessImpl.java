package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.Usuario;


public class DataAccessImpl implements DataAccess{

	private Connection con;
	private PreparedStatement stmt;
	private String dbHost;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	
	private void connect() throws ClassNotFoundException, SQLException, IOException {
		if (dbHost == null) {
			Properties config = new Properties();
			FileInputStream input = null;
			try {
				input = new FileInputStream("./resources/db.properties");
				config.load(input);
				dbHost = config.getProperty("ip");
				dbName = config.getProperty("dbname");
				dbUser = config.getProperty("username");
				dbPassword = config.getProperty("password");
			} finally {
				if (input != null)
					input.close();
			}
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://" + dbHost + "/" + dbName + "?serverTimezone=Europe/Madrid";
		con = DriverManager.getConnection(url, dbUser, dbPassword);
	}
	
	private void disconnect() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

	public boolean validarUsuario(String nUsuario, String contraseña) throws ClassNotFoundException, SQLException, IOException {
		boolean validado = false;
		try {
			this.connect();
			String sql = "select contraseña from usuarios where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String contraseñaDB = result.getString("contraseña");
				if(contraseñaDB.equals(contraseña)) {
					validado=true;
				}
			}
		}finally {
			this.disconnect();
		}
		return validado;
	}
	
	public void regUsUsuarios(Usuario usuario) throws ClassNotFoundException, SQLException, IOException{
		try {
			this.connect();
			String sql = "INSERT INTO usuarios VALUES (?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getContraseña());
			stmt.setBoolean(3, usuario.isEsAdmin());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}
	
	public void regUsUConvencional(Usuario usuario) throws ClassNotFoundException, SQLException, IOException{
		try {
			this.connect();
			String sql = "INSERT INTO uconvencional VALUES (?, ?, ?, ?, ?, ?, null)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellidos());
			stmt.setString(4, usuario.getDireccion());
			stmt.setInt(5, usuario.getTelefono());
			stmt.setString(6, usuario.getEmail());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}
	
	
	public void regUsGustoAutor(String autor, String usuario) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "INSERT INTO gustoautor select nombreUsuario, codautor from uconvencional, autores where autores.nombreAutor=? and nombreusuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, autor);
			stmt.setString(2, usuario);
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	
	public void regUsGustoGenero(String genero, String usuario) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "INSERT INTO gustogenero select nombreUsuario, codgen from uconvencional, generos where generos.nombreGen=? and nombreusuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, genero);
			stmt.setString(2, usuario);
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	public void listarBestsellers() throws ClassNotFoundException, SQLException, IOException{
		// TODO Auto-generated method stub
		
	}

	public void insertarLibro() throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void comprarLibro(ArrayList<String> carrito, String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void verRecomendados(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void buscarLibro(String busqueda) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void modificarLibro(String isbn) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void consultarCompras(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	public boolean comprobarNUsuario(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		Boolean repetido = false;
		try {
			this.connect();
			String sql = "select nombreUsuario from usuarios where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String nombreU = result.getString("nombreUsuario");
				if(nombreU.equalsIgnoreCase(nUsuario)) {
					repetido=true;
				}
			}
		}finally {
			this.disconnect();
		}
		return repetido;
	}

	public ArrayList<String> cargarGeneros() throws SQLException, ClassNotFoundException, IOException {
		ArrayList<String> generos = new ArrayList<String>();
		try {
			this.connect();
			String sql = "select * from generos";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String genero;
				genero=result.getString("nombreGen");
				generos.add(genero);
			}
		}finally {
			this.disconnect();
		}
		return generos;
	}

	public ArrayList<String> cargarAutores() throws SQLException, ClassNotFoundException, IOException {
		ArrayList<String> autores = new ArrayList<String>();
		try {
			this.connect();
			String sql = "select * from autores";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String autor;
				autor=result.getString("nombreAutor");
				autores.add(autor);
			}
		}finally {
			this.disconnect();
		}
		return autores;
	}

	public Usuario cargarUsuario(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		Usuario usuario = new Usuario();
		
		try {
			this.connect();
			String sql = "select * from usuarios,uconvencional where usuarios.nombreUsuario=? and usuarios.nombreUsuario=uconvencional.nombreUsuario";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				usuario.setNombre(result.getString("Nombre"));
				usuario.setApellidos(result.getString("Apellidos"));
				usuario.setDireccion(result.getString("Direccion"));
				usuario.setTelefono(result.getInt("Telefono"));
				usuario.setEmail(result.getString("Email"));
				usuario.setContraseña(result.getString("Contraseña"));
				usuario.setNombreUsuario(result.getString("nombreUsuario"));
			}
		}finally {
			this.disconnect();
		}
		
		return usuario;
	}

	public void guardarCambiosUCon(Usuario usuario, String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "update uConvencional set nombreUsuario=?, nombre=?, apellidos=?, email=?, telefono=?, direccion=?, numCuenta=null where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellidos());
			stmt.setString(4, usuario.getEmail());
			stmt.setInt(5, usuario.getTelefono());
			stmt.setString(6, usuario.getDireccion());
			stmt.setString(7, nUsuario);
			stmt.executeUpdate();
			
		}finally {
			this.disconnect();
		}
		
	}

	public void guardarCambiosUs(Usuario usuario, String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "update usuarios set nombreUsuario=?, contraseña=?, esAdmin=? where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getContraseña());
			stmt.setBoolean(3, usuario.isEsAdmin());
			stmt.setString(4, nUsuario);
			stmt.executeUpdate();
			
		}finally {
			this.disconnect();
		}
		
	}

}
