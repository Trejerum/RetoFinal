package gui.all;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResultadoBestSellers extends JPanel {
	private JLabel lblBestSellers;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5934182603239436311L;

	/**
	 * Create the panel.
	 */
	public ResultadoBestSellers() {
		setLayout(null);
		
		lblBestSellers = new JLabel("Best Sellers:");
		lblBestSellers.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblBestSellers.setBounds(235, 65, 144, 27);
		add(lblBestSellers);
	}

}
