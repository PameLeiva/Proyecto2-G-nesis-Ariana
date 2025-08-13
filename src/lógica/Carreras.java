
package lógica;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class Carreras {
    private int idCarrera;
    private String nomCarrera;
    private String Carrera;

    public Carreras() {
        this.idCarrera = 0;
        this.nomCarrera = "";
        this.Carrera = "";
    }

    public Carreras(int idCarrera, String nomCarrera, String Carrera) {
        this.idCarrera = idCarrera;
        this.nomCarrera = nomCarrera;
        this.Carrera = Carrera;
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

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    
    
}
