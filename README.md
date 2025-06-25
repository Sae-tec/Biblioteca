# Sistema de Gestión de Biblioteca

## 📚 Descripción del Sistema

Este sistema permite gestionar los libros de una biblioteca, incluyendo funcionalidades como:

- Agregar nuevos libros
- Modificar información de libros existentes
- Eliminar libros
- Listar todos los libros

El sistema simula una biblioteca simple y funcional a través de consola, con un enfoque en buenas prácticas de diseño orientado a objetos, utilizando **patrones de diseño** para una mejor organización y mantenibilidad del código.

## ❗ Problema a Resolver

La gestión manual o mal estructurada de libros puede llevar a inconsistencias, duplicación de datos y dificultad en el mantenimiento del sistema. Este proyecto busca resolver estos problemas:

- Centralizando el acceso a la colección de libros
- Permitiendo la clonación de libros cuando se requiera
- Facilitando distintas formas de mostrar la información

---

## 🧠 Patrones de Diseño Implementados

### 🔒 1. Singleton (Creacional) - `Biblioteca`

**Justificación**:  
Se necesita una única instancia central de la biblioteca para evitar inconsistencias en el acceso y modificación de los libros.

**Cómo y dónde se aplica**:  
La clase `Biblioteca` tiene un constructor privado y un método estático `getInstancia()` que asegura que solo se cree una única instancia a lo largo del programa. Esta instancia centraliza la gestión de libros.

---

### 🧬 2. Prototype (Creacional) - `Libro`, `LibroFisico`

**Justificación**:  
A veces es útil clonar libros a partir de uno existente, por ejemplo, al registrar múltiples copias similares con ligeras variaciones.

**Cómo y dónde se aplica**:  
La clase abstracta `Libro` implementa `Cloneable` y define un método `clonar()` que es sobrescrito por `LibroFisico`. Así se puede duplicar fácilmente un libro sin depender de la creación desde cero.

---

### 🧱 3. Bridge (Estructural) - `Formato`, `FormatoSimple`, `FormatoCompleto`

**Justificación**:  
Permite separar la lógica del sistema (gestión de libros) de la forma en que se presentan, facilitando la extensión o modificación de los formatos de salida sin alterar las clases base.

**Cómo y dónde se aplica**:  
Se define una interfaz `Formato` y dos implementaciones: `FormatoSimple` y `FormatoCompleto`. Aunque no se usa en la UI actual por consola, esta estructura permite mostrar los libros de distintas maneras (por ejemplo, en una futura interfaz gráfica o reporte impreso).

---

## 🚀 ## Instrucciones de uso:
### Software requerido:
- Netbeans 12 en adelante.
- JDK 24 (recomendado)
### Instrucciones:
- Descargar `sistema de biblioteca`.
- Abrir proyecto.
- Iniciar.

