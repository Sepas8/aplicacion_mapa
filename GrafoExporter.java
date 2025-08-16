public class GrafoExporter {
    private GrafoVisitor visitor;

    public GrafoExporter(GrafoVisitor visitor) {
        this.visitor = visitor;
    }

    public String export(Ciudad ciudad) {
        StringBuilder xml = new StringBuilder();
        visitor.visit(ciudad, xml);
        return xml.toString();
    }
}
