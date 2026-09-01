# LogiTrack

Sistema de gestión de inventario desarrollado con **Java y Spring Boot**, diseñado para administrar empleados, bodegas y productos mediante una API REST.

El proyecto implementa una arquitectura basada en capas, utilizando Spring Boot, Spring Data JPA, MySQL y autenticación mediante JWT.

## 🚀 Características

El backend permite gestionar:

* 🔐 Autenticación de usuarios mediante JWT.
* 👤 Gestión de empleados.
* 🏢 Gestión de bodegas.
* 📦 Gestión de productos.
* 🔎 Búsqueda de empleados por diferentes criterios.
* 🔎 Búsqueda de productos por ID y nombre.
* 🔎 Búsqueda de bodegas por ID.
* ✏️ Actualización de registros.
* 🗑️ Eliminación de registros.
* 🗄️ Persistencia de información utilizando MySQL.
* 📋 Validación de datos mediante Jakarta Validation.
* 📖 Documentación de la API mediante Swagger/OpenAPI.

## 🛠️ Tecnologías utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* JWT
* MySQL
* Maven
* Hibernate
* Lombok
* Jakarta Validation
* Swagger / OpenAPI

## 📁 Estructura del proyecto

```text
LogiTrack/
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
├── SQL/
├── pom.xml
├── mvnw
└── mvnw.cmd
```

## 🗄️ Base de datos

El proyecto utiliza **MySQL** como sistema gestor de base de datos.

Crear una base de datos llamada:

```sql
CREATE DATABASE LogiTrack;
```

El proyecto incluye los archivos SQL necesarios dentro de la carpeta:

```text
SQL/
```

Ejecuta los scripts SQL para crear las tablas y estructuras necesarias.

## ⚙️ Configuración

La conexión con MySQL se configura en:

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

Reemplaza:

```text
TU_USUARIO
TU_CONTRASEÑA
```

por las credenciales correspondientes a tu instalación de MySQL.

> **Importante:** no subas contraseñas reales al repositorio. Se recomienda utilizar variables de entorno o un archivo de configuración local.

## ▶️ Ejecución

### Requisitos

Antes de ejecutar el proyecto debes tener instalado:

* Java 17 o superior
* MySQL
* Maven (opcional, ya que el proyecto incluye Maven Wrapper)

### Ejecutar con Maven

Linux / macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

También puedes ejecutar el proyecto desde IntelliJ IDEA, Eclipse o Spring Tool Suite ejecutando la clase principal de Spring Boot.

## 🔐 Autenticación

El sistema utiliza autenticación basada en **JSON Web Token (JWT)**.

Para iniciar sesión se realiza una petición:

```http
POST /LogiTrack/api/auth/login
```

Body:

```json
{
    "usuario": "usuario",
    "contrasenia": "contraseña"
}
```

La API devuelve:

```json
{
    "token": "TOKEN_JWT"
}
```

El token debe enviarse posteriormente en las peticiones protegidas mediante:

```http
Authorization: Bearer TOKEN_JWT
```

## 📌 Principales endpoints

### Autenticación

```http
POST /LogiTrack/api/auth/login
```

### Empleados

```http
GET    /LogiTrack/api/empleados
GET    /LogiTrack/api/empleados/{id}
GET    /LogiTrack/api/empleados/nombre/{nombre}
GET    /LogiTrack/api/empleados/cargo/{cargo}
GET    /LogiTrack/api/empleados/documento/{documento}

POST   /LogiTrack/api/empleados
PUT    /LogiTrack/api/empleados/{id}
DELETE /LogiTrack/api/empleados/{id}
```

### Bodegas

```http
GET    /LogiTrack/api/bodegas/{id}
POST   /LogiTrack/api/bodegas
PUT    /LogiTrack/api/bodegas/{id}
DELETE /LogiTrack/api/bodegas/{id}
```

### Productos

```http
GET    /LogiTrack/api/productos/{id}
GET    /LogiTrack/api/productos/nombre/{nombre}

POST   /LogiTrack/api/productos
PUT    /LogiTrack/api/productos/{id}
DELETE /LogiTrack/api/productos/{id}
```

## 📖 Swagger

La API cuenta con documentación mediante Swagger/OpenAPI.

Una vez iniciado el servidor, puedes acceder a la documentación desde la interfaz de Swagger configurada en el proyecto.

## 🔗 Repositorio

