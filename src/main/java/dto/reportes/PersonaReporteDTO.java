package dto.reportes;

public class PersonaReporteDTO {
	
	public enum SignoChino{
		Rata,
		Buey,
		Tigre,
		Gato,
		Dragon,
		Serpiente,
		Caballo,
		Cabra,
		Mono,
		Gallo,
		Perro,
		Jabali
	};
	
	private String nombre;
	private String telefono;
	private String tipoContacto;
	private String direccion;
	private SignoChino signo;
	
	public PersonaReporteDTO() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SignoChino getSigno() {
		return signo;
	}

	public void setSigno(SignoChino signo) {
		this.signo = signo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
