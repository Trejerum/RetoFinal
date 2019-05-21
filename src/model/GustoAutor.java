package model;

/**
 * La clase GustoAutor almacena autores y los usuarios a los que les gustan esos autores.
 * @author equipo B
 *
 */
public class GustoAutor {
	
	private String codAutor;
	private String nombreUsuario;
	
	/**
	 * 
	 * @param codAutor : El código de autor es identificador que tiene cada autor y es único.
	 * @param nombreUsuario : Sirve para diferenciar a cada usuario y es único.
	 */
	// Constructores
	public GustoAutor(String codAutor, String nombreUsuario) {
		super();
		this.codAutor = codAutor;
		this.nombreUsuario = nombreUsuario;
	}
	public GustoAutor() {
		super();
	}
	
	// Getters y setters
	public String getCodAutor() {
		return codAutor;
	}
	public void setCodAutor(String codAutor) {
		this.codAutor = codAutor;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
}
