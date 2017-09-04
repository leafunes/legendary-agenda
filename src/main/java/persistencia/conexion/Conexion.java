package persistencia.conexion;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Conexion 
{
	private static Conexion instancia;
	
    private SessionFactory factory;
    private File configuration = new File("config" + File.separatorChar + "hibernate.cfg.xml");
    
    private DBCredentialsEditor dbProps = DBCredentialsEditor.getEditor();
	
	public Conexion(){

		Configuration c = new Configuration();
		c.configure(configuration);
		
		String url = "jdbc:mysql://" + dbProps.getIP() + ":" + dbProps.getPuerto() + "/tpi_g7";
		
		c.setProperty("hibernate.connection.url", url);
		c.setProperty("hibernate.connection.username", dbProps.getUsuario());
		c.setProperty("hibernate.connection.password", dbProps.getPass());
		
	
    	factory = c.buildSessionFactory();
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public static void resetConexion() throws HibernateException{
		instancia = new Conexion();
	}
	
	
	public SessionFactory getSessionFactory(){
		return factory;
	}
	
	
	public void cerrar()
	{
		factory.close();
	}
}
