package model;

/**
 * La clase Autor contiene la información de todos los autores de los que hay
 * libros en la librería.
 * 
 * @author equipo B
 *
 */
public class Autor {

	// Attributes
	private String codAutor;
	private String nomAutor;

	/**
	 * 
	 * @param codAutor : El codigo de autor es el identificador que tiene cada autor
	 *                 y es único.
	 * @param nomAutor : Nombre del autor asociado al código de autor.
	 */
	// Constructores
	public Autor(String codAutor, String nomAutor) {
		super();
		this.codAutor = codAutor;
		this.nomAutor = nomAutor;
	}

	public Autor() {
		super();
	}

	/**
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o
	 * también para establecerlo/modificarlo.
	 * 
	 * @return
	 */
	// Getters y setters
	public String getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(String codAutor) {
		this.codAutor = codAutor;
	}

	public String getNomAutor() {
		return nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}
}
