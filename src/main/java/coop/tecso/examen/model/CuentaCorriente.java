package coop.tecso.examen.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import coop.tecso.examen.dto.CuentaCorrienteDto;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.utils.Utilities;


@Entity
@Table(name = "cuenta")
public class CuentaCorriente extends EntidadIdentidad {

	private static final long serialVersionUID = -8901155893511467206L;
	
	@Column(name = "numero", nullable = true, unique = true)
	private String numero;
	@Column(name = "tipomoneda", nullable = true)
	private String tipoMoneda;
	@Column(name = "saldo", nullable = true)
	private float saldo=0;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cuenta", cascade = CascadeType.ALL)
	private List<Movimiento> movimientos;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public CuentaCorrienteDto getDTO(String... camposIgnorados) {
		CuentaCorrienteDto dto = new CuentaCorrienteDto();
		BeanUtils.copyProperties(this, dto);
		if (this.getMovimientos() != null) {
			
			dto.setMovimientos(Utilities.toDTOList(this.getMovimientos(), MovimientoDto.class));
			
		}
		return dto;
	}
	
	
	
	
}
