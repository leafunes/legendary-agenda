package dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name="personas")
public class PersonaDTO 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPersona;
	
	private String nombre;
	private String telefono;

	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime cumple;
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DomicilioDTO domicilio;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private TipoContactoDTO tipo;

	public PersonaDTO(){
		
	}

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
