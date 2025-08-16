package datos;

import java.util.ArrayList;
import lógica.BeneficiosEstudiantes;

/**
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoBeneficiosEstudiantes {
    
    private ArrayList<BeneficiosEstudiantes> listaBeneficiosEstudiantes;
    
    public AlmacenamientoBeneficiosEstudiantes() {
        this.listaBeneficiosEstudiantes = new ArrayList<>();
    }
    
    public ArrayList<BeneficiosEstudiantes> getListaBeneficiosEstudiantes() {
        return listaBeneficiosEstudiantes;
    }
    
    public void setListaBeneficiosEstudiantes(ArrayList<BeneficiosEstudiantes> listaBeneficiosEstudiantes) {
        this.listaBeneficiosEstudiantes = listaBeneficiosEstudiantes;
    }
    
    // CRUD
    public void asignarBeneficio(BeneficiosEstudiantes beneficioEstudiante) {
        if (beneficioEstudiante != null) {
            this.listaBeneficiosEstudiantes.add(beneficioEstudiante);
        }
    }
    
    public boolean quitarBeneficio(int cedula, int idBeneficio) {
        for (int i = 0; i < listaBeneficiosEstudiantes.size(); i++) {
            BeneficiosEstudiantes be = listaBeneficiosEstudiantes.get(i);
            if (be.getCed() == cedula && be.getIdBeneficio() == idBeneficio) {
                listaBeneficiosEstudiantes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<BeneficiosEstudiantes> obtenerBeneficiosDeEstudiante(int cedula) {
        ArrayList<BeneficiosEstudiantes> beneficiosDelEstudiante = new ArrayList<>();
        for (BeneficiosEstudiantes be : listaBeneficiosEstudiantes) {
            if (be.getCed() == cedula) {
                beneficiosDelEstudiante.add(be);
            }
        }
        return beneficiosDelEstudiante;
    }
    
    public boolean tieneBeneficio(int cedula, int idBeneficio) {
        for (BeneficiosEstudiantes be : listaBeneficiosEstudiantes) {
            if (be.getCed() == cedula && be.getIdBeneficio() == idBeneficio) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Integer> obtenerEstudiantesConBeneficios() {
        ArrayList<Integer> estudiantes = new ArrayList<>();
        for (BeneficiosEstudiantes be : listaBeneficiosEstudiantes) {
            if (!estudiantes.contains(be.getCed())) {
                estudiantes.add(be.getCed());
            }
        }
        return estudiantes;
    }
}
