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

	public boolean validarUsuario(String nUsuario, String contraseña) throws Exception {
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
	
	public void registrarUsuario() throws Exception {
		
		
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

	public void buscarLibro(String busqueda) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void modificarLibro(String isbn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void consultarCompras(String nUsuario) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
