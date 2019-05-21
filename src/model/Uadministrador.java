package model;

public class Uadministrador extends Usuario{

	// Constructores
	public Uadministrador(String nombreUsuario, String nombre, String apellidos, String direccion, int telefono,
			String email, boolean esAdmin, String contraseña) {
		super(nombreUsuario, nombre, apellidos, direccion, telefono, email, esAdmin, contraseña);
		
	}	
	public Uadministrador() {
		super();
	}

	
}
