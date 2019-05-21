package model;

/**
 * La clase GustoGenero almacena los géneros y los usuarios a los que les gustan esos géneros.
 * @author 1dam
 *
 */
public class GustoGenero {
	
	private String codGenero;
	private String nombreUsuario;
	
	/**
	 * 
	 * @param codGenero : El código de género es el idetificador de cada género y es único.
	 * @param nombreUsuario : Sirve para diferenciar a cada usuario y es único.
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
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o también para establecerlo/modificarlo.
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
