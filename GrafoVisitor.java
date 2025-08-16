public interface GrafoVisitor {
    void visit(Nodo nodo, StringBuilder xml);

    void visit(Ciudad ciudad, StringBuilder xml);
}
