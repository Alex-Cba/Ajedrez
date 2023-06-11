package Piezas;

import Piezas.Enums.Direction;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;

import javax.swing.*;
import java.util.HashMap;

public class Reina extends Pieza{
    public Reina(Tipo_Color Color) {
        super(Color);
        setTipoPieza(Tipo_Pieza.REINA);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equals(Tipo_Color.BLANCO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Reina()));
            } else if (getColor().equals(Tipo_Color.NEGRO)) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Reina()));
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

        DireccYmovimiento.put(Direction.TOPLEFT, 8);
        DireccYmovimiento.put(Direction.TOPRIGHT, 8);
        DireccYmovimiento.put(Direction.BOTTOMLEFT, 8);
        DireccYmovimiento.put(Direction.BOTTOMRIGHT, 8);

        return DireccYmovimiento;
    }
}
