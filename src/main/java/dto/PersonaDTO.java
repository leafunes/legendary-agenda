package dto;

import org.joda.time.DateTime;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private DomicilioDTO domicilio;
	private DateTime cumple;
	private String email;
	private TipoContactoDTO tipo;


	public PersonaDTO(int idPersona, String nombre, String telefono,DomicilioDTO domicilio, DateTime cumple, String email, TipoContactoDTO tipo) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.cumple = cumple;
		this.email = email;
		this.tipo = tipo;
	}
	


	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}



	public DateTime getCumple() {
		return cumple;
	}

	public void setCumple(DateTime cumple) {
		this.cumple = cumple;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public DomicilioDTO getDomicilio() {
		return domicilio;
	}



	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public TipoContactoDTO getTipo() {
		return tipo;
	}



	public void setTipo(TipoContactoDTO tipo) {
		this.tipo = tipo;
	}
}
