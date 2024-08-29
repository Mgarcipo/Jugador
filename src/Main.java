import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1:
                    agregarJugador();
                    break;
                case 2:
                    buscarJugador();
                    break;
                case 3:
                    editarJugador();
                    break;
                case 4:
                    eliminarJugador();
                    break;
                case 5:
                    listarJugadores();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Jugadores ---");
        System.out.println("1. Agregar Jugador");
        System.out.println("2. Buscar Jugador");
        System.out.println("3. Editar Jugador");
        System.out.println("4. Eliminar Jugador");
        System.out.println("5. Listar Jugadores");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void agregarJugador() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Posición: ");
        String posicion = scanner.nextLine();

        Jugador jugador = new Jugador(nombre, edad, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador agregado con éxito.");
        listarJugadores();
    }

    private static void buscarJugador() {
        System.out.print("Ingresa el ID del jugador: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Jugador jugador = obtenerJugadorPorId(id);
        if (jugador != null) {
            System.out.println(jugador);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void editarJugador() {
        System.out.print("Ingresa el ID del jugador a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Jugador jugador = obtenerJugadorPorId(id);
        if (jugador != null) {
            System.out.print("Nuevo nombre (actual: " + jugador.getNombre() + "): ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Nueva edad (actual: " + jugador.getEdad() + "): ");
            int nuevaEdad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Nueva posición (actual: " + jugador.getPosicion() + "): ");
            String nuevaPosicion = scanner.nextLine();

            jugador.setNombre(nuevoNombre);
            jugador.setEdad(nuevaEdad);
            jugador.setPosicion(nuevaPosicion);
            System.out.println("Jugador actualizado con éxito.");
            listarJugadores();
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void eliminarJugador() {
        System.out.print("Ingresa el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Jugador jugador = obtenerJugadorPorId(id);
        if (jugador != null) {
            System.out.print("¿Confirmas que deseas eliminar al jugador " + jugador.getNombre() + "? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                jugadores.remove(jugador);
                System.out.println("Jugador eliminado con éxito.");
                listarJugadores();
            } else {
                System.out.println("Operación cancelada.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la lista.");
        } else {
            System.out.println("\nLista de Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    private static Jugador obtenerJugadorPorId(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }
}
