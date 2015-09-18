package calendariows;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofunA
 */
class Calendario {

    private final int[] horasDeInicioValidos = {9, 10, 11, 14, 15, 16};
    private final int[] horasDeFinValidos = {10, 11, 12, 15, 16, 17};
    private List<Horario> horarios;
    private List<Materia> materias;

    public Calendario() {
        horarios = new ArrayList<>();
        materias = new ArrayList<>();
    }

    public boolean asignarHorario(Horario horario, Materia materia) {
        if (horario.estaEnRango(horasDeInicioValidos, horasDeFinValidos)) {
            if (!estaRegistrado(horario)) {
                materias.add(materia);
                return horarios.add(horario);
            }
        }
        return false;
    }

    public int contarMaterias() {
     List <Materia> matAux = new ArrayList<>();   
        for (Materia materia : materias) {
            if (!matAux.contains(materia)) {
                matAux.add(materia);
            }
        }
    return matAux.size();  
    }

    private boolean estaRegistrado(Horario horario) {
        return horarios.contains(horario);
    }

    public int contarHorarios() {
        return horarios.size();
    }

}
