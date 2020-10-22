package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersonas;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener{
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlIngresoPersonas;
	private PanelModificarPersonas pnlModificar;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelListarPersonas pnlListarPersonas;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasLista;

	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlIngresoPersonas = new PanelAgregarPersonas();
		this.pnlEliminarPersonas = new PanelEliminarPersonas();
		this.pnlModificar= new PanelModificarPersonas();
		
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		this.ventanaPrincipal.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));

		//Eventos PanelAgregarPersonas
		 this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		//evento que permite que solo se ingresen letras y espacios --> 100%
		 this.pnlIngresoPersonas.getTextFieldNombre().addKeyListener(new KeyAdapter() {
			 
				public void keyTyped(KeyEvent e) 
				{
					if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE) && !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
					} 
				}
		});
		//evento que permite que solo se ingresen letras y espacios --> 100%
		 this.pnlIngresoPersonas.getTextFieldApellido().addKeyListener(new KeyAdapter() {
			 
				public void keyTyped(KeyEvent e)
				{
					if (!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar() == KeyEvent.VK_SPACE) && !(e.getKeyChar() == KeyEvent.VK_BACK_SPACE))
					{
						e.consume();
					} 
				}
		});
		//evento que permite que solo se ingresen numeros --> 100%
		 this.pnlIngresoPersonas.getTextFieldDni().addKeyListener(new KeyAdapter() {
			 
				public void keyTyped(KeyEvent e) 
				{
					char carac= e.getKeyChar();
					
					if(Character.isLetter(carac)  || (e.getKeyChar() == KeyEvent.VK_SPACE))
					{
						e.consume();
					}
				}
		});
		
		//Eventos PanelEliminarPersonas
		 this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
		 this.pnlEliminarPersonas.getTxtDniEliminar().addKeyListener(new KeyAdapter() {
			 
				public void keyTyped(KeyEvent e) 
				{
					char carac= e.getKeyChar();
					
					if(Character.isLetter(carac)  || (e.getKeyChar() == KeyEvent.VK_SPACE))
					{
						e.consume();
					}
				}
		});
		 
		//Eventos PanelModificarPersonas (ACA ESTA EL PROBLEMA)!!!!******************
		this.pnlModificar.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPesona_PanelModificarPersonas(a));

	}
	
	
	
	private void EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a) 
	{
		this.pnlListarPersonas = new PanelListarPersonas();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	//EventoClickMenu abrir PanelEliminarPersonas
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificar);
		//Carga la lista de PANELMODIFICAR
		refrescarListaPersona();
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	//EventoClickBoton agregar persona en PanelAgregarPersonas
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) 
	{
		String txtNombre = this.pnlIngresoPersonas.getTextFieldNombre().getText();
		String txtApellido = this.pnlIngresoPersonas.getTextFieldApellido().getText();
		String txtDni = this.pnlIngresoPersonas.getTextFieldDni().getText();

			if(!txtNombre.equals("")&& !txtApellido.equals("") && !txtDni.equals(""))
			{
				PersonaDaoImpl pdi= new PersonaDaoImpl();

				String dni=txtDni;
				
				if(pdi.verificarPersona(dni)==false)
				{
					Persona p= new Persona();
					
					p.setDni(txtDni);
					p.setNombre(txtNombre);
					p.setApellido(txtApellido);

					pdi.insert(p);
					JOptionPane.showMessageDialog(null, "Persona agregada correctamente");
					this.pnlIngresoPersonas.getTextFieldDni().setText("");
					this.pnlIngresoPersonas.getTextFieldNombre().setText("");
					this.pnlIngresoPersonas.getTextFieldApellido().setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Número de dni ya existe.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Debes completar todos los campos para continuar");
			}
			
		
	}
	
	//EventoClickBoton modificar persona en PanelModificarPersonas	
	public void EventoClickBoton_ModificarPesona_PanelModificarPersonas(ActionEvent s) 
	{
		String dni_Modificar = this.pnlModificar.getTxtDni().getText();
		String nombre_Modificar = this.pnlModificar.getTxtNombre().getText();
		String apellido_Modificar = this.pnlModificar.getTxtApellido().getText();
		String dniOriginal = this.pnlModificar.listPersonas.getSelectedValue().getDni();
		Persona personaMod = new Persona();
		personaMod.setDni(dni_Modificar);
		personaMod.setNombre(nombre_Modificar);
		personaMod.setApellido(apellido_Modificar);
		boolean estado=false;
		String mensaje;
		//Para verificar que datos estan viajando
		//JOptionPane.showMessageDialog(null, personaMod+" "+dniOriginal);
		estado = pNeg.modificar(personaMod,dniOriginal);
		if(estado==true)
		{
			mensaje="Persona MODIFICADA con exito";	
			refrescarListaPersona();
		}
		else
		{
			 mensaje="NO SE PUDO MODIFICAR";
		}
		this.pnlModificar.mostrarMensaje(mensaje);
		
	}
	
	
	//EventoClickBoton borrar persona en PanelEliminarPersonas
	public void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s)
		{
			String dni_eliminar = this.pnlEliminarPersonas.getTxtDniEliminar().getText();
			Persona persona = new Persona();
			persona.setDni(dni_eliminar);
			
			boolean estado=false;
			String mensaje;
			estado = pNeg.delete(persona);
			if(estado==true)
			{
				mensaje="Persona eliminada con exito";	
			}
			else
			{
				 mensaje="DNI inexistente";
			}
			this.pnlEliminarPersonas.getTxtDniEliminar().setText("");
			this.pnlEliminarPersonas.mostrarMensaje(mensaje);
		}
		
	
	private void refrescarListaPersona()
	{
		this.personasLista = (ArrayList<Persona>) pNeg.readAll();
		this.pnlModificar.listarPersonasJList(this.personasLista);
	}
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
}
