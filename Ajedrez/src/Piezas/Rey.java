package Piezas;

import Piezas.Enums.Direction;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;

import javax.swing.*;
import java.util.HashMap;

public class Rey extends Pieza{

    public Rey(Tipo_Color Color) {
        super(Color);
        setTipoPieza(Tipo_Pieza.REY);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equals(Tipo_Color.BLANCO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Rey()));
            } else if (getColor().equals(Tipo_Color.NEGRO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Rey()));
            }
        }

        return getSpr_pieza();
    }

    @Override
    public HashMap<Direction, Integer> Mov_Pieza() {
        HashMap<Direction, Integer> DireccYmovimiento = new HashMap<>();

        DireccYmovimiento.put(Direction.TOP, 1);
        DireccYmovimiento.put(Direction.BOTTOM, 1);
        DireccYmovimiento.put(Direction.LEFT, 1);
        DireccYmovimiento.put(Direction.RIGHT, 1);

        DireccYmovimiento.put(Direction.TOPLEFT, 1);
        DireccYmovimiento.put(Direction.TOPRIGHT, 1);
        DireccYmovimiento.put(Direction.BOTTOMLEFT, 1);
        DireccYmovimiento.put(Direction.BOTTOMRIGHT, 1);

        return DireccYmovimiento;
    }
}
