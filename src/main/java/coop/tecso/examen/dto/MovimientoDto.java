package coop.tecso.examen.dto;


import java.util.Date;


public class MovimientoDto extends DTOIdentidad {
	

	private static final long serialVersionUID = -1854383574061855612L;

	
	private Long id;
	
	
	private String tipoMovimiento;
	
	
	private String descripcion;
	
	
	private Date fecha;
	
	
	private float importe = 0;
	
	
	private Long cuenta_id;

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCuenta_id() {
		return cuenta_id;
	}

	public void setCuenta_id(Long cuenta_id) {
		this.cuenta_id = cuenta_id;
	}
	
	
	
	

}
