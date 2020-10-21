package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDao pdao = new PersonaDaoImpl();
	
	
	//Falta funcion MODIFICAR
	@Override
	public boolean modificar(Persona persona)
	{
		boolean estado=false;
		if(persona.getDni().trim().length()>0 )
		{
			estado=pdao.modificar(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni().trim().length()>0 )//También se puede preguntar si existe ese ID 
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}
	
	
}
