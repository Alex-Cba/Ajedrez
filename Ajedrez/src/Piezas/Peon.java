package Piezas;

import Piezas.Enums.Direction;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;

import javax.swing.*;

import java.util.HashMap;
import java.util.Map;

import static Tablero.Tablero2.orden_Piezas;

public class Peon extends Pieza
{

    //Constructor
    public Peon(Tipo_Color Color)
    {
        color = Color;
        setTipoPieza(Tipo_Pieza.PEON);
    }

    @Override
    public ImageIcon Check_Icon() {
        if(getSpr_pieza() == null) {
            if (getColor().equals(Tipo_Color.BLANCO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Peon()));
            } else if (getColor().equals(Tipo_Color.NEGRO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Peon()));
            }
        }

        return getSpr_pieza();
    }
    //Movimiento -Pruebas Alex
    public HashMap<Direction, Integer> Mov_Pieza(){
        HashMap<Direction, Integer> DireccYmovimiento = new HashMap<>();

        if(orden_Piezas.equalsIgnoreCase("Abajo_Blancas")){
            if(color.equals(Tipo_Color.BLANCO))
            {
                DireccYmovimiento.put(Direction.TOP, 1);
            }
            else if (color.equals(Tipo_Color.NEGRO))
            {
                DireccYmovimiento.put(Direction.BOTTOM, 1);
            }
        }
        else if(orden_Piezas.equalsIgnoreCase("Arriba_Blancas"))
        {
            if(color.equals(Tipo_Color.NEGRO))
            {
                DireccYmovimiento.put(Direction.TOP, 1);
            }
            else if (color.equals(Tipo_Color.BLANCO))
            {
                DireccYmovimiento.put(Direction.BOTTOM, 1);
            }
        }

        return DireccYmovimiento;
    }
}
