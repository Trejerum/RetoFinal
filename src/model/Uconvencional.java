package model;

import java.util.ArrayList;

public class Uconvencional extends Usuario{
	
	private ArrayList<String> gustos = new ArrayList<String>();
	
	// Constructores
	public Uconvencional(ArrayList<String> gustos) {
		super();
		this.gustos = gustos;
	}

	public Uconvencional() {
		super();
	}
	
	// Getters y setters
	public ArrayList<String> getGustos() {
		return gustos;
	}

	public void setGustos(ArrayList<String> gustos) {
		this.gustos = gustos;
	}
	
	

}
