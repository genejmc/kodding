package desarrollo2015.rest.client.domain;

public class User {
	private String id;	
	public User(String id, boolean activo, String contactos, String estado,
			String grupos, boolean registrado, String open_id,
			String primer_nombre, String segundo_nombre,
			String primer_apellido, String segundo_apellido, String fecha_nac,
			String correo_electronico, String foto_perfil) {
		super();
		this.id = id;
		this.activo = activo;
		this.contactos = contactos;
		this.estado = estado;
		this.grupos = grupos;
		this.registrado = registrado;
		this.open_id = open_id;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.fecha_nac = fecha_nac;
		this.correo_electronico = correo_electronico;
		this.foto_perfil = foto_perfil;
	}
	private boolean activo;
	private String contactos;
	private String estado;
	private String grupos;
	private boolean registrado;
	private String open_id;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String fecha_nac;
	private String correo_electronico;
	private String foto_perfil;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public String getContactos() {
		return contactos;
	}
	public void setContactos(String contactos) {
		this.contactos = contactos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getGrupos() {
		return grupos;
	}
	public void setGrupos(String grupos) {
		this.grupos = grupos;
	}
	public boolean isRegistrado() {
		return registrado;
	}
	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getPrimer_nombre() {
		return primer_nombre;
	}
	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}
	public String getSegundo_nombre() {
		return segundo_nombre;
	}
	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}
	public String getPrimer_apellido() {
		return primer_apellido;
	}
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	public String getSegundo_apellido() {
		return segundo_apellido;
	}
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	public String getFoto_perfil() {
		return foto_perfil;
	}
	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}
	
	
}
