package model;

public class Uadministrador extends Usuario{

	// Constructores
	public Uadministrador(String nombreUsuario, String nombre, String apellidos, String direccion, int telefono,
			String email, boolean esAdmin, String contraseņa) {
		super(nombreUsuario, nombre, apellidos, direccion, telefono, email, esAdmin, contraseņa);
		
	}	
	public Uadministrador() {
		super();
	}

	
}
