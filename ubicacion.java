import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
    private int id;
    private String nombre;
    private String tipo;
    private double x;
    private double y;
    private List<Vecino> vecinos;

    public Ubicacion(int id, String nombre, String tipo, double x, double y) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.vecinos = new ArrayList<>();
    }

    public void agregarVecino(Ubicacion vecino, double distancia) {
        this.vecinos.add(new Vecino(vecino, distancia));
    }

    public List<Vecino> getVecinos() {
        return vecinos;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ")";
    }

    // Clase interna para representar vecinos con distancia
    public static class Vecino {
        public Ubicacion ubicacion;
        public double distancia;

        public Vecino(Ubicacion ubicacion, double distancia) {
            this.ubicacion = ubicacion;
            this.distancia = distancia;
        }
    }
}