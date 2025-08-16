public class Main {
    public static void main(String[] args) {
        // Crear una ciudad
        MapaCiudad ciudad = new MapaCiudad();

        // Agregar ubicaciones
        Ubicacion interseccion1 = new Ubicacion(1, "Intersección A", "intersección", 0, 0);
        Ubicacion interseccion2 = new Ubicacion(2, "Intersección B", "intersección", 2, 1);
        Ubicacion interseccion3 = new Ubicacion(3, "Intersección C", "intersección", 4, 0);
        Ubicacion parque = new Ubicacion(4, "Parque Central", "parque", 2, 3);
        Ubicacion hospital = new Ubicacion(5, "Hospital General", "hospital", 4, 2);

        ciudad.agregarUbicacion(interseccion1);
        ciudad.agregarUbicacion(interseccion2);
        ciudad.agregarUbicacion(interseccion3);
        ciudad.agregarUbicacion(parque);
        ciudad.agregarUbicacion(hospital);

        // Agregar carreteras
        ciudad.agregarCarretera(new Carretera(interseccion1, interseccion2, "Avenida Principal", 2, 60));
        ciudad.agregarCarretera(new Carretera(interseccion2, interseccion3, "Calle Secundaria", 1, 40));
        ciudad.agregarCarretera(new Carretera(interseccion2, parque, "Boulevard del Parque", 2, 50));
        ciudad.agregarCarretera(new Carretera(interseccion3, hospital, "Calle Hospital", 1, 30));

        // Visualizar el mapa
        SwingUtilities.invokeLater(() -> {
            VisualizadorMapa visualizador = new VisualizadorMapa(ciudad);
            visualizador.setVisible(true);
        });

        // Encontrar una ruta
        ciudad.encontrarRuta(1, 5);  // Desde Intersección A al Hospital General
    }
}