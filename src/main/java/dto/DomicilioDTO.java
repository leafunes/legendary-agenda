package dto;

public class DomicilioDTO
{
	private String calle;
	private int altura;
	private Integer piso;
	private Integer depto;
	private LocalidadDTO localidad;
	
	
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


}
