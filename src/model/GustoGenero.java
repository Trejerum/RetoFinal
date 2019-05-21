package model;

public class GustoGenero {
	
	private String codGenero;
	private String nombreUsuario;
	
	// Constructores
	public GustoGenero(String codGenero, String nombreUsuario) {
		super();
		this.codGenero = codGenero;
		this.nombreUsuario = nombreUsuario;
	}

	public GustoGenero() {
		super();
	}

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
