
package lógica;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class BeneficiosEstudiantes {
    
    private int ced;
    private int idBeneficio;

    public BeneficiosEstudiantes() {
        this.ced = 0;
        this.idBeneficio = 0;
    }

    public BeneficiosEstudiantes(int ced, int idBeneficio) {
        this.ced = ced;
        this.idBeneficio = idBeneficio;
    }

    public int getCed() {
        return ced;
    }

    public void setCed(int ced) {
        this.ced = ced;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }
    
    
}
