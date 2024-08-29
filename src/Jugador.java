public class Jugador {
    private int id;
    private String nombre;
    private int edad;
    private String posicion;
    private static int contadorID = 1;

    public Jugador(String nombre, int edad, String posicion) {
        this.id = contadorID++;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador [ID=" + id + ", Nombre=" + nombre + ", Edad=" + edad + ", Posición=" + posicion + "]";
    }
}
