package coop.tecso.examen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import coop.tecso.examen.dto.MovimientoDto;




@Entity
@Table(name = "movimiento")
public class Movimiento extends EntidadIdentidad {

	private static final long serialVersionUID = -8901155893511467206L;
	
	@Column(name = "tipomov", nullable = true)
	private String tipoMovimiento;
	
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	
	@Column(name = "importe", nullable = false)
	private float importe = 0;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cuenta_id")
	private CuentaCorriente cuenta;

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

	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public MovimientoDto getDTO(String... camposIgnorados) {
		MovimientoDto dto = new MovimientoDto();
		BeanUtils.copyProperties(this, dto);
		if (this.getCuenta() != null) {
			dto.setCuenta_id(this.getCuenta().getId());
		}
		return dto;
	}
	
	
	
	
	
	
}
