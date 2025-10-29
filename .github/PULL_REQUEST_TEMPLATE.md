## 1. Description (Descripción) RECUERDA HACERLO TDODO EN INGLES
*(Describe en 1 o 2 frases claras qué hace este PR. ¿Cuál es el objetivo?)*

Ej: "Agrega los endpoints del CRUD para Proyectos en el ProjectController y crea el ProjectService."

## 2. Related Azure Task (Tarea de Azure Vinculada)
*(Esta es la parte MÁS importante para la trazabilidad)*

**Task ID:** `AB#<ID_DE_TU_TAREA>`
**Link to Task:** `[Pega aquí el link directo a tu Tarea de Azure]`

*(Sustituye `<ID_DE_TU_TAREA>` por el número de tu tarea, ej: `AB#6605`. Esto intentará mover la tarea a "Done" cuando se haga merge.)*

## 3. Changes Made (Cambios Realizados)
*(Usa guiones para listar los cambios técnicos que hiciste. Sé específico.)*

* `[ ]` Creado `ProjectController.java`.
* `[ ]` Implementado el endpoint `POST /api/projects`.
* `[ ]` Creado `ProjectService.java` y su implementación.
* `[ ]` Añadido el DTO `ProjectDTO.java`.

*(Marca `[x]` en los que estén completos si es un PR en progreso, o déjalos `[ ]` para que el revisor los verifique).*

## 4. Evidence / How to Test (Evidencia / Cómo Probar)
*(Esta es la "prueba" de tu trabajo. ¡Ayuda a tu revisor!)*

**Screenshots:**
*(¡Pega aquí capturas de pantalla de tu trabajo!)*

* **Si es Backend:** Una captura de Postman o Insomnia mostrando el endpoint funcionar (ej: un "201 Created" o un JSON de respuesta).
* **Si es Frontend:** Una captura de la UI mostrando el nuevo botón, el formulario, o el cambio visual.
* **Si es una Prueba (Test):** Una captura de tu IDE mostrando la barra en VERDE 🟢.

**Pasos para probar (si es necesario):**
1.  Levantar el backend.
2.  Enviar una petición `POST` a `http://localhost:8080/api/projects` con este JSON: `{...}`.
3.  Verificar que la respuesta sea un `201`.
