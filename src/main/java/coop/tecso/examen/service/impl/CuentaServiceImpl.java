package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.service.CuentaService;
import coop.tecso.examen.utils.Utilities;



@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	
	@Override
	public CuentaCorrienteDto getCuentaById(Long id) {
		CuentaCorriente cuenta = cuentaRepository.getOne(id);
		CuentaCorrienteDto cuentaDto=new CuentaCorrienteDto();
		cuentaDto.setId(cuenta.getId());
		cuentaDto.setNumero(cuenta.getNumero());
		cuentaDto.setSaldo(cuenta.getSaldo());
		cuentaDto.setTipoMoneda(cuenta.getTipoMoneda());
		cuentaDto.setMovimientos(Utilities.toDTOList(cuenta.getMovimientos(), MovimientoDto.class));
		return cuentaDto;
	}

	@Override
	public CuentaCorriente guardar(CuentaCorrienteDto cuentaDto) {
		CuentaCorriente cuenta = new CuentaCorriente();
		cuenta.setNumero(cuentaDto.getNumero());
		cuenta.setSaldo(cuentaDto.getSaldo());
		cuenta.setTipoMoneda(cuentaDto.getTipoMoneda());
		//cuenta.setMovimientos(cuentaDto.getMovimientos());
		
		if(cuentaDto.getId()!=null)
			cuenta.setId(cuentaDto.getId());
		
		
		return cuentaRepository.save(cuenta);
	}

	@Override
	public void borrar(Long id) {
		cuentaRepository.deleteById(id);
	}

	

	

	

}
