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

    public Calendario() {
        horarios = new ArrayList<>();
    }

    public boolean asignarHorario(Horario horario, Materia materia) {
        if (horario.estaEnRango(horasDeInicioValidos, horasDeFinValidos)) {
            if (!estaRegistrado(horario)) {
                return horarios.add(horario);
            }
        }
        return false;
    }

    public int contarMaterias() {
        return 1;
    }

    private boolean estaRegistrado(Horario horario) {
        return horarios.contains(horario);
    }

}
