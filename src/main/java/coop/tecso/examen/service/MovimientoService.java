package coop.tecso.examen.service;

import java.util.List;

import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.Movimiento;

public interface MovimientoService {
	
	public List<MovimientoDto> getMovimientoByCuentaId(Long cuentaId);
	
	public Movimiento guardar(MovimientoDto movimientoDTO);
	

	
	
	

}
