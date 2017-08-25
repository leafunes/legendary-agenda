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
	private int altura;
	private Integer piso;
	private Integer depto;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private LocalidadDTO localidad;
	
	private DomicilioDTO(){
		
	}
	
	public DomicilioDTO(String calle, int altura, Integer piso, Integer depto, LocalidadDTO localidad) {
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
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public Integer getDepto() {
		return depto;
	}
	public void setDepto(Integer depto) {
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
		
		if(piso != null) toRet += " Piso " + piso;
		if(depto != null) toRet += " Dpto. " + depto;
		
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
