import javax.swing.*;
import java.awt.*;

public class MapaPanel extends JPanel {
    Ciudad ciudad;

    public MapaPanel(Ciudad ciudad) {
        this.ciudad = ciudad;
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        for (Nodo n : ciudad.nodos) {
            for (Nodo v : n.vecinos) {
                g.drawLine(n.x, n.y, v.x, v.y);
            }
        }

        for (Nodo n : ciudad.nodos) {
            g.setColor(Color.RED);
            g.fillOval(n.x - 10, n.y - 10, 20, 20);
            g.setColor(Color.BLACK);
            g.drawString(n.nombre, n.x + 10, n.y);
        }
    }
}
