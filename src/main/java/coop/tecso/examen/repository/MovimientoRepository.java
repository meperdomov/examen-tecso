package coop.tecso.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import coop.tecso.examen.model.Movimiento;


public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

	@Query(value = "SELECT * FROM movimiento mo WHERE mo.cuenta_id = :cuentaId order by fecha desc", nativeQuery = true)
	public List<Movimiento> getMovimientoByCuenta(@Param("cuentaId") Long cuentaId);
}
