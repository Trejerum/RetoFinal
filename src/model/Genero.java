package model;

/**
 * La clase Genero almacena los diferentes géneros que existen en la librería.
 * @author equipo B
 *
 */
public class Genero {
	
	private String codGenero;
	private String nomGenero;
	
	/**
	 * 
	 * @param codGenero : El código de género es el idetificador de cada género y es único
	 * @param nomGenero : Este atributo es el nombre de un género
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
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o también para establecerlo/modificarlo.
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
