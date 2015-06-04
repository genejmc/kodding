package desarrollo2015.rest.client.domain;

public class Publication {
	
	public Publication(String _id, String fecha_creacion,
			String id_administrador, String imagen_personalizada,
			String nombre, String participantes) {
		super();
		this._id = _id;
		this.fecha_creacion = fecha_creacion;
		this.id_administrador = id_administrador;
		this.imagen_personalizada = imagen_personalizada;
		this.nombre = nombre;
		this.participantes = participantes;
	}
	private String _id;
	private String fecha_creacion;
	private String id_administrador;
	private String imagen_personalizada;
	private String nombre;
	private String participantes;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getId_administrador() {
		return id_administrador;
	}
	public void setId_administrador(String id_administrador) {
		this.id_administrador = id_administrador;
	}
	public String getImagen_personalizada() {
		return imagen_personalizada;
	}
	public void setImagen_personalizada(String imagen_personalizada) {
		this.imagen_personalizada = imagen_personalizada;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getParticipantes() {
		return participantes;
	}
	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}
	
	
}
