package coop.tecso.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "titular")
public class Titular extends AbstractPersistentObject {

	private static final long serialVersionUID = -8901155893511467206L;
	
	@Column(name = "nombre", nullable = true)
	private String nombre;
	@Column(name = "apellido", nullable = true)
	private String apellido;
	@Column(name = "dni", nullable = true)
	private String dni;
	@Column(name = "cuit", nullable = false, unique = true)
	private String cuit;
	@Column(name = "razon", nullable = true)
	private String razonSocial;
	@Column(name = "anyo", nullable = true)
	private String anyoFundacion;
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getAnyoFundacion() {
		return anyoFundacion;
	}
	public void setAnyoFundacion(String anyoFundacion) {
		this.anyoFundacion = anyoFundacion;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
