package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import model.Autor;
import model.AutoresLibro;
import model.Compra;
import model.Genero;
import model.Libro;
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
			String sql = "INSERT INTO uconvencional VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombreUsuario());
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellidos());
			stmt.setString(4, usuario.getDireccion());
			stmt.setInt(5, usuario.getTelefono());
			stmt.setString(6, usuario.getEmail());
			stmt.setInt(7, usuario.getNumCuenta());
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

	public ArrayList<Libro> listarBestsellers() throws ClassNotFoundException, SQLException, IOException{
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			this.connect();
			String sql="select titulo, isbn, genero, editorial, numventas from libros order by numventas desc limit 10";
			stmt = con.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Libro libro = new Libro();
				libro.setTitulo(result.getString("titulo"));
				libro.setIsbn(result.getString("isbn"));
				libro.setGenero(result.getString("genero"));
				libro.setEditorial(result.getString("editorial"));
				libro.setNumVentas(result.getInt("numVentas"));
				libros.add(libro);
			}
		}finally {
			this.disconnect();
		}
		return libros;
		
	}

	public void insertarLibro(Libro libro) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "Insert into libros(isbn, titulo, genero, descripcion, editorial, fechadepublicacion, precio, oferta, descuento, stock, numVentas)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, libro.getIsbn());
			stmt.setString(2, libro.getTitulo());
			stmt.setString(3, libro.getGenero());
			stmt.setString(4, libro.getDescripcion());
			stmt.setString(5, libro.getEditorial());
			stmt.setDate(6, convertirLocalDateADate(libro.getFechaPublicacion()));
			stmt.setDouble(7, libro.getPrecio());
			stmt.setBoolean(8, libro.isOferta());
			stmt.setDouble(9, libro.getDescuento());
			stmt.setInt(10, libro.getStock());
			stmt.setInt(11, libro.getNumVentas());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	public void comprarLibro(Compra compra) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql="INSERT INTO compras (nombreUsuario, isbn, numUnidades, fechaCompra, importeTotal, numCuenta) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, compra.getNombreUsuario());
			stmt.setString(2, compra.getIsbn());
			stmt.setInt(3, compra.getUnidades());
			stmt.setDate(4, compra.getFechaCompra());
			stmt.setDouble(5, compra.getImporteTotal());
			stmt.setInt(6, compra.getNumCuenta());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	public ArrayList<Libro> verRecomendados(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			this.connect();
			String sql = "select DISTINCT libros.isbn, libros.editorial , titulo, precio, libros.genero \r\n" + 
					"from libros, usuarios,gustoAutor, gustoGenero, autoresLibro, generos \r\n" + 
					"where ( usuarios.nombreUsuario =? \r\n" + 
					"and usuarios.nombreUsuario =gustoautor.nombreUsuario \r\n" + 
					"and autoreslibro.codAutor = gustoautor.codAutor \r\n" + 
					"and autoreslibro.isbn = libros.isbn \r\n" + 
					")\r\n" + 
					" or ( usuarios.nombreUsuario = ? \r\n" + 
					"and usuarios.nombreUsuario = gustogenero.nombreUsuario \r\n" + 
					"and gustogenero.codGen = generos.codGen \r\n" + 
					"and generos.nombreGen = libros.genero )\r\n" + 
					"";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			stmt.setString(2, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Libro libro = new Libro();
				libro.setIsbn(result.getString("isbn"));
				libro.setTitulo(result.getString("titulo"));
				libro.setEditorial(result.getString("editorial"));
				libro.setGenero(result.getString("genero"));
				libro.setPrecio(result.getDouble("precio"));
				libros.add(libro);
			}
		}finally {
			this.disconnect();
		}
		return libros;
	}

	public ArrayList<Libro> buscarLibro(String busqueda) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			this.connect();
			String sql="select distinct libros.isbn, titulo, genero, editorial, precio "
					+ "from libros, autores, autoreslibro "
					+ "where titulo like ?"
					+ "or libros.isbn = ? "
					+ "or (nombreAutor like ? and autoreslibro.codAutor = autores.codAutor and libros.isbn = autoreslibro.isbn)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + busqueda + "%");
			stmt.setString(2, busqueda);
			stmt.setString(3, "%" + busqueda + "%");
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Libro libro = new Libro();
				libro.setTitulo(result.getString("titulo"));
				libro.setIsbn(result.getString("isbn"));
				libro.setGenero(result.getString("genero"));
				libro.setEditorial(result.getString("editorial"));
				libro.setPrecio(result.getDouble("precio"));
				libros.add(libro);
			}
		}finally {
			this.disconnect();
		}
		return libros;
		
	}

	public void modificarLibro(Libro libro) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "update libros set titulo=?, genero=?, descripcion=?, editorial=?, fechadepublicacion=?, "
					+ "precio=?, oferta=?, descuento=?, stock=?, numVentas=? where libros.isbn=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, libro.getTitulo());
			stmt.setString(2, libro.getGenero());
			stmt.setString(3, libro.getDescripcion());
			stmt.setString(4, libro.getEditorial());
			stmt.setDate(5, convertirLocalDateADate(libro.getFechaPublicacion()));
			stmt.setDouble(6, libro.getPrecio());
			stmt.setBoolean(7, libro.isOferta());
			stmt.setDouble(8, libro.getDescuento());
			stmt.setInt(9, libro.getStock());
			stmt.setInt(10, libro.getNumVentas());
			stmt.setString(11, libro.getIsbn());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	public ArrayList<Compra> consultarCompras(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Compra> compras = new ArrayList<Compra>();
		try {
			this.connect();
			String sql = "select *  from compras where nombreusuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Compra compra = new Compra();
				compra.setNombreUsuario(nUsuario);
				compra.setIdCompra(result.getInt("idcompra"));
				compra.setImporteTotal(result.getInt("importeTotal"));
				compra.setIsbn(result.getString("isbn"));
				compra.setNumCuenta(result.getInt("numCuenta"));
				compra.setUnidades(result.getInt("numunidades"));
				compra.setFechaCompra(result.getDate("fechaCompra"));
				compras.add(compra);
			}
		}finally {
			this.disconnect();
		}
		return compras;
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
				usuario.setNumCuenta(result.getInt("NumCuenta"));
			}
		}finally {
			this.disconnect();
		}
		
		return usuario;
	}

	public void guardarCambiosUCon(Usuario usuario) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "update uConvencional set nombre=?, apellidos=?, email=?, telefono=?, direccion=?, numCuenta=? where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getApellidos());
			stmt.setString(3, usuario.getEmail());
			stmt.setInt(4, usuario.getTelefono());
			stmt.setString(5, usuario.getDireccion());
			stmt.setInt(6, usuario.getNumCuenta());
			stmt.setString(7, usuario.getNombreUsuario());
			stmt.executeUpdate();
			
		}finally {
			this.disconnect();
		}
		
	}

	public void guardarCambiosUs(Usuario usuario) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "update usuarios set contraseña=?, esAdmin=? where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getContraseña());
			stmt.setBoolean(2, usuario.isEsAdmin());
			stmt.setString(3, usuario.getNombreUsuario());
			stmt.executeUpdate();
			
		}finally {
			this.disconnect();
		}
		
	}

	public Libro cargarLibro(String isbn) throws SQLException, ClassNotFoundException, IOException {
		Libro libro = new Libro();
		try {
			this.connect();
			String sql="select distinct libros.isbn, titulo, genero, descripcion, editorial,fechadepublicacion, precio, oferta, descuento "
					+ "from libros "
					+ "where isbn = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				libro.setTitulo(result.getString("titulo"));
				libro.setIsbn(result.getString("isbn"));
				libro.setGenero(result.getString("genero"));
				libro.setDescripcion(result.getString("descripcion"));
				libro.setEditorial(result.getString("editorial"));
				libro.setFechaPublicacion(result.getDate("fechaDePublicacion").toLocalDate());
				libro.setPrecio(result.getDouble("precio"));
				libro.setOferta(Boolean.parseBoolean(result.getString("oferta")));
				libro.setDescuento(result.getDouble("descuento"));
			}
		}finally {
			this.disconnect();
		}
		return libro;
		
	}

	public ArrayList<Autor> cargarAutoresLibro(String isbn) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		try {
			this.connect();
			String sql="select nombreAutor, autoreslibro.codAutor from autores, autoreslibro where autores.codAutor=autoreslibro.codAutor and autoresLibro.isbn=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Autor autor = new Autor();
				autor.setNomAutor(result.getString("nombreAutor"));
				autor.setCodAutor(result.getString("codautor"));
				autores.add(autor);
			}
		}finally {
			this.disconnect();
		}
		return autores;
	}

	public void aumentarVentas(String isbn, int cantidad) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "update libros set numVentas= numVentas + ? where isbn=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cantidad);
			stmt.setString(2, isbn);
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	public boolean esAdmin(String nUsuario) throws SQLException, ClassNotFoundException, IOException {
		boolean esAdmin=false;
		try {
			this.connect();
			String sql = "Select esAdmin from usuarios where nombreUsuario=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nUsuario);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				esAdmin=result.getBoolean("esAdmin");
			}
		}finally {
			this.disconnect();
		}
		return esAdmin;
	}
	
	public Date convertirLocalDateADate(LocalDate fechaAConvertir) {
	    return Date.valueOf(fechaAConvertir);
	}

	public void insertarLibroAutores(Autor autor, String isbn) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "insert into autoresLibro(isbn, codAutor) values (?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, isbn);
			stmt.setString(2, autor.getCodAutor());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
	}

	public void insertarAutor(Autor autor) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "insert into autores(codAutor, nombreAutor) values (? ,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, autor.getCodAutor());
			stmt.setString(2, autor.getNomAutor());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
		
	}

	public boolean existeAutor(Autor autor) throws SQLException, ClassNotFoundException, IOException {
		Boolean existeAutor=false;
		try {
			this.connect();
			String sql = "select autores.nombreAutor from autores where autores.nombreAutor=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, autor.getNomAutor());
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				if(result.getString("nombreAutor").equalsIgnoreCase(autor.getNomAutor())) {
					existeAutor=true;
				}
			}
		}finally {
			this.disconnect();
		}
		return existeAutor;
	}

	public void insertarGenero(Genero genero) throws SQLException, ClassNotFoundException, IOException {
		try {
			this.connect();
			String sql = "insert into generos(codGen, nombreGen) values (?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, genero.getCodGenero());
			stmt.setString(2, genero.getNomGenero());
			stmt.executeUpdate();
		}finally {
			this.disconnect();
		}
	}

	public boolean existeGenero(String genero) throws SQLException, ClassNotFoundException, IOException {
		Boolean existeGenero=false;
		try {
			this.connect();
			String sql = "select codGen from generos where codGen=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, genero);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				if(result.getString("codGen").equalsIgnoreCase(genero)) {
					existeGenero=true;
				}
			}
		}finally {
			this.disconnect();
		}
		return existeGenero;
	}
}
