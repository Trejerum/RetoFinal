package gui.user;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConfirmarCompra extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196680677816620968L;
	private JPanel contentPane;
	private JLabel lblConfirmarCompra;
	private JSeparator separator;
	private JButton btnCancelar;
	private JButton btnConfirmar;

	/**
	 * Create the frame.
	 */
	public ConfirmarCompra(String isbn) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 384);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConfirmarCompra = new JLabel("Confirmar compra");
		lblConfirmarCompra.setFont(new Font("Maiandra GD", Font.PLAIN, 27));
		lblConfirmarCompra.setBounds(10, 20, 349, 27);
		contentPane.add(lblConfirmarCompra);
		
		separator = new JSeparator();
		separator.setBounds(0, 60, 784, 2);
		contentPane.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(543, 308, 89, 23);
		contentPane.add(btnCancelar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setBounds(377, 308, 134, 23);
		contentPane.add(btnConfirmar);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
