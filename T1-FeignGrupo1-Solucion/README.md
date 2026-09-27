# T1 Feign Grupo 1

Solucion de las tres preguntas de Feign Client de la evaluacion de Desarrollo de Aplicaciones Web II. El proyecto respeta las versiones exigidas en el enunciado:

- Spring Boot 4.1.1
- Spring Cloud 2025.1.3
- Java 25

No se implemento la seccion de RabbitMQ porque la solicitud se limita a las tres preguntas de Feign Client.

## Estructura de la solucion

Cada pregunta cuenta con su DTO, cliente Feign y servicio de filtrado. Tambien se incluye un controlador para ejecutar y comprobar las tres soluciones:

| Pregunta | API externa | Endpoint local | Filtro |
|---|---|---|---|
| 1 | `GET https://jsonplaceholder.typicode.com/users` | `GET /api/feign/users` | `userId` par e `id` impar |
| 2 | `GET https://fakestoreapi.com/products` | `GET /api/feign/products` | precio mayor a 50.0 y categoria `electronics` |
| 3 | `GET https://rickandmortyapi.com/api/character` | `GET /api/feign/characters` | estado `Alive` y especie `Human`, solo primera pagina |

## Ejecucion

Se necesita JDK 25 y Maven 3.9 o superior.

```powershell
mvn clean test
mvn spring-boot:run
```

Luego se pueden probar los endpoints:

```powershell
Invoke-RestMethod http://localhost:8080/api/feign/users
Invoke-RestMethod http://localhost:8080/api/feign/products
Invoke-RestMethod http://localhost:8080/api/feign/characters
```

## Observacion sobre la pregunta 1

La respuesta real de `GET /users` de JSONPlaceholder no contiene el atributo `userId`; contiene `id`, `name`, `username`, `email`, `address`, `phone`, `website` y `company`. Por eso, al aplicar literalmente el filtro solicitado, la lista real queda vacia. La clase incluye `userId` y el servicio implementa exactamente las dos condiciones, con control de valores nulos, para que funcione si la API o los datos de evaluacion incluyen ese atributo. No se reemplazo `/users` por otra API ni se invento un valor para `userId`.

## Pruebas automatizadas

Los tres servicios tienen pruebas unitarias que verifican que se apliquen conjuntamente todos los filtros pedidos, incluyendo los limites de precio y los valores nulos.
