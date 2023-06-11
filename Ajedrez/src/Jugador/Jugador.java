package Jugador;

import Piezas.Enums.Tipo_Color;

public class Jugador {

    private String nombre;
    private Tipo_Color jugadorColor;
    private Integer puntacion;

    public String getNombre() {
        return nombre;
    }

    public Tipo_Color getJugadorColor() {
        return jugadorColor;
    }

    public Integer getPuntacion() {
        return puntacion;
    }

    public void setJugadorColor(Tipo_Color jugadorColor) {
        this.jugadorColor = jugadorColor;
    }

    public void setPuntacion(Integer puntacion) {
        this.puntacion = puntacion;
    }

    public Jugador(){
        this.nombre = "";
        this.jugadorColor = null;
        this.puntacion = 0;
    }

    public Jugador(String nombre, Tipo_Color jugadorColor, Integer puntacion) {
        this.nombre = nombre;
        this.jugadorColor = jugadorColor;
        this.puntacion = puntacion;
    }
}
