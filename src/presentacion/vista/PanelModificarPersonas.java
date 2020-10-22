package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelModificarPersonas extends JPanel
{
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JButton btnModificar;
	private PersonaNegocioImpl pNegImpl;
	
	private DefaultListModel listModel;
	public JList<Persona> listPersonas;
	
	//CONSTRUCTOR
	public PanelModificarPersonas() 
	{
		super();
		initialize();
		
	}
	
	//GETTER Y SETTER PARA PASAR AL CONTROLLER
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	public JList<Persona> getListPersonas() {
		return listPersonas;
	}

	public void setListPersonas(JList<Persona> listPersonas) {
		this.listPersonas = listPersonas;
	}

	//INICIALIZAR PANEL
	private void initialize() 
	{
		this.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(48, 272, 95, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(166, 272, 95, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(282, 272, 95, 20);
		txtDni.setEnabled(false);
		add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Seleccione la persona que desea modificar");
		lblNewLabel.setBounds(10, 27, 430, 14);
		add(lblNewLabel);
		
		listPersonas = new JList<Persona>();

		listPersonas.setBounds(48, 65, 447, 196);		
		listModel= new DefaultListModel();
		
		btnModificar = new JButton("Modificar");

		btnModificar.setBounds(395, 271, 100, 23);
		add(btnModificar);
		
		add(listPersonas);
	}
	
	//LISTAR PERSONAS EN EL JLIST

	public void listarPersonasJList(ArrayList<Persona> personas)
	{

        listModel.clear();
        for(int i=0; i<personas.size(); i++) 
        {
            listModel.add(i, personas.get(i));
        }
        listPersonas.setModel(listModel);
	}
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
