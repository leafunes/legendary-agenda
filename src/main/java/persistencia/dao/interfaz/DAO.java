package persistencia.dao.interfaz;

import java.util.List;

public interface DAO<T> {
	
	public boolean insert(T toInsert);
	
	public boolean delete(T toDelete);
	
	public List<T> readAll();

}
