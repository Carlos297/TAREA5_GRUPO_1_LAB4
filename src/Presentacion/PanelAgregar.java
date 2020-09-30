package Presentacion;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PanelAgregar extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDni;
	public PanelAgregar() {
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
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(108, 133, 89, 23);
		add(btnAceptar);
	}
}
