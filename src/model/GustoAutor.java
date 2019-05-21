package model;

public class GustoAutor {
	
	private String codAutor;
	private String nombreUsuario;
	
	// Constructores
	public GustoAutor(String codAutor, String nombreUsuario) {
		super();
		this.codAutor = codAutor;
		this.nombreUsuario = nombreUsuario;
	}
	public GustoAutor() {
		super();
	}
	
	// Getters y setters
	public String getCodAutor() {
		return codAutor;
	}
	public void setCodAutor(String codAutor) {
		this.codAutor = codAutor;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	
}
