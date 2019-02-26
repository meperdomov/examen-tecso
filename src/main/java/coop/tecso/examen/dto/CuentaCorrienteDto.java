package coop.tecso.examen.dto;


import java.util.List;



public class CuentaCorrienteDto extends DTOIdentidad  {
	

	private static final long serialVersionUID = -1854383574061855612L;

	
	private Long id;
	
	private String numero;
	
	private String tipoMoneda;
	
	private float saldo=0;
	
	private List<MovimientoDto> movimientos;

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

	public List<MovimientoDto> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoDto> movimientos) {
		this.movimientos = movimientos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}
