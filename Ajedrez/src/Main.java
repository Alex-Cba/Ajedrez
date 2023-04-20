import Piezas.Peon;
import Sprites.All_Sprites;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    private static Tablero _tablero = new Tablero();
    //private static All_Sprites _All_Sprites = new All_Sprites();
    public static void main(String[] args) {
        //Actualizar interfaz grafica
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                _tablero.setVisible(true);
            }
        });


        //Tablero

        //Matriz Tablero

        //Movimiento pieza
        Peon _peon = new Peon("Blanco");
        _tablero.Agregar_Sprite(3,1, _peon);
    }
}