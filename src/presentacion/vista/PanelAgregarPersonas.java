package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.PersonaDao;
import daoImpl.Conexion;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PanelAgregarPersonas extends JPanel  
{

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnAgregar;

	 public PanelAgregarPersonas()
	 {
		super();
		initialize();
		
	}
	 	
	public JTextField getTextFieldNombre() {
		return txtNombre;
	}


	public void setTextFieldNombre(JTextField textFieldNombre) {
		this.txtNombre = textFieldNombre;
	}


	public JTextField getTextFieldApellido() {
		return txtApellido;
	}


	public void setTextFieldApellido(JTextField textFieldApellido) {
		this.txtApellido = textFieldApellido;
	}


	public JTextField getTextFieldDni() {
		return txtDni;
	}


	public void setTextFieldDni(JTextField textFieldDni) {
		this.txtDni = textFieldDni;
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
		
		txtNombre = new JTextField();
		
		txtNombre.setBounds(182, 71, 150, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(108, 73, 46, 17);
		add(lblNombre);
		
		txtApellido = new JTextField();
		
		txtApellido.setBounds(182, 102, 151, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(108, 105, 46, 14);
		add(lblApellido);
		
		txtDni = new JTextField();
		
		txtDni.setBounds(182, 40, 150, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(108, 43, 46, 14);
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
