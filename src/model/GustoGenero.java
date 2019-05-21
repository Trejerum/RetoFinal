package model;

/**
 * La clase GustoGenero almacena los g�neros y los usuarios a los que les gustan esos g�neros.
 * @author 1dam
 *
 */
public class GustoGenero {
	
	private String codGenero;
	private String nombreUsuario;
	
	/**
	 * 
	 * @param codGenero : El c�digo de g�nero es el idetificador de cada g�nero y es �nico.
	 * @param nombreUsuario : Sirve para diferenciar a cada usuario y es �nico.
	 */
	// Constructores
	public GustoGenero(String codGenero, String nombreUsuario) {
		super();
		this.codGenero = codGenero;
		this.nombreUsuario = nombreUsuario;
	}

	public GustoGenero() {
		super();
	}
	
	/**
	 * Los siguientes m�todos get and set se usan para acceder y usar un atributo o tambi�n para establecerlo/modificarlo.
	 * @return
	 */
	// Getters y Setters
	public String getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(String codGenero) {
		this.codGenero = codGenero;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
