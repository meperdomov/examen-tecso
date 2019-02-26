package coop.tecso.examen.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.model.Titular;
import coop.tecso.examen.repository.TitularRepository;

import coop.tecso.examen.service.TitularService;

@Service
public class TitularServiceImpl implements TitularService {

	@Autowired
	private TitularRepository titularRepository;

	
	@Override
	public TitularDto getTitularById(Long id) {
		Titular titular = titularRepository.getOne(id);
		TitularDto titularDto=new TitularDto();
		titularDto.setNombre(titular.getNombre());
		titularDto.setApellido(titular.getApellido());
		titularDto.setId(titular.getId());
		titularDto.setDni(titular.getDni());
		titularDto.setCuit(titular.getCuit());
		titularDto.setTipo(titular.getTipo());
		titularDto.setAnyoFundacion(titular.getAnyoFundacion());
		titularDto.setRazonSocial(titular.getRazonSocial());
		
		return titularDto;
	}

	@Override
	public Titular guardar(TitularDto titularDto) {
		Titular titular = new Titular();
		titular.setNombre(titularDto.getNombre());
		titular.setApellido(titularDto.getApellido());
		titular.setDni(titularDto.getDni());
		titular.setCuit(titularDto.getCuit() );
		titular.setRazonSocial(titularDto.getRazonSocial());
		titular.setAnyoFundacion(titularDto.getAnyoFundacion());
		titular.setTipo(titularDto.getTipo());
		if(titularDto.getId()!=null)
			titular.setId(titularDto.getId());
		
		
		return titularRepository.save(titular);
	}

	@Override
	public void borrar(Long id) {
		titularRepository.deleteById(id);
	}

	

	

	

}
