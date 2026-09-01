# LogiTrack

Backend de un sistema de gestión de inventario desarrollado con **Java y Spring Boot**.

El proyecto proporciona una API REST para administrar **empleados, bodegas, productos y usuarios**, además de implementar autenticación mediante **JWT** y persistencia de datos utilizando **MySQL**.

---

## 🚀 Características

* 🔐 Autenticación mediante JWT.
* 👤 Gestión de usuarios.
* 👨‍💼 Gestión de empleados.
* 🏢 Gestión de bodegas.
* 📦 Gestión de productos.
* 🔎 Búsqueda de empleados por diferentes criterios.
* 🔎 Búsqueda de productos por ID y nombre.
* 🔎 Búsqueda de bodegas por ID.
* ✏️ Actualización de registros.
* ➕ Creación de registros.
* 🗑️ Eliminación de registros.
* ✅ Validación de datos mediante Jakarta Validation.
* 🔒 Protección de endpoints mediante Spring Security.
* 📖 Documentación de la API mediante Swagger/OpenAPI.

---

## 🛠️ Tecnologías utilizadas

| Tecnología             | Uso                            |
| ---------------------- | ------------------------------ |
| **Java**               | Lenguaje principal             |
| **Spring Boot**        | Framework backend              |
| **Spring Web**         | Creación de la API REST        |
| **Spring Data JPA**    | Persistencia de datos          |
| **Hibernate**          | ORM                            |
| **Spring Security**    | Seguridad y autenticación      |
| **JWT**                | Autenticación mediante tokens  |
| **MySQL**              | Base de datos                  |
| **Maven**              | Gestión de dependencias        |
| **Lombok**             | Reducción de código repetitivo |
| **Jakarta Validation** | Validación de datos            |
| **Swagger / OpenAPI**  | Documentación de la API        |

---

## 📁 Estructura del proyecto

```text
LogiTrack/
│
├── .mvn/
│   └── wrapper/
│
├── SQL/
│   └── Scripts de la base de datos
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/LogiTrack/
│       │       ├── Config/
│       │       ├── Controller/
│       │       ├── DTO/
│       │       │   ├── Request/
│       │       │   └── Response/
│       │       ├── Exception/
│       │       ├── Filter/
│       │       ├── Mapper/
│       │       ├── Model/
│       │       ├── Repository/
│       │       └── Service/
│       │
│       └── resources/
│
├── .gitignore
├── pom.xml
├── mvnw
└── mvnw.cmd
```

El repositorio incluye el código fuente dentro de `src`, los scripts SQL dentro de `SQL` y el Maven Wrapper para facilitar la ejecución del proyecto.

---

# 🗄️ Base de datos

El proyecto utiliza **MySQL** para almacenar la información del sistema.

La base de datos utilizada es:

```sql
CREATE DATABASE LogiTrack;
```

Los scripts necesarios para la creación y configuración de la base de datos se encuentran en:

```text
SQL/
```

Después de crear la base de datos, se deben ejecutar los scripts correspondientes.

---

# ⚙️ Configuración

La conexión con MySQL se configura mediante el archivo:

```text
src/main/resources/application.properties
```

Ejemplo:

```properties
spring.application.name=LogiTrack

spring.datasource.url=jdbc:mysql://localhost:3306/LogiTrack
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
```

Debes reemplazar:

```text
TU_USUARIO
TU_CONTRASEÑA
```

por las credenciales de tu instalación de MySQL.

> ⚠️ **Importante:** no se recomienda subir credenciales reales al repositorio. Para un entorno de producción se deben utilizar variables de entorno o un sistema de configuración seguro.

---

# 📋 Requisitos

Antes de ejecutar el proyecto necesitas tener instalado:

* **Java 17 o superior**
* **MySQL**
* **Git**

No es necesario instalar Maven si utilizas el Maven Wrapper incluido en el proyecto.

---

# ▶️ Instalación

Clona el repositorio:

```bash
git clone https://github.com/SantiagoRuedaGarciaPer/LogiTrack.git
```

Entra al proyecto:

```bash
cd LogiTrack
```

Configura la conexión de MySQL en:

```text
src/main/resources/application.properties
```

Después ejecuta el proyecto.

### Linux / macOS

```bash
./mvnw spring-boot:run
```

### Windows

```bash
mvnw.cmd spring-boot:run
```

También puedes ejecutar el proyecto directamente desde IntelliJ IDEA, Eclipse o Spring Tool Suite.

---

# 🔐 Autenticación

LogiTrack utiliza **JWT (JSON Web Token)** para proteger los endpoints de la API.

Para iniciar sesión:

```http
POST /LogiTrack/api/auth/login
```

Body:

```json
{
    "usuario": "Kame",
    "contrasenia": "contraseña"
}
```

Si las credenciales son correctas, la API devuelve:

```json
{
    "token": "TOKEN_JWT"
}
```

El token debe enviarse posteriormente en las peticiones protegidas mediante el header:

