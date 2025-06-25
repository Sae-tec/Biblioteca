# Proyecto de Gestión de Biblioteca
Nombre: Benjamin Vivero

Seccion: 2
## Descripción del Sistema
Este proyecto implementa tres patrones de diseño en Java: **Singleton**, **Bridge** y **Prototype**. Cada patrón tiene un propósito específico en el desarrollo de software, y se utiliza para resolver problemas comunes de diseño.

## Patrones de Diseño Implementados

### 1. Singleton (Creacional)

**Descripción**: El patrón Singleton asegura que una clase tenga una única instancia y proporciona un punto de acceso global a ella.

**Uso en el Proyecto**:
- La clase `Singleton` implementa este patrón. Su constructor es privado, lo que impide que se creen instancias desde fuera de la clase.
- El método `getInstance()` garantiza que solo se cree una instancia de `Singleton`, y la devuelve a cualquier parte del código que la solicite.

**Por qué usarlo**:
- Es útil cuando se necesita un control centralizado sobre un recurso, como una conexión a una base de datos o una configuración global.

### 2. Bridge (Estructural)

**Descripción**: El patrón Bridge desacopla una abstracción de su implementación, permitiendo que ambas evolucionen de manera independiente.

**Uso en el Proyecto**:
- Se define una interfaz `Implementor` y dos implementaciones concretas (`ConcreteImplementorA` y `ConcreteImplementorB`).
- La clase abstracta `Abstraction` contiene una referencia a un objeto `Implementor`, y la clase `RefinedAbstraction` extiende `Abstraction` para implementar el método `operation()`, que utiliza el `Implementor`.

**Por qué usarlo**:
- Permite cambiar la implementación de la abstracción sin modificar su interfaz, facilitando la escalabilidad y la flexibilidad en el diseño del sistema.

### 3. Prototype (Comportamiento)

**Descripción**: El patrón Prototype permite copiar objetos existentes sin hacer el código dependiente de sus clases.

**Uso en el Proyecto**:
- La clase `Prototype` es abstracta y define el método `clone()`.
- `ConcretePrototype` extiende `Prototype` y proporciona una implementación específica de `clone()`, creando una nueva instancia con los mismos atributos.

**Por qué usarlo**:
- Es útil cuando la creación de un objeto es costosa o compleja. Permite crear copias a partir de un objeto existente, lo que simplifica la instanciación de nuevos objetos similares.

