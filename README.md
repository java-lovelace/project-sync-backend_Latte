# proyect-sync-backend_Latte

API REST para gestión de proyectos con Spring Boot. CRUD completo con DTOs y arquitectura en capas.

## Tecnologías

Java | Spring Boot | REST API | DTO Pattern

## Endpoints

### Base URL
`http://localhost:8080/api/projects`

### Operaciones

**Listar proyectos**
```
GET /api/projects
```

**Obtener proyecto por ID**
```
GET /api/projects/{id}
```

**Crear proyecto**
```
POST /api/projects
Body: { "name": "Proyecto 1", "description": "...", "responsiblePerson": "...", "status": "..." }
```

**Actualizar proyecto**
```
POST /api/projects/{id}
Body: { "name": "...", "description": "...", ... }
```

**Eliminar proyecto**
```
POST /api/projects/delete/{id}
```

## Modelo de Datos
```
{
    "id": Long,
    "name": String,
    "description": String,
    "responsiblePerson": String,
    "status": String,
    "date": Date
}
```

## Características

- CRUD completo
- Patrón DTO para transferencia de datos
- ResponseEntity para respuestas HTTP
- Conversión Entity ↔ DTO

## Ejecutar
```
mvn spring-boot:run
```

---

Desarrollado con Spring Boot
