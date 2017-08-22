package dto;

public class TipoContactoDTO {

    private int id;
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
