package coop.tecso.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.MovimientoDto;

import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.MovimientoService;
import coop.tecso.examen.utils.Utilities;


@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	private MovimientoRepository movimientoRepository;

	
	@Override
	public List<MovimientoDto> getMovimientoByCuentaId(Long cuentaId) {
		List<Movimiento> movimientos = movimientoRepository.getMovimientoByCuenta(cuentaId);
		return Utilities.toDTOList(movimientos, MovimientoDto.class);
	}

	@Override
	public Movimiento guardar(MovimientoDto movimientoDTO) {
		Movimiento movimiento = new Movimiento();
		Utilities.toEntity(movimiento, movimientoDTO);
		
		
		return movimientoRepository.save(movimiento);
	}

	

	

	

}
