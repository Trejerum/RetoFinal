package model;

public class Genero {
	
	private String codGenero;
	private String nomGenero;
	
	// Constructores
	public Genero(String codGenero, String nomGenero) {
		super();
		this.codGenero = codGenero;
		this.nomGenero = nomGenero;
	}

	public Genero() {
		super();
	}
	
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
