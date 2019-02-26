package coop.tecso.examen.service;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.model.CuentaCorriente;



public interface CuentaService {
	
	public CuentaCorrienteDto getCuentaById(Long id);
	
	public CuentaCorriente guardar(CuentaCorrienteDto titularDTO);
	

	public void borrar(Long id);
	
	

}
