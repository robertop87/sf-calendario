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
        int hrInicio = 9;
        int hrFin = 10;
        Horario horario140910 = new Horario(Valores.DIA, hrInicio, hrFin);
        boolean estaAsignado = calendario.asignarHorario(horario140910, Valores.CFP289);
        assertEquals(1, calendario.contarMaterias());
        assertTrue("El horario esta ocupado", estaAsignado);
    }
    
    @Test
    public void testAsignarHorarioOcupado() {
        Calendario calendario = new Calendario();
        int hrInicio = 9;
        int hrFin = 10;
        Horario horario140910 = new Horario(Valores.DIA, hrInicio, hrFin);
        calendario.asignarHorario(horario140910, Valores.CFP289);
        boolean estaAsignado = calendario.asignarHorario(horario140910, Valores.CFP289);
        assertEquals(1, calendario.contarMaterias());
        assertFalse("Asignacion erronea", estaAsignado);
    }

    @Test
    public void testAsignarHorarioNoDisponible() {
        Calendario calendario = new Calendario();
        int hrInicio = 8;
        int hrFin = 9;
        Horario horario140910 = new Horario(Valores.DIA, hrInicio, hrFin);
        boolean estaAsignado = calendario.asignarHorario(horario140910, Valores.CFP289);
        assertFalse("se asigno un horario invalido", estaAsignado);
    }

    @Test
    public void testAsignarHorariosValidosYcontarHorario() {
        Calendario calendario = new Calendario();
        //asignamos dos horarios
        calendario.asignarHorario(new Horario(Valores.DIA, 9, 10), Valores.CFP289);
        calendario.asignarHorario(new Horario(Valores.DIA, 14, 15), Valores.CFP289);
        //esperamos que el conteo sea de dos horarios
        int cantidadDeHorariosEsperados = 2;
        assertEquals(cantidadDeHorariosEsperados,
                    calendario.contarHorarios());
    }
    
    @Test
    public void testAsignarHorariosYcontarHorario() {
        Calendario calendario = new Calendario();
        //asignamos un horario invalido
        calendario.asignarHorario(new Horario(Valores.DIA, 7, 8), Valores.CFP289);
        //asignamos un horario valido
        calendario.asignarHorario(new Horario(Valores.DIA, 14, 15), Valores.CFP289);
        //esperamos que el conteo sea de un solo horario
        int cantidadDeHorariosEsperados = 1;
        assertEquals(cantidadDeHorariosEsperados,
                    calendario.contarHorarios());
    }
    
    @Test
    public void testAgregarUnaMateriaConUnSoloHorario() {
        //Las materias se deben agregar al momento de poner un horario
        Calendario calendario = new Calendario();
        calendario.asignarHorario(new Horario(Valores.DIA, 9, 10), Valores.CFP289);
        //Esperamos tener solo una materia programada CFP289
        int cantidadDeMateriasEsperadas = 1;
        assertEquals(cantidadDeMateriasEsperadas, calendario.contarMaterias());
    }
    
    @Test
    public void testAgregarUnaMateriaConDosHorarios() {
        //Las materias se deben agregar al momento de poner un horario
        Calendario calendario = new Calendario();
        //Sin importar cuantos horarios asignados tiene una materia, el conteo
        //deberia ser solo por materia
        calendario.asignarHorario(new Horario(Valores.DIA, 9, 10), Valores.CFP289);
        calendario.asignarHorario(new Horario(Valores.DIA, 14, 15), Valores.CFP289);
        
        //Esperamos tener solo una materia programada CFP289
        int cantidadDeMateriasEsperadas = 1;
        assertEquals(cantidadDeMateriasEsperadas, calendario.contarMaterias());
    }
    
    @Test
    public void testAgregarDosMateriaConUnHorario() {
        //Las materias se deben agregar al momento de poner un horario
        Calendario calendario = new Calendario();
        //Sin importar cuantos horarios asignados tiene una materia, el conteo
        //deberia ser solo por materia
        calendario.asignarHorario(new Horario(Valores.DIA, 9, 10), Valores.CFP289);
        calendario.asignarHorario(new Horario(Valores.DIA, 14, 15), Valores.CFP290);
        
        //Esperamos tener solo una materia programada CFP289
        int cantidadDeMateriasEsperadas = 2;
        assertEquals(cantidadDeMateriasEsperadas, calendario.contarMaterias());
    }
    
    @Test
    public void testAgregarDosMateriaConDosHorarios() {
        //Las materias se deben agregar al momento de poner un horario
        Calendario calendario = new Calendario();
        //Sin importar cuantos horarios asignados tiene una materia, el conteo
        //deberia ser solo por materia
        calendario.asignarHorario(new Horario(Valores.DIA, 9, 10), Valores.CFP289);
        calendario.asignarHorario(new Horario(Valores.DIA, 10, 11), Valores.CFP289);
        calendario.asignarHorario(new Horario(Valores.DIA, 14, 15), Valores.CFP290);
        calendario.asignarHorario(new Horario(Valores.DIA, 15, 16), Valores.CFP290);
        
        //Esperamos tener solo una materia programada CFP289
        int cantidadDeMateriasEsperadas = 2;
        assertEquals(cantidadDeMateriasEsperadas, calendario.contarMaterias());
    }
}
