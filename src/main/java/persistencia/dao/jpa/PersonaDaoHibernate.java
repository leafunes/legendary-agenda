package persistencia.dao.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.PersonaDAO;

public class PersonaDaoHibernate extends DaoHibernate<PersonaDTO> implements PersonaDAO{
	
	private static PersonaDAO instancia;
	
	public static PersonaDAO getDao(){
		if(instancia == null)
			instancia = new PersonaDaoHibernate();
		return instancia;
	}
	
	private PersonaDaoHibernate(){
		
	}

	@Override
	public void actualizePersona(PersonaDTO toActualize) {
		initTransaction();
		
		sesion.saveOrUpdate(toActualize);
		
		finishTransaction();
		
	}

	@Override
	public List<PersonaDTO> getAllWith(TipoContactoDTO contacto) {

		initTransaction();
		
		Criteria query = sesion.createCriteria(PersonaDTO.class)
								.setFetchMode("tipo", FetchMode.JOIN)
								.add(Restrictions.eq("tipo.id", contacto.getId()));
		
		finishTransaction();
		
		return query.list();
	}

	@Override
	public List<PersonaDTO> getAllWith(LocalidadDTO localidad) {
		
		initTransaction();
		
		Criteria query = sesion.createCriteria(PersonaDTO.class)
								.setFetchMode("domicilio", FetchMode.JOIN)
								.setFetchMode("domicilio.localidad", FetchMode.JOIN)
								.add(Restrictions.eq("domicilio.localidad.id", localidad.getId()));
		
		finishTransaction();
		
		return query.list();
		

	}

	@Override
	public List<PersonaDTO> readAll() {
		
		initTransaction();
		
		Criteria query = sesion.createCriteria(PersonaDTO.class);
				
		finishTransaction();
		
		return query.list();
	}

}
