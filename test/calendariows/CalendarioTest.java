package calendariows;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase test para el Calendario
 * @author sofunA
 */
public class CalendarioTest {
    
    @Test
    public void testAsignarHorario() {
        Calendario calendario = new Calendario();
        Materia materiaCFP289 = new Materia("CFP289", "nombre 1", 11);
        int dia = 14;
        int hrInicio = 9;
        int hrFin = 10;
        Horario horario140910 = new Horario(dia, hrInicio, hrFin);
        boolean estaAsignado = calendario.asignarHorario(horario140910, materiaCFP289);
        assertEquals(1, calendario.contarMaterias());
        assertTrue("El horario esta ocupado", estaAsignado);
    }
    
    @Test
    public void testAsignarHorarioOcupado() {
        Calendario calendario = new Calendario();
        Materia materiaCFP289 = new Materia("CFP289", "nombre 1", 11);
        int dia = 14;
        int hrInicio = 9;
        int hrFin = 10;
        Horario horario140910 = new Horario(dia, hrInicio, hrFin);
        calendario.asignarHorario(horario140910, materiaCFP289);
        boolean estaAsignado = calendario.asignarHorario(horario140910, materiaCFP289);
        assertEquals(1, calendario.contarMaterias());
        assertFalse("Asignacion erronea", estaAsignado);
    }

    @Test
    public void testAsignarHorarioNoDisponible() {
        Calendario calendario = new Calendario();
        Materia materiaCFP289 = new Materia("CFP289", "nombre 1", 11);
        int dia = 14;
        int hrInicio = 8;
        int hrFin = 9;
        Horario horario140910 = new Horario(dia, hrInicio, hrFin);
        boolean estaAsignado = calendario.asignarHorario(horario140910, materiaCFP289);
        assertFalse("se asigno un horario invalido", estaAsignado);
    } 
}
