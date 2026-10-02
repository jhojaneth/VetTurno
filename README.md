# VetTurno

## Historia
Doña Marta abrió Veterinaria Huellitas hace seis años en un barrio donde conoce por su nombre a muchas familias y a sus
mascotas. Ella atiende la clínica con el doctor Andrés y con Paula, quien recibe llamadas, responde mensajes y organiza las citas.
La agenda todavía vive entre un cuaderno y conversaciones de WhatsApp. Cuando el día está ocupado, Paula puede reservar dos
consultas para el mismo veterinario a la misma hora, escribir mal el nombre de una mascota o perder el teléfono de su
responsable. El problema no es falta de cuidado: es que la información está dispersa.
## Alcance
VetTurno es una API REST para gestionar la información básica de una veterinaria. 
El sistema permite registrar usuarios, propietarios, mascotas, veterinarios y citas, 
además de consultar la información mediante endpoints protegidos.

### Funcionalidades incluidas

- Registro e inicio de sesión de usuarios.
- Autenticación mediante JWT.
- Manejo de roles USER y ADMIN.
- Registro y consulta de propietarios.
- Registro y consulta de mascotas asociadas a un propietario.
- Registro y consulta de veterinarios.
- Registro y consulta de citas.
- Consulta de citas por veterinario.
- Validación de datos de entrada.
- Validación de que las citas tengan una fecha futura.
- Prevención de citas duplicadas para un mismo veterinario y horario.
- Manejo de errores mediante respuestas HTTP.
- Persistencia de la información en MySQL mediante JPA/Hibernate.
- Documentación y pruebas de la API mediante Swagger/OpenAPI.

### Fuera del alcance

El proyecto no incluye:

- Historias clínicas.
- Pagos.
- Inventario.
- Recordatorios o notificaciones.
- Aplicación web o móvil.
- Despliegue obligatorio en la nube.
- Docker como requisito del proyecto.
## Tecnologías
## Modelo
| Entidad         | Campos principales                                          | Descripción                                                                  |
| --------------- | ----------------------------------------------------------- | ---------------------------------------------------------------------------- |
| **Propietario** | `id`, `nombre`, `telefono`, `email`                         | Representa al responsable de una o varias mascotas.                          |
| **Mascota**     | `id`, `nombre`, `especie`, `raza`, `propietario_id`         | Representa a la mascota y está relacionada con un propietario.               |
| **Veterinario** | `id`, `nombre`, `especialidad`                              | Representa al profesional que atiende las citas.                             |
| **Cita**        | `id`, `fechaHora`, `motivo`, `mascota_id`, `veterinario_id` | Representa una cita programada entre una mascota y un veterinario.           |
| **Usuario**     | `id`, `email`, `password`, `rol`                            | Permite la autenticación y autorización mediante los roles `USER` y `ADMIN`. |

**Relación**
`Propietario` 1 ─────────── N `Mascota` ──────N───── `Cita` ─────N────── 1 `Veterinario`
                             
- Un Propietario puede tener varias Mascotas.
- Una Mascota pertenece a un solo Propietario.
- Una Mascota puede tener varias Citas.
- Un Veterinario puede tener varias Citas.
- Una Cita pertenece a una Mascota y a un Veterinario.
- Las relaciones de Mascota y Cita utilizan claves foráneas para mantener la integridad de los datos.
## Endpoints
POST  /api/auth/register
POST  /api/auth/login

POST  /api/propietarios
GET   /api/propietarios

POST  /api/mascotas
GET   /api/mascotas

POST  /api/veterinarios
GET   /api/veterinarios

POST  /api/citas
GET   /api/citas
GET   /api/citas/veterinario/{id}
## Roles
### USER
- Registrar propietarios.
- Registrar mascotas.
- Registrar citas.
- Consultar propietarios.
- Consultar mascotas.
- Consultar veterinarios.
- Consultar citas.
- No puede registrar veterinarios.

### ADMIN
- Puede hacer todo lo anterior.
- Puede registrar veterinarios.
## Configuración de MySQL
- Crear la base de datos VetTurno
- Configurar application.properties: 
`spring.datasource.url=jdbc:mysql://localhost:3306/vetturnos`
`spring.datasource.username=root`
`spring.datasource.password=enginner`
  
## Orden del flujo

El flujo general de una petición es:

```text
Postman / Swagger
       ↓
   Controller
       ↓
    Service
       ↓
   Repository
       ↓
     MySQL
```

### Flujo para crear una cita

```text
POST /api/citas
       ↓
CitaController
       ↓
CitaService
       ↓
Busca Mascota y Veterinario
       ↓
Comprueba fecha futura
       ↓
Comprueba que no exista otra cita
       ↓
CitaRepository
       ↓
     MySQL
       ↓
Respuesta 201 Created
```

## Matriz de pruebas

La matriz completa de pruebas manuales se encuentra en el siguiente archivo:

[Ver matriz completa de pruebas](evidencia/matriz-pruebas.md)
## Errores frecuentes
- MySQL no está iniciado.
- Usuario o contraseña de MySQL incorrectos.
- La base de datos vetturno no existe.
- El puerto 8080 está ocupado.
- JWT no enviado en Authorization.
- Usuario USER intentando registrar veterinario.
- ID de propietario inexistente.
- ID de mascota o veterinario inexistente.
- Intento de crear una cita en el pasado.
- Intento de crear una cita duplicada.
- Error 500 por una configuración incorrecta.

