package utilidadesTabla;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class gestionCeldas extends DefaultTableCellRenderer {
	private String tipo="text";
	
	/**
	 * Constuctor para definir que tipos de dato va a tener la celda
	 * @param tipo
	 */
	public gestionCeldas(String tipo) {
		super();
		this.tipo = tipo;
	}

	public gestionCeldas() {
		super();
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		/**
		 * Este metodo controla toda la tabla, sirve para cambiar de color la fila que esta seleccionada 
		 */
		
		//Colores por defecto
		Color colorFondo = null;
		Color colorFondoPorDefecto = new Color( 192, 192, 192);
		Color colorFondoSeleccion = new Color( 140, 140, 140);
			if(selected) {
				this.setBackground(colorFondoPorDefecto);
			}else {
				this.setBackground(Color.white);
			}
			
			/**
			 * 
			 */
		
		if(tipo.equals("texto")) {
			if(focused) {
				colorFondo = colorFondoSeleccion;
			}else {
				colorFondo = colorFondoPorDefecto;
			}
			this.setHorizontalAlignment(JLabel.LEFT);
			this.setText((String) value);
			this.setBackground((selected)? colorFondo :Color.WHITE);
		}
		return this;
		
	}
	
	
}
