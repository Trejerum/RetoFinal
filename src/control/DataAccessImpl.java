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

	public boolean validarUsuario(String nUsuario, String contrase�a) throws ClassNotFoundException, SQLException, IOException {
		boolean validado = false;
		try {
			this.connect();
			String sql = "select contrase�a from usuarios where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				String contrase�aDB = result.getString("contrase�a");
				if(contrase�aDB.equals(contrase�a)) {
					validado=true;
				}
			}
		}finally {
			this.disconnect();
		}
		return validado;
	}
	
	public void registrarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException, IOException{
		try {
			this.connect();
			String sql = "INSERT INTO usuario ('nombreUsuario', 'contrase�a', 'esAdmin') VALUES (?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getContrase�a());
			stmt.setBoolean(3, usuario.isEsAdmin());
			stmt.executeUpdate();
			
			sql = "INSERT INTO uconvencional ('nombreUsuario', 'nombre', 'apellidos', 'direccion', 'telefono', 'email') VALUES (?, ?, ?, ?, ?, ?)";
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
}
