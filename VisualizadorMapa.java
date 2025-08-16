import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class VisualizadorMapa extends JFrame {
    private MapaCiudad mapa;
    private static final int ESCALA = 50;
    private static final int OFFSET = 50;

    public VisualizadorMapa(MapaCiudad mapa) {
        this.mapa = mapa;
        setTitle("Mapa de la Ciudad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        // Dibujar carreteras
        g.setColor(Color.GRAY);
        for (Carretera c : mapa.getCarreteras()) {
            Ubicacion origen = c.getOrigen();
            Ubicacion destino = c.getDestino();
            g.drawLine(
                (int)(origen.getX() * ESCALA + OFFSET), 
                (int)(origen.getY() * ESCALA + OFFSET),
                (int)(destino.getX() * ESCALA + OFFSET), 
                (int)(destino.getY() * ESCALA + OFFSET)
            );
            
            // Dibujar nombre de la carretera
            int midX = (int)((origen.getX() + destino.getX()) * ESCALA / 2 + OFFSET);
            int midY = (int)((origen.getY() + destino.getY()) * ESCALA / 2 + OFFSET);
            g.drawString(c.getNombre(), midX, midY);
        }
        
        // Dibujar ubicaciones
        for (Ubicacion u : mapa.getUbicaciones().values()) {
            switch (u.getTipo()) {
                case "intersección":
                    g.setColor(Color.BLUE);
                    break;
                case "parque":
                    g.setColor(Color.GREEN);
                    break;
                case "hospital":
                    g.setColor(Color.RED);
                    break;
                default:
                    g.setColor(Color.BLACK);
            }
            
            g.fillOval(
                (int)(u.getX() * ESCALA + OFFSET - 5), 
                (int)(u.getY() * ESCALA + OFFSET - 5), 
                10, 10
            );
            
            g.drawString(u.getNombre(), 
                (int)(u.getX() * ESCALA + OFFSET + 10), 
                (int)(u.getY() * ESCALA + OFFSET)
            );
        }
    }
}