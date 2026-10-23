# Pre-entrega JAVA – API de gestión de productos y pedidos

API REST desarrollada con **Java 21** y **Spring Boot** como pre-entrega del curso de Desarrollo Backend Java de TalentoTech. Permite administrar un catálogo de productos y sienta las bases para gestionar pedidos de compra.

El proyecto partió como una aplicación de consola y fue migrado a una API REST en capas (controller, service, model).

## Tecnologías

- Java 21
- Spring Boot 3.3.5 (`spring-boot-starter-web`)
- Maven
- JUnit 5 y Mockito (`spring-boot-starter-test`)

## Requisitos previos

- JDK 21 o superior
- Maven 3.9 o superior

## Cómo ejecutarlo

```bash
git clone https://github.com/parodiher/pre-entrega-JAVA.git
cd pre-entrega-JAVA
mvn spring-boot:run
```

La aplicación arranca desde la clase `CarritoApplication` y queda disponible en `http://localhost:8080`.

Para generar el `.jar`:

```bash
mvn clean package
java -jar target/PreEntrega-1.0-SNAPSHOT.jar
```

## Endpoints

### Productos (`/productos`)

| Método | Ruta              | Descripción                  | Respuesta                    |
| ------ | ----------------- | ---------------------------- | ---------------------------- |
| GET    | `/productos`      | Lista todos los productos    | `200 OK`                     |
| POST   | `/productos`      | Crea un producto             | `201 Created`                |
| PUT    | `/productos/{id}` | Actualiza un producto        | `200 OK`                     |
| DELETE | `/productos/{id}` | Elimina un producto          | `204 No Content`             |

Ejemplo de body para `POST` y `PUT`:

```json
{
  "nombre": "Teclado mecánico",
  "precio": 45000.0,
  "stock": 10,
  "categoria": "Periféricos"
}
```

Ejemplo con `curl`:

```bash
curl -X POST http://localhost:8080/productos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Teclado mecánico","precio":45000,"stock":10,"categoria":"Periféricos"}'
```

### Pedidos (`/pedidos`)

El controlador y el servicio de pedidos están creados, pero los endpoints todavía están en desarrollo.

## Modelo de datos

**Producto**

| Campo       | Tipo     | Notas                        |
| ----------- | -------- | ---------------------------- |
| `id`        | `int`    | Se genera automáticamente    |
| `nombre`    | `String` | Obligatorio                  |
| `precio`    | `Double` | No puede ser negativo        |
| `stock`     | `int`    | No puede ser negativo        |
| `categoria` | `String` | Obligatoria                  |

## Validaciones y manejo de errores

Los datos de los productos se validan en `Validador` antes de guardar o actualizar. Las excepciones personalizadas se traducen a respuestas HTTP en `GlobalExceptionHandler`:

| Excepción                    | Código HTTP       |
| ---------------------------- | ----------------- |
| `ProductoNotFoundException`  | `404 Not Found`   |
| `PedidoNotFoundException`    | `404 Not Found`   |
| `StockInsuficienteException` | `400 Bad Request` |

## Estructura del proyecto

```
src/main/java/org/talentotech
├── CarritoApplication.java   # Punto de entrada de Spring Boot
├── controller                # Endpoints REST (Producto, Pedido)
├── service                   # Lógica de negocio
├── model                     # Producto y Pedido
├── exceptions                # Excepciones propias y GlobalExceptionHandler
├── util                      # Validador e InputScanner
└── ui                        # Versión original de consola (comentada)
```

## Estado del proyecto

- Los datos se guardan en memoria: al reiniciar la aplicación se pierden.
- CRUD de productos implementado.
- Endpoints de pedidos en desarrollo.

## Autor

**Joaquín Parodi**
[GitHub](https://github.com/parodiher) · [LinkedIn](https://www.linkedin.com/in/joaquin-parodi/)
