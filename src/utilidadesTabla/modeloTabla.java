package utilidadesTabla;

import javax.swing.table.DefaultTableModel;

public class modeloTabla extends DefaultTableModel{
	
	String[] columnas;
	Object[][] data;
	
	/**
	 * Estros parametros van a definir la tabla
	 * @param columnas  
	 * @param data
	 */
	public modeloTabla(String[] columnas, Object[][] data) {
		super();
		this.columnas = columnas;
		this.data = data;
	}
	public modeloTabla() {
		super();
	}
	
	public boolean isCellEditable() {
		return false;
	}
	
	
}
