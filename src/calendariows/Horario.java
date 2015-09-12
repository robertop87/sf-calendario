/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendariows;

/**
 *
 * @author sofunA
 */
class Horario {
    
    private int dia;
    private int hrInicio;
    private int hrFin;

    Horario(int dia, int hrInicio, int hrFin) {
       
    }
    
    @Override
    public boolean equals(Object obj){
        Horario horario = (Horario) obj;
        return  this.dia == horario.dia &&
                this.hrInicio == horario.hrInicio &&
                this.hrFin == horario.hrFin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.dia;
        hash = 97 * hash + this.hrInicio;
        hash = 97 * hash + this.hrFin;
        return hash;
    }

}
