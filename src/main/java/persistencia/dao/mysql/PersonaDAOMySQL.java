package persistencia.dao.mysql;

import java.util.ArrayList;
import java.util.List;

import dto.TipoContactoDTO;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.*;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOMySQL implements PersonaDAO
{
	
	private static PersonaDAOMySQL instancia;
	
	private static Table<Record> PERSONAS = table("personas");
	private static Field<Integer> IDPERSONA = field("idPersona", Integer.class);
	private static Field<String> NOMBRE = field("nombrePersona", String.class);
	private static Field<String> TELEFONO = field("telefonoPersona", String.class);
	
	private static final DSLContext create = DSL.using(Conexion.getConexion().getSQLConexion(), SQLDialect.MYSQL);
	
	private PersonaDAOMySQL(){
		
	}
	
	public static PersonaDAOMySQL getDAO(){
		if(instancia == null)
			instancia = new PersonaDAOMySQL();
		
		return instancia;
	}
	
	public boolean insert(PersonaDTO persona)
	{	
		
		int query = create.insertInto(PERSONAS, IDPERSONA, NOMBRE, TELEFONO)
				.values(persona.getIdPersona(), persona.getNombre(), persona.getTelefono())
				.execute();
		
		return query == 1;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		
		int query = create.deleteFrom(PERSONAS)
				.where(IDPERSONA.eq(persona_a_eliminar.getIdPersona()))
				.execute();
		
		return query == 1;
	}
	
	public List<PersonaDTO> readAll()
	{

		List<PersonaDTO> toReturn = new ArrayList<>();
		
		Result<Record> res = create.select()
									.from(PERSONAS)
									.fetch();
		
		for(Record r : res){
			int id = r.getValue(IDPERSONA);
			String nombre = r.getValue(NOMBRE);
			String tel = r.getValue(TELEFONO);
			
			PersonaDTO toAdd = new PersonaDTO(id, nombre, tel);
			
			toReturn.add(toAdd);
			
		}
		
		return toReturn;
		
	}

	@Override
	public void actualizePersona(PersonaDTO oldPersona, PersonaDTO newPersona) {
		
		int query = create.update(PERSONAS)
							.set(NOMBRE, newPersona.getNombre())
							.set(TELEFONO, newPersona.getTelefono())
							.where(IDPERSONA.eq(oldPersona.getIdPersona()))
							.execute();
		
	}
	
	
}
