import java.util.List;
import java.util.ArrayList;

public class Ciudad {
    List<Nodo> nodos;

    public Ciudad() {
        this.nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo n) {
        nodos.add(n);
    }
}
