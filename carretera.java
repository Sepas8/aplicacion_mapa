public class Carretera {
    private Ubicacion origen;
    private Ubicacion destino;
    private String nombre;
    private int carriles;
    

    public Carretera(Ubicacion origen, Ubicacion destino, String nombre, int carriles) {
        this.origen = origen;
        this.destino = destino;
        this.nombre = nombre;
        this.carriles = carriles;
        
    }

    public Ubicacion getOrigen() {
        return origen;
    }

    public Ubicacion getDestino() {
        return destino;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarriles() {
        return carriles;
    }



    @Override
    public String toString() {
        return nombre + ": " + origen.getNombre() + " -> " + destino.getNombre();
    }
}