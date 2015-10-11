package calendariows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sofunA
 */
class Calendario {

    private final int[] horasDeInicioValidos = {9, 10, 11, 14, 15, 16};
    private final int[] horasDeFinValidos = {10, 11, 12, 15, 16, 17};
    private final Map<String, List<Horario>> reservas;

    public Calendario() {
        reservas = new HashMap<>();
    }

    public boolean asignarHorario(Horario horario, Materia materia) {
        if (horario.estaEnRango(horasDeInicioValidos, horasDeFinValidos)) {
            if (!estaRegistrado(horario)) {
                List<Horario> horarios = reservas.get(materia.miCodigo());
                if (horarios == null) {
                    horarios = new ArrayList<>();    
                }
                
                horarios.add(horario);
                reservas.put(materia.miCodigo(), horarios);
                return true;
            }
        }
        return false;
    }

    public int contarMaterias() {
        return reservas.size();
    }

    private boolean estaRegistrado(Horario horario) {
        for (Horario horarioReservado : listarHorarios()) {
            if (horarioReservado.equals(horario)) {
                return true;
            }
        }
        return false;
    }

    public int contarHorarios() {
        return listarHorarios().size();
    }
    
    private List<Horario> listarHorarios () {
        List<Horario> horarios = new ArrayList<>();
        for(List lista : reservas.values()) {
            horarios.addAll(lista);
        }
        return horarios;
    }

}
