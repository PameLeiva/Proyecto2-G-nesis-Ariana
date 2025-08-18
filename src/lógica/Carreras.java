package lógica;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class Carreras {

    private int idCarrera;
    private String nomCarrera;
    private String grado;

    public Carreras() {
        this.idCarrera = 0;
        this.nomCarrera = "";
        this.grado = "";
    }

    public Carreras(int idCarrera, String nomCarrera, String grado) {
        this.idCarrera = idCarrera;
        this.nomCarrera = nomCarrera;
        this.grado = grado;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNomCarrera() {
        return nomCarrera;
    }

    public void setNomCarrera(String nomCarrera) {
        this.nomCarrera = nomCarrera;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return this.getNomCarrera(); 
    }
}
