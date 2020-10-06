package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelModificarPersonas extends JPanel
{
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	
	private PersonaDaoImpl pDao;
	ArrayList<Persona> personas;
	private DefaultListModel listModel;
	private JList<Persona> listPersonas;
	
	public PanelModificarPersonas() 
	{
		setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(131, 246, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(244, 246, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(10, 246, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
			
		});
		btnModificar.setBounds(340, 246, 100, 23);
		add(btnModificar);
		
		JLabel lblNewLabel = new JLabel("Seleccione la persona que desea modificar");
		lblNewLabel.setBounds(10, 27, 430, 14);
		add(lblNewLabel);
		
		
		listPersonas = new JList<Persona>();
		
		listPersonas.setBounds(48, 65, 311, 141);
		add(listPersonas);
		listModel= new DefaultListModel();
		listPersonas.addListSelectionListener(new ListSelectionListener() 
		{
			@Override
			public void valueChanged(ListSelectionEvent arg0) 
			{
				Persona per_modificar = new Persona();
				 if(listPersonas.getSelectedIndex()!=-1)
	                {
	                    System.out.println("troll haunter");
	                    per_modificar = (Persona) listModel.getElementAt(listPersonas.getSelectedIndex());
	                    
	                }
			}
		});
		add(listPersonas);
		
		pDao = new PersonaDaoImpl();
        personas = pDao.readAll();
        listModel.clear();
        for(int i=0; i<personas.size(); i++) 
        {
            listModel.add(i, personas.get(i));
        }
        System.out.println(listModel.size());
        listPersonas.setModel(listModel);
        
		
		/*personas= pDao.readAll();
		DefaultListModel<Persona> model = new DefaultListModel<Persona>();
		for(Persona persona : personas)
		{
		       model.addElement(persona);
		}
		JList<Persona> contactList = new JList<Persona>(model);
		 
		
		/*listModel = new DefaultListModel();
		
		for(int i=0; i<personas.size(); i++) 
		{
		    listModel.add(i, personas.get(i));
		}
		
		listPersonas.setModel(listModel);*/
		
	}
}
