package persistencia.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DAO;

public abstract class DaoJPA<T> implements DAO<T>{
	
	protected Conexion conexion = Conexion.getConexion();
	protected EntityManager entityManager = conexion.getEntityManager();
	protected EntityTransaction transaction = entityManager.getTransaction();
	protected CriteriaBuilder builder = entityManager.getCriteriaBuilder();

	@Override
	public void insert(T toInsert) {
		
		initTransaction();
		
		entityManager.persist(toInsert);
		
		finishTransaction();
		
	}

	@Override
	public void delete(T toDelete) {
		initTransaction();
		
		entityManager.remove(toDelete);
		
		finishTransaction();
		
	}

	@Override
	public abstract List<T> readAll();
	
	protected void initTransaction(){
		
		if(!transaction.isActive())
			transaction.begin();
		
	}

	protected void finishTransaction(){
		
		if(transaction.isActive())
			transaction.commit();
		
	}
	
	
}
