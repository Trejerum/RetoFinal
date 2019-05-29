package model;

import java.sql.Date;
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
	private Date fechaCompra;
	private int numCuenta;
	private int unidades;
	private int importeTotal;
	
	//Constructors
	/**
	 * 
	 * @param idCompra : Cada compra tiene un ID, sirve para diferenciarlo de otras compras
	 * @param nombreUsuario : El nombre de usuario que realiza la compra, para posteriormente ver cuantas compras ha realizado un mismo usuario
	 * @param fechaCompra : Almacenará que dia lo ha comprado
	 * @param numCuenta : Para poder realizar la compra, es neccesario poner un numero de cuenta para poder pagar
	 * @param isbn : Sirve para diferenciar un libro de otro
	 * @param unidades : Número de ejemplares que se comprarán de un mismo libro. 
	 * @param importeTotal : Importe total de la compra realizada.
	 */
	public Compra(int idCompra, String nombreUsuario, Date fechaCompra, int numCuenta, String isbn, int unidades, int importeTotal) {
		super();
		this.idCompra = idCompra;
		this.nombreUsuario = nombreUsuario;
		this.fechaCompra = fechaCompra;
		this.numCuenta = numCuenta;
		this.isbn = isbn;
		this.unidades = unidades;
		this.importeTotal = importeTotal;
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
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
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

	public int getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(int importeTotal) {
		this.importeTotal = importeTotal;
	}
	
	
	
}
