# Matriz de pruebas manuales - VetTurno

| # | Escenario | Resultado esperado | Resultado obtenido | Evidencia                                                                                                          |
|---|---|---|---|--------------------------------------------------------------------------------------------------------------------|
| 1 | La aplicación inicia con MySQL disponible | Servidor activo y esquema accesible | Pendiente | [Ver evidencia](fotos/prueba1.jpg), [Ver evidencia](fotos/prueba1.1.jpg)                                           |
| 2 | Registro válido de Paula | 200 y token; contraseña hasheada | Pendiente | [ver evidencia](fotos/prueba2.jpg)                                                                                 |
| 3 | Registro con email inválido y clave corta | 400 con errores por campo | Pendiente | [ver evidencia](fotos/prueba3.jpg)                                                                                 |
| 4 | Login con credenciales válidas | 200 y JWT vigente | Pendiente | [ver evidencia](fotos/prueba4.jpg)                                                                                 |
| 5 | GET /api/citas sin token | Acceso rechazado | Pendiente | [ver evidencia](fotos/prueba5.jpg)                                                                                 |
| 6 | POST /api/veterinarios con USER | 403 Forbidden | Pendiente | [ver evidencia](fotos/prueba6.jpg)                                                                                 |
| 7 | POST /api/veterinarios con ADMIN | 201 y veterinario persistido | Pendiente | [ver evidencia](fotos/prueba7.jpg)                                                                                 |
| 8 | Creación válida de propietario | 201 y DTO sin colecciones anidadas | Pendiente | [ver evidencia](fotos/prueba8.jpg)                                                                                 |
| 9 | Creación de mascota con propietario existente | 201 y relación correcta | Pendiente | [ver evidencia](fotos/prueba9.jpg)                                                                                 |
| 10 | Mascota con propietario inexistente | 400 controlado; no se inserta fila | Pendiente | [ver evidencia](fotos/prueba10.jpg)                                                                                |
| 11 | Cita futura con referencias válidas | 201 y cita persistida | Pendiente | [ver evidencia](fotos/prueba11.jpg)                                                                                |
| 12 | Cita con fecha pasada | 400 con mensaje claro | Pendiente | [ver evidencia](fotos/prueba12.jpg)                                                                                |
| 13 | Segundo intento con mismo veterinario y horario | 400; se conserva una sola cita | Pendiente | [ver evidencia](fotos/prueba13.jpg)                                                                                |
| 14 | Filtro de citas por veterinario | 200 y solo coincidencias | Pendiente | [ver evidencia](fotos/prueba14.jpg)                                                                                |
| 15 | Reinicio y prueba desde Swagger con Authorize | Los datos persisten y el flujo protegido funciona | Pendiente | [ver evidencia](fotos/prueba15.1.jpg) ,[ver evidencia](fotos/prueba15.2.jpg),[ver evidencia](fotos/prueba15.3.jpg) |