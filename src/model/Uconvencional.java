package model;

import java.util.ArrayList;

/**
 * La clase Uconvencional almacena la información de los usuarios
 * convencionales, la cual hereda de la clase Usuario.
 * 
 * @author equipo B
 *
 */
public class Uconvencional extends Usuario {

	private ArrayList<String> gustos = new ArrayList<String>();

	/**
	 * 
	 * @param gustos : Gustos almacena los distintos gustos, tanto de autor como de
	 *               género, que puede tener un usuario.
	 */
	// Constructores
	public Uconvencional(ArrayList<String> gustos) {
		super();
		this.gustos = gustos;
	}

	public Uconvencional() {
		super();
	}

	/**
	 * Los siguientes métodos get and set se usan para acceder y usar un atributo o
	 * también para establecerlo/modificarlo.
	 * 
	 * @return
	 */
	// Getters y setters
	public ArrayList<String> getGustos() {
		return gustos;
	}

	public void setGustos(ArrayList<String> gustos) {
		this.gustos = gustos;
	}

}
