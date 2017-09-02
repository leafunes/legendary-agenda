package persistencia.dao.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DAO;
import utils.MessageBox;

public abstract class DaoHibernate<T> implements DAO<T>{
	
	protected Conexion conexion = Conexion.getConexion();
	protected SessionFactory sesionFactory = conexion.getSessionFactory();
	protected Session sesion = sesionFactory.openSession();
	protected Transaction transaction;
	
	private MessageBox messageBox = MessageBox.getMessageBox();
	
	protected DaoHibernate() {
		messageBox.suscribirse("newConexion", () -> resetConexion());
	}
	
	private void resetConexion(){
		conexion = Conexion.getConexion();
		sesionFactory = conexion.getSessionFactory();
		sesion = sesionFactory.openSession();
	}

	@Override
	public void insert(T toInsert) {
		
		initTransaction();
		
		sesion.save(toInsert);
		
		finishTransaction();
		
	}

	@Override
	public void delete(T toDelete) {
		initTransaction();
		
		sesion.delete(toDelete);
		
		finishTransaction();
		
	}

	@Override
	public abstract List<T> readAll();
	
	protected void initTransaction(){
		
		transaction = sesion.beginTransaction();
		
	}

	protected void finishTransaction(){
		
		transaction.commit();
		
	}
	
	
}
