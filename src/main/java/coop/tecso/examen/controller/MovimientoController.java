package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.service.CuentaService;
import coop.tecso.examen.service.MovimientoService;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private MovimientoRepository movimientoRepository;
	
	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private MovimientoService movimientoService;
	
	
	
	// Get movimiento por cuenta
	@RequestMapping(value = "{idCuenta}", method = RequestMethod.GET)
	public List<MovimientoDto> listarMovimientosPorCuenta(@PathVariable("idCuenta") long idCuenta) {
		
		List<MovimientoDto> result = new ArrayList<>();
		result= movimientoService.getMovimientoByCuentaId(idCuenta);
		
	    return result;
	}
	

	@PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody MovimientoDto movimientoDto) {
    	
    	if(movimientoDto!=null){
    		
    		CuentaCorrienteDto cuentaDto=new CuentaCorrienteDto();
    		cuentaDto=cuentaService.getCuentaById(movimientoDto.getCuenta_id());
    		if(cuentaDto.getTipoMoneda().equals("COP")){
    			if(movimientoDto.getTipoMovimiento().equals("DEBITO")){
    				float descubierto=cuentaDto.getSaldo()-movimientoDto.getImporte();
    				if(descubierto<=-1000){
    					return ResponseEntity.badRequest().body("Error de Creacion");
    				}
    			}
    			
    		}
    		if(cuentaDto.getTipoMoneda().equals("USD")){
    			if(movimientoDto.getTipoMovimiento().equals("DEBITO")){
    				float descubierto=cuentaDto.getSaldo()-movimientoDto.getImporte();
    				if(descubierto<=-300){
    					return ResponseEntity.badRequest().body("Error de Creacion");
    				}
    			}
    			
    		}
    		if(cuentaDto.getTipoMoneda().equals("E")){
    			if(movimientoDto.getTipoMovimiento().equals("DEBITO")){
    				float descubierto=cuentaDto.getSaldo()-movimientoDto.getImporte();
    				if(descubierto<=-150){
    					return ResponseEntity.badRequest().body("Error de Creacion");
    				}
    			}
    			
    		}
    		movimientoDto.setFecha(new Date());
    		Movimiento movimiento=movimientoService.guardar(movimientoDto);
    		if(movimiento.getTipoMovimiento().equals("CREDITO")){
    			
    			cuentaDto.setSaldo(cuentaDto.getSaldo()+movimiento.getImporte());
    			cuentaService.guardar(cuentaDto);
    		}
    		if(movimiento.getTipoMovimiento().equals("DEBITO")){
    			cuentaDto=cuentaService.getCuentaById(movimientoDto.getCuenta_id());
    			cuentaDto.setSaldo(cuentaDto.getSaldo()-movimiento.getImporte());
    			cuentaService.guardar(cuentaDto);
    		}
    		return new ResponseEntity<Movimiento>(movimiento, HttpStatus.OK);
    	}
    	
    	return ResponseEntity.badRequest().body("Error de Creacion");
    
    }
	
	
}
