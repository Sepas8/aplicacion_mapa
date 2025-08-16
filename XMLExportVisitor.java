public class XMLExportVisitor implements GrafoVisitor {

    @Override
    public void visit(Nodo nodo, StringBuilder xml) {
        xml.append("  <nodo nombre=\"").append(nodo.nombre)
                .append("\" x=\"").append(nodo.x)
                .append("\" y=\"").append(nodo.y).append("\">\n");

        for (Nodo vecino : nodo.vecinos) {
            xml.append("    <conectadoA>").append(vecino.nombre).append("</conectadoA>\n");
        }

        xml.append("  </nodo>\n");
    }

    @Override
    public void visit(Ciudad ciudad, StringBuilder xml) {
        xml.append("<ciudad>\n");
        for (Nodo n : ciudad.nodos) {
            visit(n, xml); // recorrer nodos
        }
        xml.append("</ciudad>\n");
    }
}
