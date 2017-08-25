package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion 
{
	private static Conexion instancia;

    private EntityManagerFactory factory;
	
	public Conexion(){
    	factory = Persistence.createEntityManagerFactory("agenda");
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
	public void cerrar()
	{
		factory.close();
	}
}
