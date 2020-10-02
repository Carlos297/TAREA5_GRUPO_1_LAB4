package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// PanelElimanarPersonas
// Segun el enunciado se elimina seleccionado el JLIST


public class PanelEliminarPersonas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDniEliminar;
	private JLabel lblEliminar;
	private JButton btnEliminar;
	/**
	 * Create the panel.
	 */
	public PanelEliminarPersonas() {
		setLayout(null);
		
		lblEliminar = new JLabel("Ingrese el DNI de la persona a eliminar:");
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEliminar.setBounds(51, 67, 323, 16);
		add(lblEliminar);
		
		txtDniEliminar = new JTextField();
		txtDniEliminar.setBounds(128, 106, 116, 22);
		add(txtDniEliminar);
		txtDniEliminar.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(277, 105, 97, 25);
		add(btnEliminar);

	}
	public JTextField getTxtDniEliminar() {
		return txtDniEliminar;
	}
	public void setTxtDniEliminar(JTextField txtDniEliminar) {
		this.txtDniEliminar = txtDniEliminar;
	}
	
	public JLabel getLblEliminar() {
		return lblEliminar;
	}
	public void setLblEliminar(JLabel lblEliminar) {
		this.lblEliminar = lblEliminar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
