package datos;

import java.util.ArrayList;
import lógica.Estudiante;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoEstudiante {

    private ArrayList<Estudiante> listaEstudiantes;

    public AlmacenamientoEstudiante() {
        this.listaEstudiantes = new ArrayList();
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    //CRUD
    public void insertarEstudiante(Estudiante estudiante) {
        if (this.listaEstudiantes != null) {
            this.listaEstudiantes.add(estudiante);
        }
    }

    public void editarEstudiante(int i, Estudiante newEstudiante) {
        if (i >= 0 && newEstudiante != null && !listaEstudiantes.isEmpty()) {
            this.listaEstudiantes.set(i, newEstudiante);
        }
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        if (this.listaEstudiantes.contains(estudiante)) {
            this.listaEstudiantes.remove(estudiante);
            return true;
        }
        return false; //Estudiante no existe en el Array
    }

    public Estudiante buscarCedula(int ced) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getCed() == ced) {
                return e;
            }
        }
        return null;
    }

    public Estudiante buscarCarnet(int carnet) {
        for (Estudiante c : listaEstudiantes) {
            if (c.getCarnet() == carnet) {
                return c;
            }
        }
        return null;
    }
}
