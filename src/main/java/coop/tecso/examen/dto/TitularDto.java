package coop.tecso.examen.dto;



import javax.validation.constraints.NotNull;

public class TitularDto extends DTOIdentidad {
	

	private static final long serialVersionUID = -1854383574061855612L;

	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String dni;
	
	@NotNull(message = "El campo activo no puede ser vacio")
	private String cuit;
	
	private String razonSocial;
	
	private String anyoFundacion;
	
	private String tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getAnyoFundacion() {
		return anyoFundacion;
	}

	public void setAnyoFundacion(String anyoFundacion) {
		this.anyoFundacion = anyoFundacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
