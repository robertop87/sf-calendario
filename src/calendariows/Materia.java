package calendariows;

/**
 *
 * @author sofunA
 */
class Materia {
    
    private String codigo;
    
    Materia(String codigo, String nombre, int duracion) {
        this.codigo = codigo;
    }
    
    public String miCodigo() {
        return codigo;
    }
}
