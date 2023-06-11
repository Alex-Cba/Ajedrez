package Piezas;

import Piezas.Enums.Direction;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;

import javax.swing.*;
import java.util.HashMap;

import static Tablero.Tablero2.orden_Piezas;

public class Torre extends Pieza
{
    public Torre(Tipo_Color Color) {
        super(Color);
        setTipoPieza(Tipo_Pieza.TORRE);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equals(Tipo_Color.BLANCO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Torre()));
            } else if (getColor().equals(Tipo_Color.NEGRO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Torre()));
            }
        }

        return getSpr_pieza();
    }
    @Override
    public HashMap<Direction, Integer> Mov_Pieza() {
        HashMap<Direction, Integer> DireccYmovimiento = new HashMap<>();

        DireccYmovimiento.put(Direction.TOP, 8);
        DireccYmovimiento.put(Direction.BOTTOM, 8);
        DireccYmovimiento.put(Direction.LEFT, 8);
        DireccYmovimiento.put(Direction.RIGHT, 8);

        return DireccYmovimiento;
    }
}
