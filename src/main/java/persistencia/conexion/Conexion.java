package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
	public static Conexion instancia;
	private Connection conexion;
	
	public Conexion()
	{
		try
		{
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpi_g7","root","root");
			System.out.println("Conexion exitosa");
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return conexion;
	}
	
	public void cerrarConexion()
	{
		instancia = null;
	}
}
