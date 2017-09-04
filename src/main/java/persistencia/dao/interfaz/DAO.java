package persistencia.dao.interfaz;

import java.util.List;

public interface DAO<T> {
	
	public void insert(T toInsert);
	
	public void delete(T toDelete);
	
	public List<T> readAll();

}