[LogiTrack Backend](https://github.com/SantiagoRuedaGarciaPer/LogiTrack)

## 👨‍💻 Autor

**Santiago Rueda Garcia**

Proyecto desarrollado como sistema de gestión de inventario utilizando Spring Boot y MySQL.

````

## README para `LogiTrackWeb`

Y este sería el README del frontend:

# LogiTrack Web

Frontend web para el sistema de gestión de inventario **LogiTrack**.

La aplicación proporciona una interfaz sencilla para interactuar con la API REST desarrollada en Spring Boot, permitiendo administrar empleados, bodegas y productos.

## 🚀 Características

El frontend permite:

- 🔐 Inicio de sesión.
- 🔑 Autenticación mediante JWT.
- 🏠 Página principal del sistema.
- 👤 Visualización de información del usuario.
- 👨‍💼 Gestión de empleados.
- 🏢 Gestión de bodegas.
- 📦 Gestión de productos.
- 🔎 Búsqueda de registros.
- ✏️ Actualización de información.
- ➕ Creación de registros.
- 🗑️ Eliminación de registros.
- 🔒 Cierre de sesión.

## 🛠️ Tecnologías utilizadas

- HTML5
- CSS3
- JavaScript
- Fetch API
- LocalStorage
- REST API
- JWT

El proyecto no utiliza frameworks frontend, por lo que la interfaz está construida utilizando HTML, CSS y JavaScript puro.

## 📁 Estructura del proyecto

```text
LogiTrackWeb/
│
├── css/
│   ├── login.css
│   ├── home.css
│   ├── empleados.css
│   ├── bodegas.css
│   └── productos.css
│
├── html/
│   ├── home.html
│   ├── empleados.html
│   ├── bodegas.html
│   └── productos.html
│
├── js/
│   ├── login.js
│   ├── home.js
│   ├── empleados.js
│   ├── bodegas.js
│   └── productos.js
│
└── index.html
````

## 🔗 Backend

El frontend se comunica con el backend de LogiTrack mediante peticiones HTTP.

La URL utilizada durante el desarrollo es:

```text
http://localhost:8080/LogiTrack/api
```

Por ejemplo:

```text
http://localhost:8080/LogiTrack/api/empleados
```

El backend correspondiente se encuentra en:

[LogiTrack Backend](https://github.com/SantiagoRuedaGarciaPer/LogiTrack)

## 🔐 Inicio de sesión

La aplicación comienza en:

```text
index.html
```

El usuario proporciona:

```json
{
    "usuario": "usuario",
    "contrasenia": "contraseña"
}
```

El frontend realiza una petición al endpoint:

```http
POST /LogiTrack/api/auth/login
```

La API devuelve un JWT:

```json
{
    "token": "TOKEN_JWT"
}
```

El token se almacena en `localStorage` y posteriormente se utiliza para realizar peticiones autenticadas:

```http
Authorization: Bearer TOKEN_JWT
```

## 🏠 Página principal

Después de iniciar sesión, el usuario accede al Home.

Desde esta página puede acceder a:

* Empleados
* Bodegas
* Productos

También puede:

* Consultar su información personal.
* Cerrar sesión.

## 👨‍💼 Gestión de empleados

La sección de empleados permite:

* Listar todos los empleados.
* Buscar por ID.
* Buscar por nombre.
* Buscar por cargo.
* Buscar por documento.
* Crear empleados.
* Actualizar empleados.
* Eliminar empleados.

## 🏢 Gestión de bodegas

La sección de bodegas permite:

* Buscar una bodega por ID.
* Crear bodegas.
* Actualizar bodegas.
* Eliminar bodegas.

## 📦 Gestión de productos

La sección de productos permite:

* Buscar productos por ID.
* Buscar productos por nombre.
* Crear productos.
* Actualizar productos.
* Eliminar productos.

## ▶️ Ejecución

### Requisitos

Necesitas:

* Un navegador web moderno.
* El backend de LogiTrack ejecutándose.
* Un servidor local para servir los archivos HTML.

Se recomienda utilizar **Live Server** en Visual Studio Code.

### Ejecutar con Live Server

1. Clona el repositorio:

```bash
git clone https://github.com/SantiagoRuedaGarciaPer/LogiTrackWeb.git
```

2. Abre la carpeta en Visual Studio Code.

3. Instala la extensión **Live Server**.

4. Abre `index.html`.

5. Selecciona **Open with Live Server**.

El frontend normalmente estará disponible en una dirección similar a:

```text
http://127.0.0.1:5500
```

## ⚠️ Requisitos del backend

Antes de utilizar el frontend, asegúrate de que el backend esté ejecutándose en:

```text
http://localhost:8080
```

Además, el backend debe tener configurado CORS para permitir las peticiones provenientes del servidor donde se ejecuta el frontend.

## 🔄 Comunicación Frontend - Backend

La comunicación se realiza utilizando `fetch()`.

Ejemplo:

```javascript
const response = await fetch(
    "http://localhost:8080/LogiTrack/api/empleados",
    {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    }
);
```

## 🔒 Manejo de sesión

El JWT se almacena temporalmente en:

```javascript
localStorage
```

Cuando el usuario cierra sesión, el token es eliminado:

```javascript
localStorage.removeItem("token");
```

Si el usuario intenta acceder a una página protegida sin un token válido almacenado, es redirigido al inicio de sesión.

## 📌 Proyecto relacionado

Backend:

[LogiTrack](https://github.com/SantiagoRuedaGarciaPer/LogiTrack)

Frontend:

[LogiTrackWeb](https://github.com/SantiagoRuedaGarciaPer/LogiTrackWeb)

## 👨‍💻 Autor

**Santiago Rueda Garcia**

Frontend desarrollado como interfaz web para el sistema de gestión de inventario LogiTrack.

```

Estos dos README quedan separados pero **se complementan**: el del backend documenta la API y configuración de Spring Boot/MySQL, mientras que el del frontend explica cómo levantar la interfaz y conectarla con la API. Además, los dos repositorios actualmente están públicos y el backend contiene `pom.xml`, `src` y `SQL`, mientras que el frontend está organizado en `css`, `html`, `js` e `index.html`.

Si quieres que se vean **más profesionales para presentarlos en GitHub**, también puedo hacerte una segunda versión con **badges, tabla de contenidos, capturas, arquitectura del sistema y diagrama de funcionamiento**.
```
