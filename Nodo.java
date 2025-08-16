import java.util.List;
import java.util.ArrayList;

public class Nodo {
    String nombre;
    int x, y; // Coordenadas para dibujar en el mapa
    List<Nodo> vecinos;

    public Nodo(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.vecinos = new ArrayList<>();
    }

    public void conectar(Nodo otro) {
        vecinos.add(otro);
    }
}
