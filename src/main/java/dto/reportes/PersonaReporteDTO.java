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

}
