package model;

import java.time.LocalDate;
/**
 * La clase Compra va a registrar información sobre cada compra que realice un usuario.
 * @author equipo B
 * 
 */
public class Compra {
	
	//Attributes
	private int idCompra;
	private String isbn;
	private String nombreUsuario;
	private LocalDate fechaCompra;
	private int numCuenta;
	private int unidades;
	
	//Constructors
	/**
	 * 
	 * @param idCompra : Cada compra tiene un ID, sirve para diferenciarlo de otras compras
	 * @param nombreUsuario : El nombre de usuario que realiza la compra, para posteriormente ver cuantas compras ha realizado un mismo usuario
	 * @param fechaCompra : Almacenará que dia lo ha comprado
	 * @param numCuenta : Para poder realizar la compra, es neccesario poner un numero de cuenta para poder pagar
	 * @param isbn : Sirve para diferenciar un libro de otro
	 * @param unidades : Número de ejemplares que se comprarán de un mismo libro. 
	 */
	public Compra(int idCompra, String nombreUsuario, LocalDate fechaCompra, int numCuenta, String isbn, int unidades) {
		super();
		this.idCompra = idCompra;
		this.nombreUsuario = nombreUsuario;
		this.fechaCompra = fechaCompra;
		this.numCuenta = numCuenta;
		this.isbn = isbn;
		this.unidades = unidades;
	}
	
	public Compra() {
		super();
	}
	
	//Getters y setters
	/**
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o también para establecerlo/modificarlo.
	 * @return
	 */
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public LocalDate getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	
	
}
