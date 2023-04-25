package Piezas;

import javax.swing.*;

public class Alfil extends Peon{
    public Alfil(String Color) {
        super(Color);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equalsIgnoreCase("Blanco")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Alfil()));
            } else if (getColor().equalsIgnoreCase("Negro")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Alfil()));
            }
        }

        return getSpr_pieza();
    }
}
