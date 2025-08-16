import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapaCiudad {
    private Map<Integer, Ubicacion> ubicaciones;
    private List<Carretera> carreteras;

    public MapaCiudad() {
        this.ubicaciones = new HashMap<>();
        this.carreteras = new LinkedList<>();
    }

    public void agregarUbicacion(Ubicacion ubicacion) {
        ubicaciones.put(ubicacion.getId(), ubicacion);
    }

    public void agregarCarretera(Carretera carretera) {
        // Calcular distancia euclidiana
        double distancia = calcularDistancia(carretera.getOrigen(), carretera.getDestino());
        
        // Conectar en ambas direcciones
        carretera.getOrigen().agregarVecino(carretera.getDestino(), distancia);
        carretera.getDestino().agregarVecino(carretera.getOrigen(), distancia);
        
        carreteras.add(carretera);
    }

    private double calcularDistancia(Ubicacion a, Ubicacion b) {
        return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    }

    public List<Ubicacion> encontrarRuta(int origenId, int destinoId) {
        // Implementación básica de BFS (podría mejorarse con Dijkstra)
        Map<Integer, Integer> parent = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean found = false;
        
        queue.add(origenId);
        parent.put(origenId, -1); // -1 indica que es el origen
        
        while (!queue.isEmpty() && !found) {
            int current = queue.poll();
            
            if (current == destinoId) {
                found = true;
                break;
            }
            
            for (Ubicacion.Vecino vecino : ubicaciones.get(current).getVecinos()) {
                int vecinoId = vecino.ubicacion.getId();
                if (!parent.containsKey(vecinoId)) {
                    parent.put(vecinoId, current);
                    queue.add(vecinoId);
                }
            }
        }
        
        if (!found) {
            System.out.println("No se encontró ruta entre los puntos");
            return null;
        }
        
        // Reconstruir la ruta
        LinkedList<Ubicacion> ruta = new LinkedList<>();
        int current = destinoId;
        while (current != -1) {
            ruta.addFirst(ubicaciones.get(current));
            current = parent.get(current);
        }
        
        System.out.println("Ruta encontrada:");
        for (Ubicacion u : ruta) {
            System.out.println(" - " + u);
        }
        
        return ruta;
    }

    public Map<Integer, Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public List<Carretera> getCarreteras() {
        return carreteras;
    }
}