package coop.tecso.examen.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import coop.tecso.examen.dto.CuentaCorrienteDto;
import coop.tecso.examen.dto.MovimientoDto;
import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.service.CuentaService;
import coop.tecso.examen.utils.Utilities;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private CuentaService cuentaService;
	
	// Get All Cuentas
	@GetMapping("/listar")
	public List<CuentaCorrienteDto> listar() {
		
		List<CuentaCorrienteDto> result = new ArrayList<>();
		for (CuentaCorriente entity : cuentaRepository.findAll()) {
			CuentaCorrienteDto dto = new CuentaCorrienteDto();
			dto.setId(entity.getId());
			dto.setNumero(entity.getNumero());
			dto.setId(entity.getId());
			dto.setMovimientos(Utilities.toDTOList(entity.getMovimientos(), MovimientoDto.class));
			dto.setTipoMoneda(entity.getTipoMoneda());
			dto.setSaldo(entity.getSaldo());
			result.add(dto);
		}
		
	    return result;
	}
	

	@PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody CuentaCorrienteDto cuentaDto) {
    	
    	if(cuentaDto!=null){
    		CuentaCorriente cuenta=cuentaService.guardar(cuentaDto);
    		
    		return new ResponseEntity<CuentaCorriente>(cuenta, HttpStatus.OK);
    	}
    	
    	return ResponseEntity.badRequest().body("Error de Creacion");
    
    }
	
	@RequestMapping(value = "borrar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		CuentaCorrienteDto cuenta=new CuentaCorrienteDto();
		cuenta=cuentaService.getCuentaById(id);
		if(cuenta.getMovimientos()==null || cuenta.getMovimientos().isEmpty()){
			cuentaService.borrar(id);
			return new ResponseEntity<>("Eliminado correctamente", HttpStatus.OK);
		}
		return new ResponseEntity<>("No se puede eliminar porque la cuenta tiene movimientos asociados", HttpStatus.BAD_REQUEST);
		
	}
	
}
