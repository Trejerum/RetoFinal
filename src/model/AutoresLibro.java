package model;

public class AutoresLibro {
		
	private String codAutor;
	private String isbn;
		
	// Constructores
	public AutoresLibro(String codAutor, String isbn) {
		super();
		this.codAutor = codAutor;
		this.isbn = isbn;
	}
	public AutoresLibro() {
		super();
	}
	
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
