package Piezas;

import javax.swing.*;

public class Caballo extends Peon {
    public Caballo(String Color) {
        super(Color);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equalsIgnoreCase("Blanco")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Caballo()));
            } else if (getColor().equalsIgnoreCase("Negro")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Caballo()));
            }
        }

        return getSpr_pieza();
    }
}
