import java.util.*;

// Patrón Singleton para la biblioteca
class Biblioteca {
    private static Biblioteca instancia;
    private Map<String, Libro> libros = new HashMap<>();
    
    private Biblioteca() {}
    
    public static Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }
    
    public void agregarLibro(Libro libro) {
        libros.put(libro.getId(), libro);
    }
    
    public void eliminarLibro(String id) {
        libros.remove(id);
    }
    
    public void modificarLibro(String id, String titulo, String autor, int año) {
        Libro libro = libros.get(id);
        if (libro != null) {
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setAño(año);
        }
    }
    
    public List<Libro> listarLibros() {
        return new ArrayList<>(libros.values());
    }
    
    public Libro obtenerLibro(String id) {
        return libros.get(id);
    }
}

// Patrón Prototype (creacional)
abstract class Libro implements Cloneable {
    private String id;
    protected String titulo;
    protected String autor;
    protected int año;
    
    public Libro(String id, String titulo, String autor, int año) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }
    
    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAño() { return año; }
    
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAño(int año) { this.año = año; }
    
    public abstract Libro clonar();
    
    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor + " | Año: " + año;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class LibroFisico extends Libro {
    private String ubicacion;
    
    public LibroFisico(String id, String titulo, String autor, int año, String ubicacion) {
        super(id, titulo, autor, año);
        this.ubicacion = ubicacion;
    }
    
    @Override
    public Libro clonar() {
        try {
            return (LibroFisico) this.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// Patrón Bridge (estructural)
interface Formato {
    String mostrar(Libro libro);
}

class FormatoSimple implements Formato {
    @Override
    public String mostrar(Libro libro) {
        return libro.getTitulo() + " - " + libro.getAutor();
    }
}

class FormatoCompleto implements Formato {
    @Override
    public String mostrar(Libro libro) {
        return "Título: " + libro.getTitulo() + "\nAutor: " + libro.getAutor() + 
               "\nAño: " + libro.getAño() + "\nID: " + libro.getId();
    }
}

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstancia();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Modificar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    agregarLibro(scanner, biblioteca);
                    break;
                case 2:
                    listarLibros(biblioteca);
                    break;
                case 3:
                    modificarLibro(scanner, biblioteca);
                    break;
                case 4:
                    eliminarLibro(scanner, biblioteca);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
    
    private static void agregarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("ID del libro: ");
        String id = scanner.nextLine();
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        System.out.print("Año: ");
        int año = scanner.nextInt();
        scanner.nextLine();
        
        biblioteca.agregarLibro(new LibroFisico(id, titulo, autor, año, "Estante A"));
        System.out.println("Libro agregado!");
    }
    
    private static void listarLibros(Biblioteca biblioteca) {
        System.out.println("\n--- LIBROS EN BIBLIOTECA ---");
        biblioteca.listarLibros().forEach(System.out::println);
    }
    
    private static void modificarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("ID del libro a modificar: ");
        String id = scanner.nextLine();
        
        Libro libro = biblioteca.obtenerLibro(id);
        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }
        
        System.out.print("Nuevo título (" + libro.getTitulo() + "): ");
        String titulo = scanner.nextLine();
        
        System.out.print("Nuevo autor (" + libro.getAutor() + "): ");
        String autor = scanner.nextLine();
        
        System.out.print("Nuevo año (" + libro.getAño() + "): ");
        int año = scanner.nextInt();
        scanner.nextLine();
        
        biblioteca.modificarLibro(id, titulo, autor, año);
        System.out.println("Libro modificado!");
    }
    
    private static void eliminarLibro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("ID del libro a eliminar: ");
        String id = scanner.nextLine();
        
        if (biblioteca.obtenerLibro(id) != null) {
            biblioteca.eliminarLibro(id);
            System.out.println("Libro eliminado!");
        } else {
            System.out.println("Libro no encontrado");
        }
    }
}
