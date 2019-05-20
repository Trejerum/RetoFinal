package model;

/**
 * La clase usuarios va a registrar todos los usuarios de la libreria
 * @author grupoB
 *
 */

public class Usuarios {
	
	
	protected String nombreUsuario;
	protected String nombre;
	protected String apellidos;
	protected String direccion;
	protected int telefono;
	protected String email;
	protected boolean esAdmin;
	protected String contraseña;
	
	//Constructors
	public Usuarios() {
		super();
	}
	/**
	 * 
	 * @param nombreUsuario Sirve para diferenciar a cada usuario
	 * @param nombre Para saber el nombre de la persona
	 * @param apellidos Para saber el apellido de la persona
	 * @param direccion Sirve para poder enviarle el libro a su direccion, despues de realizar la compra
	 * @param telefono Para poder contactar con el usuario
	 * @param email Para enviarle ofertas de sus libros favoritos
	 * @param esAdmin Para saber si es un usuario administrador o no
	 * @param contraseña Sirve para iniciar sesion con su nombre de usuario
	 */
	public Usuarios(String nombreUsuario, String nombre, String apellidos, String direccion, int telefono, String email,
			boolean esAdmin, String contraseña) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.esAdmin = esAdmin;
		this.contraseña = contraseña;
	}
	
	/**
	 * Getters and setters
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o también para establecerlo/modificarlo.
	 * @return
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	
	
}
