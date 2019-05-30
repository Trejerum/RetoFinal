package model;

/**
 * La clase Uadministrador almacena la informaci�n de los administradores, la
 * cual hereda de la clase Usuario.
 * 
 * @author equipo B
 *
 */
public class Uadministrador extends Usuario {

	/**
	 * 
	 * @param nombreUsuario : Sirve para diferenciar a cada usuario y es �nico.
	 * @param nombre        : Para saber el nombre de la persona.
	 * @param apellidos     : Para saber el apellido de la persona.
	 * @param direccion     : Sirve para poder enviarle el libro a su direccion,
	 *                      despues de realizar la compra.
	 * @param telefono      : Para poder contactar con el usuario.
	 * @param email         : Para enviarle ofertas de sus libros favoritos.
	 * @param esAdmin       : Para saber si es un usuario administrador o no.
	 * @param contrase�a    : Sirve para iniciar sesion con su nombre de usuario.
	 */
	// Constructores
	public Uadministrador(String nombreUsuario, String nombre, String apellidos, String direccion, int telefono,
			String email, boolean esAdmin, String contrase�a) {
		super(nombreUsuario, nombre, apellidos, direccion, telefono, email, esAdmin, contrase�a);

	}

	public Uadministrador() {
		super();
	}

}
