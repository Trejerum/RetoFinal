package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase Libro contiene diferentes atributos en relación a los libros.
 * @author equipo B
 *
 */
public class Libro {
	
	//Attributes
	private String Isbn;
	private String titulo;
	private String descripcion;
	private String editorial;
	private LocalDate fechaPublicacion;
	private String genero;
	private double precio;
	private boolean oferta;
	private double descuento;
	private int stock;
	//private ArrayList<String> autores = new ArrayList<String>(); 
	//private ArrayList<String> generos = new ArrayList<String>();
	
	// Constructors
	/**
	 * 
	 * @param isbn : El ISBN diferencia cada libro de los demás al ser cada ISBN único.
	 * @param titulo : El título es el nombre que recibe un libro 
	 * @param descripcion : Breve explicación sobre el libro
	 * @param editorial : Editorial que ha producido el libro
	 * @param fechaPublicacion : Fecha en la que se publicó un libro
	 * @param genero: El genero del libro
	 * @param precio : Precio establecido para un libro
	 * @param oferta : Indica si un libro tiene oferta o no 
	 * @param descuento : En caso de haber oferta, el atributo descuento contiene el porcentaje de reducción de precio de un libro.
	 * @param stock : Indica el número de existencias de un libro en la librería
	 */
	public Libro(String isbn, String titulo, String descripcion, String editorial, LocalDate fechaPublicacion,
			double precio, boolean oferta, double descuento, int stock) {
		super();
		Isbn = isbn;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.editorial = editorial;
		this.fechaPublicacion = fechaPublicacion;
		this.precio = precio;
		this.oferta = oferta;
		this.descuento = descuento;
		this.stock = stock;
	}
		
	public Libro() {
		super();
	}

	// Getters and setters
	/**
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o también para establecerlo/modificarlo.
	 * @return 
	 */
	public String getIsbn() {
		return Isbn;
	}
	
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public boolean isOferta() {
		return oferta;
	}
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	
}
