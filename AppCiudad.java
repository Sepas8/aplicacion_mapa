import javax.swing.*;

public class AppCiudad {
    public static void main(String[] args) {
        Ciudad ciudad = new Ciudad();

        // Crear nodos

        Nodo casa = new Nodo("Casa", 100, 100);
        Nodo parque = new Nodo("Parque", 300, 100);
        Nodo tienda = new Nodo("Tienda", 200, 300);
        Nodo escuela = new Nodo("Escuela", 400, 400);
        Nodo hospital = new Nodo("Hospital", 500, 200);

        // Conectar nodos

        casa.conectar(parque);
        parque.conectar(tienda);
        casa.conectar(tienda);
        tienda.conectar(escuela);
        parque.conectar(hospital);
        escuela.conectar(hospital);

        // Agregar a la ciudad

        ciudad.agregarNodo(casa);
        ciudad.agregarNodo(parque);
        ciudad.agregarNodo(tienda);
        ciudad.agregarNodo(escuela);
        ciudad.agregarNodo(hospital);

        // Mostrar el mapa
        JFrame frame = new JFrame("Mapa de la Ciudad (Grafo)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MapaPanel(ciudad));
        frame.pack();
        frame.setVisible(true);

        GrafoExporter exporter = new GrafoExporter(new XMLExportVisitor());
        String xml = exporter.export(ciudad);

        System.out.println("=== XML Exportado ===");
        System.out.println(xml);
    }
}
