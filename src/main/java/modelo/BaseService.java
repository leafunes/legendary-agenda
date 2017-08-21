package modelo;

import java.util.List;

import dto.PersonaDTO;
import persistencia.dao.interfaz.DAO;

public class BaseService <DTO>{
	
	protected DAO<DTO> dao;
	
	protected BaseService(){
	}
	
	public void agregar(DTO toAdd)
	{
		dao.insert(toAdd);
	}

	public void borrar(DTO toRemove) 
	{
		dao.delete(toRemove);
	}
	
	public List<DTO> obtenerAll()
	{
		return dao.readAll();		
	}
}
