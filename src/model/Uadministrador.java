package model;

public class Uadministrador extends Usuario{

	// Constructores
	public Uadministrador(String nombreUsuario, String nombre, String apellidos, String direccion, int telefono,
			String email, boolean esAdmin, String contrase�a) {
		super(nombreUsuario, nombre, apellidos, direccion, telefono, email, esAdmin, contrase�a);
		
	}	
	public Uadministrador() {
		super();
	}

	
}
