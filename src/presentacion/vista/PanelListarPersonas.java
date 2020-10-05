package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import java.util.ArrayList;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;


public class PanelListarPersonas extends JPanel {
	
	private JTable table;
	private PersonaDaoImpl personaDaoImpl;
	DefaultTableModel tableModel;
	ArrayList<Persona> personas;
	
	public PanelListarPersonas() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 300);
		add(panel);
		
		
		
		String columnas[] = {"Nombre", "Apellido", "DNI"};
		tableModel = new DefaultTableModel(columnas, 0);
		table = new JTable(tableModel);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		personaDaoImpl = new PersonaDaoImpl();
		personas = personaDaoImpl.readAll();
		
		for (Persona persona : personas) {
			Object[] objs = {persona.getNombre(), persona.getApellido(), persona.getDni()}; 
			tableModel.addRow(objs);
		}
		
		
		
		//panel.setLayout(null);
		panel.setLayout(new BorderLayout());
		
		table.setBounds(32, 25, 385, 249);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		
		
		
	}
}
