package desarrollo2015.rest.client.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="personadeGsocial")
public class PersonGsocial {
	private int id;
	private boolean activo;
	private Contacto contactos;	
	private String correo;
	private boolean estado;
	private String fecha_nac;
	private String foto_perfil;
	private Grupo grupos;
	private String identidad;
	private String primer_apellido;
	private String primer_nombre;
	private boolean registrado;
	private String segundo_apellido;
	private String segundo_nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Contacto getContactos() {
		return contactos;
	}
	public void setContactos(Contacto contactos) {
		this.contactos = contactos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getFoto_perfil() {
		return foto_perfil;
	}
	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}
	public Grupo getGrupos() {
		return grupos;
	}
	public void setGrupos(Grupo grupos) {
		this.grupos = grupos;
	}
	public String getIdentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}
	public String getPrimer_apellido() {
		return primer_apellido;
	}
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	public String getPrimer_nombre() {
		return primer_nombre;
	}
	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}
	public boolean isRegistrado() {
		return registrado;
	}
	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}
	public String getSegundo_apellido() {
		return segundo_apellido;
	}
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	public String getSegundo_nombre() {
		return segundo_nombre;
	}
	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}
}
