package calendariows;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roberto_perez
 */
public class HorarioTest {
    
    private final int[] horariosDeInicioValidos = {9, 10, 11, 14, 15, 16};
    private final int[] horariosDeFinValidos = {10, 11, 12, 15, 16, 17};
    private final int DIA = 14;

    @Test
    public void testVerificarHorarioEnRango() {
        for (int horas : horariosDeInicioValidos) {
            Horario horario = new Horario(DIA, horas, horas+1);
            assertTrue("Horario invalido", 
                    horario.estaEnRango(horariosDeInicioValidos,
                            horariosDeFinValidos));
        }
    }
    
    //TODO: Se deben agregar algunos casos adicionales de horarios fuera de rango
    @Test
    public void testVerificarHorarioFueraDeRango() {
        Horario horario8a9 = new Horario(DIA, 8, 9);
        assertFalse("El horario es valido", 
                horario8a9.estaEnRango(horariosDeInicioValidos,
                        horariosDeFinValidos));
    }
    
    
    // El siguiente test prueba que los horarios reservados no tengan una
    // duracion mayor a 2 horas
    @Test
    public void testVerificarDuracionValida() {
        for (int horas : horariosDeInicioValidos) {
            Horario horarioDe1Hora = new Horario(DIA, horas, horas+1);
            Horario horarioDe2Horas = new Horario(DIA, horas, horas+2);

            assertTrue("Duracion de mas de dos horas", 
                    horarioDe1Hora.tieneDuracionValida());
            
            assertTrue("Duracion de mas de dos horas",
                    horarioDe2Horas.tieneDuracionValida());
        }
    }
    
    @Test
    public void testVerificarDuracionInvalida() {
        int horaInicio = 9;
        int horaFin = horaInicio + 3;
        //Horario de 3 horas
        Horario horarioDeDuracionInvalida = new Horario(DIA, horaInicio, horaFin);
        assertFalse("Es un horario valido", 
                    horarioDeDuracionInvalida.tieneDuracionValida());
        //Horario de duracion nula (0)
        horarioDeDuracionInvalida = new Horario(DIA, horaInicio, horaInicio);
        assertFalse("Es un horario valido", 
                    horarioDeDuracionInvalida.tieneDuracionValida());
        
        //Horario de duracion negativa
        horarioDeDuracionInvalida = new Horario(DIA, horaInicio, horaInicio-10);
        assertFalse("Es un horario valido", 
                    horarioDeDuracionInvalida.tieneDuracionValida());
    }
    
}
