package coop.tecso.examen;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.model.Titular;
import coop.tecso.examen.repository.CuentaRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.repository.TitularRepository;

@SpringBootApplication
public class MainApplication {
	@Autowired
	private TitularRepository titularRepository;
	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private MovimientoRepository movimientoRepository;

	public static void main(final String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	Titular titular=new Titular();
	    	titular.setNombre("nombre");
	    	titular.setApellido("apellido");
	    	titular.setDni("dni");
	    	titular.setCuit("cuit");
	    	titular.setTipo("N");
	        titularRepository.save(titular);
	        //titularRepository.save(new Titular("Rambo"));
	        
	        CuentaCorriente cuenta=new CuentaCorriente();
	        cuenta.setNumero("123456");
	        cuenta.setSaldo(100000);
	        cuenta.setTipoMoneda("COP");
	        cuentaRepository.save(cuenta);
	        
	        CuentaCorriente cuenta1=new CuentaCorriente();
	        cuenta1.setNumero("654321");
	        cuenta1.setSaldo(200000);
	        cuenta1.setTipoMoneda("COP");
	        cuentaRepository.save(cuenta1);
	        
	        Movimiento movimiento1=new Movimiento();
	        movimiento1.setCuenta(cuenta);
	        movimiento1.setFecha(new Date());
	        movimiento1.setDescripcion("descripcion");
	        movimiento1.setTipoMovimiento("CREDITO");
	        movimiento1.setImporte(30000);
	        movimientoRepository.save(movimiento1);
	        
	        Movimiento movimiento2=new Movimiento();
	        movimiento2.setCuenta(cuenta);
	        movimiento2.setFecha(new Date());
	        movimiento2.setDescripcion("descripcion 2");
	        movimiento2.setTipoMovimiento("CREDITO");
	        movimiento2.setImporte(10000);
	        movimientoRepository.save(movimiento2);
	        
	        Movimiento movimiento3=new Movimiento();
	        movimiento3.setCuenta(cuenta1);
	        movimiento3.setFecha(new Date());
	        movimiento3.setDescripcion("descripcion 2");
	        movimiento3.setTipoMovimiento("DEBITO");
	        movimiento3.setImporte(20000);
	        movimientoRepository.save(movimiento3);
	        
	        
	    };
	    
	    }
	
	
}
