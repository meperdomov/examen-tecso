Repositorio Github

Ejercicio 1

Realizando POST guardar :
	curl -X POST -H 'Content-Type: application/json' -H 'Accept: application/json' 
	-d '{"mensaje":"mensaje de prueba"}' localhost:8080/api/echo
	
	Obtener suma de numeros:
	curl -X GET "http://localhost:8080/api/math/sum?valores=1.1&valores=2.22&valores=3.33"
	
	Obtener todos los paises:
	curl -X GET "http://localhost:8080/api/country/findAll"

