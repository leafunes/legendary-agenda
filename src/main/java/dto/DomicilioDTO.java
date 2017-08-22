package dto;

public class DomicilioDTO
{
	private String calle;
	private int altura;
	private int piso;
	private int depto;
	private LocalidadDTO localidad;
	
	
	public DomicilioDTO(String calle, int altura, int piso, int depto, LocalidadDTO localidad) {
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
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public int getDepto() {
		return depto;
	}
	public void setDepto(int depto) {
		this.depto = depto;
	}
	public LocalidadDTO getLocalidad() {
		return localidad;
	}
	public void setLocalidad(LocalidadDTO localidad) {
		this.localidad = localidad;
	}


}
