package persistencia.dao.mysql;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.TipoContactoDTO;

import org.joda.time.DateTime;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;

import static org.jooq.impl.DSL.*;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import dto.DomicilioDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class PersonaDAOMySQL implements PersonaDAO
{
	
	private static PersonaDAOMySQL instancia;
	
	private static Table<Record> PERSONAS = table("personas");
	private static Table<Record> LOCALIDADES = table("localidades");
	private static Table<Record> TIPOS = table("tipoContactos");
	
	private static Field<Integer> IDPERSONA = field("idPersona", Integer.class);
	private static Field<String> NOMBRE = field("nombrePersona", String.class);
	private static Field<String> TELEFONO = field("telefonoPersona", String.class);
	private static Field<String> CALLE = field("callePersona", String.class);
	private static Field<Integer> ALTURA = field("alturaPersona", Integer.class);
	private static Field<Integer> PISO = field("pisoPersona", Integer.class);
	private static Field<Integer> DEPTO = field("departamentoPersona", Integer.class);
	private static Field<Integer> IDLOCALIDAD = field("idLocalidad", Integer.class);
	private static Field<String> EMAIL = field("emailPersona", String.class);
	private static Field<String> CUMPLE = field("cumplePersona", String.class);
	private static Field<Integer> IDTIPOCONTACTO = field("idTipoContacto", Integer.class);

	private static Field<String> NOMBRECONTACTO = field("nombreTipo", String.class);
	private static Field<String> NOMBRELOCALIDAD = field("nombreLocalidad", String.class);
	
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
		
		int query = create.insertInto(PERSONAS, IDPERSONA, NOMBRE, TELEFONO, CALLE, ALTURA, PISO, 
									DEPTO, IDLOCALIDAD, EMAIL,CUMPLE, IDTIPOCONTACTO)
				.values(persona.getIdPersona(), 
						persona.getNombre(), 
						persona.getTelefono(),
						persona.getDomicilio().getCalle(),
						persona.getDomicilio().getAltura(),
						persona.getDomicilio().getPiso(),
						persona.getDomicilio().getDepto(),
						persona.getDomicilio().getLocalidad().getId(),
						persona.getEmail(),
						persona.getCumple().toString(),
						persona.getTipo().getId())
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

		
		Result<Record> res = create.select()
									.from(PERSONAS.naturalJoin(LOCALIDADES)
												.naturalJoin(TIPOS))
									.fetch();
		
		
		return getListOfPersonas(res);
		
	}

	@Override
	public void actualizePersona(PersonaDTO oldPersona, PersonaDTO newPersona) {
		
		int query = create.update(PERSONAS)
							.set(NOMBRE, newPersona.getNombre())
							.set(TELEFONO, newPersona.getTelefono())
							.set(CALLE, newPersona.getDomicilio().getCalle())
							.set(ALTURA, newPersona.getDomicilio().getAltura())
							.set(PISO, newPersona.getDomicilio().getPiso())
							.set(DEPTO, newPersona.getDomicilio().getDepto())
							.set(IDLOCALIDAD, newPersona.getDomicilio().getLocalidad().getId())
							.set(EMAIL, newPersona.getEmail())
							.set(CUMPLE,newPersona.getCumple().toString())
							.set(IDTIPOCONTACTO, newPersona.getTipo().getId())
							.where(IDPERSONA.eq(oldPersona.getIdPersona()))
							.execute();
		
	}

	@Override
	public List<PersonaDTO> getAllWith(TipoContactoDTO contacto) {
		
		Result<Record> res = create.select()
									.from(PERSONAS.naturalJoin(TIPOS).naturalJoin(LOCALIDADES))
									.where(IDTIPOCONTACTO.eq(contacto.getId()))
									.fetch();
		
		return getListOfPersonas(res);
		
	}
	
	@Override
	public List<PersonaDTO> getAllWith(LocalidadDTO localidad) {
		
		Result<Record> res = create.select()
									.from(PERSONAS.naturalJoin(TIPOS).naturalJoin(LOCALIDADES))
									.where(IDLOCALIDAD.eq(localidad.getId()))
									.fetch();
		
		return getListOfPersonas(res);
		
	}
	
	private List<PersonaDTO> getListOfPersonas(Result<Record> res){
		
		List<PersonaDTO> toRet = new ArrayList<>();
		
		for(Record r : res){
			int id = r.getValue(IDPERSONA);
			String nombre = r.getValue(NOMBRE);
			String tel = r.getValue(TELEFONO);
			String calle = r.getValue(CALLE);
			int altura = r.getValue(ALTURA);
			int piso = r.getValue(PISO);
			int depto = r.getValue(DEPTO);
			int localidadID = r.getValue(IDLOCALIDAD);
			String email = r.getValue(EMAIL);
			DateTime cumple = new DateTime(r.getValue(CUMPLE));
			int tipoID = r.getValue(IDTIPOCONTACTO);
			
			String nombrelocalidad = r.getValue(NOMBRELOCALIDAD);
			String nombreTipo = r.getValue(NOMBRECONTACTO);
			
			
			LocalidadDTO localidad = new LocalidadDTO(localidadID, nombrelocalidad);
			TipoContactoDTO tipo = new TipoContactoDTO(tipoID, nombreTipo);
			
			DomicilioDTO domicilio = new DomicilioDTO(calle, altura, piso, depto, localidad);
			
			
			PersonaDTO toAdd= new PersonaDTO(id, nombre, tel, domicilio, cumple, email, tipo);
			
			toRet.add(toAdd);
			
		}
		
		return toRet;
	}
	
	
}