```http
Authorization: Bearer TOKEN_JWT
```

---

# 📌 Endpoints principales

## 🔑 Autenticación

```http
POST /LogiTrack/api/auth/login
```

---

## 👨‍💼 Empleados

### Listar empleados

```http
GET /LogiTrack/api/empleados
```

### Buscar por ID

```http
GET /LogiTrack/api/empleados/{id}
```

### Buscar por nombre

```http
GET /LogiTrack/api/empleados/nombre/{nombre}
```

### Buscar por cargo

```http
GET /LogiTrack/api/empleados/cargo/{cargo}
```

### Buscar por documento

```http
GET /LogiTrack/api/empleados/documento/{documento}
```

### Crear empleado

```http
POST /LogiTrack/api/empleados
```

Ejemplo:

```json
{
    "nombre": "Santiago Rueda Garcia",
    "email": "santirueda0917@gmail.com",
    "tipoDocumento": "Cedula",
    "documento": "1099744305",
    "cargo": "Encargado",
    "bodegaId": 1
}
```

### Actualizar empleado

```http
PUT /LogiTrack/api/empleados/{id}
```

### Eliminar empleado

```http
DELETE /LogiTrack/api/empleados/{id}
```

---

# 🏢 Bodegas

### Buscar por ID

```http
GET /LogiTrack/api/bodegas/{id}
```

### Crear bodega

```http
POST /LogiTrack/api/bodegas
```

Body:

```json
{
    "nombre": "Bodega principal",
    "ubicacion": "Calle 45 #23 -32",
    "capacidad": 100.0
}
```

### Actualizar bodega

```http
PUT /LogiTrack/api/bodegas/{id}
```

### Eliminar bodega

```http
DELETE /LogiTrack/api/bodegas/{id}
```

---

# 📦 Productos

### Buscar por ID

```http
GET /LogiTrack/api/productos/{id}
```

### Buscar por nombre

```http
GET /LogiTrack/api/productos/nombre/{nombre}
```

### Crear producto

```http
POST /LogiTrack/api/productos
```

Body:

```json
{
    "nombre": "Televisor",
    "descripcion": "Televisor para el inventario de la empresa",
    "stock": 40,
    "precioCompra": 2500.0,
    "precioVenta": 30000.0,
    "bodega": 1
}
```

### Actualizar producto

```http
PUT /LogiTrack/api/productos/{id}
```

### Eliminar producto

```http
DELETE /LogiTrack/api/productos/{id}
```

---

# 👤 Usuarios

El sistema también permite consultar información de los usuarios registrados.

La información del usuario está relacionada con un empleado y su respectiva bodega.

Un usuario puede contener información como:

```json
{
    "id": 2,
    "empleado": {
        "id": 2,
        "nombre": "Santiago Rueda Garcia",
        "email": "santirueda0917@gmail.com",
        "tipoDocumento": "Cedula",
        "documento": "123456789",
        "cargo": "Encargado"
    },
    "usuario": "Kame"
}
```

---

# 📖 Swagger / OpenAPI

El proyecto cuenta con documentación de la API mediante **Swagger/OpenAPI**.

Una vez iniciado el servidor, se puede acceder a la interfaz de documentación de la API mediante la ruta configurada por Springdoc.

Esto permite consultar los endpoints disponibles y realizar pruebas directamente desde el navegador.

---

# 🔄 Arquitectura

El proyecto utiliza una arquitectura por capas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Además, se utilizan DTOs para separar los datos recibidos y enviados por la API de las entidades utilizadas internamente.

```text
Request DTO
     ↓
 Controller
     ↓
 Service
     ↓
 Mapper
     ↓
 Entity
     ↓
 Repository
     ↓
 MySQL
```

Para las respuestas:

```text
MySQL
   ↓
Repository
   ↓
Service
   ↓
Mapper
   ↓
Response DTO
   ↓
Controller
   ↓
JSON
```

---

# 🔒 Seguridad

Los endpoints protegidos requieren un token JWT válido.

El sistema utiliza:

* Spring Security
* JWT
* Filtros de autenticación
* CORS
* Sesiones Stateless

La autenticación no utiliza sesiones tradicionales del servidor; cada petición protegida debe proporcionar el token correspondiente.

---

# 🌐 Frontend

El backend está diseñado para trabajar junto con el frontend web de LogiTrack.

Repositorio del frontend:

**LogiTrackWeb**

```text
https://github.com/SantiagoRuedaGarciaPer/LogiTrackWeb
```

El frontend consume los endpoints REST proporcionados por este proyecto.

---

# 👨‍💻 Autor

**Santiago Rueda Garcia**

Proyecto desarrollado como sistema de gestión de inventario utilizando **Java, Spring Boot y MySQL**.

---

## 📄 Licencia

Este proyecto fue desarrollado con fines educativos.

```

Este ya está listo para **reemplazar el contenido de `README.md` del repositorio `LogiTrack`**.
```
