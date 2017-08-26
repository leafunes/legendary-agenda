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

@Entity
@Table(name="domicilios")
public class DomicilioDTO
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String calle;
	private String altura;
	private String piso;
	private String depto;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private LocalidadDTO localidad;
	
	public DomicilioDTO(){
		
	}
	
	public DomicilioDTO(String calle, String altura, String piso, String depto, LocalidadDTO localidad) {
		super();
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.depto = depto;
		this.localidad = localidad;
	}
	
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public LocalidadDTO getLocalidad() {
		return localidad;
	}
	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}
	
	public String toString(){
		
		String toRet = calle + " al " + altura;
		
		
		if(!piso.equals("")) toRet += " Piso " + piso;
		if(!depto.equals("")) toRet += " Dpto. " + depto;
		
		toRet += ", " + localidad.getNombre();
		
		return toRet;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


}
