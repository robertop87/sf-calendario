package calendariows;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author sofunA
 */
public class Horario {
    
    private int dia;
    private int horaInicio;
    private int horaFin;
    
    private final int MAXIMA_DURACION = 2; //tiempo en horas

    Horario(int dia, int horaInicio, int horaFin) {
       this.dia = dia;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
    }
    
    @Override
    public boolean equals(Object obj){
        Horario horario = (Horario) obj;
        return  this.dia == horario.dia &&
                this.horaInicio == horario.horaInicio &&
                this.horaFin == horario.horaFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.dia;
        hash = 97 * hash + this.horaInicio;
        hash = 97 * hash + this.horaFin;
        return hash;
    }

    public boolean estaEnRango(int[] horariosDeInicioDisponibles,
            int[] horariosDeFinDisponibles) {
        return ArrayUtils.contains(horariosDeInicioDisponibles, horaInicio) &&
                ArrayUtils.contains(horariosDeFinDisponibles, horaFin);
    }

    public boolean tieneDuracionValida() {
        int duracion = horaFin - horaInicio;
        return ( duracion <= MAXIMA_DURACION && duracion > 0 );
    }

}
