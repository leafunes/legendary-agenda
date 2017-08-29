package modelo;

import java.util.ArrayList;
import java.util.List;
import dto.PersonaDTO;
import dto.reportes.PersonaReporteDTO;
import dto.reportes.PersonaReporteDTO.SignoChino;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.jpa.PersonaDaoHibernate;


public class PersonaService extends BaseService<PersonaDTO>{
	
	private static PersonaService instancia;
	
	private PersonaDAO personaDao = PersonaDaoHibernate.getDao();	
	
	private PersonaService(){
		super.dao = personaDao;
		
	}
	
	public static PersonaService getService(){
		if(instancia == null)
			instancia = new PersonaService();
		return instancia;
	}

	
	public void actualizePersona(PersonaDTO oldPersona){
		
		personaDao.actualizePersona(oldPersona);
	}
	
	public List<PersonaReporteDTO>getPersonasReporte(){
		
		List<PersonaReporteDTO> toReturn = new ArrayList<>();
		
		List<PersonaDTO> personas = obtenerAll();
		
		for(PersonaDTO p : personas){
			
			PersonaReporteDTO toAdd = new PersonaReporteDTO();
			
			toAdd.setNombre(p.getNombre());
			toAdd.setSigno(getSignoOf(p));
			toAdd.setTelefono(p.getTelefono());
			toAdd.setDireccion(p.getDomicilio().toString());
			toAdd.setTipoContacto(p.getTipo().getNombre());
			toAdd.setEmail(p.getEmail());
			
			toReturn.add(toAdd);
		}
		
		toReturn.sort((p1, p2) -> {
			
			String p1Srt = p1.getSignoStr() + p1.getNombre();
			String p2Str = p2.getSignoStr() + p2.getNombre();
			
			return p1Srt.compareTo(p2Str);
			
		});
		
		return toReturn;
		
	}
	
	private SignoChino getSignoOf(PersonaDTO persona){
	    SignoChino[] signos = PersonaReporteDTO.SignoChino.values();
	    
	    int numeroSigno = (persona.getCumple().getYear() - 4) % 12; //Medio trucho pero bue
	    
	    return signos[numeroSigno];
	    
	}
	
	
}
