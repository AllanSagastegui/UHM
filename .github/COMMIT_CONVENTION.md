# Git Commit Message Convention

> Esta convención asegura que todos los commits sean claros, consistentes y generen un changelog limpio.

## Estructura del mensaje

```txt
<type>(<scope>): <subject>
```

* type → Categoría del cambio (obligatorio).
* scope → Área del proyecto afectada (opcional, pero recomendado).
* subject → Breve descripción del cambio (obligatorio).

### Ejemplos válidos

```txt
feat(auth): add Google Sign-In
fix(home): prevent crash on scroll
refactor(theme): simplify color logic
chore: update Flutter SDK version
revert: feat(onboarding): remove welcome screen
docs(readme): improve installation guide
```

## Tipos permitidos

| Tipo     | Descripción                                 |
| -------- | ------------------------------------------- |
| feat     | Nueva funcionalidad                         |
| fix      | Corrección de bugs                          |
| style    | Cambios de formato/código (sin lógica)      |
| refactor | Cambios internos sin afectar comportamiento |
| perf     | Mejoras de rendimiento                      |
| test     | Cambios en pruebas                          |
| chore    | Mantenimiento general                       |
| ci       | Configuración de CI/CD                      |
| workflow | Cambios en GitHub Actions u otros flujos    |
| types    | Cambios en modelos/tipos                    |
| wip      | Trabajo en progreso                         |
| revert   | Reversión de un commit anterior             |
| docs     | Cambios en archivos de documentación del proyecto |

## Reglas al escribir el commit

* Usa **presente, imperativo**: `add`, `fix`, `refactor`, no `added` o `fixes`.
* No usar punto al final.
* Máximo **72 caracteres** en `<subject>`.
* Si el commit es complejo, agrega un cuerpo opcional con más detalles:

```txt
feat(appointments): allow recurring events

Added support for daily and weekly recurring appointments.
This required changes in the database schema and scheduling logic.
```

* Usa `BREAKING CHANGE`: en el cuerpo si introduces cambios incompatibles:

```txt
feat(auth): migrate password hashing algorithm

BREAKING CHANGE: user passwords must be reset due to the new hashing method.
```