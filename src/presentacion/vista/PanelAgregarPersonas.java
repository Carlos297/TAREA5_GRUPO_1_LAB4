package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import daoImpl.Conexion;
import entidad.Persona;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;


public class PanelAgregarPersonas extends JPanel  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	private JButton btnAgregar;
	

	 public PanelAgregarPersonas() {
	
		super();
		initialize();
	}
	 	
	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}


	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.textFieldNombre = textFieldNombre;
	}


	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}


	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.textFieldApellido = textFieldApellido;
	}


	public JTextField getTextFieldDni() {
		return textFieldDni;
	}


	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldDni = textFieldDni;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
	 
	 
	 
	 
	 
	 private void initialize() 
		{
		setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(182, 40, 150, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(108, 42, 46, 17);
		add(lblNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(182, 71, 151, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(108, 74, 46, 14);
		add(lblApellido);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(182, 102, 150, 20);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(108, 105, 46, 14);
		add(lblDni);
	
		
		btnAgregar = new JButton("Aceptar");
		btnAgregar.setBounds(108, 133, 89, 23);
		add(btnAgregar);
	}
	 
		public void mostrarMensaje(String mensaje)
		{
			JOptionPane.showMessageDialog(null, mensaje);
		}
}
