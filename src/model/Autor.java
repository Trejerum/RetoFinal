package model;

public class Autor {
	
	private String codAutor;
	private String nomAutor;
	
	// Constructores
	public Autor(String codAutor, String nomAutor) {
		super();
		this.codAutor = codAutor;
		this.nomAutor = nomAutor;
	}

	public Autor() {
		super();
	}
	
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
