Repositorio Github

https://github.com/meperdomov/examen-tecso.git

Ejercicio 1

Listar titulares

curl -X GET "http://localhost:8080/api/titular/listar"

guardar o editar titular. Para editar el objeto json deben llevar de manera explicita el id.

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' 
	-d '{"nombre":"nombre","apellido":"apellido","dni":"dni","cuit":"cuit","razonSocial":null,"anyoFundacion":null,"tipo":"N"}' localhost:8080/api/titular/guardar

curl -X DELETE "http://localhost:8080/api/titular/{idTitular}"


Ejercicio 2

1. *crear cuenta*

curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' 
	-d '{"id":1,"numero":"123456","tipoMoneda":"COP","saldo":100000.0}' localhost:8080/api/cuenta/guardar

2. *eliminar cuenta*

curl -X DELETE "http://localhost:8080/api/cuenta/{idCuenta}"

3. *listar cuentas*

curl -X GET "http://localhost:8080/api/cuenta/listar"

4. *agregar movimiento*
curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' 
	-d '{"id":3,"tipoMovimiento":"DEBITO","descripcion":"descripcion 2","fecha":"2019-02-26T03:33:23.637+0000","importe":20000.0,"cuenta_id":2}' localhost:8080/api/movimientos/guardar

5. *listar movimientos x cuenta* (ordenados de forma decreciente, por fecha)
curl -X GET "http://localhost:8080/api/movimientos/{idCuenta}"
