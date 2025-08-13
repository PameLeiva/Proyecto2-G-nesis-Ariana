package datos;

import java.util.ArrayList;
import lógica.Carreras;

/**
 *
 * @author Génesis Leiva
 * @author Ariana Araya
 */
public class AlmacenamientoCarreras {

    private ArrayList<Carreras> listaCarreras;

    public AlmacenamientoCarreras() {
        this.listaCarreras = new ArrayList();
    }

    public ArrayList<Carreras> getListaCarreras() {
        return listaCarreras;
    }

    public void setListaCarreras(ArrayList<Carreras> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    //CRUD
    public void insertarCarreras(Carreras carreras) {
        if (this.listaCarreras != null) {
            this.listaCarreras.add(carreras);
        }
    }

    public void editarCarreras(int i, Carreras newCarrera) {
        if (i >= 0 && newCarrera != null && !listaCarreras.isEmpty()) {
            this.listaCarreras.set(i, newCarrera);
        }
    }

    public boolean eliminarCarreras(Carreras carreras) {
        if (this.listaCarreras.contains(carreras)) {
            this.listaCarreras.remove(carreras);
            return true;
        }
        return false; //Estudiante no existe en el Array
    }

    public Carreras buscarId(int id) {
        for (Carreras ca : listaCarreras) {
            if (ca.getIdCarrera() == id) {
                return ca;
            }
        }
        return null;

    }
}
