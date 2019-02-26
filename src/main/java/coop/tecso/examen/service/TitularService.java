package coop.tecso.examen.service;

import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.model.Titular;


public interface TitularService {
	
	public TitularDto getTitularById(Long id);
	
	public Titular guardar(TitularDto titularDTO);
	

	public void borrar(Long id);
	
	

}
