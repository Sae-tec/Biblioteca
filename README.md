# Proyecto de Gestión de Biblioteca
Nombre: Benjamin Vivero
Seccion: 2
## Descripción del Sistema
Este sistema permite gestionar una biblioteca, registrar libros y realizar préstamos. Utiliza patrones de diseño para mejorar la estructura y funcionalidad del código.

## Patrones de Diseño Implementados

1. **Singleton (BibliotecaSingleton)**
   - **Por qué**: Para asegurar que solo exista una instancia de la biblioteca en todo el sistema.
   - **Cómo**: Se utiliza un método estático `getInstance()` que controla la creación de la instancia.
   - **Dónde**: En la clase `BibliotecaSingleton`.

2. **Prototype (LibroPrototype)**
   - **Por qué**: Para permitir la creación de copias de libros sin necesidad de instanciar nuevos objetos manualmente.
   - **Cómo**: Se implementa el método `clone()` que retorna una nueva instancia de `LibroPrototype`.
   - **Dónde**: En la clase `LibroPrototype`.

3. **Adapter (FormatoAdapter)**
   - **Por qué**: Para adaptar la visualización de los libros a diferentes formatos sin modificar la clase `Libro`.
   - **Cómo**: Se crea una clase `FormatoAdapter` que toma un objeto `Libro` y proporciona un método para mostrar su información.
   - **Dónde**: En la clase `FormatoAdapter`.

4. **Iterator (BibliotecaIterator)**
   - **Por qué**: Para proporcionar una forma de recorrer los libros de la biblioteca de manera eficiente sin exponer su estructura interna.
   - **Cómo**: Se implementa la interfaz `Iterator` y se crea la clase `BibliotecaIterator` que permite iterar sobre la lista de libros.
   - **Dónde**: En las clases `Iterator` y `BibliotecaIterator`.

## Instrucciones de Compilación y Ejecución
1. Clona el repositorio.
2. Navega a la carpeta del proyecto.
3. Compila el proyecto con `javac src/main/java/com/biblioteca/*.java`.
4. Ejecuta el programa con `java com.biblioteca.Main`.

