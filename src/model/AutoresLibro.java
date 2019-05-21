package model;

/**
 * La clase AutoresLibro almacena los distintos autores que puede tener un libro.
 * @author equipo B
 *
 */
public class AutoresLibro {
		
	private String codAutor;
	private String isbn;
		
	/**
	 * 
	 * @param codAutor : El código de autor es identificador que tiene cada autor y es único.
	 * @param isbn : El ISBN es el identificador de un libro y es único.
	 */
	// Constructores
	public AutoresLibro(String codAutor, String isbn) {
		super();
		this.codAutor = codAutor;
		this.isbn = isbn;
	}
	public AutoresLibro() {
		super();
	}
	
	/**
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o también para establecerlo/modificarlo.
	 * @return
	 */
	// Getters y Setters
	public String getCodAutor() {
		return codAutor;
	}
	public void setCodAutor(String codAutor) {
		this.codAutor = codAutor;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
