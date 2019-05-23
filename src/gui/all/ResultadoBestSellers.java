package gui.all;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultadoBestSellers extends JPanel {
	private JLabel lblBestSellers;
	private JTextField tfDate;
	private JSeparator separator;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5934182603239436311L;
	private JTable tablaBestSellers;

	/**
	 * Create the panel.
	 */
	public ResultadoBestSellers() {
		setBackground(new Color(0, 153, 51));
		setLayout(null);
		
		lblBestSellers = new JLabel("Best Sellers:");
		lblBestSellers.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBestSellers.setBounds(235, 65, 144, 27);
		add(lblBestSellers);
		
		tfDate = new JTextField();
		tfDate.setForeground(new Color(0, 0, 153));
		tfDate.setFont(new Font("Malgun Gothic", Font.PLAIN, 24));
		tfDate.setEditable(false);
		tfDate.setBackground(new Color(0, 153, 51));
		tfDate.setBounds(389, 65, 135, 27);
		add(tfDate);
		tfDate.setColumns(10);
		LocalDate calendario = LocalDate.now();
		TextField texto = new TextField(calendario.toString());
		String fecha = texto.getText();
		tfDate.setText(fecha);
		

		separator = new JSeparator();
		separator.setBounds(0, 114, 784, 2);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 146, 609, 270);
		add(scrollPane);
		
		tablaBestSellers = new JTable();
		tablaBestSellers.setForeground(new Color(0, 0, 0));
		tablaBestSellers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"N\u00BA", "Titulo", "Autor", "Ventas"
			}
		));
		scrollPane.setViewportView(tablaBestSellers);
		
	}
}
