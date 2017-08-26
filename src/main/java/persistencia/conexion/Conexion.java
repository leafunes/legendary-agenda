package persistencia.conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conexion 
{
	private static Conexion instancia;

	private StandardServiceRegistry registry;
    private SessionFactory factory;
	
	public Conexion(){
		
		registry = new StandardServiceRegistryBuilder().configure(new File("hibernate.cfg.xml")).build();
		
		MetadataSources sources = new MetadataSources(registry);
		
		Metadata metadata = sources.getMetadataBuilder().build();
	
    	factory = metadata.getSessionFactoryBuilder().build();
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public SessionFactory getSessionFactory(){
		return factory;
	}
	
	public void cerrar()
	{
		factory.close();
	}
}
