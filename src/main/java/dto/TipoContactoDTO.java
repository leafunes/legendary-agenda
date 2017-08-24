package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoContactos")
public class TipoContactoDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTipoContacto")
    private int id;
	
	@Column(name="nombreTipo")
    private String nombre;

    public TipoContactoDTO(int id, String tipo){
        super();
        this.id = id;
        this.nombre = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
