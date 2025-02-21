# API de Turismo - Spring Boot con MongoDB

Este proyecto es una API REST desarrollada con **Spring Boot** y **MongoDB** para gestionar recursos relacionados con el turismo, como hoteles, puntos de interés (POIs), eventos, vuelos y usuarios. La API incluye autenticación básica y control de roles (USER y ADMIN).

---

## Requisitos

- **Java 17** o superior.
- **MongoDB** (local o en la nube con MongoDB Atlas).
- **Maven** (para gestionar dependencias).
- **Postman** o **cURL** (para probar los endpoints).

---

## Configuración

### 1. Clonar el repositorio

```
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio
```
## 2. Configurar la base de datos

Crea una base de datos en MongoDB (local o en MongoDB Atlas).

Configura la conexión en el archivo application.properties:

```spring.data.mongodb.uri=mongodb+srv://<usuario>:<contraseña>@cluster0.mongodb.net/<nombre_db>?retryWrites=true&w=majority```

Reemplaza <usuario>, <contraseña> y <nombre_db> con tus credenciales.

## 3. Ejecutar la aplicación

``mvn spring-boot:run``

# Endpoints

## Autenticación
La API usa autenticación básica (Basic Auth). Debes incluir el nombre de usuario y la contraseña en el encabezado Authorization.

Ejemplo de encabezado:

``Authorization: Basic dXNlcjE6cGFzc3dvcmQxMjM=``

## Usuarios
Crear usuario (público):

POST /api/public/register

Body:

````
{
"username": "user1",
"email": "user1@example.com",
"password": "password123",
"role": "USER"
}
````

Obtener perfil de usuario (requiere autenticación como USER):

``GET /api/user/profile``

Panel de administrador (requiere autenticación como ADMIN):

``GET /api/admin``

Hoteles
Listar todos los hoteles (público):

``GET /api/public/hotels``

Crear un hotel (requiere autenticación como ADMIN):

``POST /api/admin/hotels``

Body:

````
{
"name": "Hotel Plaza",
"description": "Un hotel de lujo en el centro de Madrid.",
"location": "Madrid",
"stars": 5,
"pricePerNight": 250.0
}
````

## Puntos de Interés (POIs)

Listar todos los POIs (público):

``GET /api/public/pois``

Crear un POI (requiere autenticación como ADMIN):

``POST /api/admin/pois``

Body:

````
{
"name": "Museo del Prado",
"description": "Uno de los museos más importantes del mundo.",
"category": "Museo",
"latitude": 40.4138,
"longitude": -3.6921
}
````
## Eventos
Listar todos los eventos (público):

``GET /api/public/events``

Crear un evento (requiere autenticación como ADMIN):

``POST /api/admin/events``

Body:

````
{
"name": "Concierto de Rock",
"description": "Un concierto increíble con las mejores bandas de rock.",
"startTime": "2023-12-25T20:00:00",
"endTime": "2023-12-25T23:00:00",
"location": "Estadio Nacional",
"price": 50.0
}
````
## Vuelos
Listar todos los vuelos (público):

``GET /api/public/flights``

Crear un vuelo (requiere autenticación como ADMIN):

``POST /api/admin/flights``

Body:

````
{
"flightNumber": "AA123",
"departureAirport": "JFK",
"arrivalAirport": "LAX",
"departureTime": "2023-12-25T08:00:00",
"arrivalTime": "2023-12-25T11:00:00",
"price": 299.99
}
````
## Datos de Prueba
La aplicación incluye un DataLoader que carga datos iniciales en la base de datos al iniciar. Estos datos incluyen:

Usuarios:

````
Usuario normal: user1 (contraseña: password123, rol: USER).

Administrador: admin (contraseña: admin123, rol: ADMIN).
````
Hoteles, POIs, Eventos y Vuelos: 5 registros de cada uno.

## Ejemplos de Uso
1. Autenticarse como usuario normal
   ``````
   curl -u user1:password123 http://localhost:8080/api/user/profile
2. Autenticarse como administrador
   ````
   curl -u admin:admin123 http://localhost:8080/api/admin
3. Listar todos los hoteles
   ````
   curl http://localhost:8080/api/public/hotels
4. Crear un nuevo hotel (como administrador)
   ````
   curl -u admin:admin123 -X POST -H "Content-Type: application/json" -d '{
   "name": "Hotel Ritz",
   "description": "Un hotel emblemático en el centro de Madrid.",
   "location": "Madrid",
   "stars": 5,
   "pricePerNight": 300.0
   }' http://localhost:8080/api/admin/hotels
   ````
   
   ## Estructura del Proyecto
   ````
   src/main/java/com/villalta/turismoapi
   ├── config
   │   ├── DataLoader.java
   │   └── SecurityConfig.java
   ├── controller
   │   ├── HotelController.java
   │   ├── PoiController.java
   │   ├── EventController.java
   │   ├── FlightController.java
   │   └── UserController.java
   ├── model
   │   ├── hotel
   │   │   └── Hotel.java
   │   ├── poi
   │   │   └── PointOfInterest.java
   │   ├── event
   │   │   └── Event.java
   │   ├── flight
   │   │   └── Flight.java
   │   └── user
   │       └── User.java
   ├── repository
   │   ├── HotelRepository.java
   │   ├── PoiRepository.java
   │   ├── EventRepository.java
   │   ├── FlightRepository.java
   │   └── UserRepository.java
   ├── service
   │   ├── HotelService.java
   │   ├── PoiService.java
   │   ├── EventService.java
   │   ├── FlightService.java
   │   └── UserService.java
   └── TurismoApiApplication.java
   ````
