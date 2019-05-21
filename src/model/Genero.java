package model;

/**
 * La clase Genero almacena los diferentes g�neros que existen en la librer�a.
 * @author equipo B
 *
 */
public class Genero {
	
	private String codGenero;
	private String nomGenero;
	
	/**
	 * 
	 * @param codGenero : El c�digo de g�nero es el idetificador de cada g�nero y es �nico
	 * @param nomGenero : Este atributo es el nombre de un g�nero
	 */
	// Constructores
	public Genero(String codGenero, String nomGenero) {
		super();
		this.codGenero = codGenero;
		this.nomGenero = nomGenero;
	}

	public Genero() {
		super();
	}
	
	/**
	 * Los siguientes m�todos get and set se usan para acceder y usar un atributo o tambi�n para establecerlo/modificarlo.
	 * @return
	 */
	// Getters y setters
	public String getCodGenero() {
		return codGenero;
	}

	public void setCodGenero(String codGenero) {
		this.codGenero = codGenero;
	}

	public String getNomGenero() {
		return nomGenero;
	}

	public void setNomGenero(String nomGenero) {
		this.nomGenero = nomGenero;
	}
	
	
}
