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



import coop.tecso.examen.dto.TitularDto;
import coop.tecso.examen.model.Titular;
import coop.tecso.examen.repository.TitularRepository;
import coop.tecso.examen.service.TitularService;

@RestController
@RequestMapping("/titular")
public class TitularController {

	@Autowired
	private TitularRepository titularRepository;
	
	@Autowired
	private TitularService titularService;
	
	// Get All Titulares
	@GetMapping("/findAll")
	public List<TitularDto> findAll() {
		
		List<TitularDto> result = new ArrayList<>();
		for (Titular entity : titularRepository.findAll()) {
			TitularDto dto = new TitularDto();
			dto.setId(entity.getId());
			if(entity.getNombre()!=null)
				dto.setNombre(entity.getNombre());
			if(entity.getApellido()!=null)
				dto.setApellido(entity.getApellido());
			if(entity.getAnyoFundacion()!=null)
				dto.setAnyoFundacion(entity.getAnyoFundacion());
			if(entity.getDni()!=null)
				dto.setDni(entity.getDni());
			dto.setCuit(entity.getCuit());
			dto.setTipo(entity.getTipo());
			result.add(dto);
		}
		
	    return result;
	}
	

	@PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody TitularDto titularDto) {
    	
    	if(titularDto!=null){
    		Titular titular=titularService.guardar(titularDto);
    		
    		return new ResponseEntity<Titular>(titular, HttpStatus.OK);
    	}
    	
    	return ResponseEntity.badRequest().body("Error de Creacion");
    
    }
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		titularService.borrar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
