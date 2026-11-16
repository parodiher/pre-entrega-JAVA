# API REST de gestión de productos – Proyecto final Backend Java

API REST desarrollada con **Java 21**, **Spring Boot** y **MySQL** como proyecto del curso de Desarrollo Backend Java con Spring Boot de TalentoTech. Permite administrar un catálogo de productos (crear, listar, consultar, actualizar y eliminar) con persistencia en base de datos mediante JPA/Hibernate.

El proyecto partió como una aplicación de consola y fue migrado a una API REST organizada en capas.

## Tecnologías

- Java 21
- Spring Boot 3.3.5 (Web, Data JPA, Validation)
- Hibernate / JPA
- MySQL 8
- Maven

## Requisitos previos

- JDK 21 o superior
- Maven 3.9 o superior
- MySQL 8 en ejecución (por defecto en `localhost:3306`)

## Configuración de la base de datos

1. Crear la base de datos:

```sql
CREATE DATABASE carrito_db;
```

2. Revisar la conexión en `src/main/resources/application.properties` y ajustar usuario y contraseña según tu instalación de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/carrito_db
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Con `ddl-auto=update`, Hibernate crea la tabla `producto` automáticamente la primera vez que se ejecuta la aplicación.

## Cómo ejecutarlo

```bash
git clone https://github.com/parodiher/pre-entrega-JAVA.git
cd pre-entrega-JAVA
mvn spring-boot:run
```

La aplicación arranca desde la clase `CarritoApplication` y queda disponible en `http://localhost:8080`.

Para generar el `.jar` y ejecutarlo:

```bash
mvn clean package
java -jar target/PreEntrega-1.0-SNAPSHOT.jar
```

## Endpoints

### Productos (`/productos`)

| Método | Ruta              | Descripción                    | Respuestas exitosas | Errores posibles               |
| ------ | ----------------- | ------------------------------ | ------------------- | ------------------------------ |
| GET    | `/productos`      | Lista todos los productos      | `200 OK`            | –                              |
| GET    | `/productos/{id}` | Obtiene un producto por id     | `200 OK`            | `404 Not Found`                |
| POST   | `/productos`      | Crea un producto               | `201 Created`       | `400 Bad Request`              |
| PUT    | `/productos/{id}` | Actualiza un producto completo | `200 OK`            | `400 Bad Request`, `404 Not Found` |
| DELETE | `/productos/{id}` | Elimina un producto            | `204 No Content`    | `404 Not Found`                |

Ejemplo de body para `POST` y `PUT`:

```json
{
  "nombre": "Teclado mecánico",
  "precio": 45000.0,
  "stock": 10,
  "categoria": "Periféricos"
}
```

Ejemplos con `curl`:

```bash
# Crear
curl -X POST http://localhost:8080/productos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Teclado mecánico","precio":45000,"stock":10,"categoria":"Periféricos"}'

# Listar
curl http://localhost:8080/productos

# Obtener por id
curl http://localhost:8080/productos/1

# Actualizar
curl -X PUT http://localhost:8080/productos/1 \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Teclado mecánico RGB","precio":52000,"stock":8,"categoria":"Periféricos"}'

# Eliminar
curl -X DELETE http://localhost:8080/productos/1
```

## Modelo de datos

**Producto** (tabla `producto`)

| Campo       | Tipo     | Reglas de validación                 |
| ----------- | -------- | ------------------------------------ |
| `id`        | `int`    | Se genera automáticamente            |
| `nombre`    | `String` | Obligatorio, no puede estar vacío    |
| `precio`    | `Double` | Obligatorio, mayor o igual a 0       |
| `stock`     | `int`    | Mayor o igual a 0                    |
| `categoria` | `String` | Obligatoria, no puede estar vacía    |

Si los datos no cumplen las reglas, la API responde `400 Bad Request` con un mensaje que indica el problema.

## Manejo de errores

Las excepciones propias se manejan de forma centralizada en `GlobalExceptionHandler` (`@RestControllerAdvice`):

| Situación                                  | Código HTTP       |
| ------------------------------------------ | ----------------- |
| Producto inexistente (`ProductoNotFoundException`) | `404 Not Found`   |
| Pedido inexistente (`PedidoNotFoundException`)     | `404 Not Found`   |
| Stock insuficiente (`StockInsuficienteException`)  | `400 Bad Request` |
| Datos inválidos en el body                 | `400 Bad Request` |

## Estructura del proyecto

```
src/main/java/org/talentotech
├── CarritoApplication.java   # Punto de entrada de Spring Boot
├── controller                # Endpoints REST (ProductoController, PedidoController)
├── service                   # Lógica de negocio
├── repository                # Acceso a datos con Spring Data JPA
├── model                     # Entidades (Producto, Pedido, ItemPedido)
├── exceptions                # Excepciones propias y GlobalExceptionHandler
└── util                      # Utilidades
```

## Estado del proyecto

- CRUD completo de **productos** persistido en MySQL con JPA.
- Los **pedidos** (`/pedidos`) son una funcionalidad adicional todavía en desarrollo: se guardan en memoria y solo está disponible `GET /pedidos`. No forman parte del alcance mínimo del proyecto final.

## Autor

**Joaquín Parodi**
[GitHub](https://github.com/parodiher) · [LinkedIn](https://www.linkedin.com/in/joaquin-parodi/)