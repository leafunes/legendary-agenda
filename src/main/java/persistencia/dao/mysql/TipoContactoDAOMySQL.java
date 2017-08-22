package persistencia.dao.mysql;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

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

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDAOMySQL implements TipoContactoDAO {

    private static TipoContactoDAOMySQL instancia;

    private static Table<Record> TIPOCONTACTOS = table ("tipoContactos");
    private static Field<Integer> IDTIPOCONTACTO = field("idTipoContacto", Integer.class);
    private static Field<String> NOMBRE = field("nombreTipoContacto", String.class);

    private static final DSLContext create = DSL.using(Conexion.getConexion().getSQLConexion(), SQLDialect.MYSQL);

    private TipoContactoDAOMySQL(){

    }

    public static TipoContactoDAOMySQL getDAO(){
        if(instancia == null)
            instancia = new TipoContactoDAOMySQL();
        return instancia;
    }

    @Override
    public boolean insert(TipoContactoDTO toInsert) {
        int query = create.insertInto(TIPOCONTACTOS, IDTIPOCONTACTO, NOMBRE)
                .values(toInsert.getId() , toInsert.getNombre())
                .execute();

        return query == 1;
    }

    @Override
    public boolean delete(TipoContactoDTO toDelete) {
        int query = create.deleteFrom(TIPOCONTACTOS)
                .where(IDTIPOCONTACTO.eq(toDelete.getId()))
                .execute();

        return query == 1;
    }

    @Override
    public List<TipoContactoDTO> readAll() {

        List<TipoContactoDTO> toReturn = new ArrayList<>();

        Result<Record> res = create.select()
                .from(TIPOCONTACTOS)
                .fetch();

        for(Record r : res){
            int id = r.getValue(IDTIPOCONTACTO);
            String nombre = r.getValue(NOMBRE);

            TipoContactoDTO toAdd = new TipoContactoDTO(id, nombre);

            toReturn.add(toAdd);

        }

        return toReturn;
    }

}
