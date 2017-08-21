package persistencia.dao.mysql;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOMySQL implements LocalidadDAO{
	
	private static LocalidadDAOMySQL instancia;
	
	private static Table<Record> LOCALIDADES = table("localidades");
	private static Field<Integer> IDLOCALIDAD = field("idLocalidad", Integer.class);
	private static Field<String> NOMBRE = field("nombreLocalidad", String.class);
	
	private static final DSLContext create = DSL.using(Conexion.getConexion().getSQLConexion(), SQLDialect.MYSQL);
	
	private LocalidadDAOMySQL(){
		
	}
	
	public static LocalidadDAOMySQL getDAO(){
		if(instancia == null)
			instancia = new LocalidadDAOMySQL();
		return instancia;
	}

	@Override
	public boolean insert(LocalidadDTO toInsert) {
		int query = create.insertInto(LOCALIDADES, IDLOCALIDAD, NOMBRE)
				.values(toInsert.getId(), toInsert.getNombre())
				.execute();
		
		return query == 1;
	}

	@Override
	public boolean delete(LocalidadDTO toDelete) {
		int query = create.deleteFrom(LOCALIDADES)
				.where(IDLOCALIDAD.eq(toDelete.getId()))
				.execute();
		
		return query == 1;
	}

	@Override
	public List<LocalidadDTO> readAll() {
		
		List<LocalidadDTO> toReturn = new ArrayList<>();
		
		Result<Record> res = create.select()
									.from(LOCALIDADES)
									.fetch();
		
		for(Record r : res){
			int id = r.getValue(IDLOCALIDAD);
			String nombre = r.getValue(NOMBRE);
			
			LocalidadDTO toAdd = new LocalidadDTO(id, nombre);
			
			toReturn.add(toAdd);
			
		}
		
		return toReturn;
	}

}
